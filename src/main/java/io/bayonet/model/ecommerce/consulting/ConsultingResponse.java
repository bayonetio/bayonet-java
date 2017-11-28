package io.bayonet.model.ecommerce.consulting;

import io.bayonet.model.base.BaseResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imranarshad on 11/27/17
 */

public class ConsultingResponse extends BaseResponse {

    public String feedback_api_trans_code;
    public ArrayList<String> rules_triggered;
    public String risk_level;
    public OutputPayload payload;

    public HashMap<String, Object> getPayloadAsMap() throws IllegalAccessException {
        return payload.getPayloadAsMap();
    }
}
