package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EbSiteElectrificationTransactionList {
    @SerializedName("Id")
    @Expose
    private String id;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public EbSiteElectrificationTransactionList(String id, String ebSiteElectrificationTicketNo, String ebSiteElectrificationTicketDate, String siteId, String siteName, String siteAddress, String status, String siteType, String stateName, String customerName, String circleName, String ssaName, String nameOfSupplyCompany,String consumerNumber,String ebMeterSerialNumber) {
        this.id = id;
        this.ebSiteElectrificationTicketNo = ebSiteElectrificationTicketNo;
        this.ebSiteElectrificationTicketDate = ebSiteElectrificationTicketDate;
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.status = status;
        this.siteType = siteType;
        this.stateName = stateName;
        this.customerName = customerName;
        this.circleName = circleName;
        this.ssaName = ssaName;
        this.nameOfSupplyCompany = nameOfSupplyCompany;
        this.consumerNumber = consumerNumber;
        this.ebMeterSerialNumber = ebMeterSerialNumber;
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

}
