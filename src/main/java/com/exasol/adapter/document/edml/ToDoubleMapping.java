
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toDoubleMapping}.
 */
public final class ToDoubleMapping extends AbstractToNumberMapping {
    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    public static abstract class ToDoubleMappingBuilder<B extends ToDoubleMapping.ToDoubleMappingBuilder<B>>
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

    protected ToDoubleMapping(final ToDoubleMapping.ToDoubleMappingBuilder<?> b) {
        super(b);
    }

    public static ToDoubleMapping.ToDoubleMappingBuilder<?> builder() {
        return new ToDoubleMapping.ToDoubleMappingBuilderImpl();
    }

    @Override

    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToDoubleMapping))
            return false;
        final ToDoubleMapping other = (ToDoubleMapping) o;
        if (!other.canEqual((Object) this))
            return false;
        if (!super.equals(o))
            return false;
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof ToDoubleMapping;
    }

    @Override

    public int hashCode() {
        final int result = super.hashCode();
        return result;
    }

    @Override

    public String toString() {
        return "ToDoubleMapping(super=" + super.toString() + ")";
    }
}
