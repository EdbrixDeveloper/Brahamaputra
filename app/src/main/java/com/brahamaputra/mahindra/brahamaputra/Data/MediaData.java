package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;
public class MediaData {

    @SerializedName("typeOfMedia")
    private String typeOfMedia;

    public String getTypeOfMedia() {
        return typeOfMedia;
    }

    public void setTypeOfMedia(String typeOfMedia) {
        this.typeOfMedia = typeOfMedia;
    }

    public MediaData(String typeOfMedia) {
        this.typeOfMedia = typeOfMedia;
    }
}
