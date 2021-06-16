package io.bayonet.model.base;

/**
 * Created by imranarshad on 6/15/21
 */

public class Location {

    private String latitude;
    private String longitude;

    public Location() {
    }

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public Location setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }
}
