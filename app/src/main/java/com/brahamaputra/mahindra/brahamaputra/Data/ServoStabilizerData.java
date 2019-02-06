package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class ServoStabilizerData {

    @SerializedName("servoStabilizer_Qr")
    String servoStabilizer_Qr;

    @SerializedName("servoStabilizerWorkingStatus")
    String servoStabilizerWorkingStatus;

    @SerializedName("makeofServo")
    String makeofServo;

    @SerializedName("ratingofServo")
    String ratingofServo;

    @SerializedName("workingCondition")
    String workingCondition;

    @SerializedName("natureofProblem")
    String natureofProblem;

    @SerializedName("qrCodeImageFileName")
    private String qrCodeImageFileName;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public ServoStabilizerData() {
        this.servoStabilizer_Qr = "";
        this.servoStabilizerWorkingStatus = "";
        this.makeofServo = "";
        this.ratingofServo = "";
        this.workingCondition = "";
        this.natureofProblem = "";
        this.qrCodeImageFileName = "";
        this.isSubmited = 0;
    }

    public ServoStabilizerData(String servoStabilizer_Qr, String servoStabilizerWorkingStatus, String makeofServo, String ratingofServo, String workingCondition, String natureofProblem, String qrCodeImageFileName) {
        this.servoStabilizer_Qr = servoStabilizer_Qr;
        this.servoStabilizerWorkingStatus = servoStabilizerWorkingStatus;
        this.makeofServo = makeofServo;
        this.ratingofServo = ratingofServo;
        this.workingCondition = workingCondition;
        this.natureofProblem = natureofProblem;
        this.qrCodeImageFileName = qrCodeImageFileName;
        //this.isSubmited=true;//007
        if (servoStabilizerWorkingStatus.equals("Not Available")) {
            this.isSubmited = 2;
        } else {
            if (!this.servoStabilizer_Qr.isEmpty() && !this.servoStabilizerWorkingStatus.isEmpty()) {
                this.isSubmited = 2;
            } else {
                this.isSubmited = 1;
            }
        }
    }

    public String getServoStabilizer_Qr() {
        return servoStabilizer_Qr;
    }

    public void setServoStabilizer_Qr(String servoStabilizer_Qr) {
        this.servoStabilizer_Qr = servoStabilizer_Qr;
    }

    public String getServoStabilizerWorkingStatus() {
        return servoStabilizerWorkingStatus;
    }

    public void setServoStabilizerWorkingStatus(String servoStabilizerWorkingStatus) {
        this.servoStabilizerWorkingStatus = servoStabilizerWorkingStatus;
    }

    public String getMakeofServo() {
        return makeofServo;
    }

    public void setMakeofServo(String makeofServo) {
        this.makeofServo = makeofServo;
    }

    public String getRatingofServo() {
        return ratingofServo;
    }

    public void setRatingofServo(String ratingofServo) {
        this.ratingofServo = ratingofServo;
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

}
