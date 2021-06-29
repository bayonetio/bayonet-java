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


    /** Merchant email */

    private String email;


    /** Merchant level - defined by the client */

    private Integer level;


    /** Unix timestamp of when the merchant was created */

    private Long created_at;


    /** Merchant address */

    private Address address;


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

    public Merchant setEmail(String email) {
        this.email = email;
        return this;
    }

    public Merchant setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Merchant setCreatedAt(Long createdAt) {
        this.created_at = createdAt;
        return this;
    }

    public Merchant setAddress(Address address) {
        this.address = address;
        return this;
    }
}
