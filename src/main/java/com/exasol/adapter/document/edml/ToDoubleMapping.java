
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toDoubleMapping}. Maps the selected document property to an Exasol
 * {@code DOUBLE PRECISION} column.
 */
public final class ToDoubleMapping extends AbstractToNumberMapping {

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link ToDoubleMapping}.
     */
    public abstract static class ToDoubleMappingBuilder<B extends ToDoubleMapping.ToDoubleMappingBuilder<B>>
            extends AbstractToNumberMapping.AbstractToNumberMappingBuilder<ToDoubleMapping, B> {
        @Override
        protected abstract B self();

        @Override
        public abstract ToDoubleMapping build();

        @Override
        public String toString() {
            return "ToDoubleMapping.ToDoubleMappingBuilder(super=" + super.toString() + ")";
        }
    }

    private static final class ToDoubleMappingBuilderImpl
            extends ToDoubleMapping.ToDoubleMappingBuilder<ToDoubleMapping.ToDoubleMappingBuilderImpl> {

        private ToDoubleMappingBuilderImpl() {
        }

        @Override
        protected ToDoubleMapping.ToDoubleMappingBuilderImpl self() {
            return this;
        }

        @Override
        public ToDoubleMapping build() {
            return new ToDoubleMapping(this);
        }
    }

    private ToDoubleMapping(final ToDoubleMapping.ToDoubleMappingBuilder<?> builder) {
        super(builder);
    }

    /**
     * Create a new builder for {@link ToDoubleMapping}.
     * 
     * @return a new builder for {@link ToDoubleMapping}
     */
    @SuppressWarnings("java:S1452") // Generic wildcard is required here
    public static ToDoubleMapping.ToDoubleMappingBuilder<?> builder() {
        return new ToDoubleMapping.ToDoubleMappingBuilderImpl();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToDoubleMapping)) {
            return false;
        }
        final ToDoubleMapping other = (ToDoubleMapping) o;
        if (!(other instanceof ToDoubleMapping)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ToDoubleMapping(super=" + super.toString() + ")";
    }
}
