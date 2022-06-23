package com.exasol.adapter.document.edml.deserializer;

import static com.exasol.adapter.document.edml.EdmlKeys.*;
import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readOptionalBoolean;
import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readRequiredString;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Optional;

import com.exasol.adapter.document.edml.EdmlDefinition;
import com.exasol.adapter.document.edml.validator.EdmlSchemaValidator;
import com.exasol.errorreporting.ExaError;

import jakarta.json.*;

/**
 * This class deserializes an {@link EdmlDefinition} from JSON.
 */
public class EdmlDeserializer {
    /**
     * Deserialize an {@link EdmlDefinition} from JSON.
     * 
     * @param edmlDefinitionAsJson serialized JSON
     * @return deserialized {@link EdmlDefinition}
     */
    public EdmlDefinition deserialize(final String edmlDefinitionAsJson) {
        new EdmlSchemaValidator().validate(edmlDefinitionAsJson);
        final JsonObject json = readJson(edmlDefinitionAsJson);
        final EdmlDefinition.EdmlDefinitionBuilder builder = EdmlDefinition.builder()
                .source(readRequiredString(json, KEY_SOURCE))
                .destinationTable(readRequiredString(json, KEY_DESTINATION_TABLE));
        Optional.ofNullable(json.getString(KEY_DESCRIPTION, null)).ifPresent(builder::description);
        readOptionalBoolean(json, KEY_ADD_SOURCE_REFERENCE_COLUMN).ifPresent(builder::addSourceReferenceColumn);
        //we serialize the json object again, we can then just deserialise it again to a jsonobject later and read it out where we need it
        JsonObject additionalConfiguration  = json.getJsonObject(KEY_ADDITIONAL_CONFIGURATION); // will return null if not found
        Optional.ofNullable(additionalConfiguration).ifPresent(addConfig -> builder.additionalConfiguration(jsonObjectToString(addConfig)));
        final JsonObject mapping = json.getJsonObject(KEY_MAPPING);
        builder.mapping(new MappingDeserializer().deserializeMapping(mapping));
        return builder.build();
    }
    private String jsonObjectToString(JsonObject jsonObject){
        var stringWriter = new StringWriter();
        try (final JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(jsonObject);
        }
        return stringWriter.toString();
    }
    private JsonObject readJson(final String edmlDefinitionAsJson) {
        try (final StringReader reader = new StringReader(edmlDefinitionAsJson)) {
            try (final JsonReader jsonReader = Json.createReader(reader)) {
                return jsonReader.readObject();
            } catch (final JsonException exception) {
                throw new IllegalStateException(ExaError.messageBuilder("E-EDML-85")
                        .message("Failed to deserialize EDML definition.").toString(), exception);
            }
        }
    }
}
