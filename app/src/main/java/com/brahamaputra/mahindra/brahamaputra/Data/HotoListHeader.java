package com.brahamaputra.mahindra.brahamaputra.Data;

public class HotoListHeader {

    private String headerName;

    private String headerCount;

    public HotoListHeader(String headerName, String headerCount) {
        this.headerName = headerName;
        this.headerCount = headerCount;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getHeaderCount() {
        return headerCount;
    }

    public void setHeaderCount(String headerCount) {
        this.headerCount = headerCount;
    }
}
