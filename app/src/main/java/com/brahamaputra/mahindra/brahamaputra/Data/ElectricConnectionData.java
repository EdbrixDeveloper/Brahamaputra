package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;

public class ElectricConnectionData {

    @SerializedName("electricConnectionType")
    private String electricConnectionType;

    @SerializedName("connectionTariff")
    private String connectionTariff;

    @SerializedName("sanctionLoad")
    private String sanctionLoad;

    @SerializedName("existingLoadAtSite")
    private String existingLoadAtSite;

    @SerializedName("nameSupplyCompany")
    private String nameSupplyCompany;

    @SerializedName("electricBillCopyStatus")
    private String electricBillCopyStatus;

    @SerializedName("noOfCompoundLights")
    private String noOfCompoundLights;

    @SerializedName("meterReadingsEB")
    private String meterReadingsEB;

    @SerializedName("supplierEB")
    private String supplierEB;

    @SerializedName("costPerUnitForSharedConnectionEB")
    private String costPerUnitForSharedConnectionEB;

    @SerializedName("statusEB")
    private String statusEB;

    @SerializedName("transformerWorkingCondition")
    private String transformerWorkingCondition;

    @SerializedName("transformerCapacity")
    private String transformerCapacity;

    @SerializedName("meterBoxStatusEB")
    private String meterBoxStatusEB;

    @SerializedName("sectionName")
    private String sectionName;

    @SerializedName("sectionNo")
    private String sectionNo;

    @SerializedName("consumerNo")
    private String consumerNo;

    @SerializedName("meterWorkingStatusEB")
    private String meterWorkingStatusEB;

    @SerializedName("meterSerialNumberEB")
    private String meterSerialNumberEB;

    @SerializedName("paymentType")
    private String paymentType;

    @SerializedName("paymentScheduleEB")
    private String paymentScheduleEB;

    @SerializedName("safetyFuseUnit")
    private String safetyFuseUnit;

    @SerializedName("kitKatFuseStatus")
    private String kitKatFuseStatus;

    @SerializedName("ebNeutralEarthing")
    private String ebNeutralEarthing;

    @SerializedName("averageEbAvailability")
    private String averageEbAvailability;

    @SerializedName("scheduledPowerCut")
    private String scheduledPowerCut;

    @SerializedName("ebBillDate")
    private String ebBillDate;

    @SerializedName("sapVendorCode")
    private String sapVendorCode;

    @SerializedName("typeModeOfPayment_Val")
    private String typeModeOfPayment_Val;

    @SerializedName("bankIfscCode")
    private String bankIfscCode;

    @SerializedName("bankAccountNo")
    private String bankAccountNo;

    @SerializedName("securityAmountPaid")
    private String securityAmountPaid;

    public String getSecurityAmountPaid() {
        return securityAmountPaid;
    }

    public void setSecurityAmountPaid(String securityAmountPaid) {
        this.securityAmountPaid = securityAmountPaid;
    }

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    //region Region of Constructors
    public ElectricConnectionData() {
        this.electricConnectionType = "";
        this.connectionTariff = "";
        this.sanctionLoad = "";
        this.existingLoadAtSite = "";
        this.nameSupplyCompany = "";
        this.electricBillCopyStatus = "";
        this.noOfCompoundLights = "";
        this.meterReadingsEB = "";
        this.supplierEB = "";
        this.costPerUnitForSharedConnectionEB = "";
        this.statusEB = "";
        this.transformerWorkingCondition = "";
        this.transformerCapacity = "";
        this.meterBoxStatusEB = "";
        this.sectionName = "";
        this.sectionNo = "";
        this.consumerNo = "";
        this.meterWorkingStatusEB = "";
        this.meterSerialNumberEB = "";
        this.paymentType = "";
        this.paymentScheduleEB = "";
        this.safetyFuseUnit = "";
        this.kitKatFuseStatus = "";
        this.ebNeutralEarthing = "";
        this.averageEbAvailability = "";
        this.scheduledPowerCut = "";
        this.ebBillDate = "";
        this.typeModeOfPayment_Val = "";
        this.bankIfscCode = "";
        this.bankAccountNo = "";
        this.isSubmited = 0;
        this.securityAmountPaid = "";
    }

    public ElectricConnectionData(String electricConnectionType, String connectionTariff, String sanctionLoad, String securityAmountPaid, String existingLoadAtSite, String nameSupplyCompany, String electricBillCopyStatus, String noOfCompoundLights, String meterReadingsEB, String supplierEB, String costPerUnitForSharedConnectionEB, String statusEB, String transformerWorkingCondition, String transformerCapacity, String meterBoxStatusEB, String sectionName, String sectionNo, String consumerNo, String meterWorkingStatusEB, String meterSerialNumberEB, String paymentType, String paymentScheduleEB, String safetyFuseUnit, String kitKatFuseStatus, String ebNeutralEarthing, String averageEbAvailability, String scheduledPowerCut, String ebBillDate, String sapVendorCode, String typeModeOfPayment_Val, String bankIfscCode, String bankAccountNo) {
        this.electricConnectionType = electricConnectionType;
        this.connectionTariff = connectionTariff;
        this.sanctionLoad = sanctionLoad;
        this.securityAmountPaid = securityAmountPaid;
        this.existingLoadAtSite = existingLoadAtSite;
        this.nameSupplyCompany = nameSupplyCompany;
        this.electricBillCopyStatus = electricBillCopyStatus;
        this.noOfCompoundLights = noOfCompoundLights;
        this.meterReadingsEB = meterReadingsEB;
        this.supplierEB = supplierEB;
        this.costPerUnitForSharedConnectionEB = costPerUnitForSharedConnectionEB;
        this.statusEB = statusEB;
        this.transformerWorkingCondition = transformerWorkingCondition;
        this.transformerCapacity = transformerCapacity;
        this.meterBoxStatusEB = meterBoxStatusEB;
        this.sectionName = sectionName;
        this.sectionNo = sectionNo;
        this.consumerNo = consumerNo;
        this.meterWorkingStatusEB = meterWorkingStatusEB;
        this.meterSerialNumberEB = meterSerialNumberEB;
        this.paymentType = paymentType;
        this.paymentScheduleEB = paymentScheduleEB;
        this.safetyFuseUnit = safetyFuseUnit;
        this.kitKatFuseStatus = kitKatFuseStatus;
        this.ebNeutralEarthing = ebNeutralEarthing;
        this.averageEbAvailability = averageEbAvailability;
        this.scheduledPowerCut = scheduledPowerCut;
        this.ebBillDate = ebBillDate;
        this.sapVendorCode = sapVendorCode;
        this.typeModeOfPayment_Val = typeModeOfPayment_Val;
        this.bankIfscCode = bankIfscCode;
        this.bankAccountNo = bankAccountNo;
        //this.isSubmited=true;//007
        this.isSubmited = 1;
        if (hototicket_sourceOfPower.equals("Non EB")) {
            /*if (!this.electricConnectionType.isEmpty() && !this.connectionTariff.isEmpty() && !this.nameSupplyCompany.isEmpty() &&
                    !this.typeModeOfPayment_Val.isEmpty()) {*/
            this.isSubmited = 2;
            /*}*/
        } else {
            if (!this.electricConnectionType.isEmpty() && !this.connectionTariff.isEmpty() && !this.nameSupplyCompany.isEmpty() &&
                    !this.meterReadingsEB.isEmpty() && !this.consumerNo.isEmpty() && !this.typeModeOfPayment_Val.isEmpty()) {
                this.isSubmited = 2;
            } else if (this.electricConnectionType.isEmpty() && this.connectionTariff.isEmpty() && this.sanctionLoad.isEmpty() && this.securityAmountPaid.isEmpty() && this.
                    existingLoadAtSite.isEmpty() && this.nameSupplyCompany.isEmpty() && this.electricBillCopyStatus.isEmpty() && this.noOfCompoundLights.isEmpty() && this.
                    meterReadingsEB.isEmpty() && this.supplierEB.isEmpty() && this.costPerUnitForSharedConnectionEB.isEmpty() && this.statusEB.isEmpty() && this.
                    transformerWorkingCondition.isEmpty() && this.transformerCapacity.isEmpty() && this.meterBoxStatusEB.isEmpty() && this.sectionName.isEmpty() && this.
                    sectionNo.isEmpty() && this.consumerNo.isEmpty() && this.meterWorkingStatusEB.isEmpty() && this.meterSerialNumberEB.isEmpty() && this.
                    paymentType.isEmpty() && this.paymentScheduleEB.isEmpty() && this.safetyFuseUnit.isEmpty() && this.kitKatFuseStatus.isEmpty() && this.
                    ebNeutralEarthing.isEmpty() && this.averageEbAvailability.isEmpty() && this.
                    scheduledPowerCut.isEmpty() && this.ebBillDate.isEmpty() && this.sapVendorCode.isEmpty() && this.typeModeOfPayment_Val.isEmpty() && this.
                    bankIfscCode.isEmpty() && this.bankAccountNo.isEmpty()) {
                this.isSubmited = 0;
            }
            /*else {
            this.isSubmited = 1;
        }*/
        }
    }
    //endregion

    //region Region of Getter() Setter() Properties
    public String getElectricConnectionType() {
        return electricConnectionType;
    }

    public void setElectricConnectionType(String electricConnectionType) {
        this.electricConnectionType = electricConnectionType;
    }

    public String getConnectionTariff() {
        return connectionTariff;
    }

    public void setConnectionTariff(String connectionTariff) {
        this.connectionTariff = connectionTariff;
    }

    public String getSanctionLoad() {
        return sanctionLoad;
    }

    public void setSanctionLoad(String sanctionLoad) {
        this.sanctionLoad = sanctionLoad;
    }

    public String getExistingLoadAtSite() {
        return existingLoadAtSite;
    }

    public void setExistingLoadAtSite(String existingLoadAtSite) {
        this.existingLoadAtSite = existingLoadAtSite;
    }

    public String getNameSupplyCompany() {
        return nameSupplyCompany;
    }

    public void setNameSupplyCompany(String nameSupplyCompany) {
        this.nameSupplyCompany = nameSupplyCompany;
    }

    public String getElectricBillCopyStatus() {
        return electricBillCopyStatus;
    }

    public void setElectricBillCopyStatus(String electricBillCopyStatus) {
        this.electricBillCopyStatus = electricBillCopyStatus;
    }

    public String getNoOfCompoundLights() {
        return noOfCompoundLights;
    }

    public void setNoOfCompoundLights(String noOfCompoundLights) {
        this.noOfCompoundLights = noOfCompoundLights;
    }

    public String getMeterReadingsEB() {
        return meterReadingsEB;
    }

    public void setMeterReadingsEB(String meterReadingsEB) {
        this.meterReadingsEB = meterReadingsEB;
    }

    public String getSupplierEB() {
        return supplierEB;
    }

    public void setSupplierEB(String supplierEB) {
        this.supplierEB = supplierEB;
    }

    public String getCostPerUnitForSharedConnectionEB() {
        return costPerUnitForSharedConnectionEB;
    }

    public void setCostPerUnitForSharedConnectionEB(String costPerUnitForSharedConnectionEB) {
        this.costPerUnitForSharedConnectionEB = costPerUnitForSharedConnectionEB;
    }

    public String getStatusEB() {
        return statusEB;
    }

    public void setStatusEB(String statusEB) {
        this.statusEB = statusEB;
    }

    public String getTransformerWorkingCondition() {
        return transformerWorkingCondition;
    }

    public void setTransformerWorkingCondition(String transformerWorkingCondition) {
        this.transformerWorkingCondition = transformerWorkingCondition;
    }

    public String getTransformerCapacity() {
        return transformerCapacity;
    }

    public void setTransformerCapacity(String transformerCapacity) {
        this.transformerCapacity = transformerCapacity;
    }

    public String getMeterBoxStatusEB() {
        return meterBoxStatusEB;
    }

    public void setMeterBoxStatusEB(String meterBoxStatusEB) {
        this.meterBoxStatusEB = meterBoxStatusEB;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getConsumerNo() {
        return consumerNo;
    }

    public void setConsumerNo(String consumerNo) {
        this.consumerNo = consumerNo;
    }

    public String getMeterWorkingStatusEB() {
        return meterWorkingStatusEB;
    }

    public void setMeterWorkingStatusEB(String meterWorkingStatusEB) {
        this.meterWorkingStatusEB = meterWorkingStatusEB;
    }

    public String getMeterSerialNumberEB() {
        return meterSerialNumberEB;
    }

    public void setMeterSerialNumberEB(String meterSerialNumberEB) {
        this.meterSerialNumberEB = meterSerialNumberEB;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentScheduleEB() {
        return paymentScheduleEB;
    }

    public void setPaymentScheduleEB(String paymentScheduleEB) {
        this.paymentScheduleEB = paymentScheduleEB;
    }

    public String getSafetyFuseUnit() {
        return safetyFuseUnit;
    }

    public void setSafetyFuseUnit(String safetyFuseUnit) {
        this.safetyFuseUnit = safetyFuseUnit;
    }

    public String getKitKatFuseStatus() {
        return kitKatFuseStatus;
    }

    public void setKitKatFuseStatus(String kitKatFuseStatus) {
        this.kitKatFuseStatus = kitKatFuseStatus;
    }

    public String getEbNeutralEarthing() {
        return ebNeutralEarthing;
    }

    public void setEbNeutralEarthing(String ebNeutralEarthing) {
        this.ebNeutralEarthing = ebNeutralEarthing;
    }

    public String getAverageEbAvailability() {
        return averageEbAvailability;
    }

    public void setAverageEbAvailability(String averageEbAvailability) {
        this.averageEbAvailability = averageEbAvailability;
    }

    public String getScheduledPowerCut() {
        return scheduledPowerCut;
    }

    public void setScheduledPowerCut(String scheduledPowerCut) {
        this.scheduledPowerCut = scheduledPowerCut;
    }

    public String getEbBillDate() {
        return ebBillDate;
    }

    public void setEbBillDate(String ebBillDate) {
        this.ebBillDate = ebBillDate;
    }

    public String getSapVendorCode() {
        return sapVendorCode;
    }

    public void setSapVendorCode(String sapVendorCode) {
        this.sapVendorCode = sapVendorCode;
    }

    public String getTypeModeOfPayment_Val() {
        return typeModeOfPayment_Val;
    }

    public void setTypeModeOfPayment_Val(String typeModeOfPayment_Val) {
        this.typeModeOfPayment_Val = typeModeOfPayment_Val;
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

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
    //endregion
}
