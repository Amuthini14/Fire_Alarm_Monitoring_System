/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Models.getAllData;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface ServiceInterface extends Remote{
    
    List<getAllData> allData() throws RemoteException;
    public int increment() throws RemoteException;
}
