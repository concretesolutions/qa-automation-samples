const { Given, When, Then } = require('cucumber')
const expect = require('chai').use(require('chai-as-promised')).expect

const AngularPage = require('../page_objects/angular_po')
const page = new AngularPage()

Given('que eu esteja na página', async function () {
  await page.open('/')
})

When('preencher o campo de texto com o {string}', async function (name) {
  await page.fillText(name)
})

Then('verifico que o texto {string} foi validado com sucesso', async function (text) {
  await expect(page.resultText.getText())
    .to.eventually.equal(text)
})