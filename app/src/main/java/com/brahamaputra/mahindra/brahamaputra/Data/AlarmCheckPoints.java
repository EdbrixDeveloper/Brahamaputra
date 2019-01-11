
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlarmCheckPoints implements Serializable
{

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
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    private final static long serialVersionUID = -5880192528663814251L;

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

}
