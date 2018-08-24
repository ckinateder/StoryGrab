/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;

/**
 *
 * @author ckinateder
 */
public class AccountManager {
    ArrayList<User> users = new ArrayList<>(); //list of all users
    public AccountManager(){
        users.add(new User("calvinkinateder","1234","Calvin Kinateder"));
        //use aep password and login
    }
    public User loginChecker(String usrnm, String pwd){
        for(User u:users){
            if(u.username.equals(usrnm)&&u.getPassword().equals(pwd)){
                return u;//return user with that combination
            }
        }
        return null;//if none exists return that
    }
    public void createAccount(String usrnm, String pwd,String scrNm){
        users.add(new User(usrnm,pwd,scrNm));
    }
}
