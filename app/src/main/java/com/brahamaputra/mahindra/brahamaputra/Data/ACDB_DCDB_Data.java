package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class ACDB_DCDB_Data {

    @SerializedName("numberofACDB")
    String numberofACDB;

    @SerializedName("acdbRatingAMP")
    String acdbRatingAMP;

    @SerializedName("numberofDCDB")
    String numberofDCDB;

    @SerializedName("freeCoolingDeviseStausFCU")
    String freeCoolingDeviseStausFCU;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public ACDB_DCDB_Data() {
        this.numberofACDB = "";
        this.acdbRatingAMP = "";
        this.numberofDCDB = "";
        this.freeCoolingDeviseStausFCU = "";
        this.isSubmited=false;
    }

    public ACDB_DCDB_Data(String numberofACDB, String acdbRatingAMP, String numberofDCDB, String freeCoolingDeviseStausFCU) {
        this.numberofACDB = numberofACDB;
        this.acdbRatingAMP = acdbRatingAMP;
        this.numberofDCDB = numberofDCDB;
        this.freeCoolingDeviseStausFCU = freeCoolingDeviseStausFCU;
        this.isSubmited=true;
    }

    public String getNumberofACDB() {
        return numberofACDB;
    }

    public void setNumberofACDB(String numberofACDB) {
        this.numberofACDB = numberofACDB;
    }

    public String getAcdbRatingAMP() {
        return acdbRatingAMP;
    }

    public void setAcdbRatingAMP(String acdbRatingAMP) {
        this.acdbRatingAMP = acdbRatingAMP;
    }

    public String getNumberofDCDB() {
        return numberofDCDB;
    }

    public void setNumberofDCDB(String numberofDCDB) {
        this.numberofDCDB = numberofDCDB;
    }

    public String getFreeCoolingDeviseStausFCU() {
        return freeCoolingDeviseStausFCU;
    }

    public void setFreeCoolingDeviseStausFCU(String freeCoolingDeviseStausFCU) {
        this.freeCoolingDeviseStausFCU = freeCoolingDeviseStausFCU;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }
}


