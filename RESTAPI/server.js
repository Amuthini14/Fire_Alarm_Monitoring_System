const express = require('express');
const bodyParser = require('body-parser');
const mysqlConnection = require('./connection.js');
const SeonsorRoutes = require('./routes/sensorRoutes.js');


const app = express();
app.use(bodyParser.json());

//all the requests comes to '/sensors' will use the SeonsorRoutes and there handle all the requests and send he response 
app.use('/sensors', SeonsorRoutes);



app.listen(5000);