package io.bayonet.model.base;

/**
 * Created by imranarshad on 8/16/17.
 *
 * pojo to represent a product that the customer is trying to buy
 */

public class Product {


    /** Client's internal product ID - item id, sku, etc. */

    String product_id;


    /** Name of the product */

    String product_name;


    /** Product price */

    Double product_price;


    /** Product category */

    String product_category;

    /**
     * Getter and Setter methods
     */
    public Product setProductId(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public Product setProductName(String product_name) {
        this.product_name = product_name;
        return this;
    }

    public Product setProductPrice(Double product_price) {
        this.product_price = product_price;
        return this;
    }

    public Product setProductCategory(String product_category) {
        this.product_category = product_category;
        return this;
    }
}
