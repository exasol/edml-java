package com.exasol.adapter.document.edml;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Java representation of the EDML {@code toDateMapping}.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@SuperBuilder
@Data
@SuppressWarnings("java:S1170") // sonar can't deal with Lombok
public final class ToDateMapping extends AbstractToColumnMapping {

    @Builder.Default
    private final ConvertableMappingErrorBehaviour notDateBehavior = ConvertableMappingErrorBehaviour.ABORT;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }
}
