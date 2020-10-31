package io.bayonet.model.device_fingerprint;

/**
 * Created by imranarshad on 10/30/20
 *
 * model representing the error response returned by Device fingerprinting API
 *
 */

public class ErrorResponse {

    /** Reason code returned by the API */

    private Integer reasonCode;


    /** Reason message / error message returned by the API */

    private String reasonMessage;



    /**
     * Getters
     */
    public Integer getReasonCode() {
        return reasonCode;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }


    /**
     * Setters
     */
    public void setReasonCode(Integer reasonCode) {
        this.reasonCode = reasonCode;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }
}
