
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

    @SerializedName("testDoneAs")
    @Expose
    private String testDoneAs;

    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    ////////////////////

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


    /*
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

    public BatteryBankCheckPointsParentData() {
        this.noOfBatteryBankAvailableAtSite = "";
        this.batteryBankCheckPointsData = new ArrayList<>();
        this.base64StringUploadPhotoOfRegisterFault = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.testDoneAs = "";

        this.isSubmited = 0;

        ////////////////

        this.batteryBankDischargeTest = "";
        this.bdTestDetailsBatteryBankBackUpOfQRCodeScan = "";
        this.bdTestBatteryBankBackUpTicketNo = "";
        this.bdTestCustomer = "";
        this.bdTestCircle = "";
        this.bdTestState = "";
        this.bdTestSiteName = "";
        this.bdTestSiteId = "";
        this.bdTestSsa = "";
        this.bdTestUserFseNameDesignation = "";
        this.bdTestBatteryTestDateTime = "";
        this.typeOfBattery = "";
        this.bdTestBatteryBankMake = "";
        this.bdTestBatteryBankCapacity = "";
        this.bdTestNumberOfRectifireModuleWorking = "";
        this.bdTestSiteLoadOnBatteryInAmps = "";
        this.bdTestFloatVoltageBeforeBBTest = "";
        this.bdTestSingleModuleRating = "";
        this.bdTestNumberOfBatteryModule = "";
        //this.bdTestReadingTakenAt = "";
        /*this.bdTestVoltageModuleReading1 = "";
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
        this.bdTestTotalLoadCurrentInAmps = "";*/
        this.bdTestLastReadingTakenAt = "";
        this.bdTestBase64StringPhotoOfBatteryBank = "";
        this.bdTestRemarks = "";
        this.batteryBankCheckPointsChildData = new ArrayList<>();
        this.batteryBankCheckPointsViLionBatteryData = new ArrayList<>();
    }

    public BatteryBankCheckPointsParentData(String noOfBatteryBankAvailableAtSite, String registerFault, String typeOfFault, String testDoneAs, String base64StringUploadPhotoOfRegisterFault, List<BatteryBankCheckPointsData> batteryBankCheckPointsData,
            /*String registerFault, String typeOfFault,*/String batteryBankDischargeTest, String bdTestDetailsBatteryBankBackUpOfQRCodeScan,
                                            String bdTestBatteryBankBackUpTicketNo, String bdTestCustomer, String bdTestCircle, String bdTestState,
                                            String bdTestSiteName, String bdTestSiteId, String bdTestSsa, String bdTestUserFseNameDesignation,
                                            String bdTestBatteryTestDateTime, String typeOfBattery, String bdTestBatteryBankMake, String bdTestBatteryBankCapacity,
                                            String bdTestNumberOfRectifireModuleWorking, String bdTestSiteLoadOnBatteryInAmps, String bdTestFloatVoltageBeforeBBTest,
                                            String bdTestSingleModuleRating, String bdTestNumberOfBatteryModule, /*String bdTestReadingTakenAt,*/
                                            String bdTestLastReadingTakenAt, String bdTestBase64StringPhotoOfBatteryBank,
                                            String bdTestRemarks, List<BatteryBankCheckPointsChildData> batteryBankCheckPointsChildData,
                                            List<BatteryBankCheckPointsViLionBatteryData> batteryBankCheckPointsViLionBatteryData
    ) {
        /*
        String bdTestVoltageModuleReading1, String bdTestVoltageModuleReading2, String bdTestVoltageModuleReading3,
                                            String bdTestCurrentModuleReading1, String bdTestCurrentModuleReading2, String bdTestCurrentModuleReading3,
                                            String bdTestSocModuleReading1, String bdTestSocModuleReading2, String bdTestSocModuleReading3, String bdTestSohModuleReading1,
                                            String bdTestSohModuleReading2, String bdTestSohModuleReading3, String bdTestFloatVoltageInSmpsBusBarAfter30Min,
                                            String bdTestTotalLoadCurrentInAmps,
         */
        this.noOfBatteryBankAvailableAtSite = noOfBatteryBankAvailableAtSite;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.testDoneAs = testDoneAs;

        this.batteryBankCheckPointsData = batteryBankCheckPointsData;
        if (!noOfBatteryBankAvailableAtSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }

        //////////////////
        this.batteryBankDischargeTest = batteryBankDischargeTest;
        this.bdTestDetailsBatteryBankBackUpOfQRCodeScan = bdTestDetailsBatteryBankBackUpOfQRCodeScan;
        this.bdTestBatteryBankBackUpTicketNo = bdTestBatteryBankBackUpTicketNo;
        this.bdTestCustomer = bdTestCustomer;
        this.bdTestCircle = bdTestCircle;
        this.bdTestState = bdTestState;
        this.bdTestSiteName = bdTestSiteName;
        this.bdTestSiteId = bdTestSiteId;
        this.bdTestSsa = bdTestSsa;
        this.bdTestUserFseNameDesignation = bdTestUserFseNameDesignation;
        this.bdTestBatteryTestDateTime = bdTestBatteryTestDateTime;
        this.typeOfBattery = typeOfBattery;
        this.bdTestBatteryBankMake = bdTestBatteryBankMake;
        this.bdTestBatteryBankCapacity = bdTestBatteryBankCapacity;
        this.bdTestNumberOfRectifireModuleWorking = bdTestNumberOfRectifireModuleWorking;
        this.bdTestSiteLoadOnBatteryInAmps = bdTestSiteLoadOnBatteryInAmps;
        this.bdTestFloatVoltageBeforeBBTest = bdTestFloatVoltageBeforeBBTest;
        this.bdTestSingleModuleRating = bdTestSingleModuleRating;
        this.bdTestNumberOfBatteryModule = bdTestNumberOfBatteryModule;
        //this.bdTestReadingTakenAt = bdTestReadingTakenAt;

        /*this.bdTestVoltageModuleReading1 = bdTestVoltageModuleReading1;
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
        this.bdTestTotalLoadCurrentInAmps = bdTestTotalLoadCurrentInAmps;*/
        this.bdTestLastReadingTakenAt = bdTestLastReadingTakenAt;
        this.bdTestBase64StringPhotoOfBatteryBank = bdTestBase64StringPhotoOfBatteryBank;
        this.bdTestRemarks = bdTestRemarks;
        this.batteryBankCheckPointsChildData = batteryBankCheckPointsChildData;
        this.batteryBankCheckPointsViLionBatteryData = batteryBankCheckPointsViLionBatteryData;


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

    public String getTestDoneAs() {
        return testDoneAs;
    }

    public void setTestDoneAs(String testDoneAs) {
        this.testDoneAs = testDoneAs;
    }

    public String getBase64StringUploadPhotoOfRegisterFault() {
        return base64StringUploadPhotoOfRegisterFault;
    }

    public void setBase64StringUploadPhotoOfRegisterFault(String base64StringUploadPhotoOfRegisterFault) {
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
    }

    ///////////////////

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

}
