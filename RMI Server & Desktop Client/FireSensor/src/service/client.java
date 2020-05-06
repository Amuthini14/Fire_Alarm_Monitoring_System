/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class client {
    
    private static ServiceInterface s1;
    
     public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        client Client = new client();
        Client.connectRemote();
        System.out.println("User Count: "+s1.increment());

    }

 private void connectRemote() throws RemoteException, NotBoundException {

        Registry reg = LocateRegistry.getRegistry("localhost", 9090);
        s1 =(ServiceInterface) reg.lookup("Sensor_server");
       
    }

}