package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DieselRequestTicketNoList {

    @SerializedName("Success")
    private Integer Success;

    @SerializedName("Code")
    private String Code;

    @SerializedName("Message")
    private String Message;

    @SerializedName("DiselRequestTicketList")
    private List<DiselRequestTicketList> diselRequestTicketList = null;

    public Integer getSuccess() {
        return Success;
    }

    public void setSuccess(Integer success) {
        Success = success;
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

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public List<DiselRequestTicketList> getDiselRequestTicketList() {
        return diselRequestTicketList;
    }

    public void setDiselRequestTicketList(List<DiselRequestTicketList> diselRequestTicketList) {
        this.diselRequestTicketList = diselRequestTicketList;
    }
}
