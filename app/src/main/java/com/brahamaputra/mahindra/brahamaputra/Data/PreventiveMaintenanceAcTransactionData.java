package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreventiveMaintenanceAcTransactionData implements Serializable {

    @SerializedName("AccessToken")
    @Expose
    private String accessToken;
    @SerializedName("UserId")
    @Expose
    private String userId;
    @SerializedName("checkInBatteryData")
    @Expose
    private String checkInBatteryData;
    @SerializedName("checkInLatitude")
    @Expose
    private String checkInLatitude;
    @SerializedName("checkInLongitude")
    @Expose
    private String checkInLongitude;
    @SerializedName("checkOutBatteryData")
    @Expose
    private String checkOutBatteryData;
    @SerializedName("checkOutLatitude")
    @Expose
    private String checkOutLatitude;
    @SerializedName("checkOutLongitude")
    @Expose
    private String checkOutLongitude;
    @SerializedName("siteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("siteId")
    @Expose
    private String siteId;
    @SerializedName("sourceOfPower")
    @Expose
    private String sourceOfPower;
    @SerializedName("ticketId")
    @Expose
    private String ticketId;
    @SerializedName("ticketNo")
    @Expose
    private String ticketNo;
    @SerializedName("ticketSubmissionFromFieldEngineer")
    @Expose
    private PreventiveMaintenanceAcTicketSubmissionFromFieldEngineer ticketSubmissionFromFieldEngineer;
    @SerializedName("acPreventiveMaintenanceProcessParentData")
    @Expose
    private PreventiveMaintenanceAcProcessParentData acPreventiveMaintenanceProcessParentData;

    public PreventiveMaintenanceAcTransactionData() {
    }

    public PreventiveMaintenanceAcTransactionData(String accessToken, String userId, String checkInBatteryData, String checkInLatitude, String checkInLongitude, String checkOutBatteryData, String checkOutLatitude, String checkOutLongitude, String siteAddress, String siteId, String sourceOfPower, String ticketId, String ticketNo, PreventiveMaintenanceAcTicketSubmissionFromFieldEngineer ticketSubmissionFromFieldEngineer, PreventiveMaintenanceAcProcessParentData acPreventiveMaintenanceProcessParentData) {
        super();
        this.accessToken = accessToken;
        this.userId = userId;
        this.checkInBatteryData = checkInBatteryData;
        this.checkInLatitude = checkInLatitude;
        this.checkInLongitude = checkInLongitude;
        this.checkOutBatteryData = checkOutBatteryData;
        this.checkOutLatitude = checkOutLatitude;
        this.checkOutLongitude = checkOutLongitude;
        this.siteAddress = siteAddress;
        this.siteId = siteId;
        this.sourceOfPower = sourceOfPower;
        this.ticketId = ticketId;
        this.ticketNo = ticketNo;
        this.ticketSubmissionFromFieldEngineer = ticketSubmissionFromFieldEngineer;
        this.acPreventiveMaintenanceProcessParentData = acPreventiveMaintenanceProcessParentData;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCheckInBatteryData() {
        return checkInBatteryData;
    }

    public void setCheckInBatteryData(String checkInBatteryData) {
        this.checkInBatteryData = checkInBatteryData;
    }

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

    public String getCheckOutBatteryData() {
        return checkOutBatteryData;
    }

    public void setCheckOutBatteryData(String checkOutBatteryData) {
        this.checkOutBatteryData = checkOutBatteryData;
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

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSourceOfPower() {
        return sourceOfPower;
    }

    public void setSourceOfPower(String sourceOfPower) {
        this.sourceOfPower = sourceOfPower;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public PreventiveMaintenanceAcTicketSubmissionFromFieldEngineer getTicketSubmissionFromFieldEngineer() {
        return ticketSubmissionFromFieldEngineer;
    }

    public void setTicketSubmissionFromFieldEngineer(PreventiveMaintenanceAcTicketSubmissionFromFieldEngineer ticketSubmissionFromFieldEngineer) {
        this.ticketSubmissionFromFieldEngineer = ticketSubmissionFromFieldEngineer;
    }

    public PreventiveMaintenanceAcProcessParentData getAcPreventiveMaintenanceProcessParentData() {
        return acPreventiveMaintenanceProcessParentData;
    }

    public void setAcPreventiveMaintenanceProcessParentData(PreventiveMaintenanceAcProcessParentData acPreventiveMaintenanceProcessParentData) {
        this.acPreventiveMaintenanceProcessParentData = acPreventiveMaintenanceProcessParentData;
    }

}