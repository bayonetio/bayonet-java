package io.bayonet.model.ecommerce;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by imranarshad on 5/3/16.
 *
 */
class OutputPayload {


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


    HashMap<String, Object> getPayloadAsMap() throws IllegalAccessException {
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
     * Nested classes that build the output payload
     */

    class Timestamps {
        Long first_seen_on_network;
        Long last_seen_on_network;
        Long first_seen_on_client;
        Long last_seen_on_client;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    class VelocityModel {
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

    class VelocitySubModel {
        Integer total;
        Integer successful;
        Integer suspected_fraud_declines;
        Integer bank_declines;
        Integer unique_sites;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }

    }

    class LabeledParameters {
        Integer blocked_by_network;
        Integer blocked_by_client;
        Integer whitelisted_by_network;
        Integer whitelisted_by_client;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    class Transactions {

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

        class Successful {
            Integer total;
            Integer with_card_total;
            Integer with_card_last_14_days;
            Integer with_card_last_30_days;
            Integer offline_total;
            Integer offline_last_14_days;
            Integer offline_last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }

        class Declined {
            Integer total;
            Integer suspected_fraud_total;
            Integer suspected_fraud_last_14_days;
            Integer suspected_fraud_last_30_days;
            Integer bank_declines_total;
            Integer bank_declines_last_14_days;
            Integer bank_declines_last_30_days;
            Integer using_stolen_card_total;
            Integer using_stolen_card_last_14_days;
            Integer using_stolen_card_last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }

        class Chargebacks {
            Integer total;
            Integer last_14_days;
            Integer last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }

        class ExpeditedShipping {
            Integer total;
            Integer last_14_days;
            Integer last_30_days;

            HashMap<String, Object> getMap() throws IllegalAccessException {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Field field : this.getClass().getDeclaredFields()) {
                    map.put(field.getName(), field.get(this));
                }
                return map;
            }
        }
    }

    class PersonaParams {
        Integer total;
        Integer blocked_by_network;
        Integer blocked_by_client;
        Integer whitelisted_by_network;
        Integer whitelisted_by_client;
        Integer with_successful_transactions;
        Integer with_suspected_fraud_declines;
        Integer with_chargebacks;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    class PersonaParamsWithStolen {
        Integer total;
        Integer reported_as_stolen;
        Integer blocked_by_network;
        Integer blocked_by_client;
        Integer whitelisted_by_network;
        Integer whitelisted_by_client;
        Integer with_successful_transactions;
        Integer with_suspected_fraud_declines;
        Integer with_chargebacks;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    class DeviceInformation {
        String country;
        String city;
        Boolean is_in_multiple_timezones;
        Boolean is_blocking_ads;
        Boolean is_blocking_cookies;
        Boolean is_blocking_javascript;
        Boolean is_browser_spoofed;
        Boolean is_bot_detected;
        Boolean is_using_tor;
        Boolean is_using_do_not_track;
        Boolean is_browser_incognito;
        Boolean is_using_proxy;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

    class SocialProfileModel {

        Integer total;
        HashSet<String> facebook;
        HashSet<String> twitter;
        HashSet<String> instagram;
        HashSet<String> linkedin;
        HashSet<String> github;
        HashSet<String> foursquare;
        HashSet<String> google;
        HashSet<String> pinterest;
        HashSet<String> reddit;
        HashSet<String> angel_list;
        HashSet<String> behance;
        HashSet<String> quora;
        HashSet<String> skype;
        HashSet<String> youtube;

        HashMap<String, Object> getMap() throws IllegalAccessException {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (Field field : this.getClass().getDeclaredFields()) {
                map.put(field.getName(), field.get(this));
            }
            return map;
        }
    }

}