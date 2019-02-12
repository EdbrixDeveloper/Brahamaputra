package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ExternalTenantsPersonalDetailsParentData {

    @SerializedName("totalNumberofTanents")
    String totalNumberofTanents;

    @SerializedName("externalTenantsPersonalDetailsData")
    ArrayList<ExternalTenantsPersonalDetailsData> externalTenantsPersonalDetailsData;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public ExternalTenantsPersonalDetailsParentData() {
        this.totalNumberofTanents = "";
        this.externalTenantsPersonalDetailsData = new ArrayList<>();
        this.isSubmited = 0;
    }

    public ExternalTenantsPersonalDetailsParentData(String totalNumberofTanents, ArrayList<ExternalTenantsPersonalDetailsData> externalTenantsPersonalDetailsData) {
        this.totalNumberofTanents = totalNumberofTanents;
        this.externalTenantsPersonalDetailsData = externalTenantsPersonalDetailsData;
        //this.isSubmited = true;//007
        this.isSubmited = 1;
        if (!this.totalNumberofTanents.isEmpty()) {
            this.isSubmited = 2;
        }/* else {
            this.isSubmited = 1;
        }*/
    }

    public String getTotalNumberofTanents() {
        return totalNumberofTanents;
    }

    public void setTotalNumberofTanents(String totalNumberofTanents) {
        this.totalNumberofTanents = totalNumberofTanents;
    }

    public ArrayList<ExternalTenantsPersonalDetailsData> getExternalTenantsPersonalDetailsData() {
        return externalTenantsPersonalDetailsData;
    }

    public void setExternalTenantsPersonalDetailsData(ArrayList<ExternalTenantsPersonalDetailsData> externalTenantsPersonalDetailsData) {
        this.externalTenantsPersonalDetailsData = externalTenantsPersonalDetailsData;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
