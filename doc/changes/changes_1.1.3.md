# EDML Java 1.1.3, released 2023-02-14

Code name:

## Summary

This release replaces `org.json:json` dependency which has vulnerability CVE-2022-45688 with `jakarta.json-api`. During this process we migrated to library `org.leadpony.justify:justify` for validating the EDML content against the JSON schema. This will result in slightly different error messages for invalid EDML.

## Bugfixes

* #10: Added language to release config file
* #11: Replaced `org.json:json` dependency with `jakarta.json-api`

## Refactoring

* #13: Removed lombok library

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:1.0.0` to `1.0.1`
* Removed `com.github.everit-org.json-schema:org.everit.json.schema:1.14.1`
* Added `org.leadpony.justify:justify:3.1.0`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.12.3` to `3.13.1`
* Updated `org.junit.jupiter:junit-jupiter-api:5.9.1` to `5.9.2`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.1` to `5.9.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.1` to `5.9.2`
* Updated `org.mockito:mockito-junit-jupiter:4.10.0` to `5.1.1`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.1` to `1.2.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.1` to `2.9.3`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M7` to `3.0.0-M8`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.13.0` to `2.14.2`
* Updated `org.itsallcode:openfasttrace-maven-plugin:1.5.0` to `1.6.1`
* Removed `org.projectlombok:lombok-maven-plugin:1.18.20.0`
