
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DgCheckPoints implements Serializable
{

    @SerializedName("noOfDgAvailableAtSite")
    @Expose
    private String noOfDgAvailableAtSite;
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
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    private final static long serialVersionUID = 2712088718549900683L;

    public String getNoOfDgAvailableAtSite() {
        return noOfDgAvailableAtSite;
    }

    public void setNoOfDgAvailableAtSite(String noOfDgAvailableAtSite) {
        this.noOfDgAvailableAtSite = noOfDgAvailableAtSite;
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

    public String getRegisterFault() {
        return registerFault;
    }

    public void setRegisterFault(String registerFault) {
        this.registerFault = registerFault;
    }

    public String getTypeOfFault() {
        return typeOfFault;
    }

    public void setTypeOfFault(String typeOfFault) {
        this.typeOfFault = typeOfFault;
    }

}
