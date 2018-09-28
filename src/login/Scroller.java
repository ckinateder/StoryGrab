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
    int scrollEnd = 10-1; //add note at bottom that there is more
    BackgroundRunner lblContainer;
    public Scroller(BackgroundRunner lblContainer){
        
        this.lblContainer = lblContainer;
        if(lblContainer.sources.size()<=scrollEnd){
            scrollEnd = lblContainer.sources.size();
        }
    }
    public void setLabel(JLabel l){
        modifiedLbl = l;
    }
    public void setWidth(int s){
        scrollEnd = s;
    }
    public void scrollSources(java.awt.event.MouseWheelEvent mwheel){
        int scAmount = mwheel.getWheelRotation();
        //System.out.println(scAmount);
        lblContainer.updateSrc();
        if(scrollStart+scAmount>=0 && scrollEnd+scAmount<lblContainer.sources.size()+1){
            scrollStart+=scAmount;         
            scrollEnd+=scAmount;
        }
        updateSources();        
    }
    
    public void updateSources(){        
        lblContainer.updateSrc();
        String s = "<html>";
        for(int i = scrollStart; i<scrollEnd;i++){
            String se = (i+1)+": "+lblContainer.sources.get(i);
            s=s+se+"<br>";
        }
        if(lblContainer.sources.size()-1>scrollEnd){
            s+="...<br>";
        }
        s+="</html>";
        modifiedLbl.setText(s);
        
        
    }
}
