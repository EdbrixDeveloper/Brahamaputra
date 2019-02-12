package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;

public class PowerManagementSystemData {

    @SerializedName("newFieldAvailability")
    private String newFieldAvailability;

    @SerializedName("powerManagementSystemQR")
    private String powerManagementSystemQR;

    @SerializedName("assetOwner")
    private String assetOwner;

    @SerializedName("powerManagementSystemType")
    private String powerManagementSystemType;

    @SerializedName("powerManagementSystemMake")
    private String powerManagementSystemMake;

    @SerializedName("powerManagementSystemPosition")
    private String powerManagementSystemPosition;

    @SerializedName("powerManagementSystemStaus")
    private String powerManagementSystemStaus;

    @SerializedName("serialNumber")
    private String serialNumber;

    @SerializedName("workingCondition")
    private String workingCondition;

    @SerializedName("natureofProblem")
    private String natureofProblem;

    @SerializedName("qrCodeImageFileName")
    private String qrCodeImageFileName;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public String getNewFieldAvailability() {
        return newFieldAvailability;
    }

    public void setNewFieldAvailability(String newFieldAvailability) {
        this.newFieldAvailability = newFieldAvailability;
    }

    public String getPowerManagementSystemQR() {
        return powerManagementSystemQR;
    }

    public void setPowerManagementSystemQR(String powerManagementSystemQR) {
        this.powerManagementSystemQR = powerManagementSystemQR;
    }

    public String getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(String assetOwner) {
        this.assetOwner = assetOwner;
    }

    public String getPowerManagementSystemType() {
        return powerManagementSystemType;
    }

    public void setPowerManagementSystemType(String powerManagementSystemType) {
        this.powerManagementSystemType = powerManagementSystemType;
    }

    public String getPowerManagementSystemMake() {
        return powerManagementSystemMake;
    }

    public void setPowerManagementSystemMake(String powerManagementSystemMake) {
        this.powerManagementSystemMake = powerManagementSystemMake;
    }

    public String getPowerManagementSystemPosition() {
        return powerManagementSystemPosition;
    }

    public void setPowerManagementSystemPosition(String powerManagementSystemPosition) {
        this.powerManagementSystemPosition = powerManagementSystemPosition;
    }

    public String getPowerManagementSystemStaus() {
        return powerManagementSystemStaus;
    }

    public void setPowerManagementSystemStaus(String powerManagementSystemStaus) {
        this.powerManagementSystemStaus = powerManagementSystemStaus;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getWorkingCondition() {
        return workingCondition;
    }

    public void setWorkingCondition(String workingCondition) {
        this.workingCondition = workingCondition;
    }

    public String getNatureofProblem() {
        return natureofProblem;
    }

    public void setNatureofProblem(String natureofProblem) {
        this.natureofProblem = natureofProblem;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

    public PowerManagementSystemData() {
        this.newFieldAvailability = "";
        this.powerManagementSystemQR = "";
        this.assetOwner = "";
        this.powerManagementSystemType = "";
        this.powerManagementSystemMake = "";
        this.powerManagementSystemPosition = "";
        this.powerManagementSystemStaus = "";
        this.serialNumber = "";
        this.workingCondition = "";
        this.natureofProblem = "";
        this.qrCodeImageFileName = "";
        this.isSubmited = 0;
    }

    public String getQrCodeImageFileName() {
        return qrCodeImageFileName;
    }

    public void setQrCodeImageFileName(String qrCodeImageFileName) {
        this.qrCodeImageFileName = qrCodeImageFileName;
    }

    public PowerManagementSystemData(String newFieldAvailability, String powerManagementSystemQR, String assetOwner, String powerManagementSystemType, String powerManagementSystemMake, String powerManagementSystemPosition, String powerManagementSystemStaus, String serialNumber, String workingCondition, String natureofProblem, String qrCodeImageFileName) {
        this.newFieldAvailability = newFieldAvailability;
        this.powerManagementSystemQR = powerManagementSystemQR;
        this.assetOwner = assetOwner;
        this.powerManagementSystemType = powerManagementSystemType;
        this.powerManagementSystemMake = powerManagementSystemMake;
        this.powerManagementSystemPosition = powerManagementSystemPosition;
        this.powerManagementSystemStaus = powerManagementSystemStaus;
        this.serialNumber = serialNumber;
        this.workingCondition = workingCondition;
        this.natureofProblem = natureofProblem;
        this.qrCodeImageFileName = qrCodeImageFileName;
        //this.isSubmited=true;//007
        if (newFieldAvailability.equals("No")) {
            this.isSubmited = 2;
        } else if (newFieldAvailability.equals("Yes")) {
            if (!this.powerManagementSystemQR.isEmpty() && !this.assetOwner.isEmpty() && !this.powerManagementSystemType.isEmpty() && !this.powerManagementSystemMake.isEmpty() && !this.serialNumber.isEmpty()) {
                this.isSubmited = 2;
            } else {
                this.isSubmited = 1;
            }
        } else {
            this.isSubmited = 1;
        }
    }
}
