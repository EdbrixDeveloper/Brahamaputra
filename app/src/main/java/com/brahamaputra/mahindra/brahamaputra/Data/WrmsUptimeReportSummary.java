package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WrmsUptimeReportSummary {
    @SerializedName("TotalSites")
    @Expose
    private Integer totalSites;
    @SerializedName("SSAUptime")
    @Expose
    private String sSAUptime;
    @SerializedName("CircleUptime")
    @Expose
    private String circleUptime;
    @SerializedName("MyUptime")
    @Expose
    private String myUptime;
    @SerializedName("TargetUptime")
    @Expose
    private String targetUptime;

    public Integer getTotalSites() {
        return totalSites;
    }

    public void setTotalSites(Integer totalSites) {
        this.totalSites = totalSites;
    }

    public String getSSAUptime() {
        return sSAUptime;
    }

    public void setSSAUptime(String sSAUptime) {
        this.sSAUptime = sSAUptime;
    }

    public String getCircleUptime() {
        return circleUptime;
    }

    public void setCircleUptime(String circleUptime) {
        this.circleUptime = circleUptime;
    }

    public String getMyUptime() {
        return myUptime;
    }

    public void setMyUptime(String myUptime) {
        this.myUptime = myUptime;
    }

    public String getTargetUptime() {
        return targetUptime;
    }

    public void setTargetUptime(String targetUptime) {
        this.targetUptime = targetUptime;
    }

}
