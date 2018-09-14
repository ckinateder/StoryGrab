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
    JLabel theLabel;
    int scrollStart = 0;
    int scrollEnd = 10; //add note at bottom that there is more
    BackgroundRunner lr;
    public Scroller(BackgroundRunner lr){
        
        this.lr = lr;
        if(lr.sources.size()<=scrollEnd){
            scrollEnd = lr.sources.size();
        }
    }
    public void setLabel(JLabel l){
        theLabel = l;
    }
    public void setWidth(int s){
        scrollEnd = s;
    }
    public void scrollSources(java.awt.event.MouseWheelEvent mwheel){
        int scAmount = mwheel.getWheelRotation();
        //System.out.println(scAmount);
        lr.updateSrc();
        if(scrollStart+scAmount>=0 && scrollEnd+scAmount<lr.sources.size()){
            scrollStart+=scAmount;         
            scrollEnd+=scAmount;
        }
        updateSources();        
    }
    
    public void updateSources(){        
        lr.updateSrc();
        String s = "<html>";
        for(int i = scrollStart; i<scrollEnd;i++){
            String se = (i+1)+": "+lr.sources.get(i);
            s=s+se+"<br>";
        }
        s+="</html>";
        theLabel.setText(s);
        
        
    }
}
