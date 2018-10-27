package com.brahamaputra.mahindra.brahamaputra.Data;

public class HotoListTiketData {

    private String tiketId;

    private String siteId;

    private String siteAddress;

    public HotoListTiketData(String tiketId) {
        this.tiketId = tiketId;
    }

    public HotoListTiketData(String tiketId, String siteId, String siteAddress) {
        this.tiketId = tiketId;
        this.siteId = siteId;
        this.siteAddress = siteAddress;
    }

    public String getTiketId() {
        return tiketId;
    }

    public void setTiketId(String tiketId) {
        this.tiketId = tiketId;
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
}
