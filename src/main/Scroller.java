package main;

import javax.swing.JLabel;

/**
 * Controls the scrolling methods
 * @author Calvin Kinateder
 */
public class Scroller {
    JLabel modifiedLbl;
    int scrollStart = 0;
    int SCROLLSIZE = 10; //add note at bottom that there is more
    BackgroundRunner lblContainer;
    /**
     * Constructor for Scroller
     * @param lblContainer the BackgroundRunner containing the sources list
     */
    public Scroller(BackgroundRunner lblContainer){        
        this.lblContainer = lblContainer;
        this.lblContainer.updateSrc();
        if(lblContainer.sources.size()<=SCROLLSIZE){
            SCROLLSIZE = lblContainer.sources.size();
        }
    }
    /**
     * Updates scrollStart and SCROLLSIZE for the finalOut pane on the GUI.
     * @param mwheel the mousewheel event
     */
    public void scrollSources(java.awt.event.MouseWheelEvent mwheel){
        int scAmount = mwheel.getWheelRotation();
        if(scrollStart+scAmount>=0 && SCROLLSIZE+scAmount<lblContainer.sources.size()+1){
            scrollStart+=scAmount;         
            SCROLLSIZE+=scAmount;
        }
        updateSources();        
    }
    /**
     * Updates the HTML String for the finalOut pane on the GUI.
     */
    public void updateSources(){
        lblContainer.updateSrc(); 
        //sort sources list with not done at the top
        String finalOut = "<html>";
        if(scrollStart>0){
            finalOut+="...<br>";
        }
        else{
            finalOut+="<br>";
        }
        for(int i = scrollStart; i<SCROLLSIZE;i++){
            String se = "";
            Link tmpLink = lblContainer.sources.get(i);
            if(tmpLink.islinkDone()){
                se = (i+1)+": <b><font color=31E13C>"+tmpLink.getHyperlink()+"</font></b>";
            }
            else if(!tmpLink.islinkDone()&&tmpLink.errors()>10){
                se = (i+1)+": <b><font color=FF7777>"+tmpLink.getHyperlink()+"</font></b>";
            }
            else if(!tmpLink.islinkDone()&&tmpLink.errors()>0){
                se = (i+1)+": <b><font color=FFD126>"+tmpLink.getHyperlink()+"</font></b>";
            }
            else{
                se = (i+1)+": "+tmpLink.getHyperlink();
            }
            finalOut=finalOut+se+"<br>";
        }
        if(lblContainer.sources.size()>SCROLLSIZE){
            finalOut+="...<br>";
        }
        finalOut+="</html>";
        modifiedLbl.setText(finalOut);
    }
    /*
     * Modifiers
     */
    public void setLabel(JLabel l){
        modifiedLbl = l;
    }
    public void setWidth(int s){
        SCROLLSIZE = s;
    }
}
