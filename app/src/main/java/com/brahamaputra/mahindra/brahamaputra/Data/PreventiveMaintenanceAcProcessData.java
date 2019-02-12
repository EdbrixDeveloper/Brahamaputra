
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreventiveMaintenanceAcProcessData implements Serializable {

    @SerializedName("acPreventiveMaintenanceProcessQrCodeScan")
    @Expose
    private String acPreventiveMaintenanceProcessQrCodeScan;
    @SerializedName("acModel")
    @Expose
    private String acModel;
    @SerializedName("acType")
    @Expose
    private String acType;
    @SerializedName("acMake")
    @Expose
    private String acMake;
    @SerializedName("acCapacity")
    @Expose
    private String acCapacity;
    @SerializedName("acSerialNo")
    @Expose
    private String acSerialNo;
    @SerializedName("mainMcbStatus")
    @Expose
    private String mainMcbStatus;
    @SerializedName("subMcbStatus")
    @Expose
    private String subMcbStatus;
    @SerializedName("metalCladPlugStatus")
    @Expose
    private String metalCladPlugStatus;
    @SerializedName("metalCladSocketStatus")
    @Expose
    private String metalCladSocketStatus;
    @SerializedName("stablizerStatus")
    @Expose
    private String stablizerStatus;
    @SerializedName("stabilizerMake")
    @Expose
    private String stabilizerMake;
    @SerializedName("stabilizerCapacity")
    @Expose
    private String stabilizerCapacity;
    @SerializedName("stablizerWorkingStatus")
    @Expose
    private String stablizerWorkingStatus;
    @SerializedName("inputAcVoltage")
    @Expose
    private String inputAcVoltage;
    @SerializedName("acEarthingStatus")
    @Expose
    private String acEarthingStatus;
    @SerializedName("filterCleaned")
    @Expose
    private String filterCleaned;
    @SerializedName("base64filterCleanedBeforePhoto")
    @Expose
    private String base64filterCleanedBeforePhoto;
    @SerializedName("base64filterCleanedAfterPhoto")
    @Expose
    private String base64filterCleanedAfterPhoto;
    @SerializedName("condenserCoilCleaned")
    @Expose
    private String condenserCoilCleaned;
    @SerializedName("base64condenserCoilCleanedBeforePhoto")
    @Expose
    private String base64condenserCoilCleanedBeforePhoto;
    @SerializedName("base64condenserCoilCleanedAfterPhoto")
    @Expose
    private String base64condenserCoilCleanedAfterPhoto;
    @SerializedName("coolingCoilCleaned")
    @Expose
    private String coolingCoilCleaned;
    @SerializedName("base64coolingCoilCleanedBeforePhoto")
    @Expose
    private String base64coolingCoilCleanedBeforePhoto;
    @SerializedName("base64coolingCoilCleanedAfterPhoto")
    @Expose
    private String base64coolingCoilCleanedAfterPhoto;
    @SerializedName("acCoolingStatus")
    @Expose
    private String acCoolingStatus;
    @SerializedName("acStartingLoadCurrent")
    @Expose
    private String acStartingLoadCurrent;
    @SerializedName("acRunningLoadCurrent")
    @Expose
    private String acRunningLoadCurrent;
    @SerializedName("indoorFilterCleanedStatus")
    @Expose
    private String indoorFilterCleanedStatus;
    @SerializedName("indoorFanMotorCondition")
    @Expose
    private String indoorFanMotorCondition;
    @SerializedName("blowerWheelCondition")
    @Expose
    private String blowerWheelCondition;
    @SerializedName("noiseIndoorMotor")
    @Expose
    private String noiseIndoorMotor;
    @SerializedName("outdoorFanmotorCondition")
    @Expose
    private String outdoorFanmotorCondition;
    @SerializedName("fanLeafCondition")
    @Expose
    private String fanLeafCondition;
    @SerializedName("noiseOutdoorMotor")
    @Expose
    private String noiseOutdoorMotor;
    @SerializedName("compressorCondition")
    @Expose
    private String compressorCondition;
    @SerializedName("compCapacitorCondition")
    @Expose
    private String compCapacitorCondition;
    @SerializedName("controllerCondition")
    @Expose
    private String controllerCondition;
    @SerializedName("acAlarmStatus")
    @Expose
    private String acAlarmStatus;
    @SerializedName("acSensorCondition")
    @Expose
    private String acSensorCondition;
    @SerializedName("roomTemperature")
    @Expose
    private String roomTemperature;
    @SerializedName("setTemperature")
    @Expose
    private String setTemperature;
    @SerializedName("vibrationOfAc")
    @Expose
    private String vibrationOfAc;
    @SerializedName("freeCoolingUnitStatus")
    @Expose
    private String freeCoolingUnitStatus;
    @SerializedName("freeCoolingAvailable")
    @Expose
    private String freeCoolingAvailable;
    @SerializedName("waterLeakage")
    @Expose
    private String waterLeakage;
    @SerializedName("acCabinateStatus")
    @Expose
    private String acCabinateStatus;
    @SerializedName("shelterDoorStatus")
    @Expose
    private String shelterDoorStatus;
    @SerializedName("remarks")
    @Expose
    private String remarks;

    /**
     * No args constructor for use in serialization
     */
    public PreventiveMaintenanceAcProcessData() {
        this.acPreventiveMaintenanceProcessQrCodeScan ="";
        this.acModel ="";
        this.acType ="";
        this.acMake ="";
        this.acCapacity ="";
        this.acSerialNo ="";
        this.mainMcbStatus ="";
        this.subMcbStatus ="";
        this.metalCladPlugStatus ="";
        this.metalCladSocketStatus ="";
        this.stablizerStatus ="";
        this.stabilizerMake ="";
        this.stabilizerCapacity ="";
        this.stablizerWorkingStatus ="";
        this.inputAcVoltage ="";
        this.acEarthingStatus ="";
        this.filterCleaned ="";
        this.base64filterCleanedBeforePhoto ="";
        this.base64filterCleanedAfterPhoto ="";
        this.condenserCoilCleaned ="";
        this.base64condenserCoilCleanedBeforePhoto ="";
        this.base64condenserCoilCleanedAfterPhoto ="";
        this.coolingCoilCleaned ="";
        this.base64coolingCoilCleanedBeforePhoto ="";
        this.base64coolingCoilCleanedAfterPhoto ="";
        this.acCoolingStatus ="";
        this.acStartingLoadCurrent ="";
        this.acRunningLoadCurrent ="";
        this.indoorFilterCleanedStatus ="";
        this.indoorFanMotorCondition ="";
        this.blowerWheelCondition ="";
        this.noiseIndoorMotor ="";
        this.outdoorFanmotorCondition ="";
        this.fanLeafCondition ="";
        this.noiseOutdoorMotor ="";
        this.compressorCondition ="";
        this.compCapacitorCondition ="";
        this.controllerCondition ="";
        this.acAlarmStatus ="";
        this.acSensorCondition ="";
        this.roomTemperature ="";
        this.setTemperature ="";
        this.vibrationOfAc ="";
        this.freeCoolingUnitStatus ="";
        this.freeCoolingAvailable ="";
        this.waterLeakage ="";
        this.acCabinateStatus ="";
        this.shelterDoorStatus ="";
        this.remarks ="";

    }

    public PreventiveMaintenanceAcProcessData(String acPreventiveMaintenanceProcessQrCodeScan, String acModel, String acType, String acMake, String acCapacity, String acSerialNo, String mainMcbStatus, String subMcbStatus, String metalCladPlugStatus, String metalCladSocketStatus, String stablizerStatus, String stabilizerMake, String stabilizerCapacity, String stablizerWorkingStatus, String inputAcVoltage, String acEarthingStatus, String filterCleaned, String base64filterCleanedBeforePhoto, String base64filterCleanedAfterPhoto, String condenserCoilCleaned, String base64condenserCoilCleanedBeforePhoto, String base64condenserCoilCleanedAfterPhoto, String coolingCoilCleaned, String base64coolingCoilCleanedBeforePhoto, String base64coolingCoilCleanedAfterPhoto, String acCoolingStatus, String acStartingLoadCurrent, String acRunningLoadCurrent, String indoorFilterCleanedStatus, String indoorFanMotorCondition, String blowerWheelCondition, String noiseIndoorMotor, String outdoorFanmotorCondition, String fanLeafCondition, String noiseOutdoorMotor, String compressorCondition, String compCapacitorCondition, String controllerCondition, String acAlarmStatus, String acSensorCondition, String roomTemperature, String setTemperature, String vibrationOfAc, String freeCoolingUnitStatus, String freeCoolingAvailable, String waterLeakage, String acCabinateStatus, String shelterDoorStatus, String remarks) {
        this.acPreventiveMaintenanceProcessQrCodeScan = acPreventiveMaintenanceProcessQrCodeScan;
        this.acModel = acModel;
        this.acType = acType;
        this.acMake = acMake;
        this.acCapacity = acCapacity;
        this.acSerialNo = acSerialNo;
        this.mainMcbStatus = mainMcbStatus;
        this.subMcbStatus = subMcbStatus;
        this.metalCladPlugStatus = metalCladPlugStatus;
        this.metalCladSocketStatus = metalCladSocketStatus;
        this.stablizerStatus = stablizerStatus;
        this.stabilizerMake = stabilizerMake;
        this.stabilizerCapacity = stabilizerCapacity;
        this.stablizerWorkingStatus = stablizerWorkingStatus;
        this.inputAcVoltage = inputAcVoltage;
        this.acEarthingStatus = acEarthingStatus;
        this.filterCleaned = filterCleaned;
        this.base64filterCleanedBeforePhoto = base64filterCleanedBeforePhoto;
        this.base64filterCleanedAfterPhoto = base64filterCleanedAfterPhoto;
        this.condenserCoilCleaned = condenserCoilCleaned;
        this.base64condenserCoilCleanedBeforePhoto = base64condenserCoilCleanedBeforePhoto;
        this.base64condenserCoilCleanedAfterPhoto = base64condenserCoilCleanedAfterPhoto;
        this.coolingCoilCleaned = coolingCoilCleaned;
        this.base64coolingCoilCleanedBeforePhoto = base64coolingCoilCleanedBeforePhoto;
        this.base64coolingCoilCleanedAfterPhoto = base64coolingCoilCleanedAfterPhoto;
        this.acCoolingStatus = acCoolingStatus;
        this.acStartingLoadCurrent = acStartingLoadCurrent;
        this.acRunningLoadCurrent = acRunningLoadCurrent;
        this.indoorFilterCleanedStatus = indoorFilterCleanedStatus;
        this.indoorFanMotorCondition = indoorFanMotorCondition;
        this.blowerWheelCondition = blowerWheelCondition;
        this.noiseIndoorMotor = noiseIndoorMotor;
        this.outdoorFanmotorCondition = outdoorFanmotorCondition;
        this.fanLeafCondition = fanLeafCondition;
        this.noiseOutdoorMotor = noiseOutdoorMotor;
        this.compressorCondition = compressorCondition;
        this.compCapacitorCondition = compCapacitorCondition;
        this.controllerCondition = controllerCondition;
        this.acAlarmStatus = acAlarmStatus;
        this.acSensorCondition = acSensorCondition;
        this.roomTemperature = roomTemperature;
        this.setTemperature = setTemperature;
        this.vibrationOfAc = vibrationOfAc;
        this.freeCoolingUnitStatus = freeCoolingUnitStatus;
        this.freeCoolingAvailable = freeCoolingAvailable;
        this.waterLeakage = waterLeakage;
        this.acCabinateStatus = acCabinateStatus;
        this.shelterDoorStatus = shelterDoorStatus;
        this.remarks = remarks;
    }

    public String getAcPreventiveMaintenanceProcessQrCodeScan() {
        return acPreventiveMaintenanceProcessQrCodeScan;
    }

    public void setAcPreventiveMaintenanceProcessQrCodeScan(String acPreventiveMaintenanceProcessQrCodeScan) {
        this.acPreventiveMaintenanceProcessQrCodeScan = acPreventiveMaintenanceProcessQrCodeScan;
    }

    public String getAcModel() {
        return acModel;
    }

    public void setAcModel(String acModel) {
        this.acModel = acModel;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public String getAcMake() {
        return acMake;
    }

    public void setAcMake(String acMake) {
        this.acMake = acMake;
    }

    public String getAcCapacity() {
        return acCapacity;
    }

    public void setAcCapacity(String acCapacity) {
        this.acCapacity = acCapacity;
    }

    public String getAcSerialNo() {
        return acSerialNo;
    }

    public void setAcSerialNo(String acSerialNo) {
        this.acSerialNo = acSerialNo;
    }

    public String getMainMcbStatus() {
        return mainMcbStatus;
    }

    public void setMainMcbStatus(String mainMcbStatus) {
        this.mainMcbStatus = mainMcbStatus;
    }

    public String getSubMcbStatus() {
        return subMcbStatus;
    }

    public void setSubMcbStatus(String subMcbStatus) {
        this.subMcbStatus = subMcbStatus;
    }

    public String getMetalCladPlugStatus() {
        return metalCladPlugStatus;
    }

    public void setMetalCladPlugStatus(String metalCladPlugStatus) {
        this.metalCladPlugStatus = metalCladPlugStatus;
    }

    public String getMetalCladSocketStatus() {
        return metalCladSocketStatus;
    }

    public void setMetalCladSocketStatus(String metalCladSocketStatus) {
        this.metalCladSocketStatus = metalCladSocketStatus;
    }

    public String getStablizerStatus() {
        return stablizerStatus;
    }

    public void setStablizerStatus(String stablizerStatus) {
        this.stablizerStatus = stablizerStatus;
    }

    public String getStabilizerMake() {
        return stabilizerMake;
    }

    public void setStabilizerMake(String stabilizerMake) {
        this.stabilizerMake = stabilizerMake;
    }

    public String getStabilizerCapacity() {
        return stabilizerCapacity;
    }

    public void setStabilizerCapacity(String stabilizerCapacity) {
        this.stabilizerCapacity = stabilizerCapacity;
    }

    public String getStablizerWorkingStatus() {
        return stablizerWorkingStatus;
    }

    public void setStablizerWorkingStatus(String stablizerWorkingStatus) {
        this.stablizerWorkingStatus = stablizerWorkingStatus;
    }

    public String getInputAcVoltage() {
        return inputAcVoltage;
    }

    public void setInputAcVoltage(String inputAcVoltage) {
        this.inputAcVoltage = inputAcVoltage;
    }

    public String getAcEarthingStatus() {
        return acEarthingStatus;
    }

    public void setAcEarthingStatus(String acEarthingStatus) {
        this.acEarthingStatus = acEarthingStatus;
    }

    public String getFilterCleaned() {
        return filterCleaned;
    }

    public void setFilterCleaned(String filterCleaned) {
        this.filterCleaned = filterCleaned;
    }

    public String getBase64filterCleanedBeforePhoto() {
        return base64filterCleanedBeforePhoto;
    }

    public void setBase64filterCleanedBeforePhoto(String base64filterCleanedBeforePhoto) {
        this.base64filterCleanedBeforePhoto = base64filterCleanedBeforePhoto;
    }

    public String getBase64filterCleanedAfterPhoto() {
        return base64filterCleanedAfterPhoto;
    }

    public void setBase64filterCleanedAfterPhoto(String base64filterCleanedAfterPhoto) {
        this.base64filterCleanedAfterPhoto = base64filterCleanedAfterPhoto;
    }

    public String getCondenserCoilCleaned() {
        return condenserCoilCleaned;
    }

    public void setCondenserCoilCleaned(String condenserCoilCleaned) {
        this.condenserCoilCleaned = condenserCoilCleaned;
    }

    public String getBase64condenserCoilCleanedBeforePhoto() {
        return base64condenserCoilCleanedBeforePhoto;
    }

    public void setBase64condenserCoilCleanedBeforePhoto(String base64condenserCoilCleanedBeforePhoto) {
        this.base64condenserCoilCleanedBeforePhoto = base64condenserCoilCleanedBeforePhoto;
    }

    public String getBase64condenserCoilCleanedAfterPhoto() {
        return base64condenserCoilCleanedAfterPhoto;
    }

    public void setBase64condenserCoilCleanedAfterPhoto(String base64condenserCoilCleanedAfterPhoto) {
        this.base64condenserCoilCleanedAfterPhoto = base64condenserCoilCleanedAfterPhoto;
    }

    public String getCoolingCoilCleaned() {
        return coolingCoilCleaned;
    }

    public void setCoolingCoilCleaned(String coolingCoilCleaned) {
        this.coolingCoilCleaned = coolingCoilCleaned;
    }

    public String getBase64coolingCoilCleanedBeforePhoto() {
        return base64coolingCoilCleanedBeforePhoto;
    }

    public void setBase64coolingCoilCleanedBeforePhoto(String base64coolingCoilCleanedBeforePhoto) {
        this.base64coolingCoilCleanedBeforePhoto = base64coolingCoilCleanedBeforePhoto;
    }

    public String getBase64coolingCoilCleanedAfterPhoto() {
        return base64coolingCoilCleanedAfterPhoto;
    }

    public void setBase64coolingCoilCleanedAfterPhoto(String base64coolingCoilCleanedAfterPhoto) {
        this.base64coolingCoilCleanedAfterPhoto = base64coolingCoilCleanedAfterPhoto;
    }

    public String getAcCoolingStatus() {
        return acCoolingStatus;
    }

    public void setAcCoolingStatus(String acCoolingStatus) {
        this.acCoolingStatus = acCoolingStatus;
    }

    public String getAcStartingLoadCurrent() {
        return acStartingLoadCurrent;
    }

    public void setAcStartingLoadCurrent(String acStartingLoadCurrent) {
        this.acStartingLoadCurrent = acStartingLoadCurrent;
    }

    public String getAcRunningLoadCurrent() {
        return acRunningLoadCurrent;
    }

    public void setAcRunningLoadCurrent(String acRunningLoadCurrent) {
        this.acRunningLoadCurrent = acRunningLoadCurrent;
    }

    public String getIndoorFilterCleanedStatus() {
        return indoorFilterCleanedStatus;
    }

    public void setIndoorFilterCleanedStatus(String indoorFilterCleanedStatus) {
        this.indoorFilterCleanedStatus = indoorFilterCleanedStatus;
    }

    public String getIndoorFanMotorCondition() {
        return indoorFanMotorCondition;
    }

    public void setIndoorFanMotorCondition(String indoorFanMotorCondition) {
        this.indoorFanMotorCondition = indoorFanMotorCondition;
    }

    public String getBlowerWheelCondition() {
        return blowerWheelCondition;
    }

    public void setBlowerWheelCondition(String blowerWheelCondition) {
        this.blowerWheelCondition = blowerWheelCondition;
    }

    public String getNoiseIndoorMotor() {
        return noiseIndoorMotor;
    }

    public void setNoiseIndoorMotor(String noiseIndoorMotor) {
        this.noiseIndoorMotor = noiseIndoorMotor;
    }

    public String getOutdoorFanmotorCondition() {
        return outdoorFanmotorCondition;
    }

    public void setOutdoorFanmotorCondition(String outdoorFanmotorCondition) {
        this.outdoorFanmotorCondition = outdoorFanmotorCondition;
    }

    public String getFanLeafCondition() {
        return fanLeafCondition;
    }

    public void setFanLeafCondition(String fanLeafCondition) {
        this.fanLeafCondition = fanLeafCondition;
    }

    public String getNoiseOutdoorMotor() {
        return noiseOutdoorMotor;
    }

    public void setNoiseOutdoorMotor(String noiseOutdoorMotor) {
        this.noiseOutdoorMotor = noiseOutdoorMotor;
    }

    public String getCompressorCondition() {
        return compressorCondition;
    }

    public void setCompressorCondition(String compressorCondition) {
        this.compressorCondition = compressorCondition;
    }

    public String getCompCapacitorCondition() {
        return compCapacitorCondition;
    }

    public void setCompCapacitorCondition(String compCapacitorCondition) {
        this.compCapacitorCondition = compCapacitorCondition;
    }

    public String getControllerCondition() {
        return controllerCondition;
    }

    public void setControllerCondition(String controllerCondition) {
        this.controllerCondition = controllerCondition;
    }

    public String getAcAlarmStatus() {
        return acAlarmStatus;
    }

    public void setAcAlarmStatus(String acAlarmStatus) {
        this.acAlarmStatus = acAlarmStatus;
    }

    public String getAcSensorCondition() {
        return acSensorCondition;
    }

    public void setAcSensorCondition(String acSensorCondition) {
        this.acSensorCondition = acSensorCondition;
    }

    public String getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(String roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public String getSetTemperature() {
        return setTemperature;
    }

    public void setSetTemperature(String setTemperature) {
        this.setTemperature = setTemperature;
    }

    public String getVibrationOfAc() {
        return vibrationOfAc;
    }

    public void setVibrationOfAc(String vibrationOfAc) {
        this.vibrationOfAc = vibrationOfAc;
    }

    public String getFreeCoolingUnitStatus() {
        return freeCoolingUnitStatus;
    }

    public void setFreeCoolingUnitStatus(String freeCoolingUnitStatus) {
        this.freeCoolingUnitStatus = freeCoolingUnitStatus;
    }

    public String getFreeCoolingAvailable() {
        return freeCoolingAvailable;
    }

    public void setFreeCoolingAvailable(String freeCoolingAvailable) {
        this.freeCoolingAvailable = freeCoolingAvailable;
    }

    public String getWaterLeakage() {
        return waterLeakage;
    }

    public void setWaterLeakage(String waterLeakage) {
        this.waterLeakage = waterLeakage;
    }

    public String getAcCabinateStatus() {
        return acCabinateStatus;
    }

    public void setAcCabinateStatus(String acCabinateStatus) {
        this.acCabinateStatus = acCabinateStatus;
    }

    public String getShelterDoorStatus() {
        return shelterDoorStatus;
    }

    public void setShelterDoorStatus(String shelterDoorStatus) {
        this.shelterDoorStatus = shelterDoorStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
