
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreventiveMaintenanceAcProcessParentData implements Serializable
{

    @SerializedName("circle")
    @Expose
    private String circle;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("ssa")
    @Expose
    private String ssa;
    @SerializedName("siteId")
    @Expose
    private String siteId;
    @SerializedName("siteName")
    @Expose
    private String siteName;
    @SerializedName("ticketNo")
    @Expose
    private String ticketNo;
    @SerializedName("ticketDate")
    @Expose
    private String ticketDate;
    @SerializedName("pmPlanDate")
    @Expose
    private String pmPlanDate;
    @SerializedName("submittedDate")
    @Expose
    private String submittedDate;
    @SerializedName("noOfAcAtSite")
    @Expose
    private String noOfAcAtSite;
    @SerializedName("acPreventiveMaintenanceProcessData")
    @Expose
    private List<PreventiveMaintenanceAcProcessData> acPreventiveMaintenanceProcessData = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PreventiveMaintenanceAcProcessParentData() {
    }

    /**
     * 
     * @param ticketNo
     * @param siteId
     * @param ssa
     * @param submittedDate
     * @param state
     * @param circle
     * @param noOfAcAtSite
     * @param pmPlanDate
     * @param acPreventiveMaintenanceProcessData
     * @param siteName
     * @param ticketDate
     */
    public PreventiveMaintenanceAcProcessParentData(String circle, String state, String ssa, String siteId, String siteName, String ticketNo, String ticketDate, String pmPlanDate, String submittedDate, String noOfAcAtSite, List<PreventiveMaintenanceAcProcessData> acPreventiveMaintenanceProcessData) {
        super();
        this.circle = circle;
        this.state = state;
        this.ssa = ssa;
        this.siteId = siteId;
        this.siteName = siteName;
        this.ticketNo = ticketNo;
        this.ticketDate = ticketDate;
        this.pmPlanDate = pmPlanDate;
        this.submittedDate = submittedDate;
        this.noOfAcAtSite = noOfAcAtSite;
        this.acPreventiveMaintenanceProcessData = acPreventiveMaintenanceProcessData;
    }

    public String getCircle() {
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

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTicketDate() {
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
    }

    public String getNoOfAcAtSite() {
        return noOfAcAtSite;
    }

    public void setNoOfAcAtSite(String noOfAcAtSite) {
        this.noOfAcAtSite = noOfAcAtSite;
    }

    public List<PreventiveMaintenanceAcProcessData> getAcPreventiveMaintenanceProcessData() {
        return acPreventiveMaintenanceProcessData;
    }

    public void setAcPreventiveMaintenanceProcessData(List<PreventiveMaintenanceAcProcessData> acPreventiveMaintenanceProcessData) {
        this.acPreventiveMaintenanceProcessData = acPreventiveMaintenanceProcessData;
    }

}
