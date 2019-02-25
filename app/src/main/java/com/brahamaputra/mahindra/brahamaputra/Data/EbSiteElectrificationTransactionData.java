package com.brahamaputra.mahindra.brahamaputra.Data;

import com.brahamaputra.mahindra.brahamaputra.Activities.EbSiteElectrificationElectricConnectionActivity;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EbSiteElectrificationTransactionData implements Serializable {
    @SerializedName("UserId")
    private String UserId;

    @SerializedName("AccessToken")
    private String AccessToken;

    @SerializedName("ticketId")
    private String ticketId;

    /*@SerializedName("ticketNo")
    private String ticketNo;*/

    @SerializedName("checkInLatitude")
    private String checkInLatitude;

    @SerializedName("checkInLongitude")
    private String checkInLongitude;

    @SerializedName("checkInBatteryData")
    private String checkInBatteryData;

    @SerializedName("siteId")
    private String siteId;

    @SerializedName("siteAddress")
    private String siteAddress;

    @SerializedName("sourceOfPower")
    private String sourceOfPower;

    @SerializedName("checkOutLatitude")
    private String checkOutLatitude;

    @SerializedName("checkOutLongitude")
    private String checkOutLongitude;

    @SerializedName("checkOutBatteryData")
    private String checkOutBatteryData;

    @SerializedName("objEbSiteElectrificationElectricConnection")
    private EbSiteElectrificationElectricConnectionData objEbSiteElectrificationElectricConnection;


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

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    /*public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }*/

    public String getCheckInLatitude() {
        return checkInLatitude;
    }

    public void setCheckInLatitude(String checkInLatitude) {
        this.checkInLatitude = checkInLatitude;
    }

    public String getCheckInLongitude() {
        return checkInLongitude;
    }

    public void setCheckInLongitude(String checkInLongitude) {
        this.checkInLongitude = checkInLongitude;
    }

    public String getCheckInBatteryData() {
        return checkInBatteryData;
    }

    public void setCheckInBatteryData(String checkInBatteryData) {
        this.checkInBatteryData = checkInBatteryData;
    }

    public String getCheckOutBatteryData() {
        return checkOutBatteryData;
    }

    public void setCheckOutBatteryData(String checkOutBatteryData) {
        this.checkOutBatteryData = checkOutBatteryData;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSourceOfPower() {
        return sourceOfPower;
    }

    public void setSourceOfPower(String sourceOfPower) {
        this.sourceOfPower = sourceOfPower;
    }

    public String getCheckOutLatitude() {
        return checkOutLatitude;
    }

    public void setCheckOutLatitude(String checkOutLatitude) {
        this.checkOutLatitude = checkOutLatitude;
    }

    public String getCheckOutLongitude() {
        return checkOutLongitude;
    }

    public void setCheckOutLongitude(String checkOutLongitude) {
        this.checkOutLongitude = checkOutLongitude;
    }

    public EbSiteElectrificationElectricConnectionData getObjEbSiteElectrificationElectricConnection()
    {
        return objEbSiteElectrificationElectricConnection;
    }

    public void setObjEbSiteElectrificationElectricConnection(EbSiteElectrificationElectricConnectionData objEbSiteElectrificationElectricConnection) {
        this.objEbSiteElectrificationElectricConnection = objEbSiteElectrificationElectricConnection;
    }
}
