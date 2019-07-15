
import java.io.IOException;
import javax.swing.JFrame;


/**
   A simulation of a Door Alarm System
*/
public class DoorDemo
{   
   public static void main(String[] args) throws IOException
   {  
      JFrame frame = new DoorGUI();
      frame.setTitle("Door Alarm System");      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.show();
   }
}
