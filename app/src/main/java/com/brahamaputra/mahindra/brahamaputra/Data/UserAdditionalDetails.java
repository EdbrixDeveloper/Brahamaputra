
package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAdditionalDetails {

    @SerializedName("CustomerId")
    @Expose
    private String CustomerId;

    @SerializedName("CustomerName")
    @Expose
    private String CustomerName;

    @SerializedName("CircleId")
    @Expose
    private String CircleId;

    @SerializedName("CircleName")
    @Expose
    private String CircleName;

    @SerializedName("StateId")
    @Expose
    private String StateId;

    @SerializedName("StateName")
    @Expose
    private String StateName;

    @SerializedName("SsaId")
    @Expose
    private String SsaId;

    @SerializedName("SsaName")
    @Expose
    private String SsaName;


    @SerializedName("SiteId")
    @Expose
    private String SiteId;

    @SerializedName("SiteName")
    @Expose
    private String SiteName;

    @SerializedName("SiteCode")
    @Expose
    private String SiteCode;

    @SerializedName("SiteAddress")
    @Expose
    private String SiteAddress;

    @SerializedName("EbOfficeName")
    @Expose
    private String EbOfficeName;


    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCircleId() {
        return CircleId;
    }

    public void setCircleId(String CircleId) {
        this.CircleId = CircleId;
    }

    public String getCircleName() {
        return CircleName;
    }

    public void setCircleName(String CircleName) {
        this.CircleName = CircleName;
    }

    public String getStateId() {
        return StateId;
    }

    public void setStateId(String StateId) {
        this.StateId = StateId;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String StateName) {
        this.StateName = StateName;
    }

    public String getSsaId() {
        return SsaId;
    }

    public void setSsaId(String SsaId) {
        this.SsaId = SsaId;
    }

    public String getSsaName() {
        return SsaName;
    }

    public void setSsaName(String SsaName) {
        this.SsaName = SsaName;
    }

    public String getSiteId() {
        return SiteId;
    }

    public void setSiteId(String SiteId) {
        this.SiteId = SiteId;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String SiteName) {
        this.SiteName = SiteName;
    }

    public String getSiteCode() {
        return SiteCode;
    }

    public void setSiteCode(String SiteCode) {
        this.SiteCode = SiteCode;
    }

    public String getSiteAddress() {
        return SiteAddress;
    }

    public void setSiteAddress(String SiteAddress) {
        this.SiteAddress = SiteAddress;
    }

    public String getEbOfficeName() {
        return EbOfficeName;
    }

    public void setEbOfficeName(String EbOfficeName) {
        this.EbOfficeName = EbOfficeName;
    }

}
