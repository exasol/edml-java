
package com.exasol.adapter.document.edml;

import java.util.Objects;

/**
 * Java representation of an EDML definition file.
 */
public class EdmlDefinition {

    private static final String DEFAULT_DESCRIPTION = "";
    private static final String DEFAULT_ADDITIONAL_CONFIGURATION = "";
    private static final boolean DEFAULT_ADD_SOURCE_COLUMN = false;
    private static final ColumnNameMapping DEFAULT_AUTO_INFERENCE_COLUMN_NAME_MAPPING = ColumnNameMapping.CONVERT_TO_UPPER_SNAKE_CASE;

    private final String source;

    private final String destinationTable;
    private final String description;
    private final boolean addSourceReferenceColumn;

    private final MappingDefinition mapping;
    private final ColumnNameMapping autoInferenceColumnNames;
    private final String additionalConfiguration;

    private EdmlDefinition(final EdmlDefinitionBuilder builder) {
        this.source = Objects.requireNonNull(builder.source, "source");
        this.destinationTable = Objects.requireNonNull(builder.destinationTable, "destinationTable");
        this.description = builder.description;
        this.addSourceReferenceColumn = builder.addSourceReferenceColumn;
        this.mapping = builder.mapping;
        this.autoInferenceColumnNames = builder.autoInferenceColumnNames;
        this.additionalConfiguration = builder.additionalConfiguration;
    }

    /**
     * A builder for {@link EdmlDefinition}.
     */
    public static class EdmlDefinitionBuilder {
        private String source;
        private String destinationTable;
        private String description = DEFAULT_DESCRIPTION;
        private boolean addSourceReferenceColumn = DEFAULT_ADD_SOURCE_COLUMN;
        private MappingDefinition mapping;
        private ColumnNameMapping autoInferenceColumnNames = DEFAULT_AUTO_INFERENCE_COLUMN_NAME_MAPPING;
        private String additionalConfiguration = DEFAULT_ADDITIONAL_CONFIGURATION;

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
            this.description = description;
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
            this.addSourceReferenceColumn = addSourceReferenceColumn;
            return this;
        }

        /**
         * Defines the mapping for the document's properties. Typically you want to define {@code fields} here to define
         * mappings for this document's properties. But you can also use {@code toJsonMapping} mapping here. In that
         * case the whole document is mapped to a JSON string.
         * <p>
         * Omit the {@code mapping} to enable auto-inference.
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
         * Set the column name mapping for auto-inference.
         * <p>
         * Only specify this when {@code mapping} is omitted.
         * 
         * @param autoInferenceColumnNames column name mapping
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder autoInferenceColumnNames(
                final ColumnNameMapping autoInferenceColumnNames) {
            this.autoInferenceColumnNames = Objects.requireNonNull(autoInferenceColumnNames,
                    "autoInferenceColumnNames");
            return this;
        }

        /**
         * Set the optional additional configuration options.
         *
         * @param additionalConfiguration additional configuration
         * @return {@code this}.
         */
        public EdmlDefinition.EdmlDefinitionBuilder additionalConfiguration(final String additionalConfiguration) {
            this.additionalConfiguration = additionalConfiguration;
            return this;
        }

        /**
         * Build a new {@link EdmlDefinition}.
         *
         * @return a new {@link EdmlDefinition}
         */
        public EdmlDefinition build() {
            return new EdmlDefinition(this);
        }

        @Override
        public String toString() {
            return "EdmlDefinition.EdmlDefinitionBuilder(source=" + this.source + ", destinationTable="
                    + this.destinationTable + ", description=" + this.description + ", addSourceReferenceColumn="
                    + this.addSourceReferenceColumn + ", mapping=" + this.mapping + ", autoInferenceColumnNames="
                    + autoInferenceColumnNames + ", additionalConfiguration=" + this.additionalConfiguration + ")";
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
     * <p>
     * You can omit the {@code mapping} element to enable auto-inference.
     *
     * @return the mapping
     */
    public MappingDefinition getMapping() {
        return this.mapping;
    }

    /**
     * Get the column name mapping for auto-inference.
     * <p>
     * Only specify this when {@code mapping} is omitted.
     * 
     * @return column name mapping
     */
    public ColumnNameMapping getAutoInferenceColumnNames() {
        return this.autoInferenceColumnNames;
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
        return Objects.hash(this.source, this.destinationTable, this.description, this.addSourceReferenceColumn,
                this.mapping, this.autoInferenceColumnNames, this.additionalConfiguration);
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
        return Objects.equals(this.source, other.source)
                && Objects.equals(this.destinationTable, other.destinationTable)
                && Objects.equals(this.description, other.description)
                && (this.addSourceReferenceColumn == other.addSourceReferenceColumn)
                && Objects.equals(this.mapping, other.mapping)
                && Objects.equals(this.autoInferenceColumnNames, other.autoInferenceColumnNames)
                && Objects.equals(this.additionalConfiguration, other.additionalConfiguration);
    }

    @Override
    public String toString() {
        return "EdmlDefinition(source=" + this.getSource() + ", destinationTable=" + this.getDestinationTable()
                + ", description=" + this.getDescription() + ", addSourceReferenceColumn="
                + this.isAddSourceReferenceColumn() + ", mapping=" + this.getMapping() + ", autoInferenceColumnNames="
                + autoInferenceColumnNames + ", additionalConfiguration=" + this.getAdditionalConfiguration() + ")";
    }
}
