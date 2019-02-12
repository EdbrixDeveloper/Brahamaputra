package com.brahamaputra.mahindra.brahamaputra.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DgBatteryCheckPointsParentData implements Serializable {

    @SerializedName("noOfDgBatteryavailableAtSite")
    @Expose
    private String noOfDgBatteryavailableAtSite;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("dgBatteryCheckPointsData")
    @Expose
    private List<DgBatteryCheckPointsData> dgBatteryCheckPointsData;

    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    public DgBatteryCheckPointsParentData() {
        this.noOfDgBatteryavailableAtSite = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.dgBatteryCheckPointsData = new ArrayList<>();
        this.isSubmited = 0;
    }

    public DgBatteryCheckPointsParentData(String noOfDgBatteryavailableAtSite, String registerFault, String typeOfFault, String base64StringUploadPhotoOfRegisterFault, List<DgBatteryCheckPointsData> dgBatteryCheckPointsData) {
        this.noOfDgBatteryavailableAtSite = noOfDgBatteryavailableAtSite;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        this.dgBatteryCheckPointsData = dgBatteryCheckPointsData;
        if (!this.noOfDgBatteryavailableAtSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getNoOfDgBatteryavailableAtSite() {
        return noOfDgBatteryavailableAtSite;
    }

    public void setNoOfDgBatteryavailableAtSite(String noOfDgBatteryavailableAtSite) {
        this.noOfDgBatteryavailableAtSite = noOfDgBatteryavailableAtSite;
    }

    public List<DgBatteryCheckPointsData> getDgBatteryCheckPointsData() {
        return dgBatteryCheckPointsData;
    }

    public void setDgBatteryCheckPointsData(List<DgBatteryCheckPointsData> dgBatteryCheckPointsData) {
        this.dgBatteryCheckPointsData = dgBatteryCheckPointsData;
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

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }

}
