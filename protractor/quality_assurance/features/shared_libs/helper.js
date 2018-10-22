var until = protractor.ExpectedConditions
var fs = require('fs')
var Buffer = require('safe-buffer').Buffer
const { setDefaultTimeout } = require('cucumber')
setDefaultTimeout(60 * 1000)

var Helper = function () {}

// Wait to see if element is on DOM
Helper.prototype.elementIsPresenceDom = function (element) {
  browser.wait(until.presenceOf(element), 25000, 'Element ' + element.getText() + ' taking too long to appear in the DOM')
  browser.executeScript('arguments[0].scrollIntoView();', element.getWebElement())
}

// Wait to see if element is clickable
Helper.prototype.elementIsClickable = function (element) {
  browser.wait(until.elementToBeClickable(element), 50000, 'Element taking too long to appear in the DOM and stay clickable')
}

// Wait to see if element is visible
Helper.prototype.elementIsVisible = function (element) {
  browser.wait(until.visibilityOf(element), 10000, 'Element taking too long to appear in the DOM and stay visible')
}

// Wait to see if element is not attache to the DOM
Helper.prototype.elementIsNotAttachedOnDom = function (element) {
  browser.wait(until.stalenessOf(element), 10000, 'Element appeared in DOM')
}

// Wait to see if element is not present of DOM
Helper.prototype.elementIsNotPresentOfDom = function (element) {
  return browser.wait(until.not(until.presenceOf(element)))
}

// Force the browser to stop
Helper.prototype.stopBrowser = function (time) {
  browser.sleep(time)
}

// Wait for dropdown list elements load
Helper.prototype.waitForCount = function (elementArrayFinder, expectedCount) {
  return function () {
    return elementArrayFinder.count().then(function (actualCount) {
      return expectedCount === actualCount // or <= instead of ===, depending on the use case
    })
  }
}

// Wait for all elements the array of webelements
Helper.prototype.presenceOfAll = function (elementArrayFinder) {
  return function () {
    return elementArrayFinder.count(function (count) {
      return count > 0
    })
  }
}

// This function take a screenshot and save in directory screenshots_atual
Helper.prototype.getScreenshot = function (nomeArquivo) {
  function writeScreenShot (data, filename) {
    var stream = fs.createWriteStream(filename)
    stream.write(Buffer.from(data, 'base64'))
    stream.end()
  }
  return browser.takeScreenshot().then((png) => {
    writeScreenShot(png, './features/screenshots_atual/' + nomeArquivo + '.png')
  })
}

// This function make scrool to down on page
Helper.prototype.scrollPageDown = function (valuePixels) {
  browser.executeScript('window.scrollBy(0,' + valuePixels + ');')
}

// Check if an array is ascending ordered - V2
Helper.prototype.stringArrayIsAscendingOrdered = function (data) {
  for (let i = 0; i < data.length - 1; i++) {
    if (data[i].localeCompare(data[i + 1]) > 0) {
      return false
    }
  }
  return true
}

// Check if an array is descending ordered - V2
Helper.prototype.stringArrayIsDescendingOrdered = function (data) {
  for (let i = 0; i < data.length - 1; i++) {
    if (data[i].localeCompare(data[i + 1]) < 0) {
      return false
    }
  }
  return true
}

Helper.prototype.numberArrayIsOrdered = function (a, b) {
  'use strict' // optional.
  // --------------------------------------------
  // a is the array input to be tested.
  // --------------------------------------------
  // b is optional.
  // Undefined b (or other value besides 1) for ascending sequence.
  // b === 1 for descending sequence test.
  // --------------------------------------------
  var m = 0 // counter for loop.
  var currentNum
  var nextNum
  var result = a
  var test

  if (a !== undefined) {
    if (a.constructor === Array) { // check if input a is array object.
      result = true
      while (m < a.length) { // loop through array elements.
        currentNum = a[m]
        nextNum = a[m + 1]
        if (typeof currentNum === 'number' &&
          typeof nextNum === 'number') {
          if (b === 1) {
            test = currentNum <= nextNum // descending.
          } else {
            test = currentNum >= nextNum // ascending.
          }
          if (test) { // found unordered/same elements.
            result = false
            break
          }
        }
        m += 1
      }
    }
  }
  return result
}

module.exports = Helper
