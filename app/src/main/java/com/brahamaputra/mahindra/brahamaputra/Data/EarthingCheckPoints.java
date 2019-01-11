
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EarthingCheckPoints implements Serializable
{

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
    @SerializedName("earthingCheckPoints")
    @Expose
    private List<EarthingCheckPoint> earthingCheckPoints = null;
    private final static long serialVersionUID = 2082877317620656429L;

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

    public List<EarthingCheckPoint> getEarthingCheckPoints() {
        return earthingCheckPoints;
    }

    public void setEarthingCheckPoints(List<EarthingCheckPoint> earthingCheckPoints) {
        this.earthingCheckPoints = earthingCheckPoints;
    }

}
