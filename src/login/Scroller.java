/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * Controls the scrolling methods
 * @author ckinateder
 */
public class Scroller {
    JLabel modifiedLbl;
    int scrollStart = 0;
    int SCROLLSIZE = 10; //add note at bottom that there is more
    BackgroundRunner lblContainer;
    //ArrayList<Link> sources;
    public Scroller(BackgroundRunner lblContainer){        
        this.lblContainer = lblContainer;
        //sources = lblContainer.sources;
        if(lblContainer.sources.size()<=SCROLLSIZE){
            SCROLLSIZE = lblContainer.sources.size();
        }
    }/*
    public Scroller(ArrayList lst, int size){
        SCROLLSIZE = size;
        sources = lst;
        if(sources.size()<=SCROLLSIZE){
            SCROLLSIZE = sources.size();
        }
    }*/
    public void setLabel(JLabel l){
        modifiedLbl = l;
    }
    public void setWidth(int s){
        SCROLLSIZE = s;
    }
    public void scrollSources(java.awt.event.MouseWheelEvent mwheel){
        int scAmount = mwheel.getWheelRotation();
        //System.out.println(scAmount);
        //add empty catch in here
        if(scrollStart+scAmount>=0 && SCROLLSIZE+scAmount<lblContainer.sources.size()+1){
            scrollStart+=scAmount;         
            SCROLLSIZE+=scAmount;
        }
        updateSources();        
    }
    
    public void updateSources(){
        lblContainer.updateSrc(); 
        //sort sources list with not done at the top...
        
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
            //System.out.println(tmpLink);
            if(tmpLink.islinkDone()){ //really done, maybe change var name
                se = (i+1)+": <b><font color=31E13C>"+tmpLink.getHyperlink()+"</font></b>";
            }
            else if(!tmpLink.islinkDone()&&tmpLink.errors()>10){
                se = (i+1)+": <b><font color=FF7777>"+tmpLink.getHyperlink()+"</font></b>";
            }/*
            else if(!tmpLink.islinkDone()&&tmpLink.errors()>5){
                se = (i+1)+": <font color=FA8500>"+tmpLink.getHyperlink()+"</font>";
            }*/
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
}
