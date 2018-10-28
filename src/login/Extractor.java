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
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringUtils;
/**
 * This class is what searches the webpage
 * @author calvin kinateder
 */

public class Extractor extends Thread {
    public int maxDepth = 5;
    private HashSet<String> alreadySearched;
    private HashSet<String> bodiesSearched = new HashSet<>();
    public String searchFor = "";    
    private String file="links.txt";
    public String webpage = "";
    public boolean done = false;
    private boolean stop = false;
    private String username="";
    private String password="";
    public String toBG = "";//to send to the backgroundrunner
    public String errorMsgs = "";//to send to bg too
    public Vector dynamicSet;
    public int errorCount = 0;
    public boolean[] modes = {false, false};
    public Extractor() {
        alreadySearched = new HashSet<>();
    }
    public Extractor(String w, Vector ps){
        alreadySearched = new HashSet<>();              
        webpage=w;
        dynamicSet = ps;
    }
    public void setModes(boolean[] m){
        modes = m;
    }    
    public int getFreq(String str, String word){
        String a[] = str.split(" |\\.|\\,"); 
        int count = 0; 
        for (int i = 0; i < a.length; i++){ 
        // if match found increase count 
            if (word.toLowerCase().equals(a[i].toLowerCase())) 
                count++; 
        } 
        return count; 
    }
    public boolean searchPageLinks(String URL, int depth, String strUserId, 
            String strPassword) {//returns true when done        
        errorMsgs = "";            
        String authString = strUserId + ":" + strPassword;
        String encodedString = //need to authenticate for firewall
                Base64.getEncoder().encodeToString(authString.getBytes());            
        if ((!alreadySearched.contains(URL) && (depth < maxDepth))&&!stop) {                               
            toBG=""+URL+"\n";//add to toBG
            try {                    
                alreadySearched.add(URL); //add link to the hashset
                Document document = Jsoup.connect(URL)
                        .header("Authorization", "Basic " + encodedString)
                        .get();                    
                Elements alreadySearchedOnPage = document.select("a[href]");
                Elements txt = document.select("p");
                String article = txt.text();
                //bodiesSearched.add(article);
                /*if(article.toLowerCase().contains
                        (searchFor.toLowerCase()))||
                    (URL.toLowerCase().contains(searchFor.toLowerCase())&&
                        modes[1]))*/
                if(getFreq(article, searchFor)>1){                                        
                    int f = getFreq(article, searchFor); //doesnt work rn
                    dynamicSet.add(new Link(URL, article,searchFor,f));
                }
                depth++;
                for (Element page : alreadySearchedOnPage) {
                    searchPageLinks(page.attr("abs:href"), 
                            depth,strUserId,strPassword);
                }
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
               // errorMsgs = "E: " + e.getMessage() + " on "+ URL + "" ;
                errorMsgs = "E:"+URL;
                errorCount++;
            }
        }
        
        return true;
    }
    public void setStop(boolean t) {
        stop = t;
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
   
    @Override
    public void run() {// l is link
        System.out.println("Extractor running on "+webpage+" at max depth "
                +maxDepth);
        done = searchPageLinks(webpage, 0, username, password);
        if(stop){
            System.out.println("Extractor error finishing on "+webpage);
        }else{
            System.out.println("Extractor client successful on "+webpage);
        }        
    }
    public String toString(){
        return "Page: "+webpage+", Depth: "+maxDepth+", File: "+file;
    }
}

