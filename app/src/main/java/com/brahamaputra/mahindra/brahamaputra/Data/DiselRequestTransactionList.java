package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiselRequestTransactionList {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("DiselRequesttTicketNo")
    @Expose
    private String diselRequesttTicketNo;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("PresentDgHmr")
    @Expose
    private String presentDgHmr;
    @SerializedName("PresentDieselStock")
    @Expose
    private String presentDieselStock;
    @SerializedName("PresentEbReading")
    @Expose
    private String presentEbReading;
    @SerializedName("dieselQuantityRequiredinLtrs")
    @Expose
    private String dieselQuantityRequiredinLtrs;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("StatusId")
    @Expose
    private int StatusId;
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
    @SerializedName("hmrPhotoUploadPath")
    @Expose
    private String hmrPhotoUploadPath;
    @SerializedName("ebReadingKwhPhotoPath")
    @Expose
    private String ebReadingKwhPhotoPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiselRequesttTicketNo() {
        return diselRequesttTicketNo;
    }

    public void setDiselRequesttTicketNo(String diselRequesttTicketNo) {
        this.diselRequesttTicketNo = diselRequesttTicketNo;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPresentDgHmr() {
        return presentDgHmr;
    }

    public void setPresentDgHmr(String presentDgHmr) {
        this.presentDgHmr = presentDgHmr;
    }

    public String getPresentDieselStock() {
        return presentDieselStock;
    }

    public void setPresentDieselStock(String presentDieselStock) {
        this.presentDieselStock = presentDieselStock;
    }

    public String getPresentEbReading() {
        return presentEbReading;
    }

    public void setPresentEbReading(String presentEbReading) {
        this.presentEbReading = presentEbReading;
    }

    public String getDieselQuantityRequiredinLtrs() {
        return dieselQuantityRequiredinLtrs;
    }

    public void setDieselQuantityRequiredinLtrs(String dieselQuantityRequiredinLtrs) {
        this.dieselQuantityRequiredinLtrs = dieselQuantityRequiredinLtrs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
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

    public String getHmrPhotoUploadPath() {
        return hmrPhotoUploadPath;
    }

    public void setHmrPhotoUploadPath(String hmrPhotoUploadPath) {
        this.hmrPhotoUploadPath = hmrPhotoUploadPath;
    }

    public String getEbReadingKwhPhotoPath() {
        return ebReadingKwhPhotoPath;
    }

    public void setEbReadingKwhPhotoPath(String ebReadingKwhPhotoPath) {
        this.ebReadingKwhPhotoPath = ebReadingKwhPhotoPath;
    }

}
