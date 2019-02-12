
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiteHygenieneGenralSeftyParameter implements Serializable {

    @SerializedName("sitePremisesCleaning")
    @Expose
    private String sitePremisesCleaning;
    @SerializedName("base64StringUploadPhotoOfSitePremises")
    @Expose
    private String base64StringUploadPhotoOfSitePremises;
    @SerializedName("equipmentCleaning")
    @Expose
    private String equipmentCleaning;
    @SerializedName("anyEagleCrowHoneyHivesInTower")
    @Expose
    private String anyEagleCrowHoneyHivesInTower;
    @SerializedName("compoundWallFencingStatus")
    @Expose
    private String compoundWallFencingStatus;
    @SerializedName("gateLockAvailablity")
    @Expose
    private String gateLockAvailablity;
    @SerializedName("shelterLockAvailablity")
    @Expose
    private String shelterLockAvailablity;
    @SerializedName("dgLockAvailablity")
    @Expose
    private String dgLockAvailablity;
    @SerializedName("fireExtinguisherAvilability")
    @Expose
    private String fireExtinguisherAvilability;
    @SerializedName("noOfFireExtinguisher")
    @Expose
    private String noOfFireExtinguisher;
    @SerializedName("fireExtinguisherExpiryDate")
    @Expose
    private String fireExtinguisherExpiryDate;
    @SerializedName("fireBucket")
    @Expose
    private String fireBucket;
    @SerializedName("base64StringCautionSignBoardPhoto")
    @Expose
    private String base64StringCautionSignBoardPhoto;
    @SerializedName("base64StringWarningSignBoardPhoto")
    @Expose
    private String base64StringWarningSignBoardPhoto;
    @SerializedName("base64StringDangerSignBoardPhoto")
    @Expose
    private String base64StringDangerSignBoardPhoto;
    @SerializedName("safetyChartsCalendar")
    @Expose
    private String safetyChartsCalendar;
    @SerializedName("unusedMaterialInSite")
    @Expose
    private String unusedMaterialInSite;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    @SerializedName("base64StringUploadPhotoOfRegisterFault")
    @Expose
    private String base64StringUploadPhotoOfRegisterFault;

    @SerializedName("isSubmited")
    private int isSubmited;

    /*private String imageFileUploadPhotoOfSitePremises;
    private String imageFileCautionSignBoard;
    private String imageFileWarningSignBoard;
    private String imageFileDangerSignBoard;*/

    public SiteHygenieneGenralSeftyParameter() {
        this.sitePremisesCleaning = "";
        this.base64StringUploadPhotoOfSitePremises = "";
        this.equipmentCleaning = "";
        this.anyEagleCrowHoneyHivesInTower = "";
        this.compoundWallFencingStatus = "";
        this.gateLockAvailablity = "";
        this.shelterLockAvailablity = "";
        this.dgLockAvailablity = "";
        this.fireExtinguisherAvilability = "";
        this.noOfFireExtinguisher = "";
        this.fireExtinguisherExpiryDate = "";
        this.fireBucket = "";
        this.base64StringCautionSignBoardPhoto = "";
        this.base64StringWarningSignBoardPhoto = "";
        this.base64StringDangerSignBoardPhoto = "";
        this.safetyChartsCalendar = "";
        this.unusedMaterialInSite = "";
        this.registerFault = "";
        this.typeOfFault = "";
        this.base64StringUploadPhotoOfRegisterFault = "";
        /*this.imageFileUploadPhotoOfSitePremises = "";
        this.imageFileCautionSignBoard = "";
        this.imageFileWarningSignBoard = "";
        this.imageFileDangerSignBoard = "";*/

        isSubmited = 0;
    }


    public SiteHygenieneGenralSeftyParameter(String sitePremisesCleaning, String base64StringUploadPhotoOfSitePremises, String equipmentCleaning,
                                             String anyEagleCrowHoneyHivesInTower, String compoundWallFencingStatus, String gateLockAvailablity,
                                             String shelterLockAvailablity, String dgLockAvailablity, String fireExtinguisherAvilability, String noOfFireExtinguisher,
                                             String fireExtinguisherExpiryDate, String fireBucket, String base64StringCautionSignBoardPhoto,
                                             String base64StringWarningSignBoardPhoto, String base64StringDangerSignBoardPhoto, String safetyChartsCalendar,
                                             String unusedMaterialInSite, String registerFault, String typeOfFault, String base64StringUploadPhotoOfRegisterFault/*,
                                             String imageFileUploadPhotoOfSitePremises, String imageFileCautionSignBoard,
                                             String imageFileWarningSignBoard, String imageFileDangerSignBoard*/) {
        this.sitePremisesCleaning = sitePremisesCleaning;
        this.base64StringUploadPhotoOfSitePremises = base64StringUploadPhotoOfSitePremises;
        this.equipmentCleaning = equipmentCleaning;
        this.anyEagleCrowHoneyHivesInTower = anyEagleCrowHoneyHivesInTower;
        this.compoundWallFencingStatus = compoundWallFencingStatus;
        this.gateLockAvailablity = gateLockAvailablity;
        this.shelterLockAvailablity = shelterLockAvailablity;
        this.dgLockAvailablity = dgLockAvailablity;
        this.fireExtinguisherAvilability = fireExtinguisherAvilability;
        this.noOfFireExtinguisher = noOfFireExtinguisher;
        this.fireExtinguisherExpiryDate = fireExtinguisherExpiryDate;
        this.fireBucket = fireBucket;
        this.base64StringCautionSignBoardPhoto = base64StringCautionSignBoardPhoto;
        this.base64StringWarningSignBoardPhoto = base64StringWarningSignBoardPhoto;
        this.base64StringDangerSignBoardPhoto = base64StringDangerSignBoardPhoto;
        this.safetyChartsCalendar = safetyChartsCalendar;
        this.unusedMaterialInSite = unusedMaterialInSite;
        this.registerFault = registerFault;
        this.typeOfFault = typeOfFault;
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;

        /*this.imageFileUploadPhotoOfSitePremises = imageFileUploadPhotoOfSitePremises;
        this.imageFileCautionSignBoard = imageFileCautionSignBoard;
        this.imageFileWarningSignBoard = imageFileWarningSignBoard;
        this.imageFileDangerSignBoard = imageFileDangerSignBoard;*/

        //this.isSubmited = 2;
        if (!this.sitePremisesCleaning.isEmpty() && !this.base64StringUploadPhotoOfSitePremises.isEmpty() && !this.equipmentCleaning.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }


        //sitePremisesCleaning,base64StringUploadPhotoOfSitePremises,equipmentCleaning,anyEagleCrowHoneyHivesInTower,compoundWallFencingStatus,gateLockAvailablity,shelterLockAvailablity,dgLockAvailablity,fireExtinguisherAvilability,noOfFireExtinguisher,fireExtinguisherExpiryDate,fireBucket,base64StringCautionSignBoardPhoto,base64StringWarningSignBoardPhoto,base64StringDangerSignBoardPhoto,safetyChartsCalendar,unusedMaterialInSite,registerFault,typeOfFault


    }


    public String getSitePremisesCleaning() {
        return sitePremisesCleaning;
    }

    public void setSitePremisesCleaning(String sitePremisesCleaning) {
        this.sitePremisesCleaning = sitePremisesCleaning;
    }

    public String getBase64StringUploadPhotoOfSitePremises() {
        return base64StringUploadPhotoOfSitePremises;
    }

    public void setBase64StringUploadPhotoOfSitePremises(String base64StringUploadPhotoOfSitePremises) {
        this.base64StringUploadPhotoOfSitePremises = base64StringUploadPhotoOfSitePremises;
    }

    public String getEquipmentCleaning() {
        return equipmentCleaning;
    }

    public void setEquipmentCleaning(String equipmentCleaning) {
        this.equipmentCleaning = equipmentCleaning;
    }

    public String getAnyEagleCrowHoneyHivesInTower() {
        return anyEagleCrowHoneyHivesInTower;
    }

    public void setAnyEagleCrowHoneyHivesInTower(String anyEagleCrowHoneyHivesInTower) {
        this.anyEagleCrowHoneyHivesInTower = anyEagleCrowHoneyHivesInTower;
    }

    public String getCompoundWallFencingStatus() {
        return compoundWallFencingStatus;
    }

    public void setCompoundWallFencingStatus(String compoundWallFencingStatus) {
        this.compoundWallFencingStatus = compoundWallFencingStatus;
    }

    public String getGateLockAvailablity() {
        return gateLockAvailablity;
    }

    public void setGateLockAvailablity(String gateLockAvailablity) {
        this.gateLockAvailablity = gateLockAvailablity;
    }

    public String getShelterLockAvailablity() {
        return shelterLockAvailablity;
    }

    public void setShelterLockAvailablity(String shelterLockAvailablity) {
        this.shelterLockAvailablity = shelterLockAvailablity;
    }

    public String getDgLockAvailablity() {
        return dgLockAvailablity;
    }

    public void setDgLockAvailablity(String dgLockAvailablity) {
        this.dgLockAvailablity = dgLockAvailablity;
    }

    public String getFireExtinguisherAvilability() {
        return fireExtinguisherAvilability;
    }

    public void setFireExtinguisherAvilability(String fireExtinguisherAvilability) {
        this.fireExtinguisherAvilability = fireExtinguisherAvilability;
    }

    public String getNoOfFireExtinguisher() {
        return noOfFireExtinguisher;
    }

    public void setNoOfFireExtinguisher(String noOfFireExtinguisher) {
        this.noOfFireExtinguisher = noOfFireExtinguisher;
    }

    public String getFireExtinguisherExpiryDate() {
        return fireExtinguisherExpiryDate;
    }

    public void setFireExtinguisherExpiryDate(String fireExtinguisherExpiryDate) {
        this.fireExtinguisherExpiryDate = fireExtinguisherExpiryDate;
    }

    public String getFireBucket() {
        return fireBucket;
    }

    public void setFireBucket(String fireBucket) {
        this.fireBucket = fireBucket;
    }

    public String getBase64StringCautionSignBoardPhoto() {
        return base64StringCautionSignBoardPhoto;
    }

    public void setBase64StringCautionSignBoardPhoto(String base64StringCautionSignBoardPhoto) {
        this.base64StringCautionSignBoardPhoto = base64StringCautionSignBoardPhoto;
    }

    public String getBase64StringWarningSignBoardPhoto() {
        return base64StringWarningSignBoardPhoto;
    }

    public void setBase64StringWarningSignBoardPhoto(String base64StringWarningSignBoardPhoto) {
        this.base64StringWarningSignBoardPhoto = base64StringWarningSignBoardPhoto;
    }

    public String getBase64StringDangerSignBoardPhoto() {
        return base64StringDangerSignBoardPhoto;
    }

    public void setBase64StringDangerSignBoardPhoto(String base64StringDangerSignBoardPhoto) {
        this.base64StringDangerSignBoardPhoto = base64StringDangerSignBoardPhoto;
    }

    public String getSafetyChartsCalendar() {
        return safetyChartsCalendar;
    }

    public void setSafetyChartsCalendar(String safetyChartsCalendar) {
        this.safetyChartsCalendar = safetyChartsCalendar;
    }

    public String getUnusedMaterialInSite() {
        return unusedMaterialInSite;
    }

    public void setUnusedMaterialInSite(String unusedMaterialInSite) {
        this.unusedMaterialInSite = unusedMaterialInSite;
    }

    public String getRegisterFault() {
        return registerFault;
    }

    public void setRegisterFault(String registerFault) {
        this.registerFault = registerFault;
    }

    public String getTypeOfFault() {
        return typeOfFault;
    }

    public void setTypeOfFault(String typeOfFault) {
        this.typeOfFault = typeOfFault;
    }

    public String getBase64StringUploadPhotoOfRegisterFault() {
        return base64StringUploadPhotoOfRegisterFault;
    }

    public void setBase64StringUploadPhotoOfRegisterFault(String base64StringUploadPhotoOfRegisterFault) {
        this.base64StringUploadPhotoOfRegisterFault = base64StringUploadPhotoOfRegisterFault;
    }

    /*public String getImageFileUploadPhotoOfSitePremises() {
        return imageFileUploadPhotoOfSitePremises;
    }

    public void setImageFileUploadPhotoOfSitePremises(String imageFileUploadPhotoOfSitePremises) {
        this.imageFileUploadPhotoOfSitePremises = imageFileUploadPhotoOfSitePremises;
    }

    public String getImageFileCautionSignBoard() {
        return imageFileCautionSignBoard;
    }

    public void setImageFileCautionSignBoard(String imageFileCautionSignBoard) {
        this.imageFileCautionSignBoard = imageFileCautionSignBoard;
    }

    public String getImageFileWarningSignBoard() {
        return imageFileWarningSignBoard;
    }

    public void setImageFileWarningSignBoard(String imageFileWarningSignBoard) {
        this.imageFileWarningSignBoard = imageFileWarningSignBoard;
    }

    public String getImageFileDangerSignBoard() {
        return imageFileDangerSignBoard;
    }

    public void setImageFileDangerSignBoard(String imageFileDangerSignBoard) {
        this.imageFileDangerSignBoard = imageFileDangerSignBoard;
    }*/

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }


}
