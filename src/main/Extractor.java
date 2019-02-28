package main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.Vector;
/**
 * Searches the webpage for a given keyword.
 * @author Calvin Kinateder
 */

public class Extractor extends Thread {
    public int maxDepth = 5; //initial depth
    private HashSet<String> alreadySearched; //no double searching
    private HashSet<String> bodiesSearched = new HashSet<>();
    private HashSet<String> titlesSearched = new HashSet<>();
    public String searchFor = "";
    public String webpage = "";
    public boolean done = false;
    private boolean stop = false;
    private String username="";
    private String password="";
    public String toBG = "";//to send to the backgroundrunner
    public String errorMsgs = "";//to send to bg too
    public ArrayList<Link> hits = new ArrayList<>();
    public int errorCount = 0;
    public boolean[] modes = {false, false};
    
    public Extractor() {        
        alreadySearched = new HashSet<>();
    }
    public Extractor(String w){
        alreadySearched = new HashSet<>();              
        webpage=w;
    }
    /**
     * Returns the number of times a specified word appears in a
     *  specified String. Uses .equals() instead of .contains()
     * @param str the block of text needing to be searched
     * @param word the word being searched for
     * Precondition: str words are separated by " ",".", or ","
     * @return the number of times the specified word appears in the 
     *  specified str
    */
    public int getFreq(String str, String word){
        String[] a = str.split(" |\\.|\\,");
        int count = 0; 
        for (int i = 0; i < a.length; i++){        
            if (word.toLowerCase().equals(a[i].toLowerCase())) 
                count++; // if match found increase count 
        }
        return count; 
    }
    /**
     * Returns the number of times a specified word appears in a
     *  specified String. Uses .contains() instead of .equals()
     * @param str the block of text needing to be searched
     * @param word the word being searched for
     * Precondition: str words are separated by " ",".", or ","
     * @return the number of times the specified word appears in the 
     *  specified str
    */
    public int getFreq2(String str, String word){
        String[] a = str.split(" |\\.|\\,");
        int count = 0; 
        for (String i : a){         
            if (i.toLowerCase().contains(word.toLowerCase())) 
                count++; // if match found increase count 
        } 
        return count; 
    }
    /**
     * Loads the webpage connected to the specified URL and, using getFreq(), 
     *  recursively finds every link and webpage containing the universal search
     *  term. 
     * Precondition: the provided login credentials are correct and URL connects
     *  successfully
     * @param URL the URL of the webpage
     * @param depth how many times the method will recursively search for the 
     *  search term
     * @param strUserId username to get past the firewall if it exists
     * @param strPassword password to get past the firewall if it exists
     * @return true if completed successfully, false if not
    */
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
                Document document = Jsoup.connect(URL) //connect to doc
                        .header("Authorization", "Basic " + encodedString)
                        .get();                    
                Elements alreadySearchedOnPage = document.select("a[href]");
                Elements txt = document.select("p");
                String article = txt.text();
                String title = document.title();
                if(getFreq(article, searchFor)>1
                        &&!bodiesSearched.contains(article)
                        &&!titlesSearched.contains(title)){                     
                    int f = getFreq2(article, searchFor); 
                    hits.add(new Link(URL, article,searchFor,title,f));
                }
                bodiesSearched.add(article);
                titlesSearched.add(title);
                depth++;
                for (Element page : alreadySearchedOnPage) {
                    searchPageLinks(page.attr("abs:href"), 
                            depth,strUserId,strPassword);
                }
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
                errorMsgs = "E:"+URL;
                errorCount++;
            }
        }        
        return true; //reached finish
    }
    /**
     * Runs the whole class.
     */
    @Override
    public void run() {
        Thread.currentThread().setName(webpage);
        System.out.println("Extractor running on "+webpage+" at max depth "
                +maxDepth);
        done = searchPageLinks(webpage, 0, username, password);
        if(stop){
            System.out.println("Extractor prematurely finished on "+webpage);
        }
        else{
            System.out.println("Extractor client successful on "+webpage);
        }        
    }    
    
    /**
     * Returns the webpage and depth as a String.
     * @return String including the page and depth
     */
    @Override
    public String toString(){
        return "Page: "+webpage+", Depth: "+maxDepth;
    }
    /*
    Accessors and modifiers
    */
    public void setModes(boolean[] m){
        modes = m;
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
}

