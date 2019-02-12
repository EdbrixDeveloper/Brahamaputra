
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmpsCheckPoint implements Serializable
{
    @SerializedName("detailsOfSmpsQrCodeScan")
    @Expose
    private String detailsOfSmpsQrCodeScan;
    @SerializedName("SmpsCondition")
    @Expose
    private String smpsCondition;
    @SerializedName("SmpsControlerStatus")
    @Expose
    private String smpsControlerStatus;
    @SerializedName("SmpsEarthingStatus")
    @Expose
    private String smpsEarthingStatus;
    @SerializedName("DcLoadCurrentInFloat")
    @Expose
    private String dcLoadCurrentInFloat;
    @SerializedName("base64DcLoadCurrentPhoto")
    @Expose
    private String base64DcLoadCurrentPhoto;
    @SerializedName("dcLoadAmpPh")
    @Expose
    private String dcLoadAmpPh;

    public String getDetailsOfSmpsQrCodeScan() {
        return detailsOfSmpsQrCodeScan;
    }

    public void setDetailsOfSmpsQrCodeScan(String detailsOfSmpsQrCodeScan) {
        this.detailsOfSmpsQrCodeScan = detailsOfSmpsQrCodeScan;
    }

    public String getSmpsCondition() {
        return smpsCondition;
    }

    public void setSmpsCondition(String smpsCondition) {
        this.smpsCondition = smpsCondition;
    }

    public String getSmpsControlerStatus() {
        return smpsControlerStatus;
    }

    public void setSmpsControlerStatus(String smpsControlerStatus) {
        this.smpsControlerStatus = smpsControlerStatus;
    }

    public String getSmpsEarthingStatus() {
        return smpsEarthingStatus;
    }

    public void setSmpsEarthingStatus(String smpsEarthingStatus) {
        this.smpsEarthingStatus = smpsEarthingStatus;
    }

    public String getDcLoadCurrentInFloat() {
        return dcLoadCurrentInFloat;
    }

    public void setDcLoadCurrentInFloat(String dcLoadCurrentInFloat) {
        this.dcLoadCurrentInFloat = dcLoadCurrentInFloat;
    }

    public String getBase64DcLoadCurrentPhoto() {
        return base64DcLoadCurrentPhoto;
    }

    public void setBase64DcLoadCurrentPhoto(String base64DcLoadCurrentPhoto) {
        this.base64DcLoadCurrentPhoto = base64DcLoadCurrentPhoto;
    }

    public String getDcLoadAmpPh() {
        return dcLoadAmpPh;
    }

    public void setDcLoadAmpPh(String dcLoadAmpPh) {
        this.dcLoadAmpPh = dcLoadAmpPh;
    }


    public SmpsCheckPoint(String detailsOfSmpsQrCodeScan, String smpsCondition, String smpsControlerStatus, String smpsEarthingStatus, String dcLoadCurrentInFloat, String base64DcLoadCurrentPhoto, String dcLoadAmpPh) {
        this.detailsOfSmpsQrCodeScan = detailsOfSmpsQrCodeScan;
        this.smpsCondition = smpsCondition;
        this.smpsControlerStatus = smpsControlerStatus;
        this.smpsEarthingStatus = smpsEarthingStatus;
        this.dcLoadCurrentInFloat = dcLoadCurrentInFloat;
        this.base64DcLoadCurrentPhoto = base64DcLoadCurrentPhoto;
        this.dcLoadAmpPh = dcLoadAmpPh;

    }
    public SmpsCheckPoint(){
        this.detailsOfSmpsQrCodeScan = "";
        this.smpsCondition = "";
        this.smpsControlerStatus = "";
        this.smpsEarthingStatus = "";
        this.dcLoadCurrentInFloat = "";
        this.base64DcLoadCurrentPhoto = "";
        this.dcLoadAmpPh = "";
    }
}
