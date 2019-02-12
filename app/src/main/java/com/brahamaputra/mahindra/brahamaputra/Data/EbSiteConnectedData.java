package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EbSiteConnectedData {

    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("ConsumerNoList")
    @Expose
    private List<String> ConsumerNoList;

    @SerializedName("PaymentTypeList")
    @Expose
    private List<String> PaymentTypeList;

    @SerializedName("ElectricConnectionTypeList")
    @Expose
    private List<String> ElectricConnectionTypeList;

    @SerializedName("ConnectionTariffList")
    @Expose
    private List<String> ConnectionTariffList;


    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getConsumerNoList() {
        return ConsumerNoList;
    }

    public void setConsumerNoList(List<String> consumerNoList) {
        ConsumerNoList = consumerNoList;
    }

    public List<String> getPaymentTypeList() {
        return PaymentTypeList;
    }

    public void setPaymentTypeList(List<String> paymentTypeList) {
        PaymentTypeList = paymentTypeList;
    }

    public List<String> getElectricConnectionTypeList() {
        return ElectricConnectionTypeList;
    }

    public void setElectricConnectionTypeList(List<String> electricConnectionTypeList) {
        ElectricConnectionTypeList = electricConnectionTypeList;
    }

    public List<String> getConnectionTariffList() {
        return ConnectionTariffList;
    }

    public void setConnectionTariffList(List<String> connectionTariffList) {
        ConnectionTariffList = connectionTariffList;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @SerializedName("Error")
    @Expose
    private Error error;
}