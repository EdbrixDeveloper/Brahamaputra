package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcSitePMTicketsDate {
    @SerializedName("TicketDate")
    @Expose
    private String ticketDate;

    @SerializedName("acSitePMTicketCount")
    @Expose
    private Integer acSitePMTicketCount;

    @SerializedName("acSitePMTickets")
    @Expose
    private List<AcSitePMTicket> acSitePMTickets = null;

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Integer getAcSitePMTicketCount() {
        return acSitePMTicketCount;
    }

    public void setAcSitePMTicketCount(Integer sitePMTicketCount) {
        this.acSitePMTicketCount = sitePMTicketCount;
    }

    public List<AcSitePMTicket> getAcSitePMTickets() {
        return acSitePMTickets;
    }

    public void setAcSitePMTickets(List<AcSitePMTicket> sitePMTickets) {
        this.acSitePMTickets = sitePMTickets;
    }
}
