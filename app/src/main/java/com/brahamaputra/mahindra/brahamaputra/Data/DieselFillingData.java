package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class DieselFillingData {

    @SerializedName("siteID")
    private String siteID;

    @SerializedName("selectDgIdQrCode")
    private String selectDgIdQrCode;

    @SerializedName("presentDgHmr")
    private String presentDgHmr;

    @SerializedName("hmrPhotoUpload")
    private String hmrPhotoUpload;

    @SerializedName("tankBalanceBeforeFilling")
    private String tankBalanceBeforeFilling;

    @SerializedName("fillingQty")
    private String fillingQty;

    @SerializedName("finalDieselStock")
    private String finalDieselStock;

    @SerializedName("pesentEbReading")
    private String pesentEbReading;

    @SerializedName("ebReadingKwhPhoto")
    private String ebReadingKwhPhoto;

    @SerializedName("UserId")
    private String UserId;

    @SerializedName("AccessToken")
    private String AccessToken;

    @SerializedName("dieselPrice")
    private String dieselPrice;


    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSelectDgIdQrCode() {
        return selectDgIdQrCode;
    }

    public void setSelectDgIdQrCode(String selectDgIdQrCode) {
        this.selectDgIdQrCode = selectDgIdQrCode;
    }

    public String getPresentDgHmr() {
        return presentDgHmr;
    }

    public void setPresentDgHmr(String presentDgHmr) {
        this.presentDgHmr = presentDgHmr;
    }

    public String getHmrPhotoUpload() {
        return hmrPhotoUpload;
    }

    public void setHmrPhotoUpload(String hmrPhotoUpload) {
        this.hmrPhotoUpload = hmrPhotoUpload;
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

    public String getFinalDieselStock() {
        return finalDieselStock;
    }

    public void setFinalDieselStock(String finalDieselStock) {
        this.finalDieselStock = finalDieselStock;
    }

    public String getPesentEbReading() {
        return pesentEbReading;
    }

    public void setPesentEbReading(String pesentEbReading) {
        this.pesentEbReading = pesentEbReading;
    }

    public String getEbReadingKwhPhoto() {
        return ebReadingKwhPhoto;
    }

    public void setEbReadingKwhPhoto(String ebReadingKwhPhoto) {
        this.ebReadingKwhPhoto = ebReadingKwhPhoto;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(String dieselPrice) {
        this.dieselPrice = dieselPrice;
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

    public DieselFillingData(String siteID, String selectDgIdQrCode, String presentDgHmr, String hmrPhotoUpload, String tankBalanceBeforeFilling, String fillingQty, String finalDieselStock, String pesentEbReading, String ebReadingKwhPhoto, String userId, String accessToken, String dieselPrice, String latitude, String longitude) {
        this.siteID = siteID;
        this.selectDgIdQrCode = selectDgIdQrCode;
        this.presentDgHmr = presentDgHmr;
        this.hmrPhotoUpload = hmrPhotoUpload;
        this.tankBalanceBeforeFilling = tankBalanceBeforeFilling;
        this.fillingQty = fillingQty;
        this.finalDieselStock = finalDieselStock;
        this.pesentEbReading = pesentEbReading;
        this.ebReadingKwhPhoto = ebReadingKwhPhoto;
        UserId = userId;
        AccessToken = accessToken;
        this.dieselPrice = dieselPrice;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}




