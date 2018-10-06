/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 * The link object stores the link, title, relevance constant
 * @author ckinateder
 */
public class Link {
    private String title;
    private String hyperlink;
    private String body;
    private double relevance;
    private boolean inProcess;
    private boolean failed = false;
    
    public Link(){
        title = ""; // avoid NullPointerException
        hyperlink = ""; // avoid NullPointerException
        relevance = -1; // not calculated
        inProcess = false;
    }
    public Link(String hyperlink){
        this.title = "no title ";
        this.hyperlink = hyperlink;
        relevance = -1; //not calculated
        inProcess = false;
    }
    public Link(String hyperlink, String body){
        this.body = body;
        this.hyperlink = hyperlink;
        relevance = -1; //not calculated
        inProcess = false;
    }
    public Link(String title, String hyperlink, double relevance){
        this.title = title;
        this.hyperlink = hyperlink;
        this.relevance = relevance;
    }
    public String getTitle(){
        return title;
    }
    public String getHyperlink(){
        return hyperlink;
    }
    public String getText(){
        return body;
    }
    public double getRelevance(){
        return relevance;
    }
    public boolean isInProcess(){
        return inProcess;
    }
    public boolean isFailed(){
        return failed;
    }
    public void setTitle(String t){
        this.title = t;
    }
    public void setText(String t){
        this.body = t;
    }
    public void setHyperlink(String t){
        this.hyperlink = t;
    }
    public void setRelevance(double t){
        this.relevance = t;
    }
    public void setInProcess(boolean t){
        this.inProcess = t;
    }
    public void setFailed(boolean t){
        this.failed = t;
    }
    @Override
    public String toString(){
        return "\nLink: "+hyperlink+""
                + "\nRelevance: "+relevance+"\nText: "
                +body+"\nIn process? "+inProcess;
    }
}
