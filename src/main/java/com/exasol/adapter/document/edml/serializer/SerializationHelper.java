package com.exasol.adapter.document.edml.serializer;

import jakarta.json.JsonObjectBuilder;

public class SerializationHelper {
    private SerializationHelper() {
        // static class
    }
    public static void addIfNotNullOrEmpty(final JsonObjectBuilder json, final String key, final String value) {
        if (value != null && !value.isEmpty()) {
            json.add(key, value);
        }
    }
}
