package io.bayonet.model.base;

import java.util.ArrayList;

/**
 * Created by imranarshad on 6/12/18
 *
 * models the rules triggered set in the consult API response
 */

public class RulesTriggered {

    /** List of all dynamic rules triggered */

    private ArrayList<String> dynamic;


    /** List of all custom rules triggered */

    private ArrayList<String> custom;


    /**
     * Getters
     */
    public ArrayList<String> getDynamic() {
        return dynamic;
    }

    public ArrayList<String> getCustom() {
        return custom;
    }
}
