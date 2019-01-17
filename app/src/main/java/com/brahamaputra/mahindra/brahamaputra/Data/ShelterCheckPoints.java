
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShelterCheckPoints implements Serializable
{

    @SerializedName("shelterCleaning")
    @Expose
    private String shelterCleaning;
    @SerializedName("shelterLeakage")
    @Expose
    private String shelterLeakage;
    @SerializedName("hatchPlateEntrysealed")
    @Expose
    private String hatchPlateEntrysealed;
    @SerializedName("shleterFloorStatus")
    @Expose
    private String shleterFloorStatus;
    @SerializedName("shelterEarthingStatus")
    @Expose
    private String shelterEarthingStatus;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;
    private final static long serialVersionUID = -536383988018643670L;

    public ShelterCheckPoints(){
        this.shelterCleaning = "";
        this.hatchPlateEntrysealed = "";
        this.shelterLeakage = "";
        this.shleterFloorStatus = "";
        this.shelterEarthingStatus = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.isSubmited = 0;
    }

    public ShelterCheckPoints(String shelterCleaning, String shelterLeakage, String hatchPlateEntrySealed, String shelterFloorStatus, String shelterEarthingStatus, String resultFault, String typeOfFault) {
        this.shelterCleaning = shelterCleaning;
        this.hatchPlateEntrysealed = hatchPlateEntrySealed;
        this.shelterLeakage = shelterLeakage;
        this.shleterFloorStatus = shelterFloorStatus;
        this.shelterEarthingStatus = shelterEarthingStatus;
        this.registerFault = resultFault;
        this.typeOfFault = typeOfFault;

         if (!this.shelterCleaning.isEmpty() && !this.hatchPlateEntrysealed.isEmpty() && !this.shelterLeakage.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getShelterCleaning() {
        return shelterCleaning;
    }

    public void setShelterCleaning(String shelterCleaning) {
        this.shelterCleaning = shelterCleaning;
    }

    public String getShelterLeakage() {
        return shelterLeakage;
    }

    public void setShelterLeakage(String shelterLeakage) {
        this.shelterLeakage = shelterLeakage;
    }

    public String getHatchPlateEntrysealed() {
        return hatchPlateEntrysealed;
    }

    public void setHatchPlateEntrysealed(String hatchPlateEntrysealed) {
        this.hatchPlateEntrysealed = hatchPlateEntrysealed;
    }

    public String getShleterFloorStatus() {
        return shleterFloorStatus;
    }

    public void setShleterFloorStatus(String shleterFloorStatus) {
        this.shleterFloorStatus = shleterFloorStatus;
    }

    public String getShelterEarthingStatus() {
        return shelterEarthingStatus;
    }

    public void setShelterEarthingStatus(String shelterEarthingStatus) {
        this.shelterEarthingStatus = shelterEarthingStatus;
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

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

}
