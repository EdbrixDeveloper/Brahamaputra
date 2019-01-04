package com.brahamaputra.mahindra.brahamaputra.Data;

public class SitePreventiveMaintenanceSection {

    String secNo;
    String secName;
    //boolean secReadingStatus;
    int secReadingStatus;

    public SitePreventiveMaintenanceSection(String secNo, String secName, int secReadingStatus) {
        this.secNo = secNo;
        this.secName = secName;
        this.secReadingStatus = secReadingStatus;
    }

    public String getSecNo() {
        return secNo;
    }

    public void setSecNo(String secNo) {
        this.secNo = secNo;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public int getSecReadingStatus() {
        return secReadingStatus;
    }

    public void setSecReadingStatus(int secReadingStatus) {
        this.secReadingStatus = secReadingStatus;
    }
}
