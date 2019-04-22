
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmNoOfAcAvailableAtSite;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmServoStabilizerWorkingStatus;

public class PreventiveMaintanceSiteTransactionDetails implements Serializable {

    @SerializedName("AccessToken")
    @Expose
    private String accessToken;
    @SerializedName("UserId")
    @Expose
    private String userId;
    /*@SerializedName("checkInBatteryData")
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
    private String checkOutBatteryData;*/
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
    @SerializedName("sitePMTicketId")
    @Expose
    private String sitePMTicketId;
    @SerializedName("ticketNo")
    @Expose
    private String ticketNo;
    @SerializedName("siteHygenieneGenralSeftyParameter")
    @Expose
    private SiteHygenieneGenralSeftyParameter siteHygenieneGenralSeftyParameter;
    @SerializedName("alarmCheckPoints")
    @Expose
    private AlarmCheckPoints alarmCheckPoints;
    @SerializedName("batteryBankCheckPointsParentData")
    @Expose
    private BatteryBankCheckPointsParentData batteryBankCheckPointsParentData;
    @SerializedName("earthingCheckPointsParentData")
    @Expose
    private EarthingCheckPointsParentData EarthingCheckPointsParentData;
    @SerializedName("ebMeterBox")
    @Expose
    private EbMeterBox ebMeterBox;

    @SerializedName("dgCheckPointsParentData")
    @Expose
    private DgCheckPointsParentData dgCheckPointsParentData;

    @SerializedName("dgBatteryCheckPointsParentData")
    @Expose
    private DgBatteryCheckPointsParentData dgBatteryCheckPointsParentData;

    @SerializedName("otherElectricalCheckPoints")
    @Expose
    private OtherElectricalCheckPoints otherElectricalCheckPoints;

    @SerializedName("shelterCheckPoints")
    @Expose
    private ShelterCheckPoints shelterCheckPoints;
    @SerializedName("servoCheckPoints")
    @Expose
    private ServoCheckPoints servoCheckPoints;
    @SerializedName("pmsAmfPanelCheckPoints")
    @Expose
    private PmsAmfPanelCheckPointsParentData pmsAmfPanelCheckPoints;

    @SerializedName("rectifierModuleCheckPoint")
    @Expose
    private RectifierModuleCheckPointParentData rectifierModuleCheckPoint;

    @SerializedName("smpsCheckPointParentData")
    @Expose
    private SmpsCheckPointParentData smpsCheckPointParentData;
    //private SmpsCheckPointParentData smpsCheckPoints;

    @SerializedName("acCheckPointParentData")
    private AcCheckPointParentData acCheckPointParentData;

    public PreventiveMaintanceSiteTransactionDetails() {
        siteHygenieneGenralSeftyParameter = new SiteHygenieneGenralSeftyParameter();
        alarmCheckPoints = new AlarmCheckPoints();
        batteryBankCheckPointsParentData = new BatteryBankCheckPointsParentData();
        EarthingCheckPointsParentData = new EarthingCheckPointsParentData();
        ebMeterBox = new EbMeterBox();
        dgCheckPointsParentData = new DgCheckPointsParentData();
        dgBatteryCheckPointsParentData = new DgBatteryCheckPointsParentData();
        dgCheckPointsParentData = new DgCheckPointsParentData();
        dgBatteryCheckPointsParentData = new DgBatteryCheckPointsParentData();
        acCheckPointParentData = new AcCheckPointParentData();
        smpsCheckPointParentData = new SmpsCheckPointParentData();
        rectifierModuleCheckPoint = new RectifierModuleCheckPointParentData();
        pmsAmfPanelCheckPoints = new PmsAmfPanelCheckPointsParentData();
        servoCheckPoints = new ServoCheckPoints();
        shelterCheckPoints = new ShelterCheckPoints();
        otherElectricalCheckPoints = new OtherElectricalCheckPoints();
    }

    public PreventiveMaintanceSiteTransactionDetails(String userId, String accessToken, String ticketId, String checkInLat, String checkInLong, String checkInBatteryData, String checkOutLat, String checkOutLong, String checkOutBatteryData) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.sitePMTicketId = ticketId;
        /*this.checkInLongitude = checkInLat;
        this.checkInLongitude = checkInLong;
        this.checkInBatteryData = checkInBatteryData;*/
        this.checkOutLongitude = checkOutLong;
        this.checkOutLatitude = checkOutLat;
        /*this.checkOutBatteryData = checkOutBatteryData;*/
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

    /*public String getCheckInBatteryData() {
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
    }*/

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
        return sitePMTicketId;
    }

    public void setTicketId(String ticketId) {
        this.sitePMTicketId = ticketId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public SiteHygenieneGenralSeftyParameter getSiteHygenieneGenralSeftyParameter() {
        return siteHygenieneGenralSeftyParameter;
    }

    public void setSiteHygenieneGenralSeftyParameter(SiteHygenieneGenralSeftyParameter siteHygenieneGenralSeftyParameter) {
        this.siteHygenieneGenralSeftyParameter = siteHygenieneGenralSeftyParameter;
    }

    public AlarmCheckPoints getAlarmCheckPoints() {
        return alarmCheckPoints;
    }

    public void setAlarmCheckPoints(AlarmCheckPoints alarmCheckPoints) {
        this.alarmCheckPoints = alarmCheckPoints;
    }

    public BatteryBankCheckPointsParentData getBatteryBankCheckPointsParentData() {
        return batteryBankCheckPointsParentData;
    }

    public void setBatteryBankCheckPointsParentData(BatteryBankCheckPointsParentData batteryBankCheckPointsParentData) {
        this.batteryBankCheckPointsParentData = batteryBankCheckPointsParentData;
    }

    public EarthingCheckPointsParentData getEarthingCheckPointsParentData() {
        return EarthingCheckPointsParentData;
    }

    public void setEarthingCheckPointsParentData(EarthingCheckPointsParentData EarthingCheckPointsParentData) {
        this.EarthingCheckPointsParentData = EarthingCheckPointsParentData;
    }

    public EbMeterBox getEbMeterBox() {
        return ebMeterBox;
    }

    public void setEbMeterBox(EbMeterBox ebMeterBox) {
        this.ebMeterBox = ebMeterBox;
    }

    public DgCheckPointsParentData getDgCheckPointsParentData() {
        return dgCheckPointsParentData;
    }

    public void setDgCheckPointsParentData(DgCheckPointsParentData dgCheckPointsParentData) {
        this.dgCheckPointsParentData = dgCheckPointsParentData;
    }

    public OtherElectricalCheckPoints getOtherElectricalCheckPoints() {
        return otherElectricalCheckPoints;
    }

    public void setOtherElectricalCheckPoints(OtherElectricalCheckPoints otherElectricalCheckPoints) {
        this.otherElectricalCheckPoints = otherElectricalCheckPoints;
    }

    public ShelterCheckPoints getShelterCheckPoints() {
        return shelterCheckPoints;
    }

    public void setShelterCheckPoints(ShelterCheckPoints shelterCheckPoints) {
        this.shelterCheckPoints = shelterCheckPoints;
    }

    public ServoCheckPoints getServoCheckPoints() {
        return servoCheckPoints;
    }

    public void setServoCheckPoints(ServoCheckPoints servoCheckPoints) {
        this.servoCheckPoints = servoCheckPoints;
    }

    public PmsAmfPanelCheckPointsParentData getPmsAmfPanelCheckPoints() {
        return pmsAmfPanelCheckPoints;
    }

    public void setPmsAmfPanelCheckPoints(PmsAmfPanelCheckPointsParentData pmsAmfPanelCheckPoints) {
        this.pmsAmfPanelCheckPoints = pmsAmfPanelCheckPoints;
    }

    public RectifierModuleCheckPointParentData getRectifierModuleCheckPoint() {
        return rectifierModuleCheckPoint;
    }

    public void setRectifierModuleCheckPoint(RectifierModuleCheckPointParentData rectifierModuleCheckPoint) {
        this.rectifierModuleCheckPoint = rectifierModuleCheckPoint;
    }

    public SmpsCheckPointParentData getSmpsCheckPointParentData() {
        return smpsCheckPointParentData;
    }

    public void setSmpsCheckPointParentData(SmpsCheckPointParentData smpsCheckPointParentData) {
        this.smpsCheckPointParentData = smpsCheckPointParentData;
    }

    public AcCheckPointParentData getAcCheckPointParentData() {
        return acCheckPointParentData;
    }

    public void setAcCheckPointParentData(AcCheckPointParentData acCheckPointParentData) {
        this.acCheckPointParentData = acCheckPointParentData;
    }

    public DgBatteryCheckPointsParentData getDgBatteryCheckPointsParentData() {
        return dgBatteryCheckPointsParentData;
    }

    public void setDgBatteryCheckPointsParentData(DgBatteryCheckPointsParentData dgBatteryCheckPointsParentData) {
        this.dgBatteryCheckPointsParentData = dgBatteryCheckPointsParentData;
    }

    public int isAtLeastOneSitePmFormsSubmit() {

        if (hototicket_sourceOfPower.equals("Non DG")) {
            dgCheckPointsParentData.setSubmited(2);
            dgBatteryCheckPointsParentData.setSubmited(2);
        }

        if (sitePmNoOfAcAvailableAtSite.equals("0")) {
            acCheckPointParentData.setSubmited(2);
        }

        if (sitePmServoStabilizerWorkingStatus.equals("Not Available")) {
            servoCheckPoints.setSubmited(2);
        }

        if (hototicket_Selected_SiteType.equals("Outdoor")) {
            shelterCheckPoints.setSubmited(2);
        }

        /*if (siteHygenieneGenralSeftyParameter.getSubmited() == 2) {
            return true;
        } else if (acCheckPointParentData.getSubmited() == 2) {
            return true;
        } else if (batteryBankCheckPointsParentData.getSubmited() == 2) {
            return true;
        } else if (EarthingCheckPointsParentData.getSubmited() == 2) {
            return true;
        } else if (ebMeterBox.getSubmited() == 2) {
            return true;
        } else if (dgBatteryCheckPointsParentData.getSubmited() == 2) {
            return true;
        } else if (dgCheckPointsParentData.getSubmited() == 2) {
            return true;
        } else if (alarmCheckPoints.getSubmited() == 2) {
            return true;
        } else if (smpsCheckPointParentData.getSubmited() == 2) {
            return true;
        } else if (rectifierModuleCheckPoint.getSubmited() == 2) {
            return true;
        } else if (pmsAmfPanelCheckPoints.getSubmited() == 2) {
            return true;
        } else if (servoCheckPoints.getSubmited() == 2) {
            return true;
        } else if (shelterCheckPoints.getSubmited() == 2) {
            return true;
        } else if (otherElectricalCheckPoints.getSubmited() == 2) {
            return true;
        }  else return false;*/

        int flag = 0;

        if (siteHygenieneGenralSeftyParameter.getSubmited() == 0 ||
                acCheckPointParentData.getSubmited() == 0 ||
                batteryBankCheckPointsParentData.getSubmited() == 0 ||
                EarthingCheckPointsParentData.getSubmited() == 0 ||
                ebMeterBox.getSubmited() == 0 ||
                dgBatteryCheckPointsParentData.getSubmited() == 0 ||
                dgCheckPointsParentData.getSubmited() == 0 ||
                alarmCheckPoints.getSubmited() == 0 ||
                smpsCheckPointParentData.getSubmited() == 0 ||
                rectifierModuleCheckPoint.getSubmited() == 0 ||
                pmsAmfPanelCheckPoints.getSubmited() == 0 ||
                servoCheckPoints.getSubmited() == 0 ||
                shelterCheckPoints.getSubmited() == 0 ||
                otherElectricalCheckPoints.getSubmited() == 0
                ) {
            flag = 0;
        } else if (siteHygenieneGenralSeftyParameter.getSubmited() == 1 ||
                acCheckPointParentData.getSubmited() == 1 ||
                batteryBankCheckPointsParentData.getSubmited() == 1 ||
                EarthingCheckPointsParentData.getSubmited() == 1 ||
                ebMeterBox.getSubmited() == 1 ||
                dgBatteryCheckPointsParentData.getSubmited() == 1 ||
                dgCheckPointsParentData.getSubmited() == 1 ||
                alarmCheckPoints.getSubmited() == 1 ||
                smpsCheckPointParentData.getSubmited() == 1 ||
                rectifierModuleCheckPoint.getSubmited() == 1 ||
                pmsAmfPanelCheckPoints.getSubmited() == 1 ||
                servoCheckPoints.getSubmited() == 1 ||
                shelterCheckPoints.getSubmited() == 1 ||
                otherElectricalCheckPoints.getSubmited() == 1
                ) {
            flag = 1;
        } else if (siteHygenieneGenralSeftyParameter.getSubmited() == 2 &&
                acCheckPointParentData.getSubmited() == 2 &&
                batteryBankCheckPointsParentData.getSubmited() == 2 &&
                EarthingCheckPointsParentData.getSubmited() == 2 &&
                ebMeterBox.getSubmited() == 2 &&
                dgBatteryCheckPointsParentData.getSubmited() == 2 &&
                dgCheckPointsParentData.getSubmited() == 2 &&
                alarmCheckPoints.getSubmited() == 2 &&
                smpsCheckPointParentData.getSubmited() == 2 &&
                rectifierModuleCheckPoint.getSubmited() == 2 &&
                pmsAmfPanelCheckPoints.getSubmited() == 2 &&
                servoCheckPoints.getSubmited() == 2 &&
                shelterCheckPoints.getSubmited() == 2 &&
                otherElectricalCheckPoints.getSubmited() == 2
                ) {
            flag = 2;
        }
        return flag;
    }


   /* public boolean isAllPreventiveMaintainanceFormSubmitted()
    {
        if(siteHygenieneGenralSeftyParameter)
    }*/

}
