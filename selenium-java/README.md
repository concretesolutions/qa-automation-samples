# qa-automation-sample: SELENIUM-JAVA

> Repository with examples of automation using selenium + java

> Selenium is a portable software-testing framework for web applications. Selenium provides a playback tool for authoring tests without the need to learn a test scripting language.

---

## Table of Contents

> Índice `README`.

- [Prerequisite](#prerequisite)
- [Configuration](#configuration)
- [Installation](#installation)
- [Features](#features)
- [Report](#report)
- [Support](#support)
- [License](#license)

---

## Prerequisite

- [JDK install +8](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Eclipse IDE install](http://www.eclipse.org/downloads/)
- [Maven install](https://maven.apache.org/install.html)
- [Cucumber plugin install](http://toolsqa.com/cucumber/install-cucumber-eclipse-plugin/)


## Configuration
###Java
- Mac
`export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home`

###Maven
- Mac
`export PATH=/opt/apache-maven-3.5.3/bin:$PATH`

## Installation

- Windows:
https://www.mkyong.com/maven/how-to-install-maven-in-windows/

- Install all dependencies (pom.xml)
`mvn install`

![Maven install example](http://g.recordit.co/AC3WJT4g4D.gif)

> Tips

- Use pom.xml to install the project dependencies

### Clone

- Clone this repo to your local machine using `https://github.com/concretesolutions/qa-automation-samples`

### Run test

> run test Maven

```shell
$ mvn clean test
```

> run test Cucumber

```shell
$ mvn clean -Dtest=CucumberRunnerTest test
```

> run test Eclipse

Right click on class CucumberRunnerTest.java> Run as> JUnit Test


---

## Features
- file example `.feature`

```gherkin
Feature: Learning to use selenium with java 
As a QA
I want to learn how to use selenium 
To be able to automate applications 

Scenario Outline: Validate texts in concrete.com.br website
Given Im on the page
When I fill in the text field with "<name>"
Then I checked that the text "<expected>" was successfully validated

  Examples: 
  | name        | expected								              |
  | Concrete	| A Concrete no QCon SP 2011 – parte 1	  |
  | Lucas Fraga	| Utilizando async/await com Protractor	|
```

## Report

> run allure report

```shell
$ mvn allure:serve
```

---

## Support

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