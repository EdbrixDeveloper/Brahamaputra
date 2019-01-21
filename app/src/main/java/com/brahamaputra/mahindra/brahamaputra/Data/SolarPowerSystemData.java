package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class SolarPowerSystemData {

    @SerializedName("qRCodeScan")
    String qRCodeScan;

    @SerializedName("available")
    String available;

    @SerializedName("assetOwner")
    String assetOwner;

    @SerializedName("manufacturerMakeModel")
    String manufacturerMakeModel;

    @SerializedName("cellPanel")
    String cellPanel;

    @SerializedName("capacityKW")
    String capacityKW;

    @SerializedName("amcYesNo")
    String amcYesNo;

    @SerializedName("dateOfvalidityOfAmc")
    String dateOfvalidityOfAmc;

    @SerializedName("qrCodeImageFileName")
    String qrCodeImageFileName;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    @SerializedName("bookValue")
    String bookValue;
//
    @SerializedName("battery_manufacturerMakeModel")
    String battery_manufacturerMakeModel;

    @SerializedName("battery_capacityKW")
    String battery_capacityKW;

    @SerializedName("battery_bookValue")
    String battery_bookValue;

    @SerializedName("battery_amcYesNo")
    String battery_amcYesNo;

    @SerializedName("battery_dateOfvalidityOfAmc")
    String battery_dateOfvalidityOfAmc;

    @SerializedName("battery_supplier_same_as_Solar_Supplier")
    String battery_supplier_same_as_Solar_Supplier;


    public String getBookValue() {
        return bookValue;
    }

    public void setBookValue(String bookValue) {
        this.bookValue = bookValue;
    }

    public int getIsSubmited() {
        return isSubmited;
    }

    public void setIsSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }

    public SolarPowerSystemData() {
        this.qRCodeScan = "";
        this.available = "";
        this.assetOwner = "";
        this.manufacturerMakeModel = "";
        this.cellPanel = "";
        this.capacityKW = "";
        this.amcYesNo = "";
        this.dateOfvalidityOfAmc = "";
        this.qrCodeImageFileName = "";
        this.isSubmited = 0;
        this.bookValue ="";


        this.battery_manufacturerMakeModel = "";
        this.battery_capacityKW = "";
        this.battery_bookValue = "";
        this.battery_amcYesNo = "";
        this.battery_dateOfvalidityOfAmc = "";
        this.battery_supplier_same_as_Solar_Supplier = "";
    }

    public SolarPowerSystemData(String qRCodeScan, String bookValue,String available, String assetOwner, String manufacturerMakeModel, String cellPanel,
                                String capacityKW, String amcYesNo, String dateOfvalidityOfAmc, String qrCodeImageFileName,
                                String battery_manufacturerMakeModel, String battery_capacityKW, String battery_bookValue, String battery_amcYesNo,
                                String battery_dateOfvalidityOfAmc,String battery_supplier_same_as_Solar_Supplier) {
        this.qRCodeScan = qRCodeScan;
        this.available = available;
        this.assetOwner = assetOwner;
        this.manufacturerMakeModel = manufacturerMakeModel;
        this.cellPanel = cellPanel;
        this.capacityKW = capacityKW;
        this.amcYesNo = amcYesNo;
        this.dateOfvalidityOfAmc = dateOfvalidityOfAmc;
        this.qrCodeImageFileName = qrCodeImageFileName;
        this.bookValue = bookValue;

        this.battery_manufacturerMakeModel = battery_manufacturerMakeModel;
        this.battery_capacityKW = battery_capacityKW;
        this.battery_bookValue = battery_bookValue;
        this.battery_amcYesNo = battery_amcYesNo;
        this.battery_dateOfvalidityOfAmc = battery_dateOfvalidityOfAmc;
        this.battery_supplier_same_as_Solar_Supplier = battery_supplier_same_as_Solar_Supplier;

        //this.isSubmited=true;//007
        this.isSubmited = 1;
        if (!this.available.isEmpty()) {
            this.isSubmited = 2;
        }/*else {
            this.isSubmited = 1;
        }*/


    }

    public String getqRCodeScan() {
        return qRCodeScan;
    }

    public void setqRCodeScan(String qRCodeScan) {
        this.qRCodeScan = qRCodeScan;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
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

    public void setManufacturerMakeModel(String manufacturerMakeModel) { this.manufacturerMakeModel = manufacturerMakeModel; }

    public String getCellPanel() {
        return cellPanel;
    }

    public void setCellPanel(String cellPanel) {
        this.cellPanel = cellPanel;
    }

    public String getCapacityKW() {
        return capacityKW;
    }

    public void setCapacityKW(String capacityKW) {
        this.capacityKW = capacityKW;
    }

    public String getAmcYesNo() {
        return amcYesNo;
    }

    public void setAmcYesNo(String amcYesNo) {
        this.amcYesNo = amcYesNo;
    }

    public String getDateOfvalidityOfAmc() {
        return dateOfvalidityOfAmc;
    }

    public void setDateOfvalidityOfAmc(String dateOfvalidityOfAmc) {
        this.dateOfvalidityOfAmc = dateOfvalidityOfAmc;
    }

    public String getQrCodeImageFileName() {
        return qrCodeImageFileName;
    }

    public void setQrCodeImageFileName(String qrCodeImageFileName) {
        this.qrCodeImageFileName = qrCodeImageFileName;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

    public String getBattery_manufacturerMakeModel() {
        return battery_manufacturerMakeModel;
    }

    public void setBattery_manufacturerMakeModel(String battery_manufacturerMakeModel) {
        this.battery_manufacturerMakeModel = battery_manufacturerMakeModel;
    }

    public String getBattery_capacityKW() {
        return battery_capacityKW;
    }

    public void setBattery_capacityKW(String battery_capacityKW) {
        this.battery_capacityKW = battery_capacityKW;
    }

    public String getBattery_bookValue() {
        return battery_bookValue;
    }

    public void setBattery_bookValue(String battery_bookValue) {
        this.battery_bookValue = battery_bookValue;
    }

    public String getBattery_amcYesNo() {
        return battery_amcYesNo;
    }

    public void setBattery_amcYesNo(String battery_amcYesNo) {
        this.battery_amcYesNo = battery_amcYesNo;
    }

    public String getBattery_dateOfvalidityOfAmc() {
        return battery_dateOfvalidityOfAmc;
    }

    public void setBattery_dateOfvalidityOfAmc(String battery_dateOfvalidityOfAmc) {
        this.battery_dateOfvalidityOfAmc = battery_dateOfvalidityOfAmc;
    }

    public String getBattery_supplier_same_as_Solar_Supplier() {
        return battery_supplier_same_as_Solar_Supplier;
    }

    public void setBattery_supplier_same_as_Solar_Supplier(String battery_supplier_same_as_Solar_Supplier) {
        this.battery_supplier_same_as_Solar_Supplier = battery_supplier_same_as_Solar_Supplier;
    }
}
