Feature: Verify the login functionality of OMR branch application

Scenario Outline: Verify the login functionality of OMR branch

Given User is on OMR branch login page

When User enter "<username>" username and "<password>" password

And User clicks remember me checkbox

And USer clicks on login button

Then User should navigate to OMR branch home page

Examples:

|username|password|
|arun|arun@123|
|bala|bala@456|
|babu|babu@789|
 
