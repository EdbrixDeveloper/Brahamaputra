
package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_Selected_SiteType;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.hototicket_sourceOfPower;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmNoOfAcAvailableAtSite;
import static com.brahamaputra.mahindra.brahamaputra.Utils.Constants.sitePmServoStabilizerWorkingStatus;

public class AcPmTransactionDetails implements Serializable {

    @SerializedName("AccessToken")
    @Expose
    private String accessToken;
    @SerializedName("UserId")
    @Expose
    private String userId;

    @SerializedName("acPMTicketId")
    @Expose
    private String acPMTicketId;

    @SerializedName("acPreventiveMaintanceProcess")
    @Expose
    private AcPreventiveMaintanceProcessParentDatum acPreventiveMaintanceProcessParentDatum;


    public AcPmTransactionDetails() {
        acPreventiveMaintanceProcessParentDatum = new AcPreventiveMaintanceProcessParentDatum();
    }

    public AcPmTransactionDetails(String userId, String accessToken, String ticketId, String checkInLat, String checkInLong, String checkInBatteryData, String checkOutLat, String checkOutLong, String checkOutBatteryData) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.acPMTicketId = ticketId;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTicketId() {
        return acPMTicketId;
    }

    public void setTicketId(String ticketId) {
        this.acPMTicketId = ticketId;
    }

    public AcPreventiveMaintanceProcessParentDatum getAcPreventiveMaintanceProcessParentDatum() {
        return acPreventiveMaintanceProcessParentDatum;
    }

    public void setAcPreventiveMaintanceProcessParentDatum(AcPreventiveMaintanceProcessParentDatum acPreventiveMaintanceProcessParentDatum) {
        this.acPreventiveMaintanceProcessParentDatum = acPreventiveMaintanceProcessParentDatum;
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
