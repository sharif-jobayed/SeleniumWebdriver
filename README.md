# OrangeHRM Demo Test Automation Project
### BaseURL: "https://opensource-demo.orangehrmlive.com/web/index.php"

## Technologies and Tools Used

*   **Java:** Programming language.
*   **Selenium WebDriver:** Web browser automation framework.
*   **TestNG:** Testing framework.
*   **Gradle:** Build automation tool.
*   **Allure:** Reporting framework.
*   **Apache Commons IO:** Utility library for file operations.
* **Git**: Version control system.

## Test Cases

The test cases for this project are defined in the `Test Cases.xlsx` file. This file contains:

*   **Test Scenarios:** High-level descriptions of the features or behaviors being tested.
*   **Test Cases:** Step-by-step instructions for each test, including:
    *   Test case ID
    *   Test case description
    *   Preconditions
    *   Steps
    *   Expected results

## Test Suites

Test cases are grouped into test suites defined in the `./src/test/resources/testSuites/` directory:

*   **`LoginPageTests.xml`:** Contains test cases related to login functionality.
    *   `loginUsingValidCredentials`
    *   `loginUsingInvalidUsernameAndValidPassword`
    *   `loginUsingValidUsernameAndInvalidPassword`
    *   `loginUsingInvalidUsernameAndInvalidPassword`
    *   `validateThatTheApplicationBannerIsVisible`
    *   `resetPasswordWithValidUsername`
*   **`DashboardPageTests.xml`:** Contains test cases related to the Dashboard page.
    *   `validateThatTheProfileItemIsVisibleOnThePage`
    *   `hoverOnThePivotTableUnderTheEmployeeDistributionBySubUnitModule`
    *   `checkIfTheTimeAtWorkWidgetIsDisplayed`
    *   `checkIfTheMyActionsWidgetIsDisplayed`
    *   `checkIfTheQuickLaunchWidgetIsDisplayed`
    *   `checkIfTheBuzzLatestPostsWidgetIsDisplayed`
    *   `checkIfTheEmployeesOnLeaveTodayWidgetIsDisplayed`
    *   `checkIfTheEmployeeDistributionBySubUnitWidgetIsDisplayed`
    *   `checkIfTheEmployeeDistributionByLocationWidgetIsDisplayed`
    *   `openAndCloseTheProfileMenu`
*   **`LeaveListPageTests.xml`**: Will contain the tests related to the Leave List Page.
*   **`ApplyLeavePageTests.xml`**: Will contain the tests related to the Apply Leave Page.

## Core Framework Components

*   **`BaseTest.java`:**
    *   Base class for all test classes.
    *   Sets up the WebDriver instance (`setUp()` method).
    *   Tears down the WebDriver instance (`tearDown()` method).
    *   Contains a method `takeScreenshotOnFailure()` to take a screenshot when a test fails.
    *   Contains a method `saveScreenshotPNG()` to add a screenshot to the allure report.
*   **`BasePage.java`:**
    *   Base class for all page object classes.
    *   Provides common methods for interacting with web elements (e.g., `doClick()`, `type()`, `isVisible()`).
    *   Provides common methods to interact with the page (`getPageTitle()`, `getPageURL()`, `isPageOpen()`, `isPageLoaded()`, `isAlertOpen()`, etc.).
    *   Provides common method to interact with alerts (`typeInAlert()`, `acceptAlert()`, `rejectAlert()`)
    *   Provides common methods to open and interact with other windows.
*   **`BaseElement.java`:**
    *   Base class that represents a web element.
    *   Provides methods to interact with the element (`doClick()`, `type()`, `isVisible()`, `getText()`, etc.).
*   **`DriverTools.java`:**
    *   Manages the WebDriver instance (e.g., starting and stopping the browser).
*   **`Pages.java`:**
    *   Factory class that provides access to all page object classes.
* **`Page.java`**:
    * Interface for page objects.

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 8 or later
*   Gradle
*   A web browser (e.g., Chrome)
*   Git

### Installation

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd SeleniumWebdriver
    ```
2.  **Install Dependencies:**
    ```bash
    ./gradlew dependencies
    ```

### Running the Tests

1.  **Run all tests:**
    ```bash
    ./gradlew clean test
    ```

2.  **Run a specific test suite:**
    ```bash
    ./gradlew clean test --tests tests.LoginPageTest
    ./gradlew clean test --tests tests.ApplyLeavePageTest
    ```

### Allure Reports

1.  **Generate the Allure report:**
    ```bash
    ./gradlew allureReport
    ```
2.  **Serve the Allure report:**
    ```bash
    ./gradlew allureServe
    ```
    This will open the report in your default web browser.

### Screenshot on Failure

When a test fails, a screenshot of the browser will be automatically captured and saved to the `build/reports/tests/` directory. The screenshot will be also available on the Allure Report. The name of the image will be in the format `nameOfTheMethod-currentTimestamp.png`.

### Common issue

If you have an issue with `allureServe` it is possible that you have a path with a space. If it is the case, you will need to modify the `allureServe` task in your `build.gradle` file. You need to ensure that any path being passed to that command is enclosed in double quotes.

## Contributing

If you would like to contribute to this project, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them.
4.  Push your changes to your forked repository.
5.  Submit a pull request.

## Contact

If you have any questions or feedback, please feel free to contact me.