// this file have the routes for all sensor
//here do the db connection and query part

const express = require('express');
const mysqlConnection = require('../connection.js');


//create  router object for the app on which we are going to create all the routes
const Router = express.Router();

//query - 1. is query and  2. callback
//To Retrieve all Sensors details 
Router.get('/', (req, res) => {
        // mysqlConnection.query("SELECT * from sensors", (err, rows, fields) => {
        mysqlConnection.query("SELECT * from sensors", (err, results) => {
            if(!err){
                // res.send(rows);
                res.send(JSON.stringify(results));
            }
            else{
                console.log(err);
            }
        } )
});

// //To Retrieve a sensor by using id
// Router.get('/:id', (req, res) => {
//     mysqlConnection.query("SELECT * from sensors", (err, rows, fields) => {
//         if(!err){
//             res.send(rows);
//         }
//         else{
//             console.log(err);
//         }
//     } )
// });

//To Retrieve a sensor by using id
Router.get('/:id', (req, res)=> {
    // mysqlConnection.query("select * from sensors where id= ?", [req.params.id],  (error, rows, fields) => {
        mysqlConnection.query("select * from sensors where Sensor_Id=" + req.params.id + " ",  (error, results) => {

        if (error) throw error;
       console.log(results);
       res.send(JSON.stringify(results));
     });
 });



 //To delete a sensor by using id
Router.delete('/delete/:id', (req, res)=> {
    mysqlConnection.query("DELETE FROM  sensors  WHERE Sensor_Id =" + req.params.id + " ", (error, results) => {
       if (error) throw error;
       console.log(results);
       res.send(JSON.stringify(results));
     });
 });


//To Insert A New Sensor
Router.post('/', (req, res) => {
    mysqlConnection.query('INSERT INTO sensors SET ?',  req.body, (err, results, fields) => {
        if (err) throw err;
        res.send(JSON.stringify(results));
      });
  });

  Router.post('/addsensor/:senId/:flNo/:rmNo/:Co2lvl/:smoke', (req, res) => {
    mysqlConnection.query('INSERT INTO sensors SET sensor_name=?,floor_no=?,room_no=?,co2_level=?,smoke_level=?', [req.params.senId,req.params.flNo,req.params.rmNo,req.params.Co2lvl,req.params.smoke,] , (err, results, fields) => {
        if (err) throw err;
        
        console.log(req.params.senId,req.params.flNo,req.params.rmNo,req.params.Co2lvl,req.params.smoke);
        res.send(JSON.stringify(results));
      });

  });



   //To Update a sensor by using id
   Router.put('/:id', (req, res)=> {
    mysqlConnection.query("update  sensors  SET floor_no =?, room_no = ?,sensor_name=?,  co2_level = ?, smoke_level = ?  where id= ?", [req.body.floor_no,req.body.room_no, req.body.sensor_name,req.body.co2_level, req.body.smoke_level, req.params.id], (error, results) => {
       if (error) throw error;
       console.log(results);
       res.send(JSON.stringify(results));
     });
 });




  
//rest api to update record into mysql database
// Router.put('/', function (req, res) {
//    connection.query('UPDATE `employee` SET `employee_name`=?,`employee_salary`=?,`employee_age`=? where `id`=?', [req.body.employee_name,req.body.employee_salary, req.body.employee_age, req.body.id], function (error, results, fields) {
// 	  if (error) throw error;
// 	  res.end(JSON.stringify(results));
// 	});
// });

 module.exports = Router;