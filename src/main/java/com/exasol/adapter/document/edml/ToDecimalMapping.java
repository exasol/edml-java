// Generated by delombok at Tue Feb 14 11:27:09 CET 2023
package com.exasol.adapter.document.edml;

import lombok.Builder;
// sonar can't deal with Lombok
/**
 * Java representation of the EDML {@code toDecimalMapping}.
 */
@SuppressWarnings("java:S1170")
public final class ToDecimalMapping extends AbstractToNumberMapping {
    private final int decimalPrecision;
    private final int decimalScale;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    private static int $default$decimalPrecision() {
        return 18;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    private static int $default$decimalScale() {
        return 0;
    }


    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public static abstract class ToDecimalMappingBuilder<C extends ToDecimalMapping, B extends ToDecimalMapping.ToDecimalMappingBuilder<C, B>> extends AbstractToNumberMapping.AbstractToNumberMappingBuilder<C, B> {
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private boolean decimalPrecision$set;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private int decimalPrecision$value;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private boolean decimalScale$set;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private int decimalScale$value;

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        protected abstract B self();

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public abstract C build();

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public B decimalPrecision(final int decimalPrecision) {
            this.decimalPrecision$value = decimalPrecision;
            decimalPrecision$set = true;
            return self();
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public B decimalScale(final int decimalScale) {
            this.decimalScale$value = decimalScale;
            decimalScale$set = true;
            return self();
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public java.lang.String toString() {
            return "ToDecimalMapping.ToDecimalMappingBuilder(super=" + super.toString() + ", decimalPrecision$value=" + this.decimalPrecision$value + ", decimalScale$value=" + this.decimalScale$value + ")";
        }
    }


    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    private static final class ToDecimalMappingBuilderImpl extends ToDecimalMapping.ToDecimalMappingBuilder<ToDecimalMapping, ToDecimalMapping.ToDecimalMappingBuilderImpl> {
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private ToDecimalMappingBuilderImpl() {
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        protected ToDecimalMapping.ToDecimalMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public ToDecimalMapping build() {
            return new ToDecimalMapping(this);
        }
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    protected ToDecimalMapping(final ToDecimalMapping.ToDecimalMappingBuilder<?, ?> b) {
        super(b);
        if (b.decimalPrecision$set) this.decimalPrecision = b.decimalPrecision$value;
         else this.decimalPrecision = ToDecimalMapping.$default$decimalPrecision();
        if (b.decimalScale$set) this.decimalScale = b.decimalScale$value;
         else this.decimalScale = ToDecimalMapping.$default$decimalScale();
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public static ToDecimalMapping.ToDecimalMappingBuilder<?, ?> builder() {
        return new ToDecimalMapping.ToDecimalMappingBuilderImpl();
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ToDecimalMapping)) return false;
        final ToDecimalMapping other = (ToDecimalMapping) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (!super.equals(o)) return false;
        if (this.getDecimalPrecision() != other.getDecimalPrecision()) return false;
        if (this.getDecimalScale() != other.getDecimalScale()) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToDecimalMapping;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result = result * PRIME + this.getDecimalPrecision();
        result = result * PRIME + this.getDecimalScale();
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public java.lang.String toString() {
        return "ToDecimalMapping(super=" + super.toString() + ", decimalPrecision=" + this.getDecimalPrecision() + ", decimalScale=" + this.getDecimalScale() + ")";
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public int getDecimalPrecision() {
        return this.decimalPrecision;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public int getDecimalScale() {
        return this.decimalScale;
    }
}
