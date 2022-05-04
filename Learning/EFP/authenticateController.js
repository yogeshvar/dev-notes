var jwt = require('jsonwebtoken');


module.exports.authenticate = function(req,res)
{
  var user = {
    username: 'maggie',
    email: 'maggie@test.com'
  }
  var token = jwt.sign(user,process.env.SECRET_KEY,
  {
    expiresIn: 4000
  });
  res.json({
      success: true,
      token: token
  })
}
