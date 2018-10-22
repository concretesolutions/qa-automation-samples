#language: pt

@example
Feature: Learning to use the protractor
As a Quality assurance
I want to learn how to use the protractor 
In order to be able to automate successful angled applications

Scenario: Validate texts on the site angular.org
  Given Im on the page
  When you fill in the text filed with the "<name>"
  Then I checked the text "Hello <name>!" has been successfully validated

  Examples: 
  | name        |
  | Concrete    |
  | QA Analyst  |
  | Any Name    |