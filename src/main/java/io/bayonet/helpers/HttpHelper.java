package io.bayonet.helpers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.bayonet.exceptions.BayonetException;
import io.bayonet.model.BayonetResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by imranarshad on 11/27/17
 *
 * Helper class to perform all http operations
 */

public class HttpHelper {


    /** API connection base url */

    private static final String BASE_URL = "https://staging-api.bayonet.io/v";


    /** User Agent to send with the requests */

    private static final String USER_AGENT = "OfficialBayonetJavaSDK";

    public static String request(Object params, String route, String api_version) throws BayonetException {

        // check if params and route are present
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null");
        if(route == null)
            throw new BayonetException(-1, "Internal SDK error. The Http client implementation is incorrect. Please contact the Bayonet team");
        // parse the params to json
        String params_as_json = new Gson().toJson(params);
        System.out.println(params_as_json);
        // API full url
        String url = BASE_URL + api_version + "/" + route;

        try {
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            //add request headers
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-Type", "application/json");

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(params_as_json);
            wr.flush();
            wr.close();

            int response_code = con.getResponseCode();
            BufferedReader in;
            if(response_code == 200) {
                 in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
            }
            else {
                in = new BufferedReader(
                        new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String response_json_string = response.toString();

            JsonObject response_json_object = new JsonParser().parse(response_json_string).getAsJsonObject();
            //LinkedTreeMap response_map = DataHelper.getMapFromJson(response_json);
            // throw Bayonet exception with the received error code and error message if API call failed
            if(response_code!= 200) {
                if(response_json_object.has("reason_code") && response_json_object.has("reason_message")) {
                    throw new BayonetException(response_json_object.get("reason_code").getAsInt(), response_json_object.get("reason_message").toString());
                }
            }

            return response_json_string;


        } catch (IOException e) {
            throw new BayonetException(-1, "POST request to the Bayonet API endpoint (" + url + ") failed with the following error :\n" + e.getMessage());
        }
    }
}
