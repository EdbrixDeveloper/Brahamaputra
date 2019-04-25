
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SitePMReportTicketsDate {

    @SerializedName("TicketDate")
    @Expose
    private String ticketDate;
    @SerializedName("SitePMTicketCount")
    @Expose
    private Integer sitePMTicketCount;
    @SerializedName("SitePMReportTickets")
    @Expose
    private List<SitePMReportTicket> sitePMReportTickets = null;

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

    public List<SitePMReportTicket> getSitePMReportTickets() {
        return sitePMReportTickets;
    }

    public void setSitePMReportTickets(List<SitePMReportTicket> sitePMReportTickets) {
        this.sitePMReportTickets = sitePMReportTickets;
    }

}
