
package com.exasol.adapter.document.edml;

import java.util.LinkedHashMap;
import java.util.Map;

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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Fields)) {
            return false;
        }
        final Fields other = (Fields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        return this.getFieldsMap() == null ? other.getFieldsMap() != null
                : !this.getFieldsMap().equals(other.getFieldsMap());
    }

    private boolean canEqual(final Object other) {
        return other instanceof Fields;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = (result * PRIME) + (this.getFieldsMap() == null ? 43 : this.getFieldsMap().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Fields(fields=" + this.getFieldsMap() + ")";
    }
}
