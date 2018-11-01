package com.brahamaputra.mahindra.brahamaputra.Data;

public class HotoListTiketData {

    private String Id;

    private String hotoTicketNo;

    private String hotoTicketDate;

    private String siteId;

    private String siteName;

    private String siteAddress;

    private String status;

    public HotoListTiketData(String tiketId) {
        this.Id = tiketId;
    }

    public HotoListTiketData(String hotoTicketNo, String status) {
        this.hotoTicketNo = hotoTicketNo;
        this.status = status;
    }

    public HotoListTiketData(String tiketId, String siteId, String siteAddress) {
        this.Id = tiketId;
        this.siteId = siteId;
        this.siteAddress = siteAddress;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getHotoTicketNo() {
        return hotoTicketNo;
    }

    public void setHotoTicketNo(String hotoTicketNo) {
        this.hotoTicketNo = hotoTicketNo;
    }

    public String getHotoTicketDate() {
        return hotoTicketDate;
    }

    public void setHotoTicketDate(String hotoTicketDate) {
        this.hotoTicketDate = hotoTicketDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
