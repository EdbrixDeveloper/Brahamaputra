package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SitePMTicketSummary {

    @SerializedName("TotalTickets")
    @Expose
    private String totalTickets;
    @SerializedName("OpenTickets")
    @Expose
    private String openTickets;
    @SerializedName("Percentage")
    @Expose
    private double percentage;

    public String getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(String totalTickets) {
        this.totalTickets = totalTickets;
    }

    public String getOpenTickets() {
        return openTickets;
    }

    public void setOpenTickets(String openTickets) {
        this.openTickets = openTickets;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}
