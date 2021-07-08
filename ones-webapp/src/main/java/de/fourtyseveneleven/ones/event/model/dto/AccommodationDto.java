package de.fourtyseveneleven.ones.event.model.dto;

public class AccommodationDto {

    private String uuid;
    private String type;
    private FeeDto fee;
    private String feeUnit;
    private FeeDto pledgeFee;
    private String additionalInformation;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FeeDto getFee() {
        return fee;
    }

    public void setFee(FeeDto fee) {
        this.fee = fee;
    }

    public String getFeeUnit() {
        return feeUnit;
    }

    public void setFeeUnit(String feeUnit) {
        this.feeUnit = feeUnit;
    }

    public FeeDto getPledgeFee() {
        return pledgeFee;
    }

    public void setPledgeFee(FeeDto pledgeFee) {
        this.pledgeFee = pledgeFee;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
