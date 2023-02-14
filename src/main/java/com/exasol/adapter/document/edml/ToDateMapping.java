
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

        @Override
        protected abstract B self();

        @Override
        public abstract ToDateMapping build();

        /**
         * @param notDateBehavior the behaviour in case the value is not a date
         * @return {@code this}.
         */
        public B notDateBehavior(final ConvertableMappingErrorBehaviour notDateBehavior) {
            this.notDateBehavior$value = notDateBehavior;
            this.notDateBehavior$set = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToDateMapping.ToDateMappingBuilder(super=" + super.toString() + ", notDateBehavior$value="
                    + this.notDateBehavior$value + ")";
        }
    }

    private static final class ToDateMappingBuilderImpl
            extends ToDateMapping.ToDateMappingBuilder<ToDateMapping.ToDateMappingBuilderImpl> {

        private ToDateMappingBuilderImpl() {
        }

        @Override
        protected ToDateMapping.ToDateMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToDateMapping build() {
            return new ToDateMapping(this);
        }
    }

    protected ToDateMapping(final ToDateMapping.ToDateMappingBuilder<?> b) {
        super(b);
        if (b.notDateBehavior$set) {
            this.notDateBehavior = b.notDateBehavior$value;
        } else {
            this.notDateBehavior = ToDateMapping.$default$notDateBehavior();
        }
    }

    public static ToDateMapping.ToDateMappingBuilder<?> builder() {
        return new ToDateMapping.ToDateMappingBuilderImpl();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToDateMapping)) {
            return false;
        }
        final ToDateMapping other = (ToDateMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Object this$notDateBehavior = this.getNotDateBehavior();
        final Object other$notDateBehavior = other.getNotDateBehavior();
        if (this$notDateBehavior == null ? other$notDateBehavior != null
                : !this$notDateBehavior.equals(other$notDateBehavior)) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof ToDateMapping;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $notDateBehavior = this.getNotDateBehavior();
        result = (result * PRIME) + ($notDateBehavior == null ? 43 : $notDateBehavior.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ToDateMapping(super=" + super.toString() + ", notDateBehavior=" + this.getNotDateBehavior() + ")";
    }

    public ConvertableMappingErrorBehaviour getNotDateBehavior() {
        return this.notDateBehavior;
    }
}
