<a href="https://www.protractortest.org/#/"><img src="https://www.protractortest.org/#/" title="Protractor" alt="Protractor"></a>

# qa-automation-sample: PROTRACTOR

> Repository with examples of automation using Protractor

> Protractor is an end-to-end test framework for Angular and AngularJS applications. Protractor runs tests against your application running in a real browser, interacting with it as a user would.

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger) [![Dependency Status](http://img.shields.io/codeclimate/github/badges/badgerbadgerbadger.svg?style=flat-square)](https://codeclimate.com/github/badges/badgerbadgerbadger) [![Github Issues]

---

## Table of Contents

> Índice `README`.

- [Installation](#installation)
- [Features](#features)
- [Support](#support)
- [License](#license)

---

## Installation

- Install package dependency

> Tips

- Use package scritps
- Install all dependencies (package.json):

![Install example](http://g.recordit.co/0xODbJSVZ1.gif)

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
Funcionalidade: Learning to use the protractor
Como um QA
Quero aprender a utilizar o protractor 
Para então poder automatizar aplicações em angular com sucesso 

Esquema do Cenario: Validar textos no site do angular.org
  Dado que eu esteja na página
  Quando preencher o campo de texto com o "<name>"
  Então verifico que o texto "Hello <name>!" foi validado com sucesso

  Exemplos: 
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