
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SitePMReportListData {

    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SitePMReportTicketsDates")
    @Expose
    private List<SitePMReportTicketsDate> sitePMReportTicketsDates = null;
    @SerializedName("SitePMReportSummary")
    @Expose
    private SitePMReportSummary sitePMReportSummary;

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

    public List<SitePMReportTicketsDate> getSitePMReportTicketsDates() {
        return sitePMReportTicketsDates;
    }

    public void setSitePMReportTicketsDates(List<SitePMReportTicketsDate> sitePMReportTicketsDates) {
        this.sitePMReportTicketsDates = sitePMReportTicketsDates;
    }

    public SitePMReportSummary getSitePMReportSummary() {
        return sitePMReportSummary;
    }

    public void setSitePMReportSummary(SitePMReportSummary sitePMReportSummary) {
        this.sitePMReportSummary = sitePMReportSummary;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}
