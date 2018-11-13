package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;
public class MediaData {

    @SerializedName("typeOfMedia")
    private String typeOfMedia;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public String getTypeOfMedia() {
        return typeOfMedia;
    }

    public void setTypeOfMedia(String typeOfMedia) {
        this.typeOfMedia = typeOfMedia;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }

    public MediaData() {
        this.typeOfMedia = "";
        this.isSubmited=false;
    }

    public MediaData(String typeOfMedia) {
        this.typeOfMedia = typeOfMedia;
        this.isSubmited=true;
    }

}
