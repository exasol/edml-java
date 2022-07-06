package com.exasol.adapter.document.edml.validator.messageimprover;

import com.exasol.adapter.document.edml.validator.ExceptionMessageImprover;
import com.exasol.errorreporting.ExaError;
import org.everit.json.schema.ValidationException;

import java.util.Optional;
import java.util.Set;

/**
 * This {@link ExceptionMessageImprover} improves the exception message for unknown mapping types.
 */
public class UnknownMappingExceptionMessageImprover extends AbstractExceptionMessageImprover {

    @Override
    public Optional<String> tryToImprove(final ValidationException exception) {
        if (exception.getErrorMessage().startsWith("extraneous key")
                && exception.getSchemaLocation().equals("#/definitions/mappingDefinition")) {
            return improveMessage(exception);
        } else {
            return Optional.empty();
        }
    }

    private Optional<String> improveMessage(final ValidationException exception) {
        final Set<String> possibleDefinitions = possibleObjectProperties(exception.getViolatedSchema());
        if (!possibleDefinitions.isEmpty()) {
            return Optional.of(ExaError.messageBuilder("F-EDML-54").message("{{VALIDATION_ERROR|uq}}.")
                    .parameter("VALIDATION_ERROR", exception.getMessage())
                    .mitigation("Use one of the following mapping definitions: {{POSSIBLE_DEFINITIONS}}.")
                    .parameter("POSSIBLE_DEFINITIONS", possibleDefinitions).toString());
        } else {
            return Optional.empty();
        }
    }
}
