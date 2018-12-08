package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class SitePhotoCaptureData {

    @SerializedName("imageFileNameOfSite")
    private String imageFileNameOfSite;
    @SerializedName("base64StringSite")
    private String base64StringSite;
    @SerializedName("imageFileNameOfShelter")
    private String imageFileNameOfShelter;
    @SerializedName("base64StringShelter")
    private String base64StringShelter;
    @SerializedName("imageFileNameOfEbMeterBox")
    private String imageFileNameOfEbMeterBox;
    @SerializedName("base64StringEbMeterBox")
    private String base64StringEbMeterBox;
    @SerializedName("imageFileNameOfSmps")
    private String imageFileNameOfSmps;
    @SerializedName("base64StringSmps")
    private String base64StringSmps;
    @SerializedName("imageFileNameOfEbMeter")
    private String imageFileNameOfEbMeter;
    @SerializedName("base64StringEbMeter")
    private String base64StringEbMeter;
    @SerializedName("imageFileNameOfDgHmr")
    private String imageFileNameOfDgHmr;
    @SerializedName("base64StringDgHmr")
    private String base64StringDgHmr;
    @SerializedName("imageFileNameOfDgOverview")
    private String imageFileNameOfDgOverview;
    @SerializedName("base64StringDgOverview")
    private String base64StringDgOverview;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public SitePhotoCaptureData() {
        this.imageFileNameOfSite = "";
        this.base64StringSite = "";
        this.imageFileNameOfShelter = "";
        this.base64StringShelter = "";
        this.imageFileNameOfEbMeterBox = "";
        this.base64StringEbMeterBox = "";
        this.imageFileNameOfSmps = "";
        this.base64StringSmps = "";
        this.imageFileNameOfEbMeter = "";
        this.base64StringEbMeter = "";
        this.imageFileNameOfDgHmr = "";
        this.base64StringDgHmr = "";
        this.imageFileNameOfDgOverview = "";
        this.base64StringDgOverview = "";
        this.isSubmited = 0;
    }

    public SitePhotoCaptureData(String imageFileNameOfSite, String base64StringSite, String imageFileNameOfShelter, String base64StringShelter, String imageFileNameOfEbMeterBox, String base64StringEbMeterBox, String imageFileNameOfSmps, String base64StringSmps, String imageFileNameOfEbMeter, String base64StringEbMeter, String imageFileNameOfDgHmr, String base64StringDgHmr, String imageFileNameOfDgOverview, String base64StringDgOverview) {
        this.imageFileNameOfSite = imageFileNameOfSite;
        this.base64StringSite = base64StringSite;
        this.imageFileNameOfShelter = imageFileNameOfShelter;
        this.base64StringShelter = base64StringShelter;
        this.imageFileNameOfEbMeterBox = imageFileNameOfEbMeterBox;
        this.base64StringEbMeterBox = base64StringEbMeterBox;
        this.imageFileNameOfSmps = imageFileNameOfSmps;
        this.base64StringSmps = base64StringSmps;
        this.imageFileNameOfEbMeter = imageFileNameOfEbMeter;
        this.base64StringEbMeter = base64StringEbMeter;
        this.imageFileNameOfDgHmr = imageFileNameOfDgHmr;
        this.base64StringDgHmr = base64StringDgHmr;
        this.imageFileNameOfDgOverview = imageFileNameOfDgOverview;
        this.base64StringDgOverview = base64StringDgOverview;
        //this.isSubmited=true;//007
        if (!this.imageFileNameOfSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getImageFileNameOfSite() {
        return imageFileNameOfSite;
    }

    public void setImageFileNameOfSite(String imageFileNameOfSite) {
        this.imageFileNameOfSite = imageFileNameOfSite;
    }

    public String getBase64StringSite() {
        return base64StringSite;
    }

    public void setBase64StringSite(String base64StringSite) {
        this.base64StringSite = base64StringSite;
    }

    public String getImageFileNameOfShelter() {
        return imageFileNameOfShelter;
    }

    public void setImageFileNameOfShelter(String imageFileNameOfShelter) {
        this.imageFileNameOfShelter = imageFileNameOfShelter;
    }

    public String getBase64StringShelter() {
        return base64StringShelter;
    }

    public void setBase64StringShelter(String base64StringShelter) {
        this.base64StringShelter = base64StringShelter;
    }

    public String getImageFileNameOfEbMeterBox() {
        return imageFileNameOfEbMeterBox;
    }

    public void setImageFileNameOfEbMeterBox(String imageFileNameOfEbMeterBox) {
        this.imageFileNameOfEbMeterBox = imageFileNameOfEbMeterBox;
    }

    public String getBase64StringEbMeterBox() {
        return base64StringEbMeterBox;
    }

    public void setBase64StringEbMeterBox(String base64StringEbMeterBox) {
        this.base64StringEbMeterBox = base64StringEbMeterBox;
    }

    public String getImageFileNameOfSmps() {
        return imageFileNameOfSmps;
    }

    public void setImageFileNameOfSmps(String imageFileNameOfSmps) {
        this.imageFileNameOfSmps = imageFileNameOfSmps;
    }

    public String getBase64StringSmps() {
        return base64StringSmps;
    }

    public void setBase64StringSmps(String base64StringSmps) {
        this.base64StringSmps = base64StringSmps;
    }

    public String getImageFileNameOfEbMeter() {
        return imageFileNameOfEbMeter;
    }

    public void setImageFileNameOfEbMeter(String imageFileNameOfEbMeter) {
        this.imageFileNameOfEbMeter = imageFileNameOfEbMeter;
    }

    public String getBase64StringEbMeter() {
        return base64StringEbMeter;
    }

    public void setBase64StringEbMeter(String base64StringEbMeter) {
        this.base64StringEbMeter = base64StringEbMeter;
    }

    public String getImageFileNameOfDgHmr() {
        return imageFileNameOfDgHmr;
    }

    public void setImageFileNameOfDgHmr(String imageFileNameOfDgHmr) {
        this.imageFileNameOfDgHmr = imageFileNameOfDgHmr;
    }

    public String getBase64StringDgHmr() {
        return base64StringDgHmr;
    }

    public void setBase64StringDgHmr(String base64StringDgHmr) {
        this.base64StringDgHmr = base64StringDgHmr;
    }

    public String getImageFileNameOfDgOverview() {
        return imageFileNameOfDgOverview;
    }

    public void setImageFileNameOfDgOverview(String imageFileNameOfDgOverview) {
        this.imageFileNameOfDgOverview = imageFileNameOfDgOverview;
    }

    public String getBase64StringDgOverview() {
        return base64StringDgOverview;
    }

    public void setBase64StringDgOverview(String base64StringDgOverview) {
        this.base64StringDgOverview = base64StringDgOverview;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
