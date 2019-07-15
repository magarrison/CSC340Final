import java.io.IOException;
import javax.swing.JFrame;

/**
   A simulation of an automatic teller machine
*/
public class Admin_House_System
{  
   public static void main(String[] args) throws IOException
   {  
      JFrame frame = new Admin_System();
      frame.setTitle("Admin House System");      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.show();
   }
}

