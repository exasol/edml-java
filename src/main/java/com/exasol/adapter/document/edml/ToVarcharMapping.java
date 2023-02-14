
package com.exasol.adapter.document.edml;

import static com.exasol.adapter.document.edml.ConvertableMappingErrorBehaviour.CONVERT_OR_ABORT;
import static com.exasol.adapter.document.edml.TruncateableMappingErrorBehaviour.TRUNCATE;

/**
 * Java representation of the EDML {@code toVarcharMapping}.
 */

public final class ToVarcharMapping extends AbstractToVarcharColumnMapping {
    private final ConvertableMappingErrorBehaviour nonStringBehaviour;
    private final TruncateableMappingErrorBehaviour overflowBehaviour;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static ConvertableMappingErrorBehaviour $default$nonStringBehaviour() {
        return CONVERT_OR_ABORT;
    }

    private static TruncateableMappingErrorBehaviour $default$overflowBehaviour() {
        return TRUNCATE;
    }

    public static abstract class ToVarcharMappingBuilder<C extends ToVarcharMapping, B extends ToVarcharMapping.ToVarcharMappingBuilder<C, B>>
            extends AbstractToVarcharColumnMapping.AbstractToVarcharColumnMappingBuilder<C, B> {

        private boolean nonStringBehaviour$set;

        private ConvertableMappingErrorBehaviour nonStringBehaviour$value;

        private boolean overflowBehaviour$set;

        private TruncateableMappingErrorBehaviour overflowBehaviour$value;

        @java.lang.Override

        protected abstract B self();

        @java.lang.Override

        public abstract C build();

        /**
         * @return {@code this}.
         */

        public B nonStringBehaviour(final ConvertableMappingErrorBehaviour nonStringBehaviour) {
            this.nonStringBehaviour$value = nonStringBehaviour;
            nonStringBehaviour$set = true;
            return self();
        }

        /**
         * @return {@code this}.
         */

        public B overflowBehaviour(final TruncateableMappingErrorBehaviour overflowBehaviour) {
            this.overflowBehaviour$value = overflowBehaviour;
            overflowBehaviour$set = true;
            return self();
        }

        @java.lang.Override

        public java.lang.String toString() {
            return "ToVarcharMapping.ToVarcharMappingBuilder(super=" + super.toString() + ", nonStringBehaviour$value="
                    + this.nonStringBehaviour$value + ", overflowBehaviour$value=" + this.overflowBehaviour$value + ")";
        }
    }

    private static final class ToVarcharMappingBuilderImpl extends
            ToVarcharMapping.ToVarcharMappingBuilder<ToVarcharMapping, ToVarcharMapping.ToVarcharMappingBuilderImpl> {

        private ToVarcharMappingBuilderImpl() {
        }

        @java.lang.Override

        protected ToVarcharMapping.ToVarcharMappingBuilderImpl self() {
            return this;
        }

        @java.lang.Override

        public ToVarcharMapping build() {
            return new ToVarcharMapping(this);
        }
    }

    protected ToVarcharMapping(final ToVarcharMapping.ToVarcharMappingBuilder<?, ?> b) {
        super(b);
        if (b.nonStringBehaviour$set)
            this.nonStringBehaviour = b.nonStringBehaviour$value;
        else
            this.nonStringBehaviour = ToVarcharMapping.$default$nonStringBehaviour();
        if (b.overflowBehaviour$set)
            this.overflowBehaviour = b.overflowBehaviour$value;
        else
            this.overflowBehaviour = ToVarcharMapping.$default$overflowBehaviour();
    }

    public static ToVarcharMapping.ToVarcharMappingBuilder<?, ?> builder() {
        return new ToVarcharMapping.ToVarcharMappingBuilderImpl();
    }

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ToVarcharMapping))
            return false;
        final ToVarcharMapping other = (ToVarcharMapping) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        final java.lang.Object this$nonStringBehaviour = this.getNonStringBehaviour();
        final java.lang.Object other$nonStringBehaviour = other.getNonStringBehaviour();
        if (this$nonStringBehaviour == null ? other$nonStringBehaviour != null
                : !this$nonStringBehaviour.equals(other$nonStringBehaviour))
            return false;
        final java.lang.Object this$overflowBehaviour = this.getOverflowBehaviour();
        final java.lang.Object other$overflowBehaviour = other.getOverflowBehaviour();
        if (this$overflowBehaviour == null ? other$overflowBehaviour != null
                : !this$overflowBehaviour.equals(other$overflowBehaviour))
            return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ToVarcharMapping;
    }

    @java.lang.Override

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final java.lang.Object $nonStringBehaviour = this.getNonStringBehaviour();
        result = result * PRIME + ($nonStringBehaviour == null ? 43 : $nonStringBehaviour.hashCode());
        final java.lang.Object $overflowBehaviour = this.getOverflowBehaviour();
        result = result * PRIME + ($overflowBehaviour == null ? 43 : $overflowBehaviour.hashCode());
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
        return "ToVarcharMapping(super=" + super.toString() + ", nonStringBehaviour=" + this.getNonStringBehaviour()
                + ", overflowBehaviour=" + this.getOverflowBehaviour() + ")";
    }

    public ConvertableMappingErrorBehaviour getNonStringBehaviour() {
        return this.nonStringBehaviour;
    }

    public TruncateableMappingErrorBehaviour getOverflowBehaviour() {
        return this.overflowBehaviour;
    }
}
