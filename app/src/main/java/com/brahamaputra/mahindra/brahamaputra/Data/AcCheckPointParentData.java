
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcCheckPointParentData implements Serializable
{

    @SerializedName("noOfAcAvailableAtsite")
    @Expose
    private String noOfAcAvailableAtsite;
    @SerializedName("acCheckPoints")
    @Expose
    private List<AcCheckPoint> acCheckPoints = null;
    private final static long serialVersionUID = 3555383886849176421L;

    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    public String getNoOfAcAvailableAtsite() {
        return noOfAcAvailableAtsite;
    }

    public void setNoOfAcAvailableAtsite(String noOfAcAvailableAtsite) {
        this.noOfAcAvailableAtsite = noOfAcAvailableAtsite;
    }

    public List<AcCheckPoint> getAcCheckPoints() {
        return acCheckPoints;
    }

    public void setAcCheckPoints(List<AcCheckPoint> acCheckPoints) {
        this.acCheckPoints = acCheckPoints;
    }

    public AcCheckPointParentData(String noOfAcAvailableAtsite, List<AcCheckPoint> acCheckPoints) {
        this.noOfAcAvailableAtsite = noOfAcAvailableAtsite;
        this.acCheckPoints = acCheckPoints;
        if(!this.noOfAcAvailableAtsite.isEmpty())
        {
            isSubmited = 2;
        }else {
            isSubmited = 1;
        }
    }

    public AcCheckPointParentData() {
        this.noOfAcAvailableAtsite = "";
        this.acCheckPoints = new ArrayList<>();
        this.isSubmited = 0;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }
}
