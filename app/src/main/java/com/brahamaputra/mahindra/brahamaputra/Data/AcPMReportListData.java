package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcPMReportListData {
    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("AcPMReportTicketsDates")
    @Expose
    private List<AcPMReportTicketsDate> acPMReportTicketsDates = null;
    @SerializedName("AcPMReportSummary")
    @Expose
    private AcPMReportSummary acPMReportSummary;

    @SerializedName("Error")
    @Expose
    private Error error;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AcPMReportTicketsDate> getAcPMReportTicketsDates() {
        return acPMReportTicketsDates;
    }

    public void setAcPMReportTicketsDates(List<AcPMReportTicketsDate> acPMReportTicketsDates) {
        this.acPMReportTicketsDates = acPMReportTicketsDates;
    }

    public AcPMReportSummary getAcPMReportSummary() {
        return acPMReportSummary;
    }

    public void setAcPMReportSummary(AcPMReportSummary acPMReportSummary) {
        this.acPMReportSummary = acPMReportSummary;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
