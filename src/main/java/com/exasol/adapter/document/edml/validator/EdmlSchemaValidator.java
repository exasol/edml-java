package com.exasol.adapter.document.edml.validator;

import static java.util.stream.Collectors.joining;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.leadpony.justify.api.*;

import com.exasol.adapter.document.edml.ExasolDocumentMappingLanguageException;
import com.exasol.errorreporting.ExaError;

import jakarta.json.stream.JsonParser;

/**
 * Validator for mapping definitions using a JSON-schema validator.
 */
public class EdmlSchemaValidator {
    private static final String MAPPING_LANGUAGE_SCHEMA = "schemas/edml-2.0.0.json";
    private final JsonValidationService service;
    private final JsonSchema schema;

    /**
     * Create an instance of {@link EdmlSchemaValidator}.
     */
    public EdmlSchemaValidator() {
        this.service = JsonValidationService.newInstance();
        final ClassLoader classLoader = EdmlSchemaValidator.class.getClassLoader();
        try (final InputStream inputStream = classLoader.getResourceAsStream(MAPPING_LANGUAGE_SCHEMA)) {
            this.schema = this.service.readSchema(inputStream);
        } catch (final IOException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-EDML-22")
                    .message("Internal error (Failed to open EDML-schema from resources).").ticketMitigation()
                    .toString(), exception);
        }
    }

    /**
     * Validates the schema from given file using a JSON-schema validator.
     *
     * @param schemaMappingDefinition schema mapping definition to validate
     * @throws ExasolDocumentMappingLanguageException if schema is violated
     */
    public void validate(final String schemaMappingDefinition) {
        final List<String> validationErrors = getValidationErrors(schemaMappingDefinition);
        if (validationErrors.isEmpty()) {
            return;
        }
        throw new ExasolDocumentMappingLanguageException(
                ExaError.messageBuilder("F-EDML-53").message("Syntax validation error: {{VALIDATION_ERROR|uq}}")
                        .parameter("VALIDATION_ERROR", improveErrorMessages(validationErrors)).toString());
    }

    private String improveErrorMessages(final List<String> validationErrors) {
        return validationErrors.stream().collect(joining(", "));
    }

    private List<String> getValidationErrors(final String schemaMappingDefinition) {
        final ErrorCollector errorCollector = new ErrorCollector();
        final ProblemHandler handler = this.service.createProblemPrinter(errorCollector);
        try (Reader reader = new StringReader(schemaMappingDefinition);
                final JsonParser parser = this.service.createParser(reader, this.schema, handler)) {
            consumeEvents(parser);
            return errorCollector.errors;
        } catch (final IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    private void consumeEvents(final JsonParser parser) {
        while (parser.hasNext()) {
            parser.next();
        }
    }

    private static class ErrorCollector implements Consumer<String> {
        private final List<String> errors = new ArrayList<>();

        @Override
        public void accept(final String message) {
            this.errors.add(message);
        }
    }
}
