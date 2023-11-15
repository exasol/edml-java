package com.exasol.adapter.document.edml.deserializer;

import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.jsonObjectToString;
import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.StringReader;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.exasol.adapter.document.edml.*;
import com.exasol.adapter.document.edml.serializer.EdmlSerializer;

import jakarta.json.Json;

class EdmlDeserializerTest {
    @Test
    void testDeserializationOfMultipleFields() {
        final EdmlDefinition expected = EdmlDefinition.builder().source("test").destinationTable("test")
                .mapping(Fields.builder()//
                        .mapField("text", ToVarcharMapping.builder().build())
                        .mapField("number", ToDecimalMapping.builder().build())
                        .mapField("object", ToJsonMapping.builder().build()).build())
                .build();
        assertSerializeDeserializeLoop(expected);
    }

    @Test
    void testDeserializationFailsForEmptyMapping() {
        final String serialized = List.of("{", //
                "  '$schema': '../../main/resources/schemas/edml-1.2.0.json',", //
                "  'source': 'MY_BOOKS',", //
                "  'destinationTable': 'BOOKS',", //
                "  'description': 'Maps MY_BOOKS to BOOKS',", //
                "  'addSourceReferenceColumn': true,", //
                "  'mapping': {}", //
                "}" //
        ).stream().collect(joining("\n")).replace('\'', '"');
        final EdmlDeserializer deserializer = new EdmlDeserializer();
        final ExasolDocumentMappingLanguageException exception = assertThrows(
                ExasolDocumentMappingLanguageException.class, () -> deserializer.deserialize(serialized));
        assertThat(exception.getMessage(), equalTo(
                "F-EDML-53: Syntax validation error: [7,15][/mapping] The object must have at least 1 property(ies), but actual number is 0."));
    }

    @Test
    void testDeserializationWithoutMapping() {
        final EdmlDefinition expected = EdmlDefinition.builder().source("testSource").destinationTable("testTable")
                .build();
        assertSerializeDeserializeLoop(expected);
    }

    private void assertSerializeDeserializeLoop(final EdmlDefinition expected) {
        final EdmlDefinition deserialized = new EdmlDeserializer()
                .deserialize(new EdmlSerializer().serialize(expected));
        assertThat(deserialized, equalTo(expected));
    }

    @Test
    void testDeserializeToVarcharMapping() {
        final ToVarcharMapping mapping = ToVarcharMapping.builder()
                .nonStringBehaviour(ConvertableMappingErrorBehaviour.NULL)
                .overflowBehaviour(TruncateableMappingErrorBehaviour.NULL).build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    @Test
    void testDeserializeToBoolMapping() {
        final var mapping = ToBoolMapping.builder().notBooleanBehavior(ConvertableMappingErrorBehaviour.NULL).build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    @Test
    void testDeserializeToDateMapping() {
        final var mapping = ToDateMapping.builder().notDateBehavior(ConvertableMappingErrorBehaviour.NULL).build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    @Test
    void testDeserializeToDecimalMapping() {
        final var mapping = ToDecimalMapping.builder().notNumericBehaviour(ConvertableMappingErrorBehaviour.NULL)
                .decimalPrecision(11).decimalScale(1).required(true).build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    @Test
    void testDeserializeToDoubleMapping() {
        final var mapping = ToDoubleMapping.builder().build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    @Test
    void testDeserializeToJsonMapping() {
        final var mapping = ToJsonMapping.builder().overflowBehaviour(MappingErrorBehaviour.NULL)
                .destinationName("test").key(KeyType.LOCAL).description("my description").varcharColumnSize(123)
                .build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    @Test
    void testDeserializeToTableMapping() {
        final var mapping = ToTableMapping.builder().description("my description").destinationTable("MY_NESTED")
                .mapping(Fields.builder().mapField("test", ToVarcharMapping.builder().build()).build()).build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    @CsvSource({ "NULL, true", //
            "CONVERT_OR_ABORT, true", //
            "NULL, false", //
            "CONVERT_OR_ABORT, false", })
    @ParameterizedTest
    void testDeserializeToTimestampMapping(final ConvertableMappingErrorBehaviour behaviour,
            final boolean localTimezone) {
        final var mapping = ToTimestampMapping.builder().notTimestampBehavior(behaviour)
                .useTimestampWithLocalTimezoneType(localTimezone).build();
        assertSerializeDeserializeLoop(getEdmlDefinitionForMapping(mapping));
    }

    private EdmlDefinition getEdmlDefinitionForMapping(final MappingDefinition mapping) {
        return EdmlDefinition.builder().source("test").destinationTable("test").mapping(Fields.builder()//
                .mapField("myProperty", mapping).build()).build();
    }

    @Test
    void testHelperJsonObjectToString() {
        final var jsonInput = "{\"additionalConfiguration\":{\"csv-headers\":true}}";
        final var jsonReader = Json.createReader(new StringReader(jsonInput));
        final var jsonObject = jsonReader.readObject();
        final var additionalConfigurationObject = jsonObject.getJsonObject("additionalConfiguration");
        final var desiredOutput = "{\"csv-headers\":true}";
        final var producedOutput = jsonObjectToString(additionalConfigurationObject);
        assertThat(desiredOutput, equalTo(producedOutput));
    }
}
