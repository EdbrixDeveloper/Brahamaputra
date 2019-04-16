package com.brahamaputra.mahindra.brahamaputra.Data;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcPreventiveMaintanceProcessParentDatum {

    /*@SerializedName("circle")
    @Expose
    private String circle;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("ssa")
    @Expose
    private String ssa;
    @SerializedName("siteName")
    @Expose
    private String siteName;
    @SerializedName("siteId")
    @Expose
    private String siteId;
    @SerializedName("ticketNo")
    @Expose
    private String ticketNo;*/
    /*@SerializedName("ticketDate")
    @Expose
    private String ticketDate;
    @SerializedName("pmPlanDate")
    @Expose
    private String pmPlanDate;
    @SerializedName("submittedDate")
    @Expose
    private String submittedDate;*/
    @SerializedName("noOfAcAtSite")
    @Expose
    private String noOfAcAtSite;
    @SerializedName("acPreventiveMaintanceProcessData")
    @Expose
    private List<AcPreventiveMaintanceProcessDatum> acPreventiveMaintanceProcessData = null;
    @SerializedName("acPmTechnicianLat")
    @Expose
    private String acPmTechnicianLat;
    @SerializedName("acPmTechnicianLong")
    @Expose
    private String acPmTechnicianLong;

    public AcPreventiveMaintanceProcessParentDatum(){

    }

    /**
     * @param ticketNo
     * @param siteId
     * @param ssa
     * @param submittedDate
     * @param state
     * @param circle
     * @param noOfAcAtSite
     * @param pmPlanDate
     * @param acPreventiveMaintanceProcessData
     * @param siteName
     * @param ticketDate
     */
    public AcPreventiveMaintanceProcessParentDatum(String circle, String state, String ssa, String siteName, String siteId, String ticketNo, String ticketDate, String pmPlanDate, String submittedDate, String noOfAcAtSite, List<AcPreventiveMaintanceProcessDatum> acPreventiveMaintanceProcessData) {
        super();
        /*this.circle = circle;
        this.state = state;
        this.ssa = ssa;
        this.siteName = siteName;
        this.siteId = siteId;
        this.ticketNo = ticketNo;*/
        /*this.ticketDate = ticketDate;
        this.pmPlanDate = pmPlanDate;
        this.submittedDate = submittedDate;*/
        this.noOfAcAtSite = noOfAcAtSite;
        this.acPreventiveMaintanceProcessData = acPreventiveMaintanceProcessData;
    }

    /*public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSsa() {
        return ssa;
    }

    public void setSsa(String ssa) {
        this.ssa = ssa;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }*/

    /*public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
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
    }*/

    public String getNoOfAcAtSite() {
        return noOfAcAtSite;
    }

    public void setNoOfAcAtSite(String noOfAcAtSite) {
        this.noOfAcAtSite = noOfAcAtSite;
    }

    public List<AcPreventiveMaintanceProcessDatum> getAcPreventiveMaintanceProcessData() {
        return acPreventiveMaintanceProcessData;
    }

    public void setAcPreventiveMaintanceProcessData(List<AcPreventiveMaintanceProcessDatum> acPreventiveMaintanceProcessData) {
        this.acPreventiveMaintanceProcessData = acPreventiveMaintanceProcessData;
    }
    public String getAcPmTechnicianLat() {
        return acPmTechnicianLat;
    }

    public void setAcPmTechnicianLat(String acPmTechnicianLat) {
        this.acPmTechnicianLat = acPmTechnicianLat;
    }

    public String getAcPmTechnicianLong() {
        return acPmTechnicianLong;
    }

    public void setAcPmTechnicianLong(String acPmTechnicianLong) {
        this.acPmTechnicianLong = acPmTechnicianLong;
    }
}
