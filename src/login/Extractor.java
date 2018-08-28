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
 * https://www.mkyong.com/java/jsoup-basic-web-crawler-example/
 */

public class Extractor {
    
    public static void writeToFile(String fileName, String toWrite){
        // The name of the file to open.
        //String fileName = "accounts.txt";

        try {
            // Assume default encoding.
            System.out.println("dude");
            FileWriter fileWriter =
                new FileWriter(fileName,true);

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
    
    public static void parsePage(String fileName) {
        try {
            // fetch the document over HTTP
            Document doc = Jsoup.connect("http://google.com").get();

            // get the page title
            String title = doc.title();
            System.out.println("title: " + title);

            // get all links in page
            Elements links = doc.select("a[href]");
            StringBuilder sb = new StringBuilder();
            for (Element link : links) {
              // get the value from the href attribute
              /*
              System.out.println("\nlink: " + link.attr("href"));
              System.out.println("text: " + link.text());*/
              sb.append("link: "+link.attr("href")+"\n"+"Text: "+link.text()+"\n");

            }
            System.out.println(sb.toString());
            writeToFile(fileName, sb.toString());
        } 
        catch (IOException e) {
        e.printStackTrace();
        }
  }
}

