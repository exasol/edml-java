
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toBoolMapping}. Maps the selected document property to an Exasol
 * {@code BOOLEAN}. column.
 */
public final class ToBoolMapping extends AbstractToColumnMapping {
    private static final ConvertableMappingErrorBehaviour DEFAULT_NOT_BOOLEAN_BEHAVIOUR = ConvertableMappingErrorBehaviour.ABORT;
    private final ConvertableMappingErrorBehaviour notBooleanBehavior;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link ToBoolMapping}.
     */
    public abstract static class ToBoolMappingBuilder<B extends ToBoolMapping.ToBoolMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToBoolMapping, B> {

        private ConvertableMappingErrorBehaviour notBooleanBehavior = DEFAULT_NOT_BOOLEAN_BEHAVIOUR;

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
            this.notBooleanBehavior = notBooleanBehavior;
            return self();
        }

        @Override
        public String toString() {
            return "ToBoolMapping.ToBoolMappingBuilder(super=" + super.toString() + ", notBooleanBehaviorValue="
                    + this.notBooleanBehavior + ")";
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
        this.notBooleanBehavior = builder.notBooleanBehavior;
    }

    /**
     * Create a new builder for {@link ToBoolMapping}.
     *
     * @return a new builder for {@link ToBoolMapping}
     */
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToBoolMapping.ToBoolMappingBuilder<?> builder() {
        return new ToBoolMapping.ToBoolMappingBuilderImpl();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + Objects.hash(this.notBooleanBehavior);
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
        final ToBoolMapping other = (ToBoolMapping) obj;
        return this.notBooleanBehavior == other.notBooleanBehavior;
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
