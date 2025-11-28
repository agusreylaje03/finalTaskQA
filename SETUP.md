# Browser Configuration Guide

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Firefox browser (latest stable version recommended)
- Microsoft Edge browser (latest stable version recommended)

## Browser Configuration

### Firefox

Firefox works automatically with WebDriverManager. No manual configuration required.

The test framework will automatically:
1. Download the appropriate GeckoDriver version
2. Configure the WebDriver path
3. Initialize the browser

### Edge

Microsoft Edge requires additional configuration due to driver path requirements.

#### Option 1: Automatic setup (Recommended)

1. Download EdgeDriver from [Microsoft Edge WebDriver Downloads](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
2. Verify your Edge browser version:
    - Open Edge
    - Go to `edge://settings/help`
    - Note the version number (e.g., `120.0.2210.133`)
3. Download the matching EdgeDriver version
4. Extract `msedgedriver.exe` to `C:\Program Files\_webdrivers\`
5. In `src/test/java/org/agustin/webdriver/WebDriverSingleton.java`:
    - **Uncomment** line 43: `WebDriverManager.edgedriver().setup();`
    - **Comment out** line 44: `System.setProperty("webdriver.edge.driver", "C:\\Program Files\\_webdrivers\\msedgedriver.exe");`

#### Option 2: Manual driver path (Fallback)

If automatic setup fails:

1. Follow steps 1-4 from Option 1
2. Keep line 44 **uncommented** in `WebDriverSingleton.java`
3. Update the path if your EdgeDriver is in a different location:
   ```java
   System.setProperty("webdriver.edge.driver", "YOUR_CUSTOM_PATH\\msedgedriver.exe");
