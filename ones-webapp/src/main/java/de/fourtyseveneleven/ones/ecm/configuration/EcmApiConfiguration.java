package de.fourtyseveneleven.ones.ecm.configuration;

import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import de.fourtyseveneleven.ones.settings.ecm.EcmSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;

@Configuration
public class EcmApiConfiguration {

    @Bean
    public EventContestControllerApi eventContestControllerApi(ApiClient apiClient) {

        return new EventContestControllerApi(apiClient);
    }

    @Bean
    public MasterdataContactControllerApi masterdataContactControllerApi(ApiClient apiClient) {

        return new MasterdataContactControllerApi(apiClient);
    }

    @Bean
    public ApplicationAccountControllerApi applicationAccountControllerApi(ApiClient apiClient) {

        return new ApplicationAccountControllerApi(apiClient);
    }

    @Bean
    public ApiClient apiClient(@Qualifier("ecmApiAuthenticator") Authenticator ecmApiAuthenticator) {

        final HttpClient.Builder httpClientBuilder = HttpClient.newBuilder()
                .authenticator(ecmApiAuthenticator);

        final ApiClient apiClient = de.fourtyseveneleven.ones.ecm.generated.Configuration.getDefaultApiClient();
        apiClient.setHttpClientBuilder(httpClientBuilder);
        return apiClient;
    }

    @Bean
    @Qualifier("ecmApiAuthenticator")
    public Authenticator ecmApiAuthenticator(OnesSettings onesSettings) {

        final EcmSettings ecmSettings = onesSettings.getEcm();
        return new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ecmSettings.getApiUser(), ecmSettings.getApiPassword().toCharArray());
            }
        };
    }
}
