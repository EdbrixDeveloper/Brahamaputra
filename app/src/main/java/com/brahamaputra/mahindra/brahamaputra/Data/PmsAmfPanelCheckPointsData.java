
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PmsAmfPanelCheckPointsData implements Serializable
{

    @SerializedName("detailsOfPmsAmfPiuQrCodeScan")
    @Expose
    private String detailsOfPmsAmfPiuQrCodeScan;
    @SerializedName("siteInAutoManual")
    @Expose
    private String siteInAutoManual;
    @SerializedName("anyLooseConnectionBypass")
    @Expose
    private String anyLooseConnectionBypass;
    @SerializedName("PmsAmfPiuEarthingStatus")
    @Expose
    private String pmsAmfPiuEarthingStatus;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    private final static long serialVersionUID = -7367757211641983319L;

    public PmsAmfPanelCheckPointsData()
    {
        this.detailsOfPmsAmfPiuQrCodeScan = "";
        this.siteInAutoManual = "";
        this.anyLooseConnectionBypass = "";
        this.pmsAmfPiuEarthingStatus = "";
        this.registerFault = "";
        this.typeOfFault = "";
    }

    public PmsAmfPanelCheckPointsData(String detailsOfPmsAmfQrCodeScan, String siteInAutoManual, String anyLooseConnectionBypass, String pmsAmfPuiEarthingStatus, String registerFault, String typeOfFault) {
        this.detailsOfPmsAmfPiuQrCodeScan = detailsOfPmsAmfQrCodeScan;
        this.siteInAutoManual = siteInAutoManual;
        this.anyLooseConnectionBypass =anyLooseConnectionBypass;
        this.pmsAmfPiuEarthingStatus = pmsAmfPuiEarthingStatus;
        this.registerFault =registerFault;
        this.typeOfFault = typeOfFault;
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

    public String getRegisterFault() {
        return registerFault;
    }

    public void setRegisterFault(String registerFault) {
        this.registerFault = registerFault;
    }

    public String getTypeOfFault() {
        return typeOfFault;
    }

    public void setTypeOfFault(String typeOfFault) {
        this.typeOfFault = typeOfFault;
    }

}
