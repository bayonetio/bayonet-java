package io.bayonet.model.base;

/**
 * Created by imranarshad on 6/15/21
 */

public class PaymentTerminal {

    /** Payment terminal ID */

    String id;

    /** Payment terminal location */

    Location location;


    public PaymentTerminal setId(String id) {
        this.id = id;
        return this;
    }

    public PaymentTerminal setLocation(Location location) {
        this.location = location;
        return this;
    }
}
