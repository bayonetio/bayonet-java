package io.bayonet.model;

import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

/**
 * Created by imranarshad on 11/27/17
 */

public class BayonetResponse {

    //private LinkedTreeMap response_map;
    private JsonObject json_object;


//    public BayonetResponse(LinkedTreeMap response_map) {
//        this.response_map = response_map;
//    }
    public BayonetResponse(JsonObject json_object) {
        this.json_object = json_object;
    }


}
