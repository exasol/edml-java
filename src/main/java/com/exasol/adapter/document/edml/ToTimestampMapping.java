
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toTimestampMapping}. Maps the selected document property to an Exasol
 * {@code TIMESTAMP} or {@code TIMESTAMP WITH LOCAL TIMEZONE} column.
 */
public final class ToTimestampMapping extends AbstractToColumnMapping {
    private static final ConvertableMappingErrorBehaviour DEFAULT_NOT_TIMESTAMP_BEHAVIOUR = ConvertableMappingErrorBehaviour.ABORT;

    private final ConvertableMappingErrorBehaviour notTimestampBehavior;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link ToTimestampMapping}.
     */
    public abstract static class ToTimestampMappingBuilder<B extends ToTimestampMapping.ToTimestampMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToTimestampMapping, B> {

        private ConvertableMappingErrorBehaviour notTimestampBehavior = DEFAULT_NOT_TIMESTAMP_BEHAVIOUR;

        @Override
        protected abstract B self();

        @Override
        public abstract ToTimestampMapping build();

        /**
         * Define the behaviour to apply in case a value is not a timestamp.
         *
         * @param notTimestampBehavior behaviour to apply in case a value is not a timestamp
         * @return {@code this}.
         */
        public B notTimestampBehavior(final ConvertableMappingErrorBehaviour notTimestampBehavior) {
            this.notTimestampBehavior = notTimestampBehavior;
            return self();
        }

        @Override
        public String toString() {
            return "ToTimestampMapping.ToTimestampMappingBuilder(super=" + super.toString()
                    + ", notTimestampBehaviorValue=" + this.notTimestampBehavior + ")";
        }
    }

    private static final class ToTimestampMappingBuilderImpl
            extends ToTimestampMapping.ToTimestampMappingBuilder<ToTimestampMapping.ToTimestampMappingBuilderImpl> {

        private ToTimestampMappingBuilderImpl() {
        }

        @Override
        protected ToTimestampMapping.ToTimestampMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToTimestampMapping build() {
            return new ToTimestampMapping(this);
        }
    }

    private ToTimestampMapping(final ToTimestampMapping.ToTimestampMappingBuilder<?> builder) {
        super(builder);
        this.notTimestampBehavior = builder.notTimestampBehavior;
    }

    /**
     * Create a new builder for {@link ToTimestampMapping}.
     *
     * @return a new builder for {@link ToTimestampMapping}
     */
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToTimestampMapping.ToTimestampMappingBuilder<?> builder() {
        return new ToTimestampMapping.ToTimestampMappingBuilderImpl();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(notTimestampBehavior);
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
        final ToTimestampMapping other = (ToTimestampMapping) obj;
        return notTimestampBehavior == other.notTimestampBehavior;
    }

    @Override
    public String toString() {
        return "ToTimestampMapping(super=" + super.toString() + ", notTimestampBehavior="
                + this.getNotTimestampBehavior() + ")";
    }

    /**
     * Get the behaviour to apply in case a value is not a timestamp.
     *
     * @return behaviour to apply in case a value is not a timestamp
     */
    public ConvertableMappingErrorBehaviour getNotTimestampBehavior() {
        return this.notTimestampBehavior;
    }
}
