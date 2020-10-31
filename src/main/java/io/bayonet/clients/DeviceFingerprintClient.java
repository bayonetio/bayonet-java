package io.bayonet.clients;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import io.bayonet.Bayonet;
import io.bayonet.exceptions.BayonetException;
import io.bayonet.helpers.HttpHelper;
import io.bayonet.model.device_fingerprint.DeviceFingerprintRequest;
import io.bayonet.model.device_fingerprint.ErrorResponse;

import java.util.HashMap;

/**
 * Created by imranarshad on 11/28/17
 *
 * Client implementation for connecting to the Bayonet Device Fingerprint API endpoints
 */

public class DeviceFingerprintClient extends Bayonet {

    /** Http response code returned by the API */

    private Integer http_response_code;


    /** Reason code included in the API response */

    private Integer reason_code;


    /** Reason message / error message included in the API response */

    private String reason_message;


    /** Device fingerprint generated by Bayonet Fingerprinting API */

    private String bayonet_fingerprint;


    /** Device info */

    private HashMap<String, Object> device_info;



    /**
     * Constructor to set up the client configuration
     *
     * @param api_key client api key
     * @param api_version Bayonet api version to connect to
     */

    public DeviceFingerprintClient(String api_key, String api_version) {
        super(api_key, api_version);
    }


    /**
     * Handler for sending get fingerprint data API calls
     * @param params POST request parameters to be sent in the JSON payload
     * @throws BayonetException if the API returns an error
     */
    public void queryFingerprintData(DeviceFingerprintRequest params) throws BayonetException {
        // validate client config
        this.validateClientConfig();
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null", -1);
        resetClass();
        // add auth info to the params
        params.setApiKey(api_key);

        // send the request
        HttpHelper http_helper = new HttpHelper();
        http_helper.request(params, "get-device-data", api_version);
        this.http_response_code = http_helper.getResponseCode();
        String response_json = http_helper.getResponseJson();
        // process the response
        if(response_json!= null) {
            if(this.http_response_code == 200) {
                // generate a Map from the json
                HashMap<String, Object> response_map = new Gson().fromJson(
                        response_json, new TypeToken<HashMap<String, Object>>() {}.getType()
                );
                this.device_info = response_map;
                this.reason_code = 0;
                this.reason_message = "success";
                if(response_map.containsKey("deviceFingerprint"))
                    this.bayonet_fingerprint = response_map.get("deviceFingerprint").toString();
            }
            else if (this.http_response_code == 400 || this.http_response_code == 500) { // the API returns only 400 and 500 error codes
                ErrorResponse error_response;
                try {
                    error_response = new Gson().fromJson(response_json, ErrorResponse.class);
                } catch (JsonSyntaxException e) {
                    throw new BayonetException(-1, "Internal SDK error. The client could not parse Device fingerprinting API response correctly. Please contact the Bayonet team to report this bug", -1);
                }
                // set default values if not present
                if(error_response.getReasonCode() == null) {
                    error_response.setReasonCode(-1);
                }
                if(error_response.getReasonMessage() == null) {
                    error_response.setReasonMessage("Could not fetch a response from the Bayonet API. Please try again after some time");
                }
                this.reason_code = error_response.getReasonCode();
                this.reason_message = error_response.getReasonMessage();
                throw new BayonetException(error_response.getReasonCode(), error_response.getReasonMessage(), this.http_response_code);
            }
        }
        else {
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
        bayonet_fingerprint = null;
        device_info = null;
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

    public String getBayonetFingerprint() {
        return bayonet_fingerprint;
    }

    public HashMap<String, Object> getDeviceInfo() {
        return device_info;
    }
}
