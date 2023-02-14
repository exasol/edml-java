package com.exasol.adapter.document.edml.validator;

import static com.exasol.adapter.document.edml.MappingTestFiles.*;
import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.document.edml.ExasolDocumentMappingLanguageException;

class EdmlSchemaValidatorTest {
    private static final Logger LOGGER = Logger.getLogger(EdmlSchemaValidatorTest.class.getSimpleName());

    private void runValidationWithResource(final String resource) throws IOException {
        final String schema = new String(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(resource)).readAllBytes(),
                StandardCharsets.UTF_8);
        runValidation(schema);
    }

    private void runValidation(final String schema) {
        try {
            new EdmlSchemaValidator().validate(schema);
        } catch (final IllegalArgumentException exception) {
            LOGGER.info(exception.getMessage());
            throw exception;
        }
    }

    @Test
    void testValidBasicMapping() throws IOException {
        runValidationWithResource(BASIC_MAPPING);
    }

    @Test
    void testValidToJsonMapping() throws IOException {
        runValidationWithResource(TO_JSON_MAPPING);
    }

    @Test
    void testValidSingleColumnToTableMapping() throws IOException {
        runValidationWithResource(SINGLE_COLUMN_TO_TABLE_MAPPING);
    }

    @Test
    void testValidMultiColumnToTableMapping() throws IOException {
        runValidationWithResource(MULTI_COLUMN_TO_TABLE_MAPPING);
    }

    @Test
    void testValidWholeTableToJsonMapping() throws IOException {
        runValidationWithResource(WHOLE_TABLE_TO_TABLE_MAPPING);
    }

    private void testInvalidContent(final List<String> invalidMappingLines, final Matcher<String> messageMatcher) {
        testInvalidContent(invalidMappingLines.stream().collect(joining("\n")), messageMatcher);
    }

    private void testInvalidContent(final String invalidMapping, final Matcher<String> messageMatcher) {
        final ExasolDocumentMappingLanguageException exception = assertThrows(
                ExasolDocumentMappingLanguageException.class, () -> runValidation(invalidMapping));
        assertThat(exception.getMessage(), messageMatcher);
    }

    @Test
    void testInvalidNoDestName() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.2.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true,", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"isbn\": {", //
                "        \"toVarcharMapping\": {", //
                "          \"varcharColumnSize\": 20,", //
                "          \"description\": \"The isbn is mapped to a string with max length of 20\",", //
                "          \"overflowBehaviour\": \"ABORT\",", //
                "          \"required\": true,", //
                "          \"key\": \"global\"", //
                "        }", //
                "      }", //
                "    }", //
                "  }", //
                "}"),
                equalTo("F-EDML-53: Syntax validation error: [19,1][] The object must have a property whose name is \"destinationTable\"."));
    }

    @Test
    void testInvalidNoSchemaSet() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true,", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"isbn\": {", //
                "        \"toVarcharMapping\": {", //
                "          \"varcharColumnSize\": 20,", //
                "          \"description\": \"The isbn is mapped to a string with max length of 20\",", //
                "          \"overflowBehaviour\": \"ABORT\",", //
                "          \"required\": true,", //
                "          \"key\": \"global\"", //
                "        }", //
                "      }", //
                "    }", //
                "  }", //
                "}"),
                equalTo("F-EDML-53: Syntax validation error: [19,1][] The object must have a property whose name is \"$schema\"."));
    }

    @Test
    void testInvalidWrongSchemaSet() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"invalidSchema\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true,", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"isbn\": {", //
                "        \"toVarcharMapping\": {", //
                "          \"varcharColumnSize\": 20,", //
                "          \"description\": \"The isbn is mapped to a string with max length of 20\",", //
                "          \"overflowBehaviour\": \"ABORT\",", //
                "          \"required\": true,", //
                "          \"key\": \"global\"", //
                "        }", //
                "      }", //
                "    }", //
                "  }", //
                "}"), startsWith("F-EDML-53: Syntax validation error: [2,28][/$schema] The value must be one of ["));
    }

    @Test
    void testInvalidUnknownRootProperty() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"unknownProperty\": \"someValue\",", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.2.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true,", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"isbn\": {", //
                "        \"toVarcharMapping\": {", //
                "          \"varcharColumnSize\": 20,", //
                "          \"description\": \"The isbn is mapped to a string with max length of 20\",", //
                "          \"overflowBehaviour\": \"ABORT\",", //
                "          \"required\": true,", //
                "          \"key\": \"global\"", //
                "        }", //
                "      }", //
                "    }", //
                "  }", //
                "}"),
                equalTo("F-EDML-53: Syntax validation error: [2,32][/unknownProperty] The object must not have a property whose name is \"unknownProperty\"."));
    }

    @Test
    void testInvalidUnknownMappingType() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.2.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true,", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"isbn\": {", //
                "        \"toStriiiiiiingMapping\": {}", //
                "      }", //
                "    }", //
                "  }", //
                "}"),
                equalTo("F-EDML-53: Syntax validation error: [10,34][/mapping/fields/isbn/toStriiiiiiingMapping] The object must not have a property whose name is \"toStriiiiiiingMapping\"."));
    }

    @Test
    void testInvalidUnknownMappingInToTable() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.0.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"chapters\": {", //
                "        \"toTableMapping\": {", //
                "          \"mapping\": {", //
                "            \"toStriiiiingMapping\": {}", //
                "          }", //
                "        }", //
                "      }", //
                "    }", //
                "  }", //
                "}"),
                startsWith(
                        "F-EDML-53: Syntax validation error: [11,36][/mapping/fields/chapters/toTableMapping/mapping/toStriiiiingMapping] The object must not have a property whose name is \"toStriiiiingMapping\"."));
    }

    @Test
    void testInvalidToTableWithNoFields() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.0.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"chapters\": {", //
                "        \"toTableMapping\": {", //
                "        }", //
                "      }", //
                "    }", //
                "  }", //
                "}"),
                startsWith(
                        "F-EDML-53: Syntax validation error: [10,9][/mapping/fields/chapters/toTableMapping] The object must have a property whose name is \"mapping\"."));
    }

    @Test
    void testInvalidKeyValue() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.2.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true,", //
                "  \"mapping\": {", //
                "    \"fields\": {", //
                "      \"isbn\": {", //
                "        \"toVarcharMapping\": {", //
                "          \"varcharColumnSize\": 20,", //
                "          \"description\": \"The isbn is mapped to a string with max length of 20\",", //
                "          \"overflowBehaviour\": \"ABORT\",", //
                "          \"required\": true,", //
                "          \"key\": \"\"", //
                "        }", //
                "      }", //
                "    }", //
                "  }", //
                "}" //

        ), equalTo(
                "F-EDML-53: Syntax validation error: [15,19][/mapping/fields/isbn/toVarcharMapping/key] The value must be one of [\"local\", \"global\", \"none\"]."));
    }

    @Test
    void testInvalidNoMapping() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.2.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true", //
                "}" //

        ), equalTo(
                "F-EDML-53: Syntax validation error: [7,1][] The object must have a property whose name is \"mapping\"."));
    }

    @Test
    void testInvalidNoFields() throws IOException {
        testInvalidContent(List.of("{", //
                "  \"$schema\": \"../../main/resources/schemas/edml-1.2.0.json\",", //
                "  \"source\": \"MY_BOOKS\",", //
                "  \"destinationTable\": \"BOOKS\",", //
                "  \"description\": \"Maps MY_BOOKS to BOOKS\",", //
                "  \"addSourceReferenceColumn\": true,", //
                "  \"mapping\": {}", //
                "}"),
                startsWith(
                        "F-EDML-53: Syntax validation error: [7,15][/mapping] The object must have at least 1 property(ies), but actual number is 0."));
    }
}
