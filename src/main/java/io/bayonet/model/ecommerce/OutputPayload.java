package io.bayonet.model.ecommerce;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by imranarshad on 5/3/16.
 *
 */
public class OutputPayload {


    /** Persona timestamp information */

    private Timestamps timestamps;


    /** Order velocity of the persona */

    private VelocityModel recent_activity;


    /** Parameters marked as blocked or whitelisted */

    private LabeledParameters labeled_parameters;


    /** Information related to historical transactions done by the persona */

    private Transactions transactions;


    /** Information related to emails */

    private PersonaParams emails;


    /** Information related to cards */

    private PersonaParamsWithStolen cards;


    /** Information related to addresses */

    private PersonaParams addresses;


    /** Information related to telephones */

    private PersonaParams telephones;


    /** Information related to devices */

    private PersonaParams devices;


    /** Information related to ip addresses */

    private PersonaParams ips;


    /** Device information */

    private DeviceInformation device_information;


    /** Information related to social_profiles */

    private SocialProfileModel social_profiles;


    public HashMap<String, Object> getPayloadAsMap() throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("timestamps", timestamps.getMap());
        map.put("recent_activity", recent_activity.getMap());
        map.put("labeled_parameters", labeled_parameters.getMap());
        map.put("transactions", transactions.getMap());
        map.put("emails", emails.getMap());
        map.put("cards", cards.getMap());
        map.put("addresses", addresses.getMap());
        map.put("telephones", telephones.getMap());
        map.put("devices", devices.getMap());
        map.put("ips", ips.getMap());
        map.put("device_information", device_information.getMap());
        map.put("social_profiles", social_profiles.getMap());
        return map;
    }

    /**
     * Static nested classes that build the Output Payload
     */

    static class Timestamps {
        private Long first_seen_on_network;
        private Long last_seen_on_network;
        private Long first_seen_on_client;
        private Long last_seen_on_client;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    static class VelocityModel {
        VelocitySubModel orders_last_15_mins;
        VelocitySubModel orders_last_30_mins;
        VelocitySubModel orders_last_hour;
        VelocitySubModel orders_last_day;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("orders_last_15_mins", orders_last_15_mins.getMap());
            map.put("orders_last_30_mins", orders_last_30_mins.getMap());
            map.put("orders_last_hour", orders_last_hour.getMap());
            map.put("orders_last_day", orders_last_day.getMap());
            return map;
        }
    }

    static class VelocitySubModel {
        private Integer total;
        private Integer successful;
        private Integer suspected_fraud_declines;
        private Integer bank_declines;
        private Integer unique_sites;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }

    }

    static class LabeledParameters {
        private Integer blocked_by_network;
        private Integer blocked_by_client;
        private Integer whitelisted_by_network;
        private Integer whitelisted_by_client;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    static class Transactions {

        Successful successful;
        Declined declined;
        Chargebacks chargebacks;
        ExpeditedShipping expedited_shipping;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("successful", successful.getMap());
            map.put("declined", declined.getMap());
            map.put("chargebacks", chargebacks.getMap());
            map.put("expedited_shipping", expedited_shipping.getMap());
            return map;
        }

        static class Successful {
            private Integer total;
            private Integer with_card_total;
            private Integer with_card_last_14_days;
            private Integer with_card_last_30_days;
            private Integer offline_total;
            private Integer offline_last_14_days;
            private Integer offline_last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }

        static class Declined {
            private Integer total;
            private Integer suspected_fraud_total;
            private Integer suspected_fraud_last_14_days;
            private Integer suspected_fraud_last_30_days;
            private Integer bank_declines_total;
            private Integer bank_declines_last_14_days;
            private Integer bank_declines_last_30_days;
            private Integer using_stolen_card_total;
            private Integer using_stolen_card_last_14_days;
            private Integer using_stolen_card_last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }

        static class Chargebacks {
            private Integer total;
            private Integer last_14_days;
            private Integer last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }

        static class ExpeditedShipping {
            private Integer total;
            private Integer last_14_days;
            private Integer last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }
    }

    static class PersonaParams {
        private Integer total;
        private Integer blocked_by_network;
        private Integer blocked_by_client;
        private Integer whitelisted_by_network;
        private Integer whitelisted_by_client;
        private Integer with_successful_transactions;
        private Integer with_suspected_fraud_declines;
        private Integer with_chargebacks;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    static class PersonaParamsWithStolen {
        private Integer total;
        private Integer reported_as_stolen;
        private Integer blocked_by_network;
        private Integer blocked_by_client;
        private Integer whitelisted_by_network;
        private Integer whitelisted_by_client;
        private Integer with_successful_transactions;
        private Integer with_suspected_fraud_declines;
        private Integer with_chargebacks;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    static class DeviceInformation {
        private String country;
        private String city;
        private Boolean is_in_multiple_timezones;
        private Boolean is_blocking_ads;
        private Boolean is_blocking_cookies;
        private Boolean is_blocking_javascript;
        private Boolean is_browser_spoofed;
        private Boolean is_bot_detected;
        private Boolean is_using_tor;
        private Boolean is_using_do_not_track;
        private Boolean is_browser_incognito;
        private Boolean is_using_proxy;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    static class SocialProfileModel {

        private Integer total;
        private HashSet<String> facebook;
        private HashSet<String> twitter;
        private HashSet<String> instagram;
        private HashSet<String> linkedin;
        private HashSet<String> github;
        private HashSet<String> foursquare;
        private HashSet<String> google;
        private HashSet<String> pinterest;
        private HashSet<String> reddit;
        private HashSet<String> angel_list;
        private HashSet<String> behance;
        private HashSet<String> quora;
        private HashSet<String> skype;
        private HashSet<String> youtube;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

}