package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ElectricBillProcessData{

    @SerializedName("UserId")
    @Expose
    private String userId;
    @SerializedName("AccessToken")
    @Expose
    private String accessToken;
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("CircleId")
    @Expose
    private String circleId;
    @SerializedName("StateId")
    @Expose
    private String stateId;
    @SerializedName("SSAId")
    @Expose
    private String sSAId;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("EBServiceProvider")
    @Expose
    private String eBServiceProvider;
    @SerializedName("EBConsumerNumber")
    @Expose
    private String eBConsumerNumber;
    @SerializedName("ModeOfPayment")
    @Expose
    private String modeOfPayment;
    @SerializedName("TypeofElectricConnection")
    @Expose
    private String typeofElectricConnection;
    @SerializedName("Tariff")
    @Expose
    private String tariff;
    @SerializedName("UnitsConsumed")
    @Expose
    private String unitsConsumed;
    @SerializedName("BillingPeriodFrom")
    @Expose
    private String billingPeriodFrom;
    @SerializedName("BillingPeriodTo")
    @Expose
    private String billingPeriodTo;
    @SerializedName("ReceiptNumber")
    @Expose
    private String receiptNumber;
    @SerializedName("BillIssueDate")
    @Expose
    private String billIssueDate;
    @SerializedName("BillDueDate")
    @Expose
    private String billDueDate;
    @SerializedName("GrossAmount")
    @Expose
    private String grossAmount;
    @SerializedName("NetPayableOnOrBeforeDueDate")
    @Expose
    private String netPayableOnOrBeforeDueDate;
    @SerializedName("VendorSAPId")
    @Expose
    private String vendorSAPId;
    @SerializedName("EbBillScanCopyImageName")
    @Expose
    private String ebBillScanCopyImageName;

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getSSAId() {
        return sSAId;
    }

    public void setSSAId(String sSAId) {
        this.sSAId = sSAId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getEBServiceProvider() {
        return eBServiceProvider;
    }

    public void setEBServiceProvider(String eBServiceProvider) {
        this.eBServiceProvider = eBServiceProvider;
    }

    public String getEBConsumerNumber() {
        return eBConsumerNumber;
    }

    public void setEBConsumerNumber(String eBConsumerNumber) {
        this.eBConsumerNumber = eBConsumerNumber;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getTypeofElectricConnection() {
        return typeofElectricConnection;
    }

    public void setTypeofElectricConnection(String typeofElectricConnection) {
        this.typeofElectricConnection = typeofElectricConnection;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(String unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    public String getBillingPeriodFrom() {
        return billingPeriodFrom;
    }

    public void setBillingPeriodFrom(String billingPeriodFrom) {
        this.billingPeriodFrom = billingPeriodFrom;
    }

    public String getBillingPeriodTo() {
        return billingPeriodTo;
    }

    public void setBillingPeriodTo(String billingPeriodTo) {
        this.billingPeriodTo = billingPeriodTo;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getBillIssueDate() {
        return billIssueDate;
    }

    public void setBillIssueDate(String billIssueDate) {
        this.billIssueDate = billIssueDate;
    }

    public String getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(String billDueDate) {
        this.billDueDate = billDueDate;
    }

    public String getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getNetPayableOnOrBeforeDueDate() {
        return netPayableOnOrBeforeDueDate;
    }

    public void setNetPayableOnOrBeforeDueDate(String netPayableOnOrBeforeDueDate) {
        this.netPayableOnOrBeforeDueDate = netPayableOnOrBeforeDueDate;
    }

    public String getVendorSAPId() {
        return vendorSAPId;
    }

    public void setVendorSAPId(String vendorSAPId) {
        this.vendorSAPId = vendorSAPId;
    }

    public String getEbBillScanCopyImageName() {
        return ebBillScanCopyImageName;
    }

    public void setEbBillScanCopyImageName(String ebBillScanCopyImageName) {
        this.ebBillScanCopyImageName = ebBillScanCopyImageName;
    }

    public ElectricBillProcessData(String userId, String accessToken, String customerId, String circleId, String stateId, String sSAId, String siteId, String eBServiceProvider, String eBConsumerNumber, String modeOfPayment, String typeofElectricConnection, String tariff, String unitsConsumed, String billingPeriodFrom, String billingPeriodTo, String receiptNumber, String billIssueDate, String billDueDate, String grossAmount, String netPayableOnOrBeforeDueDate, String vendorSAPId, String ebBillScanCopyImageName) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.customerId = customerId;
        this.circleId = circleId;
        this.stateId = stateId;
        this.sSAId = sSAId;
        this.siteId = siteId;
        this.eBServiceProvider = eBServiceProvider;
        this.eBConsumerNumber = eBConsumerNumber;
        this.modeOfPayment = modeOfPayment;
        this.typeofElectricConnection = typeofElectricConnection;
        this.tariff = tariff;
        this.unitsConsumed = unitsConsumed;
        this.billingPeriodFrom = billingPeriodFrom;
        this.billingPeriodTo = billingPeriodTo;
        this.receiptNumber = receiptNumber;
        this.billIssueDate = billIssueDate;
        this.billDueDate = billDueDate;
        this.grossAmount = grossAmount;
        this.netPayableOnOrBeforeDueDate = netPayableOnOrBeforeDueDate;
        this.vendorSAPId = vendorSAPId;
        this.ebBillScanCopyImageName = ebBillScanCopyImageName;
    }
}
