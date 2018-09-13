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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author calvi
 */
public class BackgroundRunner {
    
    String searchFor;
    User currentusr;
    ArrayList<Extractor> extractors = new ArrayList<>();    
    String sourcesFile = "sources.txt";
    ArrayList<String> sources = new ArrayList<>();
    //ArrayList<Thread> extractors = new ArrayList<>();
    int maxDepth = 2;
    private boolean isRunning = false; //changes frequently
    ExecutorService executor;
    List<Future<?>> futures = new ArrayList<Future<?>>();
    String extractorFile = "links.txt";
    JLabel statusLblRef, outputlbl;
    
    
    public BackgroundRunner(){
        
        searchFor="";
        currentusr=new User();
        updateSrc();
        
    }
    public void passLbl(JLabel l){
        statusLblRef = l;
        statusLblRef.setText("");
        
    }
    public void passInitializedOP(JLabel l){
        outputlbl = l;
        outputlbl.setText("");
    }
    public void setBefore(String s, User u){//set the variables relevant before running.
        searchFor = s; currentusr=u;
    }
    
    public void updateSrc(){
        sources.clear();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(sourcesFile);
           
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
            sources.add("Unable to open file '" + 
                sourcesFile + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + sourcesFile + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
            sources.add("Error reading file '" 
                + sourcesFile + "'");     
        }
        
    }
    public void add(Extractor e){
        extractors.add(e);
    }
    public void setMaxDepth(int m){
        maxDepth = m;
        for(int i = 0; i<extractors.size();i++){           
            extractors.get(i).setMaxDepth(maxDepth);
        }
    }
    public int getMaxDepth(){
        return maxDepth;
    }
    public void setSearchFor(String s){ 
        //System.out.println(extractors.size());
        for(int i = 0; i<extractors.size();i++){           
            extractors.get(i).setSearchFor(s);
            //System.out.println(extractors.get(i).searchFor);
        }
    }
    public void createContainer(User u){
        updateSrc();
        extractors.clear();
        
        for(String src : sources){
            //if(!src.equals())
                extractors.add(new Extractor(src));//make new extractor for each source
        }
        setMaxDepth(maxDepth);
        setCreds(u);
        //System.out.println(extractors.toString());
    }
    public boolean isRunning(){
        return isRunning;
    }
    public void setCreds(User u){        
        for(int i = 0; i<extractors.size();i++){           
            extractors.get(i).setCreds(u.getUser(), u.getPassword());
        }
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
    public void printExtractors(){
        for(Extractor e : extractors){
            System.out.println(e);
        }
        System.out.println("");
    }
    
    public SwingWorker createWorker() {
        return new SwingWorker<Boolean, String>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Start Progress setProgress(0);                
                // Example Loop
                
                System.out.println("Search for: "+searchFor+" User: "+currentusr);
                statusLblRef.setText("Extracting...");
                writeToFile(extractorFile,"", false); //overwrite the file
                createContainer(currentusr);
                setSearchFor(searchFor);
                printExtractors();//print all extractors
                for(Extractor e : extractors){
                   e.start();//make new thread for each extractor
                }
                
                /*                
                for(Thread t : extractors){
                    //Future<?> f = executor.submit(t);
                    //futures.add(f);
                    t.start();
                }
                *//*
                
                */
                boolean alldone=false;
                int leftToDo = extractors.size();
                int percent = 0;
                ArrayList<Extractor> used = new ArrayList<>();
                statusLblRef.setText("Extracting... "+percent+"%");
                while(!alldone){
                    for(Extractor t:extractors){
                        
                        if(!t.isAlive()&&!used.contains(t)){
                            //System.out.println("Done on "+t);
                            used.add(t);
                            leftToDo--;
                            //set tmp vars
                            double s = extractors.size();
                            double l = leftToDo;
                            double sm = s-l;
                            String wp = t.getWebpage();//send that somehow
                            System.out.println("Done: ");
                            for(Extractor e : used){
                                System.out.println("\t"+e);
                            }
                            System.out.println("");
                            
                            percent=(int) ((sm/s)*100);
                            statusLblRef.setText("Extracting... "+percent+"%"); //set label
                            
                        }
                        publish(t.toBG.toString());//publish output to process
                        
                        if(isCancelled()){
                            System.out.println("awefa efaewcawedcef waef ed");
                            return false;
                        }
                        
                    }
                    if(leftToDo==0){
                        alldone=true;
                    }
                }
                for(Thread t : extractors){
                    //Future<?> f = executor.submit(t);
                    //futures.add(f);
                    t.join();
                    
                }
                // Finished
                return true;
            }
            protected void process(List<String> chunks) {
                // Get Info
                //statusLblRef.setText(chunks.get(chunks.size()-1)+"%");
                String currentOut = "";
                currentOut= chunks.get(chunks.size()-1);
                outputlbl.setText(currentOut);
                
            }
            @Override
            protected void done() {
                
                boolean bStatus = false;
                try {
                    bStatus = get();                   
                    statusLblRef.setText("");
                    if(bStatus ==true){
                    System.out.println("Done on all!");
                    }
                    else{
                        System.out.println("Cancelled by user");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }               
                
                
            }
        };
    } // End of Method: createWorker()
}
