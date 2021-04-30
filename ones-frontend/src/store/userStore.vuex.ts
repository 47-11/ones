import { LoginControllerApi, RegistrationControllerApi } from '@/openapi/generated';
import { action, createModule, getter } from 'vuex-class-component';

const VuexModule = createModule({
    namespaced: 'user',
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

export class UserStore extends VuexModule {
    private token?: string;

    @getter
    isAuthenticated (): boolean {
        return this.token !== undefined;
    }

    @action
    async login (payload: LoginPayload): Promise<void> {
        const loginResult = await new LoginControllerApi().login({
            emailAddress: payload.email,
            password: payload.password
        });
        const jwsToken = loginResult.data;
        this.token = jwsToken;
    }

    @action
    async register (payload: RegistrationPayload): Promise<void> {
        await new RegistrationControllerApi().createRegistration({
            emailAddress: payload.email,
            password: payload.password
        });
    }

    @action
    async verify (payload: VerificationPayload): Promise<void> {
        await new RegistrationControllerApi().createRegistration1(payload.code);
    }
}
