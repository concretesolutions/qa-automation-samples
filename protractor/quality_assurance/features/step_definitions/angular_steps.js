const { Given, When, Then } = require('cucumber')
const expect = require('chai').use(require('chai-as-promised')).expect

const AngularPage = require('../page_objects/angular_po')
const page = new AngularPage()

Given('Im on the page', async function () {
  await page.open('/')
})

When('you fill in the text filed with the {string}', async function (name) {
  await page.fillText(name)
})

Then('I checked the text {string} has been successfully validated', async function (text) {
  await expect(page.resultText.getText())
    .to.eventually.equal(text)
})