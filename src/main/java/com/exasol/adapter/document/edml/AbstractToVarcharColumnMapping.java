
package com.exasol.adapter.document.edml;

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

        private boolean varcharColumnSizeSet;
        private int varcharColumnSizeValue;

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
            this.varcharColumnSizeSet = true;
            return self();
        }

        @Override
        public String toString() {
            return "AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder(super=" + super.toString()
                    + ", varcharColumnSize$value=" + this.varcharColumnSizeValue + ")";
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
        if (builder.varcharColumnSizeSet) {
            this.varcharColumnSize = builder.varcharColumnSizeValue;
        } else {
            this.varcharColumnSize = DEFAULT_VARCHAR_COLUMN_SIZE;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractToVarcharColumnMapping)) {
            return false;
        }
        final AbstractToVarcharColumnMapping other = (AbstractToVarcharColumnMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return this.getVarcharColumnSize() == other.getVarcharColumnSize();
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof AbstractToVarcharColumnMapping;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result = (result * PRIME) + this.getVarcharColumnSize();
        return result;
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
