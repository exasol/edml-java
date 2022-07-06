package com.exasol.adapter.document.edml.deserializer;

import com.exasol.adapter.document.edml.ConvertableMappingErrorBehaviour;
import com.exasol.adapter.document.edml.EdmlKeys;
import com.exasol.adapter.document.edml.MappingDefinition;
import com.exasol.adapter.document.edml.ToDateMapping;
import jakarta.json.JsonObject;

import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readEnum;
import static com.exasol.adapter.document.edml.deserializer.MappingDeserializer.deserializeToColumnMapping;

/**
 * Deserializer for {@link ToDateMapping}.
 */
class ToDateMappingDeserializer implements MappingDefinitionDeserializer {
    @Override
    public MappingDefinition deserialize(final JsonObject json) {
        final ToDateMapping.ToDateMappingBuilder<?, ?> builder = ToDateMapping.builder();
        deserializeToColumnMapping(json, builder);
        readEnum(json, EdmlKeys.KEY_NOT_DATE_BEHAVIOR, ConvertableMappingErrorBehaviour.class)
                .ifPresent(builder::notDateBehavior);
        return builder.build();
    }

    @Override
    public Class<?> ofClass() {
        return ToDateMapping.class;
    }
}
