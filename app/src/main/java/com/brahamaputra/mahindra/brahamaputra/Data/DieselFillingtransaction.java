package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DieselFillingtransaction{
    @SerializedName("Success")
    @Expose
    private Integer success;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("DiselFillingTransactionList")
    @Expose
    private List<DiselFillingTransactionList> diselFillingTransactionList = null;

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

    public List<DiselFillingTransactionList> getDiselFillingTransactionList() {
        return diselFillingTransactionList;
    }

    public void setDiselFillingTransactionList(List<DiselFillingTransactionList> diselFillingTransactionList) {
        this.diselFillingTransactionList = diselFillingTransactionList;
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
