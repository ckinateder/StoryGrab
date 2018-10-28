/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import javax.swing.*;
import java.util.List;
import java.util.Vector;
/**
 * Refreshes the state of Link objects once every WAIT ms
 * @author calvin
 */
public class AutomaticScrollUpdater {
    Scroller scroller;
    final int WAIT = 200;    
    public AutomaticScrollUpdater(Scroller s){
        scroller = s;
    }    
    public SwingWorker createWorker() {
        return new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Start Progress
                waitFor(1000);
                setProgress(0);
                while(true){
                    scroller.updateSources();                    
                    waitFor(WAIT);
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

    /**
     * Wait the given time in milliseconds
     * @param iMillis
     */
    private void waitFor (int iMillis) {
        try {
            Thread.sleep(iMillis);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
