/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 * Holds a user and their data
 * @author ckinateder
 */
public class User {
    public String username;//can access w/o method
    public String screenName;//ditto
    private String password;//keep private for security
    public User(){
        username="";
        password="";
        screenName="";
    }
    public User(String u, String p, String sc){
        username=u;
        password=p;
        screenName=sc;
    }
    public User(String u, String p){
        username=u;
        password=p;
        screenName=username;
    }
    /**
     * Accessors and Modifiers
     */
    public void setPassword(String p){
        password=p; 
    }    
    public String getPassword(){
        return password;
    }
    public String getUser(){
        return username;
    }
    public String toString(){
        return screenName;
    }
    
}
