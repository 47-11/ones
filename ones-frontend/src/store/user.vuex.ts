import { EmailPasswordDto, SetPersonalDataRequest, UserDto as User, UserDto } from "@/openapi/generated";
import { getApi } from "@/store/api";
import { action, createModule, mutation } from "vuex-class-component";

const VuexModule = createModule({
    namespaced: "user",
    strict: false
});

export interface LoginPayload {
    email: string;
    password: string;
    staySignedIn?: boolean;
}

export interface VerificationPayload {
    code: string;
}

export interface ForgotPassPayload {
    email: string;
}

export interface NewPassByCodePayload {
    code: string;
    password: string;
}

export class UserStore extends VuexModule {
    private static readonly TOKEN_STORAGE_NAME = "jwtToken";
    public token?: string = this.getLastToken();
    private _current: UserDto | null = null;

    private getLastToken(): string | undefined {
        return sessionStorage.getItem(UserStore.TOKEN_STORAGE_NAME) ||
            localStorage.getItem(UserStore.TOKEN_STORAGE_NAME) ||
            undefined;
    }

    get authenticated(): boolean {
        return this.token !== undefined;
    }

    get current(): User | null {
        // this will not have the current user data immediately
        if (this.authenticated && this._current === null) {
            this.fetchCurrent();
        }
        return this._current;
    }

    @action
    async login(payload: LoginPayload): Promise<void> {
        const loginResult = await getApi().login.login({
            emailAddress: payload.email,
            password: payload.password
        });
        const jwsToken = loginResult.data;
        this.token = jwsToken;
        if (payload.staySignedIn) {
            localStorage.setItem(UserStore.TOKEN_STORAGE_NAME, jwsToken);
            sessionStorage.removeItem(UserStore.TOKEN_STORAGE_NAME);
        } else {
            localStorage.removeItem(UserStore.TOKEN_STORAGE_NAME);
            sessionStorage.setItem(UserStore.TOKEN_STORAGE_NAME, jwsToken);
        }

        try {
            await this.fetchCurrent();
        } catch (error) {
            this.logout();
            throw error;
        }
    }

    @action
    async register(payload: EmailPasswordDto): Promise<void> {
        await getApi().registration.createRegistration(payload);
    }

    @action
    async verify(payload: VerificationPayload): Promise<void> {
        await getApi().registration.confirmRegistration(payload.code);
    }

    @mutation
    logout(): void {
        this.token = undefined;
        localStorage.removeItem(UserStore.TOKEN_STORAGE_NAME);
        sessionStorage.removeItem(UserStore.TOKEN_STORAGE_NAME);
    }

    @action
    async forgotPassword(payload: ForgotPassPayload): Promise<void> {
        await getApi().forgotPassword.forgotPassword({
            emailAddress: payload.email
        });
    }

    @action
    async setNewPasswordByCode(payload: NewPassByCodePayload): Promise<void> {
        await getApi().forgotPassword.forgotPasswordSetNewPassword({
            code: payload.code,
            newPassword: payload.password
        });
    }

    @action
    async fetchCurrent(): Promise<void> {
        const response = await getApi().user.getCurrentUser();

        this._current = response.data;
    }

    @action
    async setPersonalData(payload: SetPersonalDataRequest): Promise<void> {
        await getApi().user.setPersonalData(payload);
        await this.fetchCurrent();
    }

    @action
    async updatePersonalData(payload: UserDto): Promise<void> {
        await getApi().user.updatePersonalData(payload);
        await this.fetchCurrent();
    }

    @action
    async deleteAccount(): Promise<void> {
        await getApi().user.deleteSelf();
    }
}
