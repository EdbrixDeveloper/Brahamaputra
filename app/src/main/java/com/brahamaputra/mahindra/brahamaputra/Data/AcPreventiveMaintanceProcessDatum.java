package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcPreventiveMaintanceProcessDatum {

    @SerializedName("acPreventiveMaintanceProcessQrCodeScan")
    @Expose
    private String acPreventiveMaintanceProcessQrCodeScan;
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
    @SerializedName("stabilizerStatus")
    @Expose
    private String stabilizerStatus;
    @SerializedName("stabilizerMake")
    @Expose
    private String stabilizerMake;
    @SerializedName("stabilizerCapacity")
    @Expose
    private String stabilizerCapacity;
    @SerializedName("stabilizerWorkingStatus")
    @Expose
    private String stabilizerWorkingStatus;
    @SerializedName("inputAcVoltage")
    @Expose
    private String inputAcVoltage;
    @SerializedName("acEarthingStatus")
    @Expose
    private String acEarthingStatus;
    @SerializedName("filterCleaned")
    @Expose
    private String filterCleaned;
    @SerializedName("base64StringAcFilterPhotoBeforeCleaned")
    @Expose
    private String base64StringAcFilterPhotoBeforeCleaned;
    @SerializedName("base64StringAcFilterPhotoAfterCleaned")
    @Expose
    private String base64StringAcFilterPhotoAfterCleaned;
    @SerializedName("condenserCoilCleaned")
    @Expose
    private String condenserCoilCleaned;
    @SerializedName("base64StringCondenserCoilPhotoBeforeCleaned")
    @Expose
    private String base64StringCondenserCoilPhotoBeforeCleaned;
    @SerializedName("base64StringCondenserCoilPhotoAfterCleaned")
    @Expose
    private String base64StringCondenserCoilPhotoAfterCleaned;
    @SerializedName("coolingCoilCleaned")
    @Expose
    private String coolingCoilCleaned;
    @SerializedName("base64StringCoolingCoilPhotoBeforeCleaned")
    @Expose
    private String base64StringCoolingCoilPhotoBeforeCleaned;
    @SerializedName("base64StringCoolingCoilPhotoAfterCleaned")
    @Expose
    private String base64StringCoolingCoilPhotoAfterCleaned;
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
    @SerializedName("ifAnyNoiseIndoorMotor")
    @Expose
    private String ifAnyNoiseIndoorMotor;
    @SerializedName("outdoorFanMotorCondition")
    @Expose
    private String outdoorFanMotorCondition;
    @SerializedName("fanLeafCondition")
    @Expose
    private String fanLeafCondition;
    @SerializedName("ifAnyNoiseOutdoorMotor")
    @Expose
    private String ifAnyNoiseOutdoorMotor;
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
    @SerializedName("ifAnyVibrationOfAc")
    @Expose
    private String ifAnyVibrationOfAc;
    @SerializedName("freeCoolingUnitStatus")
    @Expose
    private String freeCoolingUnitStatus;
    @SerializedName("ifFreeCoolingAvaibleWorkingStatus")
    @Expose
    private String ifFreeCoolingAvaibleWorkingStatus;
    @SerializedName("waterLeakageIfAny")
    @Expose
    private String waterLeakageIfAny;
    @SerializedName("acCabinateStatus")
    @Expose
    private String acCabinateStatus;
    @SerializedName("shelterDoorStatus")
    @Expose
    private String shelterDoorStatus;
    @SerializedName("remark")
    @Expose
    private String remark;

    /**
     * No args constructor for use in serialization
     *
     */
    public AcPreventiveMaintanceProcessDatum() {
    }

    /**
     *
     * @param ifFreeCoolingAvaibleWorkingStatus
     * @param acMake
     * @param mainMcbStatus
     * @param stabilizerWorkingStatus
     * @param remark
     * @param acSerialNo
     * @param stabilizerStatus
     * @param acCabinateStatus
     * @param ifAnyNoiseIndoorMotor
     * @param controllerCondition
     * @param acModel
     * @param setTemperature
     * @param blowerWheelCondition
     * @param coolingCoilCleaned
     * @param acAlarmStatus
     * @param stabilizerCapacity
     * @param acType
     * @param roomTemperature
     * @param metalCladSocketStatus
     * @param base64StringCoolingCoilPhotoAfterCleaned
     * @param fanLeafCondition
     * @param waterLeakageIfAny
     * @param outdoorFanMotorCondition
     * @param inputAcVoltage
     * @param acCapacity
     * @param condenserCoilCleaned
     * @param base64StringCondenserCoilPhotoBeforeCleaned
     * @param acPreventiveMaintanceProcessQrCodeScan
     * @param acStartingLoadCurrent
     * @param acRunningLoadCurrent
     * @param base64StringCondenserCoilPhotoAfterCleaned
     * @param indoorFilterCleanedStatus
     * @param subMcbStatus
     * @param filterCleaned
     * @param acCoolingStatus
     * @param freeCoolingUnitStatus
     * @param acSensorCondition
     * @param base64StringAcFilterPhotoBeforeCleaned
     * @param indoorFanMotorCondition
     * @param compressorCondition
     * @param shelterDoorStatus
     * @param ifAnyNoiseOutdoorMotor
     * @param compCapacitorCondition
     * @param base64StringCoolingCoilPhotoBeforeCleaned
     * @param ifAnyVibrationOfAc
     * @param acEarthingStatus
     * @param metalCladPlugStatus
     * @param base64StringAcFilterPhotoAfterCleaned
     * @param stabilizerMake
     */
    public AcPreventiveMaintanceProcessDatum(String acPreventiveMaintanceProcessQrCodeScan, String acModel, String acType, String acMake, String acCapacity, String acSerialNo, String mainMcbStatus, String subMcbStatus, String metalCladPlugStatus, String metalCladSocketStatus, String stabilizerStatus, String stabilizerMake, String stabilizerCapacity, String stabilizerWorkingStatus, String inputAcVoltage, String acEarthingStatus, String filterCleaned, String base64StringAcFilterPhotoBeforeCleaned, String base64StringAcFilterPhotoAfterCleaned, String condenserCoilCleaned, String base64StringCondenserCoilPhotoBeforeCleaned, String base64StringCondenserCoilPhotoAfterCleaned, String coolingCoilCleaned, String base64StringCoolingCoilPhotoBeforeCleaned, String base64StringCoolingCoilPhotoAfterCleaned, String acCoolingStatus, String acStartingLoadCurrent, String acRunningLoadCurrent, String indoorFilterCleanedStatus, String indoorFanMotorCondition, String blowerWheelCondition, String ifAnyNoiseIndoorMotor, String outdoorFanMotorCondition, String fanLeafCondition, String ifAnyNoiseOutdoorMotor, String compressorCondition, String compCapacitorCondition, String controllerCondition, String acAlarmStatus, String acSensorCondition, String roomTemperature, String setTemperature, String ifAnyVibrationOfAc, String freeCoolingUnitStatus, String ifFreeCoolingAvaibleWorkingStatus, String waterLeakageIfAny, String acCabinateStatus, String shelterDoorStatus, String remark) {
        super();
        this.acPreventiveMaintanceProcessQrCodeScan = acPreventiveMaintanceProcessQrCodeScan;
        this.acModel = acModel;
        this.acType = acType;
        this.acMake = acMake;
        this.acCapacity = acCapacity;
        this.acSerialNo = acSerialNo;
        this.mainMcbStatus = mainMcbStatus;
        this.subMcbStatus = subMcbStatus;
        this.metalCladPlugStatus = metalCladPlugStatus;
        this.metalCladSocketStatus = metalCladSocketStatus;
        this.stabilizerStatus = stabilizerStatus;
        this.stabilizerMake = stabilizerMake;
        this.stabilizerCapacity = stabilizerCapacity;
        this.stabilizerWorkingStatus = stabilizerWorkingStatus;
        this.inputAcVoltage = inputAcVoltage;
        this.acEarthingStatus = acEarthingStatus;
        this.filterCleaned = filterCleaned;
        this.base64StringAcFilterPhotoBeforeCleaned = base64StringAcFilterPhotoBeforeCleaned;
        this.base64StringAcFilterPhotoAfterCleaned = base64StringAcFilterPhotoAfterCleaned;
        this.condenserCoilCleaned = condenserCoilCleaned;
        this.base64StringCondenserCoilPhotoBeforeCleaned = base64StringCondenserCoilPhotoBeforeCleaned;
        this.base64StringCondenserCoilPhotoAfterCleaned = base64StringCondenserCoilPhotoAfterCleaned;
        this.coolingCoilCleaned = coolingCoilCleaned;
        this.base64StringCoolingCoilPhotoBeforeCleaned = base64StringCoolingCoilPhotoBeforeCleaned;
        this.base64StringCoolingCoilPhotoAfterCleaned = base64StringCoolingCoilPhotoAfterCleaned;
        this.acCoolingStatus = acCoolingStatus;
        this.acStartingLoadCurrent = acStartingLoadCurrent;
        this.acRunningLoadCurrent = acRunningLoadCurrent;
        this.indoorFilterCleanedStatus = indoorFilterCleanedStatus;
        this.indoorFanMotorCondition = indoorFanMotorCondition;
        this.blowerWheelCondition = blowerWheelCondition;
        this.ifAnyNoiseIndoorMotor = ifAnyNoiseIndoorMotor;
        this.outdoorFanMotorCondition = outdoorFanMotorCondition;
        this.fanLeafCondition = fanLeafCondition;
        this.ifAnyNoiseOutdoorMotor = ifAnyNoiseOutdoorMotor;
        this.compressorCondition = compressorCondition;
        this.compCapacitorCondition = compCapacitorCondition;
        this.controllerCondition = controllerCondition;
        this.acAlarmStatus = acAlarmStatus;
        this.acSensorCondition = acSensorCondition;
        this.roomTemperature = roomTemperature;
        this.setTemperature = setTemperature;
        this.ifAnyVibrationOfAc = ifAnyVibrationOfAc;
        this.freeCoolingUnitStatus = freeCoolingUnitStatus;
        this.ifFreeCoolingAvaibleWorkingStatus = ifFreeCoolingAvaibleWorkingStatus;
        this.waterLeakageIfAny = waterLeakageIfAny;
        this.acCabinateStatus = acCabinateStatus;
        this.shelterDoorStatus = shelterDoorStatus;
        this.remark = remark;
    }

    public String getAcPreventiveMaintanceProcessQrCodeScan() {
        return acPreventiveMaintanceProcessQrCodeScan;
    }

    public void setAcPreventiveMaintanceProcessQrCodeScan(String acPreventiveMaintanceProcessQrCodeScan) {
        this.acPreventiveMaintanceProcessQrCodeScan = acPreventiveMaintanceProcessQrCodeScan;
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

    public String getStabilizerStatus() {
        return stabilizerStatus;
    }

    public void setStabilizerStatus(String stabilizerStatus) {
        this.stabilizerStatus = stabilizerStatus;
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

    public String getStabilizerWorkingStatus() {
        return stabilizerWorkingStatus;
    }

    public void setStabilizerWorkingStatus(String stabilizerWorkingStatus) {
        this.stabilizerWorkingStatus = stabilizerWorkingStatus;
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

    public String getBase64StringAcFilterPhotoBeforeCleaned() {
        return base64StringAcFilterPhotoBeforeCleaned;
    }

    public void setBase64StringAcFilterPhotoBeforeCleaned(String base64StringAcFilterPhotoBeforeCleaned) {
        this.base64StringAcFilterPhotoBeforeCleaned = base64StringAcFilterPhotoBeforeCleaned;
    }

    public String getBase64StringAcFilterPhotoAfterCleaned() {
        return base64StringAcFilterPhotoAfterCleaned;
    }

    public void setBase64StringAcFilterPhotoAfterCleaned(String base64StringAcFilterPhotoAfterCleaned) {
        this.base64StringAcFilterPhotoAfterCleaned = base64StringAcFilterPhotoAfterCleaned;
    }

    public String getCondenserCoilCleaned() {
        return condenserCoilCleaned;
    }

    public void setCondenserCoilCleaned(String condenserCoilCleaned) {
        this.condenserCoilCleaned = condenserCoilCleaned;
    }

    public String getBase64StringCondenserCoilPhotoBeforeCleaned() {
        return base64StringCondenserCoilPhotoBeforeCleaned;
    }

    public void setBase64StringCondenserCoilPhotoBeforeCleaned(String base64StringCondenserCoilPhotoBeforeCleaned) {
        this.base64StringCondenserCoilPhotoBeforeCleaned = base64StringCondenserCoilPhotoBeforeCleaned;
    }

    public String getBase64StringCondenserCoilPhotoAfterCleaned() {
        return base64StringCondenserCoilPhotoAfterCleaned;
    }

    public void setBase64StringCondenserCoilPhotoAfterCleaned(String base64StringCondenserCoilPhotoAfterCleaned) {
        this.base64StringCondenserCoilPhotoAfterCleaned = base64StringCondenserCoilPhotoAfterCleaned;
    }

    public String getCoolingCoilCleaned() {
        return coolingCoilCleaned;
    }

    public void setCoolingCoilCleaned(String coolingCoilCleaned) {
        this.coolingCoilCleaned = coolingCoilCleaned;
    }

    public String getBase64StringCoolingCoilPhotoBeforeCleaned() {
        return base64StringCoolingCoilPhotoBeforeCleaned;
    }

    public void setBase64StringCoolingCoilPhotoBeforeCleaned(String base64StringCoolingCoilPhotoBeforeCleaned) {
        this.base64StringCoolingCoilPhotoBeforeCleaned = base64StringCoolingCoilPhotoBeforeCleaned;
    }

    public String getBase64StringCoolingCoilPhotoAfterCleaned() {
        return base64StringCoolingCoilPhotoAfterCleaned;
    }

    public void setBase64StringCoolingCoilPhotoAfterCleaned(String base64StringCoolingCoilPhotoAfterCleaned) {
        this.base64StringCoolingCoilPhotoAfterCleaned = base64StringCoolingCoilPhotoAfterCleaned;
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

    public String getIfAnyNoiseIndoorMotor() {
        return ifAnyNoiseIndoorMotor;
    }

    public void setIfAnyNoiseIndoorMotor(String ifAnyNoiseIndoorMotor) {
        this.ifAnyNoiseIndoorMotor = ifAnyNoiseIndoorMotor;
    }

    public String getOutdoorFanMotorCondition() {
        return outdoorFanMotorCondition;
    }

    public void setOutdoorFanMotorCondition(String outdoorFanMotorCondition) {
        this.outdoorFanMotorCondition = outdoorFanMotorCondition;
    }

    public String getFanLeafCondition() {
        return fanLeafCondition;
    }

    public void setFanLeafCondition(String fanLeafCondition) {
        this.fanLeafCondition = fanLeafCondition;
    }

    public String getIfAnyNoiseOutdoorMotor() {
        return ifAnyNoiseOutdoorMotor;
    }

    public void setIfAnyNoiseOutdoorMotor(String ifAnyNoiseOutdoorMotor) {
        this.ifAnyNoiseOutdoorMotor = ifAnyNoiseOutdoorMotor;
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

    public String getIfAnyVibrationOfAc() {
        return ifAnyVibrationOfAc;
    }

    public void setIfAnyVibrationOfAc(String ifAnyVibrationOfAc) {
        this.ifAnyVibrationOfAc = ifAnyVibrationOfAc;
    }

    public String getFreeCoolingUnitStatus() {
        return freeCoolingUnitStatus;
    }

    public void setFreeCoolingUnitStatus(String freeCoolingUnitStatus) {
        this.freeCoolingUnitStatus = freeCoolingUnitStatus;
    }

    public String getIfFreeCoolingAvaibleWorkingStatus() {
        return ifFreeCoolingAvaibleWorkingStatus;
    }

    public void setIfFreeCoolingAvaibleWorkingStatus(String ifFreeCoolingAvaibleWorkingStatus) {
        this.ifFreeCoolingAvaibleWorkingStatus = ifFreeCoolingAvaibleWorkingStatus;
    }

    public String getWaterLeakageIfAny() {
        return waterLeakageIfAny;
    }

    public void setWaterLeakageIfAny(String waterLeakageIfAny) {
        this.waterLeakageIfAny = waterLeakageIfAny;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}