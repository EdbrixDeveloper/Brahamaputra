package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserSitesList {
    @SerializedName("Success")
    private Integer Success;

    @SerializedName("Code")
    private String Code;

    @SerializedName("Message")
    private String Message;

    @SerializedName("SiteList")
    private List<UserSites> SiteList = null;

    public Integer getSuccess() {
        return Success;
    }

    public void setSuccess(Integer success) {
        Success = success;
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

    public List<UserSites> getSiteList() {
        return SiteList;
    }

    public void setSiteList(List<UserSites> siteList) {
        SiteList = siteList;
    }

   /* public GetUserSitesList(Integer success, String code, String message, List<UserSites> siteList) {
        Success = success;
        Code = code;
        Message = message;
        SiteList = siteList;
    }*/


}
