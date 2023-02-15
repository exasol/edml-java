
package com.exasol.adapter.document.edml;

import static com.exasol.adapter.document.edml.MappingErrorBehaviour.ABORT;

/**
 * Java representation of the EDML {@code toJsonMapping}. Maps the selected document property and all its descendants to
 * a JSON string. You can also use this mapping directly for a whole document.
 */
public final class ToJsonMapping extends AbstractToVarcharColumnMapping {
    private final MappingErrorBehaviour overflowBehaviour;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static MappingErrorBehaviour $default$overflowBehaviour() {
        return ABORT;
    }

    /**
     * Builder for {@link ToJsonMapping}.
     */
    public abstract static class ToJsonMappingBuilder<B extends ToJsonMapping.ToJsonMappingBuilder<B>>
            extends AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder<ToJsonMapping, B> {

        private boolean overflowBehaviour$set;

        private MappingErrorBehaviour overflowBehaviour$value;

        @Override
        protected abstract B self();

        @Override
        public abstract ToJsonMapping build();

        /**
         * Set the behaviour to apply in case a value exceeds the size of the Exasol column.
         * 
         * @param overflowBehaviour the overflow behaviour
         * @return {@code this}.
         */
        public B overflowBehaviour(final MappingErrorBehaviour overflowBehaviour) {
            this.overflowBehaviour$value = overflowBehaviour;
            this.overflowBehaviour$set = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToJsonMapping.ToJsonMappingBuilder(super=" + super.toString() + ", overflowBehaviour$value="
                    + this.overflowBehaviour$value + ")";
        }
    }

    private static final class ToJsonMappingBuilderImpl
            extends ToJsonMapping.ToJsonMappingBuilder<ToJsonMapping.ToJsonMappingBuilderImpl> {

        private ToJsonMappingBuilderImpl() {
        }

        @Override
        protected ToJsonMapping.ToJsonMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToJsonMapping build() {
            return new ToJsonMapping(this);
        }
    }

    private ToJsonMapping(final ToJsonMapping.ToJsonMappingBuilder<?> builder) {
        super(builder);
        if (builder.overflowBehaviour$set) {
            this.overflowBehaviour = builder.overflowBehaviour$value;
        } else {
            this.overflowBehaviour = ToJsonMapping.$default$overflowBehaviour();
        }
    }

    /**
     * Create a new builder for {@link ToJsonMapping}.
     * 
     * @return a new builder for {@link ToJsonMapping}
     */
    public static ToJsonMapping.ToJsonMappingBuilder<?> builder() {
        return new ToJsonMapping.ToJsonMappingBuilderImpl();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToJsonMapping)) {
            return false;
        }
        final ToJsonMapping other = (ToJsonMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
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
        return other instanceof ToJsonMapping;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $overflowBehaviour = this.getOverflowBehaviour();
        result = (result * PRIME) + ($overflowBehaviour == null ? 43 : $overflowBehaviour.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ToJsonMapping(super=" + super.toString() + ", overflowBehaviour=" + this.getOverflowBehaviour() + ")";
    }

    /**
     * Get the behaviour to apply in case a value exceeds the size of the Exasol column.
     * 
     * @return the overflow behaviour
     */
    public MappingErrorBehaviour getOverflowBehaviour() {
        return this.overflowBehaviour;
    }
}
