# CounterString Generator

## Overview
The following repo contains test cases for CounterString Generator.


## Guidelines

1. Clone this repository

2. Check if maven is installed on system. Enter "mvn -version" from terminal. You can also install maven with "brew install maven" on mac.

3. If Maven is installed, Go to project root directory and type "mvn test" and enter. It will execute the test cases. Once execution is completed go to reports/index.html for the report.

4. If Maven is not configured, then import the repository in eclipse/intellij.

5. Expand the Project, right click on testng.xml and run as TestNG Suite. It will start executing the test cases and will show the status in the end.

5. Logging is enabled on console & file. Logs can be seen during the execution at Step 3  or 5.

6. ExtendReports is configured and will be generated in the reports/index.html once the execution is completed.
 

## Source Code Review

Framework is designed as per the Page Object Model. It helps in modifying the framework in future.

7. Source code for the test cases is located in /src/test/java/. 

8. Utilities are located in /src/main/java/.

9. 2 Test cases will be passed and 2 will be failed.






