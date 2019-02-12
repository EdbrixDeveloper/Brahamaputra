package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PowerBackupsDGDataList {

    @SerializedName("DGMakeName")
    @Expose
    private String dGMakeName;
    @SerializedName("Capacity")
    @Expose
    private List<String> capacity = null;

    public String getDGMakeName() {
        return dGMakeName;
    }

    public void setDGMakeName(String dGMakeName) {
        this.dGMakeName = dGMakeName;
    }

    public List<String> getCapacity() {
        return capacity;
    }

    public void setCapacity(List<String> capacity) {
        this.capacity = capacity;
    }

}

