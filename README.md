# Task description

Launch URL: https://www.saucedemo.com/

## Test cases

UC-1 Test Login form with empty credentials:

1. Type any credentials into "Username" and "Password" fields.
2. Clear the inputs.
3. Hit the "Login" button.
4. Check the error messages: "Username is required".

UC-2 Test Login form with credentials by passing Username:

1. Type any credentials in username.
2. Enter password.
3. Clear the "Password" input.
4. Hit the "Login" button.
5. Check the error messages: "Password is required".

UC-3 Test Login form with credentials by passing Username & Password:

1. Type credentials in username which are listed under "Accepted usernames" on the site.
2. Enter password as `secret_sauce`.
3. Click on Login and validate the title “Swag Labs” in the dashboard.

---

## Requirements / Constraints

- Test Automation tool: Selenium WebDriver
- Project Builder: Maven
- Browsers to support: 1) Firefox; 2) Edge
- Locators: XPath (use XPath selectors for locating elements)
- Test Runner: JUnit
- Parameterization: Use a Data Provider (JUnit parameterized tests) to supply test data for UC-1/UC-2/UC-3
- Parallel execution: Tests must be runnable in parallel (configure Maven Surefire / JUnit accordingly)
- Logging: Add logging for tests (recommended: SLF4J)
- Assertions: Use Hamcrest matchers where applicable

Optional (suggested patterns / approaches):
- Design patterns: Singleton (for WebDriver factory), Adapter, Strategy
- Test automation approach: BDD (optional)

## Notes / Implementation hints

- Ensure UC-1, UC-2 and UC-3 are all supported by the test suite and by the data provider(s).
- Use a WebDriver factory (prefer Singleton) to create browser instances for Firefox and Edge.
- Use explicit waits where appropriate and XPath locators.
- Configure Maven Surefire (or Failsafe) to run tests in parallel and to pass a system property to select the browser (e.g. `-Dbrowser=firefox` or `-Dbrowser=edge`).
- Use JUnit parameterized tests (or JUnit 5 @ParameterizedTest with a data source) to provide combinations for the three UCs.
- Use SLF4J for logging test steps and important checkpoints.
- Use Hamcrest for readable assertions (e.g., `assertThat(title, is("Swag Labs"));`).

## Quick run examples (Windows CMD)

Run tests with default configuration (uses Maven):

```cmd
mvn test
```

Run tests for Firefox explicitly:

```cmd
mvn test -Dbrowser=firefox
```

Run tests for Edge explicitly:

```cmd
mvn test -Dbrowser=edge
```

Run a single test class (example):

```cmd
mvn -Dtest=org.agustin.AppTest test
```

---

If you want, I can also scaffold the suggested test structure (WebDriver factory, sample JUnit parameterized tests for UC-1/UC-2/UC-3, logging configuration and Maven Surefire parallel setup).