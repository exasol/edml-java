
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Abstract base for EDML mappings that map to a numeric Exasol column.
 */
public abstract class AbstractToNumberMapping extends AbstractToColumnMapping {
    private static final ConvertableMappingErrorBehaviour DEFAULT_NON_NUMERIC_BEHAVIOUR = ConvertableMappingErrorBehaviour.ABORT;
    private static final MappingErrorBehaviour DEFAULT_OVERFLOW_BEHAVIOUR = MappingErrorBehaviour.ABORT;
    private final MappingErrorBehaviour overflowBehaviour;
    private final ConvertableMappingErrorBehaviour notNumericBehaviour;

    /**
     * Builder for {@link AbstractToColumnMapping}.
     */
    public abstract static class AbstractToNumberMappingBuilder<C extends AbstractToNumberMapping, B extends AbstractToNumberMappingBuilder<C, B>>
            extends AbstractToColumnMappingBuilder<C, B> {

        private MappingErrorBehaviour overflowBehaviourValue = DEFAULT_OVERFLOW_BEHAVIOUR;

        private boolean notNumericBehaviourSet;

        private ConvertableMappingErrorBehaviour notNumericBehaviourValue;

        @Override
        protected abstract B self();

        @Override
        public abstract C build();

        /**
         * Define the behaviour to apply in case a value exceeds the size of the {@code VARCHAR} column.
         *
         * @param overflowBehaviour behaviour to apply in case a value exceeds the size of the {@code VARCHAR} column.
         * @return {@code this}.
         */
        public B overflowBehaviour(final MappingErrorBehaviour overflowBehaviour) {
            this.overflowBehaviourValue = overflowBehaviour;
            return self();
        }

        /**
         * Define the behaviour to apply in case a value is not a number.
         *
         * @param notNumericBehaviour behaviour to apply in case a value is not a number.
         * @return {@code this}.
         */
        public B notNumericBehaviour(final ConvertableMappingErrorBehaviour notNumericBehaviour) {
            this.notNumericBehaviourValue = notNumericBehaviour;
            this.notNumericBehaviourSet = true;
            return self();
        }

        @Override
        public String toString() {
            return "AbstractToNumberMapping.AbstractToNumberMappingBuilder(super=" + super.toString()
                    + ", overflowBehaviourValue=" + this.overflowBehaviourValue + ", notNumericBehaviourValue="
                    + this.notNumericBehaviourValue + ")";
        }
    }

    /**
     * Create a new {@link AbstractToNumberMapping}.
     *
     * @param builder the builder
     */
    protected AbstractToNumberMapping(final AbstractToNumberMapping.AbstractToNumberMappingBuilder<?, ?> builder) {
        super(builder);
        this.overflowBehaviour = builder.overflowBehaviourValue;
        if (builder.notNumericBehaviourSet) {
            this.notNumericBehaviour = builder.notNumericBehaviourValue;
        } else {
            this.notNumericBehaviour = DEFAULT_NON_NUMERIC_BEHAVIOUR;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + Objects.hash(this.overflowBehaviour, this.notNumericBehaviour);
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
        final AbstractToNumberMapping other = (AbstractToNumberMapping) obj;
        return (this.overflowBehaviour == other.overflowBehaviour)
                && (this.notNumericBehaviour == other.notNumericBehaviour);
    }

    @Override
    public String toString() {
        return "AbstractToNumberMapping(super=" + super.toString() + ", overflowBehaviour="
                + this.getOverflowBehaviour() + ", notNumericBehaviour=" + this.getNotNumericBehaviour() + ")";
    }

    /**
     * Get the behaviour to apply in case a value exceeds the size of the {@code VARCHAR} column.
     *
     * @return behaviour to apply in case a value exceeds the size of the {@code VARCHAR} column.
     */
    public MappingErrorBehaviour getOverflowBehaviour() {
        return this.overflowBehaviour;
    }

    /**
     * Get the behaviour to apply in case a value is not a number.
     *
     * @return behaviour to apply in case a value is not a number
     */
    public ConvertableMappingErrorBehaviour getNotNumericBehaviour() {
        return this.notNumericBehaviour;
    }
}
