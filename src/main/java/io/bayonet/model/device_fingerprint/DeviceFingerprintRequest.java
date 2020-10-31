package io.bayonet.model.device_fingerprint;

/**
 * Created by imranarshad on 11/28/17
 *
 * model representing the device fingerprint API request
 */

public class DeviceFingerprintRequest {


    /** Auth info of the client */

    private AuthModel auth;


    /** Bayonet fingerprint token to query */

    private String bayonetFingerprintToken;


    /**
     * Setters
     */
    public void setApiKey(String api_key) {
        this.auth = new AuthModel(api_key);
    }
    public DeviceFingerprintRequest setBayonetFingerprintToken(String bayonet_fingerprint_token) {
        this.bayonetFingerprintToken = bayonet_fingerprint_token;
        return this;
    }
}
