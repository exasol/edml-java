package com.exasol.adapter.document.edml.deserializer;

import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readEnum;
import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readOptionalBoolean;
import static com.exasol.adapter.document.edml.deserializer.MappingDeserializer.deserializeToColumnMapping;

import com.exasol.adapter.document.edml.*;

import jakarta.json.JsonObject;

/**
 * Deserializer for {@link ToTimestampMapping}.
 */
class ToTimestampMappingDeserializer implements MappingDefinitionDeserializer {
    @Override
    public MappingDefinition deserialize(final JsonObject json) {
        final ToTimestampMapping.ToTimestampMappingBuilder<?> builder = ToTimestampMapping.builder();
        deserializeToColumnMapping(json, builder);
        readEnum(json, EdmlKeys.KEY_NOT_TIMESTAMP_BEHAVIOR, ConvertableMappingErrorBehaviour.class)
                .ifPresent(builder::notTimestampBehavior);
        readOptionalBoolean(json, EdmlKeys.KEY_USE_TIMESTAMP_WITH_LOCAL_TIMEZONE_TYPE)
                .ifPresent(builder::useTimestampWithLocalTimezoneType);
        return builder.build();
    }

    @Override
    public Class<?> ofClass() {
        return ToTimestampMapping.class;
    }
}
