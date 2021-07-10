#Author: Naresh Cherala
 
@bvt
Feature: Validate Total Balance
  Scenario: verify total balance in exercise page 
    Given user launch "chrome" browser
    And User open homepage of exercise application
    When user sum the all the values from value1 to value5
    Then verify the count of values appear on the page as "5"
		And verify the values on the screen are greater than "0"
		And verify the values are formatted as currencies
		And verify the sum of values is equal to Total Balance 
    