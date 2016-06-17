Prerequisites:

1. Install Chrome WebDriver
On command line, pass path to Chrome WebDriver:
mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/path/to/chrome/driver' test
Example:
mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/Users/alexplotitsa/Downloads/chromedriver' test

2. Maven

How to run tests:
Assumption:  Code has been cloned from GitHub to subdirector called "CodeChallenge

1. Change directory to "CodeChallenge"
2. Do mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/path/to/chrome/driver' test
