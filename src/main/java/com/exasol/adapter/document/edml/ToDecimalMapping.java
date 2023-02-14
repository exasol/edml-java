
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toDecimalMapping}.
 */

public final class ToDecimalMapping extends AbstractToNumberMapping {
    private final int decimalPrecision;
    private final int decimalScale;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static int $default$decimalPrecision() {
        return 18;
    }

    private static int $default$decimalScale() {
        return 0;
    }

    public static abstract class ToDecimalMappingBuilder<C extends ToDecimalMapping, B extends ToDecimalMapping.ToDecimalMappingBuilder<C, B>>
            extends AbstractToNumberMapping.AbstractToNumberMappingBuilder<C, B> {

        private boolean decimalPrecision$set;

        private int decimalPrecision$value;

        private boolean decimalScale$set;

        private int decimalScale$value;

        @java.lang.Override

        protected abstract B self();

        @java.lang.Override

        public abstract C build();

        /**
         * @return {@code this}.
         */

        public B decimalPrecision(final int decimalPrecision) {
            this.decimalPrecision$value = decimalPrecision;
            decimalPrecision$set = true;
            return self();
        }

        /**
         * @return {@code this}.
         */

        public B decimalScale(final int decimalScale) {
            this.decimalScale$value = decimalScale;
            decimalScale$set = true;
            return self();
        }

        @java.lang.Override

        public java.lang.String toString() {
            return "ToDecimalMapping.ToDecimalMappingBuilder(super=" + super.toString() + ", decimalPrecision$value="
                    + this.decimalPrecision$value + ", decimalScale$value=" + this.decimalScale$value + ")";
        }
    }

    private static final class ToDecimalMappingBuilderImpl extends
            ToDecimalMapping.ToDecimalMappingBuilder<ToDecimalMapping, ToDecimalMapping.ToDecimalMappingBuilderImpl> {

        private ToDecimalMappingBuilderImpl() {
        }

        @java.lang.Override

        protected ToDecimalMapping.ToDecimalMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override

        public ToDecimalMapping build() {
            return new ToDecimalMapping(this);
        }
    }

    protected ToDecimalMapping(final ToDecimalMapping.ToDecimalMappingBuilder<?, ?> b) {
        super(b);
        if (b.decimalPrecision$set)
            this.decimalPrecision = b.decimalPrecision$value;
        else
            this.decimalPrecision = ToDecimalMapping.$default$decimalPrecision();
        if (b.decimalScale$set)
            this.decimalScale = b.decimalScale$value;
        else
            this.decimalScale = ToDecimalMapping.$default$decimalScale();
    }

    public static ToDecimalMapping.ToDecimalMappingBuilder<?, ?> builder() {
        return new ToDecimalMapping.ToDecimalMappingBuilderImpl();
    }

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToDecimalMapping))
            return false;
        final ToDecimalMapping other = (ToDecimalMapping) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        if (this.getDecimalPrecision() != other.getDecimalPrecision())
            return false;
        if (this.getDecimalScale() != other.getDecimalScale())
            return false;
        return true;
    }

    @Override
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToDecimalMapping;
    }

    @java.lang.Override

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result = result * PRIME + this.getDecimalPrecision();
        result = result * PRIME + this.getDecimalScale();
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
        return "ToDecimalMapping(super=" + super.toString() + ", decimalPrecision=" + this.getDecimalPrecision()
                + ", decimalScale=" + this.getDecimalScale() + ")";
    }

    public int getDecimalPrecision() {
        return this.decimalPrecision;
    }

    public int getDecimalScale() {
        return this.decimalScale;
    }
}
