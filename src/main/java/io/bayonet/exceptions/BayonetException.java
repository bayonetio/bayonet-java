package io.bayonet.exceptions;

/**
 * Created by imranarshad on 11/27/17
 */

public class BayonetException extends Exception {


    /** Error code */

    private Integer reason_code;


    /** Error message */

    private String reason_message;


    /** Http response code */

    private Integer http_response_code;


    /**
     * Constructors
     */
    public BayonetException(Integer reason_code, String reason_message, Integer http_response_code) {
        this.reason_code = reason_code;
        this.reason_message = reason_message;
        this.http_response_code = http_response_code;
    }


    /**
     * Getters and Setters
     */
    public Integer getReasonCode() {
        return reason_code;
    }

    public String getReasonMessage() {
        return reason_message;
    }

    public Integer getHttpResponseCode() {
        return http_response_code;
    }
}
