
package com.exasol.adapter.document.edml;

import static com.exasol.adapter.document.edml.MappingErrorBehaviour.ABORT;

import java.util.Objects;

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
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToJsonMapping.ToJsonMappingBuilder<?> builder() {
        return new ToJsonMapping.ToJsonMappingBuilderImpl();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(overflowBehaviour);
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
        ToJsonMapping other = (ToJsonMapping) obj;
        return overflowBehaviour == other.overflowBehaviour;
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
