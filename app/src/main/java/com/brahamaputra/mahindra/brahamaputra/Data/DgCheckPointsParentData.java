package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DgCheckPointsParentData implements Serializable {

    @SerializedName("noOfDgAvailableAtSite")
    @Expose
    private String noOfDgAvailableAtSite;

    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("dgCheckPointsData")
    @Expose
    private List<DgCheckPointsData> dgCheckPointsData;

    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    public DgCheckPointsParentData() {
        this.noOfDgAvailableAtSite = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.dgCheckPointsData = new ArrayList<>();
        this.isSubmited = 0;
    }

    public DgCheckPointsParentData(String noOfDgAvailableAtSite, String registerFault, String typeOfFault,
                                   String base64StringUploadPhotoOfRegisterFault, List<DgCheckPointsData> dgCheckPointsData) {
        this.noOfDgAvailableAtSite = noOfDgAvailableAtSite;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        this.dgCheckPointsData = dgCheckPointsData;
        if (!this.noOfDgAvailableAtSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getNoOfDgAvailableAtSite() {
        return noOfDgAvailableAtSite;
    }

    public void setNoOfDgAvailableAtSite(String noOfDgAvailableAtSite) {
        this.noOfDgAvailableAtSite = noOfDgAvailableAtSite;
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

    public List<DgCheckPointsData> getDgCheckPointsData() {
        return dgCheckPointsData;
    }

    public void setDgCheckPointsData(List<DgCheckPointsData> dgCheckPointsData) {
        this.dgCheckPointsData = dgCheckPointsData;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }
}
