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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author calvin kinateder
 */

public class Extractor extends Thread {
    public int maxDepth = 5;
    private HashSet<String> links;
    public String searchFor = "politics";
    StringBuilder sb;
    String file="links.txt";
    public String webpage = "";
    public boolean done = false;
    private String username="";
    private String password="";
    public String toBG = "";//to send to the backgroundrunner
    //add search string and accessor
    public String errorMsgs = "";//to send to bg too
    public Extractor() {
        links = new HashSet<>();
        sb = new StringBuilder();
        
    }/*
    public Extractor(String f) {
        links = new HashSet<>();
        sb = new StringBuilder();
        file=f;
    }*/
    public Extractor(String w){
        links = new HashSet<>();
        sb = new StringBuilder();
        //file=f;
        webpage=w;
    }
    
    public void writeToFile(String fileName, String toWrite, boolean append){
        // The name of the file to open.
        //String fileName = "accounts.txt";

        try {
            // Assume default encoding.
            
            FileWriter fileWriter =
                new FileWriter(fileName,append);//add true to append

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character./*
            bufferedWriter.write(toWrite);
            //bufferedWriter.newLine();            
            
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
    
    public void getPageLinks(String URL, int depth) {
        try {
            if ((!links.contains(URL) && (depth < maxDepth))) {
                //System.out.println("Depth: " + depth + " [" + URL + "]");
                //sb.append(URL + "\n");//add to the thing to be written 
                FileWriter fileWriter =
                new FileWriter(file,true);//add true to append

            // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
                bufferedWriter.write(URL+"\n");
                bufferedWriter.close();
                try {
                    links.add(URL); //add link to the hashset
                    Document document = Jsoup.connect(URL).get();
                    Elements linksOnPage = document.select("a[href]");
                    depth++;
                    for (Element page : linksOnPage) { //iterate through links on page
                        getPageLinks(page.attr("abs:href"), depth);
                    }                

                } catch (IOException | IllegalArgumentException e) {
                    System.err.println("For '" + URL + "': " + e.getMessage());
                }
            }
            

        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + file + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        
    }
    public boolean searchPageLinks(String URL, int depth, String strUserId, String strPassword) {//returns true when done
        try {
            
            String authString = strUserId + ":" + strPassword;
            String encodedString = 
                    Base64.getEncoder().encodeToString(authString.getBytes());
            
            if ((!links.contains(URL) && (depth < maxDepth))) {
                
                //sb.append(URL + "\n");//add to the thing to be written 
                FileWriter fileWriter =
                new FileWriter(file,true);//add true to append

            // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
                //System.out.println("Searching  "+URL);//print output
                toBG="Searching "+URL+"\n";//add to toBG
               //could use file
                try {
                    links.add(URL); //add link to the hashset
                    Document document = Jsoup.connect(URL)
                            .header("Authorization", "Basic " + encodedString)
                            .get();
                    
                    Elements linksOnPage = document.select("a[href]");
                    if(document.text().toLowerCase().contains(searchFor.toLowerCase())||
                            URL.toLowerCase().contains(searchFor.toLowerCase())){//search in doc and link
                    //System.out.println("ARTICLE CONTAINS :: "+searchFor);
                        bufferedWriter.write(URL+"\n"); //only write if theres search term
                        //bufferedWriter.write("LINK: "+URL+"\nTEXT:\n"+document.text()+"\n\n");
                    }
                    bufferedWriter.close();
                    depth++;
                    
                    for (Element page : linksOnPage) { //iterate through links on page
                        
                            searchPageLinks(page.attr("abs:href"), depth,strUserId,strPassword);
                        
                        
                    }                

                } catch (IOException | IllegalArgumentException e) {
                    System.err.println("For '" + URL + "': " + e.getMessage());
                    errorMsgs = "E: " + e.getMessage() + " on "+ URL + "" ;
                }
                
            }
            

        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + file + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return true;
    }
    public void setWebpage(String l){
        webpage = l;
    }
    public String getWebpage(){
        return webpage;
    }
    public void setMaxDepth(int i){
        maxDepth=i;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
    public void setSearchFor(String s){
        searchFor = s;
    }
    public String getSearchFor(){
        return searchFor;
    }
    public void setCreds(String u, String p){
        username = u;
        password = p;
    }
    /*
    public void setDone(boolean d){
        done=d;
    }
    public boolean isDone(){
        return done;
    }*/
    @Override
    public void run() {// l is link
       // writeToFile(file,"", false); //overwrite the file
        System.out.println("Extractor running on "+webpage+" at max depth "+maxDepth);        
        //getPageLinks(webpage, 0);
        done = searchPageLinks(webpage, 0, username, password); //done probs not needed
        //if(Thread.currentThread().isInterrupted()){            
            System.out.println("Extractor client done on "+webpage);            
        
    }
    public String toString(){
        return "Page: "+webpage+", Depth: "+maxDepth+", File: "+file;
    }

}

