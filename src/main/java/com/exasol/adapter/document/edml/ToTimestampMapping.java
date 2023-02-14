
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

    public static abstract class ToTimestampMappingBuilder<C extends ToTimestampMapping, B extends ToTimestampMapping.ToTimestampMappingBuilder<C, B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<C, B> {

        private boolean notTimestampBehavior$set;

        private ConvertableMappingErrorBehaviour notTimestampBehavior$value;

        private boolean useTimestampWithLocalTimezoneType$set;

        private boolean useTimestampWithLocalTimezoneType$value;

        @java.lang.Override

        protected abstract B self();

        @java.lang.Override

        public abstract C build();

        /**
         * @return {@code this}.
         */

        public B notTimestampBehavior(final ConvertableMappingErrorBehaviour notTimestampBehavior) {
            this.notTimestampBehavior$value = notTimestampBehavior;
            notTimestampBehavior$set = true;
            return self();
        }

        /**
         * @return {@code this}.
         */

        public B useTimestampWithLocalTimezoneType(final boolean useTimestampWithLocalTimezoneType) {
            this.useTimestampWithLocalTimezoneType$value = useTimestampWithLocalTimezoneType;
            useTimestampWithLocalTimezoneType$set = true;
            return self();
        }

        @java.lang.Override

        public java.lang.String toString() {
            return "ToTimestampMapping.ToTimestampMappingBuilder(super=" + super.toString()
                    + ", notTimestampBehavior$value=" + this.notTimestampBehavior$value
                    + ", useTimestampWithLocalTimezoneType$value=" + this.useTimestampWithLocalTimezoneType$value + ")";
        }
    }

    private static final class ToTimestampMappingBuilderImpl extends
            ToTimestampMapping.ToTimestampMappingBuilder<ToTimestampMapping, ToTimestampMapping.ToTimestampMappingBuilderImpl> {

        private ToTimestampMappingBuilderImpl() {
        }

        @java.lang.Override

        protected ToTimestampMapping.ToTimestampMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override

        public ToTimestampMapping build() {
            return new ToTimestampMapping(this);
        }
    }

    protected ToTimestampMapping(final ToTimestampMapping.ToTimestampMappingBuilder<?, ?> b) {
        super(b);
        if (b.notTimestampBehavior$set)
            this.notTimestampBehavior = b.notTimestampBehavior$value;
        else
            this.notTimestampBehavior = ToTimestampMapping.$default$notTimestampBehavior();
        if (b.useTimestampWithLocalTimezoneType$set)
            this.useTimestampWithLocalTimezoneType = b.useTimestampWithLocalTimezoneType$value;
        else
            this.useTimestampWithLocalTimezoneType = ToTimestampMapping.$default$useTimestampWithLocalTimezoneType();
    }

    public static ToTimestampMapping.ToTimestampMappingBuilder<?, ?> builder() {
        return new ToTimestampMapping.ToTimestampMappingBuilderImpl();
    }

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToTimestampMapping))
            return false;
        final ToTimestampMapping other = (ToTimestampMapping) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        if (this.isUseTimestampWithLocalTimezoneType() != other.isUseTimestampWithLocalTimezoneType())
            return false;
        final java.lang.Object this$notTimestampBehavior = this.getNotTimestampBehavior();
        final java.lang.Object other$notTimestampBehavior = other.getNotTimestampBehavior();
        if (this$notTimestampBehavior == null ? other$notTimestampBehavior != null
                : !this$notTimestampBehavior.equals(other$notTimestampBehavior))
            return false;
        return true;
    }

    @Override
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToTimestampMapping;
    }

    @java.lang.Override

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result = result * PRIME + (this.isUseTimestampWithLocalTimezoneType() ? 79 : 97);
        final java.lang.Object $notTimestampBehavior = this.getNotTimestampBehavior();
        result = result * PRIME + ($notTimestampBehavior == null ? 43 : $notTimestampBehavior.hashCode());
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
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
     */

    public boolean isUseTimestampWithLocalTimezoneType() {
        return this.useTimestampWithLocalTimezoneType;
    }
}
