
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcCheckPoint implements Serializable
{

    @SerializedName("detailsOfAcQrCodeScan")
    @Expose
    private String detailsOfAcQrCodeScan;
    @SerializedName("workingConditionOfAc")
    @Expose
    private String workingConditionOfAc;
    @SerializedName("automationOfAcController")
    @Expose
    private String automationOfAcController;
    @SerializedName("acEarthingStatus")
    @Expose
    private String acEarthingStatus;
    @SerializedName("acFilterStatus")
    @Expose
    private String acFilterStatus;
    @SerializedName("base64StringTakePhotoOfAcFiltersBeforeCleaning")
    @Expose
    private String base64StringTakePhotoOfAcFiltersBeforeCleaning;
    @SerializedName("base64StringTakePhotoOfAcFiltersAfterCleaning")
    @Expose
    private String base64StringTakePhotoOfAcFiltersAfterCleaning;
    @SerializedName("cleaningOfCoolingCondensorCoils")
    @Expose
    private String cleaningOfCoolingCondensorCoils;
    @SerializedName("anyAbnormalSoundFromMotor")
    @Expose
    private String anyAbnormalSoundFromMotor;
    @SerializedName("shelterTemperature")
    @Expose
    private String shelterTemperature;
    @SerializedName("base64StringTakePhotoOfTemperature")
    @Expose
    private String base64StringTakePhotoOfTemperature;
    @SerializedName("shelterDoorStatus")
    @Expose
    private String shelterDoorStatus;
    @SerializedName("isQrCodeNew")
    @Expose
    private int isQrCodeNew = 0;

    public AcCheckPoint(){
        this.detailsOfAcQrCodeScan = "";
        this.workingConditionOfAc = "";
        this.automationOfAcController = "";
        this.acEarthingStatus = "";
        this.acFilterStatus = "";
        this.base64StringTakePhotoOfAcFiltersBeforeCleaning = "";
        this.base64StringTakePhotoOfAcFiltersAfterCleaning = "";
        this.cleaningOfCoolingCondensorCoils = "";
        this.anyAbnormalSoundFromMotor = "";
        this.shelterTemperature = "";
        this.base64StringTakePhotoOfTemperature = "";
        this.shelterDoorStatus = "";
    }
    public AcCheckPoint(String detailsOfAcQrCodeScan, String workingConditionOfAc, String automationOfAcController, String acEarthingStatus, String acFilterStatus, String base64StringTakePhotoOfAcFiltersBeforeCleaning, String base64StringTakePhotoOfAcFiltersAfterCleaning, String cleaningOfCoolingCondensorCoils, String anyAbnormalSoundFromMotor, String shelterTemperature, String base64StringTakePhotoOfTemperature, String shelterDoorStatus, int isQrCodeNew) {
        this.detailsOfAcQrCodeScan = detailsOfAcQrCodeScan;
        this.workingConditionOfAc = workingConditionOfAc;
        this.automationOfAcController = automationOfAcController;
        this.acEarthingStatus = acEarthingStatus;
        this.acFilterStatus = acFilterStatus;
        this.base64StringTakePhotoOfAcFiltersBeforeCleaning = base64StringTakePhotoOfAcFiltersBeforeCleaning;
        this.base64StringTakePhotoOfAcFiltersAfterCleaning = base64StringTakePhotoOfAcFiltersAfterCleaning;
        this.cleaningOfCoolingCondensorCoils = cleaningOfCoolingCondensorCoils;
        this.anyAbnormalSoundFromMotor = anyAbnormalSoundFromMotor;
        this.shelterTemperature = shelterTemperature;
        this.base64StringTakePhotoOfTemperature = base64StringTakePhotoOfTemperature;
        this.shelterDoorStatus = shelterDoorStatus;
        this.isQrCodeNew = isQrCodeNew;
    }

    public String getDetailsOfAcQrCodeScan() {
        return detailsOfAcQrCodeScan;
    }

    public void setDetailsOfAcQrCodeScan(String detailsOfAcQrCodeScan) {
        this.detailsOfAcQrCodeScan = detailsOfAcQrCodeScan;
    }

    public String getWorkingConditionOfAc() {
        return workingConditionOfAc;
    }

    public void setWorkingConditionOfAc(String workingConditionOfAc) {
        this.workingConditionOfAc = workingConditionOfAc;
    }

    public String getAutomationOfAcController() {
        return automationOfAcController;
    }

    public void setAutomationOfAcController(String automationOfAcController) {
        this.automationOfAcController = automationOfAcController;
    }

    public String getAcEarthingStatus() {
        return acEarthingStatus;
    }

    public void setAcEarthingStatus(String acEarthingStatus) {
        this.acEarthingStatus = acEarthingStatus;
    }

    public String getAcFilterStatus() {
        return acFilterStatus;
    }

    public void setAcFilterStatus(String acFilterStatus) {
        this.acFilterStatus = acFilterStatus;
    }

    public String getBase64TakePhotoOfAcFiltersBeforeCleaning() {
        return base64StringTakePhotoOfAcFiltersBeforeCleaning;
    }

    public void setBase64TakePhotoOfAcFiltersBeforeCleaning(String base64StringTakePhotoOfAcFiltersBeforeCleaning) {
        this.base64StringTakePhotoOfAcFiltersBeforeCleaning = base64StringTakePhotoOfAcFiltersBeforeCleaning;
    }

    public String getBase64TakePhotoOfAcFiltersAfterCleaning() {
        return base64StringTakePhotoOfAcFiltersAfterCleaning;
    }

    public void setBase64TakePhotoOfAcFiltersAfterCleaning(String base64StringTakePhotoOfAcFiltersAfterCleaning) {
        this.base64StringTakePhotoOfAcFiltersAfterCleaning = base64StringTakePhotoOfAcFiltersAfterCleaning;
    }

    public String getCleaningOfCoolingCondensorCoils() {
        return cleaningOfCoolingCondensorCoils;
    }

    public void setCleaningOfCoolingCondensorCoils(String cleaningOfCoolingCondensorCoils) {
        this.cleaningOfCoolingCondensorCoils = cleaningOfCoolingCondensorCoils;
    }

    public String getAnyAbnormalSoundFromMotor() {
        return anyAbnormalSoundFromMotor;
    }

    public void setAnyAbnormalSoundFromMotor(String anyAbnormalSoundFromMotor) {
        this.anyAbnormalSoundFromMotor = anyAbnormalSoundFromMotor;
    }

    public String getShelterTemperature() {
        return shelterTemperature;
    }

    public void setShelterTemperature(String shelterTemperature) {
        this.shelterTemperature = shelterTemperature;
    }

    public String getBase64TakePhotoOfTemperature() {
        return base64StringTakePhotoOfTemperature;
    }

    public void setBase64TakePhotoOfTemperature(String base64StringTakePhotoOfTemperature) {
        this.base64StringTakePhotoOfTemperature = base64StringTakePhotoOfTemperature;
    }

    public String getShelterDoorStatus() {
        return shelterDoorStatus;
    }

    public void setShelterDoorStatus(String shelterDoorStatus) {
        this.shelterDoorStatus = shelterDoorStatus;
    }



}
