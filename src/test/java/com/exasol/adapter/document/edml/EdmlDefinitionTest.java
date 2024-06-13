package com.exasol.adapter.document.edml;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.exasol.adapter.document.edml.EdmlDefinition.EdmlDefinitionBuilder;
import com.exasol.adapter.document.edml.Fields.FieldsBuilder;
import com.exasol.adapter.document.edml.ToBoolMapping.ToBoolMappingBuilderImpl;
import com.exasol.adapter.document.edml.ToDateMapping.ToDateMappingBuilderImpl;
import com.exasol.adapter.document.edml.ToDecimalMapping.ToDecimalMappingBuilderImpl;
import com.exasol.adapter.document.edml.ToDoubleMapping.ToDoubleMappingBuilderImpl;
import com.exasol.adapter.document.edml.ToJsonMapping.ToJsonMappingBuilderImpl;
import com.exasol.adapter.document.edml.ToTableMapping.ToTableMappingBuilder;
import com.exasol.adapter.document.edml.ToTimestampMapping.ToTimestampMappingBuilderImpl;
import com.exasol.adapter.document.edml.ToVarcharMapping.ToVarcharMappingBuilderImpl;
import com.jparams.verifier.tostring.ToStringVerifier;

import nl.jqno.equalsverifier.EqualsVerifier;

class EdmlDefinitionTest {

    static Stream<Arguments> getEdmlClasses() {
        return Stream.of(EdmlDefinition.class, Fields.class, ToBoolMapping.class, ToDecimalMapping.class,
                ToDecimalMapping.class, ToDoubleMapping.class, ToJsonMapping.class, ToTableMapping.class,
                ToTimestampMapping.class, ToVarcharMapping.class).map(Arguments::of);
    }

    static Stream<Arguments> getEdmlBuilderClasses() {
        return Stream.of(EdmlDefinitionBuilder.class, FieldsBuilder.class, ToTableMappingBuilder.class,
                ToTimestampMappingBuilderImpl.class, ToVarcharMappingBuilderImpl.class, ToJsonMappingBuilderImpl.class,
                ToDoubleMappingBuilderImpl.class, ToDecimalMappingBuilderImpl.class, ToDateMappingBuilderImpl.class,
                ToBoolMappingBuilderImpl.class).map(Arguments::of);
    }

    @Test
    void testBuilder() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("myTable")
                .mapping(Fields.builder().mapField("id", ToVarcharMapping.builder().build()).build()).build();
        final Fields fields = (Fields) edmlDefinition.getMapping();
        final ToVarcharMapping idField = (ToVarcharMapping) fields.getFieldsMap().get("id");
        assertAll(//
                () -> assertThat(edmlDefinition.getSource(), equalTo("test")),
                () -> assertThat(edmlDefinition.getDestinationTable(), equalTo("myTable")),
                () -> assertThat("254 is the default value", idField.getVarcharColumnSize(), equalTo(254))//
        );
    }

    @Test
    void testBuilderWithoutMapping() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("myTable")
                .build();
        assertAll(//
                () -> assertThat(edmlDefinition.getSource(), equalTo("test")),
                () -> assertThat(edmlDefinition.getDestinationTable(), equalTo("myTable")),
                () -> assertThat(edmlDefinition.getMapping(), nullValue())//
        );
    }

    @Test
    void testBuilderDefaultAutoInferenceColumnNameMapping() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("myTable")
                .build();
        assertThat(edmlDefinition.getAutoInferenceColumnNames(),
                equalTo(ColumnNameMapping.CONVERT_TO_UPPER_SNAKE_CASE));
    }

    @Test
    void testBuilderCustomAutoInferenceColumnNameMapping() {
        final EdmlDefinition edmlDefinition = EdmlDefinition.builder().source("test").destinationTable("myTable")
                .autoInferenceColumnNames(ColumnNameMapping.KEEP_ORIGINAL_NAME).build();
        assertThat(edmlDefinition.getAutoInferenceColumnNames(), equalTo(ColumnNameMapping.KEEP_ORIGINAL_NAME));
    }

    @ParameterizedTest(name = "equals and hashCode of {0} are correct")
    @MethodSource({ "getEdmlClasses" })
    void testEquals(final Class<?> forClass) {
        EqualsVerifier.simple().forClass(forClass).verify();
    }

    @ParameterizedTest(name = "toString implementation of {0} is correct")
    @MethodSource({ "getEdmlClasses" })
    void testToString(final Class<?> forClass) {
        ToStringVerifier.forClass(forClass).verify();
    }

    @ParameterizedTest(name = "toString implementation of builder {0} is correct")
    @MethodSource({ "getEdmlBuilderClasses" })
    void testBuilderToString(final Class<?> forClass) {
        ToStringVerifier.forClass(forClass).verify();
    }
}
