package io.bayonet.model.base;

/**
 * Created by imranarshad on 11/27/17
 *
 * model representing the generic API response returned by Bayonet APIs
 *
 */

public class BaseResponse {

    /** Reason code returned by the API */

    private Integer reason_code;


    /** Reason message / error message returned by the API */

    private String reason_message;



    /**
     * Getters
     */
    public Integer getReason_code() {
        return reason_code;
    }

    public String getReason_message() {
        return reason_message;
    }
}
