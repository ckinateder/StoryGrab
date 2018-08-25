/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ckinateder
 */
public class AccountManager {
    ArrayList<User> users = new ArrayList<>(); //list of all users.
    String fileName = "accounts.txt"; //accounts file
    
    public AccountManager(){
        //users.add(new User("calvinkinateder","1234","Calvin Kinateder"));
        loadFromFile();
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
        if(!usrnm.equals("")&&!pwd.equals("")&&!scrNm.equals("")){
            users.add(new User(usrnm,pwd,scrNm));
            writeToFile(new User(usrnm,pwd,scrNm));
        }
    }
    public void loadFromFile(){
        // The name of the file to open.
        String[] ar;//string from file parsed 
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                ar=line.split(",");
                users.add(new User(ar[0],ar[1],ar[2]));
            }   
            //System.out.println(users);
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException ab){
            System.out.println("No accounts in file");
        }
        
    }
    public void writeToFile(User newUser){
        // The name of the file to open.
        String fileName = "accounts.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName,true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character./*
            bufferedWriter.append(newUser.username+",");
            bufferedWriter.append(newUser.getPassword()+",");
            bufferedWriter.append(newUser.screenName+",");
            bufferedWriter.newLine();            

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
