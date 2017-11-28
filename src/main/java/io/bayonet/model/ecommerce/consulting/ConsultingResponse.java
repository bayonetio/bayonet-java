package io.bayonet.model.ecommerce.consulting;

import io.bayonet.model.base.BaseResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imranarshad on 11/27/17
 */

public class ConsultingResponse extends BaseResponse {

    private String feedback_api_trans_code;
    private ArrayList<String> rules_triggered;
    private String risk_level;
    private OutputPayload payload;

    public String getFeedbackApiTransCode() {
        return feedback_api_trans_code;
    }

    public ArrayList<String> getRulesTriggered() {
        return rules_triggered;
    }

    public String getRiskLevel() {
        return risk_level;
    }

    public HashMap<String, Object> getPayloadAsMap() throws IllegalAccessException {
        return payload.getPayloadAsMap();
    }
}
