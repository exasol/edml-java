
package com.exasol.adapter.document.edml;

/**
 * Abstract base for EDML mappings that map to an Exasol column.
 */
public abstract class AbstractToColumnMapping implements MappingDefinition {
    private static final KeyType DEFAULT_KEY = KeyType.NONE;
    private static final boolean DEFAULT_REQUIRED = false;
    private final String destinationName;
    private final String description;
    private final KeyType key;
    private final boolean required;

    /**
     * Builder for {@link AbstractToColumnMapping}.
     *
     * @param <C> built product type
     * @param <B> builder type
     */
    public abstract static class AbstractToColumnMappingBuilder<C extends AbstractToColumnMapping, B extends AbstractToColumnMappingBuilder<C, B>> {

        private String destinationName;
        private String description;
        private boolean keySet;
        private KeyType keyValue;
        private boolean requiredSet;
        private boolean requiredValue;

        /**
         * Gets the {@code this} pointer for fluent programming.
         * 
         * @return {@code this} pointer
         */
        protected abstract B self();

        /**
         * Build the product.
         * 
         * @return the built product
         */
        public abstract C build();

        /**
         * Set the destination name.
         * 
         * @param destinationName destination name
         * @return {@code this}.
         */
        public B destinationName(final String destinationName) {
            this.destinationName = destinationName;
            return self();
        }

        /**
         * Set the description.
         * 
         * @param description description
         * @return {@code this}.
         */
        public B description(final String description) {
            this.description = description;
            return self();
        }

        /**
         * Set the key type.
         * 
         * @param key key type
         * @return {@code this}.
         */
        public B key(final KeyType key) {
            this.keyValue = key;
            this.keySet = true;
            return self();
        }

        /**
         * Set the required flag.
         * 
         * @param required required
         * @return {@code this}.
         */
        public B required(final boolean required) {
            this.requiredValue = required;
            this.requiredSet = true;
            return self();
        }

        @Override
        public String toString() {
            return "AbstractToColumnMapping.AbstractToColumnMappingBuilder(destinationName=" + this.destinationName
                    + ", description=" + this.description + ", key$value=" + this.keyValue + ", required$value="
                    + this.requiredValue + ")";
        }
    }

    /**
     * Create a new {@link AbstractToColumnMapping}.
     * 
     * @param builder the builder
     */
    protected AbstractToColumnMapping(final AbstractToColumnMapping.AbstractToColumnMappingBuilder<?, ?> builder) {
        this.destinationName = builder.destinationName;
        this.description = builder.description;
        if (builder.keySet) {
            this.key = builder.keyValue;
        } else {
            this.key = DEFAULT_KEY;
        }
        if (builder.requiredSet) {
            this.required = builder.requiredValue;
        } else {
            this.required = DEFAULT_REQUIRED;
        }
    }

    /**
     * Get the destination name.
     * 
     * @return destination name
     */
    public String getDestinationName() {
        return this.destinationName;
    }

    /**
     * Get the description.
     * 
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the key type.
     * 
     * @return key type
     */
    public KeyType getKey() {
        return this.key;
    }

    /**
     * Check if this is a required field.
     * 
     * @return {@code true} if this is a required field
     */
    public boolean isRequired() {
        return this.required;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractToColumnMapping)) {
            return false;
        }
        final AbstractToColumnMapping other = (AbstractToColumnMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isRequired() != other.isRequired()) {
            return false;
        }
        final Object thisDestinationName = this.getDestinationName();
        final Object otherDestinationName = other.getDestinationName();
        if (thisDestinationName == null ? otherDestinationName != null
                : !thisDestinationName.equals(otherDestinationName)) {
            return false;
        }
        final Object thisDescription = this.getDescription();
        final Object otherDescription = other.getDescription();
        if (thisDescription == null ? otherDescription != null : !thisDescription.equals(otherDescription)) {
            return false;
        }
        final Object thisKey = this.getKey();
        final Object otherKey = other.getKey();
        return thisKey == null ? otherKey != null : !thisKey.equals(otherKey);
    }

    boolean canEqual(final Object other) {
        return other instanceof AbstractToColumnMapping;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = (result * PRIME) + (this.isRequired() ? 79 : 97);
        result = (result * PRIME) + (this.getDestinationName() == null ? 43 : this.getDestinationName().hashCode());
        result = (result * PRIME) + (this.getDescription() == null ? 43 : this.getDescription().hashCode());
        result = (result * PRIME) + (this.getKey() == null ? 43 : this.getKey().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AbstractToColumnMapping(destinationName=" + this.getDestinationName() + ", description="
                + this.getDescription() + ", key=" + this.getKey() + ", required=" + this.isRequired() + ")";
    }
}
