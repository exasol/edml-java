
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toDoubleMapping}.
 */
public final class ToDoubleMapping extends AbstractToNumberMapping {
    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    public static abstract class ToDoubleMappingBuilder<C extends ToDoubleMapping, B extends ToDoubleMapping.ToDoubleMappingBuilder<C, B>>
            extends AbstractToNumberMapping.AbstractToNumberMappingBuilder<C, B> {
        @java.lang.Override

        protected abstract B self();

        @java.lang.Override

        public abstract C build();

        @java.lang.Override

        public java.lang.String toString() {
            return "ToDoubleMapping.ToDoubleMappingBuilder(super=" + super.toString() + ")";
        }
    }

    private static final class ToDoubleMappingBuilderImpl extends
            ToDoubleMapping.ToDoubleMappingBuilder<ToDoubleMapping, ToDoubleMapping.ToDoubleMappingBuilderImpl> {

        private ToDoubleMappingBuilderImpl() {
        }

        @java.lang.Override

        protected ToDoubleMapping.ToDoubleMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override

        public ToDoubleMapping build() {
            return new ToDoubleMapping(this);
        }
    }

    protected ToDoubleMapping(final ToDoubleMapping.ToDoubleMappingBuilder<?, ?> b) {
        super(b);
    }

    public static ToDoubleMapping.ToDoubleMappingBuilder<?, ?> builder() {
        return new ToDoubleMapping.ToDoubleMappingBuilderImpl();
    }

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToDoubleMapping))
            return false;
        final ToDoubleMapping other = (ToDoubleMapping) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        return true;
    }

    @Override
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToDoubleMapping;
    }

    @java.lang.Override

    public int hashCode() {
        final int result = super.hashCode();
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
        return "ToDoubleMapping(super=" + super.toString() + ")";
    }
}
