package com.brahamaputra.mahindra.brahamaputra.Data;
import java.util.ArrayList;

public class HotoListHeader {

    private String date;

    private String hotoTicketCount;

    private ArrayList<HotoListTiketData> hotoTickets;

    public HotoListHeader(String date, String hotoTicketCount) {
        this.date = date;
        this.hotoTicketCount = hotoTicketCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHotoTicketCount() {
        return hotoTicketCount;
    }

    public void setHotoTicketCount(String hotoTicketCount) {
        this.hotoTicketCount = hotoTicketCount;
    }

    public ArrayList<HotoListTiketData> getHotoTickets() {
        return hotoTickets;
    }

    public void setHotoTickets(ArrayList<HotoListTiketData> hotoTickets) {
        this.hotoTickets = hotoTickets;
    }
}
