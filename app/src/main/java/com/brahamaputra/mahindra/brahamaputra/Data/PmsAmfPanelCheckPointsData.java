package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PmsAmfPanelCheckPointsData implements Serializable {

    @SerializedName("detailsOfPmsAmfPiuQrCodeScan")
    @Expose
    private String detailsOfPmsAmfPiuQrCodeScan;
    @SerializedName("siteInAutoManual")
    @Expose
    private String siteInAutoManual;
    @SerializedName("anyLooseConnectionBypass")
    @Expose
    private String anyLooseConnectionBypass;
    @SerializedName("pmsAmfPiuEarthingStatus")
    @Expose
    private String pmsAmfPiuEarthingStatus;

    public PmsAmfPanelCheckPointsData() {
        this.detailsOfPmsAmfPiuQrCodeScan = "";
        this.siteInAutoManual = "";
        this.anyLooseConnectionBypass = "";
        this.pmsAmfPiuEarthingStatus = "";

    }

    public PmsAmfPanelCheckPointsData(String detailsOfPmsAmfQrCodeScan, String siteInAutoManual, String anyLooseConnectionBypass, String pmsAmfPuiEarthingStatus) {
        this.detailsOfPmsAmfPiuQrCodeScan = detailsOfPmsAmfQrCodeScan;
        this.siteInAutoManual = siteInAutoManual;
        this.anyLooseConnectionBypass = anyLooseConnectionBypass;
        this.pmsAmfPiuEarthingStatus = pmsAmfPuiEarthingStatus;

    }

    public String getDetailsOfPmsAmfPiuQrCodeScan() {
        return detailsOfPmsAmfPiuQrCodeScan;
    }

    public void setDetailsOfPmsAmfPiuQrCodeScan(String detailsOfPmsAmfPiuQrCodeScan) {
        this.detailsOfPmsAmfPiuQrCodeScan = detailsOfPmsAmfPiuQrCodeScan;
    }

    public String getSiteInAutoManual() {
        return siteInAutoManual;
    }

    public void setSiteInAutoManual(String siteInAutoManual) {
        this.siteInAutoManual = siteInAutoManual;
    }

    public String getAnyLooseConnectionBypass() {
        return anyLooseConnectionBypass;
    }

    public void setAnyLooseConnectionBypass(String anyLooseConnectionBypass) {
        this.anyLooseConnectionBypass = anyLooseConnectionBypass;
    }

    public String getPmsAmfPiuEarthingStatus() {
        return pmsAmfPiuEarthingStatus;
    }

    public void setPmsAmfPiuEarthingStatus(String pmsAmfPiuEarthingStatus) {
        this.pmsAmfPiuEarthingStatus = pmsAmfPiuEarthingStatus;
    }


}
