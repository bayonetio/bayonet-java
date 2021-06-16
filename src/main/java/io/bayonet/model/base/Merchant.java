package io.bayonet.model.base;

/**
 * Created by imranarshad on 6/15/21
 */

public class Merchant {

    /** Merchant ID */

    private String id;


    /** Merchant name */

    private String name;


    /** Merchant category code (generally referred to as MCC) */

    private String category_code;


    /** Merchant vertical (electronics, digital wallet, etc.) */

    private String vertical;


    public Merchant setId(String id) {
        this.id = id;
        return this;
    }

    public Merchant setName(String name) {
        this.name = name;
        return this;
    }

    public Merchant setCategoryCode(String categoryCode) {
        this.category_code = categoryCode;
        return this;
    }

    public Merchant setVertical(String vertical) {
        this.vertical = vertical;
        return this;
    }
}
