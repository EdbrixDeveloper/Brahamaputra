
package com.brahamaputra.mahindra.brahamaputra.Data;

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
        this.earthingCheckPointsData = new ArrayList<>();
        this.isSubmited = 0;

    }

    public EarthingCheckPointsParentData(String allNutBoltsAreIntact, String igbOgbStatus, String lightningArresterStatus,
                                         String numberOfEarthPit, String numberOfEarthPitVisible, List<EarthingCheckPointsData> earthingCheckPointsData) {
        this.allNutBoltsAreIntact = allNutBoltsAreIntact;
        this.igbOgbStatus = igbOgbStatus;
        this.lightningArresterStatus = lightningArresterStatus;
        this.numberOfEarthPit = numberOfEarthPit;
        this.numberOfEarthPitVisible = numberOfEarthPitVisible;
        this.earthingCheckPointsData = earthingCheckPointsData;

        /*if (!this.numberOfEarthPit.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }*/
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
