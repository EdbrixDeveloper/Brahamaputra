package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiselFillingTransactionList {


    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("DiselFillingtTicketNo")
    @Expose
    private String diselFillingtTicketNo;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("TankBalanceBeforeFilling")
    @Expose
    private String tankBalanceBeforeFilling;
    @SerializedName("FillingQty")
    @Expose
    private String fillingQty;
    @SerializedName("DieselPrice")
    @Expose
    private String dieselPrice;
    @SerializedName("FinalDieselStock")
    @Expose
    private String finalDieselStock;
    @SerializedName("PresentDgHmr")
    @Expose
    private String presentDgHmr;
    @SerializedName("SelectDgIdQrCode")
    @Expose
    private String selectDgIdQrCode;
    @SerializedName("Latitude")
    @Expose
    private String latitude;
    @SerializedName("Longitude")
    @Expose
    private String longitude;
    @SerializedName("PesentEbReading")
    @Expose
    private String pesentEbReading;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("SiteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("SiteType")
    @Expose
    private String siteType;
    @SerializedName("DateOfFilling")
    @Expose
    private String dateOfFilling;
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

    public String getDiselFillingtTicketNo() {
        return diselFillingtTicketNo;
    }

    public void setDiselFillingtTicketNo(String diselFillingtTicketNo) {
        this.diselFillingtTicketNo = diselFillingtTicketNo;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTankBalanceBeforeFilling() {
        return tankBalanceBeforeFilling;
    }

    public void setTankBalanceBeforeFilling(String tankBalanceBeforeFilling) {
        this.tankBalanceBeforeFilling = tankBalanceBeforeFilling;
    }

    public String getFillingQty() {
        return fillingQty;
    }

    public void setFillingQty(String fillingQty) {
        this.fillingQty = fillingQty;
    }

    public String getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(String dieselPrice) {
        this.dieselPrice = dieselPrice;
    }

    public String getFinalDieselStock() {
        return finalDieselStock;
    }

    public void setFinalDieselStock(String finalDieselStock) {
        this.finalDieselStock = finalDieselStock;
    }

    public String getPresentDgHmr() {
        return presentDgHmr;
    }

    public void setPresentDgHmr(String presentDgHmr) {
        this.presentDgHmr = presentDgHmr;
    }

    public String getSelectDgIdQrCode() {
        return selectDgIdQrCode;
    }

    public void setSelectDgIdQrCode(String selectDgIdQrCode) {
        this.selectDgIdQrCode = selectDgIdQrCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPesentEbReading() {
        return pesentEbReading;
    }

    public void setPesentEbReading(String pesentEbReading) {
        this.pesentEbReading = pesentEbReading;
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

    public String getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
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
