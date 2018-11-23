const Joi = require('joi')

function getSchema () {
  const schema = Joi.object().keys({
    currencies: Joi.array().min(1).items(Joi.object().keys({
      code: Joi.string().required(),
      name: Joi.string().required(),
      symbol: Joi.string().required()
    })),
    name: Joi.string().required(),
    capital: Joi.string().required()
  })
  return schema
}

module.exports = {
  getSchema
}
