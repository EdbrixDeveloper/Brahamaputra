package com.brahamaputra.mahindra.brahamaputra.Data;

public class TowerDetailsData {

    private String towerName;
    private String towerType;
    private String towerHeight;
    private String dateOfTowerPainting;
    private String boardSign;
    private String dangerSignBoard;
    private String cautionSignBoard;
    private String warningSignBoard;


    public TowerDetailsData(String towerName, String towerType, String towerHeight, String dateOfTowerPainting, String boardSign, String dangerSignBoard, String cautionSignBoard, String warningSignBoard) {
        this.towerName = towerName;
        this.towerType = towerType;
        this.towerHeight = towerHeight;
        this.dateOfTowerPainting = dateOfTowerPainting;
        this.boardSign = boardSign;
        this.dangerSignBoard = dangerSignBoard;
        this.cautionSignBoard = cautionSignBoard;
        this.warningSignBoard = warningSignBoard;
    }

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
}
