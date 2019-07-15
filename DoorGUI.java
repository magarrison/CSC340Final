import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.sql.Types.NULL;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
   A frame displaying the components of a Door Alarm
*/
class DoorGUI extends JFrame
{  
   // private Object panel;
   /**
      Constructs the user interface of the Door Alarm.
   */
   public DoorGUI() throws IOException
   {  
         
      //enter and exit button
      exitButton = new JButton(" EXIT ");
      exitButton.addActionListener(new exitButtonListener());
      
      enterButton = new JButton(" ENTER PIN ");
      enterButton.addActionListener(new enterButtonListner());
      
      //add components to content pane
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(2, 1));
      buttonPanel.add(enterButton,BorderLayout.SOUTH);
      buttonPanel.add(exitButton,BorderLayout.SOUTH);
      
      //doorOpen and doorClose buttons
      doorCloseButton = new JButton(" Close Door ");
      doorCloseButton.addActionListener(new doorCloseButtonListner());
      
      doorOpenButton = new JButton(" Open Door ");
      doorOpenButton.addActionListener(new doorOpenButtonListner());
      
      //add components to content pane
      JPanel buttonPanel1 = new JPanel();
      buttonPanel1.setLayout(new GridLayout(2,1));
      buttonPanel1.add(doorCloseButton,BorderLayout.EAST);
      buttonPanel1.add(doorOpenButton,BorderLayout.EAST);
      
      //display instance
      display1 = new JTextArea(5, 15);
      display2 = new JTextArea(5, 10);
      
      //construct buttons
      offButton = new JButton("  DISARM  ");
      offButton.addActionListener(new offButtonListener());

      awayButton = new JButton("  AWAY  ");
      awayButton.addActionListener(new awayButtonListener());

      stayButton = new JButton("  STAY  ");
      stayButton.addActionListener(new stayButtonListener());
      
      
      JPanel buttonPanel0 = new JPanel();
      buttonPanel0.setLayout(new GridLayout(3, 1));
      buttonPanel0.add(offButton);
      buttonPanel0.add(awayButton);
      buttonPanel0.add(stayButton);
      
      Container contentPane1 = getContentPane();
      contentPane1.setLayout(new FlowLayout());
      contentPane1.add(pad);
      contentPane1.add(buttonPanel);
      contentPane1.add(display1);
      contentPane1.add(buttonPanel0);
      contentPane1.setBackground(Color.cyan);
      
      Container contentPane2 = getContentPane();
      contentPane2.add(buttonPanel1);
      contentPane2.add(display2);
      contentPane2.setBackground(Color.red);

      setState(START_STATE); 
      setDoor(DefaultDoor);
   }
  DoorKeyPad pad = new DoorKeyPad();
  Admin admin = new Admin();
 
   /** 
      Sets currentMode to OFF or AWAY or STAY. 
      * 
   */
      public void selectMode(byte mode)
      {
      if (mode == OFF_MODE)
      {  CurrentMode = "Alarm Status : OFF";
         display1.setText("Door Alarm : OFF");}
      else if (mode == AWAY_MODE)
      {  CurrentMode = "Alarm Status : AWAY";
         display1.setText("Door Alarm : AWAY MODE");}
      else if (mode == STAY_MODE)
      {  CurrentMode = "Alarm Status : STAY";
  	 display1.setText("Door Alarm : STAY MODE");}
      }
   /** 
      Sets state and updates display message.
      @param state the next state
   */
   public void setState(byte newState)
   {  
      state = newState;
      pad.clear();
      if (state == START_STATE)
         display1.setText("Enter PIN\npress ENTER");
      else if (state == MODE_STATE){
         display1.setText(CurrentMode +"\n"+ "\nSelect MODE :  " 
           + "\t OFF\n\t AWAY\n\t STAY");
      }
      else if(state == LOCK_OUT)
      {
          showMessage();
      }
   }
   
   public void setDoor(byte doorstate)
   {
       dstate = doorstate;
       pad.clear();
       if(dstate == DOOR_STATE_x)
           display2.setText("Door Is Open!");
       else if(dstate == DOOR_STATE_y)
           display2.setText("Door Is Closed!");
      
   }
   public void prepAlarm(byte doorstate)
   {
       df = doorstate;
       pad.clear();
       if(df == POTENTIAL_ALARM){
           display2.setText("System Alert!\nDoor subject to\nAlarm...");
           
       }
           
   }
   private void showMessage()
   {   
             display2.setText("Alarm Triggered!\nContact Admin...");
             display1.setText("    \n"+
                             "      *----  LOCKED OUT  ----*\n"+
                             "      *--- CONTACT ADMIN ----*");
   }

 
      //functions of the doorOpen button
    private class doorOpenButtonListner implements ActionListener 
    {
     public void actionPerformed(ActionEvent event)
     {
         if(df == POTENTIAL_ALARM)
         {
             setState(LOCK_OUT);
         }
         setDoor(DOOR_STATE_x);
         try {
             x.openPressed();
         } catch (IOException ex) {
             Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
    } 
      //functions of the doorClose button
    private class doorCloseButtonListner implements ActionListener 
    {
     public void actionPerformed(ActionEvent event)
     {
         
         if(dstate == DOOR_STATE_x)
         {
         setDoor(DOOR_STATE_y);
         }
         else if(dstate == DOOR_STATE_x)
         {
             display2.setText("Door is already Closed");
         } 
         try {
             x.closePressed();
         } catch (IOException ex) {
             Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    }
   //functions of the exit button
    private class exitButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event) 
        {
           if(df == POTENTIAL_ALARM)
         {
             if(state == MODE_STATE)
                 setState(START_STATE);  
             else
             setState(LOCK_OUT);
         }
        
            try {
                x.exitPressed();
            } catch (IOException ex) {
                Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //functions of the enter button
    private class enterButtonListner implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {  
         secretCode = (int)pad.getValue();
         setState(START_STATE);
            try {
                if(admin.checkCode(secretCode) == true){
                    setState(MODE_STATE);
                }
                else{
                    setState(LOCK_OUT);
                }     } catch (FileNotFoundException ex) {
                Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                x.enterPressed();
            } catch (IOException ex) {
                Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
      }  
    }
    //functions of the off Button
   private class offButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == MODE_STATE)
            selectMode(OFF_MODE);
         else if (state == START_STATE){
           setState(START_STATE); 
         }
          try {
              x.offPressed();
          } catch (IOException ex) {
              Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   }
   //functions of the away button
   private class awayButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
	 if (state == MODE_STATE)
	    selectMode(AWAY_MODE);
         else if (state == START_STATE)
            setState(START_STATE);
          try {
              x.awayPressed();
          } catch (IOException ex) {
              Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   }
   //functions of the stay button
   private class stayButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
	 if (state == MODE_STATE)
		selectMode(STAY_MODE);
	 else if (state == START_STATE)
		setState(START_STATE);
          try {
              x.stayPressed();
          } catch (IOException ex) {
              Logger.getLogger(DoorGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   }
   //private data members for control
   private int secretCode;
   private short PIN1 = 1111; private short PIN2 = 2222;
   private byte state;
   private byte dstate;
   private static byte df;
   private String CurrentMode = "Alarm is ON";
   private String CurrentDoor = "Door is Closed";
   
   private JButton exitButton;
   private JButton enterButton;
   private JButton offButton;
   private JButton awayButton;
   private JButton stayButton;
   private JButton doorCloseButton;
   private JButton doorOpenButton;
   
   private Door x;
   private JTextArea display1;
   private JTextArea display2;
   //private JRadioButton display1;
   
   private static final byte START_STATE = 1;
   private static final byte MODE_STATE = 2;
   private static final byte LOCK_OUT = 0;
   
   private static final byte DefaultDoor = 2;
   private static final byte DOOR_STATE_x = 1;
   private static final byte DOOR_STATE_y = 2;
   private static final byte POTENTIAL_ALARM = 4;

   private static final byte OFF_MODE = 1;
   private static final byte AWAY_MODE = 2;
   private static final byte STAY_MODE = 3;
  
}
