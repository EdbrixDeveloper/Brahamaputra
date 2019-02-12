package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EbPaymentDetailsParent {

    @SerializedName("Success")
    @Expose
    private Integer success;

    @SerializedName("Code")
    @Expose
    private String code;

    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("EbPaymentDetails")
    @Expose
    private EbPaymentDetails ebPaymentDetails;


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

    public EbPaymentDetails getEbPaymentDetails() {
        return ebPaymentDetails;
    }

    public void setEbPaymentDetails(EbPaymentDetails ebPaymentDetails) {
        this.ebPaymentDetails = ebPaymentDetails;
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
