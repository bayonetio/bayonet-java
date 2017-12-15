package io.bayonet.model.base;

/**
 * Created by imranarshad on 7/10/17.
 *
 * model representing client authentication information
 */
public class AuthModel {

    /** Api key */

    private String api_key;


    /**
     * Constructors
     */
    public AuthModel(String api_key){
        this.api_key = api_key;
    }
}
