
package com.exasol.adapter.document.edml;

import java.util.LinkedHashMap;

/**
 * Java representation of the {@code fields} object in the EDML.
 */
public class Fields implements MappingDefinition {
    // name is given by EDML
    @SuppressWarnings("java:S1700")
    private final LinkedHashMap<String, MappingDefinition> fields;

    /**
     * Create a builder for {@link Fields}.
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

    public Fields(final LinkedHashMap<String, MappingDefinition> fields) {
        this.fields = fields;
    }

    public LinkedHashMap<String, MappingDefinition> getFields() {
        return this.fields;
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
        final Object this$fields = this.getFields();
        final Object other$fields = other.getFields();
        if (this$fields == null ? other$fields != null : !this$fields.equals(other$fields)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Fields;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $fields = this.getFields();
        result = (result * PRIME) + ($fields == null ? 43 : $fields.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Fields(fields=" + this.getFields() + ")";
    }
}
