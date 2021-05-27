package de.fourtyseveneleven.ones.event.model.dto;

import java.math.BigDecimal;

public class AccommodationDto {

    private String type;
    private BigDecimal fee;
    private AccommodationFeeUnit feeUnit;
    private BigDecimal pledgeFee;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public AccommodationFeeUnit getFeeUnit() {
        return feeUnit;
    }

    public void setFeeUnit(AccommodationFeeUnit feeUnit) {
        this.feeUnit = feeUnit;
    }

    public BigDecimal getPledgeFee() {
        return pledgeFee;
    }

    public void setPledgeFee(BigDecimal pledgeFee) {
        this.pledgeFee = pledgeFee;
    }
}
