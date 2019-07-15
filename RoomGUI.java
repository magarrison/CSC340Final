import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
Name: Michael Garrison
Course: CSC 340-01
Subject: S15 Room Subsystem Final
I have abided by the UNCG Academic Honor Code on this assignment.
Graphical User Interface for a Room Subsystem
*/

/**
   A frame displaying the components of an ATM
*/
class RoomGUI extends JFrame
{  
   /**
      Constructs the user interface of the ATM application.
   */
    public RoomGUI() throws IOException
   {  
   
      // construct components

      pad = new RoomKeyPad();

      display = new JTextArea(4, 40);
      
      aButton = new JButton("  Temperature UP  ");
      aButton.addActionListener(new AButtonListener());

      bButton = new JButton("  Temperature DOWN  ");
      bButton.addActionListener(new BButtonListener());

      cButton = new JButton("  Temperature ON/OFF  ");
      cButton.addActionListener(new CButtonListener());
      
      dButton = new JButton("  Fan HIGH  ");
      dButton.addActionListener(new DButtonListener());
      
      eButton = new JButton("  Fan LOW  ");
      eButton.addActionListener(new EButtonListener());
      
      fButton = new JButton("  Fan OFF  ");
      fButton.addActionListener(new FButtonListener());
      
      gButton = new JButton("  Lights UP  ");
      gButton.addActionListener(new GButtonListener());
      
      hButton = new JButton("  Lights DOWN  ");
      hButton.addActionListener(new HButtonListener());
      
      iButton = new JButton("  Lights OFF  ");
      iButton.addActionListener(new IButtonListener());
      
      jButton = new JButton("  Living Room  ");
      jButton.addActionListener(new JButtonListener());
      
      kButton = new JButton("  Bedroom 1  ");
      kButton.addActionListener(new KButtonListener());
      
      lButton = new JButton("  Bedroom 2  ");
      lButton.addActionListener(new LButtonListener());
      
      backButton = new JButton("BACK");
      backButton.addActionListener(new backButtonListener());
      
      exitButton = new JButton("EXIT");
      exitButton.addActionListener(new exitButtonListener());
      
      
      // add components to content pane

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(5, 3));
      buttonPanel.add(jButton);
      buttonPanel.add(kButton);
      buttonPanel.add(lButton);
      buttonPanel.add(aButton);
      buttonPanel.add(bButton);
      buttonPanel.add(cButton);
      buttonPanel.add(dButton);
      buttonPanel.add(eButton);
      buttonPanel.add(fButton);
      buttonPanel.add(gButton);
      buttonPanel.add(hButton);
      buttonPanel.add(iButton);
      buttonPanel.add(backButton);
      buttonPanel.add(exitButton);
      
      buttonPanel.revalidate();
      
      Container contentPane = getContentPane();
      contentPane.setLayout(new FlowLayout());
      contentPane.add(pad);
      contentPane.add(display);
      contentPane.add(buttonPanel);

      setState(START_STATE);      
   }
   
    Admin admin = new Admin();
    Room room = new Room();
    
     
    public void checkPermissionA() throws FileNotFoundException{
      secretCode = (int)pad.getValue();
      if(admin.checkCode(secretCode) == true && (admin.checkRoomCode(secretCode) == 0 
              || admin.checkRoomCode(secretCode) == 3 || admin.checkRoomCode(secretCode) == 4 
              || admin.checkRoomCode(secretCode) == 6))
      setState(LROOM_STATE);
      else if(admin.checkCode(secretCode) == false){
       JOptionPane.showMessageDialog(null, 
            "Invalid secret code.");   
      }
      else{
       JOptionPane.showMessageDialog(null, 
            "Insufficient privileges for this room.");
   }
   }
   
    public void checkPermissionB() throws FileNotFoundException{
      secretCode = (int)pad.getValue();
      if(admin.checkCode(secretCode) == true && (admin.checkRoomCode(secretCode) == 1 
              || admin.checkRoomCode(secretCode) == 3 || admin.checkRoomCode(secretCode) == 5 
              || admin.checkRoomCode(secretCode) == 6))
      setState(ROOM1_STATE);
      else if(admin.checkCode(secretCode) == false){
       JOptionPane.showMessageDialog(null, 
            "Invalid secret code.");   
      }
      else{
       JOptionPane.showMessageDialog(null, 
            "Insufficient privileges for this room.");
   }
   }
    
     public void checkPermissionC() throws FileNotFoundException{
      secretCode = (int)pad.getValue();
      if(admin.checkCode(secretCode) == true && (admin.checkRoomCode(secretCode) == 2 
              || admin.checkRoomCode(secretCode) == 4 || admin.checkRoomCode(secretCode) == 5 
              || admin.checkRoomCode(secretCode) == 6))
      setState(ROOM2_STATE);
      else if(admin.checkCode(secretCode) == false){
       JOptionPane.showMessageDialog(null, 
            "Invalid secret code.");   
      }
      else{
       JOptionPane.showMessageDialog(null, 
            "Insufficient privileges for this room.");
   }
   }
   

   /** 
      Sets state and updates display message.
      @param state the next state
   */
   public void setState(int newState)
   {  
      state = newState;
      pad.clear();
      if (state == START_STATE)
         display.setText("Enter secret code and select room.");
      else if (state == LROOM_STATE){
         display.setText("Current Room = Living Room" 
            + "\nCurrent Temp = " + room.getTempLivingRoom()
            + "     Max Temp = "
            + room.getTempMax()
            + "     Min Temp = "
            + room.getTempMin()
            + "     Temp Status = "
            + room.getTempStatusLivingRoom()
            + "\nFan Status = " 
            + room.getFanLivingRoom()
            + "\nLight Status = " 
            + room.getLightLivingRoom());
      }
      else if (state == ROOM1_STATE){
          display.setText("Current Room = Bedroom 1" 
            + "\nCurrent Temp = " + room.getTempBedRoom1()
            + "     Max Temp = "
            + room.getTempMax()
            + "     Min Temp = "
            + room.getTempMin()
            + "     Temp Status = "
            + room.getTempStatusBedRoom1()
            + "\nFan Status = " 
            + room.getFanBedRoom1()
            + "\nLight Status = " 
            + room.getLightBedRoom1());
      }
      else if (state == ROOM2_STATE){
          display.setText("Current Room = Bedroom 2" 
            + "\nCurrent Temp = " + room.getTempBedRoom2()
            + "     Max Temp = "
            + room.getTempMax()
            + "     Min Temp = "
            + room.getTempMin()
            + "     Temp Status = "
            + room.getTempStatusBedRoom2()
            + "\nFan Status = " 
            + room.getFanBedRoom2()
            + "\nLight Status = " 
            + room.getLightBedRoom2());
      }
   }
   
   private class JButtonListener implements ActionListener 
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == START_STATE){
             try {
                 checkPermissionA();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
      }
   }
   
   private class KButtonListener implements ActionListener 
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == START_STATE){
             try {
                 checkPermissionB();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
      }
   }
   
   private class LButtonListener implements ActionListener 
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == START_STATE){
             try {
                 checkPermissionC();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
      }
   }
   
   private class AButtonListener implements ActionListener 
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == LROOM_STATE){
             try {
                 room.incTempA();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
            setState(LROOM_STATE);
         }
        else if (state == ROOM1_STATE){
             try {
                 room.incTempB();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
            setState(ROOM1_STATE);
        }
        else if (state == ROOM2_STATE){
             try {
                 room.incTempC();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
            setState(ROOM2_STATE);
        }
   }
   }
   
   private class BButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == LROOM_STATE){
             try {
                 room.decTempA();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
            setState(LROOM_STATE);
          }
         else if (state == ROOM1_STATE){
             try {
                 room.decTempB();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
             setState(ROOM1_STATE);
         }
         else if (state == ROOM2_STATE){
             try {
                 room.decTempC();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
             setState(ROOM2_STATE);
         }
   }
   }

   private class CButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == LROOM_STATE){
             try {
                 room.tempStatusA();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
            setState(LROOM_STATE);
         }
         else if (state == ROOM1_STATE){
             try {
                 room.tempStatusB();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
             setState(ROOM1_STATE);
         }
         else if (state == ROOM2_STATE){
             try {
                 room.tempStatusC();
             } catch (IOException ex) {
                 Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
             setState(ROOM2_STATE);
         }
   }
   }
   
   private class DButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
        if (state == LROOM_STATE){
            try {
                room.fanHighA();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(LROOM_STATE);
        }
        else if (state == ROOM1_STATE){
            try {
                room.fanHighB();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM1_STATE);
        }
        else if (state == ROOM2_STATE){
            try {
                room.fanHighC();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM2_STATE);
        }
      }
   }
   
   private class EButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
        if (state == LROOM_STATE){
            try {
                room.fanLowA();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(LROOM_STATE);
      }
        else if (state == ROOM1_STATE){
            try {
                room.fanLowB();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM1_STATE);
        }
        else if (state == ROOM2_STATE){
            try {
                room.fanLowC();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM2_STATE);
        }     
   }
   }
   
   private class FButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
        if (state == LROOM_STATE){
            try {
                room.fanOffA();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(LROOM_STATE);
      }
        else if (state == ROOM1_STATE){
            try {
                room.fanOffB();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM1_STATE);
        }
        else if (state == ROOM2_STATE){
            try {
                room.fanOffC();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM2_STATE);
        }
   }
   }
   
   private class GButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
        if (state == LROOM_STATE){
            try {
                room.incLightA();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(LROOM_STATE);
      }
        else if (state == ROOM1_STATE){
            try {
                room.incLightB();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM1_STATE);
        }
        else if (state == ROOM2_STATE){
            try {
                room.incLightC();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM2_STATE);
        }
   }
   }
   
   private class HButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
        if (state == LROOM_STATE){
            try {
                room.decLightA();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(LROOM_STATE);
      }
        else if (state == ROOM1_STATE){
            try {
                room.decLightB();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM1_STATE);
        }
        else if (state == ROOM2_STATE){
            try {
                room.decLightC();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM2_STATE);
        }
   }
   }
   
   private class IButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
        if (state == LROOM_STATE){
            try {
                room.lightOffA();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(LROOM_STATE);
      }
        else if (state == ROOM1_STATE){
            try {
                room.lightOffB();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM1_STATE);
        }
        else if (state == ROOM2_STATE){
            try {
                room.lightOffC();
            } catch (IOException ex) {
                Logger.getLogger(RoomGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            setState(ROOM2_STATE);
        }
   }
   }
   
   private class backButtonListener implements ActionListener{
       public void actionPerformed(ActionEvent event){
           if(state == LROOM_STATE){
               setState(START_STATE);
           }
           else if (state == ROOM1_STATE){
               setState(START_STATE);
           }
           else if (state == ROOM2_STATE){
               setState(START_STATE);
           }
       }
   }
   
    private class exitButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
         if (state == START_STATE){
                         
             System.exit(0);
         }
         else if (state == LROOM_STATE){
            System.exit(0);
         }
        else if (state == ROOM1_STATE){
            System.exit(0);
        }
        else if (state == ROOM2_STATE){
            System.exit(0);
        }
   }
   }

   private int state;
   private int secretCode;
  
   
   private JButton aButton;
   private JButton bButton;
   private JButton cButton;
   private JButton dButton;
   private JButton eButton;
   private JButton fButton;
   private JButton gButton;
   private JButton hButton;
   private JButton iButton;
   private JButton jButton;
   private JButton kButton;
   private JButton lButton;
   private JButton backButton;
   private JButton exitButton;
   
   private RoomKeyPad pad;
   private JTextArea display;
   
   private static final int START_STATE = 1;
   private static final int LROOM_STATE = 2;
   private static final int ROOM1_STATE = 3;
   private static final int ROOM2_STATE = 4;
}
