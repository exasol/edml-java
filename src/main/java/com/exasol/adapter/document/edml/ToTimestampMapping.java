
package com.exasol.adapter.document.edml;

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
    public static ToTimestampMapping.ToTimestampMappingBuilder<?> builder() {
        return new ToTimestampMapping.ToTimestampMappingBuilderImpl();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToTimestampMapping)) {
            return false;
        }
        final ToTimestampMapping other = (ToTimestampMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (this.isUseTimestampWithLocalTimezoneType() != other.isUseTimestampWithLocalTimezoneType()) {
            return false;
        }
        final Object this$notTimestampBehavior = this.getNotTimestampBehavior();
        final Object other$notTimestampBehavior = other.getNotTimestampBehavior();
        if (this$notTimestampBehavior == null ? other$notTimestampBehavior != null
                : !this$notTimestampBehavior.equals(other$notTimestampBehavior)) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof ToTimestampMapping;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result = (result * PRIME) + (this.isUseTimestampWithLocalTimezoneType() ? 79 : 97);
        final Object $notTimestampBehavior = this.getNotTimestampBehavior();
        result = (result * PRIME) + ($notTimestampBehavior == null ? 43 : $notTimestampBehavior.hashCode());
        return result;
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
