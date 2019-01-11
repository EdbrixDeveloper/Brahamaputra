
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcCheckPoints implements Serializable
{

    @SerializedName("noOfAcAvailableAtsite")
    @Expose
    private String noOfAcAvailableAtsite;
    @SerializedName("acCheckPoints")
    @Expose
    private List<AcCheckPoint> acCheckPoints = null;
    private final static long serialVersionUID = 3555383886849176421L;

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

}
