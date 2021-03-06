package com.exasol.adapter.document.edml;

/**
 * Behaviour for errors during schema mapping.
 */
public enum MappingErrorBehaviour {
    /**
     * Abort the whole query
     */
    ABORT,
    /**
     * Use NULL instead
     */
    NULL
}
