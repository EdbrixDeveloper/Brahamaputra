package com.brahamaputra.mahindra.brahamaputra.Data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotoTicketList {

    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("HotoTicketsDates")
    @Expose
    private List<HotoTicketsDate> hotoTicketsDates = null;

    @SerializedName("HotoTicketSummary")
    @Expose
    private HotoTicketSummary hotoTicketSummary;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @SerializedName("Error")
    @Expose
    private Error error;

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

    public List<HotoTicketsDate> getHotoTicketsDates() {
        return hotoTicketsDates;
    }

    public void setHotoTicketsDates(List<HotoTicketsDate> hotoTicketsDates) {
        this.hotoTicketsDates = hotoTicketsDates;
    }

    public HotoTicketSummary getHotoTicketSummary() {
        return hotoTicketSummary;
    }

    public void setHotoTicketSummary(HotoTicketSummary hotoTicketSummary) {
        this.hotoTicketSummary = hotoTicketSummary;
    }

}
