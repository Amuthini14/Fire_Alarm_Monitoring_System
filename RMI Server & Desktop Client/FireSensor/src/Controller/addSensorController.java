/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import service.ServiceInterface;



public class addSensorController {
    
      private static ServiceInterface s1;
      private static HttpURLConnection connection;
    
    public addSensorController()throws RemoteException, NotBoundException{
        
         Registry reg = LocateRegistry.getRegistry("localhost", 9090);
                    s1 = (ServiceInterface) reg.lookup("Sensor_server");
   
    }
    
    public void insertSensor(String floor_no,String room_no,String sensor){
             
           String resp = new Controller.httpJson().jsonRequest1("http://localhost:5000/sensors/addsensor/"+sensor+"/"+floor_no+"/"+room_no+"/0/0");
        System.out.println(resp);
        System.out.println("----------------------------------------------------");
       
           
                
       
    
    }   
}
