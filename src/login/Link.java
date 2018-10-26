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
public class Link implements Comparable<Link>{
    private String title;
    private String hyperlink;
    private String body;
    private String searchFor;
    private double relevance;
    private boolean linkDone;
    private boolean failed = false;
    private int errors = 0;
    private int termFreq;
    
    public Link(){
        title = ""; // avoid NullPointerException
        hyperlink = ""; // avoid NullPointerException
        relevance = -1; // not calculated
        linkDone = false;
    }
    public Link(String hyperlink){
        this.title = "no title ";
        this.hyperlink = hyperlink;
        relevance = -1; //not calculated
        linkDone = false;
    }
    public Link(String hyperlink, String body){
        this.body = body;
        this.hyperlink = hyperlink;
        relevance = -1; //not calculated
        linkDone = false;
    }
    public Link(String hyperlink, String body, String sf, int f){
        this.body = body;
        this.hyperlink = hyperlink;
        relevance = -1; //not calculated
        linkDone = false;
        searchFor = sf;
        termFreq = f; relevance = f;
    }
    public Link(String title, String hyperlink, double relevance){
        this.title = title;
        this.hyperlink = hyperlink;
        this.relevance = relevance;
    }
    // <editor-fold defaultstate="collapsed" desc="Accessors/Modifiers">
    public String getTitle(){
        return title;
    }
    public String getHyperlink(){
        return hyperlink;
    }
    public String getText(){
        return body;
    }
    public String getSearchFor(){
        return searchFor;
    }
    public double getRelevance(){
        return relevance;
    }
    public boolean islinkDone(){
        return linkDone;
    }
    public boolean isFailed(){
        return failed;
    }
    public int errors() {
        return errors;
    }
    public int getTermFreq() {
        return termFreq;
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
    public void setSearchFor(String t){
        this.searchFor = t;
    }
    public void setRelevance(double t){
        this.relevance = t;
    }
    public void setlinkDone(boolean t){
        this.linkDone = t;
    }
    public void setFailed(boolean t){
        this.failed = t;
    }
    public void setError(int t){
        this.errors=t;
    }
    public void setTermFreq(int t){
        this.termFreq=t;
    }
    
    public void incrementTermFreq(){
        this.termFreq++;
    }
    // </editor-fold> 
    @Override
    public String toString(){
        return "\nLink: "+hyperlink+""
                + "\nRelevance: "+relevance+"\nErrors: "+errors+
                "\nSearchFor: '"+searchFor+"'\nFrequency in body: "+termFreq;
    }
    public String shortPrint(){
        return "--------\nLink: "+hyperlink+"\nTermFreq: "+termFreq;
    }

    @Override
    public int compareTo(Link o) {
        return Double.compare(this.relevance, o.getRelevance());
    }
    
    
    
}
