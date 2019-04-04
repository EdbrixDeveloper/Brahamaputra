package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TicktetSubmissionFromFieldEngineerDatum {

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
        @SerializedName("sheduledDateOfAcPm")
        @Expose
        private String sheduledDateOfAcPm;
        @SerializedName("modeOfOpration")
        @Expose
        private String modeOfOpration;
        @SerializedName("ticketNo")
        @Expose
        private String ticketNo;
        @SerializedName("vendorName")
        @Expose
        private String vendorName;
        @SerializedName("acTechnicianName")
        @Expose
        private String acTechnicianName;
        @SerializedName("acTechnicianMobileNo")
        @Expose
        private String acTechnicianMobileNo;
        @SerializedName("ticketStatusToWip")
        @Expose
        private String ticketStatusToWip;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("submittedDate")
        @Expose
        private String submittedDate;
        @SerializedName("feedBack")
        @Expose
        private String feedBack;
        @SerializedName("remark")
        @Expose
        private String remark;

        @SerializedName("Success")
        @Expose
        private Integer success;

        @SerializedName("Error")
        @Expose
        private Error error;

        @SerializedName("Code")
        @Expose
        private String code;

        @SerializedName("Message")
        @Expose
        private String message;

        /**
         * No args constructor for use in serialization
         *
         */
        public TicktetSubmissionFromFieldEngineerDatum() {
        }

        /**
         *
         * @param feedBack
         * @param acTechnicianName
         * @param ticketStatusToWip
         * @param vendorName
         * @param remark
         * @param status
         * @param ssa
         * @param state
         * @param circle
         * @param customer
         * @param ticketNo
         * @param siteId
         * @param modeOfOpration
         * @param submittedDate
         * @param acTechnicianMobileNo
         * @param siteName
         * @param sheduledDateOfAcPm
         */
        public TicktetSubmissionFromFieldEngineerDatum(String customer, String circle, String state, String ssa, String siteName, String siteId, String sheduledDateOfAcPm, String modeOfOpration, String ticketNo, String vendorName, String acTechnicianName, String acTechnicianMobileNo, String ticketStatusToWip, String status, String submittedDate, String feedBack, String remark) {
            super();
            this.customer = customer;
            this.circle = circle;
            this.state = state;
            this.ssa = ssa;
            this.siteName = siteName;
            this.siteId = siteId;
            this.sheduledDateOfAcPm = sheduledDateOfAcPm;
            this.modeOfOpration = modeOfOpration;
            this.ticketNo = ticketNo;
            this.vendorName = vendorName;
            this.acTechnicianName = acTechnicianName;
            this.acTechnicianMobileNo = acTechnicianMobileNo;
            this.ticketStatusToWip = ticketStatusToWip;
            this.status = status;
            this.submittedDate = submittedDate;
            this.feedBack = feedBack;
            this.remark = remark;
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

        public String getSheduledDateOfAcPm() {
            return sheduledDateOfAcPm;
        }

        public void setSheduledDateOfAcPm(String sheduledDateOfAcPm) {
            this.sheduledDateOfAcPm = sheduledDateOfAcPm;
        }

        public String getModeOfOpration() {
            return modeOfOpration;
        }

        public void setModeOfOpration(String modeOfOpration) {
            this.modeOfOpration = modeOfOpration;
        }

        public String getTicketNo() {
            return ticketNo;
        }

        public void setTicketNo(String ticketNo) {
            this.ticketNo = ticketNo;
        }

        public String getVendorName() {
            return vendorName;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        public String getAcTechnicianName() {
            return acTechnicianName;
        }

        public void setAcTechnicianName(String acTechnicianName) {
            this.acTechnicianName = acTechnicianName;
        }

        public String getAcTechnicianMobileNo() {
            return acTechnicianMobileNo;
        }

        public void setAcTechnicianMobileNo(String acTechnicianMobileNo) {
            this.acTechnicianMobileNo = acTechnicianMobileNo;
        }

        public String getTicketStatusToWip() {
            return ticketStatusToWip;
        }

        public void setTicketStatusToWip(String ticketStatusToWip) {
            this.ticketStatusToWip = ticketStatusToWip;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSubmittedDate() {
            return submittedDate;
        }

        public void setSubmittedDate(String submittedDate) {
            this.submittedDate = submittedDate;
        }

        public String getFeedBack() {
            return feedBack;
        }

        public void setFeedBack(String feedBack) {
            this.feedBack = feedBack;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

    public Integer getSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
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
}
