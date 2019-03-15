
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlarmCheckPoints implements Serializable {


    @SerializedName("detailsOfWrmsQrCodeScan")
    @Expose
    private String detailsOfWrmsQrCodeScan;
    @SerializedName("doorOpenAlarm")
    @Expose
    private String doorOpenAlarm;
    @SerializedName("dgOn")
    @Expose
    private String dgOn;
    @SerializedName("dgOutputAvailable")
    @Expose
    private String dgOutputAvailable;
    @SerializedName("highRoomTemp")
    @Expose
    private String highRoomTemp;
    @SerializedName("fireSmoke")
    @Expose
    private String fireSmoke;
    @SerializedName("powerPlantFailure")
    @Expose
    private String powerPlantFailure;
    @SerializedName("alarmConfirmedByNoc")
    @Expose
    private String alarmConfirmedByNoc;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("isSubmited")
    private int isSubmited;

    public AlarmCheckPoints() {
        this.detailsOfWrmsQrCodeScan = "";
        this.doorOpenAlarm = "";
        this.dgOn = "";
        this.dgOutputAvailable = "";
        this.highRoomTemp = "";
        this.fireSmoke = "";
        this.powerPlantFailure = "";
        this.alarmConfirmedByNoc = "";
        this.remarks = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        isSubmited = 0;
    }

    public AlarmCheckPoints(String detailsOfWrmsQrCodeScan, String doorOpenAlarm, String dgOn, String dgOutputAvailable, String highRoomTemp,
                            String fireSmoke, String powerPlantFailure, String alarmConfirmedByNoc, String remarks, String registerFault,
                            String typeOfFault, String base64StringUploadPhotoOfRegisterFault) {
        this.detailsOfWrmsQrCodeScan = detailsOfWrmsQrCodeScan;
        this.doorOpenAlarm = doorOpenAlarm;
        this.dgOn = dgOn;
        this.dgOutputAvailable = dgOutputAvailable;
        this.highRoomTemp = highRoomTemp;
        this.fireSmoke = fireSmoke;
        this.powerPlantFailure = powerPlantFailure;
        this.alarmConfirmedByNoc = alarmConfirmedByNoc;
        this.remarks = remarks;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        /*this.isSubmited = 2;*/
        if (!this.detailsOfWrmsQrCodeScan.isEmpty() && !this.doorOpenAlarm.isEmpty() && !this.dgOn.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getDetailsOfWrmsQrCodeScan() {
        return detailsOfWrmsQrCodeScan;
    }

    public void setDetailsOfWrmsQrCodeScan(String detailsOfWrmsQrCodeScan) {
        this.detailsOfWrmsQrCodeScan = detailsOfWrmsQrCodeScan;
    }

    public String getDoorOpenAlarm() {
        return doorOpenAlarm;
    }

    public void setDoorOpenAlarm(String doorOpenAlarm) {
        this.doorOpenAlarm = doorOpenAlarm;
    }

    public String getDgOn() {
        return dgOn;
    }

    public void setDgOn(String dgOn) {
        this.dgOn = dgOn;
    }

    public String getDgOutputAvailable() {
        return dgOutputAvailable;
    }

    public void setDgOutputAvailable(String dgOutputAvailable) {
        this.dgOutputAvailable = dgOutputAvailable;
    }

    public String getHighRoomTemp() {
        return highRoomTemp;
    }

    public void setHighRoomTemp(String highRoomTemp) {
        this.highRoomTemp = highRoomTemp;
    }

    public String getFireSmoke() {
        return fireSmoke;
    }

    public void setFireSmoke(String fireSmoke) {
        this.fireSmoke = fireSmoke;
    }

    public String getPowerPlantFailure() {
        return powerPlantFailure;
    }

    public void setPowerPlantFailure(String powerPlantFailure) {
        this.powerPlantFailure = powerPlantFailure;
    }

    public String getAlarmConfirmedByNoc() {
        return alarmConfirmedByNoc;
    }

    public void setAlarmConfirmedByNoc(String alarmConfirmedByNoc) {
        this.alarmConfirmedByNoc = alarmConfirmedByNoc;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getBase64StringUploadPhotoOfRegisterFault() {
        return base64StringUploadPhotoOfRegisterFault;
    }

    public void setBase64StringUploadPhotoOfRegisterFault(String base64StringUploadPhotoOfRegisterFault) {
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

}
