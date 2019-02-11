package com.brahamaputra.mahindra.brahamaputra.Data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SiteDieselTransactions {

    @SerializedName("LastDieselFillingDate")
    private String LastDieselFillingDate;

    @SerializedName("LastDieselStock")
    private String LastDieselStock;

    @SerializedName("LastDGHMR")
    private String LastDGHMR;

    @SerializedName("LastEBReading")
    private String LastEBReadingl;


    public String getLastDieselFillingDate() {
        return LastDieselFillingDate;
    }

    public void setLastDieselFillingDate(String lastDieselFillingDate) {
        LastDieselFillingDate = lastDieselFillingDate;
    }

    public String getLastDieselStock() {
        return LastDieselStock;
    }

    public void setLastDieselStock(String lastDieselStock) {
        LastDieselStock = lastDieselStock;
    }

    public String getLastDGHMR() {
        return LastDGHMR;
    }

    public void setLastDGHMR(String lastDGHMR) {
        LastDGHMR = lastDGHMR;
    }

    public String getLastEBReadingl() {
        return LastEBReadingl;
    }

    public void setLastEBReadingl(String lastEBReadingl) {
        LastEBReadingl = lastEBReadingl;
    }


}