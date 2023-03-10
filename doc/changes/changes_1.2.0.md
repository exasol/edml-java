# EDML Java 1.2.0, released 2023-03-10

Code name: Optional `mapping`

## Summary

This release makes the `mapping` field optional. When `mapping` is not defined, the virtual schema will use auto-inference to detect the mapping.

In order to use this new feature, please upgrade the JSON schema definition to `edml-1.5.0.json`.

## Features

* #16: Made `mapping` field optional

## Dependency Updates

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.13.1` to `3.14`
