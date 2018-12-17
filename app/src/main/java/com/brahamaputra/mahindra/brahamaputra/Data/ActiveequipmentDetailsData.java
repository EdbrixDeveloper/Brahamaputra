package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class ActiveequipmentDetailsData {

    @SerializedName("typeofBTS")
    private String typeofBTS;

    @SerializedName("importanceOfSite")
    private String importanceOfSite;

    @SerializedName("numberOfDependantSites")
    private String numberOfDependantSites;

    @SerializedName("make")
    private String make;

    @SerializedName("DCLoadofBTSequipment")
    private String DCLoadofBTSequipment;

    @SerializedName("YearofInstallationatsite")
    private String YearofInstallationatsite;

    @SerializedName("PositionofAntennaTower")
    private String PositionofAntennaTower;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public ActiveequipmentDetailsData() {
        this.typeofBTS = "";
        this.importanceOfSite = "";
        this.numberOfDependantSites = "";
        this.make = "";
        this.DCLoadofBTSequipment = "";
        this.YearofInstallationatsite = "";
        this.PositionofAntennaTower = "";
        this.isSubmited = 0;
    }

    public ActiveequipmentDetailsData(String typeofBTS, String importanceOfSite, String numberOfDependantSites, String make, String DCLoadofBTSequipment, String yearofInstallationatsite, String positionofAntennaTower) {
        this.typeofBTS = typeofBTS;
        this.importanceOfSite = importanceOfSite;
        this.numberOfDependantSites = numberOfDependantSites;
        this.make = make;
        this.DCLoadofBTSequipment = DCLoadofBTSequipment;
        this.YearofInstallationatsite = yearofInstallationatsite;
        this.PositionofAntennaTower = positionofAntennaTower;
        //this.isSubmited=true;//007
        this.isSubmited = 1;
        if (!this.typeofBTS.isEmpty() && !this.make.isEmpty() && !this.DCLoadofBTSequipment.isEmpty()) {
            this.isSubmited = 2;
        } /*else {
            this.isSubmited = 1;
        }*/
    }

    public String getTypeofBTS() {
        return typeofBTS;
    }

    public void setTypeofBTS(String typeofBTS) {
        this.typeofBTS = typeofBTS;
    }

    public String getImportanceOfSite() {
        return importanceOfSite;
    }

    public void setImportanceOfSite(String importanceOfSite) {
        this.importanceOfSite = importanceOfSite;
    }

    public String getNumberOfDependantSites() {
        return numberOfDependantSites;
    }

    public void setNumberOfDependantSites(String numberOfDependantSites) {
        this.numberOfDependantSites = numberOfDependantSites;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDCLoadofBTSequipment() {
        return DCLoadofBTSequipment;
    }

    public void setDCLoadofBTSequipment(String DCLoadofBTSequipment) {
        this.DCLoadofBTSequipment = DCLoadofBTSequipment;
    }

    public String getYearofInstallationatsite() {
        return YearofInstallationatsite;
    }

    public void setYearofInstallationatsite(String yearofInstallationatsite) {
        YearofInstallationatsite = yearofInstallationatsite;
    }

    public String getPositionofAntennaTower() {
        return PositionofAntennaTower;
    }

    public void setPositionofAntennaTower(String positionofAntennaTower) {
        PositionofAntennaTower = positionofAntennaTower;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }


}
