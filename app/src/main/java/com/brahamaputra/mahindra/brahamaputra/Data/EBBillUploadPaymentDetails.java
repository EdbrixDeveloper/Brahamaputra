package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EBBillUploadPaymentDetails {

    @SerializedName("Success")
    @Expose
    private Integer success;

    @SerializedName("Code")
    @Expose
    private String code;

    @SerializedName("Message")
    @Expose
    private String message;


    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /////////////////////////////

    @SerializedName("UserId")
    @Expose
    private String userId;

    @SerializedName("AccessToken")
    @Expose
    private String accessToken;

    @SerializedName("EbpaymentrequestId")
    @Expose
    private String ebpaymentrequestId;

    @SerializedName("EbPaymentRemark")
    @Expose
    private String ebPaymentRemark;


    @SerializedName("EbPaymentDdChequeScanCopyImageName")
    @Expose
    private String ebPaymentDdChequeScanCopyImageName;


    @SerializedName("EbPaymentDdChequeNumber")
    @Expose
    private String ebPaymentDdChequeNumber;


    @SerializedName("EbPaymentDdChequeDate")
    @Expose
    private String ebPaymenDdChequetDate;

    @SerializedName("EbPaymentDdChequeAmount")
    @Expose
    private String ebPaymentDdChequeAmount;

    @SerializedName("EbPaymentDdChequeTransactionDetails")
    @Expose
    private String ebPaymentDdChequeTransactionDetails;

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

    public String getEbPaymenDdChequetDate() {
        return ebPaymenDdChequetDate;
    }

    public void setEbPaymenDdChequetDate(String ebPaymenDdChequetDate) {
        this.ebPaymenDdChequetDate = ebPaymenDdChequetDate;
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

    public EBBillUploadPaymentDetails(String userId, String accessToken, String ebpaymentrequestId, String ebPaymentRemark, String ebPaymentDdChequeNumber, String ebPaymenDdChequetDate, String ebPaymentDdChequeAmount, String ebPaymentDdChequeTransactionDetails, String ebPaymentDdChequeScanCopyImageName) {
        this.userId = userId;
        this.accessToken = accessToken;

        this.ebpaymentrequestId = ebpaymentrequestId;
        this.ebPaymentRemark = ebPaymentRemark;

        this.ebPaymentDdChequeNumber = ebPaymentDdChequeNumber;
        this.ebPaymenDdChequetDate = ebPaymenDdChequetDate;
        this.ebPaymentDdChequeAmount = ebPaymentDdChequeAmount;
        this.ebPaymentDdChequeTransactionDetails = ebPaymentDdChequeTransactionDetails;
        this.ebPaymentDdChequeScanCopyImageName = ebPaymentDdChequeScanCopyImageName;

    }
}
