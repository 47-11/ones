package de.fourtyseveneleven.ones.ecm.configuration;

import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import de.fourtyseveneleven.ones.settings.ecm.EcmSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public ApiClient apiClient(OnesSettings onesSettings) {

        final EcmSettings ecmSettings = onesSettings.getEcm();
        // TODO: Specify authentication information here as soon as ECM api is changed
        return new ApiClient();
    }
}
