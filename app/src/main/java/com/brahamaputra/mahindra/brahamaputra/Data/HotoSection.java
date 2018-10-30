package com.brahamaputra.mahindra.brahamaputra.Data;

public class HotoSection {

    String secNo;
    String secName;
    boolean secReadingStatus;

    public HotoSection(String secNo, String secName, boolean secReadingStatus) {
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

    public boolean getSecReadingStatus() {
        return secReadingStatus;
    }

    public void setSecReadingStatus(boolean secReadingStatus) {
        this.secReadingStatus = secReadingStatus;
    }
}
