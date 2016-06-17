Prerequisites:

1. Install Chrome WebDriver and note where it was installed.

On command line, pass path to Chrome WebDriver:
mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/path/to/chrome/driver' test

Example:
mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/Users/alexplotitsa/Downloads/chromedriver' test

2. Maven - Maven is used to compile and run tests

How to run tests:

Assumption:  Code has been cloned from GitHub to subdirectory called "CodeChallenge

1. Change directory to "CodeChallenge"
2. Do mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/path/to/chrome/driver' test
