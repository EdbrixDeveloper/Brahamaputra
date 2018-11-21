package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailsOfUnusedMaterialsParentData {

    @SerializedName("numberofUnusedAssetinSite")
    String numberofUnusedAssetinSite;

    @SerializedName("detailsOfUnusedMaterialsData")
    ArrayList<DetailsOfUnusedMaterialsData> detailsOfUnusedMaterialsData;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public DetailsOfUnusedMaterialsParentData(String numberofUnusedAssetinSite, ArrayList<DetailsOfUnusedMaterialsData> detailsOfUnusedMaterialsData) {
        this.numberofUnusedAssetinSite = numberofUnusedAssetinSite;
        this.detailsOfUnusedMaterialsData = detailsOfUnusedMaterialsData;
        this.isSubmited = true;
    }

    public DetailsOfUnusedMaterialsParentData(){
        this.numberofUnusedAssetinSite = "";
        this.detailsOfUnusedMaterialsData = new ArrayList<>();
        this.isSubmited = false;
    }

    public String getNumberofUnusedAssetinSite() {
        return numberofUnusedAssetinSite;
    }

    public void setNumberofUnusedAssetinSite(String numberofUnusedAssetinSite) {
        this.numberofUnusedAssetinSite = numberofUnusedAssetinSite;
    }

    public ArrayList<DetailsOfUnusedMaterialsData> getDetailsOfUnusedMaterialsData() {
        return detailsOfUnusedMaterialsData;
    }

    public void setDetailsOfUnusedMaterialsData(ArrayList<DetailsOfUnusedMaterialsData> detailsOfUnusedMaterialsData) {
        this.detailsOfUnusedMaterialsData = detailsOfUnusedMaterialsData;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }
}
