package io.bayonet.model.base;

/**
 * Created by imranarshad on 4/13/16.
 *
 * pojo to map the Address of a consumer
 *
 * The class variables are self-explanatory - no more helpful comments after this!! :)
 */
public class Address {
    private String line_1;
    private String line_2;
    private String city;
    private String state;
    private String country;
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
