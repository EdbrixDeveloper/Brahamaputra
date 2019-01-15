
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServoCheckPoints implements Serializable
{

    @SerializedName("detailsOfServoQrCodeScan")
    @Expose
    private String detailsOfServoQrCodeScan;
    @SerializedName("servoWorkingStatus")
    @Expose
    private String servoWorkingStatus;
    @SerializedName("anyBypassInSVS")
    @Expose
    private String anyBypassInSVS;
    @SerializedName("svsEarthing Status")
    @Expose
    private String svsEarthingStatus;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    private final static long serialVersionUID = -725516690069653860L;

    public ServoCheckPoints()
    {
        this.detailsOfServoQrCodeScan = "";
        this.servoWorkingStatus = "";
        this.anyBypassInSVS = "";
        this.svsEarthingStatus = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.isSubmited = 0;
    }

    public ServoCheckPoints(String detailsOfServoQRCodeScan, String servoWorkingStatus, String anyBypassInSvs, String svsEarthingStatus, String registerFault, String typeOfFault) {
        this.detailsOfServoQrCodeScan = detailsOfServoQRCodeScan;
        this.servoWorkingStatus = servoWorkingStatus;
        this.anyBypassInSVS = anyBypassInSvs;
        this.svsEarthingStatus = svsEarthingStatus;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;

        /*if (!this.landType.isEmpty() && !this.landArea.isEmpty() && !this.landAgreementCopy.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }*/
    }

    public String getDetailsOfServoQrCodeScan() {
        return detailsOfServoQrCodeScan;
    }

    public void setDetailsOfServoQrCodeScan(String detailsOfServoQrCodeScan) {
        this.detailsOfServoQrCodeScan = detailsOfServoQrCodeScan;
    }

    public String getServoWorkingStatus() {
        return servoWorkingStatus;
    }

    public void setServoWorkingStatus(String servoWorkingStatus) {
        this.servoWorkingStatus = servoWorkingStatus;
    }

    public String getAnyBypassInSVS() {
        return anyBypassInSVS;
    }

    public void setAnyBypassInSVS(String anyBypassInSVS) {
        this.anyBypassInSVS = anyBypassInSVS;
    }

    public String getSvsEarthingStatus() {
        return svsEarthingStatus;
    }

    public void setSvsEarthingStatus(String svsEarthingStatus) {
        this.svsEarthingStatus = svsEarthingStatus;
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

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

}