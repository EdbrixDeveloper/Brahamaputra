
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatteryBankCheckPointsParentData implements Serializable {

    @SerializedName("noOfBatteryBankAvailableAtSite")
    @Expose
    private String noOfBatteryBankAvailableAtSite;
    @SerializedName("batteryBankCheckPointData")
    @Expose
    private List<BatteryBankCheckPointsData> batteryBankCheckPointsData;
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
    @Expose
    private int isSubmited = 0;

    //    private final static long serialVersionUID = 791430875205059677L;


    public BatteryBankCheckPointsParentData() {
        this.noOfBatteryBankAvailableAtSite = "";
        this.batteryBankCheckPointsData = new ArrayList<>();
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.isSubmited = 0;
    }

    public BatteryBankCheckPointsParentData(String noOfBatteryBankAvailableAtSite, String registerFault, String typeOfFault, String base64StringUploadPhotoOfRegisterFault, List<BatteryBankCheckPointsData> batteryBankCheckPointsData) {
        this.noOfBatteryBankAvailableAtSite = noOfBatteryBankAvailableAtSite;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.batteryBankCheckPointsData = batteryBankCheckPointsData;
        if(!noOfBatteryBankAvailableAtSite.isEmpty())
        {
            this.isSubmited = 2;
        }else {
            this.isSubmited = 1;
        }

    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }

    public String getNoOfBatteryBankAvailableAtSite() {
        return noOfBatteryBankAvailableAtSite;
    }

    public void setNoOfBatteryBankAvailableAtSite(String noOfBatteryBankAvailableAtSite) {
        this.noOfBatteryBankAvailableAtSite = noOfBatteryBankAvailableAtSite;
    }

    public List<BatteryBankCheckPointsData> getBatteryBankCheckPointsData() {
        return batteryBankCheckPointsData;
    }

    public void setBatteryBankCheckPointsData(List<BatteryBankCheckPointsData> batteryBankCheckPointsData) {
        this.batteryBankCheckPointsData = batteryBankCheckPointsData;
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
