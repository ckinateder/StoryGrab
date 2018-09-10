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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    ArrayList<Thread> threads = new ArrayList<>();
    int maxDepth = 2;
    private boolean isRunning = false; //changes frequently
    ExecutorService executor;
    
    
    public BackgroundRunner(){
        
        searchFor="";
        currentusr=new User();
        updateSrc();
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
        threads.add(new Thread(e));
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
        threads.clear();
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
    }/*
    public boolean isDone(){
        boolean y = true;
        for(Thread t : threads){
            if(t.isAlive()){
                y=false;
            }
        }
        return y;
    }
   */
    public void setCreds(User u){        
        for(int i = 0; i<extractors.size();i++){           
            extractors.get(i).setCreds(u.getUser(), u.getPassword());
        }
    }
    public void extract(String s, User u) throws InterruptedException{
        System.out.println("Search for: "+s+" User: "+u);
        createContainer(u);
        setSearchFor(s);
        executor = Executors.newFixedThreadPool(extractors.size());
        for(Extractor e : extractors){
           threads.add(new Thread(e));//make new thread for each extractor
        }
        System.out.println(Arrays.toString(threads.toArray()));
        for(Thread t : threads){
            executor.execute(t);
            //t.start();
        }
        executor.shutdown(); 
        //send no more
        //add some join thing not sure yet tho
        /*
        Future<?> f = exec.submit(extractor); 
        futures.add(f);
        
        boolean allDone = true;
        for(Future<?> future : futures){
            allDone &= future.isDone(); // check if future is done
        }
        */
    }
    
    public SwingWorker createWorker() {
        return new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Start Progress setProgress(0);                
                // Example Loop
                extract(searchFor,currentusr);
                                // Finished
                return true;
            }/*
            protected void process(List<Integer> chunks) {
                // Get Info
                
            }*/
            @Override
            protected void done() {
                boolean bStatus = false;
                try {
                    bStatus = get();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Finished with status " + bStatus);
            }
        };
    } // End of Method: createWorker()
}
