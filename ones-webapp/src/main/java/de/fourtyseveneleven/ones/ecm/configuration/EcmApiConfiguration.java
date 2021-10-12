package de.fourtyseveneleven.ones.ecm.configuration;

import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataPropertyControllerApi;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import de.fourtyseveneleven.ones.settings.ecm.EcmSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
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
    public MasterdataPropertyControllerApi masterdataPropertyControllerApi(ApiClient apiClient) {

        return new MasterdataPropertyControllerApi(apiClient);
    }

    @Bean
    public ApiClient apiClient(@Qualifier("ecmApiHttpClientBuilder") HttpClient.Builder httpClientBuilder, OnesSettings onesSettings) {

        final ApiClient apiClient = de.fourtyseveneleven.ones.ecm.generated.Configuration.getDefaultApiClient();
        apiClient.setHttpClientBuilder(httpClientBuilder);

        final URI apiBaseUri = onesSettings.getEcm().getParsedApiBaseUri().orElseThrow(() -> new IllegalStateException("ECM API base url is not configured. Please set a value for the property ecm.api-base-url"));
        apiClient.setScheme(apiBaseUri.getScheme());
        apiClient.setHost(apiBaseUri.getHost());
        apiClient.setPort(apiBaseUri.getPort());
        apiClient.setBasePath(apiBaseUri.getPath());

        return apiClient;
    }

    @Bean
    @Qualifier("ecmApiHttpClientBuilder")
    public HttpClient.Builder httpClientBuilder(@Qualifier("ecmApiAuthenticator") Authenticator ecmApiAuthenticator) {

        return HttpClient.newBuilder()
                .authenticator(ecmApiAuthenticator);
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
