
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EbMeterBox implements Serializable
{

    @SerializedName("ebMeterBoxCondition")
    @Expose
    private String ebMeterBoxCondition;
    @SerializedName("ebMeterWorkingStatus")
    @Expose
    private String ebMeterWorkingStatus;
    @SerializedName("kitkatClayFuseStatus")
    @Expose
    private String kitkatClayFuseStatus;
    @SerializedName("sfuMccbStatus")
    @Expose
    private String sfuMccbStatus;
    @SerializedName("hrcFuseStatus")
    @Expose
    private String hrcFuseStatus;
    @SerializedName("acLoadAmpPh")
    @Expose
    private String acLoadAmpPh;
    @SerializedName("ebMeterReadingKwh")
    @Expose
    private String ebMeterReadingKwh;
    @SerializedName("ebServiceWireCondition")
    @Expose
    private String ebServiceWireCondition;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    private final static long serialVersionUID = -7989704559019063986L;

    public String getEbMeterBoxCondition() {
        return ebMeterBoxCondition;
    }

    public void setEbMeterBoxCondition(String ebMeterBoxCondition) {
        this.ebMeterBoxCondition = ebMeterBoxCondition;
    }

    public String getEbMeterWorkingStatus() {
        return ebMeterWorkingStatus;
    }

    public void setEbMeterWorkingStatus(String ebMeterWorkingStatus) {
        this.ebMeterWorkingStatus = ebMeterWorkingStatus;
    }

    public String getKitkatClayFuseStatus() {
        return kitkatClayFuseStatus;
    }

    public void setKitkatClayFuseStatus(String kitkatClayFuseStatus) {
        this.kitkatClayFuseStatus = kitkatClayFuseStatus;
    }

    public String getSfuMccbStatus() {
        return sfuMccbStatus;
    }

    public void setSfuMccbStatus(String sfuMccbStatus) {
        this.sfuMccbStatus = sfuMccbStatus;
    }

    public String getHrcFuseStatus() {
        return hrcFuseStatus;
    }

    public void setHrcFuseStatus(String hrcFuseStatus) {
        this.hrcFuseStatus = hrcFuseStatus;
    }

    public String getAcLoadAmpPh() {
        return acLoadAmpPh;
    }

    public void setAcLoadAmpPh(String acLoadAmpPh) {
        this.acLoadAmpPh = acLoadAmpPh;
    }

    public String getEbMeterReadingKwh() {
        return ebMeterReadingKwh;
    }

    public void setEbMeterReadingKwh(String ebMeterReadingKwh) {
        this.ebMeterReadingKwh = ebMeterReadingKwh;
    }

    public String getEbServiceWireCondition() {
        return ebServiceWireCondition;
    }

    public void setEbServiceWireCondition(String ebServiceWireCondition) {
        this.ebServiceWireCondition = ebServiceWireCondition;
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
