package io.bayonet.model.ecommerce.consulting;

/**
 * Created by imranarshad on 6/27/16.
 * pojo to represent the order velocity parameters for a persona - used in the consulting api response
 */
public class VelocityModel {
    Integer orders_last_15_mins;
    Integer orders_last_30_mins;
    Integer orders_last_hour;
    Integer orders_last_day;
    Integer orders_last_14_days;
    Integer unique_sites_last_15_mins;
    Integer unique_sites_last_30_mins;
    Integer unique_sites_last_hour;
    Integer unique_sites_last_day;
    Integer unique_sites_last_14_days;


    /** Default constructor to initialize all parameters with zero values */

    public VelocityModel() {
        orders_last_15_mins = 0;
        orders_last_30_mins = 0;
        orders_last_hour = 0;
        orders_last_day = 0;
        orders_last_14_days = 0;
        unique_sites_last_15_mins = 0;
        unique_sites_last_30_mins = 0;
        unique_sites_last_hour = 0;
        unique_sites_last_day = 0;
        unique_sites_last_14_days = 0;
    }


    /** Basic getter and setter methods for all class variables */

    public Integer getOrders_last_15_mins() {
        return orders_last_15_mins;
    }

    public void setOrders_last_15_mins(Integer orders_last_15_mins) {
        this.orders_last_15_mins = orders_last_15_mins;
    }

    public Integer getOrders_last_30_mins() {
        return orders_last_30_mins;
    }

    public void setOrders_last_30_mins(Integer orders_last_30_mins) {
        this.orders_last_30_mins = orders_last_30_mins;
    }

    public Integer getOrders_last_hour() {
        return orders_last_hour;
    }

    public void setOrders_last_hour(Integer orders_last_hour) {
        this.orders_last_hour = orders_last_hour;
    }

    public Integer getOrders_last_day() {
        return orders_last_day;
    }

    public void setOrders_last_day(Integer orders_last_day) {
        this.orders_last_day = orders_last_day;
    }

    public Integer getOrders_last_14_days() {
        return orders_last_14_days;
    }

    public void setOrders_last_14_days(Integer orders_last_14_days) {
        this.orders_last_14_days = orders_last_14_days;
    }

    public Integer getUnique_sites_last_15_mins() {
        return unique_sites_last_15_mins;
    }

    public void setUnique_sites_last_15_mins(Integer unique_sites_last_15_mins) {
        this.unique_sites_last_15_mins = unique_sites_last_15_mins;
    }

    public Integer getUnique_sites_last_30_mins() {
        return unique_sites_last_30_mins;
    }

    public void setUnique_sites_last_30_mins(Integer unique_sites_last_30_mins) {
        this.unique_sites_last_30_mins = unique_sites_last_30_mins;
    }

    public Integer getUnique_sites_last_hour() {
        return unique_sites_last_hour;
    }

    public void setUnique_sites_last_hour(Integer unique_sites_last_hour) {
        this.unique_sites_last_hour = unique_sites_last_hour;
    }

    public Integer getUnique_sites_last_day() {
        return unique_sites_last_day;
    }

    public void setUnique_sites_last_day(Integer unique_sites_last_day) {
        this.unique_sites_last_day = unique_sites_last_day;
    }

    public Integer getUnique_sites_last_14_days() {
        return unique_sites_last_14_days;
    }

    public void setUnique_sites_last_14_days(Integer unique_sites_last_14_days) {
        this.unique_sites_last_14_days = unique_sites_last_14_days;
    }

    /** Increment methods for all class variables */

    public void incrementOrdersLast_15_mins(Integer increment) {
        orders_last_15_mins += increment;
    }

    public void incrementOrdersLast_30_mins(Integer increment) {
        orders_last_30_mins += increment;
    }

    public void incrementOrdersLast_hour(Integer increment) {
        orders_last_hour += increment;
    }

    public void incrementOrdersLast_day(Integer increment) {
        orders_last_day += increment;
    }

    public void incrementOrdersLast_14_days(Integer increment) {
        orders_last_14_days += increment;
    }

    public void incrementUniqueSitesLast_15_mins(Integer increment) {
        unique_sites_last_15_mins += increment;
    }

    public void incrementUniqueSitesLast_30_mins(Integer increment) {
        unique_sites_last_30_mins += increment;
    }

    public void incrementUniqueSitesLast_hour(Integer increment) {
        unique_sites_last_hour += increment;
    }

    public void incrementUniqueSitesLast_day(Integer increment) {
        unique_sites_last_day += increment;
    }

    public void incrementUniqueSitesLast_14_days(Integer increment) {
        unique_sites_last_14_days += increment;
    }
}
