package com.exasol.adapter.document.edml.serializer;

import jakarta.json.JsonObjectBuilder;

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
}
