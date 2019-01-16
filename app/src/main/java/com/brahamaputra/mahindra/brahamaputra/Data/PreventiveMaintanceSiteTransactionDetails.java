
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreventiveMaintanceSiteTransactionDetails implements Serializable {

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
    @SerializedName("siteHygenieneGenralSeftyParameter")
    @Expose
    private SiteHygenieneGenralSeftyParameter siteHygenieneGenralSeftyParameter;
    @SerializedName("alarmCheckPoints")
    @Expose
    private AlarmCheckPoints alarmCheckPoints;
    @SerializedName("batteryBankCheckPoints")
    @Expose
    private BatteryBankCheckPointsParentData batteryBankCheckPoints;
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
    private SmpsCheckPointParentData smpsCheckPoints;

    private SmpsCheckPointParentData smpsCheckPointParentData;
    @SerializedName("acCheckPointParentData")
    private AcCheckPointParentData acCheckPointParentData;

    // private final static long serialVersionUID = 4468678041836209812L;

    public PreventiveMaintanceSiteTransactionDetails() {
        siteHygenieneGenralSeftyParameter = new SiteHygenieneGenralSeftyParameter();
        alarmCheckPoints = new AlarmCheckPoints();
        batteryBankCheckPoints = new BatteryBankCheckPointsParentData();
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

    public BatteryBankCheckPointsParentData getBatteryBankCheckPoints() {
        return batteryBankCheckPoints;
    }

    public void setBatteryBankCheckPoints(BatteryBankCheckPointsParentData batteryBankCheckPoints) {
        this.batteryBankCheckPoints = batteryBankCheckPoints;
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

   /* public boolean isAllPreventiveMaintainanceFormSubmitted()
    {
        if(siteHygenieneGenralSeftyParameter)
    }*/

}
