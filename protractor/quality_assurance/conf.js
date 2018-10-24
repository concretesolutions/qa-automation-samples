'use strict'

const Data = require('./environments_parameters.json')

const TEST_ENV = process.env.TEST_ENV || 'local'
let environmentParameters

switch (TEST_ENV) {
  case 'local':
    environmentParameters = Data[0].local
    break
}

exports.config = {
  seleniumAddress: environmentParameters.seleniumAddress,
  ignoreUncaughtExceptions: true,
  framework: 'custom',
  frameworkPath: require.resolve('protractor-cucumber-framework'),
  restartBrowserBetweenTests: false,
  getPageTimeout: 50000,
  allScriptsTimeout: 30000,
  rootElement: '*[ng-app]',
  baseUrl: environmentParameters.baseUrl,
  params: {

  },

  specs: [
    'features/*.feature'
  ],

  exclude: [
  ],

  capabilities: {
    'browserName': 'chrome',
    chromeOptions: {
      args: [
        '--disable-gpu'
      ]
    }
  },

  cucumberOpts: {
    require: '../features/step_definitions/*.js',
    tags: ['~@notImplemented'],
    format: ['json:results.json'],
    profile: false,
    'no-source': true
  },

  beforeLaunch: function () {
    setTimeout(function () {
      browser.driver.executeScript(function () {
        return {
          width: window.screen.availWidth,
          height: window.screen.availHeight
        }
      }).then(function (result) {
        browser.driver.manage().window().setSize(result.width, result.height)
      })
    })
  },

  onPrepare: function () {
    // Use only for angular applications
    // False: app Angular
    // True: app not Angular
    browser.ignoreSynchronization = false
  },

  afterLaunch: function () {
    var reporter = require('cucumber-html-reporter')

    var options = {
      theme: 'bootstrap',
      jsonFile: 'results.json',
      output: 'report/cucumber_report.html',
      reportSuiteAsScenarios: true,
      launchReport: true,
      screenshotsDirectory: 'report/screenshots/',
      storeScreenshots: true,
      metadata: {
        'App Version': '0.0.1',
        'Test Environment': 'STAGING',
        'Browser': 'Chrome  69.0.3497.100',
        'Platform': 'OSX',
        'Parallel': 'Scenarios',
        'Executed': 'Remote'
      }
    }
    reporter.generate(options)
  }
}
