#language: en

@example
Feature: Learning to use Protractor 
As a QA
I want to learn how to use Protractor 
To be able to automate angular applications 

Scenario Outline: Validate texts in angular.org website
Given Im on the page
When I fill in the text field with "<name>"
Then I checked that the text "Hello <name>!" was successfully validated

  Examples: 
  | name        |
  | Concrete    |
  | QA Analyst  |
  | Any Name    |