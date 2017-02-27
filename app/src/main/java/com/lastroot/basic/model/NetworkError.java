package com.lastroot.basic.model;

/**
 * Created by Truong Quoc Khanh on 2/24/2017.
 */

public class NetworkError {

    private String domain;
    private Integer errorSubcode;
    private String errorUserMsg;
    private String errorUserTitle;
    private String message;
    private String reason;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getErrorSubcode() {
        return errorSubcode;
    }

    public void setErrorSubcode(Integer errorSubcode) {
        this.errorSubcode = errorSubcode;
    }

    public String getErrorUserMsg() {
        return errorUserMsg;
    }

    public void setErrorUserMsg(String errorUserMsg) {
        this.errorUserMsg = errorUserMsg;
    }

    public String getErrorUserTitle() {
        return errorUserTitle;
    }

    public void setErrorUserTitle(String errorUserTitle) {
        this.errorUserTitle = errorUserTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
