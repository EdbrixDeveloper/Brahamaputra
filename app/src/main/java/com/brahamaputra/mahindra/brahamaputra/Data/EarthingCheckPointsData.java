
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EarthingCheckPointsData implements Serializable {

    @SerializedName("earthPitValue")
    @Expose
    private String earthPitValue;

    @SerializedName("registerFault")
    @Expose
    private String registerFault;

    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;

    /*@SerializedName("isSubmited")
        private Boolean isSubmited;*/

    private final static long serialVersionUID = 5934053737079112992L;

    public EarthingCheckPointsData() {
        this.earthPitValue = "";
        this.registerFault = "";
        this.typeOfFault = "";
    }

    public EarthingCheckPointsData(String earthPitValue, String registerFault, String typeOfFault) {
        this.earthPitValue = earthPitValue;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
    }

    public String getEarthPitValue() {
        return earthPitValue;
    }

    public void setEarthPitValue(String earthPitValue) {
        this.earthPitValue = earthPitValue;
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

    /* public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }*/

}
