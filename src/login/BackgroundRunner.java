/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * This class is what controls all the extractors running in the background
 * @author calvin kinateder
 */
public class BackgroundRunner {
    
    String searchFor;
    User currentusr;
    final int OUTSIZE = 12;
    ArrayList<Extractor> extractors = new ArrayList<>();    
    String sourcesFile = "sources.txt";
    //ArrayList<Link> sources = new ArrayList<>();
    Vector<Link> sources = new Vector<>();
    //ArrayList<Thread> extractors = new ArrayList<>();
    int maxDepth = 2;
    private boolean isRunning = false; //changes frequently
    ExecutorService executor;
    List<Future<?>> futures = new ArrayList<Future<?>>();
    String extractorFile = "links.txt";
    JLabel statusLblRef, outputlbl, longout, hitslbl;
    boolean shouldStop = false;
    boolean verbose = false;
    Vector<Link> hitLinks;
    public BackgroundRunner(){
        
        searchFor="";
        currentusr=new User();
        updateSrc();
        
    }
    public void passVec(Vector h){
        hitLinks = h;
    }
    public void passLbl(JLabel l){
        statusLblRef = l;
        statusLblRef.setText("");        
    }
    public void passInitializedOP(JLabel l){
        outputlbl = l;
        outputlbl.setText("");
    }
    void passBigOut(JLabel l) {
        longout = l;
    }
    void passHitsLbl(JLabel l) {
        hitslbl = l;
    }
    public void setBefore(String s, User u){//set the variables relevant before running.
        searchFor = s; currentusr=u;
    }
    
    public void updateSrc(){
        //check if sources in proc
        /*
        boolean anyInProc = false;
        for(Link l : sources){
            if(l.islinkDone()){
                anyInProc = true;
            }
        }*/
        if(!isRunning){
            //none in proc
            sources.clear();
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader(sourcesFile);

                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                     sources.add(new Link(line));
                }            
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
            }
        }
        else{
            //currently running, do nothing
            //send a message 
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
        hitLinks.clear();
        for(Link src : sources){            
            extractors.add(new Extractor(src.getHyperlink(), hitLinks));//make new extractor for each source
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
    public void broStop(){
        shouldStop = true;
        updateSrc();
    }
    public void setVerbose(boolean j){
        verbose = j;
    }
    public Link findSource(String l){
        for(int i = 0; i<sources.size(); i++){
            if(sources.get(i).getHyperlink().equals(l)){
                return sources.get(i);
            }
        }
        return null;
    }
    public int totalErrors(){
        int l = 0;
        for(int i = 0; i<sources.size(); i++){
            l+=sources.get(i).errors();
        }
        return l;
    }
    public SwingWorker createWorker() {
        return new SwingWorker<Boolean, String>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Start Progress setProgress(0);                
                // Example Loop
                //updateSrc();
                System.out.println("Search for: "+searchFor+" User: "+currentusr);
                statusLblRef.setText("Starting...");
                writeToFile(extractorFile,"", false); //overwrite the file
                createContainer(currentusr);
                setSearchFor(searchFor);
                printExtractors();//print all extractors
                for(Extractor e : extractors){
                    e.setModes(new boolean[] {true, true});
                   e.start();//make new thread for each extractor
                }               
                boolean alldone=false;
                int leftToDo = extractors.size();
                int percent = 0;
                ArrayList<Extractor> used = new ArrayList<>();
                statusLblRef.setText("Extracting... "+percent+"%");
                for(int i = 0; i<12;i++){
                    publish("Starting..."); //fill chunks to ten
                }
                while(!alldone){
                    isRunning = true;
                    for(int i = 0;i<extractors.size();i++){ 
                        Extractor t=extractors.get(i);
                        if(!t.isAlive()&&!used.contains(t)){
                            //System.out.println("Done on "+t);
                            used.add(t);
                            leftToDo--;
                            //set tmp vars
                            double s = extractors.size();
                            double l = leftToDo;
                            double sm = s-l;
                            //String wp = t.getWebpage();//send that somehow
                            //search sources for t.getWeb
                            //System.out.println(findSource(t.getWebpage()));
                            findSource(t.getWebpage()).setlinkDone(true);                            
                            System.out.println();
                            System.out.println("Done: ");
                            for(Extractor e : used){
                                System.out.println("\t"+e);
                            }
                            System.out.println("");
                            
                            percent=(int) ((sm/s)*100);
                            statusLblRef.setText("Extracting... "+percent+"%"); //set label
                            
                        }                        
                        publish(t.toBG);//publish output to process   
                        if(!t.errorMsgs.equals("")){
                             publish("<font color=FFD126>"+t.errorMsgs+"</font>");
                             //maybe find source and flash it for .2 s
                             findSource(t.getWebpage()).setError(t.errorCount);
                             //maybe have a waitfor
                        }
                       
                        if(shouldStop){
                            publish("Cancelled by user");
                            for(Extractor ts : extractors){
                                ts.setStop(true);
                            }
                            
                            shouldStop = false; //so loader can be used again
                            isRunning = false; //update this
                            return false;
                        }      
                    }
                    if(leftToDo==0){
                        alldone=true;
                    }
                }
                for(Thread t : extractors){
                    t.join();                    
                }
                publish("Completed");
                isRunning = false;
                // Finished
                return true;
            }
            protected void process(List<String> chunks) {
                // Get Info
                //statusLblRef.setText(chunks.get(chunks.size()-1)+"%");
                
                String currentOut = "";
                currentOut = chunks.get(chunks.size()-1);
                //currentOut+="</html>";
                outputlbl.setText("<html>"+currentOut+"</html>");
                int st = chunks.size()-OUTSIZE;
                if(st<0){
                    st=0;
                }
                if(verbose){
                    String bo; //no scroll
                    bo = "<html><br>";
                    for(int i = st; i<chunks.size();i++){
                        String se = chunks.get(i).replaceAll("Searching ", "");
                        bo=bo+se+"<br>";
                    }
                    bo+="</html>";
                    longout.setText(bo);
                }
                else{
                    longout.setText("");
                }
                hitslbl.setText(/*"Hits: "+*/hitLinks.size()+"");
            }
            @Override
            protected void done() {                
                boolean bStatus = false;
                try {
                    bStatus = get();                   
                    statusLblRef.setText("");
                    if(bStatus ==true){
                        System.out.println("Done on all!");
                        for(Link l : hitLinks){
                            System.out.println(l);
                        }
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
