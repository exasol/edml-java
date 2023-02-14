
package com.exasol.adapter.document.edml;

import static com.exasol.adapter.document.edml.MappingErrorBehaviour.ABORT;

/**
 * Java representation of the EDML {@code toJsonMapping}.
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

    public static abstract class ToJsonMappingBuilder<C extends ToJsonMapping, B extends ToJsonMapping.ToJsonMappingBuilder<C, B>>
            extends AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder<C, B> {

        private boolean overflowBehaviour$set;

        private MappingErrorBehaviour overflowBehaviour$value;

        @java.lang.Override

        protected abstract B self();

        @java.lang.Override

        public abstract C build();

        /**
         * @return {@code this}.
         */

        public B overflowBehaviour(final MappingErrorBehaviour overflowBehaviour) {
            this.overflowBehaviour$value = overflowBehaviour;
            overflowBehaviour$set = true;
            return self();
        }

        @java.lang.Override

        public java.lang.String toString() {
            return "ToJsonMapping.ToJsonMappingBuilder(super=" + super.toString() + ", overflowBehaviour$value="
                    + this.overflowBehaviour$value + ")";
        }
    }

    private static final class ToJsonMappingBuilderImpl
            extends ToJsonMapping.ToJsonMappingBuilder<ToJsonMapping, ToJsonMapping.ToJsonMappingBuilderImpl> {

        private ToJsonMappingBuilderImpl() {
        }

        @java.lang.Override

        protected ToJsonMapping.ToJsonMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override

        public ToJsonMapping build() {
            return new ToJsonMapping(this);
        }
    }

    protected ToJsonMapping(final ToJsonMapping.ToJsonMappingBuilder<?, ?> b) {
        super(b);
        if (b.overflowBehaviour$set)
            this.overflowBehaviour = b.overflowBehaviour$value;
        else
            this.overflowBehaviour = ToJsonMapping.$default$overflowBehaviour();
    }

    public static ToJsonMapping.ToJsonMappingBuilder<?, ?> builder() {
        return new ToJsonMapping.ToJsonMappingBuilderImpl();
    }

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToJsonMapping))
            return false;
        final ToJsonMapping other = (ToJsonMapping) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        final java.lang.Object this$overflowBehaviour = this.getOverflowBehaviour();
        final java.lang.Object other$overflowBehaviour = other.getOverflowBehaviour();
        if (this$overflowBehaviour == null ? other$overflowBehaviour != null
                : !this$overflowBehaviour.equals(other$overflowBehaviour))
            return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToJsonMapping;
    }

    @java.lang.Override

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final java.lang.Object $overflowBehaviour = this.getOverflowBehaviour();
        result = result * PRIME + ($overflowBehaviour == null ? 43 : $overflowBehaviour.hashCode());
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
        return "ToJsonMapping(super=" + super.toString() + ", overflowBehaviour=" + this.getOverflowBehaviour() + ")";
    }

    public MappingErrorBehaviour getOverflowBehaviour() {
        return this.overflowBehaviour;
    }
}
