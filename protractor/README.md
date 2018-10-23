# qa-automation-sample: PROTRACTOR

> Repository with examples of automation using Protractor

> Protractor is an end-to-end test framework for Angular and AngularJS applications. Protractor runs tests against your application running in a real browser, interacting with it as a user would.

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger) [![Dependency Status](http://img.shields.io/codeclimate/github/badges/badgerbadgerbadger.svg?style=flat-square)](https://codeclimate.com/github/badges/badgerbadgerbadger) [![Github Issues]

---

## Table of Contents

> Índice `README`.

- [Prerequisite](#prerequisite)
- [Installation](#installation)
- [Features](#features)
- [Support](#support)
- [License](#license)

---

## Prerequisite

- [Node install](https://nodejs.org/en/download/)
- [Npm install](https://www.npmjs.com/get-npm)
- [Protractor install](https://www.npmjs.com/package/protractor)

## Installation

- Install all dependencies (package.json)

![Install example](http://g.recordit.co/0xODbJSVZ1.gif)

> Tips

- Use scripts (package.json) for shortcut

### Clone

- Clone this repo to your local machine using `https://github.com/concretesolutions/qa-automation-samples`

### Run test

- Ride up selenium server to a default port and running the tests:

> ride up server and run test

```shell
$ npm run start_update_webdriver
$ npm run test
```

---

## Features
- file `.feature`

```gherkin
Feature: Learning to use Protractor 
As a QA
I want to learn how to use Protractor 
To be able to automate angular applications 

Scenario Outline: Validate texts in angular.org website
Given Im on the page
When I fill in the text field with "<name>"
Then I checked that the text "Hello <name>" was successfully validated

  Examples: 
  | name        |
  | Concrete    |
  | QA Analyst  |
  | Any Name    |
```

---

## Support

Reach out to me at one of the following places!

- Website at <a href="https://concrete.com.br" target="_blank">`Concrete`</a>
- Twitter at <a href="https://twitter.com/ConcreteS" target="_blank">`@ConcreteS`</a>
- Facebook at <a href="https://www.facebook.com/ConcreteS" target="_blank">`FB - Concrete`</a>
- Instagram at <a href="https://www.instagram.com/concretebr" target="_blank">`IG - Concrete`</a>

- E-mail: `contato@concrete.com.br`

---

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2018 © <a href="http://concrete.com.br" target="_blank">Concrete</a>.