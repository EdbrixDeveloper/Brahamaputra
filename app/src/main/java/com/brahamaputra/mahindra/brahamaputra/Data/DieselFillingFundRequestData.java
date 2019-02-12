package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DieselFillingFundRequestData implements Serializable {

    @SerializedName("customer")
    @Expose
    private String customer;

    @SerializedName("circle")
    @Expose
    private String circle;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("ssa")
    @Expose
    private String ssa;

    @SerializedName("siteName")
    @Expose
    private String siteName;

    @SerializedName("siteId")
    @Expose
    private String siteId;

    @SerializedName("sourceOfPower")
    @Expose
    private String sourceOfPower;

    @SerializedName("cardSupplier")
    @Expose
    private String cardSupplier;

    @SerializedName("childCardNumber")
    @Expose
    private String childCardNumber;

    @SerializedName("lastDieselFillingDate")
    @Expose
    private String lastDieselFillingDate;

    @SerializedName("lastDieselStock")
    @Expose
    private String lastDieselStock;

    @SerializedName("lastDgHmr")
    @Expose
    private String lastDgHmr;

    @SerializedName("lastEbReading")
    @Expose
    private String lastEbReading;

    @SerializedName("presentDgHmr")
    @Expose
    private String presentDgHmr;

    @SerializedName("hmrPhotoUpload")
    @Expose
    private String hmrPhotoUpload;

    @SerializedName("presentDieselStock")
    @Expose
    private String presentDieselStock;

    @SerializedName("presentEbReading")
    @Expose
    private String presentEbReading;

    @SerializedName("presentEbMeterReadingKwhPhoto")
    @Expose
    private String presentEbMeterReadingKwhPhoto;

    @SerializedName("presentDateTime")
    @Expose
    private String presentDateTime;

    @SerializedName("dieselQuantityRequiredInLtrs")
    @Expose
    private String dieselQuantityRequiredInLtrs;

    public DieselFillingFundRequestData() {
    }

    public DieselFillingFundRequestData(String customer, String circle, String state, String ssa, String siteName, String siteId,
                                        String sourceOfPower, String cardSupplier, String childCardNumber, String lastDieselFillingDate,
                                        String lastDieselStock, String lastDgHmr, String lastEbReading, String presentDgHmr,
                                        String hmrPhotoUpload, String presentDieselStock, String presentEbReading,
                                        String presentEbMeterReadingKwhPhoto, String presentDateTime, String dieselQuantityRequiredInLtrs) {
        this.customer = customer;
        this.circle = circle;
        this.state = state;
        this.ssa = ssa;
        this.siteName = siteName;
        this.siteId = siteId;
        this.sourceOfPower = sourceOfPower;
        this.cardSupplier = cardSupplier;
        this.childCardNumber = childCardNumber;
        this.lastDieselFillingDate = lastDieselFillingDate;
        this.lastDieselStock = lastDieselStock;
        this.lastDgHmr = lastDgHmr;
        this.lastEbReading = lastEbReading;
        this.presentDgHmr = presentDgHmr;
        this.hmrPhotoUpload = hmrPhotoUpload;
        this.presentDieselStock = presentDieselStock;
        this.presentEbReading = presentEbReading;
        this.presentEbMeterReadingKwhPhoto = presentEbMeterReadingKwhPhoto;
        this.presentDateTime = presentDateTime;
        this.dieselQuantityRequiredInLtrs = dieselQuantityRequiredInLtrs;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSsa() {
        return ssa;
    }

    public void setSsa(String ssa) {
        this.ssa = ssa;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSourceOfPower() {
        return sourceOfPower;
    }

    public void setSourceOfPower(String sourceOfPower) {
        this.sourceOfPower = sourceOfPower;
    }

    public String getCardSupplier() {
        return cardSupplier;
    }

    public void setCardSupplier(String cardSupplier) {
        this.cardSupplier = cardSupplier;
    }

    public String getChildCardNumber() {
        return childCardNumber;
    }

    public void setChildCardNumber(String childCardNumber) {
        this.childCardNumber = childCardNumber;
    }

    public String getLastDieselFillingDate() {
        return lastDieselFillingDate;
    }

    public void setLastDieselFillingDate(String lastDieselFillingDate) {
        this.lastDieselFillingDate = lastDieselFillingDate;
    }

    public String getLastDieselStock() {
        return lastDieselStock;
    }

    public void setLastDieselStock(String lastDieselStock) {
        this.lastDieselStock = lastDieselStock;
    }

    public String getLastDgHmr() {
        return lastDgHmr;
    }

    public void setLastDgHmr(String lastDgHmr) {
        this.lastDgHmr = lastDgHmr;
    }

    public String getLastEbReading() {
        return lastEbReading;
    }

    public void setLastEbReading(String lastEbReading) {
        this.lastEbReading = lastEbReading;
    }

    public String getPresentDgHmr() {
        return presentDgHmr;
    }

    public void setPresentDgHmr(String presentDgHmr) {
        this.presentDgHmr = presentDgHmr;
    }

    public String getHmrPhotoUpload() {
        return hmrPhotoUpload;
    }

    public void setHmrPhotoUpload(String hmrPhotoUpload) {
        this.hmrPhotoUpload = hmrPhotoUpload;
    }

    public String getPresentDieselStock() {
        return presentDieselStock;
    }

    public void setPresentDieselStock(String presentDieselStock) {
        this.presentDieselStock = presentDieselStock;
    }

    public String getPresentEbReading() {
        return presentEbReading;
    }

    public void setPresentEbReading(String presentEbReading) {
        this.presentEbReading = presentEbReading;
    }

    public String getPresentEbMeterReadingKwhPhoto() {
        return presentEbMeterReadingKwhPhoto;
    }

    public void setPresentEbMeterReadingKwhPhoto(String presentEbMeterReadingKwhPhoto) {
        this.presentEbMeterReadingKwhPhoto = presentEbMeterReadingKwhPhoto;
    }

    public String getPresentDateTime() {
        return presentDateTime;
    }

    public void setPresentDateTime(String presentDateTime) {
        this.presentDateTime = presentDateTime;
    }

    public String getDieselQuantityRequiredInLtrs() {
        return dieselQuantityRequiredInLtrs;
    }

    public void setDieselQuantityRequiredInLtrs(String dieselQuantityRequiredInLtrs) {
        this.dieselQuantityRequiredInLtrs = dieselQuantityRequiredInLtrs;
    }

}




