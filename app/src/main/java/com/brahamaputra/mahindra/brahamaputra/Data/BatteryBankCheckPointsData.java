
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatteryBankCheckPointsData implements Serializable {

    @SerializedName("detailsOfBatteryBankQrCodeScan")
    @Expose
    private String detailsOfBatteryBankQrCodeScan;

    @SerializedName("stripBoltTightnessAsPerTorque")
    @Expose
    private String stripBoltTightnessAsPerTorque;
    @SerializedName("petroleumJellyApplied")
    @Expose
    private String petroleumJellyApplied;
    /*@SerializedName("batteryCharger")
    @Expose
    private String batteryCharger;*/
    @SerializedName("batteryVentPlugStatus")
    @Expose
    private String batteryVentPlugStatus;
    @SerializedName("bbEarthingStatus")
    @Expose
    private String bbEarthingStatus;


    public BatteryBankCheckPointsData() {
        this.detailsOfBatteryBankQrCodeScan = "";
        this.stripBoltTightnessAsPerTorque = "";
        this.petroleumJellyApplied = "";
        this.batteryBankQrCodeSelection = "";
        this.batteryBankDischargeTest = "";
        //this.batteryCharger = "";
        this.batteryVentPlugStatus = "";
        this.bbEarthingStatus = "";

    }

    public BatteryBankCheckPointsData(String detailsOfBatteryBankQrCodeScan, String stripBoltTightnessAsPerTorque,
                                      String petroleumJellyApplied, String batteryBankQrCodeSelection, String batteryBankDischargeTest, String batteryVentPlugStatus, String bbEarthingStatus
    ) {
        this.detailsOfBatteryBankQrCodeScan = detailsOfBatteryBankQrCodeScan;
        this.stripBoltTightnessAsPerTorque = stripBoltTightnessAsPerTorque;
        this.petroleumJellyApplied = petroleumJellyApplied;
        this.batteryBankQrCodeSelection = batteryBankQrCodeSelection;
        this.batteryBankDischargeTest = batteryBankDischargeTest;
        this.batteryVentPlugStatus = batteryVentPlugStatus;
        this.bbEarthingStatus = bbEarthingStatus;

    }

    public String getDetailsOfBatteryBankQrCodeScan() {
        return detailsOfBatteryBankQrCodeScan;
    }

    public void setDetailsOfBatteryBankQrCodeScan(String detailsOfBatteryBankQrCodeScan) {
        this.detailsOfBatteryBankQrCodeScan = detailsOfBatteryBankQrCodeScan;
    }

    public String getStripBoltTightnessAsPerTorque() {
        return stripBoltTightnessAsPerTorque;
    }

    public void setStripBoltTightnessAsPerTorque(String stripBoltTightnessAsPerTorque) {
        this.stripBoltTightnessAsPerTorque = stripBoltTightnessAsPerTorque;
    }

    public String getPetroleumJellyApplied() {
        return petroleumJellyApplied;
    }

    public void setPetroleumJellyApplied(String petroleumJellyApplied) {
        this.petroleumJellyApplied = petroleumJellyApplied;
    }

    /*public String getBatteryCharger() {
        return batteryCharger;
    }

    public void setBatteryCharger(String batteryCharger) {
        this.batteryCharger = batteryCharger;
    }*/

    public String getBatteryVentPlugStatus() {
        return batteryVentPlugStatus;
    }

    public void setBatteryVentPlugStatus(String batteryVentPlugStatus) {
        this.batteryVentPlugStatus = batteryVentPlugStatus;
    }

    public String getBbEarthingStatus() {
        return bbEarthingStatus;
    }

    public void setBbEarthingStatus(String bbEarthingStatus) {
        this.bbEarthingStatus = bbEarthingStatus;
    }


    /////////////////////////////////////

    @SerializedName("batteryBankQrCodeSelection")
    @Expose
    private String batteryBankQrCodeSelection;

    @SerializedName("batteryBankDischargeTest")
    @Expose
    private String batteryBankDischargeTest;

    @SerializedName("bdTestDetailsBatteryBankBackUpOfQRCodeScan")
    @Expose
    private String bdTestDetailsBatteryBankBackUpOfQRCodeScan;
    @SerializedName("bdTestBatteryBankBackUpTicketNo")
    @Expose
    private String bdTestBatteryBankBackUpTicketNo;
    @SerializedName("bdTestCustomer")
    @Expose
    private String bdTestCustomer;
    @SerializedName("bdTestCircle")
    @Expose
    private String bdTestCircle;
    @SerializedName("bdTestState")
    @Expose
    private String bdTestState;
    @SerializedName("bdTestSiteName")
    @Expose
    private String bdTestSiteName;
    @SerializedName("bdTestSiteId")
    @Expose
    private String bdTestSiteId;
    @SerializedName("bdTestSsa")
    @Expose
    private String bdTestSsa;
    @SerializedName("bdTestUserFseNameDesignation")
    @Expose
    private String bdTestUserFseNameDesignation;
    @SerializedName("bdTestBatteryTestDateTime")
    @Expose
    private String bdTestBatteryTestDateTime;
    @SerializedName("typeOfBattery")
    @Expose
    private String typeOfBattery;
    @SerializedName("bdTestBatteryBankMake")
    @Expose
    private String bdTestBatteryBankMake;
    @SerializedName("bdTestBatteryBankCapacity")
    @Expose
    private String bdTestBatteryBankCapacity;
    @SerializedName("bdTestNumberOfRectifireModuleWorking")
    @Expose
    private String bdTestNumberOfRectifireModuleWorking;
    @SerializedName("bdTestSiteLoadOnBatteryInAmps")
    @Expose
    private String bdTestSiteLoadOnBatteryInAmps;
    @SerializedName("bdTestFloatVoltageBeforeBBTest")
    @Expose
    private String bdTestFloatVoltageBeforeBBTest;
    @SerializedName("bdTestSingleModuleRating")
    @Expose
    private String bdTestSingleModuleRating;
    @SerializedName("bdTestNumberOfBatteryModule")
    @Expose
    private String bdTestNumberOfBatteryModule;
    /*@SerializedName("bdTestReadingTakenAt")
    @Expose
    private String bdTestReadingTakenAt;*/

    /*@SerializedName("bdTestVoltageModuleReading1")
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
    private String bdTestTotalLoadCurrentInAmps;*/


    @SerializedName("bdTestLastReadingTakenAt")
    @Expose
    private String bdTestLastReadingTakenAt;
    @SerializedName("bdTestBase64StringPhotoOfBatteryBank")
    @Expose
    private String bdTestBase64StringPhotoOfBatteryBank;
    @SerializedName("bdTestRemarks")
    @Expose
    private String bdTestRemarks;

    @SerializedName("batteryBankCheckPointsChildData")
    @Expose
    private List<BatteryBankCheckPointsChildData> batteryBankCheckPointsChildData;

    @SerializedName("batteryBankCheckPointsViLionBatteryData")
    @Expose
    private List<BatteryBankCheckPointsViLionBatteryData> batteryBankCheckPointsViLionBatteryData;

    public String getBatteryBankQrCodeSelection() {
        return batteryBankQrCodeSelection;
    }

    public void setBatteryBankQrCodeSelection(String batteryBankQrCodeSelection) {
        this.batteryBankQrCodeSelection = batteryBankQrCodeSelection;
    }

    public String getBatteryBankDischargeTest() {
        return batteryBankDischargeTest;
    }

    public void setBatteryBankDischargeTest(String batteryBankDischargeTest) {
        this.batteryBankDischargeTest = batteryBankDischargeTest;
    }

    public String getBdTestDetailsBatteryBankBackUpOfQRCodeScan() {
        return bdTestDetailsBatteryBankBackUpOfQRCodeScan;
    }

    public void setBdTestDetailsBatteryBankBackUpOfQRCodeScan(String bdTestDetailsBatteryBankBackUpOfQRCodeScan) {
        this.bdTestDetailsBatteryBankBackUpOfQRCodeScan = bdTestDetailsBatteryBankBackUpOfQRCodeScan;
    }

    public String getBdTestBatteryBankBackUpTicketNo() {
        return bdTestBatteryBankBackUpTicketNo;
    }

    public void setBdTestBatteryBankBackUpTicketNo(String bdTestBatteryBankBackUpTicketNo) {
        this.bdTestBatteryBankBackUpTicketNo = bdTestBatteryBankBackUpTicketNo;
    }

    public String getBdTestCustomer() {
        return bdTestCustomer;
    }

    public void setBdTestCustomer(String bdTestCustomer) {
        this.bdTestCustomer = bdTestCustomer;
    }

    public String getBdTestCircle() {
        return bdTestCircle;
    }

    public void setBdTestCircle(String bdTestCircle) {
        this.bdTestCircle = bdTestCircle;
    }

    public String getBdTestState() {
        return bdTestState;
    }

    public void setBdTestState(String bdTestState) {
        this.bdTestState = bdTestState;
    }

    public String getBdTestSiteName() {
        return bdTestSiteName;
    }

    public void setBdTestSiteName(String bdTestSiteName) {
        this.bdTestSiteName = bdTestSiteName;
    }

    public String getBdTestSiteId() {
        return bdTestSiteId;
    }

    public void setBdTestSiteId(String bdTestSiteId) {
        this.bdTestSiteId = bdTestSiteId;
    }

    public String getBdTestSsa() {
        return bdTestSsa;
    }

    public void setBdTestSsa(String bdTestSsa) {
        this.bdTestSsa = bdTestSsa;
    }

    public String getBdTestUserFseNameDesignation() {
        return bdTestUserFseNameDesignation;
    }

    public void setBdTestUserFseNameDesignation(String bdTestUserFseNameDesignation) {
        this.bdTestUserFseNameDesignation = bdTestUserFseNameDesignation;
    }

    public String getBdTestBatteryTestDateTime() {
        return bdTestBatteryTestDateTime;
    }

    public void setBdTestBatteryTestDateTime(String bdTestBatteryTestDateTime) {
        this.bdTestBatteryTestDateTime = bdTestBatteryTestDateTime;
    }

    public String getTypeOfBattery() {
        return typeOfBattery;
    }

    public void setTypeOfBattery(String typeOfBattery) {
        this.typeOfBattery = typeOfBattery;
    }

    public String getBdTestBatteryBankMake() {
        return bdTestBatteryBankMake;
    }

    public void setBdTestBatteryBankMake(String bdTestBatteryBankMake) {
        this.bdTestBatteryBankMake = bdTestBatteryBankMake;
    }

    public String getBdTestBatteryBankCapacity() {
        return bdTestBatteryBankCapacity;
    }

    public void setBdTestBatteryBankCapacity(String bdTestBatteryBankCapacity) {
        this.bdTestBatteryBankCapacity = bdTestBatteryBankCapacity;
    }

    public String getBdTestNumberOfRectifireModuleWorking() {
        return bdTestNumberOfRectifireModuleWorking;
    }

    public void setBdTestNumberOfRectifireModuleWorking(String bdTestNumberOfRectifireModuleWorking) {
        this.bdTestNumberOfRectifireModuleWorking = bdTestNumberOfRectifireModuleWorking;
    }

    public String getBdTestSiteLoadOnBatteryInAmps() {
        return bdTestSiteLoadOnBatteryInAmps;
    }

    public void setBdTestSiteLoadOnBatteryInAmps(String bdTestSiteLoadOnBatteryInAmps) {
        this.bdTestSiteLoadOnBatteryInAmps = bdTestSiteLoadOnBatteryInAmps;
    }

    public String getBdTestFloatVoltageBeforeBBTest() {
        return bdTestFloatVoltageBeforeBBTest;
    }

    public void setBdTestFloatVoltageBeforeBBTest(String bdTestFloatVoltageBeforeBBTest) {
        this.bdTestFloatVoltageBeforeBBTest = bdTestFloatVoltageBeforeBBTest;
    }

    public String getBdTestSingleModuleRating() {
        return bdTestSingleModuleRating;
    }

    public void setBdTestSingleModuleRating(String bdTestSingleModuleRating) {
        this.bdTestSingleModuleRating = bdTestSingleModuleRating;
    }

    public String getBdTestNumberOfBatteryModule() {
        return bdTestNumberOfBatteryModule;
    }

    public void setBdTestNumberOfBatteryModule(String bdTestNumberOfBatteryModule) {
        this.bdTestNumberOfBatteryModule = bdTestNumberOfBatteryModule;
    }

    /*public String getBdTestReadingTakenAt() {
        return bdTestReadingTakenAt;
    }

    public void setBdTestReadingTakenAt(String bdTestReadingTakenAt) {
        this.bdTestReadingTakenAt = bdTestReadingTakenAt;
    }*/

    /*public String getBdTestVoltageModuleReading1() {
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
    }*/

    public String getBdTestLastReadingTakenAt() {
        return bdTestLastReadingTakenAt;
    }

    public void setBdTestLastReadingTakenAt(String bdTestLastReadingTakenAt) {
        this.bdTestLastReadingTakenAt = bdTestLastReadingTakenAt;
    }

    public String getBdTestBase64StringPhotoOfBatteryBank() {
        return bdTestBase64StringPhotoOfBatteryBank;
    }

    public void setBdTestBase64StringPhotoOfBatteryBank(String bdTestBase64StringPhotoOfBatteryBank) {
        this.bdTestBase64StringPhotoOfBatteryBank = bdTestBase64StringPhotoOfBatteryBank;
    }

    public String getBdTestRemarks() {
        return bdTestRemarks;
    }

    public void setBdTestRemarks(String bdTestRemarks) {
        this.bdTestRemarks = bdTestRemarks;
    }

    public List<BatteryBankCheckPointsChildData> getBatteryBankCheckPointsChildData() {
        return batteryBankCheckPointsChildData;
    }

    public void setBatteryBankCheckPointsChildData(List<BatteryBankCheckPointsChildData> batteryBankCheckPointsChildData) {
        this.batteryBankCheckPointsChildData = batteryBankCheckPointsChildData;
    }

    public List<BatteryBankCheckPointsViLionBatteryData> getBatteryBankCheckPointsViLionBatteryData() {
        return batteryBankCheckPointsViLionBatteryData;
    }

    public void setBatteryBankCheckPointsViLionBatteryData(List<BatteryBankCheckPointsViLionBatteryData> batteryBankCheckPointsViLionBatteryData) {
        this.batteryBankCheckPointsViLionBatteryData = batteryBankCheckPointsViLionBatteryData;
    }

}

