
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toTimestampMapping}.
 */

public final class ToTimestampMapping extends AbstractToColumnMapping {
    private final ConvertableMappingErrorBehaviour notTimestampBehavior;

    /**
     * If set to {@code true} this adapter will use a {@code TIMESTAMP WITH LOCAL TIMEZONE} Exasol column instead of a
     * {@code TIMEZONE} column.
     */
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

    public static abstract class ToTimestampMappingBuilder<B extends ToTimestampMapping.ToTimestampMappingBuilder<B>>
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
         * @param notTimestampBehavior the not-timestamp behaviour
         * @return {@code this}.
         */
        public B notTimestampBehavior(final ConvertableMappingErrorBehaviour notTimestampBehavior) {
            this.notTimestampBehavior$value = notTimestampBehavior;
            this.notTimestampBehavior$set = true;
            return self();
        }

        /**
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

    protected ToTimestampMapping(final ToTimestampMapping.ToTimestampMappingBuilder<?> b) {
        super(b);
        if (b.notTimestampBehavior$set) {
            this.notTimestampBehavior = b.notTimestampBehavior$value;
        } else {
            this.notTimestampBehavior = ToTimestampMapping.$default$notTimestampBehavior();
        }
        if (b.useTimestampWithLocalTimezoneType$set) {
            this.useTimestampWithLocalTimezoneType = b.useTimestampWithLocalTimezoneType$value;
        } else {
            this.useTimestampWithLocalTimezoneType = ToTimestampMapping.$default$useTimestampWithLocalTimezoneType();
        }
    }

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

    public ConvertableMappingErrorBehaviour getNotTimestampBehavior() {
        return this.notTimestampBehavior;
    }

    /**
     * If set to {@code true} this adapter will use a {@code TIMESTAMP WITH LOCAL TIMEZONE} Exasol column instead of a
     * {@code TIMEZONE} column.
     * 
     * @return {@code true} if {@code TIMESTAMP WITH LOCAL TIMEZONE} is used
     */
    public boolean isUseTimestampWithLocalTimezoneType() {
        return this.useTimestampWithLocalTimezoneType;
    }
}
