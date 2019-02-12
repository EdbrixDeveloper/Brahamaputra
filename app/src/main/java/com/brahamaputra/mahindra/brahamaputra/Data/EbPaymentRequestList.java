package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EbPaymentRequestList  {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("RequestTicketeNo")
    @Expose
    private String requestTicketeNo;
    @SerializedName("EBServiceProvider")
    @Expose
    private String eBServiceProvider;
    @SerializedName("ModeOfPayment")
    @Expose
    private String modeOfPayment;
    @SerializedName("TypeofElectricConnection")
    @Expose
    private String typeofElectricConnection;
    @SerializedName("Tariff")
    @Expose
    private String tariff;
    @SerializedName("GrossAmount")
    @Expose
    private String grossAmount;
    @SerializedName("StatusId")
    @Expose
    private String statusId;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("CircleName")
    @Expose
    private String circleName;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("SiteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("SiteType")
    @Expose
    private String siteType;
    @SerializedName("DateOfRequest")
    @Expose
    private String dateOfRequest;
    @SerializedName("BillIssueDate")
    @Expose
    private String billIssueDate;
    @SerializedName("BillDueDate")
    @Expose
    private String billDueDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestTicketeNo() {
        return requestTicketeNo;
    }

    public void setRequestTicketeNo(String requestTicketeNo) {
        this.requestTicketeNo = requestTicketeNo;
    }

    public String getEBServiceProvider() {
        return eBServiceProvider;
    }

    public void setEBServiceProvider(String eBServiceProvider) {
        this.eBServiceProvider = eBServiceProvider;
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

    public String getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(String dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
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

}