
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toDateMapping}. Maps the selected document property to an Exasol {@code DATE}
 * column.
 */
public final class ToDateMapping extends AbstractToColumnMapping {
    private static final ConvertableMappingErrorBehaviour DEFAULT_NOT_DATE_BEHAVIOUR = ConvertableMappingErrorBehaviour.ABORT;
    private final ConvertableMappingErrorBehaviour notDateBehavior;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link ToDateMapping}.
     */
    public abstract static class ToDateMappingBuilder<B extends ToDateMapping.ToDateMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToDateMapping, B> {

        private boolean notDateBehaviorSet;
        private ConvertableMappingErrorBehaviour notDateBehaviorValue;

        @Override
        protected abstract B self();

        @Override
        public abstract ToDateMapping build();

        /**
         * Define the behaviour to apply in case a value is not a date.
         * 
         * @param notDateBehavior behaviour to apply in case a value is not a date
         * @return {@code this}.
         */
        public B notDateBehavior(final ConvertableMappingErrorBehaviour notDateBehavior) {
            this.notDateBehaviorValue = notDateBehavior;
            this.notDateBehaviorSet = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToDateMapping.ToDateMappingBuilder(super=" + super.toString() + ", notDateBehaviorValue="
                    + this.notDateBehaviorValue + ")";
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

    private ToDateMapping(final ToDateMapping.ToDateMappingBuilder<?> builder) {
        super(builder);
        if (builder.notDateBehaviorSet) {
            this.notDateBehavior = builder.notDateBehaviorValue;
        } else {
            this.notDateBehavior = DEFAULT_NOT_DATE_BEHAVIOUR;
        }
    }

    /**
     * Create a new builder for {@link ToDateMapping}.
     * 
     * @return a new builder for {@link ToDateMapping}
     */
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToDateMapping.ToDateMappingBuilder<?> builder() {
        return new ToDateMapping.ToDateMappingBuilderImpl();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(notDateBehavior);
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
        final ToDateMapping other = (ToDateMapping) obj;
        return notDateBehavior == other.notDateBehavior;
    }

    @Override
    public String toString() {
        return "ToDateMapping(super=" + super.toString() + ", notDateBehavior=" + this.getNotDateBehavior() + ")";
    }

    /**
     * Get the behaviour to apply in case a value is not a date.
     * 
     * @return behaviour to apply in case a value is not a date
     */
    public ConvertableMappingErrorBehaviour getNotDateBehavior() {
        return this.notDateBehavior;
    }
}
