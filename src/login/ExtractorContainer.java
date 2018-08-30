/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ckinateder
 */
public class ExtractorContainer {
    //ArrayList<Extractor> container = new ArrayList<>();    
    String sourcesFile = "sources.txt";
    ArrayList<String> sources = new ArrayList<>();
    ArrayList<Thread> threads = new ArrayList<>();
    
    public ExtractorContainer(){
        createContainer();
    }
    public ExtractorContainer(String f){
        sourcesFile = f;
        createContainer();
    }
    public void updateSrc(){
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(sourcesFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                 sources.add(line);
            }
            
            //System.out.println(users);
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                sourcesFile + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + sourcesFile + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
    }
    public void add(Extractor e){
        threads.add(new Thread(e));
    }
    public void createContainer(){
        updateSrc();
        threads.clear();
        for(String src : sources){
            threads.add(new Thread(new Extractor(src)));//make new extractor for each source
        }
        System.out.println(threads.toString());
    }
    public void extract(){
        
        createContainer();
        for(Thread t : threads){
            t.start();
        }
    }
    
}
