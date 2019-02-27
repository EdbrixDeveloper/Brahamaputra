package com.brahamaputra.mahindra.brahamaputra.Data;

import com.brahamaputra.mahindra.brahamaputra.Utils.Constants;
import com.google.gson.annotations.SerializedName;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;

public class HotoTransactionData {

    @SerializedName("UserId")
    private String UserId;

    @SerializedName("AccessToken")
    private String AccessToken;

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

    private LandDetailsData landDetailsData;
    private TowerDetailsData towerDetailsData;
    private EarthResistanceTowerData earthResistanceTowerData;
    private EarthResistanceEquipmentData earthResistanceEquipmentData;
    private ElectricConnectionData electricConnectionData;
    private AirConditionParentData airConditionParentData;
    private SolarPowerSystemData solarPowerSystemData;
    private PowerPlantDetailsParentData powerPlantDetailsParentData;
    private PowerBackupsDGParentData powerBackupsDGParentData;
    private ShelterData shelterData;
    private MediaData mediaData;
    private BatterySetParentData batterySetParentData;
    private ExternalTenantsPersonalDetailsParentData externalTenantsPersonalDetailsParentData;
    private TotalDCLoadofSiteData totalDCLoadofSiteData;
    private ActiveequipmentDetailsData activeequipmentDetailsData;
    private PowerManagementSystemData powerManagementSystemData;
    //private GeneralSafetyMeasuresData generalSafetyMeasuresData;
    private GeneralSafetyMeasuresParentData generalSafetyMeasuresParentData;
    private ACDB_DCDB_Data acdb_dcdb_data;
    private ServoStabilizerData servoStabilizerData;
    //private DetailsOfUnusedMaterialsData detailsOfUnusedMaterialsData;
    private DetailsOfUnusedMaterialsParentData detailsOfUnusedMaterialsParentData;

    public HotoTransactionData() {
        landDetailsData = new LandDetailsData();
        towerDetailsData = new TowerDetailsData();
        earthResistanceTowerData = new EarthResistanceTowerData();
        earthResistanceEquipmentData = new EarthResistanceEquipmentData();
        electricConnectionData = new ElectricConnectionData();
        airConditionParentData = new AirConditionParentData();
        solarPowerSystemData = new SolarPowerSystemData();
        powerPlantDetailsParentData = new PowerPlantDetailsParentData();
        powerBackupsDGParentData = new PowerBackupsDGParentData();
        shelterData = new ShelterData();
        mediaData = new MediaData();
        batterySetParentData = new BatterySetParentData();
        externalTenantsPersonalDetailsParentData = new ExternalTenantsPersonalDetailsParentData();
        totalDCLoadofSiteData = new TotalDCLoadofSiteData();
        activeequipmentDetailsData = new ActiveequipmentDetailsData();
        powerManagementSystemData = new PowerManagementSystemData();
        generalSafetyMeasuresParentData = new GeneralSafetyMeasuresParentData();
        acdb_dcdb_data = new ACDB_DCDB_Data();
        servoStabilizerData = new ServoStabilizerData();
        detailsOfUnusedMaterialsParentData = new DetailsOfUnusedMaterialsParentData();
        sitePhotoCaptureData = new SitePhotoCaptureData();
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

    public SitePhotoCaptureData getSitePhotoCaptureData() {
        return sitePhotoCaptureData;
    }

    public void setSitePhotoCaptureData(SitePhotoCaptureData sitePhotoCaptureData) {
        this.sitePhotoCaptureData = sitePhotoCaptureData;
    }

    private SitePhotoCaptureData sitePhotoCaptureData;

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

    public AirConditionParentData getAirConditionParentData() {
        return airConditionParentData;
    }

    public void setAirConditionParentData(AirConditionParentData airConditionParentData) {
        this.airConditionParentData = airConditionParentData;
    }

    public SolarPowerSystemData getSolarPowerSystemData() {
        return solarPowerSystemData;
    }

    public void setSolarPowerSystemData(SolarPowerSystemData solarPowerSystemData) {
        this.solarPowerSystemData = solarPowerSystemData;
    }

    public PowerPlantDetailsParentData getPowerPlantDetailsParentData() {
        return powerPlantDetailsParentData;
    }

    public void setPowerPlantDetailsParentData(PowerPlantDetailsParentData powerPlantDetailsParentData) {
        this.powerPlantDetailsParentData = powerPlantDetailsParentData;
    }

    public PowerBackupsDGParentData getPowerBackupsDGParentData() {
        return powerBackupsDGParentData;
    }

    public void setPowerBackupsDGParentData(PowerBackupsDGParentData powerBackupsDGParentData) {
        this.powerBackupsDGParentData = powerBackupsDGParentData;
    }

    public ShelterData getShelterData() {
        return shelterData;
    }

    public void setShelterData(ShelterData shelterData) {
        this.shelterData = shelterData;
    }

    public MediaData getMediaData() {
        return mediaData;
    }

    public void setMediaData(MediaData mediaData) {
        this.mediaData = mediaData;
    }

    public BatterySetParentData getBatterySetParentData() {
        return batterySetParentData;
    }

    public void setBatterySetParentData(BatterySetParentData batterySetParentData) {
        this.batterySetParentData = batterySetParentData;
    }

    public ExternalTenantsPersonalDetailsParentData getExternalTenantsPersonalDetailsParentData() {
        return externalTenantsPersonalDetailsParentData;
    }

    public void setExternalTenantsPersonalDetailsParentData(ExternalTenantsPersonalDetailsParentData externalTenantsPersonalDetailsParentData) {
        this.externalTenantsPersonalDetailsParentData = externalTenantsPersonalDetailsParentData;
    }

    public TotalDCLoadofSiteData getTotalDCLoadofSiteData() {
        return totalDCLoadofSiteData;
    }

    public void setTotalDCLoadofSiteData(TotalDCLoadofSiteData totalDCLoadofSiteData) {
        this.totalDCLoadofSiteData = totalDCLoadofSiteData;
    }

    public ActiveequipmentDetailsData getActiveequipmentDetailsData() {
        return activeequipmentDetailsData;
    }

    public void setActiveequipmentDetailsData(ActiveequipmentDetailsData activeequipmentDetailsData) {
        this.activeequipmentDetailsData = activeequipmentDetailsData;
    }

    public PowerManagementSystemData getPowerManagementSystemData() {
        return powerManagementSystemData;
    }

    public void setPowerManagementSystemData(PowerManagementSystemData powerManagementSystemData) {
        this.powerManagementSystemData = powerManagementSystemData;
    }

    /*public GeneralSafetyMeasuresData getGeneralSafetyMeasuresData() {
        return generalSafetyMeasuresData;
    }

    public void setGeneralSafetyMeasuresData(GeneralSafetyMeasuresData generalSafetyMeasuresData) {
        this.generalSafetyMeasuresData = generalSafetyMeasuresData;
    }*/

    public GeneralSafetyMeasuresParentData getGeneralSafetyMeasuresParentData() {
        return generalSafetyMeasuresParentData;
    }

    public void setGeneralSafetyMeasuresParentData(GeneralSafetyMeasuresParentData generalSafetyMeasuresParentData) {
        this.generalSafetyMeasuresParentData = generalSafetyMeasuresParentData;
    }

    public ACDB_DCDB_Data getAcdb_dcdb_data() {
        return acdb_dcdb_data;
    }

    public void setAcdb_dcdb_data(ACDB_DCDB_Data acdb_dcdb_data) {
        this.acdb_dcdb_data = acdb_dcdb_data;
    }

    public ServoStabilizerData getServoStabilizerData() {
        return servoStabilizerData;
    }

    public void setServoStabilizerData(ServoStabilizerData servoStabilizerData) {
        this.servoStabilizerData = servoStabilizerData;
    }

    public DetailsOfUnusedMaterialsParentData getDetailsOfUnusedMaterialsParentData() {
        return detailsOfUnusedMaterialsParentData;
    }

    public void setDetailsOfUnusedMaterialsParentData(DetailsOfUnusedMaterialsParentData detailsOfUnusedMaterialsParentData) {
        this.detailsOfUnusedMaterialsParentData = detailsOfUnusedMaterialsParentData;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /*public boolean isAllHotoFormsSubmit() {
        if (landDetailsData.getSubmited() != 2 || landDetailsData.getSubmited() != 1) {
            return false;
        } else if (towerDetailsData.getSubmited() != 2 || towerDetailsData.getSubmited() != 1) {
            return false;
        } else if (earthResistanceTowerData.getSubmited() != 2 || earthResistanceTowerData.getSubmited() != 1) {
            return false;
        } else if (earthResistanceEquipmentData.getSubmited() != 2 || earthResistanceEquipmentData.getSubmited() != 1) {
            return false;
        } else if (electricConnectionData.getSubmited() != 2 || electricConnectionData.getSubmited() != 1) {
            return false;
        } else if (airConditionParentData.getSubmited() != 2 || airConditionParentData.getSubmited() != 1) {
            return false;
        } else if (solarPowerSystemData.getSubmited() != 2 || solarPowerSystemData.getSubmited() != 1) {
            return false;
        } else if (powerPlantDetailsParentData.getSubmited() != 2 || powerPlantDetailsParentData.getSubmited() != 1) {
            return false;
        } else if (powerBackupsDGParentData.getSubmited() != 2 || powerBackupsDGParentData.getSubmited() != 1) {
            return false;
        } else if (shelterData.getSubmited() != 2 || shelterData.getSubmited() != 1) {
            return false;
        } else if (mediaData.getSubmited() != 2 || mediaData.getSubmited() != 1) {
            return false;
        } else if (batterySetParentData.getSubmited() != 2 || batterySetParentData.getSubmited() != 1) {
            return false;
        } else if (externalTenantsPersonalDetailsParentData.getSubmited() != 2 || externalTenantsPersonalDetailsParentData.getSubmited() != 1) {
            return false;
        } else if (totalDCLoadofSiteData.getSubmited() != 2 || totalDCLoadofSiteData.getSubmited() != 1) {
            return false;
        } else if (activeequipmentDetailsData.getSubmited() != 2 || activeequipmentDetailsData.getSubmited() != 1) {
            return false;
        } else if (powerManagementSystemData.getSubmited() != 2 || powerManagementSystemData.getSubmited() != 1) {
            return false;
        } else if (generalSafetyMeasuresParentData.getSubmited() != 2 || generalSafetyMeasuresParentData.getSubmited() != 1) {
            return false;
        } else if (acdb_dcdb_data.getSubmited() != 2 || acdb_dcdb_data.getSubmited() != 1) {
            return false;
        } else if (servoStabilizerData.getSubmited() != 2 || servoStabilizerData.getSubmited() != 1) {
            return false;
        } else if (detailsOfUnusedMaterialsParentData.getSubmited() != 2 || detailsOfUnusedMaterialsParentData.getSubmited() != 1) {
            return false;
        } else if (sitePhotoCaptureData.getSubmited() != 2 || sitePhotoCaptureData.getSubmited() != 1) {
            return false;
        } else return true;
    }*/

    public boolean isAllHotoFormsSubmit() {

        if ((landDetailsData.getSubmited() == 2) &&
                (towerDetailsData.getSubmited() == 2) &&
                (earthResistanceTowerData.getSubmited() == 2) &&
                (earthResistanceEquipmentData.getSubmited() == 2)
                && (electricConnectionData.getSubmited() == 2) &&
                (airConditionParentData.getSubmited() == 2) &&
                (solarPowerSystemData.getSubmited() == 2) &&
                (powerPlantDetailsParentData.getSubmited() == 2) &&
                (powerBackupsDGParentData.getSubmited() == 2) &&
                (shelterData.getSubmited() == 2) &&
                (mediaData.getSubmited() == 2) &&
                (batterySetParentData.getSubmited() == 2) &&
                (externalTenantsPersonalDetailsParentData.getSubmited() == 2) &&
                (totalDCLoadofSiteData.getSubmited() == 2) &&
                (activeequipmentDetailsData.getSubmited() == 2) &&
                (powerManagementSystemData.getSubmited() == 2) &&
                (generalSafetyMeasuresParentData.getSubmited() == 2) &&
                (acdb_dcdb_data.getSubmited() == 2) &&
                (servoStabilizerData.getSubmited() == 2) &&
                (detailsOfUnusedMaterialsParentData.getSubmited() == 2) &&
                (sitePhotoCaptureData.getSubmited() == 2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtLeastOneHotoFormsSubmit() {
        /*if (landDetailsData.getSubmited() == 2 || landDetailsData.getSubmited() == 1) {
            return true;
        } else if (towerDetailsData.getSubmited() == 2 || towerDetailsData.getSubmited() == 1) {
            return true;
        } else if (earthResistanceTowerData.getSubmited() == 2 || earthResistanceTowerData.getSubmited() == 1) {
            return true;
        } else if (earthResistanceEquipmentData.getSubmited() == 2 || earthResistanceEquipmentData.getSubmited() == 1) {
            return true;
        } else if (electricConnectionData.getSubmited() == 2 || electricConnectionData.getSubmited() == 1) {
            return true;
        }else if (airConditionParentData.getSubmited() == 2 || airConditionParentData.getSubmited() == 1) {
            return true;
        } else if (solarPowerSystemData.getSubmited() == 2 || solarPowerSystemData.getSubmited() == 1) {
            return true;
        } else if (powerPlantDetailsParentData.getSubmited() == 2 || powerPlantDetailsParentData.getSubmited() == 1) {
            return true;
        } else if (powerBackupsDGParentData.getSubmited() == 2 || powerBackupsDGParentData.getSubmited() == 1) {
            return true;
        } else if (shelterData.getSubmited() == 2 || shelterData.getSubmited() == 1) {
            return true;
        } else if (mediaData.getSubmited() == 2 || mediaData.getSubmited() == 1) {
            return true;
        } else if (batterySetParentData.getSubmited() == 2 || batterySetParentData.getSubmited() == 1) {
            return true;
        } else if (externalTenantsPersonalDetailsParentData.getSubmited() == 2 || externalTenantsPersonalDetailsParentData.getSubmited() == 1) {
            return true;
        } else if (totalDCLoadofSiteData.getSubmited() == 2 || totalDCLoadofSiteData.getSubmited() == 1) {
            return true;
        }  else if (activeequipmentDetailsData.getSubmited() == 2 || activeequipmentDetailsData.getSubmited() == 1) {
            return true;
        } else if (powerManagementSystemData.getSubmited() == 2 || powerManagementSystemData.getSubmited() == 1) {
            return true;
        } else if (generalSafetyMeasuresParentData.getSubmited() == 2 || generalSafetyMeasuresParentData.getSubmited() == 1) {
            return true;
        } else if (acdb_dcdb_data.getSubmited() == 2 || acdb_dcdb_data.getSubmited() == 1) {
            return true;
        } else if (servoStabilizerData.getSubmited() == 2 || servoStabilizerData.getSubmited() == 1) {
            return true;
        } else if (detailsOfUnusedMaterialsParentData.getSubmited() == 2 || detailsOfUnusedMaterialsParentData.getSubmited() == 1) {
            return true;
        } else if (sitePhotoCaptureData.getSubmited() == 2 || sitePhotoCaptureData.getSubmited() == 1) {
            return true;
        } else return false;*/

        if (hototicket_sourceOfPower.equals("Non EB")) {
            electricConnectionData.setSubmited(2);
        }

        if ((landDetailsData.getSubmited() == 2 || landDetailsData.getSubmited() == 1) &&
                (towerDetailsData.getSubmited() == 2 || towerDetailsData.getSubmited() == 1) &&
                (earthResistanceTowerData.getSubmited() == 2 || earthResistanceTowerData.getSubmited() == 1) &&
                (earthResistanceEquipmentData.getSubmited() == 2 || earthResistanceEquipmentData.getSubmited() == 1)
                && (electricConnectionData.getSubmited() == 2 || electricConnectionData.getSubmited() == 1) &&
                (airConditionParentData.getSubmited() == 2 || airConditionParentData.getSubmited() == 1) &&
                (solarPowerSystemData.getSubmited() == 2 || solarPowerSystemData.getSubmited() == 1) &&
                (powerPlantDetailsParentData.getSubmited() == 2 || powerPlantDetailsParentData.getSubmited() == 1) &&
                (powerBackupsDGParentData.getSubmited() == 2 || powerBackupsDGParentData.getSubmited() == 1) &&
                (shelterData.getSubmited() == 2 || shelterData.getSubmited() == 1) &&
                (mediaData.getSubmited() == 2 || mediaData.getSubmited() == 1) &&
                (batterySetParentData.getSubmited() == 2 || batterySetParentData.getSubmited() == 1) &&
                (externalTenantsPersonalDetailsParentData.getSubmited() == 2 || externalTenantsPersonalDetailsParentData.getSubmited() == 1) &&
                (totalDCLoadofSiteData.getSubmited() == 2 || totalDCLoadofSiteData.getSubmited() == 1) &&
                (activeequipmentDetailsData.getSubmited() == 2 || activeequipmentDetailsData.getSubmited() == 1) &&
                (powerManagementSystemData.getSubmited() == 2 || powerManagementSystemData.getSubmited() == 1) &&
                (generalSafetyMeasuresParentData.getSubmited() == 2 || generalSafetyMeasuresParentData.getSubmited() == 1) &&
                (acdb_dcdb_data.getSubmited() == 2 || acdb_dcdb_data.getSubmited() == 1) &&
                (servoStabilizerData.getSubmited() == 2 || servoStabilizerData.getSubmited() == 1) &&
                (detailsOfUnusedMaterialsParentData.getSubmited() == 2 || detailsOfUnusedMaterialsParentData.getSubmited() == 1) &&
                (sitePhotoCaptureData.getSubmited() == 2 || sitePhotoCaptureData.getSubmited() == 1)) {
            return true;
        } else {
            return false;
        }
    }
}
