Feature: Gillette Website

Scenario Outline: Search Operation
Given Initialize the browser with chrome
And Navigate to url site
When the user clicks on search icon 
And enters the <search item> in the search bar
Then the user is navigated to <search item> page and verify the text displayed on that page
And close the browser

Examples:
|search item |
|shaving cream |

Scenario: Verifying Terms and Conditions of the Gillette
Given Initialize the browser with chrome
And Navigate to url site
When the user clicks on Terms and Conditions in the footer section
Then the user is navigated to terms and conditions page and verify the code of conduct
And close the browser
