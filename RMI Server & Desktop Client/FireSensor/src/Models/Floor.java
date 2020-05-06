/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;



public class Floor implements Serializable{
    
     public int Id;
    public String No;
    public int User;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String No) {
        this.No = No;
    }

    public int getUser() {
        return User;
    }

    public void setUser(int User) {
        this.User = User;
    }
     
    
}
