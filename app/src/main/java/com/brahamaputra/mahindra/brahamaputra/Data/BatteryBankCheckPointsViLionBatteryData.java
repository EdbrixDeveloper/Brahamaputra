
package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BatteryBankCheckPointsViLionBatteryData implements Serializable {

    @SerializedName("bdTestReadingTakenAt")
    @Expose
    private String bdTestReadingTakenAt;
    @SerializedName("bdTestVoltageModuleReading1")
    @Expose
    private String bdTestVoltageModuleReading1;
    @SerializedName("bdTestVoltageModuleReading2")
    @Expose
    private String bdTestVoltageModuleReading2;
    @SerializedName("bdTestVoltageModuleReading3")
    @Expose
    private String bdTestVoltageModuleReading3;
    @SerializedName("bdTestCurrentModuleReading1")
    @Expose
    private String bdTestCurrentModuleReading1;
    @SerializedName("bdTestCurrentModuleReading2")
    @Expose
    private String bdTestCurrentModuleReading2;
    @SerializedName("bdTestCurrentModuleReading3")
    @Expose
    private String bdTestCurrentModuleReading3;
    @SerializedName("bdTestSocModuleReading1")
    @Expose
    private String bdTestSocModuleReading1;
    @SerializedName("bdTestSocModuleReading2")
    @Expose
    private String bdTestSocModuleReading2;
    @SerializedName("bdTestSocModuleReading3")
    @Expose
    private String bdTestSocModuleReading3;
    @SerializedName("bdTestSohModuleReading1")
    @Expose
    private String bdTestSohModuleReading1;
    @SerializedName("bdTestSohModuleReading2")
    @Expose
    private String bdTestSohModuleReading2;
    @SerializedName("bdTestSohModuleReading3")
    @Expose
    private String bdTestSohModuleReading3;

    @SerializedName("bdTestFloatVoltageInSmpsBusBarAfter30Min")
    @Expose
    private String bdTestFloatVoltageInSmpsBusBarAfter30Min;
    @SerializedName("bdTestTotalLoadCurrentInAmps")
    @Expose
    private String bdTestTotalLoadCurrentInAmps;

    public BatteryBankCheckPointsViLionBatteryData() {
        this.bdTestReadingTakenAt = "";
        this.bdTestVoltageModuleReading1 = "";
        this.bdTestVoltageModuleReading2 = "";
        this.bdTestVoltageModuleReading3 = "";
        this.bdTestCurrentModuleReading1 = "";
        this.bdTestCurrentModuleReading2 = "";
        this.bdTestCurrentModuleReading3 = "";
        this.bdTestSocModuleReading1 = "";
        this.bdTestSocModuleReading2 = "";
        this.bdTestSocModuleReading3 = "";
        this.bdTestSohModuleReading1 = "";
        this.bdTestSohModuleReading2 = "";
        this.bdTestSohModuleReading3 = "";

        this.bdTestFloatVoltageInSmpsBusBarAfter30Min = "";
        this.bdTestTotalLoadCurrentInAmps = "";

    }

    public BatteryBankCheckPointsViLionBatteryData(String bdTestReadingTakenAt,
                                                   String bdTestVoltageModuleReading1, String bdTestVoltageModuleReading2,
                                                   String bdTestVoltageModuleReading3,
                                                   String bdTestCurrentModuleReading1, String bdTestCurrentModuleReading2,
                                                   String bdTestCurrentModuleReading3,
                                                   String bdTestSocModuleReading1, String bdTestSocModuleReading2, String bdTestSocModuleReading3,
                                                   String bdTestSohModuleReading1, String bdTestSohModuleReading2, String bdTestSohModuleReading3,
                                                   String bdTestFloatVoltageInSmpsBusBarAfter30Min, String bdTestTotalLoadCurrentInAmps
    ) {
        this.bdTestReadingTakenAt = bdTestReadingTakenAt;

        this.bdTestVoltageModuleReading1 = bdTestVoltageModuleReading1;
        this.bdTestVoltageModuleReading2 = bdTestVoltageModuleReading2;
        this.bdTestVoltageModuleReading3 = bdTestVoltageModuleReading3;

        this.bdTestCurrentModuleReading1 = bdTestCurrentModuleReading1;
        this.bdTestCurrentModuleReading2 = bdTestCurrentModuleReading2;
        this.bdTestCurrentModuleReading3 = bdTestCurrentModuleReading3;

        this.bdTestSocModuleReading1 = bdTestSocModuleReading1;
        this.bdTestSocModuleReading2 = bdTestSocModuleReading2;
        this.bdTestSocModuleReading3 = bdTestSocModuleReading3;

        this.bdTestSohModuleReading1 = bdTestSohModuleReading1;
        this.bdTestSohModuleReading2 = bdTestSohModuleReading2;
        this.bdTestSohModuleReading3 = bdTestSohModuleReading3;

        this.bdTestFloatVoltageInSmpsBusBarAfter30Min = bdTestFloatVoltageInSmpsBusBarAfter30Min;
        this.bdTestTotalLoadCurrentInAmps = bdTestTotalLoadCurrentInAmps;
    }

    public String getBdTestReadingTakenAt() {
        return bdTestReadingTakenAt;
    }

    public void setBdTestReadingTakenAt(String bdTestReadingTakenAt) {
        this.bdTestReadingTakenAt = bdTestReadingTakenAt;
    }

    public String getBdTestVoltageModuleReading1() {
        return bdTestVoltageModuleReading1;
    }

    public void setBdTestVoltageModuleReading1(String bdTestVoltageModuleReading1) {
        this.bdTestVoltageModuleReading1 = bdTestVoltageModuleReading1;
    }

    public String getBdTestVoltageModuleReading2() {
        return bdTestVoltageModuleReading2;
    }

    public void setBdTestVoltageModuleReading2(String bdTestVoltageModuleReading2) {
        this.bdTestVoltageModuleReading2 = bdTestVoltageModuleReading2;
    }

    public String getBdTestVoltageModuleReading3() {
        return bdTestVoltageModuleReading3;
    }

    public void setBdTestVoltageModuleReading3(String bdTestVoltageModuleReading3) {
        this.bdTestVoltageModuleReading3 = bdTestVoltageModuleReading3;
    }

    public String getBdTestCurrentModuleReading1() {
        return bdTestCurrentModuleReading1;
    }

    public void setBdTestCurrentModuleReading1(String bdTestCurrentModuleReading1) {
        this.bdTestCurrentModuleReading1 = bdTestCurrentModuleReading1;
    }

    public String getBdTestCurrentModuleReading2() {
        return bdTestCurrentModuleReading2;
    }

    public void setBdTestCurrentModuleReading2(String bdTestCurrentModuleReading2) {
        this.bdTestCurrentModuleReading2 = bdTestCurrentModuleReading2;
    }

    public String getBdTestCurrentModuleReading3() {
        return bdTestCurrentModuleReading3;
    }

    public void setBdTestCurrentModuleReading3(String bdTestCurrentModuleReading3) {
        this.bdTestCurrentModuleReading3 = bdTestCurrentModuleReading3;
    }

    public String getBdTestSocModuleReading1() {
        return bdTestSocModuleReading1;
    }

    public void setBdTestSocModuleReading1(String bdTestSocModuleReading1) {
        this.bdTestSocModuleReading1 = bdTestSocModuleReading1;
    }

    public String getBdTestSocModuleReading2() {
        return bdTestSocModuleReading2;
    }

    public void setBdTestSocModuleReading2(String bdTestSocModuleReading2) {
        this.bdTestSocModuleReading2 = bdTestSocModuleReading2;
    }

    public String getBdTestSocModuleReading3() {
        return bdTestSocModuleReading3;
    }

    public void setBdTestSocModuleReading3(String bdTestSocModuleReading3) {
        this.bdTestSocModuleReading3 = bdTestSocModuleReading3;
    }

    public String getBdTestSohModuleReading1() {
        return bdTestSohModuleReading1;
    }

    public void setBdTestSohModuleReading1(String bdTestSohModuleReading1) {
        this.bdTestSohModuleReading1 = bdTestSohModuleReading1;
    }

    public String getBdTestSohModuleReading2() {
        return bdTestSohModuleReading2;
    }

    public void setBdTestSohModuleReading2(String bdTestSohModuleReading2) {
        this.bdTestSohModuleReading2 = bdTestSohModuleReading2;
    }

    public String getBdTestSohModuleReading3() {
        return bdTestSohModuleReading3;
    }

    public void setBdTestSohModuleReading3(String bdTestSohModuleReading3) {
        this.bdTestSohModuleReading3 = bdTestSohModuleReading3;
    }

    public String getBdTestFloatVoltageInSmpsBusBarAfter30Min() {
        return bdTestFloatVoltageInSmpsBusBarAfter30Min;
    }

    public void setBdTestFloatVoltageInSmpsBusBarAfter30Min(String bdTestFloatVoltageInSmpsBusBarAfter30Min) {
        this.bdTestFloatVoltageInSmpsBusBarAfter30Min = bdTestFloatVoltageInSmpsBusBarAfter30Min;
    }

    public String getBdTestTotalLoadCurrentInAmps() {
        return bdTestTotalLoadCurrentInAmps;
    }

    public void setBdTestTotalLoadCurrentInAmps(String bdTestTotalLoadCurrentInAmps) {
        this.bdTestTotalLoadCurrentInAmps = bdTestTotalLoadCurrentInAmps;
    }

}

