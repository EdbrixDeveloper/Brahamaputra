package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EbPaymentDetails {

    @SerializedName("UserId")
    @Expose
    private String userId;

    @SerializedName("AccessToken")
    @Expose
    private String accessToken;

    @SerializedName("EbpaymentrequestId")
    @Expose
    private String ebpaymentrequestId;

    @SerializedName("EbPaymentTicketNumber")
    @Expose
    private String ebPaymentTicketNumber;

    @SerializedName("ModeOfPayment")
    @Expose
    private String ModeOfPayment;

    @SerializedName("EbPaymentDdChequeScanCopyImageName")
    @Expose
    private String ebPaymentDdChequeScanCopyImageName;


    @SerializedName("EbPaymentDdChequeNumber")
    @Expose
    private String ebPaymentDdChequeNumber;


    @SerializedName("EbPaymentDdChequeDate")
    @Expose
    private String ebPaymentDdChequetDate;

    @SerializedName("EbPaymentDdChequeAmount")
    @Expose
    private String ebPaymentDdChequeAmount;

    @SerializedName("EbPaymentDdChequeTransactionDetails")
    @Expose
    private String ebPaymentDdChequeTransactionDetails;

    @SerializedName("EbPaymentDdChequeScanCopyImageUrl")
    @Expose
    private String ebPaymentDdChequeScanCopyImageUrl;

    @SerializedName("EbPaymentRemark")
    @Expose
    private String ebPaymentRemark;

    @SerializedName("EbPaymentDDUploadRemark")
    @Expose
    private String ebPaymentDDUploadRemark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getEbpaymentrequestId() {
        return ebpaymentrequestId;
    }

    public void setEbpaymentrequestId(String ebpaymentrequestId) {
        this.ebpaymentrequestId = ebpaymentrequestId;
    }

    public String getEbPaymentTicketNumber() {
        return ebPaymentTicketNumber;
    }

    public void setEbPaymentTicketNumber(String ebPaymentTicketNumber) {
        this.ebPaymentTicketNumber = ebPaymentTicketNumber;
    }

    public String getModeOfPayment() {
        return ModeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        ModeOfPayment = modeOfPayment;
    }

    public String getEbPaymentRemark() {
        return ebPaymentRemark;
    }

    public void setEbPaymentRemark(String ebPaymentRemark) {
        this.ebPaymentRemark = ebPaymentRemark;
    }

    public String getEbPaymentDdChequeScanCopyImageName() {
        return ebPaymentDdChequeScanCopyImageName;
    }

    public void setEbPaymentDdChequeScanCopyImageName(String ebPaymentDdChequeScanCopyImageName) {
        this.ebPaymentDdChequeScanCopyImageName = ebPaymentDdChequeScanCopyImageName;
    }

    public String getEbPaymentDdChequeNumber() {
        return ebPaymentDdChequeNumber;
    }

    public void setEbPaymentDdChequeNumber(String ebPaymentDdChequeNumber) {
        this.ebPaymentDdChequeNumber = ebPaymentDdChequeNumber;
    }

    public String getEbPaymentDdChequetDate() {
        return ebPaymentDdChequetDate;
    }

    public void setEbPaymentDdChequetDate(String ebPaymentDdChequetDate) {
        this.ebPaymentDdChequetDate = ebPaymentDdChequetDate;
    }

    public String getEbPaymentDdChequeAmount() {
        return ebPaymentDdChequeAmount;
    }

    public void setEbPaymentDdChequeAmount(String ebPaymentDdChequeAmount) {
        this.ebPaymentDdChequeAmount = ebPaymentDdChequeAmount;
    }

    public String getEbPaymentDdChequeTransactionDetails() {
        return ebPaymentDdChequeTransactionDetails;
    }

    public void setEbPaymentDdChequeTransactionDetails(String ebPaymentDdChequeTransactionDetails) {
        this.ebPaymentDdChequeTransactionDetails = ebPaymentDdChequeTransactionDetails;
    }

    public String getEbPaymentDdChequeScanCopyImageUrl() {
        return ebPaymentDdChequeScanCopyImageUrl;
    }

    public void setEbPaymentDdChequeScanCopyImageUrl(String ebPaymentDdChequeScanCopyImageUrl) {
        this.ebPaymentDdChequeScanCopyImageUrl = ebPaymentDdChequeScanCopyImageUrl;
    }

    public String getEbPaymentDDUploadRemark() {
        return ebPaymentDDUploadRemark;
    }

    public void setEbPaymentDDUploadRemark(String ebPaymentDDUploadRemark) {
        this.ebPaymentDDUploadRemark = ebPaymentDDUploadRemark;
    }

    public EbPaymentDetails(String userId, String accessToken, String ebpaymentrequestId, String ModeOfPayment, String ebPaymentDdChequeNumber, String ebPaymentDdChequetDate, String ebPaymentDdChequeAmount, String ebPaymentDdChequeTransactionDetails, String ebPaymentDdChequeScanCopyImageName, String ebPaymentRemark, String ebPaymentDDUploadRemark) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.ebpaymentrequestId = ebpaymentrequestId;
        this.ModeOfPayment = ModeOfPayment;

        this.ebPaymentDdChequeNumber = ebPaymentDdChequeNumber;
        this.ebPaymentDdChequetDate = ebPaymentDdChequetDate;
        this.ebPaymentDdChequeAmount = ebPaymentDdChequeAmount;
        this.ebPaymentDdChequeTransactionDetails = ebPaymentDdChequeTransactionDetails;
        this.ebPaymentDdChequeScanCopyImageName = ebPaymentDdChequeScanCopyImageName;
        this.ebPaymentRemark = ebPaymentRemark;
        this.ebPaymentDDUploadRemark = ebPaymentDDUploadRemark;

    }
}
