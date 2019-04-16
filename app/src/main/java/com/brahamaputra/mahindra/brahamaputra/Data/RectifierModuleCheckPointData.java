
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
    @SerializedName("base64StringRectifierPhotoBeforeCleaning")
    @Expose
    private String base64StringRectifierPhotoBeforeCleaning;
    @SerializedName("base64StringRectifierPhotoAfterCleaning")
    @Expose
    private String base64StringRectifierPhotoAfterCleaning;
    /*@SerializedName("isQrCodeNew")
    @Expose
    private int isQrCodeNew;
*/
    public RectifierModuleCheckPointData(String base64RectifierModuleDetailsQrCodeScan, String base64RectifierPhotoBeforeCleaning, String base64RectifierPhotoAfterCleaning, String rectifierCleaning/*,int isQrCodeNew*/) {
        this.base64StringRectifierPhotoAfterCleaning = base64RectifierPhotoAfterCleaning;
        this.base64StringRectifierPhotoBeforeCleaning = base64RectifierPhotoBeforeCleaning;
        this.detailsOfRectifierModuleQrCodeScan = base64RectifierModuleDetailsQrCodeScan;
        this.rectifierCleaning = rectifierCleaning;
        /*this.isQrCodeNew = isQrCodeNew;*/
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
        return base64StringRectifierPhotoBeforeCleaning;
    }

    public void setBase64RectifierPhotoBeforeCleaning(String base64RectifierPhotoBeforeCleaning) {
        this.base64StringRectifierPhotoBeforeCleaning = base64RectifierPhotoBeforeCleaning;
    }

    public String getBase64RectifierPhotoAfterCleaning() {
        return base64StringRectifierPhotoAfterCleaning;
    }

    public void setBase64RectifierPhotoAfterCleaning(String base64RectifierPhotoAfterCleaning) {
        this.base64StringRectifierPhotoAfterCleaning = base64RectifierPhotoAfterCleaning;
    }

   /* public int getIsQrCodeNew() {
        return isQrCodeNew;
    }

    public void setIsQrCodeNew(int isQrCodeNew) {
        this.isQrCodeNew = isQrCodeNew;
    }*/

}
