package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;

public class GeneralSafetyMeasuresData {

    /*@SerializedName("prevailingSLA")
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
    private String fireExtuinguisher;*/

    @SerializedName("fireExtuinguisherType")
    private String fireExtuinguisherType;

    @SerializedName("fireExtuinguisherExpiryDate")
    private String fireExtuinguisherExpiryDate;

    /*@SerializedName("fireBucket")
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

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    @SerializedName("agencyName")
    private String agencyName;*/

    public GeneralSafetyMeasuresData() {
        /*this.prevailingSLA = "";
        this.siteBoundaryStatus = "";
        this.siteHygieneVegitationStatus = "";
        this.gateLock = "";
        this.dgRoomLock = "";
        this.fireExtuinguisher = "";*/
        this.fireExtuinguisherType = "";
        this.fireExtuinguisherExpiryDate = "";
        /*this.fireBucket = "";
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
        this.isSubmited=false;
        this.agencyName="";*/
    }

    public GeneralSafetyMeasuresData(String fireExtuinguisherType, String fireExtuinguisherExpiryDate) {
        /*this.prevailingSLA = prevailingSLA;
        this.siteBoundaryStatus = siteBoundaryStatus;
        this.siteHygieneVegitationStatus = siteHygieneVegitationStatus;
        this.gateLock = gateLock;
        this.dgRoomLock = dgRoomLock;
        this.fireExtuinguisher = fireExtuinguisher;*/
        this.fireExtuinguisherType = fireExtuinguisherType;
        this.fireExtuinguisherExpiryDate = fireExtuinguisherExpiryDate;
        /*this.fireBucket = fireBucket;
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
        this.isSubmited=true;
        this.agencyName=agencyName;*/
    }


    /*public String getSecurityStatus() {
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
    }*/

    public String getFireExtuinguisherType() {
        return fireExtuinguisherType;
    }

    public void setFireExtuinguisherType(String fireExtuinguisherType) {
        this.fireExtuinguisherType = fireExtuinguisherType;
    }

    public String getFireExtuinguisherExpiryDate() {
        return fireExtuinguisherExpiryDate;
    }

    public void setFireExtuinguisherExpiryDate(String fireExtuinguisherExpiryDate) {
        this.fireExtuinguisherExpiryDate = fireExtuinguisherExpiryDate;
    }

    /*public String getFireBucket() {
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

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
*/

}
