package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;

public class EbSiteElectrificationElectricConnectionData implements Serializable {

    @SerializedName("nameOfTheSupplyCompany")
    private String nameOfTheSupplyCompany;

    @SerializedName("consumerNumber")
    private String consumerNumber;

    @SerializedName("ebMeterSerialNumber")
    private String ebMeterSerialNumber;

    @SerializedName("typeOfElectricConnection")
    private String typeOfElectricConnection;

    @SerializedName("tariff")
    private String tariff;

    @SerializedName("sanctionedLoad")
    private String sanctionedLoad;

    @SerializedName("existingLoadAtSite")
    private String existingLoadAtSite;

    @SerializedName("securityAmountPaidToTheCompany")
    private String securityAmountPaidToTheCompany;

    @SerializedName("copyOfTheElectricBills")
    private String copyOfTheElectricBills;

    @SerializedName("numberOfCompoundLights")
    private String numberOfCompoundLights;

    @SerializedName("ebMeterReadingInKWH")
    private String ebMeterReadingInKWH;

    @SerializedName("ebSupplier")
    private String ebSupplier;

    @SerializedName("ebCostPerUnitForSharedConnection")
    private String ebCostPerUnitForSharedConnection;

    @SerializedName("ebStatus")
    private String ebStatus;

    @SerializedName("transformerWorkingCondition")
    private String transformerWorkingCondition;

    @SerializedName("transformerCapacityInKVA")
    private String transformerCapacityInKVA;

    @SerializedName("ebMeterBoxStatus")
    private String ebMeterBoxStatus;

    @SerializedName("sectionName")
    private String sectionName;

    @SerializedName("sectionNumber")
    private String sectionNumber;

    @SerializedName("ebMeterWorkingStatus")
    private String ebMeterWorkingStatus;

    @SerializedName("typeOfPayment")
    private String typeOfPayment;

    @SerializedName("ebPaymentSchedule")
    private String ebPaymentSchedule;

    @SerializedName("safetyFuseUnit")
    private String safetyFuseUnit;

    @SerializedName("kitkatClayFuseStatus")
    private String kitkatClayFuseStatus;

    @SerializedName("ebNeutralEarthing")
    private String ebNeutralEarthing;

    @SerializedName("averageEbAvailabilityPerDay")
    private String averageEbAvailabilityPerDay;

    @SerializedName("scheduledPowerCutInHrs")
    private String scheduledPowerCutInHrs;

    @SerializedName("ebBillDate")
    private String ebBillDate;

    @SerializedName("typeModeOfPayment")
    private String typeModeOfPayment;

    @SerializedName("bankIfscCode")
    private String bankIfscCode;

    @SerializedName("bankAccountNo")
    private String bankAccountNo;

    /*@SerializedName("isSubmited")
    private int isSubmited;*/


    public EbSiteElectrificationElectricConnectionData() {
        this.nameOfTheSupplyCompany = "";
        this.consumerNumber = "";
        this.ebMeterSerialNumber = "";
        this.typeOfElectricConnection = "";
        this.tariff = "";
        this.sanctionedLoad = "";
        this.existingLoadAtSite = "";
        this.securityAmountPaidToTheCompany = "";
        this.copyOfTheElectricBills = "";
        this.numberOfCompoundLights = "";
        this.ebMeterReadingInKWH = "";
        this.ebSupplier = "";
        this.ebCostPerUnitForSharedConnection = "";
        this.ebStatus = "";
        this.transformerWorkingCondition = "";
        this.transformerCapacityInKVA = "";
        this.ebMeterBoxStatus = "";
        this.sectionName = "";
        this.sectionNumber = "";
        this.ebMeterWorkingStatus = "";
        this.typeOfPayment = "";
        this.ebPaymentSchedule = "";
        this.safetyFuseUnit = "";
        this.kitkatClayFuseStatus = "";
        this.ebNeutralEarthing = "";
        this.averageEbAvailabilityPerDay = "";
        this.scheduledPowerCutInHrs = "";
        this.ebBillDate = "";
        this.typeModeOfPayment = "";
        this.bankIfscCode = "";
        this.bankAccountNo = "";
        /*this.isSubmited = 0;*/

    }

    public EbSiteElectrificationElectricConnectionData(String nameOfTheSupplyCompany, String consumerNumber, String ebMeterSerialNumber, String typeOfElectricConnection, String tariff, String sanctionedLoad, String existingLoadAtSite, String securityAmountPaidToTheCompany, String copyOfTheElectricBills, String numberOfCompoundLights, String ebMeterReadingInKWH, String ebSupplier, String ebCostPerUnitForSharedConnection, String ebStatus, String transformerWorkingCondition, String transformerCapacityInKVA, String ebMeterBoxStatus, String sectionName, String sectionNumber, String ebMeterWorkingStatus, String typeOfPayment, String ebPaymentSchedule, String safetyFuseUnit, String kitkatClayFuseStatus, String ebNeutralEarthing, String averageEbAvailabilityPerDay, String scheduledPowerCutInHrs, String ebBillDate, String typeModeOfPayment, String bankIfscCode, String bankAccountNo) {
        this.nameOfTheSupplyCompany = nameOfTheSupplyCompany;
        this.consumerNumber = consumerNumber;
        this.ebMeterSerialNumber = ebMeterSerialNumber;
        this.typeOfElectricConnection = typeOfElectricConnection;
        this.tariff = tariff;
        this.sanctionedLoad = sanctionedLoad;
        this.existingLoadAtSite = existingLoadAtSite;
        this.securityAmountPaidToTheCompany = securityAmountPaidToTheCompany;
        this.copyOfTheElectricBills = copyOfTheElectricBills;
        this.numberOfCompoundLights = numberOfCompoundLights;
        this.ebMeterReadingInKWH = ebMeterReadingInKWH;
        this.ebSupplier = ebSupplier;
        this.ebCostPerUnitForSharedConnection = ebCostPerUnitForSharedConnection;
        this.ebStatus = ebStatus;
        this.transformerWorkingCondition = transformerWorkingCondition;
        this.transformerCapacityInKVA = transformerCapacityInKVA;
        this.ebMeterBoxStatus = ebMeterBoxStatus;
        this.sectionName = sectionName;
        this.sectionNumber = sectionNumber;
        this.ebMeterWorkingStatus = ebMeterWorkingStatus;
        this.typeOfPayment = typeOfPayment;
        this.ebPaymentSchedule = ebPaymentSchedule;
        this.safetyFuseUnit = safetyFuseUnit;
        this.kitkatClayFuseStatus = kitkatClayFuseStatus;
        this.ebNeutralEarthing = ebNeutralEarthing;
        this.averageEbAvailabilityPerDay = averageEbAvailabilityPerDay;
        this.scheduledPowerCutInHrs = scheduledPowerCutInHrs;
        this.ebBillDate = ebBillDate;
        this.typeModeOfPayment = typeModeOfPayment;
        this.bankIfscCode = bankIfscCode;
        this.bankAccountNo = bankAccountNo;
        //this.isSubmited = isSubmited;
    }


    public String getNameOfTheSupplyCompany() {
        return nameOfTheSupplyCompany;
    }

    public void setNameOfTheSupplyCompany(String nameOfTheSupplyCompany) {
        this.nameOfTheSupplyCompany = nameOfTheSupplyCompany;
    }

    public String getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getEbMeterSerialNumber() {
        return ebMeterSerialNumber;
    }

    public void setEbMeterSerialNumber(String ebMeterSerialNumber) {
        this.ebMeterSerialNumber = ebMeterSerialNumber;
    }

    public String getTypeOfElectricConnection() {
        return typeOfElectricConnection;
    }

    public void setTypeOfElectricConnection(String typeOfElectricConnection) {
        this.typeOfElectricConnection = typeOfElectricConnection;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getSanctionedLoad() {
        return sanctionedLoad;
    }

    public void setSanctionedLoad(String sanctionedLoad) {
        this.sanctionedLoad = sanctionedLoad;
    }

    public String getExistingLoadAtSite() {
        return existingLoadAtSite;
    }

    public void setExistingLoadAtSite(String existingLoadAtSite) {
        this.existingLoadAtSite = existingLoadAtSite;
    }

    public String getSecurityAmountPaidToTheCompany() {
        return securityAmountPaidToTheCompany;
    }

    public void setSecurityAmountPaidToTheCompany(String securityAmountPaidToTheCompany) {
        this.securityAmountPaidToTheCompany = securityAmountPaidToTheCompany;
    }

    public String getCopyOfTheElectricBills() {
        return copyOfTheElectricBills;
    }

    public void setCopyOfTheElectricBills(String copyOfTheElectricBills) {
        this.copyOfTheElectricBills = copyOfTheElectricBills;
    }

    public String getNumberOfCompoundLights() {
        return numberOfCompoundLights;
    }

    public void setNumberOfCompoundLights(String numberOfCompoundLights) {
        this.numberOfCompoundLights = numberOfCompoundLights;
    }

    public String getEbMeterReadingInKWH() {
        return ebMeterReadingInKWH;
    }

    public void setEbMeterReadingInKWH(String ebMeterReadingInKWH) {
        this.ebMeterReadingInKWH = ebMeterReadingInKWH;
    }

    public String getEbSupplier() {
        return ebSupplier;
    }

    public void setEbSupplier(String ebSupplier) {
        this.ebSupplier = ebSupplier;
    }

    public String getEbCostPerUnitForSharedConnection() {
        return ebCostPerUnitForSharedConnection;
    }

    public void setEbCostPerUnitForSharedConnection(String ebCostPerUnitForSharedConnection) {
        this.ebCostPerUnitForSharedConnection = ebCostPerUnitForSharedConnection;
    }

    public String getEbStatus() {
        return ebStatus;
    }

    public void setEbStatus(String ebStatus) {
        this.ebStatus = ebStatus;
    }

    public String getTransformerWorkingCondition() {
        return transformerWorkingCondition;
    }

    public void setTransformerWorkingCondition(String transformerWorkingCondition) {
        this.transformerWorkingCondition = transformerWorkingCondition;
    }

    public String getTransformerCapacityInKVA() {
        return transformerCapacityInKVA;
    }

    public void setTransformerCapacityInKVA(String transformerCapacityInKVA) {
        this.transformerCapacityInKVA = transformerCapacityInKVA;
    }

    public String getEbMeterBoxStatus() {
        return ebMeterBoxStatus;
    }

    public void setEbMeterBoxStatus(String ebMeterBoxStatus) {
        this.ebMeterBoxStatus = ebMeterBoxStatus;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getEbMeterWorkingStatus() {
        return ebMeterWorkingStatus;
    }

    public void setEbMeterWorkingStatus(String ebMeterWorkingStatus) {
        this.ebMeterWorkingStatus = ebMeterWorkingStatus;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    public String getEbPaymentSchedule() {
        return ebPaymentSchedule;
    }

    public void setEbPaymentSchedule(String ebPaymentSchedule) {
        this.ebPaymentSchedule = ebPaymentSchedule;
    }

    public String getSafetyFuseUnit() {
        return safetyFuseUnit;
    }

    public void setSafetyFuseUnit(String safetyFuseUnit) {
        this.safetyFuseUnit = safetyFuseUnit;
    }

    public String getKitkatClayFuseStatus() {
        return kitkatClayFuseStatus;
    }

    public void setKitkatClayFuseStatus(String kitkatClayFuseStatus) {
        this.kitkatClayFuseStatus = kitkatClayFuseStatus;
    }

    public String getEbNeutralEarthing() {
        return ebNeutralEarthing;
    }

    public void setEbNeutralEarthing(String ebNeutralEarthing) {
        this.ebNeutralEarthing = ebNeutralEarthing;
    }

    public String getAverageEbAvailabilityPerDay() {
        return averageEbAvailabilityPerDay;
    }

    public void setAverageEbAvailabilityPerDay(String averageEbAvailabilityPerDay) {
        this.averageEbAvailabilityPerDay = averageEbAvailabilityPerDay;
    }

    public String getScheduledPowerCutInHrs() {
        return scheduledPowerCutInHrs;
    }

    public void setScheduledPowerCutInHrs(String scheduledPowerCutInHrs) {
        this.scheduledPowerCutInHrs = scheduledPowerCutInHrs;
    }

    public String getEbBillDate() {
        return ebBillDate;
    }

    public void setEbBillDate(String ebBillDate) {
        this.ebBillDate = ebBillDate;
    }

    public String getTypeModeOfPayment() {
        return typeModeOfPayment;
    }

    public void setTypeModeOfPayment(String typeModeOfPayment) {
        this.typeModeOfPayment = typeModeOfPayment;
    }

    public String getBankIfscCode() {
        return bankIfscCode;
    }

    public void setBankIfscCode(String bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    /*public int getIsSubmited() {
        return isSubmited;
    }

    public void setIsSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }*/
    //endregion
}
