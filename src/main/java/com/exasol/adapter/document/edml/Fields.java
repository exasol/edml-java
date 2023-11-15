
package com.exasol.adapter.document.edml;

import java.util.*;

/**
 * Java representation of the {@code fields} object in the EDML. This definition defines the expected nested properties
 * of the current property. For each of the nested properties you can again define a mapping. You only need to define
 * the properties you want to map.
 */
public class Fields implements MappingDefinition {
    private final LinkedHashMap<String, MappingDefinition> fieldsMap;

    /**
     * Create a new builder for {@link Fields}.
     *
     * @return {@link FieldsBuilder}
     */
    public static FieldsBuilder builder() {
        return new FieldsBuilder();
    }

    @Override
    public void accept(final MappingDefinitionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builder for {@link Fields}.
     */
    public static class FieldsBuilder {
        private final LinkedHashMap<String, MappingDefinition> fields = new LinkedHashMap<>();

        /**
         * Add a field mapping.
         *
         * @param fieldName    name of the property in the document
         * @param fieldMapping {@link MappingDefinition}
         * @return self for fluent programming
         */
        public FieldsBuilder mapField(final String fieldName, final MappingDefinition fieldMapping) {
            this.fields.put(fieldName, fieldMapping);
            return this;
        }

        /**
         * Build the {@link Fields}.
         *
         * @return built {@link Fields}
         */
        public Fields build() {
            return new Fields(this.fields);
        }
    }

    private Fields(final LinkedHashMap<String, MappingDefinition> fields) {
        this.fieldsMap = fields;
    }

    /**
     * Get the fields.
     *
     * @return fields
     */
    public Map<String, MappingDefinition> getFieldsMap() {
        return this.fieldsMap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fieldsMap);
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
        final Fields other = (Fields) obj;
        return Objects.equals(this.fieldsMap, other.fieldsMap);
    }

    @Override
    public String toString() {
        return "Fields(fieldsMap=" + this.getFieldsMap() + ")";
    }
}
