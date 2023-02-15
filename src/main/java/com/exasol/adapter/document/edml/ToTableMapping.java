
package com.exasol.adapter.document.edml;

/**
 * Java representation of the EDML {@code toTableMapping}. This mapping is used for normalizing documents to table
 * structures. It creates a new table in the resulting virtual schema named: {@code <NAME_OF_PARENT>_<GIVEN_NAME>}.
 * <p>
 * You can define the columns of this table using the mapping property. If the parent table defines a key using one or
 * more {@code toVarcharMappings} for a key or secondary index in the document database, this will be used as foreign
 * key.
 */
public final class ToTableMapping implements MappingDefinition {
    private final String destinationTable;
    private final MappingDefinition mapping;
    private final String description;

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    private static String $default$description() {
        return "";
    }

    private ToTableMapping(final String destinationTable, final MappingDefinition mapping, final String description) {
        if (mapping == null) {
            throw new java.lang.NullPointerException("mapping is marked non-null but is null");
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
        private boolean description$set;
        private String description$value;

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
                throw new java.lang.NullPointerException("mapping is marked non-null but is null");
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
            this.description$value = description;
            this.description$set = true;
            return this;
        }

        /**
         * Build a new {@link ToTableMapping}.
         * 
         * @return the built {@link ToTableMapping}
         */
        public ToTableMapping build() {
            String description = this.description$value;
            if (!this.description$set) {
                description = ToTableMapping.$default$description();
            }
            return new ToTableMapping(this.destinationTable, this.mapping, description);
        }

        @Override
        public String toString() {
            return "ToTableMapping.ToTableMappingBuilder(destinationTable=" + this.destinationTable + ", mapping="
                    + this.mapping + ", description$value=" + this.description$value + ")";
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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToTableMapping)) {
            return false;
        }
        final ToTableMapping other = (ToTableMapping) o;
        final Object this$destinationTable = this.getDestinationTable();
        final Object other$destinationTable = other.getDestinationTable();
        if (this$destinationTable == null ? other$destinationTable != null
                : !this$destinationTable.equals(other$destinationTable)) {
            return false;
        }
        final Object this$mapping = this.getMapping();
        final Object other$mapping = other.getMapping();
        if (this$mapping == null ? other$mapping != null : !this$mapping.equals(other$mapping)) {
            return false;
        }
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $destinationTable = this.getDestinationTable();
        result = (result * PRIME) + ($destinationTable == null ? 43 : $destinationTable.hashCode());
        final Object $mapping = this.getMapping();
        result = (result * PRIME) + ($mapping == null ? 43 : $mapping.hashCode());
        final Object $description = this.getDescription();
        result = (result * PRIME) + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ToTableMapping(destinationTable=" + this.getDestinationTable() + ", mapping=" + this.getMapping()
                + ", description=" + this.getDescription() + ")";
    }
}
