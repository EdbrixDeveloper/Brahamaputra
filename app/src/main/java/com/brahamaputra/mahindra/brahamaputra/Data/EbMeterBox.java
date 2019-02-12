package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EbMeterBox implements Serializable {

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

    @SerializedName("acLoadAmpRPh")
    @Expose
    private String acLoadAmpRPh;

    @SerializedName("acLoadAmpYPh")
    @Expose
    private String acLoadAmpYPh;

    @SerializedName("acLoadAmpBPh")
    @Expose
    private String acLoadAmpBPh;

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
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("isSubmited")
    private int isSubmited;

    public EbMeterBox() {
        this.ebMeterBoxCondition = "";
        this.ebMeterWorkingStatus = "";
        this.kitkatClayFuseStatus = "";
        this.sfuMccbStatus = "";
        this.hrcFuseStatus = "";
        this.acLoadAmpRPh = "";
        this.acLoadAmpYPh = "";
        this.acLoadAmpBPh = "";
        this.ebMeterReadingKwh = "";
        this.ebServiceWireCondition = "";
        this.registerFault = "";
        this.typeOfFault = "";
        base64StringUploadPhotoOfRegisterFault = "";
        this.isSubmited = 0;
    }

    public EbMeterBox(String ebMeterBoxCondition, String ebMeterWorkingStatus, String kitkatClayFuseStatus, String sfuMccbStatus,
                      String hrcFuseStatus, String acLoadAmpRPh, String acLoadAmpYPh, String acLoadAmpBPh, String ebMeterReadingKwh,
                      String ebServiceWireCondition, String registerFault, String typeOfFault, String base64StringUploadPhotoOfRegisterFault) {
        this.ebMeterBoxCondition = ebMeterBoxCondition;
        this.ebMeterWorkingStatus = ebMeterWorkingStatus;
        this.kitkatClayFuseStatus = kitkatClayFuseStatus;
        this.sfuMccbStatus = sfuMccbStatus;
        this.hrcFuseStatus = hrcFuseStatus;
        this.acLoadAmpRPh = acLoadAmpRPh;
        this.acLoadAmpYPh = acLoadAmpYPh;
        this.acLoadAmpBPh = acLoadAmpBPh;
        this.ebMeterReadingKwh = ebMeterReadingKwh;
        this.ebServiceWireCondition = ebServiceWireCondition;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
        /*this.isSubmited = 2;*/
        if (!this.ebMeterBoxCondition.isEmpty() && !this.ebMeterWorkingStatus.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

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

    public String getAcLoadAmpRPh() {
        return acLoadAmpRPh;
    }

    public void setAcLoadAmpRPh(String acLoadAmpRPh) {
        this.acLoadAmpRPh = acLoadAmpRPh;
    }

    public String getAcLoadAmpYPh() {
        return acLoadAmpYPh;
    }

    public void setAcLoadAmpYPh(String acLoadAmpYPh) {
        this.acLoadAmpYPh = acLoadAmpYPh;
    }

    public String getAcLoadAmpBPh() {
        return acLoadAmpBPh;
    }

    public void setAcLoadAmpBPh(String acLoadAmpBPh) {
        this.acLoadAmpBPh = acLoadAmpBPh;
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
