
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmpsCheckPointParentData implements Serializable
{

    @SerializedName("noOfSmpsAvailableAtSite")
    @Expose
    private String noOfSmpsAvailableAtSite;
    @SerializedName("smpsCheckPointsData")
    @Expose
    private List<SmpsCheckPoint> smpsCheckPointsData = null;

    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    public String getNoOfSmpsAvailableAtSite() {
        return noOfSmpsAvailableAtSite;
    }

    public void setNoOfSmpsAvailableAtSite(String noOfSmpsAvailableAtSite) {
        this.noOfSmpsAvailableAtSite = noOfSmpsAvailableAtSite;
    }

    public List<SmpsCheckPoint> getSmpsCheckPointsData() {
        return smpsCheckPointsData;
    }

    public void setSmpsCheckPointsData(List<SmpsCheckPoint> smpsCheckPointsData) {
        this.smpsCheckPointsData = smpsCheckPointsData;
    }

    public SmpsCheckPointParentData(String noOfSmpsAvailableAtSite, List<SmpsCheckPoint> smpsCheckPointsData, String registerFault, String typeOfFault,String base64StringUploadPhotoOfRegisterFault) {
        this.noOfSmpsAvailableAtSite = noOfSmpsAvailableAtSite;
        this.smpsCheckPointsData = smpsCheckPointsData;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        if(!this.noOfSmpsAvailableAtSite.isEmpty())
        {
            isSubmited = 2;
        }else{
            isSubmited = 1;
        }
    }

    public SmpsCheckPointParentData(){
        this.noOfSmpsAvailableAtSite = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.smpsCheckPointsData = new ArrayList<>();
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.isSubmited = 0;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
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
}
