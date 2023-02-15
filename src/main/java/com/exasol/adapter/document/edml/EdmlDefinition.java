
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of an EDML definition file.
 */
public class EdmlDefinition {

    private static final String DEFAULT_DESCRIPTION = "";
    private static final String DEFAULT_ADDITIONAL_CONFIGURATION = "";
    private static final boolean DEFAULT_ADD_SOURCE_COLUMN = false;

    private final String source;

    private final String destinationTable;
    private final String description;
    private final boolean addSourceReferenceColumn;

    private final MappingDefinition mapping;
    private final String additionalConfiguration;

    EdmlDefinition(final String source, final String destinationTable, final String description,
            final boolean addSourceReferenceColumn, final MappingDefinition mapping,
            final String additionalConfiguration) {
        if (source == null) {
            throw new NullPointerException("source is marked non-null but is null");
        }
        if (destinationTable == null) {
            throw new NullPointerException("destinationTable is marked non-null but is null");
        }
        if (mapping == null) {
            throw new NullPointerException("mapping is marked non-null but is null");
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
        private boolean descriptionSet;
        private String descriptionValue;
        private boolean addSourceReferenceColumnSet;
        private boolean addSourceReferenceColumnValue;
        private MappingDefinition mapping;
        private boolean additionalConfigurationSet;
        private String additionalConfigurationValue;

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
                throw new NullPointerException("source is marked non-null but is null");
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
                throw new NullPointerException("destinationTable is marked non-null but is null");
            }
            this.destinationTable = destinationTable;
            return this;
        }

        /**
         * @param description description
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder description(final String description) {
            this.descriptionValue = description;
            this.descriptionSet = true;
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
            this.addSourceReferenceColumnValue = addSourceReferenceColumn;
            this.addSourceReferenceColumnSet = true;
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
                throw new NullPointerException("mapping is marked non-null but is null");
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
            this.additionalConfigurationValue = additionalConfiguration;
            this.additionalConfigurationSet = true;
            return this;
        }

        /**
         * Build a new {@link EdmlDefinition}.
         * 
         * @return a new {@link EdmlDefinition}
         */
        public EdmlDefinition build() {
            String description = this.descriptionValue;
            if (!this.descriptionSet) {
                description = DEFAULT_DESCRIPTION;
            }
            boolean addSourceReferenceColumn = this.addSourceReferenceColumnValue;
            if (!this.addSourceReferenceColumnSet) {
                addSourceReferenceColumn = DEFAULT_ADD_SOURCE_COLUMN;
            }
            String additionalConfiguration = this.additionalConfigurationValue;
            if (!this.additionalConfigurationSet) {
                additionalConfiguration = DEFAULT_ADDITIONAL_CONFIGURATION;
            }
            return new EdmlDefinition(this.source, this.destinationTable, description, addSourceReferenceColumn,
                    this.mapping, additionalConfiguration);
        }

        @Override
        public String toString() {
            return "EdmlDefinition.EdmlDefinitionBuilder(source=" + this.source + ", destinationTable="
                    + this.destinationTable + ", descriptionValue=" + this.descriptionValue
                    + ", addSourceReferenceColumnValue=" + this.addSourceReferenceColumnValue + ", mapping="
                    + this.mapping + ", additionalConfigurationValue=" + this.additionalConfigurationValue + ")";
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
    public int hashCode() {
        return Objects.hash(source, destinationTable, description, addSourceReferenceColumn, mapping,
                additionalConfiguration);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EdmlDefinition other = (EdmlDefinition) obj;
        return Objects.equals(source, other.source) && Objects.equals(destinationTable, other.destinationTable)
                && Objects.equals(description, other.description)
                && addSourceReferenceColumn == other.addSourceReferenceColumn && Objects.equals(mapping, other.mapping)
                && Objects.equals(additionalConfiguration, other.additionalConfiguration);
    }

    @Override
    public String toString() {
        return "EdmlDefinition(source=" + this.getSource() + ", destinationTable=" + this.getDestinationTable()
                + ", description=" + this.getDescription() + ", addSourceReferenceColumn="
                + this.isAddSourceReferenceColumn() + ", mapping=" + this.getMapping() + ", additionalConfiguration="
                + this.getAdditionalConfiguration() + ")";
    }
}
