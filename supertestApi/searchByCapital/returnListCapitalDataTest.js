const request = require('supertest')
const utils = require('../utils.js')
const chai = require('chai')
const expect = require('chai').expect
const Joi = require('joi')
const url = utils.getUrl()
const schema = require('../response_schemes/reponseCapitalData.js')

chai.use(require('chai-sorted'))

describe('GET on /capital/:capital', () => {
  const path = `/capital`
  it('should be return currencies, name, capital', done => {
    const capitalName = 'brasilia'
    request(url)
            .get(`${path}/${capitalName}`)
            .query({
              fields: 'name;capital;currencies'
            })
            .end((err, res) => {
              expect(res.status).to.be.eql(200)
              // Print data for debug
              console.log('Status code: ' + res.status)
              console.log('Currency code: ' + res.body[0].currencies[0].code)
              console.log('Currency name: ' + res.body[0].currencies[0].name)
              console.log('Currency symbol: ' + res.body[0].currencies[0].symbol)
              console.log('Country: ' + res.body[0].name)
              console.log('Capital: ' + res.body[0].capital)
              // End print
              if (err) return done(err)
              const actual = res.body[0]
              err = Joi.validate(actual, schema.getSchema()).error
              if (err) return done(err)
              done()
            })
  })
})
