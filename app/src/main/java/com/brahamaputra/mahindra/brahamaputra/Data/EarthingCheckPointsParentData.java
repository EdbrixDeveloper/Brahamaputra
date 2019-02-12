package com.brahamaputra.mahindra.brahamaputra.Data;
import android.annotation.SuppressLint;
import java.io.Serializable;
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

    @SerializedName("executeEarthPitTest")
    @Expose
    private String executeEarthPitTest;

    @SerializedName("valuePITNo1")
    @Expose
    private String valuePITNo1;

    @SerializedName("valuePITNo2")
    @Expose
    private String valuePITNo2;

    @SerializedName("valuePITNo3")
    @Expose
    private String valuePITNo3;

    @SerializedName("valuePITNo4")
    @Expose
    private String valuePITNo4;

    @SerializedName("valuePITNo5")
    @Expose
    private String valuePITNo5;

    @SerializedName("valuePITNo6")
    @Expose
    private String valuePITNo6;

    @SerializedName("valuePITNo7")
    @Expose
    private String valuePITNo7;

    @SerializedName("valuePITNo8")
    @Expose
    private String valuePITNo8;

    @SerializedName("earthNuetralVoltage")
    @Expose
    private String earthNuetralVoltage;
    @SerializedName("observationConclusion")
    @Expose
    private String observationConclusion;


    /*ValuePITNo1;
    ValuePITNo2;
    ValuePITNo3;
    ValuePITNo4;
    ValuePITNo5;
    ValuePITNo6;
    ValuePITNo7;
    ValuePITNo8;
    EarthNuetralVoltage;
    ObservationConclusion;*/

    @SerializedName("registerFault")
    @Expose
    private String registerFault;

    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    /*@SerializedName("earthingCheckPointsData")
    @Expose
    private List<EarthingCheckPointsData> earthingCheckPointsData;*/

    @SerializedName("isSubmited")
    private int isSubmited;

    public EarthingCheckPointsParentData() {
        this.allNutBoltsAreIntact = "";
        this.igbOgbStatus = "";
        this.lightningArresterStatus = "";
        this.numberOfEarthPit = "";
        this.numberOfEarthPitVisible = "";
        this.executeEarthPitTest = "";

        this.valuePITNo1 = "";
        this.valuePITNo2 = "";
        this.valuePITNo3 = "";
        this.valuePITNo4 = "";
        this.valuePITNo5 = "";
        this.valuePITNo6 = "";
        this.valuePITNo7 = "";
        this.valuePITNo8 = "";
        this.earthNuetralVoltage = "";
        this.observationConclusion = "";

        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        /*this.earthingCheckPointsData = new ArrayList<>();*/
        this.isSubmited = 0;

    }

    @SuppressLint("LongLogTag")
    public EarthingCheckPointsParentData(String allNutBoltsAreIntact, String igbOgbStatus, String lightningArresterStatus,
                                         String numberOfEarthPit, String numberOfEarthPitVisible, String executeEarthPitTest,
                                         String valuePITNo1, String valuePITNo2, String valuePITNo3,
                                         String valuePITNo4, String valuePITNo5, String valuePITNo6, String valuePITNo7, String valuePITNo8,
                                         String earthNuetralVoltage, String observationConclusion,
                                         String registerFault, String typeOfFault, String base64StringUploadPhotoOfRegisterFault) {
        this.allNutBoltsAreIntact = allNutBoltsAreIntact;
        this.igbOgbStatus = igbOgbStatus;
        this.lightningArresterStatus = lightningArresterStatus;
        this.numberOfEarthPit = numberOfEarthPit;
        this.numberOfEarthPitVisible = numberOfEarthPitVisible;
        this.executeEarthPitTest = executeEarthPitTest;

        this.valuePITNo1 = valuePITNo1;
        this.valuePITNo2 = valuePITNo2;
        this.valuePITNo3 = valuePITNo3;
        this.valuePITNo4 = valuePITNo4;
        this.valuePITNo5 = valuePITNo5;
        this.valuePITNo6 = valuePITNo6;
        this.valuePITNo7 = valuePITNo7;
        this.valuePITNo8 = valuePITNo8;
        this.earthNuetralVoltage = earthNuetralVoltage;
        this.observationConclusion = observationConclusion;

        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        /*, List<EarthingCheckPointsData> earthingCheckPointsData
        this.earthingCheckPointsData = earthingCheckPointsData;*/

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

    public String getExecuteEarthPitTest() {
        return executeEarthPitTest;
    }

    public void setExecuteEarthPitTest(String executeEarthPitTest) {
        this.executeEarthPitTest = executeEarthPitTest;
    }

    public String getValuePITNo1() {
        return valuePITNo1;
    }

    public void setValuePITNo1(String valuePITNo1) {
        this.valuePITNo1 = valuePITNo1;
    }

    public String getValuePITNo2() {
        return valuePITNo2;
    }

    public void setValuePITNo2(String valuePITNo2) {
        this.valuePITNo2 = valuePITNo2;
    }

    public String getValuePITNo3() {
        return valuePITNo3;
    }

    public void setValuePITNo3(String valuePITNo3) {
        this.valuePITNo3 = valuePITNo3;
    }

    public String getValuePITNo4() {
        return valuePITNo4;
    }

    public void setValuePITNo4(String valuePITNo4) {
        this.valuePITNo4 = valuePITNo4;
    }

    public String getValuePITNo5() {
        return valuePITNo5;
    }

    public void setValuePITNo5(String valuePITNo5) {
        this.valuePITNo5 = valuePITNo5;
    }

    public String getValuePITNo6() {
        return valuePITNo6;
    }

    public void setValuePITNo6(String valuePITNo6) {
        this.valuePITNo6 = valuePITNo6;
    }

    public String getValuePITNo7() {
        return valuePITNo7;
    }

    public void setValuePITNo7(String valuePITNo7) {
        this.valuePITNo7 = valuePITNo7;
    }

    public String getValuePITNo8() {
        return valuePITNo8;
    }

    public void setValuePITNo8(String valuePITNo8) {
        this.valuePITNo8 = valuePITNo8;
    }

    public String getEarthNuetralVoltage() {
        return earthNuetralVoltage;
    }

    public void setEarthNuetralVoltage(String earthNuetralVoltage) {
        this.earthNuetralVoltage = earthNuetralVoltage;
    }

    public String getObservationConclusion() {
        return observationConclusion;
    }

    public void setObservationConclusion(String observationConclusion) {
        this.observationConclusion = observationConclusion;
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

    /*public List<EarthingCheckPointsData> getEarthingCheckPointsData() {
        return earthingCheckPointsData;
    }

    public void setEarthingCheckPointsData(List<EarthingCheckPointsData> earthingCheckPointsData) {
        this.earthingCheckPointsData = earthingCheckPointsData;
    }*/

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

}
