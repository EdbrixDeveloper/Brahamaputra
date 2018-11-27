package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class DetailsOfUnusedMaterialsData {

    /*@SerializedName("numberofUnusedAssetinSite")
    String numberofUnusedAssetinSite;*/

    @SerializedName("typeOfAsset")
    String typeOfAsset;

    @SerializedName("assetMake")
    String assetMake;

    @SerializedName("assetStatus")
    String assetStatus;

    @SerializedName("assetDescription")
    String assetDescription;

    /*@SerializedName("isSubmited")
    private Boolean isSubmited;*/


    public DetailsOfUnusedMaterialsData() {
        //this.numberofUnusedAssetinSite = "";
        this.typeOfAsset = "";
        this.assetMake = "";
        this.assetStatus = "";
        this.assetDescription = "";
        //this.isSubmited = false;
    }

    public DetailsOfUnusedMaterialsData(String typeOfAsset, String assetMake, String assetStatus, String assetDescription) {
        // this.numberofUnusedAssetinSite = numberofUnusedAssetinSite;
        this.typeOfAsset = typeOfAsset;
        this.assetMake = assetMake;
        this.assetStatus = assetStatus;
        this.assetDescription = assetDescription;
        //this.isSubmited = true;
    }

   /* public String getNumberofUnusedAssetinSite() {
        return numberofUnusedAssetinSite;
    }

    public void setNumberofUnusedAssetinSite(String numberofUnusedAssetinSite) {
        this.numberofUnusedAssetinSite = numberofUnusedAssetinSite;
    }*/

    public String getTypeOfAsset() {
        return typeOfAsset;
    }

    public void setTypeOfAsset(String typeOfAsset) {
        this.typeOfAsset = typeOfAsset;
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

   /* public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }*/

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }
}