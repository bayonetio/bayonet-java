package io.bayonet.model.base;

/**
 * Created by imranarshad on 11/8/17
 *
 * model to define the actions sent by the clients using the lending API
 */

public class Actions {

    /** Flag whether to alert the network regarding the user in question */

    private Boolean alert;


    /** Flag to block a user in question (blocks user only on the client that sent the request) */

    private Boolean block;


    /**
     * Getter and Setter methods
     */
    public Actions setAlert(Boolean alert) {
        this.alert = alert;
        return this;
    }

    public Actions setBlock(Boolean block) {
        this.block = block;
        return this;
    }
}
