/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author ckinateder
 */
public class Scroller {
    JLabel modifiedLbl;
    int scrollStart = 0;
    int SCROLLSIZE = 10; //add note at bottom that there is more
    BackgroundRunner lblContainer;
    public Scroller(BackgroundRunner lblContainer){
        
        this.lblContainer = lblContainer;
        if(lblContainer.sources.size()<=SCROLLSIZE){
            SCROLLSIZE = lblContainer.sources.size();
        }
    }
    public void setLabel(JLabel l){
        modifiedLbl = l;
    }
    public void setWidth(int s){
        SCROLLSIZE = s;
    }
    public void scrollSources(java.awt.event.MouseWheelEvent mwheel){
        int scAmount = mwheel.getWheelRotation();
        //System.out.println(scAmount);
        //lblContainer.updateSrc();
        if(scrollStart+scAmount>=0 && SCROLLSIZE+scAmount<lblContainer.sources.size()+1){
            scrollStart+=scAmount;         
            SCROLLSIZE+=scAmount;
        }
        updateSources();        
    }
    
    public void updateSources(){
        String s = "<html>";
        if(scrollStart>0){
            s+="...<br>";
        }
        else{
            s+="<br>";
        }
        for(int i = scrollStart; i<SCROLLSIZE;i++){
            String se = "";
            Link tmpLink = lblContainer.sources.get(i);
            //System.out.println(tmpLink);
            if(tmpLink.isInProcess()){
                se = (i+1)+": <b><font color=green>"+tmpLink.getHyperlink()+"</font></b>";
            }
            else{
                se = (i+1)+": "+tmpLink.getHyperlink();
            }
            s=s+se+"<br>";
        }
        if(lblContainer.sources.size()>SCROLLSIZE){
            s+="...<br>";
        }
        s+="</html>";
        modifiedLbl.setText(s);
        
        
    }
}
