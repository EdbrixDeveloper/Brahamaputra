package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcPmAcDetails {
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Make")
    @Expose
    private String make;
    @SerializedName("Capacity")
    @Expose
    private String capacity;
    @SerializedName("SerialNo")
    @Expose
    private String serialNo;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

}
