package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class CircleList{

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("CircleName")
    @Expose
    private String circleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

}
