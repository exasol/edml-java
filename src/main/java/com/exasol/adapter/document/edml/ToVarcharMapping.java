
package com.exasol.adapter.document.edml;

import static com.exasol.adapter.document.edml.ConvertableMappingErrorBehaviour.CONVERT_OR_ABORT;
import static com.exasol.adapter.document.edml.TruncateableMappingErrorBehaviour.TRUNCATE;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toVarcharMapping}. Maps the selected document property to an Exasol
 * {@code VARCHAR}, column.
 */
public final class ToVarcharMapping extends AbstractToVarcharColumnMapping {
    private static final TruncateableMappingErrorBehaviour DEFAULT_OVERFLOW_BEHAVIOUR = TRUNCATE;
    private static final ConvertableMappingErrorBehaviour DEFAULT_NON_STRING_BEHAVIOUR = CONVERT_OR_ABORT;
    private final ConvertableMappingErrorBehaviour nonStringBehaviour;
    private final TruncateableMappingErrorBehaviour overflowBehaviour;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link ToVarcharMapping}.
     */
    public abstract static class ToVarcharMappingBuilder<B extends ToVarcharMapping.ToVarcharMappingBuilder<B>>
            extends AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder<ToVarcharMapping, B> {

        private ConvertableMappingErrorBehaviour nonStringBehaviour = DEFAULT_NON_STRING_BEHAVIOUR;
        private TruncateableMappingErrorBehaviour overflowBehaviour = DEFAULT_OVERFLOW_BEHAVIOUR;

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
            this.nonStringBehaviour = nonStringBehaviour;
            return self();
        }

        /**
         * Set the behaviour to apply in case a value exceeds the size of the VARCHAR column.
         *
         * @param overflowBehaviour the overflow behaviour
         * @return {@code this}.
         */
        public B overflowBehaviour(final TruncateableMappingErrorBehaviour overflowBehaviour) {
            this.overflowBehaviour = overflowBehaviour;
            return self();
        }

        @Override
        public String toString() {
            return "ToVarcharMapping.ToVarcharMappingBuilder(super=" + super.toString() + ", nonStringBehaviourValue="
                    + this.nonStringBehaviour + ", overflowBehaviourValue=" + this.overflowBehaviour + ")";
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
        this.nonStringBehaviour = builder.nonStringBehaviour;
        this.overflowBehaviour = builder.overflowBehaviour;
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
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + Objects.hash(this.nonStringBehaviour, this.overflowBehaviour);
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
        final ToVarcharMapping other = (ToVarcharMapping) obj;
        return (this.nonStringBehaviour == other.nonStringBehaviour)
                && (this.overflowBehaviour == other.overflowBehaviour);
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
