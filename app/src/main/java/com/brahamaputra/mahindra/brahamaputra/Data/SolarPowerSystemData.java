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

    public SolarPowerSystemData() {
        this.qRCodeScan = "";
        this.available = "";
        this.assetOwner = "";
        this.manufacturerMakeModel = "";
        this.cellPanel = "";
        this.capacityKW = "";
        this.amcYesNo = "";
        this.dateOfvalidityOfAmc = "";
    }

    public SolarPowerSystemData(String qRCodeScan, String available, String assetOwner, String manufacturerMakeModel, String cellPanel, String capacityKW, String amcYesNo, String dateOfvalidityOfAmc) {
        this.qRCodeScan = qRCodeScan;
        this.available = available;
        this.assetOwner = assetOwner;
        this.manufacturerMakeModel = manufacturerMakeModel;
        this.cellPanel = cellPanel;
        this.capacityKW = capacityKW;
        this.amcYesNo = amcYesNo;
        this.dateOfvalidityOfAmc = dateOfvalidityOfAmc;
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

    public void setManufacturerMakeModel(String manufacturerMakeModel) {
        this.manufacturerMakeModel = manufacturerMakeModel;
    }

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


}
