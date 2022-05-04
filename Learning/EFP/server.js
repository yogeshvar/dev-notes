const express = require('express');
const bodyParser = require('body-parser');


const app = express();
const authenticateController = require('./authenticateController.js');

process.env.SECRET_KEY = 'mysecretkey';

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.get('/api/authenticate', authenticateController.authenticate);


app.listen(3000, () => {
  console.log('Server is listening to port 3000');
});
