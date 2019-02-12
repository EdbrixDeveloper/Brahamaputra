package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;

public class MediaData {

    @SerializedName("typeOfMedia")
    private String typeOfMedia;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public MediaData() {
        this.typeOfMedia = "";
        this.isSubmited = 0;
    }

    public MediaData(String typeOfMedia) {
        this.typeOfMedia = typeOfMedia;
        //this.isSubmited=true;//007
        this.isSubmited = 1;
        if (!this.typeOfMedia.isEmpty()) {
            this.isSubmited = 2;
        }/*else {
            this.isSubmited = 1;
        }*/
    }

    public String getTypeOfMedia() {
        return typeOfMedia;
    }

    public void setTypeOfMedia(String typeOfMedia) {
        this.typeOfMedia = typeOfMedia;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }


}
