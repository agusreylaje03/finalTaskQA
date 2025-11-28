# Project Dependencies

This document lists all dependencies and plugins used in the project with their versions.

## Dependencies

### Testing Framework

**JUnit Jupiter (JUnit 5)**
- **Group ID:** `org.junit.jupiter`
- **Artifact ID:** `junit-jupiter`
- **Version:** `5.10.1`
- **Scope:** `test`
- **Purpose:** Core testing framework for writing and running tests

**JUnit Jupiter Params**
- **Group ID:** `org.junit.jupiter`
- **Artifact ID:** `junit-jupiter-params`
- **Version:** `5.10.1`
- **Scope:** `test`
- **Purpose:** Parameterized test support for data-driven testing

### Browser Automation

**Selenium WebDriver**
- **Group ID:** `org.seleniumhq.selenium`
- **Artifact ID:** `selenium-java`
- **Version:** `4.18.1`
- **Scope:** `compile`
- **Purpose:** Browser automation and web testing framework

**WebDriverManager**
- **Group ID:** `io.github.bonigarcia`
- **Artifact ID:** `webdrivermanager`
- **Version:** `5.6.3`
- **Scope:** `test`
- **Purpose:** Automatic management of browser drivers (GeckoDriver, EdgeDriver, etc.)

### Assertions

**Hamcrest**
- **Group ID:** `org.hamcrest`
- **Artifact ID:** `hamcrest`
- **Version:** `2.2`
- **Scope:** `test`
- **Purpose:** Flexible and readable assertion matchers

### Logging

**SLF4J API**
- **Group ID:** `org.slf4j`
- **Artifact ID:** `slf4j-api`
- **Version:** `2.0.9`
- **Scope:** `compile`
- **Purpose:** Logging facade for abstracting logging implementations

**Logback Classic**
- **Group ID:** `ch.qos.logback`
- **Artifact ID:** `logback-classic`
- **Version:** `1.4.14`
- **Scope:** `test`
- **Purpose:** Concrete logging implementation for SLF4J

## Maven Plugins

**Maven Surefire Plugin**
- **Group ID:** `org.apache.maven.plugins`
- **Artifact ID:** `maven-surefire-plugin`
- **Version:** `3.1.2`
- **Purpose:** Test execution and reporting with parallel execution support

## Dependency Summary Table

| Dependency | Version | Scope | Category |
|------------|---------|-------|----------|
| selenium-java | 4.18.1 | compile | Browser Automation |
| junit-jupiter | 5.10.1 | test | Testing Framework |
| junit-jupiter-params | 5.10.1 | test | Testing Framework |
| hamcrest | 2.2 | test | Assertions |
| slf4j-api | 2.0.9 | compile | Logging |
| logback-classic | 1.4.14 | test | Logging |
| webdrivermanager | 5.6.3 | test | Browser Automation |

## Maven Plugin Summary

| Plugin | Version | Purpose |
|--------|---------|---------|
| maven-surefire-plugin | 3.1.2 | Test Execution |

## Compatibility Matrix

### Java Version Compatibility

| Component | Minimum Java Version | Recommended Version |
|-----------|---------------------|---------------------|
| Selenium 4.18.1 | Java 11 | Java 17+ |
| JUnit 5.10.1 | Java 8 | Java 11+ |
| SLF4J 2.0.9 | Java 8 | Java 11+ |
| Logback 1.4.14 | Java 11 | Java 17+ |

**Project Configuration:** Java 11

### Browser Version Compatibility

| Browser | Minimum Version | Driver Management |
|---------|----------------|-------------------|
| Firefox | 78+ | Automatic (WebDriverManager) |
| Edge | 90+ | Manual + WebDriverManager |

## Updating Dependencies

### Check for Updates

To check for newer versions of dependencies:

```bash
mvn versions:display-dependency-updates
