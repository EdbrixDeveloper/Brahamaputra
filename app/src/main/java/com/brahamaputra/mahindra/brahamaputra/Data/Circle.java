package com.brahamaputra.mahindra.brahamaputra.Data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Circle {

    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("CircleList")
    @Expose
    private List<CircleList> circleList = null;

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

    public List<CircleList> getCircleList() {
        return circleList;
    }

    public void setCircleList(List<CircleList> circleList) {
        this.circleList = circleList;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @SerializedName("Error")
    @Expose
    private Error error;
}
