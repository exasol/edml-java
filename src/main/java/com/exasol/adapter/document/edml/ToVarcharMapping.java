
package com.exasol.adapter.document.edml;

import static com.exasol.adapter.document.edml.ConvertableMappingErrorBehaviour.CONVERT_OR_ABORT;
import static com.exasol.adapter.document.edml.TruncateableMappingErrorBehaviour.TRUNCATE;

/**
 * Java representation of the EDML {@code toVarcharMapping}. Maps the selected document property to an Exasol
 * {@code VARCHAR}, column.
 */
public final class ToVarcharMapping extends AbstractToVarcharColumnMapping {
    private final ConvertableMappingErrorBehaviour nonStringBehaviour;
    private final TruncateableMappingErrorBehaviour overflowBehaviour;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static ConvertableMappingErrorBehaviour $default$nonStringBehaviour() {
        return CONVERT_OR_ABORT;
    }

    private static TruncateableMappingErrorBehaviour $default$overflowBehaviour() {
        return TRUNCATE;
    }

    /**
     * Builder for {@link ToVarcharMapping}.
     */
    public abstract static class ToVarcharMappingBuilder<B extends ToVarcharMapping.ToVarcharMappingBuilder<B>>
            extends AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder<ToVarcharMapping, B> {

        private boolean nonStringBehaviour$set;
        private ConvertableMappingErrorBehaviour nonStringBehaviour$value;
        private boolean overflowBehaviour$set;
        private TruncateableMappingErrorBehaviour overflowBehaviour$value;

        @Override
        protected abstract B self();

        @Override
        public abstract ToVarcharMapping build();

        /**
         * Define the behaviour to apply in case a value is not a varchar.
         * 
         * @param nonStringBehaviour behaviour to apply in case a value is not a varchar
         * @return {@code this}.
         */
        public B nonStringBehaviour(final ConvertableMappingErrorBehaviour nonStringBehaviour) {
            this.nonStringBehaviour$value = nonStringBehaviour;
            this.nonStringBehaviour$set = true;
            return self();
        }

        /**
         * Set the behaviour to apply in case a value exceeds the size of the VARCHAR column.
         * 
         * @param overflowBehaviour the overflow behaviour
         * @return {@code this}.
         */
        public B overflowBehaviour(final TruncateableMappingErrorBehaviour overflowBehaviour) {
            this.overflowBehaviour$value = overflowBehaviour;
            this.overflowBehaviour$set = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToVarcharMapping.ToVarcharMappingBuilder(super=" + super.toString() + ", nonStringBehaviour$value="
                    + this.nonStringBehaviour$value + ", overflowBehaviour$value=" + this.overflowBehaviour$value + ")";
        }
    }

    private static final class ToVarcharMappingBuilderImpl
            extends ToVarcharMapping.ToVarcharMappingBuilder<ToVarcharMapping.ToVarcharMappingBuilderImpl> {

        private ToVarcharMappingBuilderImpl() {
        }

        @Override
        protected ToVarcharMapping.ToVarcharMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToVarcharMapping build() {
            return new ToVarcharMapping(this);
        }
    }

    private ToVarcharMapping(final ToVarcharMapping.ToVarcharMappingBuilder<?> builder) {
        super(builder);
        if (builder.nonStringBehaviour$set) {
            this.nonStringBehaviour = builder.nonStringBehaviour$value;
        } else {
            this.nonStringBehaviour = ToVarcharMapping.$default$nonStringBehaviour();
        }
        if (builder.overflowBehaviour$set) {
            this.overflowBehaviour = builder.overflowBehaviour$value;
        } else {
            this.overflowBehaviour = ToVarcharMapping.$default$overflowBehaviour();
        }
    }

    /**
     * Create a new builder for {@link ToVarcharMapping}.
     * 
     * @return a new builder for {@link ToVarcharMapping}
     */
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToVarcharMapping.ToVarcharMappingBuilder<?> builder() {
        return new ToVarcharMapping.ToVarcharMappingBuilderImpl();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToVarcharMapping)) {
            return false;
        }
        final ToVarcharMapping other = (ToVarcharMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Object this$nonStringBehaviour = this.getNonStringBehaviour();
        final Object other$nonStringBehaviour = other.getNonStringBehaviour();
        if (this$nonStringBehaviour == null ? other$nonStringBehaviour != null
                : !this$nonStringBehaviour.equals(other$nonStringBehaviour)) {
            return false;
        }
        final Object this$overflowBehaviour = this.getOverflowBehaviour();
        final Object other$overflowBehaviour = other.getOverflowBehaviour();
        if (this$overflowBehaviour == null ? other$overflowBehaviour != null
                : !this$overflowBehaviour.equals(other$overflowBehaviour)) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof ToVarcharMapping;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $nonStringBehaviour = this.getNonStringBehaviour();
        result = (result * PRIME) + ($nonStringBehaviour == null ? 43 : $nonStringBehaviour.hashCode());
        final Object $overflowBehaviour = this.getOverflowBehaviour();
        result = (result * PRIME) + ($overflowBehaviour == null ? 43 : $overflowBehaviour.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ToVarcharMapping(super=" + super.toString() + ", nonStringBehaviour=" + this.getNonStringBehaviour()
                + ", overflowBehaviour=" + this.getOverflowBehaviour() + ")";
    }

    /**
     * Get the behaviour to apply in case a value is not a varchar.
     * 
     * @return behaviour to apply in case a value is not a varchar
     */
    public ConvertableMappingErrorBehaviour getNonStringBehaviour() {
        return this.nonStringBehaviour;
    }

    /**
     * Get the behaviour to apply in case a value exceeds the size of the VARCHAR column.
     * 
     * @return behaviour in case of overflow
     */
    public TruncateableMappingErrorBehaviour getOverflowBehaviour() {
        return this.overflowBehaviour;
    }
}
