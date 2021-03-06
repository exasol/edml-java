package com.exasol.adapter.document.edml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Java representation of the EDML {@code toDoubleMapping}.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@SuperBuilder
@Data
public final class ToDoubleMapping extends AbstractToNumberMapping {

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }
}
