package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class TowerDetailsData {

    @SerializedName("towerName")
    private String towerName;

    @SerializedName("towerType")
    private String towerType;

    @SerializedName("towerHeight")
    private String towerHeight;

    @SerializedName("dateOfTowerPainting")
    private String dateOfTowerPainting;

    @SerializedName("boardSign")
    private String boardSign;

    @SerializedName("dangerSignBoard")
    private String dangerSignBoard;

    @SerializedName("cautionSignBoard")
    private String cautionSignBoard;

    @SerializedName("warningSignBoard")
    private String warningSignBoard;

    @SerializedName("bookValueOfTheTower")
    private String bookValueOfTheTower;

    public String getBookValueOfTheTower() {
        return bookValueOfTheTower;
    }

    public void setBookValueOfTheTower(String bookValueOfTheTower) {
        this.bookValueOfTheTower = bookValueOfTheTower;
    }

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;


    //region Region Of Constructors
    public TowerDetailsData() {
        this.towerName = "";
        this.towerType = "";
        this.towerHeight = "";
        this.dateOfTowerPainting = "";
        this.boardSign = "";
        this.dangerSignBoard = "";
        this.cautionSignBoard = "";
        this.warningSignBoard = "";
        this.isSubmited = 0;
        this.bookValueOfTheTower = "";
    }

    public TowerDetailsData(String towerName, String towerType,String bookValueOfTheTower, String towerHeight, String dateOfTowerPainting, String boardSign, String dangerSignBoard, String cautionSignBoard, String warningSignBoard) {
        this.towerName = towerName;
        this.towerType = towerType;
        this.bookValueOfTheTower = bookValueOfTheTower;
        this.towerHeight = towerHeight;
        this.dateOfTowerPainting = dateOfTowerPainting;
        this.boardSign = boardSign;
        this.dangerSignBoard = dangerSignBoard;
        this.cautionSignBoard = cautionSignBoard;
        this.warningSignBoard = warningSignBoard;
        //this.isSubmited=true;//007
        this.isSubmited = 1;
        if (!this.towerName.isEmpty() && !this.towerType.isEmpty() && !this.dateOfTowerPainting.isEmpty()) {
            this.isSubmited = 2;
        }/*else {
            this.isSubmited = 1;
        }*/
    }
    //endregion

    //region Region of Getter() Setter() property
    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public String getTowerHeight() {
        return towerHeight;
    }

    public void setTowerHeight(String towerHeight) {
        this.towerHeight = towerHeight;
    }

    public String getDateOfTowerPainting() {
        return dateOfTowerPainting;
    }

    public void setDateOfTowerPainting(String dateOfTowerPainting) {
        this.dateOfTowerPainting = dateOfTowerPainting;
    }

    public String getBoardSign() {
        return boardSign;
    }

    public void setBoardSign(String boardSign) {
        this.boardSign = boardSign;
    }

    public String getDangerSignBoard() {
        return dangerSignBoard;
    }

    public void setDangerSignBoard(String dangerSignBoard) {
        this.dangerSignBoard = dangerSignBoard;
    }

    public String getCautionSignBoard() {
        return cautionSignBoard;
    }

    public void setCautionSignBoard(String cautionSignBoard) {
        this.cautionSignBoard = cautionSignBoard;
    }

    public String getWarningSignBoard() {
        return warningSignBoard;
    }

    public void setWarningSignBoard(String warningSignBoard) {
        this.warningSignBoard = warningSignBoard;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
    //endregion
}
