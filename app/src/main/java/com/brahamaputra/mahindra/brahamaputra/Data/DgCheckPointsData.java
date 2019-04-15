package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DgCheckPointsData implements Serializable {

    /*@SerializedName("noOfDgAvailableAtSite")
    @Expose
    private String noOfDgAvailableAtSite;*/

    @SerializedName("detailsOfDgQrCodeScan")
    @Expose
    private String detailsOfDgQrCodeScan;
    @SerializedName("dgHmrReading")
    @Expose
    private String dgHmrReading;
    @SerializedName("base64StringTakePhotoOfDgHmr")
    @Expose
    private String base64StringTakePhotoOfDgHmr;
    @SerializedName("dgWorkingCondition")
    @Expose
    private String dgWorkingCondition;
    @SerializedName("coolentLevel")
    @Expose
    private String coolentLevel;
    @SerializedName("beltTension")
    @Expose
    private String beltTension;
    @SerializedName("engineLubeOilLevel")
    @Expose
    private String engineLubeOilLevel;
    @SerializedName("safetyWorkingStatus")
    @Expose
    private String safetyWorkingStatus;
    @SerializedName("powerCableConnectionStatus")
    @Expose
    private String powerCableConnectionStatus;
    @SerializedName("isQrCodeNew")
    @Expose
    private int isQrCodeNew = 0;

    /*private String imageFileTakePhotoOfDgHmr;*/

    /*public String getNoOfDgAvailableAtSite() {
        return noOfDgAvailableAtSite;
    }

    public void setNoOfDgAvailableAtSite(String noOfDgAvailableAtSite) {
        this.noOfDgAvailableAtSite = noOfDgAvailableAtSite;
    }*/

    public DgCheckPointsData() {
        this.detailsOfDgQrCodeScan = "";
        this.dgHmrReading = "";
        this.base64StringTakePhotoOfDgHmr = "";
        this.dgWorkingCondition = "";
        this.coolentLevel = "";
        this.beltTension = "";
        this.engineLubeOilLevel = "";
        this.safetyWorkingStatus = "";
        this.powerCableConnectionStatus = "";

        /*this.imageFileTakePhotoOfDgHmr = "";*/
    }

    public DgCheckPointsData(String detailsOfDgQrCodeScan, String dgHmrReading, String base64StringTakePhotoOfDgHmr, /*String imageFileTakePhotoOfDgHmr,*/ String dgWorkingCondition, String coolentLevel, String beltTension, String engineLubeOilLevel, String safetyWorkingStatus, String powerCableConnectionStatus, int isQrCodeNew) {
        this.detailsOfDgQrCodeScan = detailsOfDgQrCodeScan;
        this.dgHmrReading = dgHmrReading;
        this.base64StringTakePhotoOfDgHmr = base64StringTakePhotoOfDgHmr;
        /*this.imageFileTakePhotoOfDgHmr = imageFileTakePhotoOfDgHmr;*/
        this.dgWorkingCondition = dgWorkingCondition;
        this.coolentLevel = coolentLevel;
        this.beltTension = beltTension;
        this.engineLubeOilLevel = engineLubeOilLevel;
        this.safetyWorkingStatus = safetyWorkingStatus;
        this.powerCableConnectionStatus = powerCableConnectionStatus;

        this.isQrCodeNew = isQrCodeNew;
    }

    public String getDetailsOfDgQrCodeScan() {
        return detailsOfDgQrCodeScan;
    }

    public void setDetailsOfDgQrCodeScan(String detailsOfDgQrCodeScan) {
        this.detailsOfDgQrCodeScan = detailsOfDgQrCodeScan;
    }

    public String getDgHmrReading() {
        return dgHmrReading;
    }

    public void setDgHmrReading(String dgHmrReading) {
        this.dgHmrReading = dgHmrReading;
    }

    public String getBase64StringTakePhotoOfDgHmr() {
        return base64StringTakePhotoOfDgHmr;
    }

    public void setBase64StringTakePhotoOfDgHmr(String base64StringTakePhotoOfDgHmr) {
        this.base64StringTakePhotoOfDgHmr = base64StringTakePhotoOfDgHmr;
    }

    public String getDgWorkingCondition() {
        return dgWorkingCondition;
    }

    public void setDgWorkingCondition(String dgWorkingCondition) {
        this.dgWorkingCondition = dgWorkingCondition;
    }

    public String getCoolentLevel() {
        return coolentLevel;
    }

    public void setCoolentLevel(String coolentLevel) {
        this.coolentLevel = coolentLevel;
    }

    public String getBeltTension() {
        return beltTension;
    }

    public void setBeltTension(String beltTension) {
        this.beltTension = beltTension;
    }

    public String getEngineLubeOilLevel() {
        return engineLubeOilLevel;
    }

    public void setEngineLubeOilLevel(String engineLubeOilLevel) {
        this.engineLubeOilLevel = engineLubeOilLevel;
    }

    public String getSafetyWorkingStatus() {
        return safetyWorkingStatus;
    }

    public void setSafetyWorkingStatus(String safetyWorkingStatus) {
        this.safetyWorkingStatus = safetyWorkingStatus;
    }

    public String getPowerCableConnectionStatus() {
        return powerCableConnectionStatus;
    }

    public void setPowerCableConnectionStatus(String powerCableConnectionStatus) {
        this.powerCableConnectionStatus = powerCableConnectionStatus;
    }

    /*public String getImageFileTakePhotoOfDgHmr() {
        return imageFileTakePhotoOfDgHmr;
    }

    public void setImageFileTakePhotoOfDgHmr(String imageFileTakePhotoOfDgHmr) {
        this.imageFileTakePhotoOfDgHmr = imageFileTakePhotoOfDgHmr;
    }*/


    public int getIsQrCodeNew() {
        return isQrCodeNew;
    }

    public void setIsQrCodeNew(int isQrCodeNew) {
        this.isQrCodeNew = isQrCodeNew;
    }
}
