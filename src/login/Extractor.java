/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.io.BufferedWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 *
 * @author calvin kinateder
 */

public class Extractor {
    public static int MAX_DEPTH = 5;
    private HashSet<String> links;
    StringBuilder sb;
    String file="links.txt";

    
    public Extractor() {
        links = new HashSet<>();
        sb = new StringBuilder();
        
    }
    public Extractor(String f) {
        links = new HashSet<>();
        sb = new StringBuilder();
        file=f;
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
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            System.out.println("Depth: " + depth + " [" + URL + "]");
            sb.append(URL + "\n");//add to the thing to be written 
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
    
    
    public void extract(String l,boolean append) {// l is link, append is true if you want to append
        getPageLinks(l, 0);
        writeToFile(file,sb.toString()+"\nEOF", append);
        System.out.println("Done");
    }

}

