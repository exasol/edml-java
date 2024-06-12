package com.exasol.adapter.document.edml;

/**
 * Defines how Exasol column names are inferred from the source.
 */
public enum ColumnNameMapping {
    /**
     * Convert column names to {@code UPPER_SNAKE_CASE} (default).
     */
    CONVERT_TO_UPPER_SNAKE_CASE,
    /**
     * Do not convert column names, use column name from source.
     */
    KEEP_SOURCE;
}
