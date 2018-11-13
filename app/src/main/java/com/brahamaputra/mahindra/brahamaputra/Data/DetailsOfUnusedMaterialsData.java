package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class DetailsOfUnusedMaterialsData {

    @SerializedName("numberofUnusedAssetinSite")
    String numberofUnusedAssetinSite;

    @SerializedName("assetMake")
    String assetMake;

    @SerializedName("assetStatus")
    String assetStatus;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public DetailsOfUnusedMaterialsData() {
        this.numberofUnusedAssetinSite = "";
        this.assetMake = "";
        this.assetStatus = "";
        this.isSubmited = false;
    }

    public DetailsOfUnusedMaterialsData(String numberofUnusedAssetinSite, String assetMake, String assetStatus) {
        this.numberofUnusedAssetinSite = numberofUnusedAssetinSite;
        this.assetMake = assetMake;
        this.assetStatus = assetStatus;
        this.isSubmited = true;
    }

    public String getNumberofUnusedAssetinSite() {
        return numberofUnusedAssetinSite;
    }

    public void setNumberofUnusedAssetinSite(String numberofUnusedAssetinSite) {
        this.numberofUnusedAssetinSite = numberofUnusedAssetinSite;
    }

    public String getAssetMake() {
        return assetMake;
    }

    public void setAssetMake(String assetMake) {
        this.assetMake = assetMake;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }


}
