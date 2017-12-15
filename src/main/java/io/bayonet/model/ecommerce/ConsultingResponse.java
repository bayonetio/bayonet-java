package io.bayonet.model.ecommerce;

import io.bayonet.model.base.BaseResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imranarshad on 11/27/17
 */

public class ConsultingResponse extends BaseResponse {

    /** Unique code returned by the Consulting API to be used on subsequent Feedback API calls */

    private String feedback_api_trans_code;


    /** List of rules triggered by the persona consulted */

    private ArrayList<String> rules_triggered;


    /** Risk level associated to the persona consulted */

    private String risk_level;


    /** Response payload returned by the consulting call */

    private OutputPayload payload;


    /**
     * Getters
     */
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
