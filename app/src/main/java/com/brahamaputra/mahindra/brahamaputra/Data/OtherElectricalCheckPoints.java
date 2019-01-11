
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherElectricalCheckPoints implements Serializable
{

    @SerializedName("dcEnergyMeterstatus")
    @Expose
    private String dcEnergyMeterstatus;
    @SerializedName("aviationLamp")
    @Expose
    private String aviationLamp;
    @SerializedName("lightsInsideTheShelter")
    @Expose
    private String lightsInsideTheShelter;
    @SerializedName("lightsInSitePremisesBulkhead")
    @Expose
    private String lightsInSitePremisesBulkhead;
    private final static long serialVersionUID = -102542994464311110L;

    public OtherElectricalCheckPoints()
    {
        this.dcEnergyMeterstatus = "";
        this.aviationLamp = "";
        this.lightsInsideTheShelter = "";
        this.lightsInSitePremisesBulkhead = "";
    }

    public OtherElectricalCheckPoints(String dcEnergyMeterstatus,String aviationLamp,String lightsInsideTheShelter,String lightsInSitePremisesBulkhead)
    {
        this.dcEnergyMeterstatus = dcEnergyMeterstatus;
        this.aviationLamp = aviationLamp;
        this.lightsInsideTheShelter = lightsInsideTheShelter;
        this.lightsInSitePremisesBulkhead = lightsInSitePremisesBulkhead;
    }

    public String getDcEnergyMeterstatus() {
        return dcEnergyMeterstatus;
    }

    public void setDcEnergyMeterstatus(String dcEnergyMeterstatus) {
        this.dcEnergyMeterstatus = dcEnergyMeterstatus;
    }

    public String getAviationLamp() {
        return aviationLamp;
    }

    public void setAviationLamp(String aviationLamp) {
        this.aviationLamp = aviationLamp;
    }

    public String getLightsInsideTheShelter() {
        return lightsInsideTheShelter;
    }

    public void setLightsInsideTheShelter(String lightsInsideTheShelter) {
        this.lightsInsideTheShelter = lightsInsideTheShelter;
    }

    public String getLightsInSitePremisesBulkhead() {
        return lightsInSitePremisesBulkhead;
    }

    public void setLightsInSitePremisesBulkhead(String lightsInSitePremisesBulkhead) {
        this.lightsInSitePremisesBulkhead = lightsInSitePremisesBulkhead;
    }

}
