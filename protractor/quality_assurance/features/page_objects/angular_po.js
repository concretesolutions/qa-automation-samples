'use strict'
const Helper = require('../shared_libs/helper.js')

class AngularPage {
  constructor () {
    this.helper = new Helper()
    this.inputName = $('input[ng-model="yourName"]')
    this.inputSearch = $('input[id="projects_search"]')
    this.resultText = $('h1[class="ng-binding"]')
  }

  open (link) {
    return browser.get(link)
  }

  fillText (text) {
    this.helper.elementIsPresenceDom(this.inputName)
    return this.inputName.sendKeys(text)
  }
}

module.exports = AngularPage
