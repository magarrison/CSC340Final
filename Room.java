import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
/**
Name: Michael Garrison
Course: CSC 340-01
Subject: S15 Room Subsystem Final
I have abided by the UNCG Academic Honor Code on this assignment.
The implementation of a smart house (Room Subsystem)
*/
public class Room
{
//Read in log file to get variable values
Scanner scan = new Scanner(new File("roomLog.txt"));

private int currentTableA = scan.nextInt();
private int maxTable = scan.nextInt();
private int minTable = scan.nextInt();
private String tempStatusA = scan.next();
private String tableStatusA = scan.next();
private String lightStatusA = scan.next();

private int currentTableB = scan.nextInt();
private String tempStatusB = scan.next();
private String tableStatusB = scan.next();
private String lightStatusB = scan.next();

private int currentTableC = scan.nextInt();
private String tempStatusC = scan.next();
private String tableStatusC = scan.next();
private String lightStatusC = scan.next();

private boolean tempOnA = true;
private boolean tempOnB = true;
private boolean tempOnC = true;

private int currentFanA = 0;
private int currentFanB = 0;
private int currentFanC = 0;
private int currentLightA = 1;
private int currentLightB = 1;
private int currentLightC = 1;
private final int maxLight = 5;
private final int minLight = 1;

public Room() throws IOException{        
}

//getter methods
public String getTempStatusLivingRoom(){
    return tempStatusA;
}
public String getTempStatusBedRoom1(){
    return tempStatusB;
}
public String getTempStatusBedRoom2(){
    return tempStatusC;
}
public int getTempLivingRoom(){
    return currentTableA;
}
public int getTempBedRoom1(){
    return currentTableB;
}
public int getTempBedRoom2(){
    return currentTableC;
}
public int getTempMax(){
    return maxTable;
}
public int getTempMin(){
    return minTable;
}
public String getFanLivingRoom(){
    return tableStatusA;
}
public String getFanBedRoom1(){
    return tableStatusB;
}
public String getFanBedRoom2(){
    return tableStatusC;
}
public String getLightLivingRoom(){
    return lightStatusA;
}
public String getLightBedRoom1(){
    return lightStatusB;
}
public String getLightBedRoom2(){
    return lightStatusC;
}

//setter methods
public void setTempStatusLivingRoom(boolean tempOn0) throws IOException{
    tempOn0 = tempOnA;
    writeLog();
}
public void setTempStatusBedRoom1(boolean tempOn1) throws IOException{
    tempOn1 = tempOnB;
    writeLog();
}
public void setTempStatusBedRoom2(boolean tempOn2) throws IOException{
    tempOn2 = tempOnC;
    writeLog();
}
public void setTempLivingRoom(int temp0) throws IOException{
if (temp0 < maxTable){
    throw new IllegalArgumentException("Temperature cannot be set higher than the Max Temp.");
}
else{
  temp0 = currentTableA;
  writeLog();
}
 
}
public void setTempBedRoom1(int temp1) throws IOException{
if (temp1 < maxTable){
    throw new IllegalArgumentException("Temperature cannot be set higher than the Max Temp.");
}
else{
  temp1 = currentTableB;
  writeLog();
}
}
public void setTempBedRoom2(int temp2) throws IOException{
if (temp2 < maxTable){
    throw new IllegalArgumentException("Temperature cannot be set higher than the Max Temp.");
}
else{
  temp2 = currentTableC;
  writeLog();
}
}
public void setTempMax(int max) throws IOException{
    max = maxTable;
    writeLog();
if(maxTable < currentTableA){
    maxTable = currentTableA;
    writeLog();
}
else if(maxTable < currentTableB){
    maxTable = currentTableC;
    writeLog();
}
else if (maxTable < currentTableC){
    maxTable = currentTableC;
    writeLog();
}
else if (maxTable < currentTableA && maxTable < currentTableB){
    maxTable = currentTableA;
    maxTable = currentTableB;
    writeLog();
}
else if (maxTable < currentTableA && maxTable < currentTableC){
    maxTable = currentTableA;
    maxTable = currentTableC;
    writeLog();
}
else if (maxTable < currentTableB && maxTable < currentTableC){
    maxTable = currentTableB;
    maxTable = currentTableC;
    writeLog();
}
else if (maxTable < currentTableA && maxTable < currentTableB && maxTable < currentTableC){
    maxTable = currentTableA;
    maxTable = currentTableB;
    maxTable = currentTableC;
    writeLog();
}
else{
}
}
public void setTempMin(int min) throws IOException{
    min = minTable;
    writeLog();
if(minTable > currentTableA){
    minTable = currentTableA;
    writeLog();
}
else if(minTable > currentTableB){
    minTable = currentTableC;
    writeLog();
}
else if (minTable > currentTableC){
    minTable = currentTableC;
    writeLog();
}
else if (minTable > currentTableA && minTable > currentTableB){
    minTable = currentTableA;
    minTable = currentTableB;
    writeLog();
}
else if (minTable > currentTableA && minTable > currentTableC){
    minTable = currentTableA;
    minTable = currentTableC;
    writeLog();
}
else if (minTable > currentTableB && minTable > currentTableC){
    minTable = currentTableB;
    minTable = currentTableC;
    writeLog();
}
else if (minTable > currentTableA && minTable > currentTableB && minTable > currentTableC){
    minTable = currentTableA;
    minTable = currentTableB;
    minTable = currentTableC;
    writeLog();
}
else{
}
}
public void setFanLivingRoom(int fan0) throws IOException{
if (fan0 < 3){
    throw new IllegalArgumentException("Fan cannot be set higher than 3 (HIGH).");
}
else{
  fan0 = currentFanA;
  writeLog();
}   
}
public void setFanBedRoom1(int fan1) throws IOException{
if (fan1 < 3){
    throw new IllegalArgumentException("Fan cannot be set higher than 3 (HIGH).");
}
else{
  fan1 = currentFanB;
  writeLog();
}   
}
public void setFanBedRoom2(int fan2) throws IOException{
if (fan2 < 3){
    throw new IllegalArgumentException("Fan cannot be set higher than 3 (HIGH).");
}
else{
  fan2 = currentFanA;
  writeLog();
}   
}
public void setLightLivingRoom(int light0) throws IOException{
 if (light0 < 5){
    throw new IllegalArgumentException("Fan cannot be set higher than 5 (VERY HIGH).");
}
else{
  light0 = currentLightA;
  writeLog();
}   
}
public void setLightBedRoom1(int light1) throws IOException{
 if (light1 < 5){
    throw new IllegalArgumentException("Fan cannot be set higher than 5 (VERY HIGH).");
}
else{
  light1 = currentLightB;
  writeLog();
}   
}
public void setLightBedRoom2(int light2) throws IOException{
 if (light2 < 5){
    throw new IllegalArgumentException("Fan cannot be set higher than 5 (VERY HIGH).");
}
else{
  light2 = currentLightC;
  writeLog();
}   
}

//increment and decrement methods
public void incTempA() throws IOException{
       if(currentTableA != maxTable){
           currentTableA++;
           writeLog();
          }
   }
   
public void incTempB() throws IOException{
       if(currentTableB != maxTable){
           currentTableB++;
           writeLog();
       }
   }
   
public void incTempC() throws IOException{
       if(currentTableC != maxTable){
           currentTableC++;
           writeLog();
       }
   }
   
public void decTempA() throws IOException{
       if(currentTableA != minTable){
           currentTableA--;
           writeLog();
       }
   }
   
public void decTempB() throws IOException{
       if(currentTableB != minTable){
           currentTableB--;
           writeLog();
       }
   }
   
public void decTempC() throws IOException{
       if(currentTableC != minTable){
           currentTableC--;
           writeLog();
       }
   }
   
public void incmaxTable() throws IOException{
    maxTable++;
    //write out to log
    writeLog();
}
public void decmaxTable() throws IOException{
    maxTable--;
    //write out to log
    writeLog();
if(maxTable < currentTableA){
    maxTable = currentTableA;
    //write out to log
    writeLog();
}
else if(maxTable < currentTableB){
    maxTable = currentTableB;
    //write out to log
    writeLog();
}
else if (maxTable < currentTableC){
    maxTable = currentTableC;
    //write out to log
    writeLog();
}
else if (maxTable < currentTableA && maxTable < currentTableB){
    maxTable = currentTableA;
    maxTable = currentTableB;
    //write out to log
    writeLog();
}
else if (maxTable < currentTableA && maxTable < currentTableC){
    maxTable = currentTableA;
    maxTable = currentTableC;
    //write out to log
    writeLog();
}
else if (maxTable < currentTableB && maxTable < currentTableC){
    maxTable = currentTableB;
    maxTable = currentTableC;
    writeLog();
}
else if (maxTable < currentTableA && maxTable < currentTableB && maxTable < currentTableC){
    maxTable = currentTableA;
    maxTable = currentTableB;
    maxTable = currentTableC;
    writeLog();
}
else{
}
}
public void incminTable() throws IOException{
    minTable++;
    //write out to log
    writeLog();
if(minTable > currentTableA){
    minTable = currentTableA;
    //write out to log
    writeLog();
}
else if(minTable > currentTableB){
    minTable = currentTableC;
    //write out to log
    writeLog();
}
else if (minTable > currentTableC){
    minTable = currentTableC;
    //write out to log
    writeLog();
}
else if (minTable > currentTableA && minTable > currentTableB){
    minTable = currentTableA;
    minTable = currentTableB;
    //write out to log
    writeLog();
}
else if (minTable > currentTableA && minTable > currentTableC){
    minTable = currentTableA;
    minTable = currentTableC;
    //write out to log
    writeLog();
}
else if (minTable > currentTableB && minTable > currentTableC){
    minTable = currentTableB;
    minTable = currentTableC;
    //write out to log
    writeLog();
}
else if (minTable > currentTableA && minTable > currentTableB && minTable > currentTableC){
    minTable = currentTableA;
    minTable = currentTableB;
    minTable = currentTableC;
    writeLog();
}
else{
}
}
public void decminTable() throws IOException{
    minTable--;
    //write out to log
    writeLog();
}

//status methods for temp, fan and lights
public void tempStatusA() throws IOException{
    tempOnA = !tempOnA;
       if(tempOnA == true)
           tempStatusA = "ON";
       else{
           tempStatusA = "OFF";}
       writeLog();
   }
   
public void tempStatusB() throws IOException{
    tempOnB = !tempOnB;
       if(tempOnB == true)
           tempStatusB = "ON";
       else{
           tempStatusB = "OFF";}
       writeLog();
   }
   
public void tempStatusC() throws IOException{
    tempOnC = !tempOnC;
       if(tempOnC == true)
           tempStatusC = "ON";
       else{
           tempStatusC = "OFF";}
       writeLog();
   }

public void fanOffA() throws IOException{
    tableStatusA = "OFF";
    writeLog();
}

public void fanOffB() throws IOException{
    tableStatusB = "OFF";
    writeLog();
}

public void fanOffC() throws IOException{
    tableStatusC = "OFF";
    writeLog();
}

public void fanLowA() throws IOException{
    tableStatusA = "LOW";
    writeLog();
}

public void fanLowB() throws IOException{
    tableStatusB = "LOW";
    writeLog();
}

public void fanLowC() throws IOException{
    tableStatusC = "LOW";
    writeLog();
}

public void fanHighA() throws IOException{
    tableStatusA = "HIGH";
    writeLog();
}

public void fanHighB() throws IOException{
    tableStatusB = "HIGH";
    writeLog();
}

public void fanHighC() throws IOException{
    tableStatusC = "HIGH";
    writeLog();
}
   
public void incLightA() throws IOException{
       if(currentLightA != maxLight){
           currentLightA++;
       if(currentLightA == 0){
           lightStatusA = "OFF";
           writeLog();}
       else if(currentLightA == 1){
           lightStatusA = "VERY-LOW";
           writeLog();}
       else if(currentLightA == 2){
           lightStatusA = "LOW";
           writeLog();}
       else if (currentLightA == 3){
           lightStatusA = "MEDIUM";
           writeLog();}
       else if (currentLightA == 4){
           lightStatusA = "HIGH";
           writeLog();}
       else{
           lightStatusA = "VERY-HIGH";
           writeLog();
       }
   }
}
   
public void incLightB() throws IOException{
       if(currentLightB != maxLight){
           currentLightB++;
       if(currentLightB == 0){
           lightStatusB = "OFF";
           writeLog();}
       else if(currentLightB == 1){
           lightStatusB = "VERY-LOW";
           writeLog();}
       else if(currentLightB == 2){
           lightStatusB = "LOW";
           writeLog();}
       else if (currentLightB == 3){
           lightStatusB = "MEDIUM";
           writeLog();}
       else if (currentLightB == 4){
           lightStatusB = "HIGH";
           writeLog();}
       else{
           lightStatusB= "VERY-HIGH";
           writeLog();
       }
   }
}
   
public void incLightC() throws IOException{
       if(currentLightC != maxLight){
           currentLightC++;
           writeLog();
       if(currentLightC == 0){
           lightStatusC = "OFF";
           writeLog();}
       else if(currentLightC == 1){
           lightStatusC = "VERY-LOW";
           writeLog();}
       else if(currentLightC == 2){
           lightStatusC = "LOW";
           writeLog();}
       else if (currentLightC == 3){
           lightStatusC = "MEDIUM";
           writeLog();}
       else if (currentLightC == 4){
           lightStatusC = "HIGH";
           writeLog();}
       else{
           lightStatusC = "VERY-HIGH";
           writeLog();
       }
   }
}
   
public void decLightA() throws IOException{
       if(currentLightA != minLight){
           currentLightA--;
           writeLog();
       if(currentLightA == 0){
           lightStatusA = "OFF";
           writeLog();}
       else if(currentLightA == 1){
           lightStatusA = "VERY-LOW";
           writeLog();}
       else if(currentLightA == 2){
           lightStatusA = "LOW";
           writeLog();}
       else if (currentLightA == 3){
           lightStatusA = "MEDIUM";
           writeLog();}
       else if (currentLightA == 4){
           lightStatusA = "HIGH";
           writeLog();}
       else{
           lightStatusA = "VERY-HIGH";
           writeLog();
       }
   }
}
   
 public void decLightB() throws IOException{
       if(currentLightB != minLight){
           currentLightB--;
           writeLog();
       if(currentLightB == 0){
           lightStatusB = "OFF";
           writeLog();}
       else if(currentLightB == 1){
           lightStatusB = "VERY-LOW";
           writeLog();}
       else if(currentLightB == 2){
           lightStatusB = "LOW";
           writeLog();}
       else if (currentLightB == 3){
           lightStatusB = "MEDIUM";
           writeLog();}
       else if (currentLightB == 4){
           lightStatusB = "HIGH";
           writeLog();}
       else{
           lightStatusB= "VERY-HIGH";
           writeLog();
       }
   }
 }
    
public void decLightC() throws IOException{
       if(currentLightC != minLight){
           currentLightC--;
           writeLog();
       if(currentLightC == 0){
           lightStatusC = "OFF";
           writeLog();}
       else if(currentLightC == 1){
           lightStatusC = "VERY-LOW";
           writeLog();}
       else if(currentLightC == 2){
           lightStatusC = "LOW";
           writeLog();}
       else if (currentLightC == 3){
           lightStatusC = "MEDIUM";
           writeLog();}
       else if (currentLightC == 4){
           lightStatusC = "HIGH";
           writeLog();}
       else{
           lightStatusC = "VERY-HIGH";
           writeLog();
       }
   }
}

public void lightOffA() throws IOException{
        lightStatusA = "OFF";
        writeLog();
}

public void lightOffB() throws IOException{
        lightStatusB = "OFF";
        writeLog();
}

public void lightOffC() throws IOException{
        lightStatusC = "OFF";
        writeLog();
}

//method that writes new variable values to log
public void writeLog() throws IOException{
    PrintWriter writer = new PrintWriter("roomLog.txt");     
    writer.println(getTempLivingRoom());
    writer.println(getTempMax());
    writer.println(getTempMin());
    writer.println(getTempStatusLivingRoom()); 
    writer.println(getFanLivingRoom()); 
    writer.println(getLightLivingRoom());
    writer.println(getTempBedRoom1());
    writer.println(getTempStatusBedRoom1()); 
    writer.println(getFanBedRoom1());
    writer.println(getLightBedRoom1());
    writer.println(getTempBedRoom2());
    writer.println(getTempStatusBedRoom2()); 
    writer.println(getFanBedRoom2());
    writer.println(getLightBedRoom2());
    //close the file
    writer.close();
}
}