
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
    @SerializedName("base64TakePhotoOfAcFiltersBeforeCleaning")
    @Expose
    private String base64TakePhotoOfAcFiltersBeforeCleaning;
    @SerializedName("base64TakePhotoOfAcFiltersAfterCleaning")
    @Expose
    private String base64TakePhotoOfAcFiltersAfterCleaning;
    @SerializedName("cleaningOfCoolingCondensorCoils")
    @Expose
    private String cleaningOfCoolingCondensorCoils;
    @SerializedName("anyAbnormalSoundFromMotor")
    @Expose
    private String anyAbnormalSoundFromMotor;
    @SerializedName("shelterTemperature")
    @Expose
    private String shelterTemperature;
    @SerializedName("base64TakePhotoOfTemperature")
    @Expose
    private String base64TakePhotoOfTemperature;
    @SerializedName("shelterDoorStatus")
    @Expose
    private String shelterDoorStatus;




    private final static long serialVersionUID = -6436987330345681329L;

    public AcCheckPoint(){
        this.detailsOfAcQrCodeScan = "";
        this.workingConditionOfAc = "";
        this.automationOfAcController = "";
        this.acEarthingStatus = "";
        this.acFilterStatus = "";
        this.base64TakePhotoOfAcFiltersBeforeCleaning = "";
        this.base64TakePhotoOfAcFiltersAfterCleaning = "";
        this.cleaningOfCoolingCondensorCoils = "";
        this.anyAbnormalSoundFromMotor = "";
        this.shelterTemperature = "";
        this.base64TakePhotoOfTemperature = "";
        this.shelterDoorStatus = "";

    }
    public AcCheckPoint(String detailsOfAcQrCodeScan, String workingConditionOfAc, String automationOfAcController, String acEarthingStatus, String acFilterStatus, String base64TakePhotoOfAcFiltersBeforeCleaning, String base64TakePhotoOfAcFiltersAfterCleaning, String cleaningOfCoolingCondensorCoils, String anyAbnormalSoundFromMotor, String shelterTemperature, String base64TakePhotoOfTemperature, String shelterDoorStatus) {
        this.detailsOfAcQrCodeScan = detailsOfAcQrCodeScan;
        this.workingConditionOfAc = workingConditionOfAc;
        this.automationOfAcController = automationOfAcController;
        this.acEarthingStatus = acEarthingStatus;
        this.acFilterStatus = acFilterStatus;
        this.base64TakePhotoOfAcFiltersBeforeCleaning = base64TakePhotoOfAcFiltersBeforeCleaning;
        this.base64TakePhotoOfAcFiltersAfterCleaning = base64TakePhotoOfAcFiltersAfterCleaning;
        this.cleaningOfCoolingCondensorCoils = cleaningOfCoolingCondensorCoils;
        this.anyAbnormalSoundFromMotor = anyAbnormalSoundFromMotor;
        this.shelterTemperature = shelterTemperature;
        this.base64TakePhotoOfTemperature = base64TakePhotoOfTemperature;
        this.shelterDoorStatus = shelterDoorStatus;

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
        return base64TakePhotoOfAcFiltersBeforeCleaning;
    }

    public void setBase64TakePhotoOfAcFiltersBeforeCleaning(String base64TakePhotoOfAcFiltersBeforeCleaning) {
        this.base64TakePhotoOfAcFiltersBeforeCleaning = base64TakePhotoOfAcFiltersBeforeCleaning;
    }

    public String getBase64TakePhotoOfAcFiltersAfterCleaning() {
        return base64TakePhotoOfAcFiltersAfterCleaning;
    }

    public void setBase64TakePhotoOfAcFiltersAfterCleaning(String base64TakePhotoOfAcFiltersAfterCleaning) {
        this.base64TakePhotoOfAcFiltersAfterCleaning = base64TakePhotoOfAcFiltersAfterCleaning;
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
        return base64TakePhotoOfTemperature;
    }

    public void setBase64TakePhotoOfTemperature(String base64TakePhotoOfTemperature) {
        this.base64TakePhotoOfTemperature = base64TakePhotoOfTemperature;
    }

    public String getShelterDoorStatus() {
        return shelterDoorStatus;
    }

    public void setShelterDoorStatus(String shelterDoorStatus) {
        this.shelterDoorStatus = shelterDoorStatus;
    }



}
