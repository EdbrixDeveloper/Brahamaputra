package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EbSiteElectrificationTransaction {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("ebSiteElectrificationTicketCount")
    @Expose
    private Integer ebSiteElectrificationTicketCount;
    @SerializedName("ebSiteElectrificationTickets")
    @Expose
    private List<EbSiteElectrificationTransactionList> ebSiteElectrificationTransactionList = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getEbSiteElectrificationTicketCount() {
        return ebSiteElectrificationTicketCount;
    }

    public void setEbSiteElectrificationTicketCount(Integer ebSiteElectrificationTicketCount) {
        this.ebSiteElectrificationTicketCount = ebSiteElectrificationTicketCount;
    }

    public List<EbSiteElectrificationTransactionList> getEbSiteElectrificationList() {
        return ebSiteElectrificationTransactionList;
    }

    public void setEbSiteElectrificationList(List<EbSiteElectrificationTransactionList> ebSiteElectrificationTransactionList) {
        this.ebSiteElectrificationTransactionList = ebSiteElectrificationTransactionList;
    }

    public EbSiteElectrificationTransaction(String date, Integer ebSiteElectrificationTicketCount, List<EbSiteElectrificationTransactionList> ebSiteElectrificationTransactionList) {
        this.date = date;
        this.ebSiteElectrificationTicketCount = ebSiteElectrificationTicketCount;
        this.ebSiteElectrificationTransactionList = ebSiteElectrificationTransactionList;
    }
}
