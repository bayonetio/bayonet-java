package io.bayonet.model.base;

/**
 * Created by imranarshad on 11/9/23
 */

public class ProductMetadata {

    /** Event timestamp as UNIX time in seconds - used to for products that have a time of occurrence, e.g. concerts, airline tickets */

    private Long event_time;

    /** Event location - used to for products that have a place of occurrence, e.g. concerts */

    private Location event_location;


    public ProductMetadata setEventTime(Long event_time) {
        this.event_time = event_time;
        return this;
    }

    public ProductMetadata setEventLocation(Location location) {
        this.event_location = location;
        return this;
    }
}
