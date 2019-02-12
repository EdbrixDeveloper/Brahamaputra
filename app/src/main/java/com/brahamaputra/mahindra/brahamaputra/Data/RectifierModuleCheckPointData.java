
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RectifierModuleCheckPointData implements Serializable
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

    public RectifierModuleCheckPointData(String base64RectifierModuleDetailsQrCodeScan, String base64RectifierPhotoBeforeCleaning, String base64RectifierPhotoAfterCleaning, String rectifierCleaning) {
        this.base64RectifierPhotoAfterCleaning = base64RectifierPhotoAfterCleaning;
        this.base64RectifierPhotoBeforeCleaning = base64RectifierPhotoBeforeCleaning;
        this.detailsOfRectifierModuleQrCodeScan = base64RectifierModuleDetailsQrCodeScan;
        this.rectifierCleaning = rectifierCleaning;
        /*this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;*/
    }

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



}
