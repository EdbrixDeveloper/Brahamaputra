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

    //////////////
    @SerializedName("siteDBId")//Id
    @Expose
    private String siteDBId;
    @SerializedName("ebSiteElectrificationTicketNo")
    @Expose
    private String ebSiteElectrificationTicketNo;
    @SerializedName("ebSiteElectrificationTicketDate")
    @Expose
    private String ebSiteElectrificationTicketDate;
    @SerializedName("siteId")
    @Expose
    private String siteId;
    @SerializedName("siteName")
    @Expose
    private String siteName;
    @SerializedName("siteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("siteType")
    @Expose
    private String siteType;
    @SerializedName("stateName")
    @Expose
    private String stateName;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("circleName")
    @Expose
    private String circleName;
    @SerializedName("ssaName")
    @Expose
    private String ssaName;
    @SerializedName("nameOfSupplyCompany")
    @Expose
    private String nameOfSupplyCompany;
    @SerializedName("consumerNumber")
    @Expose
    private String consumerNumber;
    @SerializedName("ebMeterSerialNumber")
    @Expose
    private String ebMeterSerialNumber;

    @SerializedName("siteelectrificationId")
    @Expose
    private String siteElectrificationId;


    public String getSiteDBId() {
        return siteDBId;
    }

    public void setSiteDBId(String siteDBId) {
        this.siteDBId = siteDBId;
    }

    public String getEbSiteElectrificationTicketNo() {
        return ebSiteElectrificationTicketNo;
    }

    public void setEbSiteElectrificationTicketNo(String ebSiteElectrificationTicketNo) {
        this.ebSiteElectrificationTicketNo = ebSiteElectrificationTicketNo;
    }

    public String getEbSiteElectrificationTicketDate() {
        return ebSiteElectrificationTicketDate;
    }

    public void setEbSiteElectrificationTicketDate(String ebSiteElectrificationTicketDate) {
        this.ebSiteElectrificationTicketDate = ebSiteElectrificationTicketDate;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getSsaName() {
        return ssaName;
    }

    public void setSsaName(String ssaName) {
        this.ssaName = ssaName;
    }

    public String getNameOfSupplyCompany() {
        return nameOfSupplyCompany;
    }

    public void setNameOfSupplyCompany(String nameOfSupplyCompany) {
        this.nameOfSupplyCompany = nameOfSupplyCompany;
    }

    public String getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getEbMeterSerialNumber() {
        return ebMeterSerialNumber;
    }

    public void setEbMeterSerialNumber(String ebMeterSerialNumber) {
        this.ebMeterSerialNumber = ebMeterSerialNumber;
    }

    public String getSiteElectrificationId() {
        return siteElectrificationId;
    }

    public void setSiteElectrificationId(String siteElectrificationId) {
        this.siteElectrificationId = siteElectrificationId;
    }

    ////////////

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
