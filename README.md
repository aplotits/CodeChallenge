Prerequisites:
Install Chrome WebDriver
On command line, pass path to Chrome WebDriver:
mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/path/to/chrome/driver' test
Example:
mvn clean -Dtest=JungleTest -Dwebdriver.chrome.driver='/Users/alexplotitsa/Downloads/chromedriver' test