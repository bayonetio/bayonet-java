package io.bayonet.helpers;

import io.bayonet.exceptions.BayonetException;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by imranarshad on 11/27/17
 *
 * Helper class to assist with all data operations, eg. parsing JSON, data validations, etc.
 */

public class DataHelper {


    /**
     * Helper function to validate the provided api key
     *  - Api key should be non-null and non-empty
     *
     * @param api_key to validate
     * @throws BayonetException if the Api key is invalid
     */
    public static void validateApiKey(String api_key) throws BayonetException {
        if(api_key == null || api_key.isEmpty())
            throw new BayonetException(-1, "Please provide an Api key", -1);
    }


    /**
     * Helper function to validate the provided Api version
     *  - Api version should be non-null and non-empty
     *  - Api version should be one of the versions supported by this SDK
     *
     * @param api_version to validate
     * @param supported_versions versions supported by this SDK
     * @throws BayonetException if the Api version is invalid
     */
    public static void validateApiVersion(String api_version, HashSet<String> supported_versions) throws BayonetException {
        // check if version is valid
        if(api_version == null || api_version.isEmpty())
            throw new BayonetException(-1, "Please provide an Api version", -1);
        // check if version is supported
        if(!supported_versions.contains(api_version))
            throw new BayonetException(-1, "This SDK does not support the API version specified. Supported versions are : " + getCommaSeparatedStringFromCollection(supported_versions), -1);
    }

    /**
     * Helper function to build a comma separated string from a collection
     * @param collection of objects
     * @return comma separated string built from all objects in the collection
     */
    private static String getCommaSeparatedStringFromCollection(Collection<String> collection) {
        // return empty string if collection is empty
        if(collection == null || collection.size() == 0)
            return "";
        // initialize the string builder object
        StringBuilder collection_string_builder = new StringBuilder();
        String comma = "";
        // iterate over the collection and build the string
        for(String temp: collection) {
            collection_string_builder.append(comma).append(temp);
            comma = ",";
        }
        return collection_string_builder.toString();
    }
}
