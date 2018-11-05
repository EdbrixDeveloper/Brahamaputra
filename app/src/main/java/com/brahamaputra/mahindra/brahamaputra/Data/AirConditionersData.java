package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class AirConditionersData {

    @SerializedName("noOfACprovided")
    String noOfACprovided;

    @SerializedName("numberOfACInWorkingCondition")
    String numberOfACInWorkingCondition;

    @SerializedName("qRCodeScan")
    String qRCodeScan;

    @SerializedName("assetOwner")
    String assetOwner;

    @SerializedName("typeOfAcSpliWindow")
    String typeOfAcSpliWindow;

    @SerializedName("manufacturerMakeModel")
    String manufacturerMakeModel;

    @SerializedName("acSerialNumber")
    String acSerialNumber;

    @SerializedName("capacityTr")
    String capacityTr;

    @SerializedName("dateOfInstallation")
    String dateOfInstallation;

    @SerializedName("amcYesNo")
    String amcYesNo;

    @SerializedName("dateOfvalidityOfAmc")
    String dateOfvalidityOfAmc;

    @SerializedName("workingCondition")
    String workingCondition;

    @SerializedName("natureOfProblem")
    String natureOfProblem;

    public AirConditionersData() {
    }

    public AirConditionersData(String noOfACprovided, String numberOfACInWorkingCondition, String qRCodeScan, String assetOwner, String typeOfAcSpliWindow, String manufacturerMakeModel, String acSerialNumber, String capacityTr, String dateOfInstallation, String amcYesNo, String dateOfvalidityOfAmc, String workingCondition, String natureOfProblem) {
        this.noOfACprovided = noOfACprovided;
        this.numberOfACInWorkingCondition = numberOfACInWorkingCondition;
        this.qRCodeScan = qRCodeScan;
        this.assetOwner = assetOwner;
        this.typeOfAcSpliWindow = typeOfAcSpliWindow;
        this.manufacturerMakeModel = manufacturerMakeModel;
        this.acSerialNumber = acSerialNumber;
        this.capacityTr = capacityTr;
        this.dateOfInstallation = dateOfInstallation;
        this.amcYesNo = amcYesNo;
        this.dateOfvalidityOfAmc = dateOfvalidityOfAmc;
        this.workingCondition = workingCondition;
        this.natureOfProblem = natureOfProblem;
    }

    public String getNoOfACprovided() {
        return noOfACprovided;
    }

    public void setNoOfACprovided(String noOfACprovided) {
        this.noOfACprovided = noOfACprovided;
    }

    public String getNumberOfACInWorkingCondition() {
        return numberOfACInWorkingCondition;
    }

    public void setNumberOfACInWorkingCondition(String numberOfACInWorkingCondition) {
        this.numberOfACInWorkingCondition = numberOfACInWorkingCondition;
    }

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

    public String getTypeOfAcSpliWindow() {
        return typeOfAcSpliWindow;
    }

    public void setTypeOfAcSpliWindow(String typeOfAcSpliWindow) {
        this.typeOfAcSpliWindow = typeOfAcSpliWindow;
    }

    public String getManufacturerMakeModel() {
        return manufacturerMakeModel;
    }

    public void setManufacturerMakeModel(String manufacturerMakeModel) {
        this.manufacturerMakeModel = manufacturerMakeModel;
    }

    public String getAcSerialNumber() {
        return acSerialNumber;
    }

    public void setAcSerialNumber(String acSerialNumber) {
        this.acSerialNumber = acSerialNumber;
    }

    public String getCapacityTr() {
        return capacityTr;
    }

    public void setCapacityTr(String capacityTr) {
        this.capacityTr = capacityTr;
    }

    public String getDateOfInstallation() {
        return dateOfInstallation;
    }

    public void setDateOfInstallation(String dateOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
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


}
