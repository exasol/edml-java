package com.exasol.adapter.document.edml.serializer;

import static com.exasol.adapter.document.edml.serializer.SerializationHelper.addAsJsonObjectIfNotNullOrEmpty;
import static com.exasol.adapter.document.edml.serializer.SerializationHelper.addIfNotNullOrEmpty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.exasol.adapter.document.edml.*;

import jakarta.json.JsonObjectBuilder;
import jakarta.json.spi.JsonProvider;

//[utest->dsn~edml-serialization~1]
class EdmlSerializerTest {
    private static final String SCHEMA_URL = "https://schemas.exasol.com/edml-2.0.0.json";

    @Test
    void testSerialization() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("test")
                .mapping(Fields.builder().mapField("test", ToVarcharMapping.builder().build()).build()).build();
        final String serialized = new EdmlSerializer().serialize(edmlDefinition);
        final String expected = "{\"$schema\":\"" + SCHEMA_URL
                + "\",\"source\":\"test\",\"destinationTable\":\"test\",\"description\":\"\",\"addSourceReferenceColumn\":false,\"mapping\":{\"fields\":{\"test\":{\"toVarcharMapping\":{\"key\":\"none\",\"required\":false,\"varcharColumnSize\":254,\"nonStringBehaviour\":\"CONVERT_OR_ABORT\",\"overflowBehaviour\":\"TRUNCATE\"}}}}}";
        assertThat(serialized, equalTo(expected));
    }

    @Test
    void testSerializationWithoutMapping() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("test").build();
        final String serialized = new EdmlSerializer().serialize(edmlDefinition);
        final String expected = "{\"$schema\":\"" + SCHEMA_URL
                + "\",\"source\":\"test\",\"destinationTable\":\"test\",\"description\":\"\",\"addSourceReferenceColumn\":false}";
        assertThat(serialized, equalTo(expected));
    }

    @Test
    void testSerializeToTableMapping() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("test")
                .mapping(Fields.builder().mapField("test", //
                        ToTableMapping.builder().mapping(Fields.builder()//
                                .mapField("id", ToVarcharMapping.builder().build())//
                                .build()).build())
                        .build())
                .build();
        final String serialized = new EdmlSerializer().serialize(edmlDefinition);
        final String expected = "{\"$schema\":\"" + SCHEMA_URL
                + "\",\"source\":\"test\",\"destinationTable\":\"test\",\"description\":\"\",\"addSourceReferenceColumn\":false,\"mapping\":{\"fields\":{\"test\":{\"toTableMapping\":{\"mapping\":{\"fields\":{\"id\":{\"toVarcharMapping\":{\"key\":\"none\",\"required\":false,\"varcharColumnSize\":254,\"nonStringBehaviour\":\"CONVERT_OR_ABORT\",\"overflowBehaviour\":\"TRUNCATE\"}}}},\"description\":\"\"}}}}}";
        assertThat(serialized, equalTo(expected));
    }

    @ParameterizedTest
    @CsvSource(value = { "null, FALSE", "'', FALSE", "testtest, TRUE" }, nullValues = { "null" })
    void testAddIfNotNullOrEmptyMethodNull(final String value, final boolean testResult) {
        final JsonProvider JSON = JsonProvider.provider();
        final String key = "test";

        final JsonObjectBuilder mappingBuilder = JSON.createObjectBuilder();
        addIfNotNullOrEmpty(mappingBuilder, key, value);
        final var result = mappingBuilder.build();
        assertThat(result.containsKey(key), equalTo(testResult));
    }

    @ParameterizedTest
    @CsvSource(value = { "null, FALSE", "'', FALSE", "{    \"csv-headers\": true  }, TRUE" }, nullValues = { "null" })
    void testAddJsonObjectIfNotNullOrEmptyMethodNull(final String value, final boolean testResult) {
        final JsonProvider JSON = JsonProvider.provider();
        final String key = "test";

        final JsonObjectBuilder mappingBuilder = JSON.createObjectBuilder();
        addAsJsonObjectIfNotNullOrEmpty(mappingBuilder, key, value);
        final var result = mappingBuilder.build();
        assertThat(result.containsKey(key), equalTo(testResult));
    }
}
