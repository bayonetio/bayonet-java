package io.bayonet.model.base;

/**
 * Created by imranarshad on 8/16/17.
 *
 * model to represent a product that the customer is trying to buy
 *  - used by the ecommerce endpoints
 */

public class Product {


    /** Client's internal product ID - item id, sku, etc. */

    private String product_id;


    /** Name of the product */

    private String product_name;


    /** Product price */

    private Double product_price;


    /** Product category */

    private String product_category;


    /** Product quantity */

    private Integer product_quantity;


    /** Product metadata */

    private ProductMetadata metadata;



    /**
     * Setters
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

    public Product setProductQuantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
        return this;
    }

    public Product setProductMetadata(ProductMetadata metadata) {
        this.metadata = metadata;
        return this;
    }
}
