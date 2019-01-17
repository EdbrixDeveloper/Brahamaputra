
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmpsCheckPointParentData implements Serializable
{

    @SerializedName("noOfSmpsAvailableAtSite")
    @Expose
    private String noOfSmpsAvailableAtSite;
    @SerializedName("smpsCheckPointsData")
    @Expose
    private List<SmpsCheckPoint> smpsCheckPointsData = null;
    private final static long serialVersionUID = -2356912691505734753L;

    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    public String getNoOfSmpsAvailableAtSite() {
        return noOfSmpsAvailableAtSite;
    }

    public void setNoOfSmpsAvailableAtSite(String noOfSmpsAvailableAtSite) {
        this.noOfSmpsAvailableAtSite = noOfSmpsAvailableAtSite;
    }

    public List<SmpsCheckPoint> getSmpsCheckPointsData() {
        return smpsCheckPointsData;
    }

    public void setSmpsCheckPointsData(List<SmpsCheckPoint> smpsCheckPointsData) {
        this.smpsCheckPointsData = smpsCheckPointsData;
    }

    public SmpsCheckPointParentData(String noOfSmpsAvailableAtSite, List<SmpsCheckPoint> smpsCheckPointsData) {
        this.noOfSmpsAvailableAtSite = noOfSmpsAvailableAtSite;
        this.smpsCheckPointsData = smpsCheckPointsData;
        if(!this.noOfSmpsAvailableAtSite.isEmpty())
        {
            isSubmited = 2;
        }else{
            isSubmited = 1;
        }
    }

    public SmpsCheckPointParentData(){
        this.noOfSmpsAvailableAtSite = "";
        this.smpsCheckPointsData = new ArrayList<>();;
        this.isSubmited = 0;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }
}
