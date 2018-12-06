package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailsOfUnusedMaterialsParentData {

    @SerializedName("numberofUnusedAssetinSite")
    String numberofUnusedAssetinSite;

    @SerializedName("detailsOfUnusedMaterialsData")
    ArrayList<DetailsOfUnusedMaterialsData> detailsOfUnusedMaterialsData;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public DetailsOfUnusedMaterialsParentData(String numberofUnusedAssetinSite, ArrayList<DetailsOfUnusedMaterialsData> detailsOfUnusedMaterialsData) {
        this.numberofUnusedAssetinSite = numberofUnusedAssetinSite;
        this.detailsOfUnusedMaterialsData = detailsOfUnusedMaterialsData;
        //this.isSubmited = true;//007
        if (!this.numberofUnusedAssetinSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public DetailsOfUnusedMaterialsParentData() {
        this.numberofUnusedAssetinSite = "";
        this.detailsOfUnusedMaterialsData = new ArrayList<>();
        this.isSubmited = 0;
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

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
