package io.bayonet.clients;

import com.google.gson.Gson;
import io.bayonet.Bayonet;
import io.bayonet.exceptions.BayonetException;
import io.bayonet.helpers.HttpHelper;
import io.bayonet.model.BayonetResponse;
import io.bayonet.model.ecommerce.consulting.ConsultingRequest;
import io.bayonet.model.ecommerce.consulting.ConsultingResponse;

/**
 * Created by imranarshad on 11/27/17
 *
 * Client implementation for connecting to the Bayonet Ecommerce API endpoints
 */

public class EcommerceClient extends Bayonet {

    public EcommerceClient(String api_key, String api_version) throws BayonetException {
        super(api_key, api_version);
    }

    public ConsultingResponse consulting(ConsultingRequest params) throws BayonetException {
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null");
        // add auth info to the params
        params.setApiKey(api_key);

        // send the request
        String response_json = HttpHelper.request(params, "consulting", api_version);
        return new Gson().fromJson(response_json, ConsultingResponse.class);
    }
}
