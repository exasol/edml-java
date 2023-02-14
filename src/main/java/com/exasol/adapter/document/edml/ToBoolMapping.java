
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toBoolMapping}.
 */

public final class ToBoolMapping extends AbstractToColumnMapping {
    private final ConvertableMappingErrorBehaviour notBooleanBehavior;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static ConvertableMappingErrorBehaviour $default$notBooleanBehavior() {
        return ConvertableMappingErrorBehaviour.ABORT;
    }

    public static abstract class ToBoolMappingBuilder<B extends ToBoolMapping.ToBoolMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToBoolMapping, B> {

        private boolean notBooleanBehavior$set;

        private ConvertableMappingErrorBehaviour notBooleanBehavior$value;

        @java.lang.Override
        protected abstract B self();

        @java.lang.Override
        public abstract ToBoolMapping build();

        /**
         * @return {@code this}.
         */

        public B notBooleanBehavior(final ConvertableMappingErrorBehaviour notBooleanBehavior) {
            this.notBooleanBehavior$value = notBooleanBehavior;
            notBooleanBehavior$set = true;
            return self();
        }

        @java.lang.Override

        public java.lang.String toString() {
            return "ToBoolMapping.ToBoolMappingBuilder(super=" + super.toString() + ", notBooleanBehavior$value="
                    + this.notBooleanBehavior$value + ")";
        }
    }

    private static final class ToBoolMappingBuilderImpl
            extends ToBoolMapping.ToBoolMappingBuilder<ToBoolMapping.ToBoolMappingBuilderImpl> {

        private ToBoolMappingBuilderImpl() {
        }

        @java.lang.Override

        protected ToBoolMapping.ToBoolMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override

        public ToBoolMapping build() {
            return new ToBoolMapping(this);
        }
    }

    protected ToBoolMapping(final ToBoolMapping.ToBoolMappingBuilder<?> b) {
        super(b);
        if (b.notBooleanBehavior$set)
            this.notBooleanBehavior = b.notBooleanBehavior$value;
        else
            this.notBooleanBehavior = ToBoolMapping.$default$notBooleanBehavior();
    }

    public static ToBoolMapping.ToBoolMappingBuilder<?> builder() {
        return new ToBoolMapping.ToBoolMappingBuilderImpl();
    }

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToBoolMapping))
            return false;
        final ToBoolMapping other = (ToBoolMapping) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        final java.lang.Object this$notBooleanBehavior = this.getNotBooleanBehavior();
        final java.lang.Object other$notBooleanBehavior = other.getNotBooleanBehavior();
        if (this$notBooleanBehavior == null ? other$notBooleanBehavior != null
                : !this$notBooleanBehavior.equals(other$notBooleanBehavior))
            return false;
        return true;
    }

    @Override
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToBoolMapping;
    }

    @java.lang.Override

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final java.lang.Object $notBooleanBehavior = this.getNotBooleanBehavior();
        result = result * PRIME + ($notBooleanBehavior == null ? 43 : $notBooleanBehavior.hashCode());
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
        return "ToBoolMapping(super=" + super.toString() + ", notBooleanBehavior=" + this.getNotBooleanBehavior() + ")";
    }

    public ConvertableMappingErrorBehaviour getNotBooleanBehavior() {
        return this.notBooleanBehavior;
    }
}
