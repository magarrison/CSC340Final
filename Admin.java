import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin {
    
    int checker;
    public void createCode(int value){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("UserDatabase.txt"));
            out.write(value + " " + "6" + " " + "3");
            out.write("");
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //public void changeHousepermissions(int value, int newval){
     //   Scanner fileScanner = new Scanner(new File("UserDatabase.txt"));
     //   while (fileScanner.hasNextInt()){
    //        checker = fileScanner.nextInt();
     //        if(checker == value)
                 
    //    }
    //}
    
    //public void changeClockpermissions(int value, int newval){
    //    
   // }
    public boolean checkCode(int value) throws FileNotFoundException{
        boolean answer = false;
        Scanner fileScanner = new Scanner(new File("UserDatabase.txt"));
        while (fileScanner.hasNextInt()){
            checker = fileScanner.nextInt();
             if(checker == value)
                 return true;
        }
        
        return answer;
        
           
    }
    public int checkRoomCode(int value) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(new File("UserDatabase.txt"));
        while (fileScanner.hasNextInt()){
            checker = fileScanner.nextInt();
             if(checker == value)
                 return fileScanner.nextInt();
        }
        
        return -1;
    }
    public int checkClockCode(int value) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(new File("UserDatabase.txt"));
        while (fileScanner.hasNextInt()){
            checker = fileScanner.nextInt();
             if(checker == value){
                 fileScanner.nextInt();
                 return fileScanner.nextInt();
             }
        }
        
        return -1;
    }
    public void resetCode(int value, int newvalue) throws FileNotFoundException, IOException{
        Path path = Paths.get("UserDatabase.txt");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll("foo", "bar");
        Files.write(path, content.getBytes(charset));
    }
    
    public void readDoorFile(){
        
    }
    public void readRoomFile(){
        
    }
    public void readClockFIle(){
        
    }
}
