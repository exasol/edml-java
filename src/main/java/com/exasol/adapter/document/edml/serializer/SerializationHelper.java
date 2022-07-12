package com.exasol.adapter.document.edml.serializer;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.spi.JsonProvider;

import java.io.StringReader;

/**
 * Helper class for EDML Serialization
 */
public class SerializationHelper {
    private SerializationHelper() {
        // static class
    }

    /**
     * Add a key and string value to a json object builder if not null or empty
     *
     * @param jsonObjectBuilder the builder
     * @param key               the key
     * @param value             the value
     */
    public static void addIfNotNullOrEmpty(final JsonObjectBuilder jsonObjectBuilder, final String key,
            final String value) {
        if (value != null && !value.isEmpty()) {
            jsonObjectBuilder.add(key, value);
        }
    }

    /**
     * Add a key and json object (converted from string value) to a json object builder if not null or empty
     *
     * @param jsonObjectBuilder the builder
     * @param key the key
     * @param value the value
     */
    public static void addAsJsonObjectIfNotNullOrEmpty(final JsonObjectBuilder jsonObjectBuilder, final String key,
                                           final String value) {

        if (value != null && !value.isEmpty()) {
            final JsonProvider jsonProvider = JsonProvider.provider();
            //read the string into a json object
            JsonReader jsonReader = Json.createReader(new StringReader(value));
            JsonObject newJsonObject = jsonReader.readObject();
            jsonReader.close();
            JsonObjectBuilder newJsonObjectBuilder = jsonProvider.createObjectBuilder(newJsonObject);
            jsonObjectBuilder.add(key, newJsonObjectBuilder);
        }
    }
}
