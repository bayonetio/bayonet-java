package io.bayonet.model.lending;

import java.util.HashMap;

/**
 * Created by imranarshad on 11/28/17
 */

public class LendingConsultResponse {

    private Integer reason_code;

    private String reason_message;

    private Payload payload;


    static class Payload {
        boolean is_blocked;
        HashMap<String, Integer> alerts_raised_by_user;
        HashMap<String, Integer> parameters_used_by_user;
        UserActivity user_activity;
        HashMap<String, Object> user_device_information;


    }

    class UserActivity {
        Long first_seen_on_network;
        Long last_seen_on_network;
        Long first_seen_on_client;
        Long last_seen_on_client;
        Integer requests_total;
        Integer requests_last_5_mins;
        Integer requests_last_15_mins;
        Integer requests_last_1_hour;
        Integer requests_last_1_day;
        Integer requests_last_2_weeks;
        Integer requests_last_1_month;
        Integer requests_last_3_months;
        Integer requests_last_6_months;

        public HashMap<String, Object> getUserActivityAsMap() {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("first_seen_on_network", first_seen_on_network);
            map.put("last_seen_on_network", last_seen_on_network);
            map.put("first_seen_on_client", first_seen_on_client);
            map.put("last_seen_on_client", last_seen_on_client);
            map.put("requests_total", requests_total);
            map.put("requests_last_5_mins", requests_last_5_mins);
            map.put("requests_last_15_mins", requests_last_15_mins);
            map.put("requests_last_1_hour", requests_last_1_hour);
            map.put("requests_last_1_day", requests_last_1_day);
            map.put("requests_last_2_weeks", requests_last_2_weeks);
            map.put("requests_last_1_month", requests_last_1_month);
            map.put("requests_last_3_months", requests_last_3_months);
            map.put("requests_last_6_months", requests_last_6_months);
            return map;
        }
    }

    public Integer getReasonCode() {
        return reason_code;
    }

    public String getReasonMessage() {
        return reason_message;
    }

    public HashMap<String, Object> getPayloadAsMap() {
        HashMap<String, Object> payload_map = new HashMap<String, Object>();
        payload_map.put("is_blocked", payload.is_blocked);
        payload_map.put("alerts_raised_by_user", payload.alerts_raised_by_user);
        payload_map.put("parameters_used_by_user", payload.parameters_used_by_user);
        payload_map.put("user_device_information", payload.user_device_information);
        payload_map.put("user_activity", payload.user_activity.getUserActivityAsMap());
        return payload_map;
    }
}
