import java.io.IOException;
import javax.swing.JFrame;

/**
Name: Michael Garrison
Course: CSC 540-01
Subject: F15 Room Subsystem Final
I have abided by the UNCG Academic Honor Code on this assignment.
A simulation of a smart house (Room Subsystem)
*/

public class RoomDemo
{  
   public static void main(String[] args) throws IOException
   {  
      JFrame frame = new RoomGUI();
      frame.setTitle("Room Subsystem Demo");      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.show();
   }
}

