
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

    @java.lang.Override

    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fields))
            return false;
        final Fields other = (Fields) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        final java.lang.Object this$fields = this.getFields();
        final java.lang.Object other$fields = other.getFields();
        if (this$fields == null ? other$fields != null : !this$fields.equals(other$fields))
            return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Fields;
    }

    @java.lang.Override

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $fields = this.getFields();
        result = result * PRIME + ($fields == null ? 43 : $fields.hashCode());
        return result;
    }

    @java.lang.Override

    public java.lang.String toString() {
        return "Fields(fields=" + this.getFields() + ")";
    }
}
