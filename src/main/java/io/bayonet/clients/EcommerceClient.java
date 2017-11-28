package io.bayonet.clients;

import com.google.gson.Gson;
import io.bayonet.Bayonet;
import io.bayonet.exceptions.BayonetException;
import io.bayonet.helpers.HttpHelper;
import io.bayonet.model.base.BaseResponse;
import io.bayonet.model.ecommerce.consulting.EcommerceConsultingRequest;
import io.bayonet.model.ecommerce.consulting.ConsultingResponse;
import io.bayonet.model.ecommerce.consulting.EcommerceFeedbackHistoricalRequest;
import io.bayonet.model.ecommerce.consulting.EcommerceFeedbackRequest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imranarshad on 11/27/17
 *
 * Client implementation for connecting to the Bayonet Ecommerce API endpoints
 */

public class EcommerceClient extends Bayonet {

    private Integer http_response_code;
    private Integer reason_code;
    private String reason_message;
    private String feedback_api_trans_code;

    private ArrayList<String> rules_triggered;
    private String risk_level;
    private HashMap<String, Object> payload;

    public EcommerceClient(String api_key, String api_version) throws BayonetException {
        super(api_key, api_version);
    }

    public void consulting(EcommerceConsultingRequest params) throws BayonetException, IllegalAccessException {
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null", -1);
        resetClass();
        // add auth info to the params
        params.setApiKey(api_key);

        // send the request
        HttpHelper http_helper = new HttpHelper();
        http_helper.request(params, "consulting", api_version);
        this.http_response_code = http_helper.getResponseCode();
        String response_json = http_helper.getResponseJson();
        ConsultingResponse response = new Gson().fromJson(response_json, ConsultingResponse.class);
        this.reason_code = response.getReason_code();
        this.reason_message = response.getReason_message();
        this.feedback_api_trans_code = response.getFeedbackApiTransCode();
        this.rules_triggered = response.getRulesTriggered();
        this.risk_level = response.getRiskLevel();
        this.payload = response.getPayloadAsMap();
    }

    public void feedback(EcommerceFeedbackRequest params) throws BayonetException {
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null", -1);
        resetClass();
        // add auth info to the params
        params.setApiKey(api_key);

        // send the request
        HttpHelper http_helper = new HttpHelper();
        http_helper.request(params, "feedback", api_version);
        this.http_response_code = http_helper.getResponseCode();
        String response_json = http_helper.getResponseJson();
        BaseResponse response = new Gson().fromJson(response_json, BaseResponse.class);
        this.reason_code = response.getReason_code();
        this.reason_message = response.getReason_message();
    }

    public void feedbackHistorical(EcommerceFeedbackHistoricalRequest params) throws BayonetException {
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null", -1);
        resetClass();
        // add auth info to the params
        params.setApiKey(api_key);

        // send the request
        HttpHelper http_helper = new HttpHelper();
        http_helper.request(params, "feedback-historical", api_version);
        this.http_response_code = http_helper.getResponseCode();
        String response_json = http_helper.getResponseJson();
        BaseResponse response = new Gson().fromJson(response_json, BaseResponse.class);
        this.reason_code = response.getReason_code();
        this.reason_message = response.getReason_message();
    }

    private void resetClass() {
        reason_code = null;
        reason_message = null;
        feedback_api_trans_code = null;
        rules_triggered = null;
        risk_level = null;
        payload = null;
    }


    /**
     * Getters
     */
    public Integer getHttpResponseCode() {
        return http_response_code;
    }

    public Integer getReasonCode() {
        return reason_code;
    }

    public String getReasonMessage() {
        return reason_message;
    }

    public String getFeedbackApiTransCode() {
        return feedback_api_trans_code;
    }

    public ArrayList<String> getRulesTriggered() {
        return rules_triggered;
    }

    public String getRiskLevel() {
        return risk_level;
    }

    public HashMap<String, Object> getPayload() {
        return payload;
    }
}
