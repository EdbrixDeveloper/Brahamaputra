
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RectifierModuleCheckPointDatum implements Serializable
{

    @SerializedName("detailsOfRectifierModuleQrCodeScan")
    @Expose
    private String detailsOfRectifierModuleQrCodeScan;
    @SerializedName("rectifierCleaning")
    @Expose
    private String rectifierCleaning;
    @SerializedName("base64RectifierPhotoBeforeCleaning")
    @Expose
    private String base64RectifierPhotoBeforeCleaning;
    @SerializedName("base64RectifierPhotoAfterCleaning")
    @Expose
    private String base64RectifierPhotoAfterCleaning;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    private final static long serialVersionUID = -6106004319522608280L;

    public String getDetailsOfRectifierModuleQrCodeScan() {
        return detailsOfRectifierModuleQrCodeScan;
    }

    public void setDetailsOfRectifierModuleQrCodeScan(String detailsOfRectifierModuleQrCodeScan) {
        this.detailsOfRectifierModuleQrCodeScan = detailsOfRectifierModuleQrCodeScan;
    }

    public String getRectifierCleaning() {
        return rectifierCleaning;
    }

    public void setRectifierCleaning(String rectifierCleaning) {
        this.rectifierCleaning = rectifierCleaning;
    }

    public String getBase64RectifierPhotoBeforeCleaning() {
        return base64RectifierPhotoBeforeCleaning;
    }

    public void setBase64RectifierPhotoBeforeCleaning(String base64RectifierPhotoBeforeCleaning) {
        this.base64RectifierPhotoBeforeCleaning = base64RectifierPhotoBeforeCleaning;
    }

    public String getBase64RectifierPhotoAfterCleaning() {
        return base64RectifierPhotoAfterCleaning;
    }

    public void setBase64RectifierPhotoAfterCleaning(String base64RectifierPhotoAfterCleaning) {
        this.base64RectifierPhotoAfterCleaning = base64RectifierPhotoAfterCleaning;
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
