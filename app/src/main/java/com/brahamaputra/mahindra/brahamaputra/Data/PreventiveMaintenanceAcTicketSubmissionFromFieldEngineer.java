
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreventiveMaintenanceAcTicketSubmissionFromFieldEngineer implements Serializable
{

    @SerializedName("customer")
    @Expose
    private String customer;
    @SerializedName("circle")
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
    @SerializedName("scheduledDateOfAcPm")
    @Expose
    private String scheduledDateOfAcPm;
    @SerializedName("modeOfOperation")
    @Expose
    private String modeOfOperation;
    @SerializedName("ticketNo")
    @Expose
    private String ticketNo;
    @SerializedName("vendorName")
    @Expose
    private String vendorName;
    @SerializedName("acTechnicianName")
    @Expose
    private String acTechnicianName;
    @SerializedName("acTechnicianMobNo")
    @Expose
    private String acTechnicianMobNo;
    @SerializedName("ticketStatus")
    @Expose
    private String ticketStatus;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("submittedDate")
    @Expose
    private String submittedDate;
    @SerializedName("feedBack")
    @Expose
    private String feedBack;
    @SerializedName("remarks")
    @Expose
    private String remarks;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PreventiveMaintenanceAcTicketSubmissionFromFieldEngineer() {
    }

    /**
     * 
     * @param feedBack
     * @param acTechnicianName
     * @param vendorName
     * @param status
     * @param ssa
     * @param ticketStatus
     * @param state
     * @param remarks
     * @param circle
     * @param customer
     * @param scheduledDateOfAcPm
     * @param ticketNo
     * @param siteId
     * @param submittedDate
     * @param modeOfOperation
     * @param acTechnicianMobNo
     * @param siteName
     */
    public PreventiveMaintenanceAcTicketSubmissionFromFieldEngineer(String customer, String circle, String state, String ssa, String siteName, String siteId, String scheduledDateOfAcPm, String modeOfOperation, String ticketNo, String vendorName, String acTechnicianName, String acTechnicianMobNo, String ticketStatus, String status, String submittedDate, String feedBack, String remarks) {
        super();
        this.customer = customer;
        this.circle = circle;
        this.state = state;
        this.ssa = ssa;
        this.siteName = siteName;
        this.siteId = siteId;
        this.scheduledDateOfAcPm = scheduledDateOfAcPm;
        this.modeOfOperation = modeOfOperation;
        this.ticketNo = ticketNo;
        this.vendorName = vendorName;
        this.acTechnicianName = acTechnicianName;
        this.acTechnicianMobNo = acTechnicianMobNo;
        this.ticketStatus = ticketStatus;
        this.status = status;
        this.submittedDate = submittedDate;
        this.feedBack = feedBack;
        this.remarks = remarks;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    public String getScheduledDateOfAcPm() {
        return scheduledDateOfAcPm;
    }

    public void setScheduledDateOfAcPm(String scheduledDateOfAcPm) {
        this.scheduledDateOfAcPm = scheduledDateOfAcPm;
    }

    public String getModeOfOperation() {
        return modeOfOperation;
    }

    public void setModeOfOperation(String modeOfOperation) {
        this.modeOfOperation = modeOfOperation;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
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

    public String getAcTechnicianMobNo() {
        return acTechnicianMobNo;
    }

    public void setAcTechnicianMobNo(String acTechnicianMobNo) {
        this.acTechnicianMobNo = acTechnicianMobNo;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
