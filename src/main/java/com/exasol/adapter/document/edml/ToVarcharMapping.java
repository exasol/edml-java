package com.exasol.adapter.document.edml;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import static com.exasol.adapter.document.edml.ConvertableMappingErrorBehaviour.CONVERT_OR_ABORT;
import static com.exasol.adapter.document.edml.TruncateableMappingErrorBehaviour.TRUNCATE;

/**
 * Java representation of the EDML {@code toVarcharMapping}.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data

@SuperBuilder
@SuppressWarnings("java:S1170") // sonar can't deal with Lombok
public final class ToVarcharMapping extends AbstractToVarcharColumnMapping {
    @Builder.Default
    private final ConvertableMappingErrorBehaviour nonStringBehaviour = CONVERT_OR_ABORT;
    @Builder.Default
    private final TruncateableMappingErrorBehaviour overflowBehaviour = TRUNCATE;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }
}
