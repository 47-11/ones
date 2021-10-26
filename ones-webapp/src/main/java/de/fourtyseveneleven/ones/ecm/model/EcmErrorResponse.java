package de.fourtyseveneleven.ones.ecm.model;

public class EcmErrorResponse {

    private String uuid;
    private String state;
    private int reasonCode;
    private String justification;
    private String registerObjectUuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getRegisterObjectUuid() {
        return registerObjectUuid;
    }

    public void setRegisterObjectUuid(String registerObjectUuid) {
        this.registerObjectUuid = registerObjectUuid;
    }
}
