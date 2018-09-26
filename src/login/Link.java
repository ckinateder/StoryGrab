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
    private String title, hyperlink, text;
    private double relevance;
    public Link(){
        title = ""; // avoid NullPointerException
        hyperlink = ""; // avoid NullPointerException
        relevance = -1; // not calculated
    }
    public Link(String hyperlink){
        this.title = "no title ";
        this.hyperlink = hyperlink;
        relevance = -1; //not calculated
    }
    public Link(String hyperlink, String text){
        this.text = text;
        this.hyperlink = hyperlink;
        relevance = -1; //not calculated
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
        return text;
    }
    public double getRelevance(){
        return relevance;
    }
    public void setTitle(String t){
        this.title = t;
    }
    public void setText(String t){
        this.text = t;
    }
    public void setHyperlink(String t){
        this.hyperlink = t;
    }
    public void setRelevance(double t){
        this.relevance = t;
    }
    
    @Override
    public String toString(){
        return "\nLink: "+hyperlink+""
                + "\nRelevance: "+relevance+"\nText: "+text;
    }
}
