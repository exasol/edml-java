// Generated by delombok at Tue Feb 14 11:27:09 CET 2023
package com.exasol.adapter.document.edml;

import lombok.Builder;
// sonar can't deal with Lombok
/**
 * Abstract base for EDML mappings that map to an Exasol column.
 */
@SuppressWarnings("java:S1170")
public abstract class AbstractToColumnMapping implements MappingDefinition {
    private final String destinationName;
    private final String description;
    private final KeyType key;
    private final boolean required;

    // class generated by lombok
    /**
     * Builder class. The content of the builder is generated by lombok. We need this class declared here since the
     * Javadoc generation fails otherwise.
     *
     * @param <C> type used by lombok
     * @param <B> type used by lombok
     */
    @SuppressWarnings("java:S1610")
    public static abstract class AbstractToColumnMappingBuilder<C extends AbstractToColumnMapping, B extends AbstractToColumnMappingBuilder<C, B>> {
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private String destinationName;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private String description;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private boolean key$set;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private KeyType key$value;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private boolean required$set;
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        private boolean required$value;

        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        protected abstract B self();

        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public abstract C build();

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public B destinationName(final String destinationName) {
            this.destinationName = destinationName;
            return self();
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public B description(final String description) {
            this.description = description;
            return self();
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public B key(final KeyType key) {
            this.key$value = key;
            key$set = true;
            return self();
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public B required(final boolean required) {
            this.required$value = required;
            required$set = true;
            return self();
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @lombok.Generated
        public java.lang.String toString() {
            return "AbstractToColumnMapping.AbstractToColumnMappingBuilder(destinationName=" + this.destinationName + ", description=" + this.description + ", key$value=" + this.key$value + ", required$value=" + this.required$value + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    private static KeyType $default$key() {
        return KeyType.NONE;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    private static boolean $default$required() {
        return false;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    protected AbstractToColumnMapping(final AbstractToColumnMapping.AbstractToColumnMappingBuilder<?, ?> b) {
        this.destinationName = b.destinationName;
        this.description = b.description;
        if (b.key$set) this.key = b.key$value;
         else this.key = AbstractToColumnMapping.$default$key();
        if (b.required$set) this.required = b.required$value;
         else this.required = AbstractToColumnMapping.$default$required();
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public String getDestinationName() {
        return this.destinationName;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public String getDescription() {
        return this.description;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public KeyType getKey() {
        return this.key;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public boolean isRequired() {
        return this.required;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof AbstractToColumnMapping)) return false;
        final AbstractToColumnMapping other = (AbstractToColumnMapping) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (this.isRequired() != other.isRequired()) return false;
        final java.lang.Object this$destinationName = this.getDestinationName();
        final java.lang.Object other$destinationName = other.getDestinationName();
        if (this$destinationName == null ? other$destinationName != null : !this$destinationName.equals(other$destinationName)) return false;
        final java.lang.Object this$description = this.getDescription();
        final java.lang.Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) return false;
        final java.lang.Object this$key = this.getKey();
        final java.lang.Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof AbstractToColumnMapping;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.isRequired() ? 79 : 97);
        final java.lang.Object $destinationName = this.getDestinationName();
        result = result * PRIME + ($destinationName == null ? 43 : $destinationName.hashCode());
        final java.lang.Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final java.lang.Object $key = this.getKey();
        result = result * PRIME + ($key == null ? 43 : $key.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @lombok.Generated
    public java.lang.String toString() {
        return "AbstractToColumnMapping(destinationName=" + this.getDestinationName() + ", description=" + this.getDescription() + ", key=" + this.getKey() + ", required=" + this.isRequired() + ")";
    }
}
