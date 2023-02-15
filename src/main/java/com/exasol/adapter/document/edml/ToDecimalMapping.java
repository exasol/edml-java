
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toDecimalMapping}. Maps the selected document property to an Exasol
 * {@code DECIMAL} column.
 */
public final class ToDecimalMapping extends AbstractToNumberMapping {
    private static final int DEFAULT_DECIMAL_PRECISION = 18;
    private static final int DEFAULT_DECIMAL_SCALE = 0;
    private final int decimalPrecision;
    private final int decimalScale;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link ToDecimalMapping}.
     */
    public abstract static class ToDecimalMappingBuilder<B extends ToDecimalMapping.ToDecimalMappingBuilder<B>>
            extends AbstractToNumberMapping.AbstractToNumberMappingBuilder<ToDecimalMapping, B> {

        private boolean decimalPrecisionSet;
        private int decimalPrecisionValue;
        private boolean decimalScaleSet;
        private int decimalScaleValue;

        @Override
        protected abstract B self();

        @Override
        public abstract ToDecimalMapping build();

        /**
         * Set the precision of the Exasol {@code DECIMAL} type. Default: 18
         * <p>
         * See the <a href="https://docs.exasol.com/sql_references/data_types/datatypedetails.htm">documentation about
         * data types</a> for details.
         * 
         * @param decimalPrecision precision
         * @return {@code this}.
         */
        public B decimalPrecision(final int decimalPrecision) {
            this.decimalPrecisionValue = decimalPrecision;
            this.decimalPrecisionSet = true;
            return self();
        }

        /**
         * Set the scale of the Exasol {@code DECIMAL} type. Default: 0
         * <p>
         * See the <a href="https://docs.exasol.com/sql_references/data_types/datatypedetails.htm">documentation about
         * data types</a> for details.
         * 
         * @param decimalScale scale
         * @return {@code this}.
         */
        public B decimalScale(final int decimalScale) {
            this.decimalScaleValue = decimalScale;
            this.decimalScaleSet = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToDecimalMapping.ToDecimalMappingBuilder(super=" + super.toString() + ", decimalPrecisionValue="
                    + this.decimalPrecisionValue + ", decimalScaleValue=" + this.decimalScaleValue + ")";
        }
    }

    private static final class ToDecimalMappingBuilderImpl
            extends ToDecimalMapping.ToDecimalMappingBuilder<ToDecimalMapping.ToDecimalMappingBuilderImpl> {

        private ToDecimalMappingBuilderImpl() {
        }

        @Override
        protected ToDecimalMapping.ToDecimalMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToDecimalMapping build() {
            return new ToDecimalMapping(this);
        }
    }

    private ToDecimalMapping(final ToDecimalMapping.ToDecimalMappingBuilder<?> builder) {
        super(builder);
        if (builder.decimalPrecisionSet) {
            this.decimalPrecision = builder.decimalPrecisionValue;
        } else {
            this.decimalPrecision = DEFAULT_DECIMAL_PRECISION;
        }
        if (builder.decimalScaleSet) {
            this.decimalScale = builder.decimalScaleValue;
        } else {
            this.decimalScale = DEFAULT_DECIMAL_SCALE;
        }
    }

    /**
     * Create a new builder for {@link ToDecimalMapping}.
     * 
     * @return a new builder for {@link ToDecimalMapping}
     */
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToDecimalMapping.ToDecimalMappingBuilder<?> builder() {
        return new ToDecimalMapping.ToDecimalMappingBuilderImpl();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(decimalPrecision, decimalScale);
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
        final ToDecimalMapping other = (ToDecimalMapping) obj;
        return decimalPrecision == other.decimalPrecision && decimalScale == other.decimalScale;
    }

    @Override
    public String toString() {
        return "ToDecimalMapping(super=" + super.toString() + ", decimalPrecision=" + this.getDecimalPrecision()
                + ", decimalScale=" + this.getDecimalScale() + ")";
    }

    /**
     * Get the precision of the Exasol {@code DECIMAL} type. Default: 18
     * <p>
     * See the <a href="https://docs.exasol.com/sql_references/data_types/datatypedetails.htm">documentation about data
     * types</a> for details.
     * 
     * @return the precision
     */
    public int getDecimalPrecision() {
        return this.decimalPrecision;
    }

    /**
     * Get the scale of the Exasol {@code DECIMAL} type. Default: 0
     * <p>
     * See the <a href="https://docs.exasol.com/sql_references/data_types/datatypedetails.htm">documentation about data
     * types</a> for details.
     * 
     * @return decimal scale
     */
    public int getDecimalScale() {
        return this.decimalScale;
    }
}
