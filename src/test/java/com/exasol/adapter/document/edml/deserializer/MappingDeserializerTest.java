package com.exasol.adapter.document.edml.deserializer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.json.Json;
import jakarta.json.JsonObject;

class MappingDeserializerTest {

    private MappingDeserializer deserializer;

    @BeforeEach
    void setup() {
        this.deserializer = new MappingDeserializer();
    }

    @Test
    void testEmptyObject() {
        final JsonObject emptyObject = Json.createObjectBuilder().build();
        final IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> this.deserializer.deserializeMapping(emptyObject));
        assertThat(exception.getMessage(),
                equalTo("E-EDML-102: Invalid EDML definition. The mapping object must have exactly one property."));
    }

    @Test
    void testUnknownProperty() {
        final JsonObject emptyObject = Json.createObjectBuilder().add("unknown", "value").build();
        final IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> this.deserializer.deserializeMapping(emptyObject));
        assertThat(exception.getMessage(), startsWith(
                "E-EDML-103: Invalid EDML definition 'unknown'. The mapping object only allows the following properties"));
    }
}
