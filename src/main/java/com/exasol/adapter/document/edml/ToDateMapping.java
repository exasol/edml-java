
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toDateMapping}.
 */

public final class ToDateMapping extends AbstractToColumnMapping {
    private final ConvertableMappingErrorBehaviour notDateBehavior;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static ConvertableMappingErrorBehaviour $default$notDateBehavior() {
        return ConvertableMappingErrorBehaviour.ABORT;
    }

    public static abstract class ToDateMappingBuilder<B extends ToDateMapping.ToDateMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToDateMapping, B> {

        private boolean notDateBehavior$set;

        private ConvertableMappingErrorBehaviour notDateBehavior$value;

        @java.lang.Override

        protected abstract B self();

        @java.lang.Override

        public abstract ToDateMapping build();

        /**
         * @return {@code this}.
         */

        public B notDateBehavior(final ConvertableMappingErrorBehaviour notDateBehavior) {
            this.notDateBehavior$value = notDateBehavior;
            notDateBehavior$set = true;
            return self();
        }

        @java.lang.Override

        public java.lang.String toString() {
            return "ToDateMapping.ToDateMappingBuilder(super=" + super.toString() + ", notDateBehavior$value="
                    + this.notDateBehavior$value + ")";
        }
    }

    private static final class ToDateMappingBuilderImpl
            extends ToDateMapping.ToDateMappingBuilder<ToDateMapping.ToDateMappingBuilderImpl> {

        private ToDateMappingBuilderImpl() {
        }

        @java.lang.Override

        protected ToDateMapping.ToDateMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override

        public ToDateMapping build() {
            return new ToDateMapping(this);
        }
    }

    protected ToDateMapping(final ToDateMapping.ToDateMappingBuilder<?> b) {
        super(b);
        if (b.notDateBehavior$set)
            this.notDateBehavior = b.notDateBehavior$value;
        else
            this.notDateBehavior = ToDateMapping.$default$notDateBehavior();
    }

    public static ToDateMapping.ToDateMappingBuilder<?> builder() {
        return new ToDateMapping.ToDateMappingBuilderImpl();
    }

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToDateMapping))
            return false;
        final ToDateMapping other = (ToDateMapping) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        final java.lang.Object this$notDateBehavior = this.getNotDateBehavior();
        final java.lang.Object other$notDateBehavior = other.getNotDateBehavior();
        if (this$notDateBehavior == null ? other$notDateBehavior != null
                : !this$notDateBehavior.equals(other$notDateBehavior))
            return false;
        return true;
    }

    @Override
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToDateMapping;
    }

    @java.lang.Override

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final java.lang.Object $notDateBehavior = this.getNotDateBehavior();
        result = result * PRIME + ($notDateBehavior == null ? 43 : $notDateBehavior.hashCode());
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
        return "ToDateMapping(super=" + super.toString() + ", notDateBehavior=" + this.getNotDateBehavior() + ")";
    }

    public ConvertableMappingErrorBehaviour getNotDateBehavior() {
        return this.notDateBehavior;
    }
}
