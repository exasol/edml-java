
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toTimestampMapping}. Maps the selected document property to an Exasol
 * {@code TIMESTAMP} or {@code TIMESTAMP WITH LOCAL TIMEZONE} column.
 */
public final class ToTimestampMapping extends AbstractToColumnMapping {
    private final ConvertableMappingErrorBehaviour notTimestampBehavior;

    private final boolean useTimestampWithLocalTimezoneType;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static ConvertableMappingErrorBehaviour $default$notTimestampBehavior() {
        return ConvertableMappingErrorBehaviour.ABORT;
    }

    private static boolean $default$useTimestampWithLocalTimezoneType() {
        return true;
    }

    /**
     * Builder for {@link ToTimestampMapping}.
     */
    public abstract static class ToTimestampMappingBuilder<B extends ToTimestampMapping.ToTimestampMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToTimestampMapping, B> {

        private boolean notTimestampBehavior$set;
        private ConvertableMappingErrorBehaviour notTimestampBehavior$value;
        private boolean useTimestampWithLocalTimezoneType$set;
        private boolean useTimestampWithLocalTimezoneType$value;

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
            this.notTimestampBehavior$value = notTimestampBehavior;
            this.notTimestampBehavior$set = true;
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
            this.useTimestampWithLocalTimezoneType$value = useTimestampWithLocalTimezoneType;
            this.useTimestampWithLocalTimezoneType$set = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToTimestampMapping.ToTimestampMappingBuilder(super=" + super.toString()
                    + ", notTimestampBehavior$value=" + this.notTimestampBehavior$value
                    + ", useTimestampWithLocalTimezoneType$value=" + this.useTimestampWithLocalTimezoneType$value + ")";
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
        if (builder.notTimestampBehavior$set) {
            this.notTimestampBehavior = builder.notTimestampBehavior$value;
        } else {
            this.notTimestampBehavior = ToTimestampMapping.$default$notTimestampBehavior();
        }
        if (builder.useTimestampWithLocalTimezoneType$set) {
            this.useTimestampWithLocalTimezoneType = builder.useTimestampWithLocalTimezoneType$value;
        } else {
            this.useTimestampWithLocalTimezoneType = ToTimestampMapping.$default$useTimestampWithLocalTimezoneType();
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ToTimestampMapping other = (ToTimestampMapping) obj;
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
