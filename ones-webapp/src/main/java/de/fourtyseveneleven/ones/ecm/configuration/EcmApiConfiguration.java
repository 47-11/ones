package de.fourtyseveneleven.ones.ecm.configuration;

import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataPropertyControllerApi;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import de.fourtyseveneleven.ones.settings.ecm.EcmSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Configuration
public class EcmApiConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(EcmApiConfiguration.class);

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

        final String apiBaseUrl = onesSettings.getEcm().getApiBaseUrl();
        if (isBlank(apiBaseUrl)) {
            LOG.error("API base URL is blank.");
        } else {
            final URI apiBaseUri = URI.create(apiBaseUrl);

            apiClient.setScheme(apiBaseUri.getScheme());
            apiClient.setHost(apiBaseUri.getHost());
            apiClient.setPort(apiBaseUri.getPort());
            apiClient.setBasePath(apiBaseUri.getPath());
        }

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
