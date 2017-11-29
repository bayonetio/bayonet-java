package io.bayonet.clients;

import com.google.gson.Gson;
import io.bayonet.Bayonet;
import io.bayonet.exceptions.BayonetException;
import io.bayonet.helpers.HttpHelper;
import io.bayonet.model.base.BaseResponse;
import io.bayonet.model.ecommerce.EcommerceFeedbackHistoricalRequest;
import io.bayonet.model.lending.LendingFeedbackHistoricalRequest;

import java.util.HashMap;

/**
 * Created by imranarshad on 11/28/17
 *
 * Client implementation for connecting to the Bayonet Lending API endpoints
 */

public class LendingClient extends Bayonet {

    /** Http response code returned by the API */

    private Integer http_response_code;


    /** Reason code included in the API response */

    private Integer reason_code;


    /** Reason message / error message included in the API response */

    private String reason_message;


    /** Payload data included in the response - only used on consulting API calls */

    private HashMap<String, Object> payload;


    /**
     * Constructor to set up the client configuration
     *
     * @param api_key client api key
     * @param api_version Bayonet api version to connect to
     * @throws BayonetException if error occurs while setting up the client
     */

    public LendingClient(String api_key, String api_version) throws BayonetException {
        super(api_key, api_version);
    }


    /**
     * Handler for sending feedback-historical API calls
     * @param params POST request parameters to be sent in the JSON payload
     * @throws BayonetException if the API returns an error
     */
    public void feedbackHistorical(LendingFeedbackHistoricalRequest params) throws BayonetException {
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null", -1);
        resetClass();
        // add auth info to the params
        params.setApiKey(api_key);

        // send the request
        HttpHelper http_helper = new HttpHelper();
        http_helper.request(params, "lending/feedback-historical", api_version);
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
        payload = null;
    }
}
