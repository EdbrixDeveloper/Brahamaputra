package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EBBillUploadReceipt {

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
    @SerializedName("EbReceiptScanCopyImageName")
    @Expose
    private String ebReceiptScanCopyImageName;

    @SerializedName("EbPaymentReceiptNumber")
    @Expose
    private String ebPaymentReceiptNumber;

    @SerializedName("EbPaymentDate")
    @Expose
    private String ebPaymentDate;

    @SerializedName("EbPaymentAmount")
    @Expose
    private String ebPaymentAmount;

    @SerializedName("EbDdChequeTransactionDetails")
    @Expose
    private String ebDdChequeTransactionDetails;


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

    public String getEbReceiptScanCopyImageName() {
        return ebReceiptScanCopyImageName;
    }

    public void setEbReceiptScanCopyImageName(String ebReceiptScanCopyImageName) {
        this.ebReceiptScanCopyImageName = ebReceiptScanCopyImageName;
    }

    public String getEbPaymentReceiptNumber() {
        return ebPaymentReceiptNumber;
    }

    public void setEbPaymentReceiptNumber(String ebPaymentReceiptNumber) {
        this.ebPaymentReceiptNumber = ebPaymentReceiptNumber;
    }

    public String getEbPaymentDate() {
        return ebPaymentDate;
    }

    public void setEbPaymentDate(String ebPaymentDate) {
        this.ebPaymentDate = ebPaymentDate;
    }

    public String getEbPaymentAmount() {
        return ebPaymentAmount;
    }

    public void setEbPaymentAmount(String ebPaymentAmount) {
        this.ebPaymentAmount = ebPaymentAmount;
    }

    public String getEbDdChequeTransactionDetails() {
        return ebDdChequeTransactionDetails;
    }

    public void setEbDdChequeTransactionDetails(String ebDdChequeTransactionDetails) {
        this.ebDdChequeTransactionDetails = ebDdChequeTransactionDetails;
    }

    public EBBillUploadReceipt(String userId, String accessToken, String ebpaymentrequestId, String ebPaymentRemark, String ebPaymentReceiptNumber, String ebPaymentDate, String ebPaymentAmount, String ebReceiptScanCopyImageName) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.ebpaymentrequestId = ebpaymentrequestId;
        this.ebPaymentRemark = ebPaymentRemark;
        this.ebPaymentReceiptNumber = ebPaymentReceiptNumber;
        this.ebPaymentDate = ebPaymentDate;
        this.ebPaymentAmount = ebPaymentAmount;
        this.ebReceiptScanCopyImageName = ebReceiptScanCopyImageName;
        //this.ebDdChequeTransactionDetails = ebDdChequeTransactionDetails;, String ebDdChequeTransactionDetails
    }
}
