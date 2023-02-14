
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

    public static abstract class ToJsonMappingBuilder<B extends ToJsonMapping.ToJsonMappingBuilder<B>>
            extends AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder<ToJsonMapping, B> {

        private boolean overflowBehaviour$set;

        private MappingErrorBehaviour overflowBehaviour$value;

        @Override
        protected abstract B self();

        @Override
        public abstract ToJsonMapping build();

        /**
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

    protected ToJsonMapping(final ToJsonMapping.ToJsonMappingBuilder<?> b) {
        super(b);
        if (b.overflowBehaviour$set) {
            this.overflowBehaviour = b.overflowBehaviour$value;
        } else {
            this.overflowBehaviour = ToJsonMapping.$default$overflowBehaviour();
        }
    }

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

    public MappingErrorBehaviour getOverflowBehaviour() {
        return this.overflowBehaviour;
    }
}
