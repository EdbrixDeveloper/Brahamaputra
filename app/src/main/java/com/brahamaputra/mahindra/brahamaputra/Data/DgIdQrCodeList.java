package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DgIdQrCodeList {

    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Error")
    @Expose
    private Error error;
    @SerializedName("PowerBackupsDGDataList")
    @Expose
    private List<PowerBackupsDGDataList> powerBackupsDGDataList = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PowerBackupsDGDataList> getPowerBackupsDGDataList() {
        return powerBackupsDGDataList;
    }

    public void setPowerBackupsDGDataList(List<PowerBackupsDGDataList> powerBackupsDGDataList) {
        this.powerBackupsDGDataList = powerBackupsDGDataList;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

/////////////////////////////////////////////////////////////////
    /*@SerializedName("Success")
    private Integer Success;

    @SerializedName("Code")
    private String Code;

    @SerializedName("Message")
    private String Message;

    @SerializedName("Error")
    @Expose
    private Error error;*/

    /*@SerializedName("PowerBackupsDGMRQRList")
    private List<DgIdQrCode> PowerBackupsDGMRQRList = null;*/

    /*@SerializedName("PowerBackupsDGDataList")
    private List<String> powerBackupsDGDataList = null;

    public Integer getSuccess() {
        return Success;
    }

    public void setSuccess(Integer success) {
        Success = success;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }*/



    /*public List<DgIdQrCode> getPowerBackupsDGMRQRList() {
        return PowerBackupsDGMRQRList;
    }

    public void setPowerBackupsDGMRQRList(List<DgIdQrCode> powerBackupsDGMRQRList) {
        PowerBackupsDGMRQRList = powerBackupsDGMRQRList;
    }*/



    /*public List<String> getPowerBackupsDGDataList() {
        return powerBackupsDGDataList;
    }

    public void setPowerBackupsDGDataList(List<String> powerBackupsDGDataList) {
        this.powerBackupsDGDataList = powerBackupsDGDataList;
    }*/
}

