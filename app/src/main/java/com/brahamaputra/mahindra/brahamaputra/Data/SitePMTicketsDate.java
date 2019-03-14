package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SitePMTicketsDate {

    @SerializedName("TicketDate")
    @Expose
    private String ticketDate;
    @SerializedName("SitePMTicketCount")
    @Expose
    private Integer sitePMTicketCount;
    @SerializedName("SitePMTickets")
    @Expose
    private List<SitePMTicket> sitePMTickets = null;

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Integer getSitePMTicketCount() {
        return sitePMTicketCount;
    }

    public void setSitePMTicketCount(Integer sitePMTicketCount) {
        this.sitePMTicketCount = sitePMTicketCount;
    }

    public List<SitePMTicket> getSitePMTickets() {
        return sitePMTickets;
    }

    public void setSitePMTickets(List<SitePMTicket> sitePMTickets) {
        this.sitePMTickets = sitePMTickets;
    }
}
