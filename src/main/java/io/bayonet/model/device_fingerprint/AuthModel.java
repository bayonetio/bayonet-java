package io.bayonet.model.device_fingerprint;

/**
 * Created by imranarshad on 7/10/17.
 *
 * model representing client authentication information
 */
public class AuthModel {

    /** Api key */

    private String apiKey;


    /**
     * Constructors
     */
    public AuthModel(String api_key){
        this.apiKey = api_key;
    }
}
