package de.fourtyseveneleven.ones.settings.message;

public class EmailSettings {

    private String host;
    private Integer port;
    private String username;
    private String password;

    private String senderAddress;
    private String overrideRecipientAddress;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getOverrideRecipientAddress() {
        return overrideRecipientAddress;
    }

    public void setOverrideRecipientAddress(String overrideRecipientAddress) {
        this.overrideRecipientAddress = overrideRecipientAddress;
    }
}
