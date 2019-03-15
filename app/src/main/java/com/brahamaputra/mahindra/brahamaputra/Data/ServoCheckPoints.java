
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
    @SerializedName("svsEarthingStatus")
    @Expose
    private String svsEarthingStatus;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;

    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public ServoCheckPoints()
    {
        this.detailsOfServoQrCodeScan = "";
        this.servoWorkingStatus = "";
        this.anyBypassInSVS = "";
        this.svsEarthingStatus = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.isSubmited = 0;
    }

    public ServoCheckPoints(String detailsOfServoQRCodeScan, String servoWorkingStatus, String anyBypassInSvs, String svsEarthingStatus, String registerFault, String typeOfFault,String base64StringUploadPhotoOfRegisterFault) {
        this.detailsOfServoQrCodeScan = detailsOfServoQRCodeScan;
        this.servoWorkingStatus = servoWorkingStatus;
        this.anyBypassInSVS = anyBypassInSvs;
        this.svsEarthingStatus = svsEarthingStatus;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault=base64StringUploadPhotoOfRegisterFault;

        if (!this.detailsOfServoQrCodeScan.isEmpty() && !this.servoWorkingStatus.isEmpty() && !this.anyBypassInSVS.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
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

    public String getBase64StringUploadPhotoOfRegisterFault() {
        return base64StringUploadPhotoOfRegisterFault;
    }

    public void setBase64StringUploadPhotoOfRegisterFault(String base64StringUploadPhotoOfRegisterFault) {
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

}
