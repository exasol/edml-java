package com.exasol.adapter.document.edml.validator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.Validator;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.exasol.adapter.document.edml.ExasolDocumentMappingLanguageException;
import com.exasol.adapter.document.edml.validator.messageimprover.NoMappingExceptionMessageImprover;
import com.exasol.adapter.document.edml.validator.messageimprover.UnknownKeyTypeExceptionMessageImprover;
import com.exasol.adapter.document.edml.validator.messageimprover.UnknownMappingExceptionMessageImprover;
import com.exasol.adapter.document.edml.validator.messageimprover.WongSchemaExceptionMessageImprover;
import com.exasol.errorreporting.ExaError;

/**
 * Validator for mapping definitions using a JSON-schema validator.
 * <p>
 * The validator in this packages requires the use of the {@code io.json} API instead of the project-wide {@code javax}
 * API.
 * </p>
 */
public class EdmlSchemaValidator {
    private static final String MAPPING_LANGUAGE_SCHEMA = "schemas/edml-1.4.0.json";
    private static final List<ExceptionMessageImprover> EXCEPTION_MESSAGE_IMPROVER = List.of(
            new UnknownKeyTypeExceptionMessageImprover(), new UnknownMappingExceptionMessageImprover(),
            new NoMappingExceptionMessageImprover(), new WongSchemaExceptionMessageImprover());
    private final Schema schema;

    /**
     * Create an instance of {@link EdmlSchemaValidator}.
     */
    public EdmlSchemaValidator() {
        final ClassLoader classLoader = EdmlSchemaValidator.class.getClassLoader();
        try (final InputStream inputStream = classLoader.getResourceAsStream(MAPPING_LANGUAGE_SCHEMA)) {
            final JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            this.schema = SchemaLoader.load(rawSchema);
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
        final JSONObject definitionObject = new JSONObject(new JSONTokener(schemaMappingDefinition));
        validate(definitionObject);
    }

    private void validate(final JSONObject schemaMappingDefinition) {
        try {
            final Validator validator = Validator.builder().build();
            validator.performValidation(this.schema, schemaMappingDefinition);
        } catch (final ValidationException originalException) {
            throw new ExasolDocumentMappingLanguageException(
                    ExaError.messageBuilder("F-EDML-51").message("Syntax error in mapping definition.")
                            .mitigation("See causing exception for details.").toString(),
                    makeValidationExceptionMoreReadable(originalException));
        }
    }

    private ExasolDocumentMappingLanguageException makeValidationExceptionMoreReadable(
            final ValidationException exception) {
        final List<ValidationException> causingExceptions = exception.getCausingExceptions();
        if (!causingExceptions.isEmpty()) {
            final ValidationException firstException = causingExceptions.get(0);
            return makeValidationExceptionMoreReadable(firstException);
        } else {
            for (final ExceptionMessageImprover improver : EXCEPTION_MESSAGE_IMPROVER) {
                final Optional<String> improveResult = improver.tryToImprove(exception);
                if (improveResult.isPresent()) {
                    return new ExasolDocumentMappingLanguageException(improveResult.get());
                }
            }
            return new ExasolDocumentMappingLanguageException(
                    ExaError.messageBuilder("F-EDML-53").message("Syntax validation error: {{VALIDATION_ERROR|uq}}.")
                            .parameter("VALIDATION_ERROR", exception.getMessage()).toString());
        }
    }
}
