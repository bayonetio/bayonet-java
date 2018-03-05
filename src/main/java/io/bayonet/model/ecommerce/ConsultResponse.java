package io.bayonet.model.ecommerce;

import io.bayonet.model.base.BaseResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imranarshad on 11/27/17
 */

public class ConsultResponse extends BaseResponse {

    /** List of rules triggered by the persona consulted */

    private ArrayList<String> rules_triggered;


    /** Decision to be taken regarding the consulted transactions */

    private String decision;


    /** Response payload returned by the consulting call */

    private OutputPayload payload;


    /**
     * Getters
     */
    public ArrayList<String> getRulesTriggered() {
        return rules_triggered;
    }

    public String getDecision() {
        return decision;
    }

    public HashMap<String, Object> getPayloadAsMap() throws IllegalAccessException {
        return payload.getPayloadAsMap();
    }
}
