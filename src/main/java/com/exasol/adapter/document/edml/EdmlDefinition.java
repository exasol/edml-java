
package com.exasol.adapter.document.edml;

/**
 * Java representation of an EDML definition file.
 */
public class EdmlDefinition {

    private final String source;

    private final String destinationTable;
    private final String description;
    private final boolean addSourceReferenceColumn;

    private final MappingDefinition mapping;
    private final String additionalConfiguration;

    private static String $default$description() {
        return "";
    }

    private static boolean $default$addSourceReferenceColumn() {
        return false;
    }

    private static String $default$additionalConfiguration() {
        return "";
    }

    EdmlDefinition(final String source, final String destinationTable, final String description,
            final boolean addSourceReferenceColumn, final MappingDefinition mapping,
            final String additionalConfiguration) {
        if (source == null) {
            throw new java.lang.NullPointerException("source is marked non-null but is null");
        }
        if (destinationTable == null) {
            throw new java.lang.NullPointerException("destinationTable is marked non-null but is null");
        }
        if (mapping == null) {
            throw new java.lang.NullPointerException("mapping is marked non-null but is null");
        }
        this.source = source;
        this.destinationTable = destinationTable;
        this.description = description;
        this.addSourceReferenceColumn = addSourceReferenceColumn;
        this.mapping = mapping;
        this.additionalConfiguration = additionalConfiguration;
    }

    /**
     * A builder for {@link EdmlDefinition}.
     */
    public static class EdmlDefinitionBuilder {
        private String source;
        private String destinationTable;
        private boolean description$set;
        private String description$value;
        private boolean addSourceReferenceColumn$set;
        private boolean addSourceReferenceColumn$value;
        private MappingDefinition mapping;
        private boolean additionalConfiguration$set;
        private String additionalConfiguration$value;

        EdmlDefinitionBuilder() {
        }

        /**
         * Set the source reference, i.e. the table name or resource identifier.
         * 
         * @param source source reference
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder source(final String source) {
            if (source == null) {
                throw new java.lang.NullPointerException("source is marked non-null but is null");
            }
            this.source = source;
            return this;
        }

        /**
         * @param destinationTable destination table
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder destinationTable(final String destinationTable) {
            if (destinationTable == null) {
                throw new java.lang.NullPointerException("destinationTable is marked non-null but is null");
            }
            this.destinationTable = destinationTable;
            return this;
        }

        /**
         * @param description description
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder description(final String description) {
            this.description$value = description;
            this.description$set = true;
            return this;
        }

        /**
         * Define if a source reference column should be added. If set to {@code true}, this adapter adds the source
         * reference as a column named {@code SOURCE_REFERENCE} to the Exasol table.
         * <p>
         * This feature is mainly useful if multiple sources are used (not supported by all dialects). In that case you
         * can filter on the source name.
         * 
         * @param addSourceReferenceColumn {@code true} if a source reference column should be added
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder addSourceReferenceColumn(final boolean addSourceReferenceColumn) {
            this.addSourceReferenceColumn$value = addSourceReferenceColumn;
            this.addSourceReferenceColumn$set = true;
            return this;
        }

        /**
         * Defines the mapping for the document's properties. Typically you want to define {@code fields} here to define
         * mappings for this document's properties. But you can also use {@code toJsonMapping} mapping here. In that
         * case the whole document is mapped to a JSON string.
         * 
         * @param mapping mapping
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder mapping(final MappingDefinition mapping) {
            if (mapping == null) {
                throw new java.lang.NullPointerException("mapping is marked non-null but is null");
            }
            this.mapping = mapping;
            return this;
        }

        /**
         * Set the optional additional configuration options.
         * 
         * @param additionalConfiguration additional configuration
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder additionalConfiguration(final String additionalConfiguration) {
            this.additionalConfiguration$value = additionalConfiguration;
            this.additionalConfiguration$set = true;
            return this;
        }

        /**
         * Build a new {@link EdmlDefinition}.
         * 
         * @return a new {@link EdmlDefinition}
         */
        public EdmlDefinition build() {
            String description = this.description$value;
            if (!this.description$set) {
                description = EdmlDefinition.$default$description();
            }
            boolean addSourceReferenceColumn = this.addSourceReferenceColumn$value;
            if (!this.addSourceReferenceColumn$set) {
                addSourceReferenceColumn = EdmlDefinition.$default$addSourceReferenceColumn();
            }
            String additionalConfiguration = this.additionalConfiguration$value;
            if (!this.additionalConfiguration$set) {
                additionalConfiguration = EdmlDefinition.$default$additionalConfiguration();
            }
            return new EdmlDefinition(this.source, this.destinationTable, description, addSourceReferenceColumn,
                    this.mapping, additionalConfiguration);
        }

        @Override
        public String toString() {
            return "EdmlDefinition.EdmlDefinitionBuilder(source=" + this.source + ", destinationTable="
                    + this.destinationTable + ", description$value=" + this.description$value
                    + ", addSourceReferenceColumn$value=" + this.addSourceReferenceColumn$value + ", mapping="
                    + this.mapping + ", additionalConfiguration$value=" + this.additionalConfiguration$value + ")";
        }
    }

    /**
     * Create a new builder for {@link EdmlDefinition}.
     * 
     * @return a new builder for {@link EdmlDefinition}
     */
    public static EdmlDefinition.EdmlDefinitionBuilder builder() {
        return new EdmlDefinition.EdmlDefinitionBuilder();
    }

    /**
     * Get the source reference, i.e. the table name or resource identifier.
     * 
     * @return the source reference
     */
    public String getSource() {
        return this.source;
    }

    /**
     * Get the name of the destination table in Exasol Virtual Schema.
     * 
     * @return destination table
     */
    public String getDestinationTable() {
        return this.destinationTable;
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
     * Check if a source reference column should be added. If set to {@code true}, this adapter adds the source
     * reference as a column named {@code SOURCE_REFERENCE} to the Exasol table.
     * <p>
     * This feature is mainly useful if multiple sources are used (not supported by all dialects). In that case you can
     * filter on the source name.
     * 
     * @return {@code true} if a source reference should be added.
     */
    public boolean isAddSourceReferenceColumn() {
        return this.addSourceReferenceColumn;
    }

    /**
     * Get the mapping for the document's properties. Typically you want to define {@code fields} here to define
     * mappings for this document's properties. But you can also use {@code toJsonMapping} mapping here. In that case
     * the whole document is mapped to a JSON string.
     * 
     * @return the mapping
     */
    public MappingDefinition getMapping() {
        return this.mapping;
    }

    /**
     * Get the optional additional configuration options.
     * 
     * @return additional configuration
     */
    public String getAdditionalConfiguration() {
        return this.additionalConfiguration;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EdmlDefinition)) {
            return false;
        }
        final EdmlDefinition other = (EdmlDefinition) o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isAddSourceReferenceColumn() != other.isAddSourceReferenceColumn()) {
            return false;
        }
        final Object this$source = this.getSource();
        final Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        final Object this$destinationTable = this.getDestinationTable();
        final Object other$destinationTable = other.getDestinationTable();
        if (this$destinationTable == null ? other$destinationTable != null
                : !this$destinationTable.equals(other$destinationTable)) {
            return false;
        }
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        final Object this$mapping = this.getMapping();
        final Object other$mapping = other.getMapping();
        if (this$mapping == null ? other$mapping != null : !this$mapping.equals(other$mapping)) {
            return false;
        }
        final Object this$additionalConfiguration = this.getAdditionalConfiguration();
        final Object other$additionalConfiguration = other.getAdditionalConfiguration();
        if (this$additionalConfiguration == null ? other$additionalConfiguration != null
                : !this$additionalConfiguration.equals(other$additionalConfiguration)) {
            return false;
        }
        return true;
    }

    private boolean canEqual(final Object other) {
        return other instanceof EdmlDefinition;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = (result * PRIME) + (this.isAddSourceReferenceColumn() ? 79 : 97);
        final Object $source = this.getSource();
        result = (result * PRIME) + ($source == null ? 43 : $source.hashCode());
        final Object $destinationTable = this.getDestinationTable();
        result = (result * PRIME) + ($destinationTable == null ? 43 : $destinationTable.hashCode());
        final Object $description = this.getDescription();
        result = (result * PRIME) + ($description == null ? 43 : $description.hashCode());
        final Object $mapping = this.getMapping();
        result = (result * PRIME) + ($mapping == null ? 43 : $mapping.hashCode());
        final Object $additionalConfiguration = this.getAdditionalConfiguration();
        result = (result * PRIME) + ($additionalConfiguration == null ? 43 : $additionalConfiguration.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EdmlDefinition(source=" + this.getSource() + ", destinationTable=" + this.getDestinationTable()
                + ", description=" + this.getDescription() + ", addSourceReferenceColumn="
                + this.isAddSourceReferenceColumn() + ", mapping=" + this.getMapping() + ", additionalConfiguration="
                + this.getAdditionalConfiguration() + ")";
    }
}
