package io.bayonet.helpers;

import com.google.gson.Gson;
import io.bayonet.exceptions.BayonetException;

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

    private int response_code;

    private String response_json;

    public void request(Object params, String route, String api_version) throws BayonetException {

        // check if params and route are present
        if(params == null)
            throw new BayonetException(-1, "params sent to the post request cannot be null", -1);
        if(route == null)
            throw new BayonetException(-1, "Internal SDK error. The Http client implementation is incorrect. Please contact the Bayonet team to report this bug", -1);
        // parse the params to json
        String params_as_json = new Gson().toJson(params);
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
            this.response_code = response_code;
            this.response_json = response.toString();



        } catch (IOException e) {
            throw new BayonetException(-1, "POST request to the Bayonet API endpoint (" + url + ") failed with the following error :\n" + e.getMessage(), -1);
        }
    }

    public int getResponseCode() {
        return response_code;
    }

    public String getResponseJson() {
        return response_json;
    }
}
