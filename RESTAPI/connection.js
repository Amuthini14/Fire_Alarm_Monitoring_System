const mysql = require('mysql');

//configuration  for mysql db
var mysqlConnection = mysql.createConnection({
    host : "localhost",
    user : "root",
    password: "",
    database: "db",
    multipleStatements : true

});

//start connection
mysqlConnection.connect((err) =>{
    if(!err){
        console.log("DB Connected");

    }
    else{
        console.log("Connection  Failed");
    }
});

module.exports = mysqlConnection;