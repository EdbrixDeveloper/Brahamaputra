package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;

public class PowerBackupsDGData {

    /*@SerializedName("noOfEngineAlternator")
    String noOfEngineAlternator;

    @SerializedName("numberOfWorkingDg")
    String numberOfWorkingDg;*/

    @SerializedName("qRCodeScan")
    String qRCodeScan;

    @SerializedName("assetOwner")
    String assetOwner;

    @SerializedName("manufacturerMakeModel")
    String manufacturerMakeModel;

    @SerializedName("capacityInKva")
    String capacityInKva;

    @SerializedName("autoManual")
    String autoManual;

    @SerializedName("dieselTankCapacity")
    String dieselTankCapacity;

    @SerializedName("dateOfInstallation")
    String dateOfInstallation;

    @SerializedName("averageDieselConsumption")
    String averageDieselConsumption;

    @SerializedName("amc")
    String amc;

    @SerializedName("dateOfvalidityOfAmc")
    String dateOfvalidityOfAmc;

    @SerializedName("dgWorkingType")
    String dgWorkingType;

    @SerializedName("dgHmrReading")
    String dgHmrReading;

    @SerializedName("dgEngineSerialNo")
    String dgEngineSerialNo;

    @SerializedName("dgMainAltType")
    String dgMainAltType;

    @SerializedName("dgMainAltMake")
    String dgMainAltMake;

    @SerializedName("dgMainAltSerialNo")
    String dgMainAltSerialNo;

    @SerializedName("dgCanopyStatus")
    String dgCanopyStatus;

    @SerializedName("dgStartingBatteryStatus")
    String dgStartingBatteryStatus;

    @SerializedName("dgBatteryStatusQRCodeScan")
    String dgBatteryStatusQRCodeScan;

    @SerializedName("chargingAlternator")
    String chargingAlternator;

    @SerializedName("batteryCharger")
    String batteryCharger;

    @SerializedName("presentDieselStock")
    String presentDieselStock;

    @SerializedName("gcuRunHrs")
    String gcuRunHrs;

    @SerializedName("gcuKwh")
    String gcuKwh;

    @SerializedName("dgAvrWorkingStatus")
    String dgAvrWorkingStatus;

    @SerializedName("fuelTankPosition")
    String fuelTankPosition;

    @SerializedName("workingCondition")
    String workingCondition;

    @SerializedName("natureOfProblem")
    String natureOfProblem;

    @SerializedName("qrCodeImageFileName")
    String qrCodeImageFileName;

    @SerializedName("bookValue")
    String bookValue;

    public String getBookValue() {
        return bookValue;
    }

    public void setBookValue(String bookValue) {
        this.bookValue = bookValue;
    }
    //@SerializedName("isSubmited")
    //private Boolean isSubmited;

    public PowerBackupsDGData() {
        // this.noOfEngineAlternator = "";
        // this.numberOfWorkingDg = "";
        this.qRCodeScan = "";
        this.assetOwner = "";
        this.manufacturerMakeModel = "";
        this.capacityInKva = "";
        this.autoManual = "";
        this.dieselTankCapacity = "";
        this.dateOfInstallation = "";
        this.averageDieselConsumption = "";
        this.amc = "";
        this.dateOfvalidityOfAmc = "";
        this.dgWorkingType = "";
        this.dgHmrReading = "";
        this.dgEngineSerialNo = "";
        this.dgMainAltType = "";
        this.dgMainAltMake = "";
        this.dgMainAltSerialNo = "";
        this.dgCanopyStatus = "";
        this.dgStartingBatteryStatus = "";
        this.dgBatteryStatusQRCodeScan = "";
        this.chargingAlternator = "";
        this.batteryCharger = "";
        this.presentDieselStock = "";
        this.gcuRunHrs = "";
        this.gcuKwh = "";
        this.dgAvrWorkingStatus = "";
        this.fuelTankPosition = "";
        this.workingCondition = "";
        this.natureOfProblem = "";
        this.qrCodeImageFileName = "";
        this.bookValue = "";
        //this.isSubmited=false;
    }

    public PowerBackupsDGData(String qRCodeScan, String bookValue,String assetOwner, String manufacturerMakeModel, String capacityInKva, String autoManual, String dieselTankCapacity, String dateOfInstallation, String averageDieselConsumption, String amc, String dateOfvalidityOfAmc, String dgWorkingType, String dgHmrReading, String dgEngineSerialNo, String dgMainAltType, String dgMainAltMake, String dgMainAltSerialNo, String dgCanopyStatus, String dgStartingBatteryStatus, String dgBatteryStatusQRCodeScan, String chargingAlternator, String batteryCharger, String presentDieselStock, String gcuRunHrs, String gcuKwh, String dgAvrWorkingStatus, String fuelTankPosition, String workingCondition, String natureOfProblem, String qrCodeImageFileName) {
        // this.noOfEngineAlternator = noOfEngineAlternator;
        // this.numberOfWorkingDg = numberOfWorkingDg;
        this.qRCodeScan = qRCodeScan;
        this.assetOwner = assetOwner;
        this.manufacturerMakeModel = manufacturerMakeModel;
        this.capacityInKva = capacityInKva;
        this.autoManual = autoManual;
        this.dieselTankCapacity = dieselTankCapacity;
        this.dateOfInstallation = dateOfInstallation;
        this.averageDieselConsumption = averageDieselConsumption;
        this.amc = amc;
        this.dateOfvalidityOfAmc = dateOfvalidityOfAmc;
        this.dgWorkingType = dgWorkingType;
        this.dgHmrReading = dgHmrReading;
        this.dgEngineSerialNo = dgEngineSerialNo;
        this.dgMainAltType = dgMainAltType;
        this.dgMainAltMake = dgMainAltMake;
        this.dgMainAltSerialNo = dgMainAltSerialNo;
        this.dgCanopyStatus = dgCanopyStatus;
        this.dgStartingBatteryStatus = dgStartingBatteryStatus;
        this.dgBatteryStatusQRCodeScan = dgBatteryStatusQRCodeScan;
        this.chargingAlternator = chargingAlternator;
        this.batteryCharger = batteryCharger;
        this.presentDieselStock = presentDieselStock;
        this.gcuRunHrs = gcuRunHrs;
        this.gcuKwh = gcuKwh;
        this.dgAvrWorkingStatus = dgAvrWorkingStatus;
        this.fuelTankPosition = fuelTankPosition;
        this.workingCondition = workingCondition;
        this.natureOfProblem = natureOfProblem;
        this.qrCodeImageFileName = qrCodeImageFileName;
        //this.isSubmited=true;
        this.bookValue=bookValue;
    }

    /*public String getNoOfEngineAlternator() {
        return noOfEngineAlternator;
    }

    public void setNoOfEngineAlternator(String noOfEngineAlternator) {
        this.noOfEngineAlternator = noOfEngineAlternator;
    }

    public String getNumberOfWorkingDg() {
        return numberOfWorkingDg;
    }

    public void setNumberOfWorkingDg(String numberOfWorkingDg) {
        this.numberOfWorkingDg = numberOfWorkingDg;
    }*/

    public String getqRCodeScan() {
        return qRCodeScan;
    }

    public void setqRCodeScan(String qRCodeScan) {
        this.qRCodeScan = qRCodeScan;
    }

    public String getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(String assetOwner) {
        this.assetOwner = assetOwner;
    }

    public String getManufacturerMakeModel() {
        return manufacturerMakeModel;
    }

    public void setManufacturerMakeModel(String manufacturerMakeModel) {
        this.manufacturerMakeModel = manufacturerMakeModel;
    }

    public String getCapacityInKva() {
        return capacityInKva;
    }

    public void setCapacityInKva(String capacityInKva) {
        this.capacityInKva = capacityInKva;
    }

    public String getAutoManual() {
        return autoManual;
    }

    public void setAutoManual(String autoManual) {
        this.autoManual = autoManual;
    }

    public String getDieselTankCapacity() {
        return dieselTankCapacity;
    }

    public void setDieselTankCapacity(String dieselTankCapacity) {
        this.dieselTankCapacity = dieselTankCapacity;
    }

    public String getDateOfInstallation() {
        return dateOfInstallation;
    }

    public void setDateOfInstallation(String dateOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
    }

    public String getAverageDieselConsumption() {
        return averageDieselConsumption;
    }

    public void setAverageDieselConsumption(String averageDieselConsumption) {
        this.averageDieselConsumption = averageDieselConsumption;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public String getDateOfvalidityOfAmc() {
        return dateOfvalidityOfAmc;
    }

    public void setDateOfvalidityOfAmc(String dateOfvalidityOfAmc) {
        this.dateOfvalidityOfAmc = dateOfvalidityOfAmc;
    }

    public String getDgWorkingType() {
        return dgWorkingType;
    }

    public void setDgWorkingType(String dgWorkingType) {
        this.dgWorkingType = dgWorkingType;
    }

    public String getDgHmrReading() {
        return dgHmrReading;
    }

    public void setDgHmrReading(String dgHmrReading) {
        this.dgHmrReading = dgHmrReading;
    }

    public String getDgEngineSerialNo() {
        return dgEngineSerialNo;
    }

    public void setDgEngineSerialNo(String dgEngineSerialNo) {
        this.dgEngineSerialNo = dgEngineSerialNo;
    }

    public String getDgMainAltType() {
        return dgMainAltType;
    }

    public void setDgMainAltType(String dgMainAltType) {
        this.dgMainAltType = dgMainAltType;
    }

    public String getDgMainAltMake() {
        return dgMainAltMake;
    }

    public void setDgMainAltMake(String dgMainAltMake) {
        this.dgMainAltMake = dgMainAltMake;
    }

    public String getDgMainAltSerialNo() {
        return dgMainAltSerialNo;
    }

    public void setDgMainAltSerialNo(String dgMainAltSerialNo) {
        this.dgMainAltSerialNo = dgMainAltSerialNo;
    }

    public String getDgCanopyStatus() {
        return dgCanopyStatus;
    }

    public void setDgCanopyStatus(String dgCanopyStatus) {
        this.dgCanopyStatus = dgCanopyStatus;
    }

    public String getDgStartingBatteryStatus() {
        return dgStartingBatteryStatus;
    }

    public void setDgStartingBatteryStatus(String dgStartingBatteryStatus) {
        this.dgStartingBatteryStatus = dgStartingBatteryStatus;
    }

    public String getDgBatteryStatusQRCodeScan() {
        return dgBatteryStatusQRCodeScan;
    }

    public void setDgBatteryStatusQRCodeScan(String dgBatteryStatusQRCodeScan) {
        this.dgBatteryStatusQRCodeScan = dgBatteryStatusQRCodeScan;
    }

    public String getChargingAlternator() {
        return chargingAlternator;
    }

    public void setChargingAlternator(String chargingAlternator) {
        this.chargingAlternator = chargingAlternator;
    }

    public String getBatteryCharger() {
        return batteryCharger;
    }

    public void setBatteryCharger(String batteryCharger) {
        this.batteryCharger = batteryCharger;
    }

    public String getPresentDieselStock() {
        return presentDieselStock;
    }

    public void setPresentDieselStock(String presentDieselStock) {
        this.presentDieselStock = presentDieselStock;
    }

    public String getGcuRunHrs() {
        return gcuRunHrs;
    }

    public void setGcuRunHrs(String gcuRunHrs) {
        this.gcuRunHrs = gcuRunHrs;
    }

    public String getGcuKwh() {
        return gcuKwh;
    }

    public void setGcuKwh(String gcuKwh) {
        this.gcuKwh = gcuKwh;
    }

    public String getDgAvrWorkingStatus() {
        return dgAvrWorkingStatus;
    }

    public void setDgAvrWorkingStatus(String dgAvrWorkingStatus) {
        this.dgAvrWorkingStatus = dgAvrWorkingStatus;
    }

    public String getFuelTankPosition() {
        return fuelTankPosition;
    }

    public void setFuelTankPosition(String fuelTankPosition) {
        this.fuelTankPosition = fuelTankPosition;
    }

    public String getWorkingCondition() {
        return workingCondition;
    }

    public void setWorkingCondition(String workingCondition) {
        this.workingCondition = workingCondition;
    }

    public String getNatureOfProblem() {
        return natureOfProblem;
    }

    public void setNatureOfProblem(String natureOfProblem) {
        this.natureOfProblem = natureOfProblem;
    }

    public String getQrCodeImageFileName() {
        return qrCodeImageFileName;
    }

    public void setQrCodeImageFileName(String qrCodeImageFileName) {
        this.qrCodeImageFileName = qrCodeImageFileName;
    }

    /*public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }*/
}
