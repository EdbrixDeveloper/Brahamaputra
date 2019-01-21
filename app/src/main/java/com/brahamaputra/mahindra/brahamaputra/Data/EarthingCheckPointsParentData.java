
package com.brahamaputra.mahindra.brahamaputra.Data;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EarthingCheckPointsParentData implements Serializable {

    @SerializedName("allNutBoltsAreIntact")
    @Expose
    private String allNutBoltsAreIntact;

    @SerializedName("igbOgbStatus")
    @Expose
    private String igbOgbStatus;

    @SerializedName("lightningArresterStatus")
    @Expose
    private String lightningArresterStatus;

    @SerializedName("numberOfEarthPit")
    @Expose
    private String numberOfEarthPit;

    @SerializedName("numberOfEarthPitVisible")
    @Expose
    private String numberOfEarthPitVisible;

    @SerializedName("registerFault")
    @Expose
    private String registerFault;

    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("earthingCheckPointsData")
    @Expose
    private List<EarthingCheckPointsData> earthingCheckPointsData;

    @SerializedName("isSubmited")
    private int isSubmited;

    private final static long serialVersionUID = 2082877317620656429L;

    public EarthingCheckPointsParentData() {
        this.allNutBoltsAreIntact = "";
        this.igbOgbStatus = "";
        this.lightningArresterStatus = "";
        this.numberOfEarthPit = "";
        this.numberOfEarthPitVisible = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.earthingCheckPointsData = new ArrayList<>();
        this.isSubmited = 0;

    }

    @SuppressLint("LongLogTag")
    public EarthingCheckPointsParentData(String allNutBoltsAreIntact, String igbOgbStatus, String lightningArresterStatus,
                                         String numberOfEarthPit, String numberOfEarthPitVisible, String registerFault, String typeOfFault, String base64StringUploadPhotoOfRegisterFault, List<EarthingCheckPointsData> earthingCheckPointsData) {
        this.allNutBoltsAreIntact = allNutBoltsAreIntact;
        this.igbOgbStatus = igbOgbStatus;
        this.lightningArresterStatus = lightningArresterStatus;
        this.numberOfEarthPit = numberOfEarthPit;
        this.numberOfEarthPitVisible = numberOfEarthPitVisible;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        this.earthingCheckPointsData = earthingCheckPointsData;

        if (!this.numberOfEarthPit.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getAllNutBoltsAreIntact() {
        return allNutBoltsAreIntact;
    }

    public void setAllNutBoltsAreIntact(String allNutBoltsAreIntact) {
        this.allNutBoltsAreIntact = allNutBoltsAreIntact;
    }

    public String getIgbOgbStatus() {
        return igbOgbStatus;
    }

    public void setIgbOgbStatus(String igbOgbStatus) {
        this.igbOgbStatus = igbOgbStatus;
    }

    public String getLightningArresterStatus() {
        return lightningArresterStatus;
    }

    public void setLightningArresterStatus(String lightningArresterStatus) {
        this.lightningArresterStatus = lightningArresterStatus;
    }

    public String getNumberOfEarthPit() {
        return numberOfEarthPit;
    }

    public void setNumberOfEarthPit(String numberOfEarthPit) {
        this.numberOfEarthPit = numberOfEarthPit;
    }

    public String getNumberOfEarthPitVisible() {
        return numberOfEarthPitVisible;
    }

    public void setNumberOfEarthPitVisible(String numberOfEarthPitVisible) {
        this.numberOfEarthPitVisible = numberOfEarthPitVisible;
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

    public List<EarthingCheckPointsData> getEarthingCheckPointsData() {
        return earthingCheckPointsData;
    }

    public void setEarthingCheckPointsData(List<EarthingCheckPointsData> earthingCheckPointsData) {
        this.earthingCheckPointsData = earthingCheckPointsData;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

}
