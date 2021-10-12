package de.fourtyseveneleven.ones.settings.ecm;

import java.beans.Transient;
import java.net.URI;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class EcmSettings {

    private String apiBaseUrl;
    private String apiUser;
    private String apiPassword;

    @Transient
    public Optional<URI> getParsedApiBaseUri() {

        final String rawApiBaseUrl = getApiBaseUrl();
        if (isBlank(getApiBaseUrl())) {
            return Optional.empty();
        } else {
            final URI parsedApiBaseUri = URI.create(rawApiBaseUrl);
            return Optional.of(parsedApiBaseUri);
        }
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }
}
