package io.bayonet.model.base;

/**
 * Created by imranarshad on 6/15/21
 */

public class PaymentMetadata {

    /** Payment frequency - used for subscription or recurring payments */

    private String frequency;


    /** Payment type - one-time, subscription, etc. */

    private String type;


    public PaymentMetadata setFrequency(String frequency) {
        this.frequency = frequency;
        return this;
    }

    public PaymentMetadata setType(String type) {
        this.type = type;
        return this;
    }
}
