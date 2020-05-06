/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Controller.httpJson;
import Models.getAllData;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.JSONParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Server extends UnicastRemoteObject implements ServiceInterface {

             private int count=0;
             private List<getAllData> AllDataList;    
             
              public Server() throws RemoteException {
             super();
             GetAllData();
       
           }
     public synchronized int increment(){

				count++;
				return count;
		   }
    
    
    
    @Override
    public List<getAllData> allData() throws RemoteException {
        return AllDataList;
    }
    
    private void GetAllData() {

       
        AllDataList = new ArrayList<>();

        serverUpdate();

    }
    private void serverUpdate() {
        System.out.println("Server Update Function Execute----------------------");
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("Server Thread Start---------------------");
                    apiRequests();
                    Thread.sleep(5000);
                    serverUpdate();
                } catch (Exception e) {
                    System.out.println("Thread Exception : " + e);
                }

            }
        }
        );

        thread.start();
    }
        
        private void apiRequests() {
        System.out.println("Send API Requests");

        String fetchAllData_response = new httpJson().jsonRequest("http://localhost:5000/sensors/");
        
       // System.out.println(fetchAllData_response);
        if (fetchAllData_response != null) {
            try {
                JSONParser jsonParser = new JSONParser();
                JSONArray responseObj = (JSONArray) jsonParser.parse(fetchAllData_response);
                AllDataList.clear();
                for (Object obj : responseObj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    AllDataList.add(
                            new getAllData(
                                    jSONObject.get("id").toString(),
                                    jSONObject.get("floor_no").toString(),
                                    jSONObject.get("sensor_name").toString(),
                                    jSONObject.get("smoke_level").toString(),
                                    jSONObject.get("co2_level").toString(),
                                    jSONObject.get("room_no").toString())
                                    
                                   
                    );
                }
                System.out.println("Response from all getData: complete---------");
            } catch (Exception e) {
                System.out.println("Server Exception: " + e);
            }
        }
    }

    
     public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(9090);
            reg.rebind("Sensor_server", new Server());
            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
