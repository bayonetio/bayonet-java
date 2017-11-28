package io.bayonet.model.base;

/**
 * Created by imranarshad on 11/27/17
 */

public class BaseResponse {

    protected Integer reason_code;

    protected String reason_message;

    public Integer getReason_code() {
        return reason_code;
    }

    public String getReason_message() {
        return reason_message;
    }
}
