const { Given, When, Then } = require('cucumber')
const expect = require('chai').use(require('chai-as-promised')).expect

const AngularPage = require('../page_objects/angular_po')
const page = new AngularPage()

Given('Im on the page', async function () {
  await page.open('/')
})

When('I fill in the text field with {string}', async function (name) { 
  await page.fillText(name)
})

Then('I checked that the text {string} was successfully validated', async function (text) {
  await expect(page.resultText.getText())
    .to.eventually.equal(text)
})