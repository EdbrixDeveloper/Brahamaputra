package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcSitePMTicket {
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("SitePMAcTicketNo")
    @Expose
    private String acPMTicketNo;
    @SerializedName("SitePMAcTicketDate")
    @Expose
    private String acPMTicketDate;

    @SerializedName("AcPmPlanDate")
    @Expose
    private String pmPlanDate;
    @SerializedName("SubmittedDate")
    @Expose
    private String submittedDate;
    @SerializedName("SheduledDateOfAcPm")
    @Expose
    private String acPMScheduledDate;

    @SerializedName("ModeOfOpration")
    @Expose
    private String modeOfOpration;
    @SerializedName("VendorName")
    @Expose
    private String vendorName;
    @SerializedName("AcTechnicianName")
    @Expose
    private String acTechnicianName;
    @SerializedName("AcTechnicianMobileNo")
    @Expose
    private String acTechnicianMobileNo;
    @SerializedName("SiteDBId")
    @Expose
    private String siteDBId;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("SiteName")
    @Expose
    private String SiteName;

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("NumberOfAc")
    @Expose
    private String numberOfAc;
    /*@SerializedName("AcTechnicianStatus")
    @Expose
    private String acTechnicianStatus;*/
    @SerializedName("StateName")
    @Expose
    private String stateName;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("CircleName")
    @Expose
    private String circleName;
    @SerializedName("SSAName")
    @Expose
    private String ssaName;

    @SerializedName("TicketAccess")
    @Expose
    private String ticketAccess;

    @SerializedName("SiteType")
    @Expose
    private String siteType;

    @SerializedName("AccessType")
    @Expose
    private String accessType;

    @SerializedName("SiteAddress")
    @Expose
    private String SiteAddress;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSitePMAcTicketNo() {
        return acPMTicketNo;
    }

    public void setSitePMAcTicketNo(String acPMTicketNo) {
        this.acPMTicketNo = acPMTicketNo;
    }

    public String getSitePMAcTicketDate() {
        return acPMTicketDate;
    }

    public void setSitePMAcTicketDate(String sitePMAcTicketDate) {
        this.acPMTicketDate = sitePMAcTicketDate;
    }

    public String getPmPlanDate() {
        return pmPlanDate;
    }

    public void setPmPlanDate(String pmPlanDate) {
        this.pmPlanDate = pmPlanDate;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getSheduledDateOfAcPm() {
        return acPMScheduledDate;
    }

    public void setSheduledDateOfAcPm(String sheduledDateOfAcPm) {
        this.acPMScheduledDate = sheduledDateOfAcPm;
    }

    public String getModeOfOpration() {
        return modeOfOpration;
    }

    public void setModeOfOpration(String modeOfOpration) {
        this.modeOfOpration = modeOfOpration;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getAcTechnicianName() {
        return acTechnicianName;
    }

    public void setAcTechnicianName(String acTechnicianName) {
        this.acTechnicianName = acTechnicianName;
    }

    public String getAcTechnicianMobileNo() {
        return acTechnicianMobileNo;
    }

    public void setAcTechnicianMobileNo(String acTechnicianMobileNo) {
        this.acTechnicianMobileNo = acTechnicianMobileNo;
    }

    public String getSiteDBId() {
        return siteDBId;
    }

    public void setSiteDBId(String siteDBId) {
        this.siteDBId = siteDBId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumberOfAc() {
        return numberOfAc;
    }

    public void setNumberOfAc(String numberOfAc) {
        this.numberOfAc = numberOfAc;
    }

    /*public String getAcTechnicianStatus() {
        return acTechnicianStatus;
    }

    public void setAcTechnicianStatus(String acTechnicianStatus) {
        this.acTechnicianStatus = acTechnicianStatus;
    }*/

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getSSAName() {
        return ssaName;
    }

    public void setSSAName(String SSAName) {
        this.ssaName = SSAName;
    }

    public String getTicketAccess() {
        return ticketAccess;
    }

    public void setTicketAccess(String ticketAccess) {
        this.ticketAccess = ticketAccess;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getSiteAddress() {
        return SiteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        SiteAddress = siteAddress;
    }

}
