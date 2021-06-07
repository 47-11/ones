package de.fourtyseveneleven.ones.settings;

import de.fourtyseveneleven.ones.settings.ecm.EcmSettings;
import de.fourtyseveneleven.ones.settings.message.MessageSettings;
import de.fourtyseveneleven.ones.settings.security.SecuritySettings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "ones")
public class OnesSettings {

    @NestedConfigurationProperty
    private final SecuritySettings security = new SecuritySettings();

    @NestedConfigurationProperty
    private final MessageSettings message = new MessageSettings();

    @NestedConfigurationProperty
    private final EcmSettings ecm = new EcmSettings();

    public SecuritySettings getSecurity() {
        return security;
    }

    public MessageSettings getMessage() {
        return message;
    }

    public EcmSettings getEcm() {
        return ecm;
    }
}
