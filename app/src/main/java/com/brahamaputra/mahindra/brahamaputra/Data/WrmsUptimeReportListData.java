package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WrmsUptimeReportListData {
    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("WrmsUptimeReportTicketsDates")
    @Expose
    private List<WrmsUptimeReportTicketsDate> wrmsUptimeReportTicketsDates = null;
    @SerializedName("WrmsUptimeReportSummary")
    @Expose
    private WrmsUptimeReportSummary wrmsUptimeReportSummary;
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

    public List<WrmsUptimeReportTicketsDate> getWrmsUptimeReportTicketsDates() {
        return wrmsUptimeReportTicketsDates;
    }

    public void setWrmsUptimeReportTicketsDates(List<WrmsUptimeReportTicketsDate> wrmsUptimeReportTicketsDates) {
        this.wrmsUptimeReportTicketsDates = wrmsUptimeReportTicketsDates;
    }

    public WrmsUptimeReportSummary getWrmsUptimeReportSummary() {
        return wrmsUptimeReportSummary;
    }

    public void setWrmsUptimeReportSummary(WrmsUptimeReportSummary wrmsUptimeReportSummary) {
        this.wrmsUptimeReportSummary = wrmsUptimeReportSummary;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
