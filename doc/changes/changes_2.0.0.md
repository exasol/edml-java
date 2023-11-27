# EDML Java 2.0.0, released 2023-11-28

Code name: Remove 

## Summary

This release removes support for property `ToTimestampMapping.useTimestampWithLocalTimezoneType` which allowed using column type `TIMESTAMP WITH LOCAL TIME ZONE` in document based virtual schemas. This data type does not make sense for document based virtual schemas that don't support time zones at all. So we decided to drop support completely.

This is a breaking change, so we incremented the version to 2.0.0 and also released a new EDML JSON schema `edml-2.0.0.json`, see https://schemas.exasol.com.

## Features

* #22: Remove support for `TIMESTAMP WITH LOCAL TIME ZONE`
