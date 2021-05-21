import { ForgotPasswordControllerApi, LoginControllerApi, RegistrationControllerApi } from "@/openapi/generated";
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

export interface RegistrationPayload {
    email: string;
    password: string;
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

    private getLastToken(): string | undefined {
        return sessionStorage.getItem(UserStore.TOKEN_STORAGE_NAME) ||
            localStorage.getItem(UserStore.TOKEN_STORAGE_NAME) ||
            undefined;
    }

    get authenticated(): boolean {
        return this.token !== undefined;
    }

    @action
    async login(payload: LoginPayload): Promise<void> {
        const loginResult = await new LoginControllerApi().login({
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
    }

    @action
    async register(payload: RegistrationPayload): Promise<void> {
        await new RegistrationControllerApi().createRegistration({
            emailAddress: payload.email,
            password: payload.password
        });
    }

    @action
    async verify(payload: VerificationPayload): Promise<void> {
        await new RegistrationControllerApi().confirmRegistration(payload.code);
    }

    @mutation
    logout(): void {
        this.token = undefined;
        localStorage.removeItem(UserStore.TOKEN_STORAGE_NAME);
        sessionStorage.removeItem(UserStore.TOKEN_STORAGE_NAME);
    }

    @action
    async forgotPassword(payload: ForgotPassPayload): Promise<void> {
        await new ForgotPasswordControllerApi().forgotPassword({
            emailAddress: payload.email
        });
    }

    @action
    async setNewPasswordByCode(payload: NewPassByCodePayload): Promise<void> {
        await new ForgotPasswordControllerApi().forgotPasswordSetNewPassword({
            code: payload.code,
            newPassword: payload.password
        });
    }
}
