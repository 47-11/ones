package de.fourtyseveneleven.ones.ecm.configuration;

import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import de.fourtyseveneleven.ones.settings.ecm.EcmSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EcmApiConfiguration {

    private final String apiUser;
    private final String apiPassword;

    public EcmApiConfiguration(OnesSettings onesSettings) {

        final EcmSettings ecmSettings = onesSettings.getEcm();
        apiUser = ecmSettings.getApiUser();
        apiPassword = ecmSettings.getApiPassword();
    }

    @Bean
    public MasterdataContactControllerApi masterdataContactControllerApi() {

        // TODO: Specify authentication information here as soon as ECM api is changed
        return new MasterdataContactControllerApi();
    }

}
