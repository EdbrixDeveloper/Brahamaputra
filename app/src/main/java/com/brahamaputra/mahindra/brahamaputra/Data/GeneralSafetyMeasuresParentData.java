package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GeneralSafetyMeasuresParentData {

    @SerializedName("prevailingSLA")
    private String prevailingSLA;

    @SerializedName("siteBoundaryStatus")
    private String siteBoundaryStatus;

    @SerializedName("siteHygieneVegitationStatus")
    private String siteHygieneVegitationStatus;

    @SerializedName("gateLock")
    private String gateLock;

    @SerializedName("dgRoomLock")
    private String dgRoomLock;

    @SerializedName("fireExtuinguisher")
    private String fireExtuinguisher;

    @SerializedName("noOfFireExtuinguisher")
    private String noOfFireExtuinguisher;

    @SerializedName("fireBucket")
    private String fireBucket;

    @SerializedName("securityStatus")
    private String securityStatus;

    @SerializedName("noofSecurityPerson")
    private String noofSecurityPerson;

    @SerializedName("mobileNumberofSecurity")
    private String mobileNumberofSecurity;

    @SerializedName("caretakerStatusUpOnEmergency")
    private String caretakerStatusUpOnEmergency;

    @SerializedName("mobileNumberofCaretaker")
    private String mobileNumberofCaretaker;

    @SerializedName("isSecurityCaretakeristheOwnerofSite")
    private String isSecurityCaretakeristheOwnerofSite;

    @SerializedName("salaryofSecurityCaretaker")
    private String salaryofSecurityCaretaker;

    @SerializedName("caretakerSecuritySalaryPaidBy")
    private String caretakerSecuritySalaryPaidBy;

    @SerializedName("caretakerSecurityStayinginSite")
    private String caretakerSecurityStayinginSite;

    @SerializedName("numberofEarthPit")
    private String numberofEarthPit;

    @SerializedName("lightningArresterStatus")
    private String lightningArresterStatus;


    @SerializedName("fencingCompoundWallCondition")
    private String fencingCompoundWallCondition;

    @SerializedName("numberoffreeODPaltformAvailable")
    private String numberoffreeODPaltformAvailable;

    @SerializedName("alarmMultipluxerStatus")
    private String alarmMultipluxerStatus;

    @SerializedName("doorOpenSensor")
    private String doorOpenSensor;

    @SerializedName("fuelSensor")
    private String fuelSensor;

    @SerializedName("fireSmokeSensor")
    private String fireSmokeSensor;

    @SerializedName("agencyName")
    private String agencyName;

    @SerializedName("siteAccessStatus")
    private String siteAccessStatus;

    @SerializedName("generalSafetyMeasuresData")
    ArrayList<GeneralSafetyMeasuresData> generalSafetyMeasuresData;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;


    public GeneralSafetyMeasuresParentData() {
        this.prevailingSLA = "";
        this.siteBoundaryStatus = "";
        this.siteHygieneVegitationStatus = "";
        this.gateLock = "";
        this.dgRoomLock = "";
        this.fireExtuinguisher = "";
        this.noOfFireExtuinguisher = "";
        this.fireBucket = "";
        this.securityStatus = "";
        this.noofSecurityPerson = "";
        this.mobileNumberofSecurity = "";
        this.caretakerStatusUpOnEmergency = "";
        this.mobileNumberofCaretaker = "";
        this.isSecurityCaretakeristheOwnerofSite = "";
        this.salaryofSecurityCaretaker = "";
        this.caretakerSecuritySalaryPaidBy = "";
        this.caretakerSecurityStayinginSite = "";
        this.numberofEarthPit = "";
        this.lightningArresterStatus = "";
        this.fencingCompoundWallCondition = "";
        this.numberoffreeODPaltformAvailable = "";
        this.alarmMultipluxerStatus = "";
        this.doorOpenSensor = "";
        this.fuelSensor = "";
        this.fireSmokeSensor = "";
        this.isSubmited = 0;
        this.agencyName = "";
        this.siteAccessStatus="";
        this.generalSafetyMeasuresData = new ArrayList<>();
    }


    public GeneralSafetyMeasuresParentData(String prevailingSLA, String siteBoundaryStatus, String siteHygieneVegitationStatus, String gateLock, String dgRoomLock, String fireExtuinguisher, String noOfFireExtuinguisher, String fireBucket, String securityStatus, String noofSecurityPerson, String mobileNumberofSecurity, String caretakerStatusUpOnEmergency, String mobileNumberofCaretaker, String isSecurityCaretakeristheOwnerofSite, String salaryofSecurityCaretaker, String caretakerSecuritySalaryPaidBy, String caretakerSecurityStayinginSite, String numberofEarthPit, String lightningArresterStatus, String fencingCompoundWallCondition, String numberoffreeODPaltformAvailable, String alarmMultipluxerStatus, String doorOpenSensor, String fuelSensor, String fireSmokeSensor, String agencyName,String siteAccessStatus, ArrayList<GeneralSafetyMeasuresData> generalSafetyMeasuresData) {
        this.prevailingSLA = prevailingSLA;
        this.siteBoundaryStatus = siteBoundaryStatus;
        this.siteHygieneVegitationStatus = siteHygieneVegitationStatus;
        this.gateLock = gateLock;
        this.dgRoomLock = dgRoomLock;
        this.fireExtuinguisher = fireExtuinguisher;
        this.noOfFireExtuinguisher = noOfFireExtuinguisher;
        this.fireBucket = fireBucket;
        this.securityStatus = securityStatus;
        this.noofSecurityPerson = noofSecurityPerson;
        this.mobileNumberofSecurity = mobileNumberofSecurity;
        this.caretakerStatusUpOnEmergency = caretakerStatusUpOnEmergency;
        this.mobileNumberofCaretaker = mobileNumberofCaretaker;
        this.isSecurityCaretakeristheOwnerofSite = isSecurityCaretakeristheOwnerofSite;
        this.salaryofSecurityCaretaker = salaryofSecurityCaretaker;
        this.caretakerSecuritySalaryPaidBy = caretakerSecuritySalaryPaidBy;
        this.caretakerSecurityStayinginSite = caretakerSecurityStayinginSite;
        this.numberofEarthPit = numberofEarthPit;
        this.lightningArresterStatus = lightningArresterStatus;
        this.fencingCompoundWallCondition = fencingCompoundWallCondition;
        this.numberoffreeODPaltformAvailable = numberoffreeODPaltformAvailable;
        this.alarmMultipluxerStatus = alarmMultipluxerStatus;
        this.doorOpenSensor = doorOpenSensor;
        this.fuelSensor = fuelSensor;
        this.fireSmokeSensor = fireSmokeSensor;
        this.agencyName = agencyName;
        this.siteAccessStatus=siteAccessStatus;
        this.generalSafetyMeasuresData = generalSafetyMeasuresData;
        //this.isSubmited = true;//007
        if (!this.siteHygieneVegitationStatus.isEmpty() && !this.gateLock.isEmpty() && !this.noOfFireExtuinguisher.isEmpty() && !this.fireBucket.isEmpty() && !this.securityStatus.isEmpty() && !this.caretakerStatusUpOnEmergency.isEmpty() && !this.numberofEarthPit.isEmpty() && !this.alarmMultipluxerStatus.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }

    }


    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public String getNoofSecurityPerson() {
        return noofSecurityPerson;
    }

    public void setNoofSecurityPerson(String noofSecurityPerson) {
        this.noofSecurityPerson = noofSecurityPerson;
    }

    public String getMobileNumberofSecurity() {
        return mobileNumberofSecurity;
    }

    public void setMobileNumberofSecurity(String mobileNumberofSecurity) {
        this.mobileNumberofSecurity = mobileNumberofSecurity;
    }

    public String getCaretakerStatusUpOnEmergency() {
        return caretakerStatusUpOnEmergency;
    }

    public void setCaretakerStatusUpOnEmergency(String caretakerStatusUpOnEmergency) {
        this.caretakerStatusUpOnEmergency = caretakerStatusUpOnEmergency;
    }

    public String getMobileNumberofCaretaker() {
        return mobileNumberofCaretaker;
    }

    public void setMobileNumberofCaretaker(String mobileNumberofCaretaker) {
        this.mobileNumberofCaretaker = mobileNumberofCaretaker;
    }

    public String getIsSecurityCaretakeristheOwnerofSite() {
        return isSecurityCaretakeristheOwnerofSite;
    }

    public void setIsSecurityCaretakeristheOwnerofSite(String isSecurityCaretakeristheOwnerofSite) {
        this.isSecurityCaretakeristheOwnerofSite = isSecurityCaretakeristheOwnerofSite;
    }

    public String getSalaryofSecurityCaretaker() {
        return salaryofSecurityCaretaker;
    }

    public void setSalaryofSecurityCaretaker(String salaryofSecurityCaretaker) {
        this.salaryofSecurityCaretaker = salaryofSecurityCaretaker;
    }

    public String getCaretakerSecuritySalaryPaidBy() {
        return caretakerSecuritySalaryPaidBy;
    }

    public void setCaretakerSecuritySalaryPaidBy(String caretakerSecuritySalaryPaidBy) {
        this.caretakerSecuritySalaryPaidBy = caretakerSecuritySalaryPaidBy;
    }

    public String getCaretakerSecurityStayinginSite() {
        return caretakerSecurityStayinginSite;
    }

    public void setCaretakerSecurityStayinginSite(String caretakerSecurityStayinginSite) {
        this.caretakerSecurityStayinginSite = caretakerSecurityStayinginSite;
    }

    public String getNumberofEarthPit() {
        return numberofEarthPit;
    }

    public void setNumberofEarthPit(String numberofEarthPit) {
        this.numberofEarthPit = numberofEarthPit;
    }

    public String getLightningArresterStatus() {
        return lightningArresterStatus;
    }

    public void setLightningArresterStatus(String lightningArresterStatus) {
        this.lightningArresterStatus = lightningArresterStatus;
    }

    public String getFencingCompoundWallCondition() {
        return fencingCompoundWallCondition;
    }

    public void setFencingCompoundWallCondition(String fencingCompoundWallCondition) {
        this.fencingCompoundWallCondition = fencingCompoundWallCondition;
    }

    public String getNumberoffreeODPaltformAvailable() {
        return numberoffreeODPaltformAvailable;
    }

    public void setNumberoffreeODPaltformAvailable(String numberoffreeODPaltformAvailable) {
        this.numberoffreeODPaltformAvailable = numberoffreeODPaltformAvailable;
    }

    public String getAlarmMultipluxerStatus() {
        return alarmMultipluxerStatus;
    }

    public String getPrevailingSLA() {
        return prevailingSLA;
    }

    public void setPrevailingSLA(String prevailingSLA) {
        this.prevailingSLA = prevailingSLA;
    }

    public String getSiteBoundaryStatus() {
        return siteBoundaryStatus;
    }

    public void setSiteBoundaryStatus(String siteBoundaryStatus) {
        this.siteBoundaryStatus = siteBoundaryStatus;
    }

    public String getSiteHygieneVegitationStatus() {
        return siteHygieneVegitationStatus;
    }

    public void setSiteHygieneVegitationStatus(String siteHygieneVegitationStatus) {
        this.siteHygieneVegitationStatus = siteHygieneVegitationStatus;
    }

    public String getGateLock() {
        return gateLock;
    }

    public void setGateLock(String gateLock) {
        this.gateLock = gateLock;
    }

    public String getDgRoomLock() {
        return dgRoomLock;
    }

    public void setDgRoomLock(String dgRoomLock) {
        this.dgRoomLock = dgRoomLock;
    }

    public String getFireExtuinguisher() {
        return fireExtuinguisher;
    }

    public void setFireExtuinguisher(String fireExtuinguisher) {
        this.fireExtuinguisher = fireExtuinguisher;
    }

    public String getNoOfFireExtuinguisher() {
        return noOfFireExtuinguisher;
    }

    public void setNoOfFireExtuinguisher(String noOfFireExtuinguisher) {
        this.noOfFireExtuinguisher = noOfFireExtuinguisher;
    }


    public String getFireBucket() {
        return fireBucket;
    }

    public void setFireBucket(String fireBucket) {
        this.fireBucket = fireBucket;
    }

    public void setAlarmMultipluxerStatus(String alarmMultipluxerStatus) {
        this.alarmMultipluxerStatus = alarmMultipluxerStatus;
    }

    public String getDoorOpenSensor() {
        return doorOpenSensor;
    }

    public void setDoorOpenSensor(String doorOpenSensor) {
        this.doorOpenSensor = doorOpenSensor;
    }

    public String getFuelSensor() {
        return fuelSensor;
    }

    public void setFuelSensor(String fuelSensor) {
        this.fuelSensor = fuelSensor;
    }

    public String getFireSmokeSensor() {
        return fireSmokeSensor;
    }

    public void setFireSmokeSensor(String fireSmokeSensor) {
        this.fireSmokeSensor = fireSmokeSensor;
    }


    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }


    public String getSiteAccessStatus() {
        return siteAccessStatus;
    }

    public void setSiteAccessStatus(String siteAccessStatus) {
        this.siteAccessStatus = siteAccessStatus;
    }

    public ArrayList<GeneralSafetyMeasuresData> getGeneralSafetyMeasuresData() {
        return generalSafetyMeasuresData;
    }

    public void setGeneralSafetyMeasuresData(ArrayList<GeneralSafetyMeasuresData> generalSafetyMeasuresData) {
        this.generalSafetyMeasuresData = generalSafetyMeasuresData;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }


}
