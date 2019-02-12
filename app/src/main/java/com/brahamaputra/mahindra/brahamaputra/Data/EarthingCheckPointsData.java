package com.brahamaputra.mahindra.brahamaputra.Data;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EarthingCheckPointsData implements Serializable {

    @SerializedName("earthPitValue")
    @Expose
    private String earthPitValue;


    /*@SerializedName("isSubmited")
        private Boolean isSubmited;*/

    public EarthingCheckPointsData() {
        this.earthPitValue = "";
    }

    public EarthingCheckPointsData(String earthPitValue) {
        this.earthPitValue = earthPitValue;
    }

    public String getEarthPitValue() {
        return earthPitValue;
    }

    public void setEarthPitValue(String earthPitValue) {
        this.earthPitValue = earthPitValue;
    }

    /* public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }*/

}
