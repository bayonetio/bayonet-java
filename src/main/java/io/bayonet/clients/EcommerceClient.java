package io.bayonet.clients;

import com.google.gson.Gson;
import io.bayonet.Bayonet;
import io.bayonet.exceptions.BayonetException;
import io.bayonet.helpers.HttpHelper;
import io.bayonet.model.base.BaseResponse;
import io.bayonet.model.ecommerce.*;
import io.bayonet.model.ecommerce.consulting.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imranarshad on 11/27/17
 *
 * Client implementation for connecting to the Bayonet Ecommerce API endpoints
 */

public class EcommerceClient extends Bayonet {

    /** Http response code returned by the API */

    private Integer http_response_code;


    /** Reason code included in the API response */

    private Integer reason_code;


    /** Reason message / error message included in the API response */

    private String reason_message;


    /** Unique code returned by the consulting API that will be used in the feedback API call */

    private String feedback_api_trans_code;


    /** List of rules triggered by the persona - only used on consulting API calls */

    private ArrayList<String> rules_triggered;


    /** Risk level associated to the persona consulted - RED, GREEN or YELLOW - only used on consulting API calls */

    private String risk_level;


    /** Payload data included in the response - only used on consulting API calls */

    private HashMap<String, Object> payload;


    /**
     * Constructor to set up the client configuration
     *
     * @param api_key client api key
     * @param api_version Bayonet api version to connect to
     * @throws BayonetException if error occurs while setting up the client
     */

    public EcommerceClient(String api_key, String api_version) throws BayonetException {
        super(api_key, api_version);
    }


    /**
     * Handler for sending consulting API calls
     *
     * @param params POST request parameters to be sent in the JSON payload
     * @throws BayonetException if the API returns an error
     */
    public void consulting(EcommerceConsultingRequest params) throws BayonetException {
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
        if(response_json!= null ) {
            // parse response if API call successful
            if (this.http_response_code == 200) {
                ConsultingResponse response = new Gson().fromJson(response_json, ConsultingResponse.class);
                this.reason_code = response.getReason_code();
                this.reason_message = response.getReason_message();
                this.feedback_api_trans_code = response.getFeedbackApiTransCode();
                this.rules_triggered = response.getRulesTriggered();
                this.risk_level = response.getRiskLevel();
                // get the entire payload as a nested map
                try {
                    this.payload = response.getPayloadAsMap();
                } catch (IllegalAccessException e) {
                    // this exception will only occur if there is some error with the implementation of nested map generation - which is the SDK's fault and not the client implementation
                    throw new BayonetException(-1, "Internal SDK error. Please contact the Bayonet team to report this bug", -1);
                }
            } else if (this.http_response_code == 400 || this.http_response_code == 500) { // the API returns only 400 and 500 error codes
                BaseResponse response = new Gson().fromJson(response_json, BaseResponse.class);
                throw new BayonetException(response.getReason_code(), response.getReason_message(), this.http_response_code);
            }
        }
        else {
            throw new BayonetException(-1, "Could not fetch a response from the Bayonet API. Please try again after some time", -1);
        }
    }


    /**
     * Handler for sending feedback API calls
     * @param params POST request parameters to be sent in the JSON payload
     * @throws BayonetException if the API returns an error
     */
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
        // process the response
        processGenericResponse(response_json);
    }


    /**
     * Handler for sending feedback-historical API calls
     * @param params POST request parameters to be sent in the JSON payload
     * @throws BayonetException if the API returns an error
     */
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
        // process the response
        processGenericResponse(response_json);
    }


    /**
     * Handler for sending update-transaction API calls
     *  - this endpoint is used to report changes in the status of a transaction, eg. a successful transaction gets cancelled at a later point in time
     * @param params POST request parameters to be sent in the JSON payload
     * @throws BayonetException if the API returns an error
     */
    public void updateTransaction(EcommerceUpdateTransactionRequest params) throws BayonetException {
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null", -1);
        resetClass();
        // add auth info to the params
        params.setApiKey(api_key);

        // send the request
        HttpHelper http_helper = new HttpHelper();
        http_helper.request(params, "update-transaction", api_version);
        this.http_response_code = http_helper.getResponseCode();
        String response_json = http_helper.getResponseJson();
        // process the response
        processGenericResponse(response_json);
    }


    /**
     * Helper function to process the generic response JSON
     *  - feedback and feedback-historical API endpoints return a generic response that contains only a reason_code and a reason_message
     * @param response_json JSON to process
     * @throws BayonetException if the API returns an error
     */
    private void processGenericResponse(String response_json) throws BayonetException {
        if(response_json!= null) {
            // parse the response json
            BaseResponse response = new Gson().fromJson(response_json, BaseResponse.class);
            this.reason_code = response.getReason_code();
            this.reason_message = response.getReason_message();
            // throw an exception if the API call failed
            if(this.http_response_code!= 200)
                throw new BayonetException(this.reason_code, this.reason_message, this.http_response_code);
        }
        else {  // could not get a response from the API
            throw new BayonetException(-1, "Could not fetch a response from the Bayonet API. Please try again after some time", -1);
        }
    }


    /**
     * Helper function to reset the member variables of the class
     *  - this ensured that the clients do not reuse a response between 2 successive calls using the same client object
     */
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
