/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
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
    public void setPassword(String p){
        password=p; 
    }    
    public String getPassword(){
        return password;
    }
    
    
}
