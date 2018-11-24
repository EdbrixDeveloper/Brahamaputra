package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class EBBillUploadReceipt  {

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

    public EBBillUploadReceipt(String userId, String accessToken, String ebpaymentrequestId, String ebPaymentRemark, String ebReceiptScanCopyImageName) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.ebpaymentrequestId = ebpaymentrequestId;
        this.ebPaymentRemark = ebPaymentRemark;
        this.ebReceiptScanCopyImageName = ebReceiptScanCopyImageName;
    }
}
