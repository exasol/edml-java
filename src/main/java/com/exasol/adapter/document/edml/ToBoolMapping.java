
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toBoolMapping}. Maps the selected document property to an Exasol
 * {@code BOOLEAN}. column.
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

    /**
     * Builder for {@link ToBoolMapping}.
     */
    public static abstract class ToBoolMappingBuilder<B extends ToBoolMapping.ToBoolMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToBoolMapping, B> {

        private boolean notBooleanBehavior$set;

        private ConvertableMappingErrorBehaviour notBooleanBehavior$value;

        @Override
        protected abstract B self();

        @Override
        public abstract ToBoolMapping build();

        /**
         * Define the behaviour to apply in case a value is not a boolean.
         * 
         * @param notBooleanBehavior the behaviour to apply in case a value is not a boolean
         * @return {@code this}.
         */
        public B notBooleanBehavior(final ConvertableMappingErrorBehaviour notBooleanBehavior) {
            this.notBooleanBehavior$value = notBooleanBehavior;
            this.notBooleanBehavior$set = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToBoolMapping.ToBoolMappingBuilder(super=" + super.toString() + ", notBooleanBehavior$value="
                    + this.notBooleanBehavior$value + ")";
        }
    }

    private static final class ToBoolMappingBuilderImpl
            extends ToBoolMapping.ToBoolMappingBuilder<ToBoolMapping.ToBoolMappingBuilderImpl> {

        private ToBoolMappingBuilderImpl() {
        }

        @Override
        protected ToBoolMapping.ToBoolMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToBoolMapping build() {
            return new ToBoolMapping(this);
        }
    }

    private ToBoolMapping(final ToBoolMapping.ToBoolMappingBuilder<?> builder) {
        super(builder);
        if (builder.notBooleanBehavior$set) {
            this.notBooleanBehavior = builder.notBooleanBehavior$value;
        } else {
            this.notBooleanBehavior = ToBoolMapping.$default$notBooleanBehavior();
        }
    }

    /**
     * Create a new builder for {@link ToBoolMapping}.
     * 
     * @return a new builder for {@link ToBoolMapping}
     */
    public static ToBoolMapping.ToBoolMappingBuilder<?> builder() {
        return new ToBoolMapping.ToBoolMappingBuilderImpl();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToBoolMapping)) {
            return false;
        }
        final ToBoolMapping other = (ToBoolMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Object this$notBooleanBehavior = this.getNotBooleanBehavior();
        final Object other$notBooleanBehavior = other.getNotBooleanBehavior();
        if (this$notBooleanBehavior == null ? other$notBooleanBehavior != null
                : !this$notBooleanBehavior.equals(other$notBooleanBehavior)) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof ToBoolMapping;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $notBooleanBehavior = this.getNotBooleanBehavior();
        result = (result * PRIME) + ($notBooleanBehavior == null ? 43 : $notBooleanBehavior.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ToBoolMapping(super=" + super.toString() + ", notBooleanBehavior=" + this.getNotBooleanBehavior() + ")";
    }

    /**
     * Get the behaviour to apply in case a value is not a boolean.
     * 
     * @return behaviour to apply in case a value is not a boolean
     */
    public ConvertableMappingErrorBehaviour getNotBooleanBehavior() {
        return this.notBooleanBehavior;
    }
}
