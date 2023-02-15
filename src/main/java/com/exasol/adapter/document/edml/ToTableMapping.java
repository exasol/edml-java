
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of the EDML {@code toTableMapping}. This mapping is used for normalizing documents to table
 * structures. It creates a new table in the resulting virtual schema named: {@code <NAME_OF_PARENT>_<GIVEN_NAME>}.
 * <p>
 * You can define the columns of this table using the mapping property. If the parent table defines a key using one or
 * more {@code toVarcharMappings} for a key or secondary index in the document database, this will be used as foreign
 * key.
 */
public final class ToTableMapping implements MappingDefinition {
    private static final String DEFAULT_DESCRIPTION = "";

    private final String destinationTable;
    private final MappingDefinition mapping;
    private final String description;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private ToTableMapping(final String destinationTable, final MappingDefinition mapping, final String description) {
        if (mapping == null) {
            throw new NullPointerException("mapping is marked non-null but is null");
        }
        this.destinationTable = destinationTable;
        this.mapping = mapping;
        this.description = description;
    }

    /**
     * Builder for {@link ToTableMapping}.
     */
    public static class ToTableMappingBuilder {
        private String destinationTable;
        private MappingDefinition mapping;
        private boolean descriptionSet;
        private String descriptionValue;

        ToTableMappingBuilder() {
        }

        /**
         * @param destinationTable destination table
         * @return {@code this}.
         */
        public ToTableMapping.ToTableMappingBuilder destinationTable(final String destinationTable) {
            this.destinationTable = destinationTable;
            return this;
        }

        /**
         * Defines the mapping for the columns of the new table. If the document list contains non-objects (like
         * strings) here, you can directly use {@code toVarcharMapping} here. Otherwise, if the list contains objects,
         * you can define mappings for the nested properties using {@code fields}.
         * 
         * @param mapping mapping
         * @return {@code this}.
         */
        public ToTableMapping.ToTableMappingBuilder mapping(final MappingDefinition mapping) {
            if (mapping == null) {
                throw new NullPointerException("mapping is marked non-null but is null");
            }
            this.mapping = mapping;
            return this;
        }

        /**
         * Set the optional description. Using this property you can provide documentation.
         * 
         * @param description description
         * @return {@code this}.
         */
        public ToTableMapping.ToTableMappingBuilder description(final String description) {
            this.descriptionValue = description;
            this.descriptionSet = true;
            return this;
        }

        /**
         * Build a new {@link ToTableMapping}.
         * 
         * @return the built {@link ToTableMapping}
         */
        public ToTableMapping build() {
            String description = this.descriptionValue;
            if (!this.descriptionSet) {
                description = DEFAULT_DESCRIPTION;
            }
            return new ToTableMapping(this.destinationTable, this.mapping, description);
        }

        @Override
        public String toString() {
            return "ToTableMapping.ToTableMappingBuilder(destinationTable=" + this.destinationTable + ", mapping="
                    + this.mapping + ", description$value=" + this.descriptionValue + ")";
        }
    }

    /**
     * Create a new builder for {@link ToTableMapping}.
     * 
     * @return a new builder for {@link ToTableMapping}
     */
    public static ToTableMapping.ToTableMappingBuilder builder() {
        return new ToTableMapping.ToTableMappingBuilder();
    }

    /**
     * Get the destination table.
     * 
     * @return destination table
     */
    public String getDestinationTable() {
        return this.destinationTable;
    }

    /**
     * Get the mapping for the columns of the new table. If the document list contains non-objects (like strings) here,
     * you can directly use {@code toVarcharMapping} here. Otherwise, if the list contains objects, you can define
     * mappings for the nested properties using {@code fields}.
     * 
     * @return mapping
     */
    public MappingDefinition getMapping() {
        return this.mapping;
    }

    /**
     * Get the optional description. Using this property you can provide documentation.
     * 
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationTable, mapping, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ToTableMapping other = (ToTableMapping) obj;
        return Objects.equals(destinationTable, other.destinationTable) && Objects.equals(mapping, other.mapping)
                && Objects.equals(description, other.description);
    }

    @Override
    public String toString() {
        return "ToTableMapping(destinationTable=" + this.getDestinationTable() + ", mapping=" + this.getMapping()
                + ", description=" + this.getDescription() + ")";
    }
}
