package de.fourtyseveneleven.ones.event.model.dto;

public  class PaymentInformation {

    private String remarks;

    private String bankTransferAccountHolder;
    private String bankTransferIban;
    private String bankTransferBic;

    private String paypalInformation;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBankTransferAccountHolder() {
        return bankTransferAccountHolder;
    }

    public void setBankTransferAccountHolder(String bankTransferAccountHolder) {
        this.bankTransferAccountHolder = bankTransferAccountHolder;
    }

    public String getBankTransferIban() {
        return bankTransferIban;
    }

    public void setBankTransferIban(String bankTransferIban) {
        this.bankTransferIban = bankTransferIban;
    }

    public String getBankTransferBic() {
        return bankTransferBic;
    }

    public void setBankTransferBic(String bankTransferBic) {
        this.bankTransferBic = bankTransferBic;
    }

    public String getPaypalInformation() {
        return paypalInformation;
    }

    public void setPaypalInformation(String paypalInformation) {
        this.paypalInformation = paypalInformation;
    }
}
