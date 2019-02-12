package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;
public class DgIdQrCode {

    @SerializedName("qRCodeScan")
    private String qRCodeScan;

    @SerializedName("id")
    private String id;

    public String getqRCodeScan() {
        return qRCodeScan;
    }

    public void setqRCodeScan(String qRCodeScan) {
        this.qRCodeScan = qRCodeScan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
