
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmpsCheckPoint implements Serializable
{
    @SerializedName("detailsOfSmpsQrCodeScan")
    @Expose
    private String detailsOfSmpsQrCodeScan;
    @SerializedName("smpsCondition")
    @Expose
    private String smpsCondition;
    @SerializedName("smpsControlerStatus")
    @Expose
    private String smpsControlerStatus;
    @SerializedName("smpsEarthingStatus")
    @Expose
    private String smpsEarthingStatus;
    @SerializedName("dcLoadCurrentInFloat")
    @Expose
    private String dcLoadCurrentInFloat;
    @SerializedName("base64StringDcLoadCurrentPhoto")
    @Expose
    private String base64StringDcLoadCurrentPhoto;
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
        return base64StringDcLoadCurrentPhoto;
    }

    public void setBase64DcLoadCurrentPhoto(String base64DcLoadCurrentPhoto) {
        this.base64StringDcLoadCurrentPhoto = base64DcLoadCurrentPhoto;
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
        this.base64StringDcLoadCurrentPhoto = base64DcLoadCurrentPhoto;
        this.dcLoadAmpPh = dcLoadAmpPh;

    }
    public SmpsCheckPoint(){
        this.detailsOfSmpsQrCodeScan = "";
        this.smpsCondition = "";
        this.smpsControlerStatus = "";
        this.smpsEarthingStatus = "";
        this.dcLoadCurrentInFloat = "";
        this.base64StringDcLoadCurrentPhoto = "";
        this.dcLoadAmpPh = "";
    }
}
