/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.List;
import javax.swing.SwingWorker;

/**
 *
 * @author calvi
 */
public class BackgroundRunner {
    public ExtractorContainer extractorContainer;
    String searchFor;
    User currentusr;
    
    public BackgroundRunner(){
        extractorContainer = new ExtractorContainer();
        searchFor="";
        currentusr=new User();
    }
    public void setBefore(String s, User u){//set the variables relevant before running.
        searchFor = s; currentusr=u;
    }
    public SwingWorker createWorker() {
        return new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Start Progress setProgress(0);                
                // Example Loop
                extractorContainer.extract(searchFor,currentusr);
                                // Finished
                return true;
            }
            protected void process(List<Integer> chunks) {
                // Get Info
                for (int number : chunks) {
                    System.out.println("Found even number: " + number);
                }
            }
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
