
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toBoolMapping}. Maps the selected document property to an Exasol
 * {@code BOOLEAN}. column.
 */
public final class ToBoolMapping extends AbstractToColumnMapping {
    private final ConvertableMappingErrorBehaviour notBooleanBehavior;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static ConvertableMappingErrorBehaviour $default$notBooleanBehavior() {
        return ConvertableMappingErrorBehaviour.ABORT;
    }

    /**
     * Builder for {@link ToBoolMapping}.
     */
    public static abstract class ToBoolMappingBuilder<B extends ToBoolMapping.ToBoolMappingBuilder<B>>
            extends AbstractToColumnMapping.AbstractToColumnMappingBuilder<ToBoolMapping, B> {

        private boolean notBooleanBehavior$set;

        private ConvertableMappingErrorBehaviour notBooleanBehavior$value;

        @Override
        protected abstract B self();

        @Override
        public abstract ToBoolMapping build();

        /**
         * Define the behaviour to apply in case a value is not a boolean.
         * 
         * @param notBooleanBehavior the behaviour to apply in case a value is not a boolean
         * @return {@code this}.
         */
        public B notBooleanBehavior(final ConvertableMappingErrorBehaviour notBooleanBehavior) {
            this.notBooleanBehavior$value = notBooleanBehavior;
            this.notBooleanBehavior$set = true;
            return self();
        }

        @Override
        public String toString() {
            return "ToBoolMapping.ToBoolMappingBuilder(super=" + super.toString() + ", notBooleanBehavior$value="
                    + this.notBooleanBehavior$value + ")";
        }
    }

    private static final class ToBoolMappingBuilderImpl
            extends ToBoolMapping.ToBoolMappingBuilder<ToBoolMapping.ToBoolMappingBuilderImpl> {

        private ToBoolMappingBuilderImpl() {
        }

        @Override
        protected ToBoolMapping.ToBoolMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToBoolMapping build() {
            return new ToBoolMapping(this);
        }
    }

    private ToBoolMapping(final ToBoolMapping.ToBoolMappingBuilder<?> builder) {
        super(builder);
        if (builder.notBooleanBehavior$set) {
            this.notBooleanBehavior = builder.notBooleanBehavior$value;
        } else {
            this.notBooleanBehavior = ToBoolMapping.$default$notBooleanBehavior();
        }
    }

    /**
     * Create a new builder for {@link ToBoolMapping}.
     * 
     * @return a new builder for {@link ToBoolMapping}
     */
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToBoolMapping.ToBoolMappingBuilder<?> builder() {
        return new ToBoolMapping.ToBoolMappingBuilderImpl();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(notBooleanBehavior);
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
        ToBoolMapping other = (ToBoolMapping) obj;
        return notBooleanBehavior == other.notBooleanBehavior;
    }

    @Override
    public String toString() {
        return "ToBoolMapping(super=" + super.toString() + ", notBooleanBehavior=" + this.getNotBooleanBehavior() + ")";
    }

    /**
     * Get the behaviour to apply in case a value is not a boolean.
     * 
     * @return behaviour to apply in case a value is not a boolean
     */
    public ConvertableMappingErrorBehaviour getNotBooleanBehavior() {
        return this.notBooleanBehavior;
    }
}
