
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

    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;

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

    public AcCheckPointParentData(String noOfAcAvailableAtsite, List<AcCheckPoint> acCheckPoints, String registerFault, String typeOfFault) {
        this.noOfAcAvailableAtsite = noOfAcAvailableAtsite;
        this.acCheckPoints = acCheckPoints;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        if(!this.noOfAcAvailableAtsite.isEmpty()) {
            isSubmited = 2;
        }else {
            isSubmited = 1;
        }
    }

    public AcCheckPointParentData() {
        this.noOfAcAvailableAtsite = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.acCheckPoints = new ArrayList<>();
        this.isSubmited = 0;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }

    public String getRegisterFault() {
        return registerFault;
    }

    public void setRegisterFault(String registerFault) {
        this.registerFault = registerFault;
    }

    public String getTypeOfFault() {
        return typeOfFault;
    }

    public void setTypeOfFault(String typeOfFault) {
        this.typeOfFault = typeOfFault;
    }
}
