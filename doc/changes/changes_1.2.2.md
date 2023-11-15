# EDML Java 1.2.2, released 2023-11-15

Code name: Fix deserializing timestamp mapping

## Summary

This release fixes a bug when deserializing a `ToTimestampMapping` from JSON. Option `useTimestampWithLocalTimezoneType` was always set to its default value `true`. So it was not possible to define a `TIMESTAMP` column type, it was always `TIMESTAMP WITH LOCAL TIMEZONE`.

## Bugfixes

* #20: Fixed deserializing timestamp mapping

## Dependency Updates

### Compile Dependency Updates

* Updated `jakarta.json:jakarta.json-api:2.1.1` to `2.1.3`

### Test Dependency Updates

* Added `com.jparams:to-string-verifier:1.4.8`
* Updated `nl.jqno.equalsverifier:equalsverifier:3.14` to `3.15.3`
* Updated `org.junit.jupiter:junit-jupiter-api:5.9.2` to `5.10.1`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.2` to `5.10.1`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.2` to `5.10.1`
* Updated `org.mockito:mockito-junit-jupiter:5.1.1` to `5.7.0`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.2` to `1.3.1`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.3` to `2.9.16`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.10.1` to `3.11.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.0.0` to `3.1.1`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.1.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.0.1` to `3.1.0`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.4.1` to `3.6.2`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M8` to `3.2.2`
* Added `org.basepom.maven:duplicate-finder-maven-plugin:2.0.1`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.3.0` to `1.5.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.14.2` to `2.16.1`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.8` to `0.8.11`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184` to `3.10.0.2594`
