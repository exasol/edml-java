
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toTimestampMapping}. Maps the selected document property to an Exasol
 * {@code TIMESTAMP} or {@code TIMESTAMP WITH LOCAL TIMEZONE} column.
 */
public final class ToTimestampMapping extends AbstractToColumnMapping {
    private static final boolean DEFAULT_USE_TIMESTAMP_WITH_LOCAL_TIMEZONE_TYPE = true;
    private static final ConvertableMappingErrorBehaviour DEFAULT_NOT_TIMESTAMP_BEHAVIOUR = ConvertableMappingErrorBehaviour.ABORT;

    private final ConvertableMappingErrorBehaviour notTimestampBehavior;

    private final boolean useTimestampWithLocalTimezoneType;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link ToTimestampMapping}.
     */
    public abstract static class ToTimestampMappingBuilder<B extends ToTimestampMapping.ToTimestampMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToTimestampMapping, B> {

        private boolean notTimestampBehaviorSet;
        private ConvertableMappingErrorBehaviour notTimestampBehaviorValue;
        private boolean useTimestampWithLocalTimezoneTypeSet;
        private boolean useTimestampWithLocalTimezoneTypeValue;

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
            this.notTimestampBehaviorValue = notTimestampBehavior;
            this.notTimestampBehaviorSet = true;
            return self();
        }

        /**
         * Define which timestamp datatype to use. If set to {@code true} the adapter will use a
         * {@code TIMESTAMP WITH LOCAL TIMEZONE} Exasol column instead of a {@code TIMEZONE} column.
         * 
         * @param useTimestampWithLocalTimezoneType {@code true} if data type {@code TIMESTAMP WITH LOCAL TIMEZONE}
         *                                          should be used instead of {@code TIMESTAMP}
         * @return {@code this}.
         */
        public B useTimestampWithLocalTimezoneType(final boolean useTimestampWithLocalTimezoneType) {
            this.useTimestampWithLocalTimezoneTypeValue = useTimestampWithLocalTimezoneType;
            this.useTimestampWithLocalTimezoneTypeSet = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToTimestampMapping.ToTimestampMappingBuilder(super=" + super.toString()
                    + ", notTimestampBehaviorValue=" + this.notTimestampBehaviorValue
                    + ", useTimestampWithLocalTimezoneTypeValue=" + this.useTimestampWithLocalTimezoneTypeValue + ")";
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
        if (builder.notTimestampBehaviorSet) {
            this.notTimestampBehavior = builder.notTimestampBehaviorValue;
        } else {
            this.notTimestampBehavior = ToTimestampMapping.DEFAULT_NOT_TIMESTAMP_BEHAVIOUR;
        }
        if (builder.useTimestampWithLocalTimezoneTypeSet) {
            this.useTimestampWithLocalTimezoneType = builder.useTimestampWithLocalTimezoneTypeValue;
        } else {
            this.useTimestampWithLocalTimezoneType = DEFAULT_USE_TIMESTAMP_WITH_LOCAL_TIMEZONE_TYPE;
        }
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
        result = prime * result + Objects.hash(notTimestampBehavior, useTimestampWithLocalTimezoneType);
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
        return notTimestampBehavior == other.notTimestampBehavior
                && useTimestampWithLocalTimezoneType == other.useTimestampWithLocalTimezoneType;
    }

    @Override
    public String toString() {
        return "ToTimestampMapping(super=" + super.toString() + ", notTimestampBehavior="
                + this.getNotTimestampBehavior() + ", useTimestampWithLocalTimezoneType="
                + this.isUseTimestampWithLocalTimezoneType() + ")";
    }

    /**
     * Get the behaviour to apply in case a value is not a timestamp.
     * 
     * @return behaviour to apply in case a value is not a timestamp
     */
    public ConvertableMappingErrorBehaviour getNotTimestampBehavior() {
        return this.notTimestampBehavior;
    }

    /**
     * If set to {@code true} the adapter will use a {@code TIMESTAMP WITH LOCAL TIMEZONE} Exasol column instead of a
     * {@code TIMEZONE} column.
     * 
     * @return {@code true} if {@code TIMESTAMP WITH LOCAL TIMEZONE} is used
     */
    public boolean isUseTimestampWithLocalTimezoneType() {
        return this.useTimestampWithLocalTimezoneType;
    }
}
