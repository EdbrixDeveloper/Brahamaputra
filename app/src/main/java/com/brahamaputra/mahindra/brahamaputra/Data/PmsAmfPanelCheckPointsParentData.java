package com.brahamaputra.mahindra.brahamaputra.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PmsAmfPanelCheckPointsParentData implements Serializable
{

    @SerializedName("noOfPmsAmfPiuAvailableAtSite")
    @Expose
    private String noOfPmsAmfPiuAvailableAtSite;
    @SerializedName("pmsAmfPanelCheckPointsData")
    @Expose
    private List<PmsAmfPanelCheckPointsData> pmsAmfPanelCheckPointsData = null;

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
    private int isSubmited;

    public PmsAmfPanelCheckPointsParentData()
    {
        this.noOfPmsAmfPiuAvailableAtSite = "";
        this.pmsAmfPanelCheckPointsData = new ArrayList<>();
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        isSubmited = 0;
    }
    public PmsAmfPanelCheckPointsParentData(String noOfPmsAmfPuiAvailableAtSite, ArrayList<PmsAmfPanelCheckPointsData> pmsAmfPanelCheckPointsArrayList, String base64StringUploadPhotoOfRegisterFault, String registerFault, String typeOfFault) {
        this.noOfPmsAmfPiuAvailableAtSite = noOfPmsAmfPuiAvailableAtSite;
        this.pmsAmfPanelCheckPointsData = pmsAmfPanelCheckPointsArrayList;
        this.registerFault =registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        if (!this.noOfPmsAmfPiuAvailableAtSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }


    public String getNoOfPmsAmfPiuAvailableAtSite() {
        return noOfPmsAmfPiuAvailableAtSite;
    }

    public void setNoOfPmsAmfPiuAvailableAtSite(String noOfPmsAmfPiuAvailableAtSite) {
        this.noOfPmsAmfPiuAvailableAtSite = noOfPmsAmfPiuAvailableAtSite;
    }

    public List<PmsAmfPanelCheckPointsData> getPmsAmfPanelCheckPointsData() {
        return pmsAmfPanelCheckPointsData;
    }

    public void setPmsAmfPanelCheckPointsData(List<PmsAmfPanelCheckPointsData> pmsAmfPanelCheckPointsData) {
        this.pmsAmfPanelCheckPointsData = pmsAmfPanelCheckPointsData;
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
