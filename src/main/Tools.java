package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

/**
 * Contains functions needed for saving data.
 * @author Calvin Kinateder
 */
public abstract class Tools {
    public static String delim ="---split---";
    /**
     * Writes String toWrite to a specified file.
     * @param fileName the name of the file to write to
     * @param toWrite the String to be written to the file
     * @param append boolean determining whether the file should be overwritten
     *  or appended to
     */
    public static void writeToFile(String fileName, String toWrite, 
            boolean append){        
        try {
            // Assume default encoding.            
            FileWriter fileWriter =
                new FileWriter(fileName,append);//add true to append
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(toWrite);
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    /**
     * Saves the contents of hitLinks to a database
     * @param hitLinks Vector containing all links that need to be written to
     *  the database
     * @param DB_URL String that holds the URL to the database
     * @return String noting any completion or error messages
     */
    public static String saveToDB(Vector<Link> hitLinks, String DB_URL) {
        //sort hitLinks
        Collections.sort(hitLinks);
        try {
            Connection conn = DriverManager.getConnection(DB_URL, "calvin", "2255");
            PreparedStatement dlt = conn.prepareStatement("DELETE FROM LINKS WHERE 1=1");
            dlt.executeUpdate();
            PreparedStatement ps = conn.prepareStatement("insert into LINKS(RELEVANCE,URL)"
                        + "values(?,?)");            
            for(Link l : hitLinks){                
                ps.setDouble(1, l.getRelevance());                    
                //ps.setInt(2, l.errors());
                //ps.setBoolean(3, l.isFailed());
                ps.setString(2, l.getHyperlink());
                //System.out.println(ps.executeUpdate());
                ps.executeUpdate();
            }
            return "Succesfully wrote to database";
        } catch (SQLException ex) {
            //Logger.getLogger(BackgroundRunner.class.getName()).log(Level.SEVERE, null, ex);
            return "Could not write to database";
        }
        
    }
    /**
     * Saves the contents of hitLinks to a CSV file.
     * @param hitLinks Vector containing all links that need to be written to
     *  the database
     * @param forClassifier String to put at the beginning of the file for the
     *  Python classifying algorithm- this is not in use
     * @return String noting any completion or error messages
     */
    public static String saveToCSV(Vector<Link> hitLinks, String forClassifier){
         FileWriter fileWriter =
                    null;
        try {
            fileWriter = new FileWriter(forClassifier,false); //add true to append
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);
            for(Link l : hitLinks){
                bufferedWriter.write(Tools.delim+l.getRelevance()+Tools.delim);  //delim -s ','            
                bufferedWriter.write(l.getHyperlink()+Tools.delim);
                bufferedWriter.write(l.getText()+"\n");             
            }
            bufferedWriter.close();
            fileWriter.close();
            return "Succesfully wrote to CSV";
        } 
        catch (IOException ex) {
            //Logger.getLogger(BackgroundRunner.class.getName()).log(Level.SEVERE, null, ex);
            return "Could not write to CSV";
        }
    }
    /**
     * Saves the contents of hitLinks to an HTML file to be viewed in a browser.
     * @param hitLinks hitLinks Vector containing all links that need to be written to
     *  the database
     * @param finalHTML the final HTML file containing all the links sorted by
     *  relevance for easy viewing
     * @param searchFor the term that the links were searched for
     * @return String noting any completion or error messages
     */
    public static String saveToHTML(Vector<Link> hitLinks, String finalHTML, String searchFor){
        //Collections.sort(hitLinks);
        Vector<Link> copy = new Vector(hitLinks);
        Collections.sort(copy);
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
        "<html>\n" +
        "	<head>\n" +
        "		<title>StoryGrab</title>\n" +
        "		<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n" +
        "	</head>\n" +
        "	<body>\n" +
        "		<div class=\"gee\">\n" +
        "			<span class=\"title1\">StoryGrab</span>\n" +
                        "<span class=\"hits\">Hits: "+copy.size()+" - Search Term: \""+
                                searchFor+"\"</span>"+ 
        "		</div>\n" +
        "		<div class=\"heading\">			\n" +
        "			\n" +
        "		</div>\n" +
        "		<div class=\"out\">\n" +
        "			<span class=\"txt\">");
        Collections.reverse(copy);
        for(int i = 0; i<copy.size();i++){
            sb.append("Frequency: "+copy.get(i).getTermFreq()+
                    " - <a href=\""+copy.get(i).getHyperlink()+"\">"+
                    copy.get(i).getTitle()+"</a><br>\n");
        }
        sb.append("			</span>\n" +
        "		</div>\n" +
        "	</body>\n" +
        "</html>");
        Collections.sort(copy);
        //sb.append("</body>\n</html>");        
        FileWriter fileWriter =
                    null;
        try {
            fileWriter = new FileWriter(finalHTML,false); //add true to append
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);            
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
            fileWriter.close();
            return "Succesfully wrote to HTML";
        }
        catch (IOException ex){
            return "Could not write to HTML"; 
        }
    }
}
