package com.exasol.adapter.document.edml.deserializer;

import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readEnum;
import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readOptionalInt;
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
        readOptionalInt(json, EdmlKeys.KEY_SECONDS_PRECISION).ifPresent(builder::secondsPrecision);
        return builder.build();
    }

    @Override
    public Class<?> ofClass() {
        return ToTimestampMapping.class;
    }
}
