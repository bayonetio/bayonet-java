package io.bayonet.model.lending;

import java.util.HashMap;

/**
 * Created by imranarshad on 11/28/17
 */

public class LendingConsultResponse {

    /** Reason code returned by the API */

    private Integer reason_code;


    /** Reason message returned by the API */

    private String reason_message;


    /** Payload present in the response */

    private Payload payload;


    /**
     * Getters
     */
    public Integer getReasonCode() {
        return reason_code;
    }

    public String getReasonMessage() {
        return reason_message;
    }

    public HashMap<String, Object> getPayloadAsMap() {
        HashMap<String, Object> payload_map = new HashMap<String, Object>();
        payload_map.put("is_blocked", payload.is_blocked);
        payload_map.put("alerts_raised", payload.alerts_raised);
        payload_map.put("parameters_used", payload.parameters_used);
        payload_map.put("activity", payload.activity.getUserActivityAsMap());
        return payload_map;
    }


    /* START - nested classes to represent the payload */
    class Payload {
        boolean is_blocked;
        HashMap<String, Integer> alerts_raised;
        HashMap<String, Integer> parameters_used;
        UserActivity activity;
    }

    class UserActivity {
        Timestamps timestamps;
        Requests requests;

        HashMap<String, Object> getUserActivityAsMap() {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("timestamps", timestamps.getTimestampsAsMap());
            map.put("requests", requests.getRequestsAsMap());
            return map;
        }
    }

    class Timestamps {
        Long first_seen_on_network;
        Long last_seen_on_network;
        Long first_seen_on_client;
        Long last_seen_on_client;

        HashMap<String, Long> getTimestampsAsMap() {
            HashMap<String, Long> map = new HashMap<String, Long>();
            map.put("first_seen_on_network", first_seen_on_network);
            map.put("last_seen_on_network", last_seen_on_network);
            map.put("first_seen_on_client", first_seen_on_client);
            map.put("last_seen_on_client", last_seen_on_client);
            return map;
        }
    }

    class Requests {
        Integer total;
        Integer total_unique_sites;
        RequestsRecent recent;
        RequestsHistoric historic;

        HashMap<String, Object> getRequestsAsMap() {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("total", total);
            map.put("total_unique_sites", total_unique_sites);
            map.put("recent", recent.getRequestsRecentAsMap());
            map.put("historic", historic.getRequestsHistoricAsMap());
            return map;
        }
    }

    class RequestsRecent {
        Integer last_5_mins;
        Integer last_5_mins_unique_sites;
        Integer last_15_mins;
        Integer last_15_mins_unique_sites;
        Integer last_1_hour;
        Integer last_1_hour_unique_sites;
        Integer last_1_day;
        Integer last_1_day_unique_sites;

        HashMap<String, Integer> getRequestsRecentAsMap() {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("last_5_mins", last_5_mins);
            map.put("last_5_mins_unique_sites", last_5_mins_unique_sites);
            map.put("last_15_mins", last_15_mins);
            map.put("last_15_mins_unique_sites", last_15_mins_unique_sites);
            map.put("last_1_hour", last_1_hour);
            map.put("last_1_hour_unique_sites", last_1_hour_unique_sites);
            map.put("last_1_day", last_1_day);
            map.put("last_1_day_unique_sites", last_1_day_unique_sites);
            return map;
        }
    }

    class RequestsHistoric {
        Integer last_2_weeks;
        Integer last_2_weeks_unique_sites;
        Integer last_1_month;
        Integer last_1_month_unique_sites;
        Integer last_3_months;
        Integer last_3_months_unique_sites;
        Integer last_6_months;
        Integer last_6_months_unique_sites;

        HashMap<String, Integer> getRequestsHistoricAsMap() {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("last_2_weeks", last_2_weeks);
            map.put("last_2_weeks_unique_sites", last_2_weeks_unique_sites);
            map.put("last_1_month", last_1_month);
            map.put("last_1_month_unique_sites", last_1_month_unique_sites);
            map.put("last_3_months", last_3_months);
            map.put("last_3_months_unique_sites", last_3_months_unique_sites);
            map.put("last_6_months", last_6_months);
            map.put("last_6_months_unique_sites", last_6_months_unique_sites);
            return map;
        }
    }
    /* END nested classes */
}
