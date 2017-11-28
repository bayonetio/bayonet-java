package io.bayonet.exceptions;

/**
 * Created by imranarshad on 11/27/17
 */

public class BayonetException extends Exception {


    /** Error code */

    private Integer reason_code;


    /** Error message */

    private String reason_message;


    /**
     * Constructors
     */
    public BayonetException(Integer reason_code, String reason_message) {
        this.reason_code = reason_code;
        this.reason_message = reason_message;
    }

    public BayonetException(String reason_code, String reason_message) {
        try {
            this.reason_code = Integer.parseInt(reason_code);
        } catch (NumberFormatException e) {
            this.reason_code = -1;
        }
        this.reason_message = reason_message;
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
}
