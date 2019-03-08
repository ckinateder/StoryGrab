package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * This class is what controls all the extractors running in the background.
 * @author Calvin Kinateder
 */
public class BackgroundRunner {
    
    String searchFor;
    User currentusr;
    final int OUTSIZE = 12;
    ArrayList<Extractor> extractors = new ArrayList<>();    
    String sourcesFile = "sources.txt";
    String finalHTML = "out/storygrab.html";
    ArrayList<Link> sources = new ArrayList<>();
    int maxDepth = 2;
    private boolean isRunning = false; //changes frequently
    String forClassifier = "src/datasets/links.csv";
    JLabel statusLblRef, outputlbl, longout, hitslbl;
    boolean shouldStop = false;
    boolean verbose = false;
    ArrayList<Link> hitLinks;
    String DB_URL = "jdbc:derby://localhost:1527/FinalLinks";
    private boolean dynamic = true;
    
    public BackgroundRunner() {        
        searchFor="";
        currentusr=new User();
        updateSrc();
    }
    /**
     * Resets all the variables in this class as an object so it can be reused 
     *  without reinitialization
     * Precondition: object has been initialized
     * Postcondition: object can be used again
     */
    public void res(){       
        extractors = new ArrayList<>();    
        sourcesFile = "sources.txt";
        String finalHTML = "out/storygrab.html";
        ArrayList<Link> sources = new ArrayList<>();
        int maxDepth = 2;
        isRunning = false; //changes frequently
        forClassifier = "src/datasets/links.csv";       
        shouldStop = false;
        verbose = false;
        DB_URL = "jdbc:derby://localhost:1527/FinalLinks";
        dynamic = true;
    }
    /**
     * Updates the sources list from the file.
     * Precondition: sourcesFile exists
     */
    public void updateSrc(){        
        if(!isRunning){
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
                backupSrcs();
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file '" 
                    + sourcesFile + "'");
                backupSrcs();
            }
        }     
    }
    /**
     * In case sources.txt cannot be used, this holds the sources too.
     */
    private void backupSrcs(){
        String bckup = "http://bbc.com/\n" +
            "http://foxnews.com/\n" +
            "http://www.huffingtonpost.com/\n" +
            "http://www.nbcnews.com/\n" +
            "http://www.nytimes.com/\n" +
            "http://www.wsj.com/\n" +
            "http://www.usatoday.com/\n" +
            "http://news.google.com/\n" +
            "http://www.rollcall.com\n" +
            "http://www.latimes.com\n" +
            "http://www.wired.com\n" +
            "http://www.cnn.com\n" +
            "http://www.npr.org\n" +
            "http://abcnews.go.com/\n" +
            "https://www.usnews.com/news\n" +
            "http://www.yahoo.com/news/\n" +
            "http://www.ap.org/en-us/\n" +
            "http://www.pewresearch.org/\n";
        String[] asArr = bckup.split("\n");
        for(String src : asArr){
            sources.add(new Link(src));
        }
    }
    /**
     * Add Extractor to the extractor list.
     * @param e Extractor to add to the list
     */
    public void add(Extractor e){
        extractors.add(e);
    }
    /**
     * Sets the recursion depth.
     * @param m depth value to set
     */
    public void setMaxDepth(int m){
        maxDepth = m;
        for(int i = 0; i<extractors.size();i++){           
            extractors.get(i).setMaxDepth(maxDepth);
        }
    }
    /**
     * Sets searchFor for every Extractor in the container list.
     * @param s String to set
     */
    public void setSearchFor(String s){ 
        //System.out.println(extractors.size());
        for(int i = 0; i<extractors.size();i++){           
            extractors.get(i).setSearchFor(s);
            //System.out.println(extractors.get(i).searchFor);
        }
    }
    /**
     * Creates the container list holding all the Extractors.
     * @param u User to setCreds with
     */
    public void createContainer(User u){
        updateSrc();
        extractors.clear();
        hitLinks.clear();
        for(Link src : sources){            
            extractors.add(new Extractor(src.getHyperlink()));//make new extractor for each source
        }
        setMaxDepth(maxDepth);
        setCreds(u);
        //System.out.println(extractors.toString());
    }
    /**
     * Gets whether the object is running.
     * @return isRunning
     */
    public boolean isRunning(){
        return isRunning;
    }
    /**
     * Sets all the credentials for each link.
     * @param u User to pass the creds on
     */
    public void setCreds(User u){        
        for(int i = 0; i<extractors.size();i++){           
            extractors.get(i).setCreds(u.getUser(), u.getPassword());
        }
    }
    /**
     * Prints all the Extractors in the list.
     */
    public void printExtractors(){
        for(Extractor e : extractors){
            System.out.println(e);
        }
        System.out.println();
    }
    /**
     * Sets shouldStop to true ands updates the sources.
     */
    public void broStop(){
        shouldStop = true;
        updateSrc();
    }
    /**
     * Finds Link with attached to source l.
     * @param l String referencing the source to be found
     * @return Link with l as the source.hyperlink
     */
    public Link findSource(String l){
        for(int i = 0; i<sources.size(); i++){
            if(sources.get(i).getHyperlink().equals(l)){
                return sources.get(i);
            }
        }
        return null;
    }
    /**
     * Counts the total number of errors for all Extractor objects.
     * @return the sum of all errors
     */
    public int totalErrors(){
        int l = 0;
        for(int i = 0; i<sources.size(); i++){
            l+=sources.get(i).errors();
        }
        return l;
    }
    /**
     * Combines all the individual extractor links into one big ArrayList
     */
    public void combine(){ //only call when joined
        for(Extractor e : extractors){
            hitLinks.addAll(e.hits);
        }
    }
    /**
     * Counts the total number of hits for all the extractors
     * @return int count of all hits
     */
    public int countAll(){
        int ct = 0;
        for(Extractor e : extractors){
            ct+=e.hits.size();
        }
        return ct;
    }
    /**
     * Cleans up the remaining variables and saves everything. Sorts hitLinks 
     *  too.
     * @return String containing any error/finishing messages
     */
    public String cleanup(){
        combine();
        shouldStop = true;
        String out = "";
        Collections.sort(hitLinks);
        //out+=Tools.saveToCSV(hitLinks, forClassifier)+"<br>";
        out+=Tools.saveToHTML(hitLinks, finalHTML, searchFor)+"<br>";          
        //out+=Tools.saveToDB(hitLinks, DB_URL);
        return out;
    }
    public SwingWorker createWorker() {
        return new SwingWorker<Boolean, String>() {
            /**
             * Collects all the Extractors and keeps track of them all to run
             *  smoothly.
             * @return true if finished successfully, false if failed
             * @throws Exception for Thread.join()
             */
            @Override
            protected Boolean doInBackground() throws Exception {
                System.out.println("Search for: "+searchFor+" User: "+currentusr);
                statusLblRef.setText("Starting...");
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
                for(int i = 0; i<OUTSIZE;i++){
                    publish("Starting..."); //fill chunks to OUTSIZE
                }
                while(!alldone){
                    isRunning = true;
                    for(int i = 0;i<extractors.size();i++){ 
                        Extractor t=extractors.get(i);
                        if(!t.isAlive()&&!used.contains(t)){
                            used.add(t);
                            leftToDo--;
                            //set tmp vars
                            double s = extractors.size();
                            double l = leftToDo;
                            double sm = s-l;
                            findSource(t.getWebpage()).setlinkDone(true);                            
                            System.out.println();
                            System.out.println("Done: ");
                            for(Extractor e : used){
                                System.out.println("\t"+e);
                            }
                            System.out.println();                            
                            percent=(int) ((sm/s)*100);
                            statusLblRef.setText("Extracting... "+percent+"%"); //set label
                            
                        }                        
                        publish(t.toBG);//publish output to process   
                        if(!t.errorMsgs.equals("")){
                             publish("<font color=FFD126>"+t.errorMsgs+"</font>");
                             findSource(t.getWebpage()).setError(t.errorCount);
                        }                       
                        if(shouldStop){
                            publish("Cancelled by user - syncing threads");
                            for(Extractor ts : extractors){
                                publish("Extractor termination on "+ts.getWebpage());
                                ts.setStop(true);
                            }
                            for(Thread tt : extractors){
                                tt.join();                    
                            }
                            publish("Saving to database");
                            shouldStop = false; //so loader can be used again
                            isRunning = false; //update this
                            return false;
                        }      
                    }
                    if(leftToDo==0){
                        alldone=true;
                    }
                }
                publish("Finished successfully - saving to database");
                for(Thread t : extractors){
                    t.join();                    
                }
                publish("Completed");
                isRunning = false;
                // Finished
                return true;
            }
            /**
             * Part of formatting the output.
             * @param chunks List of strings to publish to the output labels
             */
            protected void process(List<String> chunks) {
                // Get Info             
                String currentOut = "";
                currentOut = chunks.get(chunks.size()-1);
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
                hitslbl.setText(/*"Hits: "+*/countAll()+"");
                if(dynamic){Tools.saveToHTML(hitLinks, finalHTML, searchFor);}  
            }
            /**
             * What to do when the processing is finished.
             */
            @Override
            protected void done() {                
                boolean bStatus = false;
                try {
                    bStatus = get();                   
                    statusLblRef.setText("");                    
                    publish(cleanup());
                    if(bStatus){
                        System.out.println("Done on all!");
                    } 
                    else{
                        publish("<br><br>"
                                + "Finished<br>");
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }
            }

        };
    } // End of Method: createWorker()    
    /**
     * Accessors and modifiers.
     */
    public void passVec(ArrayList h){
        hitLinks = h;
    }
    
    void setDynamic(boolean t) {
        dynamic = t;
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
        longout.setText("");
    }
    void passHitsLbl(JLabel l) {
        hitslbl = l;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
    public void setBefore(String s, User u){//set the variables relevant before running.
        searchFor = s; currentusr=u;
    }    
    public void setVerbose(boolean j){
        verbose = j;
    }
}
