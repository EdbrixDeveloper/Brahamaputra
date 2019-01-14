package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class AirConditionersData {

   /* @SerializedName("noOfACprovided")
    String noOfACprovided;

    @SerializedName("numberOfACInWorkingCondition")
    String numberOfACInWorkingCondition;*/

    @SerializedName("qRCodeScan")
    String qRCodeScan;

    @SerializedName("assetOwner")
    String assetOwner;

    @SerializedName("typeOfAcSpliWindow")
    String typeOfAcSplitWindow;

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

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    //region Region Of Constructors
    public AirConditionersData() {
        //this.noOfACprovided = "";
        // this.numberOfACInWorkingCondition = "";
        this.qRCodeScan = "";
        this.assetOwner = "";
        this.typeOfAcSplitWindow = "";
        this.manufacturerMakeModel = "";
        this.acSerialNumber = "";
        this.capacityTr = "";
        this.dateOfInstallation = "";
        this.amcYesNo = "";
        this.dateOfvalidityOfAmc = "";
        this.workingCondition = "";
        this.natureOfProblem = "";
        this.qrCodeImageFileName = "";
        this.isSubmited = false;
        this.bookValue = "";
    }

    public AirConditionersData(String qRCodeScan, String assetOwner, String typeOfAcSplitWindow, String manufacturerMakeModel, String acSerialNumber, String capacityTr, String bookValue,String dateOfInstallation, String amcYesNo, String dateOfvalidityOfAmc, String workingCondition, String natureOfProblem, String qrCodeImageFileName) {
        // this.noOfACprovided = noOfACprovided;
        // this.numberOfACInWorkingCondition = numberOfACInWorkingCondition;
        this.qRCodeScan = qRCodeScan;
        this.assetOwner = assetOwner;
        this.typeOfAcSplitWindow = typeOfAcSplitWindow;
        this.manufacturerMakeModel = manufacturerMakeModel;
        this.acSerialNumber = acSerialNumber;
        this.capacityTr = capacityTr;
        this.dateOfInstallation = dateOfInstallation;
        this.amcYesNo = amcYesNo;
        this.dateOfvalidityOfAmc = dateOfvalidityOfAmc;
        this.workingCondition = workingCondition;
        this.natureOfProblem = natureOfProblem;
        this.qrCodeImageFileName = qrCodeImageFileName;
        this.bookValue = bookValue;
        this.isSubmited = true;
    }
    //endregion

    //region comment Section
   /* public String getNoOfACprovided() {
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
    }*/
    //endregion

    //region Region of Getter() Setter Properties
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

    public String getTypeOfAcSplitWindow() {
        return typeOfAcSplitWindow;
    }

    public void setTypeOfAcSplitWindow(String typeOfAcSplitWindow) {
        this.typeOfAcSplitWindow = typeOfAcSplitWindow;
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

    public String getQrCodeImageFileName() {
        return qrCodeImageFileName;
    }

    public void setQrCodeImageFileName(String qrCodeImageFileName) {
        this.qrCodeImageFileName = qrCodeImageFileName;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }
    //endregion
}
