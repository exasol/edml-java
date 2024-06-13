# EDML Java 2.1.0, released 2024-06-13

Code name: Add property `autoInferenceColumnNames`

## Summary

This release adds property `autoInferenceColumnNames` to the EDML definition. This allows users to configure how virtual schemas convert column names from the source to Exasol column names when using automatic schema inference. By default the virtual schema will convert source column names to `UPPER_SNAKE_CASE` for Exasol column names. If you want to use the original name from the source file, you can add property `autoInferenceColumnNames` to the EDML definition. This property supports the following values:
* `CONVERT_TO_UPPER_SNAKE_CASE`: Convert column names to `UPPER_SNAKE_CASE` (default).
* `KEEP_ORIGINAL_NAME`: Do not convert column names, use column name from source.

## Features

* #24: Added property `autoInferenceColumnNames`

## Dependency Updates

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.15.3` to `3.16.1`
* Updated `org.junit.jupiter:junit-jupiter-api:5.10.1` to `5.10.2`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.10.1` to `5.10.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.1` to `5.10.2`
* Updated `org.mockito:mockito-junit-jupiter:5.7.0` to `5.12.0`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.3.1` to `2.0.3`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.16` to `4.3.3`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.11.0` to `3.13.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.1` to `3.1.2`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.1.0` to `3.2.4`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.6.2` to `3.7.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.2.2` to `3.2.5`
* Added `org.apache.maven.plugins:maven-toolchains-plugin:3.2.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.5.0` to `1.6.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.1` to `2.16.2`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.11` to `0.8.12`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594` to `4.0.0.4121`
* Updated `org.sonatype.plugins:nexus-staging-maven-plugin:1.6.13` to `1.7.0`
