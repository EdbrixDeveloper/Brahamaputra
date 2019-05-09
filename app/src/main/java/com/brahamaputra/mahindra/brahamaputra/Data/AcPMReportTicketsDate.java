package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcPMReportTicketsDate {
    @SerializedName("TicketDate")
    @Expose
    private String ticketDate;
    @SerializedName("AcPMTicketCount")
    @Expose
    private Integer acPMTicketCount;
    @SerializedName("AcPMReportTickets")
    @Expose
    private List<AcPMReportTicket> acPMReportTickets = null;

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Integer getAcPMTicketCount() {
        return acPMTicketCount;
    }

    public void setAcPMTicketCount(Integer acPMTicketCount) {
        this.acPMTicketCount = acPMTicketCount;
    }

    public List<AcPMReportTicket> getAcPMReportTickets() {
        return acPMReportTickets;
    }

    public void setAcPMReportTickets(List<AcPMReportTicket> acPMReportTickets) {
        this.acPMReportTickets = acPMReportTickets;
    }
}
