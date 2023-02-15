
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Abstract base for EDML mappings that map to an Exasol {@code VARCHAR} column.
 */

public abstract class AbstractToVarcharColumnMapping extends AbstractToColumnMapping {
    private static final int DEFAULT_VARCHAR_COLUMN_SIZE = 254;
    private final int varcharColumnSize;

    /**
     * Builder for {@link AbstractToVarcharColumnMapping}.
     */
    public abstract static class AbstractToVarcharColumnMappingBuilder<C extends AbstractToVarcharColumnMapping, B extends AbstractToVarcharColumnMappingBuilder<C, B>>
            extends AbstractToColumnMappingBuilder<C, B> {

        private int varcharColumnSizeValue = DEFAULT_VARCHAR_COLUMN_SIZE;

        @Override
        protected abstract B self();

        @Override
        public abstract C build();

        /**
         * @param varcharColumnSize size for {@code VARCHAR} columns
         * @return {@code this}.
         */
        public B varcharColumnSize(final int varcharColumnSize) {
            this.varcharColumnSizeValue = varcharColumnSize;
            return self();
        }

        @Override
        public String toString() {
            return "AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder(super=" + super.toString()
                    + ", varcharColumnSizeValue=" + this.varcharColumnSizeValue + ")";
        }
    }

    /**
     * Create a new {@link AbstractToVarcharColumnMapping}.
     *
     * @param builder the builder
     */
    protected AbstractToVarcharColumnMapping(
            final AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder<?, ?> builder) {
        super(builder);
        this.varcharColumnSize = builder.varcharColumnSizeValue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + Objects.hash(this.varcharColumnSize);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractToVarcharColumnMapping other = (AbstractToVarcharColumnMapping) obj;
        return this.varcharColumnSize == other.varcharColumnSize;
    }

    @Override
    public String toString() {
        return "AbstractToVarcharColumnMapping(super=" + super.toString() + ", varcharColumnSize="
                + this.getVarcharColumnSize() + ")";
    }

    /**
     * Size of the varchar column.
     *
     * @return size of the varchar column
     */
    public int getVarcharColumnSize() {
        return this.varcharColumnSize;
    }
}
