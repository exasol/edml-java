package com.exasol.adapter.document.edml.serializer;

import static com.exasol.adapter.document.edml.serializer.SerializationHelper.addIfNotNullOrEmpty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import jakarta.json.JsonObjectBuilder;
import jakarta.json.spi.JsonProvider;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.document.edml.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//[utest->dsn~edml-serialization~1]
class EdmlSerializerTest {
    @Test
    void testSerialization() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("test")
                .mapping(Fields.builder().mapField("test", ToVarcharMapping.builder().build()).build()).build();
        final String serialized = new EdmlSerializer().serialize(edmlDefinition);
        final String expected = "{\"$schema\":\"https://schemas.exasol.com/edml-1.4.0.json\",\"source\":\"test\",\"destinationTable\":\"test\",\"description\":\"\",\"addSourceReferenceColumn\":false,\"mapping\":{\"fields\":{\"test\":{\"toVarcharMapping\":{\"key\":\"none\",\"required\":false,\"varcharColumnSize\":254,\"nonStringBehaviour\":\"CONVERT_OR_ABORT\",\"overflowBehaviour\":\"TRUNCATE\"}}}}}" ;
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
        final String expected = "{\"$schema\":\"https://schemas.exasol.com/edml-1.4.0.json\",\"source\":\"test\",\"destinationTable\":\"test\",\"description\":\"\",\"addSourceReferenceColumn\":false,\"mapping\":{\"fields\":{\"test\":{\"toTableMapping\":{\"mapping\":{\"fields\":{\"id\":{\"toVarcharMapping\":{\"key\":\"none\",\"required\":false,\"varcharColumnSize\":254,\"nonStringBehaviour\":\"CONVERT_OR_ABORT\",\"overflowBehaviour\":\"TRUNCATE\"}}}},\"description\":\"\"}}}}}" ;
        assertThat(serialized, equalTo(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"null, FALSE",
            "'', FALSE",
            "testtest, TRUE"}
            , nullValues = {"null"})
    void testAddIfNotNullOrEmptyMethodNull(String value, boolean testResult) {
        JsonProvider JSON = JsonProvider.provider();
        String key = "test" ;

        final JsonObjectBuilder mappingBuilder = JSON.createObjectBuilder();
        addIfNotNullOrEmpty(mappingBuilder, key, value);
        var result = mappingBuilder.build();
        assertThat(result.containsKey(key), equalTo(testResult));
    }

}

