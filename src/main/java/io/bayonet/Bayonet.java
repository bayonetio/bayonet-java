package io.bayonet;

import io.bayonet.exceptions.BayonetException;
import io.bayonet.helpers.DataHelper;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by imranarshad on 11/27/17
 *
 * Base set up for all client implementations
 */

public class Bayonet {


    /** API versions supported by this SDK */

    private static final HashSet<String> SUPPORTED_API_VERSIONS = new HashSet<String>(Arrays.asList("2"));


    /** API key for connecting to the Bayonet API */

    protected String api_key;


    /** API version to connect to */

    protected String api_version;


    public Bayonet(String api_key, String api_version) {
        // set the api key and version
        this.api_key = api_key;
        this.api_version = api_version;
    }


    /**
     * Helper function to validate client configuration
     *
     * @throws BayonetException if client configuration is invalid
     */
    protected void validateClientConfig() throws BayonetException {
        // validate api key
        DataHelper.validateApiKey(api_key);
        // validate api version
        DataHelper.validateApiVersion(api_version, SUPPORTED_API_VERSIONS);
    }
}
