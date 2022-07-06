package com.exasol.adapter.document.edml.deserializer;

import com.exasol.adapter.document.edml.ConvertableMappingErrorBehaviour;
import com.exasol.adapter.document.edml.MappingDefinition;
import com.exasol.adapter.document.edml.ToVarcharMapping;
import com.exasol.adapter.document.edml.TruncateableMappingErrorBehaviour;
import jakarta.json.JsonObject;

import static com.exasol.adapter.document.edml.EdmlKeys.KEY_NON_STRING_BEHAVIOUR;
import static com.exasol.adapter.document.edml.EdmlKeys.KEY_OVERFLOW_BEHAVIOUR;
import static com.exasol.adapter.document.edml.deserializer.DeserializationHelper.readEnum;
import static com.exasol.adapter.document.edml.deserializer.MappingDeserializer.deserializeToVarcharColumnMapping;

/**
 * Deserializer for {@link ToVarcharMapping}.
 */
class ToVarcharMappingDeserializer implements MappingDefinitionDeserializer {
    @Override
    public MappingDefinition deserialize(final JsonObject json) {
        final ToVarcharMapping.ToVarcharMappingBuilder<?, ?> builder = ToVarcharMapping.builder();
        deserializeToVarcharColumnMapping(json, builder);
        readEnum(json, KEY_NON_STRING_BEHAVIOUR, ConvertableMappingErrorBehaviour.class)
                .ifPresent(builder::nonStringBehaviour);
        readEnum(json, KEY_OVERFLOW_BEHAVIOUR, TruncateableMappingErrorBehaviour.class)
                .ifPresent(builder::overflowBehaviour);
        return builder.build();
    }

    @Override
    public Class<?> ofClass() {
        return ToVarcharMapping.class;
    }
}
