#language: en

@example
Feature: Learning to use selenium with java 
As a QA
I want to learn how to use selenium 
To be able to automate applications 

Scenario Outline: Validate texts in concrete.com.br website
Given Im on the page
When I fill in the text field with "<name>"
Then I checked if the text "<expected>" was successfully validated

  Examples: 
  | name        | expected															|
  | Concrete		| A Concrete no QCon SP 2011 – parte 1		|
  | Lucas Fraga	| Utilizando async/await com Protractor	|