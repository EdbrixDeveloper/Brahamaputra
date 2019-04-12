package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SitePMACTicketsDate {

    @SerializedName("TicketDate")
    @Expose
    private String ticketDate;
    @SerializedName("SitePMAcTicketCount")
    @Expose
    private Integer sitePMAcTicketCount;
    @SerializedName("SitePMAcTickets")
    @Expose
    private List<AcSitePMTicket> sitePMAcTickets = null;

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Integer getSitePMAcTicketCount() {
        return sitePMAcTicketCount;
    }

    public void setSitePMAcTicketCount(Integer sitePMTicketCount) {
        this.sitePMAcTicketCount = sitePMTicketCount;
    }

    public List<AcSitePMTicket> getSitePMAcTickets() {
        return sitePMAcTickets;
    }

    public void setSitePMTickets(List<AcSitePMTicket> sitePMAcTickets) {
        this.sitePMAcTickets = sitePMAcTickets;
    }
}
