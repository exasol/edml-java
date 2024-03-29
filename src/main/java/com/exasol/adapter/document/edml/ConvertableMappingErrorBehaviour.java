package com.exasol.adapter.document.edml;

/**
 * Behaviour for errors during schema mapping. This enum extends the {@link MappingErrorBehaviour} by the
 * {@code CONVERT_OR_NULL} and {@code CONVERT_OR_ABORT} option that is only applicable for certain types.
 */
public enum ConvertableMappingErrorBehaviour {

    /**
     * Try to convert the value and return NULL if that is not possible.
     */
    CONVERT_OR_NULL,
    /**
     * Try to convert the value and abort if that is not possible.
     */
    CONVERT_OR_ABORT,
    /**
     * Abort the whole query
     */
    ABORT,
    /**
     * Use NULL instead
     */
    NULL
}
