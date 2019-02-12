
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RectifierModuleCheckPointParentData implements Serializable
{

    @SerializedName("noOfRectifierModuleAvailableAtSite")
    @Expose
    private String noOfRectifierModuleAvailableAtSite;
    @SerializedName("noOfModulesWorking")
    @Expose
    private String noOfModulesWorking;
    @SerializedName("noOfFaultyModulesInSite")
    @Expose
    private String noOfFaultyModulesInSite;
    @SerializedName("rectifierModuleCheckPointData")
    @Expose
    private List<RectifierModuleCheckPointData> rectifierModuleCheckPointData = null;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    String base64StringUploadPhotoOfRegisterFault;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited = 0;

    public RectifierModuleCheckPointParentData()
    {
        this.noOfRectifierModuleAvailableAtSite = "";
        this.noOfModulesWorking = "";
        this.noOfFaultyModulesInSite = "";
        this.rectifierModuleCheckPointData = null;
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.isSubmited = 0;
    }

    public RectifierModuleCheckPointParentData(String noOfRectifierModuleAvailableAtSite, String noOfModulesWorking, String noOfFaultyModulesAtSite, ArrayList<RectifierModuleCheckPointData> rectifierModuleCheckPointDataList, String registerFault, String typeOfFault, String base64StringUploadPhotoOfRegisterFault) {
        this.noOfRectifierModuleAvailableAtSite = noOfRectifierModuleAvailableAtSite;
        this.noOfModulesWorking = noOfModulesWorking;
        this.noOfFaultyModulesInSite = noOfFaultyModulesAtSite;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        this.rectifierModuleCheckPointData = rectifierModuleCheckPointDataList;

        if (!this.noOfRectifierModuleAvailableAtSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getNoOfRectifierModuleAvailableAtSite() {
        return noOfRectifierModuleAvailableAtSite;
    }

    public void setNoOfRectifierModuleAvailableAtSite(String noOfRectifierModuleAvailableAtSite) {
        this.noOfRectifierModuleAvailableAtSite = noOfRectifierModuleAvailableAtSite;
    }

    public String getNoOfModulesWorking() {
        return noOfModulesWorking;
    }

    public void setNoOfModulesWorking(String noOfModulesWorking) {
        this.noOfModulesWorking = noOfModulesWorking;
    }

    public String getNoOfFaultyModulesInSite() {
        return noOfFaultyModulesInSite;
    }

    public void setNoOfFaultyModulesInSite(String noOfFaultyModulesInSite) {
        this.noOfFaultyModulesInSite = noOfFaultyModulesInSite;
    }

    public List<RectifierModuleCheckPointData> getRectifierModuleCheckPointData() {
        return rectifierModuleCheckPointData;
    }

    public void setRectifierModuleCheckPointData(List<RectifierModuleCheckPointData> rectifierModuleCheckPointData) {
        this.rectifierModuleCheckPointData = rectifierModuleCheckPointData;
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
