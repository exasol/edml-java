
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Abstract base for EDML mappings that map to a numeric Exasol column.
 */
public abstract class AbstractToNumberMapping extends AbstractToColumnMapping {
    private final MappingErrorBehaviour overflowBehaviour;
    private final ConvertableMappingErrorBehaviour notNumericBehaviour;

    /**
     * Builder for {@link AbstractToColumnMapping}.
     */
    public abstract static class AbstractToNumberMappingBuilder<C extends AbstractToNumberMapping, B extends AbstractToNumberMappingBuilder<C, B>>
            extends AbstractToColumnMappingBuilder<C, B> {

        private boolean overflowBehaviour$set;

        private MappingErrorBehaviour overflowBehaviour$value;

        private boolean notNumericBehaviour$set;

        private ConvertableMappingErrorBehaviour notNumericBehaviour$value;

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
            this.overflowBehaviour$value = overflowBehaviour;
            this.overflowBehaviour$set = true;
            return self();
        }

        /**
         * Define the behaviour to apply in case a value is not a number.
         * 
         * @param notNumericBehaviour behaviour to apply in case a value is not a number.
         * @return {@code this}.
         */
        public B notNumericBehaviour(final ConvertableMappingErrorBehaviour notNumericBehaviour) {
            this.notNumericBehaviour$value = notNumericBehaviour;
            this.notNumericBehaviour$set = true;
            return self();
        }

        @Override
        public String toString() {
            return "AbstractToNumberMapping.AbstractToNumberMappingBuilder(super=" + super.toString()
                    + ", overflowBehaviour$value=" + this.overflowBehaviour$value + ", notNumericBehaviour$value="
                    + this.notNumericBehaviour$value + ")";
        }
    }

    private static MappingErrorBehaviour $default$overflowBehaviour() {
        return MappingErrorBehaviour.ABORT;
    }

    private static ConvertableMappingErrorBehaviour $default$notNumericBehaviour() {
        return ConvertableMappingErrorBehaviour.ABORT;
    }

    /**
     * Create a new {@link AbstractToNumberMapping}.
     * 
     * @param builder the builder
     */
    protected AbstractToNumberMapping(final AbstractToNumberMapping.AbstractToNumberMappingBuilder<?, ?> builder) {
        super(builder);
        if (builder.overflowBehaviour$set) {
            this.overflowBehaviour = builder.overflowBehaviour$value;
        } else {
            this.overflowBehaviour = AbstractToNumberMapping.$default$overflowBehaviour();
        }
        if (builder.notNumericBehaviour$set) {
            this.notNumericBehaviour = builder.notNumericBehaviour$value;
        } else {
            this.notNumericBehaviour = AbstractToNumberMapping.$default$notNumericBehaviour();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(overflowBehaviour, notNumericBehaviour);
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
        AbstractToNumberMapping other = (AbstractToNumberMapping) obj;
        return overflowBehaviour == other.overflowBehaviour && notNumericBehaviour == other.notNumericBehaviour;
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
