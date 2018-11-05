package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class ActiveequipmentDetailsData {


    private String typeofBTS;
    private String importanceOfSite;
    private String numberOfDependantSites;
    private String make;
    private String DCLoadofBTSequipment;
    private String YearofInstallationatsite;
    private String PositionofAntennaTower;

    public ActiveequipmentDetailsData() {
    }

    public ActiveequipmentDetailsData(String typeofBTS, String importanceOfSite, String numberOfDependantSites, String make, String DCLoadofBTSequipment, String yearofInstallationatsite, String positionofAntennaTower) {
        this.typeofBTS = typeofBTS;
        this.importanceOfSite = importanceOfSite;
        this.numberOfDependantSites = numberOfDependantSites;
        this.make = make;
        this.DCLoadofBTSequipment = DCLoadofBTSequipment;
        YearofInstallationatsite = yearofInstallationatsite;
        PositionofAntennaTower = positionofAntennaTower;


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

}
