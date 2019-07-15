
import com.sun.jmx.snmp.Timestamp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
/*
 */
/**
 *
 * @author sagondri
 */
public class Door{
    
  java.util.Date date = new java.util.Date();
  Writer writer = new FileWriter("doorLog.txt");
  Timestamp ts = new Timestamp(date.getTime());

    public Door() throws IOException {}	
    
    public void exitPressed() throws IOException{
       
       System.out.println(ts);
         try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("doorLog.txt", true)))) {
    out.println("Exit System: " + ts);
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
    public void enterPressed() throws IOException{
        
         System.out.println(ts);
         try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("doorLog.txt", true)))) {
    out.println("Entered System: " + ts);
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
        
    }
    public void closePressed() throws IOException{
        
         System.out.println(ts);
         try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("doorLog.txt", true)))) {
    out.println("Closed Door: " + ts);
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
    
    public void openPressed() throws IOException{
        
        System.out.println(ts);
         try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("doorLog.txt", true)))) {
    out.println("Opened Door: " + ts);
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
    
    public void offPressed() throws IOException{
        
         System.out.println(ts);
         try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("doorLog.txt", true)))) {
    out.println("Disarm Alarm: " + ts);
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
    
    public void awayPressed() throws IOException{
        
          System.out.println(ts);
         try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("doorLog.txt", true)))) {
    out.println("Set Away Alarm: " + ts);
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
    
    public void stayPressed() throws IOException{
        
        System.out.println(ts);
         try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("doorLog.txt", true)))) {
    out.println("Set Stay Alarm: " + ts);
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
}

