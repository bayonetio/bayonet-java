package io.bayonet.model.device_fingerprint;

/**
 * Created by imranarshad on 11/28/17
 *
 * model representing the device fingerprint API request
 */

public class DeviceFingerprintRequest {


    /** Api key to authenticate the client */

    private String api_key;


    /** Bayonet fingerprint token to query */

    private String bayonet_fingerprint_token;


    /**
     * Setters
     */
    public void setApiKey(String api_key) {
        this.api_key = api_key;
    }
    public DeviceFingerprintRequest setBayonetFingerprintToken(String bayonet_fingerprint_token) {
        this.bayonet_fingerprint_token = bayonet_fingerprint_token;
        return this;
    }
}
