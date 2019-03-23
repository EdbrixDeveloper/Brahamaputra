package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SitePmAcTicketList {
    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SitePMTicketsDates")
    @Expose
    private List<SitePMACTicketsDate> sitePMACTicketsDates = null;
    @SerializedName("SitePMTicketSummary")
    @Expose
    private SitePMTicketSummary sitePMTicketSummary;

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

    public List<SitePMACTicketsDate> getSitePMTicketsDates() {
        return sitePMACTicketsDates;
    }

    public void setSitePMTicketsDates(List<SitePMACTicketsDate> sitePMTicketsDates) {
        this.sitePMACTicketsDates = sitePMTicketsDates;
    }

    public SitePMTicketSummary getSitePMTicketSummary() {
        return sitePMTicketSummary;
    }

    public void setSitePMTicketSummary(SitePMTicketSummary sitePMTicketSummary) {
        this.sitePMTicketSummary = sitePMTicketSummary;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
