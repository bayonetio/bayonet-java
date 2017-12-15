package io.bayonet.model.base;

/**
 * Created by imranarshad on 4/13/16.
 *
 * model to map the Address of a consumer
 *
 */
public class Address {

    /** Address line 1 */

    private String line_1;


    /** Address line 2 */

    private String line_2;


    /** City */

    private String city;


    /** State */

    private String state;


    /** Country - 3 letter ISO country code */

    private String country;


    /** Zip code */

    private String zip_code;



    /**
     * Getters and Setters
     */
    public Address setLine1(String line_1) {
        this.line_1 = line_1;
        return this;
    }

    public Address setLine2(String line_2) {
        this.line_2 = line_2;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public Address setZipCode(String zip_code) {
        this.zip_code = zip_code;
        return this;
    }
}
