package io.bayonet.model.ecommerce;

import io.bayonet.model.base.BaseResponse;
import io.bayonet.model.base.RulesTriggered;

import java.util.HashMap;

/**
 * Created by imranarshad on 11/27/17
 */

public class ConsultResponse extends BaseResponse {

    /** List of rules triggered by the persona consulted */

    private RulesTriggered rules_triggered;


    /** Decision to be taken regarding the consulted transactions */

    private String decision;


    /** Tracking ID returned by the Bayonet API */

    private String bayonet_tracking_id;


    /**
     * Getters
     */
    public RulesTriggered getRulesTriggered() {
        return rules_triggered;
    }

    public String getDecision() {
        return decision;
    }

    public String getBayonet_tracking_id() {
        return bayonet_tracking_id;
    }


}
