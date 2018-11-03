package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class HotoTransactionData {


    @SerializedName("ticketId")
    private String ticketId;

    @SerializedName("ticketNo")
    private String ticketNo;

    @SerializedName("checkInLatitude")
    private String checkInLatitude;

    @SerializedName("checkInLongitude")
    private String checkInLongitude;

    @SerializedName("checkInBatteryData")
    private String checkInBatteryData;

    @SerializedName("siteAddress")
    private String siteAddress;

    @SerializedName("sourceOfTower")
    private String sourceOfTower;

    @SerializedName("checkOutLatitude")
    private String checkOutLatitude;

    @SerializedName("checkOutLongitude")
    private String checkOutLongitude;

    @SerializedName("checkOutBatteryData")
    private String checkOutBatteryData;

    private LandDetailsData landDetailsData;
    private TowerDetailsData towerDetailsData;
    private EarthResistanceTowerData earthResistanceTowerData;
    private EarthResistanceEquipmentData earthResistanceEquipmentData;
    private ElectricConnectionData electricConnectionData;
    private AirConditionersData airConditionersData;
    private SolarPowerSystemData solarPowerSystemData;
    private PowerPlantDetailsData powerPlantDetailsData;
    private PowerBackupsDGData powerBackupsDGData;
    private ShelterData shelterData;

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

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSourceOfTower() {
        return sourceOfTower;
    }

    public void setSourceOfTower(String sourceOfTower) {
        this.sourceOfTower = sourceOfTower;
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

    public String getCheckOutBatteryData() {
        return checkOutBatteryData;
    }

    public void setCheckOutBatteryData(String checkOutBatteryData) {
        this.checkOutBatteryData = checkOutBatteryData;
    }

    public LandDetailsData getLandDetailsData() {
        return landDetailsData;
    }

    public void setLandDetailsData(LandDetailsData landDetailsData) {
        this.landDetailsData = landDetailsData;
    }

    public TowerDetailsData getTowerDetailsData() {
        return towerDetailsData;
    }

    public void setTowerDetailsData(TowerDetailsData towerDetailsData) {
        this.towerDetailsData = towerDetailsData;
    }

    public EarthResistanceTowerData getEarthResistanceTowerData() {
        return earthResistanceTowerData;
    }

    public void setEarthResistanceTowerData(EarthResistanceTowerData earthResistanceTowerData) {
        this.earthResistanceTowerData = earthResistanceTowerData;
    }

    public EarthResistanceEquipmentData getEarthResistanceEquipmentData() {
        return earthResistanceEquipmentData;
    }

    public void setEarthResistanceEquipmentData(EarthResistanceEquipmentData earthResistanceEquipmentData) {
        this.earthResistanceEquipmentData = earthResistanceEquipmentData;
    }

    public ElectricConnectionData getElectricConnectionData() {
        return electricConnectionData;
    }

    public void setElectricConnectionData(ElectricConnectionData electricConnectionData) {
        this.electricConnectionData = electricConnectionData;
    }

    public AirConditionersData getAirConditionersData() {
        return airConditionersData;
    }

    public void setAirConditionersData(AirConditionersData airConditionersData) {
        this.airConditionersData = airConditionersData;
    }

    public SolarPowerSystemData getSolarPowerSystemData() {
        return solarPowerSystemData;
    }

    public void setSolarPowerSystemData(SolarPowerSystemData solarPowerSystemData) {
        this.solarPowerSystemData = solarPowerSystemData;
    }

    public PowerPlantDetailsData getPowerPlantDetailsData() {
        return powerPlantDetailsData;
    }

    public void setPowerPlantDetailsData(PowerPlantDetailsData powerPlantDetailsData) {
        this.powerPlantDetailsData = powerPlantDetailsData;
    }

    public PowerBackupsDGData getPowerBackupsDGData() {
        return powerBackupsDGData;
    }

    public void setPowerBackupsDGData(PowerBackupsDGData powerBackupsDGData) {
        this.powerBackupsDGData = powerBackupsDGData;
    }

    public ShelterData getShelterData() {
        return shelterData;
    }

    public void setShelterData(ShelterData shelterData) {
        this.shelterData = shelterData;
    }
}
