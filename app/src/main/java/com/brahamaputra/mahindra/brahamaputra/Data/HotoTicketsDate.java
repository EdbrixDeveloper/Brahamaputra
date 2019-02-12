package com.brahamaputra.mahindra.brahamaputra.Data;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotoTicketsDate {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("hotoTicketCount")
    @Expose
    private Integer hotoTicketCount;
    @SerializedName("hotoTickets")
    @Expose
    private List<HotoTicket> hotoTickets = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getHotoTicketCount() {
        return hotoTicketCount;
    }

    public void setHotoTicketCount(Integer hotoTicketCount) {
        this.hotoTicketCount = hotoTicketCount;
    }

    public List<HotoTicket> getHotoTickets() {
        return hotoTickets;
    }

    public void setHotoTickets(List<HotoTicket> hotoTickets) {
        this.hotoTickets = hotoTickets;
    }

    public HotoTicketsDate(String date, Integer hotoTicketCount, List<HotoTicket> hotoTickets) {
        this.date = date;
        this.hotoTicketCount = hotoTicketCount;
        this.hotoTickets = hotoTickets;
    }
}
