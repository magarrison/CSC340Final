import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
   A frame displaying the components of an ATM
*/
class Admin_System extends JFrame
{  
    
    private JButton hButton;
    private JButton iButton;
    private JButton jButton;
    private JButton kButton;
    private JButton aButton1;
    private JButton bButton1;
    private JButton cButton1;
    private JButton dButton1;
    private JButton eButton1;
    private JButton hButton1;
    private JButton iButton1;
    private JButton jButton1;
    private JButton kButton1;
    private JButton hButton3;
    private JButton eButton3;
    private JButton dButton3;
    private JButton cButton3;
    private JButton bButton3;
    private JButton aButton3;
    private JButton kButton2;
    private JButton jButton2;
    private JButton iButton2;
    private JButton hButton2;
    private JButton eButton2;
    private JButton dButton2;
    private JButton cButton2;
    private JButton bButton2;
    private JButton aButton2;
    private JButton fButton1;
    private JButton fButton2;
    private JButton aButton4;
    private JButton bButton4;
    private JButton cButton4;
    private JButton jButton4;
    private JButton iButton4;
    private JButton hButton4;
    private JButton jButton3;
    private JButton iButton3;
    private JButton sButton4;
    private JButton rButton4;
    private JButton sButton5;
    private JButton rButton5;
    private JButton sButton3;
    private JButton rButton3;
    private JButton sButton2;
    private JButton rButton2;
    private JButton sButton1;
    private JButton rButton1;
    private JButton codeButton;
    private JTextField personName;
    private JTextField code;
    private JTextField oldName;
    private JTextField newCode;
    private JButton newCodeButton;
    private JTextField AlarmTime;
    private JTextField AlarmRepeat;
    private JTextField AlarmSnooze;
    private JTextField NextAlarmTime;
    private JTextField NextAlarmRepeat;
    private JTextField NextAlarmSnooze;
    private JButton ReadDoorButton;
    private JButton ReadHouseButton;
    private JButton ReadClockButton;
    private JButton AddAlarmButton;
    private final JLabel currA;
    private final JLabel currB;
    private final JLabel currC;
    private final JLabel maxlabel;
    private final JLabel minlabel;
    private final JLabel fanA;
    private final JLabel fanB;
    private final JLabel fanC;
    private final JLabel LightA;
    private final JLabel LightB;
    private final JLabel LightC;
    
    Room room;
    Admin admin;
    private final JButton aButton;
    
   /**
      Constructs the user interface of the ATM application.
   */
   public Admin_System() throws IOException
   {  
        this.room = new Room();
        this.admin = new Admin();
      // construct components

      pad = new KeyPad();

      display = new JTextArea(4, 20);
      
      aButton = new JButton("  A  ");
      aButton.addActionListener(new AButtonListener());
      
      // add components to content pane

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(5, 1));
      buttonPanel.add(aButton);

      //Temperatures
      hButton = new JButton("  ^  ");
      hButton.addActionListener(new BButtonListener());
      
      currA = new JLabel(Integer.toString(room.getTempLivingRoom()));
      
      jButton = new JButton("  v  ");
      jButton.addActionListener(new CButtonListener());
      
      hButton1 = new JButton("  ^  ");
      hButton1.addActionListener(new DButtonListener());
      
      currB = new JLabel(Integer.toString(room.getTempBedRoom1()));
      
      jButton1 = new JButton("  v  ");
      jButton1.addActionListener(new EButtonListener());
      
      hButton2 = new JButton("  ^  ");
      hButton2.addActionListener(new FButtonListener());
      
      currC = new JLabel(Integer.toString(room.getTempBedRoom2()));
      
      jButton2 = new JButton("  v  ");
      jButton2.addActionListener(new GButtonListener());
      
      aButton1 = new JButton("  ^  ");
      aButton1.addActionListener(new HButtonListener());
      
      maxlabel = new JLabel(Integer.toString(room.getTempMax()));
      
      cButton1 = new JButton("  v  ");
      cButton1.addActionListener(new IButtonListener());
      
      aButton2 = new JButton("  ^  ");
      aButton2.addActionListener(new JButtonListener());
      
      minlabel = new JLabel(Integer.toString(room.getTempMin()));
      
      cButton2 = new JButton("  v  ");
      cButton2.addActionListener(new KButtonListener());
      
      //Fan and Lights
      aButton3 = new JButton("  ^  ");
      aButton3.addActionListener(new LButtonListener());
      
      fanA = new JLabel(room.getFanLivingRoom());
      
      cButton3 = new JButton("  v  ");
      cButton3.addActionListener(new MButtonListener());
      
      dButton1 = new JButton("  ^  ");
      dButton1.addActionListener(new NButtonListener());
      
      fanB = new JLabel(room.getFanBedRoom1());
      
      fButton1 = new JButton("  v  ");
      fButton1.addActionListener(new OButtonListener());
      
      aButton4 = new JButton("  ^  ");
      aButton4.addActionListener(new PButtonListener());
      
      fanC = new JLabel(room.getFanBedRoom2());
      
      cButton4 = new JButton("  v  ");
      cButton4.addActionListener(new QButtonListener());
      
      dButton2 = new JButton("  ^  ");
      dButton2.addActionListener(new RButtonListener());
      
      LightA = new JLabel(room.getLightLivingRoom());
      
      fButton2 = new JButton("  v  ");
      fButton2.addActionListener(new SButtonListener());
      
      hButton3 = new JButton("  ^  ");
      hButton3.addActionListener(new TButtonListener());
      
      LightB = new JLabel(room.getLightBedRoom1());
      
      jButton3 = new JButton("  v  ");
      jButton3.addActionListener(new UButtonListener());
      
      hButton4 = new JButton("  ^  ");
      hButton4.addActionListener(new VButtonListener());
      
      LightC = new JLabel(room.getLightBedRoom2());
      
      jButton4 = new JButton("  v  ");
      jButton4.addActionListener(new WButtonListener());
      
      //Permissions
      
      rButton1 = new JButton("  ^  ");
      rButton1.addActionListener(new CButtonListener());
      
      sButton1 = new JButton("  D  ");
      sButton1.addActionListener(new DButtonListener());
      
      rButton2 = new JButton("  ^  ");
      rButton2.addActionListener(new CButtonListener());
      
      sButton2 = new JButton("  D  ");
      sButton2.addActionListener(new DButtonListener());
      
      rButton3 = new JButton("  ^  ");
      rButton3.addActionListener(new CButtonListener());
      
      sButton3 = new JButton("  D  ");
      sButton3.addActionListener(new DButtonListener());
      
      rButton4 = new JButton("  ^  ");
      rButton4.addActionListener(new CButtonListener());
      
      sButton4 = new JButton("  D  ");
      sButton4.addActionListener(new DButtonListener());
      
      rButton5 = new JButton("  ^  ");
      rButton5.addActionListener(new CButtonListener());
      
      sButton5 = new JButton("  D  ");
      sButton5.addActionListener(new DButtonListener());
      
      // set code
      personName = new JTextField();
      code = new JTextField();
      codeButton = new JButton("Enter");
      codeButton.addActionListener(new AAButtonListener());
      
      // reset code
      oldName = new JTextField();
      newCode = new JTextField();
      newCodeButton = new JButton("Enter");
      
      //Clock stuff
      AlarmTime = new JTextField();
      AlarmRepeat = new JTextField();
      AlarmSnooze = new JTextField();
      AddAlarmButton = new JButton("Add");
      AddAlarmButton.addActionListener(new ACButtonListener());
      
      NextAlarmTime = new JTextField();
      NextAlarmRepeat = new JTextField();
      NextAlarmSnooze = new JTextField();
      
      //Read File stuff
      ReadDoorButton = new JButton("Read Door File");
      ReadHouseButton = new JButton("Read House File");
      ReadClockButton = new JButton("Read Clock File");
      
      // add components to content pane
      
      TitledBorder Currents = BorderFactory.createTitledBorder("Current Temperatures");
      TitledBorder Outlier = BorderFactory.createTitledBorder("Max/Min Temperatures");
      TitledBorder Permission = BorderFactory.createTitledBorder("Permissions");
      TitledBorder Fan = BorderFactory.createTitledBorder("Fan Speeds");
      TitledBorder Light = BorderFactory.createTitledBorder("Light Brightness");
      TitledBorder Clocks = BorderFactory.createTitledBorder("Clock Info");
      TitledBorder AddAlarms = BorderFactory.createTitledBorder("Add Alarm");
      TitledBorder NextAlarms = BorderFactory.createTitledBorder("Next Alarm");
      TitledBorder ReadFile = BorderFactory.createTitledBorder("Read Files");
      TitledBorder SetCodes = BorderFactory.createTitledBorder("Enter Name and Code respectively");
      TitledBorder ResetCodes = BorderFactory.createTitledBorder("Enter Name or Old Code, then enter new Code");
      TitledBorder GetCodes = BorderFactory.createTitledBorder("Create or Reset old Codes");
      TitledBorder LivingRoom = BorderFactory.createTitledBorder("Living Room");
      TitledBorder BedRoom1 = BorderFactory.createTitledBorder("Bedroom 1");
      TitledBorder BedRoom2 = BorderFactory.createTitledBorder("Bedroom 2");
      TitledBorder maxTable = BorderFactory.createTitledBorder("Max Temp");
      TitledBorder minTable = BorderFactory.createTitledBorder("Min Temp");

      JPanel Main = new JPanel();
      Main.setLayout(new GridLayout(2,1));
      
      JPanel TopMain = new JPanel();
      TopMain.setLayout(new GridLayout(1,3));
      
      JPanel LivingConditions = new JPanel();
      LivingConditions.setLayout(new GridLayout(2,1));
      
      JPanel Fans = new JPanel();
      Fans.setBorder(Fan);
      Fans.setLayout(new GridLayout(1,3));
      
      JPanel Lights = new JPanel();
      Lights.setBorder(Light);
      Lights.setLayout(new GridLayout(1,3));
      
      JPanel Permissions = new JPanel();
      Permissions.setBorder(Permission);
      Permissions.setLayout(new GridLayout(2,1));
      
      JPanel RoomPermissions = new JPanel();
      RoomPermissions.setLayout(new GridLayout(1,3));
      
      JPanel ClockPermissions = new JPanel();
      ClockPermissions.setLayout(new GridLayout(1,2));
      
      JPanel Temperatures = new JPanel();
      Temperatures.setLayout(new GridLayout(2,1));
      
      JPanel Current = new JPanel();
      Current.setBorder(Currents);
      Current.setLayout(new GridLayout(1,3));
      
      JPanel Outliers = new JPanel();
      Outliers.setBorder(Outlier);
      Outliers.setLayout(new GridLayout(1,2));
      
      JPanel BottomMain = new JPanel();
      BottomMain.setLayout(new GridLayout(1,3));
      
      JPanel GetCode = new JPanel();
      GetCode.setBorder(GetCodes);
      GetCode.setLayout(new GridLayout(2,1));
      
      JPanel SetCode = new JPanel();
      SetCode.setLayout(new GridLayout(1,3));
      
      JPanel ResetCode = new JPanel();
      ResetCode.setLayout(new GridLayout(1,3));
      
      JPanel Clock = new JPanel();
      Clock.setBorder(Clocks);
      Clock.setLayout(new GridLayout(2,1));
  
      JPanel AddAlarm = new JPanel();
      AddAlarm.setBorder(AddAlarms);
      AddAlarm.setLayout(new GridLayout(1,4));
      
      JPanel NextAlarm = new JPanel();
      NextAlarm.setBorder(NextAlarms);
      NextAlarm.setLayout(new GridLayout(1,3));
      
      JPanel ReadFiles = new JPanel();
      ReadFiles.setBorder(ReadFile);
      ReadFiles.setLayout(new GridLayout(3,1));
      
      JPanel buttonPanel2 = new JPanel();
      buttonPanel2.setLayout(new GridLayout(3, 1));
      buttonPanel2.setBorder(LivingRoom);
      buttonPanel2.add(hButton);
      buttonPanel2.add(currA);
      buttonPanel2.add(jButton);
      Current.add(buttonPanel2);
      
      JPanel buttonPanel3 = new JPanel();
      buttonPanel3.setLayout(new GridLayout(3, 1));
      buttonPanel3.setBorder(BedRoom1);
      buttonPanel3.add(hButton1);
      buttonPanel3.add(currB);
      buttonPanel3.add(jButton1);
      Current.add(buttonPanel3);
      
      JPanel buttonPanel4 = new JPanel();
      buttonPanel4.setLayout(new GridLayout(3, 1));
      buttonPanel4.setBorder(BedRoom2);
      buttonPanel4.add(hButton2);
      buttonPanel4.add(currC);
      buttonPanel4.add(jButton2);
      Current.add(buttonPanel4);
      Temperatures.add(Current);
      
      JPanel buttonPanel5 = new JPanel();
      buttonPanel5.setLayout(new GridLayout(3, 1));
      buttonPanel5.setBorder(maxTable);
      buttonPanel5.add(aButton1);
      buttonPanel5.add(maxlabel);
      buttonPanel5.add(cButton1);
      Outliers.add(buttonPanel5);
      
      JPanel buttonPanel6 = new JPanel();
      buttonPanel6.setLayout(new GridLayout(3, 1));
      buttonPanel6.setBorder(minTable);
      buttonPanel6.add(aButton2);
      buttonPanel6.add(minlabel);
      buttonPanel6.add(cButton2);
      Outliers.add(buttonPanel6);
      Temperatures.add(Outliers);
      
      JPanel buttonPanel7 = new JPanel();
      buttonPanel7.setLayout(new GridLayout(3,1));
      buttonPanel7.setBorder(LivingRoom);
      buttonPanel7.add(aButton3);
      buttonPanel7.add(fanA);
      buttonPanel7.add(cButton3);
      Fans.add(buttonPanel7);
      
      JPanel buttonPanel8 = new JPanel();
      buttonPanel8.setLayout(new GridLayout(3,1));
      buttonPanel8.setBorder(BedRoom1);
      buttonPanel8.add(dButton1);
      buttonPanel8.add(fanB);
      buttonPanel8.add(fButton1);
      Fans.add(buttonPanel8);
      
      JPanel buttonPanel9 = new JPanel();
      buttonPanel9.setLayout(new GridLayout(3,1));
      buttonPanel9.setBorder(BedRoom2);
      buttonPanel9.add(aButton4);
      buttonPanel9.add(fanC);
      buttonPanel9.add(cButton4);
      Fans.add(buttonPanel9);
      LivingConditions.add(Fans);
      
      JPanel buttonPanel10 = new JPanel();
      buttonPanel10.setLayout(new GridLayout(3,1));
      buttonPanel10.setBorder(LivingRoom);
      buttonPanel10.add(hButton3);
      buttonPanel10.add(LightA);
      buttonPanel10.add(jButton3);
      Lights.add(buttonPanel10);
      
      JPanel buttonPanel11 = new JPanel();
      buttonPanel11.setLayout(new GridLayout(3,1));
      buttonPanel11.setBorder(BedRoom1);
      buttonPanel11.add(hButton4);
      buttonPanel11.add(LightB);
      buttonPanel11.add(jButton4);
      Lights.add(buttonPanel11);
      
      JPanel buttonPanel12 = new JPanel();
      buttonPanel12.setLayout(new GridLayout(3,1));
      buttonPanel12.setBorder(BedRoom2);
      buttonPanel12.add(dButton2);
      buttonPanel12.add(LightC);
      buttonPanel12.add(fButton2);
      Lights.add(buttonPanel12);
      LivingConditions.add(Lights);
      
      JPanel buttonPanel13 = new JPanel();
      buttonPanel13.setLayout(new GridLayout(1,2));
      buttonPanel13.setBorder(LivingRoom);
      buttonPanel13.add(rButton1);
      buttonPanel13.add(sButton1);
      RoomPermissions.add(buttonPanel13);
      
      JPanel buttonPanel14 = new JPanel();
      buttonPanel14.setLayout(new GridLayout(1,2));
      buttonPanel14.setBorder(BedRoom1);
      buttonPanel14.add(rButton2);
      buttonPanel14.add(sButton2);
      RoomPermissions.add(buttonPanel14);
      
      JPanel buttonPanel15 = new JPanel();
      buttonPanel15.setLayout(new GridLayout(1,2));
      buttonPanel15.setBorder(BedRoom2);
      buttonPanel15.add(rButton3);
      buttonPanel15.add(sButton3);
      RoomPermissions.add(buttonPanel15);
      Permissions.add(RoomPermissions);
      
      JPanel buttonPanel16 = new JPanel();
      buttonPanel16.setLayout(new GridLayout(1,2));
      buttonPanel16.setBorder(BedRoom1);
      buttonPanel16.add(rButton4);
      buttonPanel16.add(sButton4);
      ClockPermissions.add(buttonPanel16);
      
      JPanel buttonPanel17 = new JPanel();
      buttonPanel17.setLayout(new GridLayout(1,2));
      buttonPanel17.setBorder(BedRoom2);
      buttonPanel17.add(rButton1);
      buttonPanel17.add(sButton1);
      ClockPermissions.add(buttonPanel17);
      Permissions.add(ClockPermissions);
      
      TopMain.add(Temperatures);
      TopMain.add(LivingConditions);
      TopMain.add(Permissions);
      
      Main.add(TopMain);
      
      SetCode.setBorder(SetCodes);
      SetCode.add(personName);
      SetCode.add(code);
      SetCode.add(codeButton);
      GetCode.add(SetCode);

      ResetCode.setBorder(ResetCodes);
      ResetCode.add(oldName);
      ResetCode.add(newCode);
      ResetCode.add(newCodeButton);
      GetCode.add(ResetCode);
      
      AddAlarm.add(AlarmTime);
      AddAlarm.add(AlarmRepeat);
      AddAlarm.add(AlarmSnooze);
      AddAlarm.add(AddAlarmButton);
      Clock.add(AddAlarm);
      
      NextAlarm.add(NextAlarmTime);
      NextAlarm.add(NextAlarmRepeat);
      NextAlarm.add(NextAlarmSnooze);
      Clock.add(NextAlarm);
      
      ReadFiles.add(ReadDoorButton);
      ReadFiles.add(ReadHouseButton);
      ReadFiles.add(ReadClockButton);
      
      BottomMain.add(GetCode);
      BottomMain.add(Clock);
      BottomMain.add(ReadFiles);
      
      Main.add(BottomMain);
      
      Container contentPane = getContentPane();
      contentPane.setLayout(new FlowLayout());
      contentPane.add(pad);
      contentPane.add(display);
      contentPane.add(buttonPanel);
      //contentPane.add(display2);
      contentPane.add(Main);
           
      setState(START_STATE);
   }
   
   public boolean checkAdminCode(int Code) 
   {  
       int admincode = 0000;
       if (admincode == Code)
           return true;
       else
           return false;
   }

    private class AAButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            admin.createCode(Integer.valueOf(code.getText()));
        }
    }

    private class ACButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            admin.createCode(Integer.valueOf(code.getText()));
        }
    }

    private class FButtonListener implements ActionListener {

         public void actionPerformed(ActionEvent event){
            try {
              room.incTempC();
              currC.setText(Integer.toString(room.getTempBedRoom2()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          } 
        }
        }
    

    private class EButtonListener implements ActionListener {

         public void actionPerformed(ActionEvent event)
      { 
             try {
                 room.decTempB();
                 currB.setText(Integer.toString(room.getTempBedRoom1()));
             } catch (IOException ex) {
                 Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
             }
          
    }
    }


   /** 
      Sets state and updates display message.
      @param state the next state
   */
   
   private class AButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      {  
          boolean result;
          result = checkAdminCode((int)pad.getValue());
          setState(START_STATE);
          if (result)
              display.setText("Main Method Accessed");
                      
         
      }
   }
   
   private class BButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.incTempA();
              currA.setText(Integer.toString(room.getTempLivingRoom()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
   }
      
      private class CButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.decTempA();
              currA.setText(Integer.toString(room.getTempLivingRoom()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }

  private class DButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.incTempB();
              currB.setText(Integer.toString(room.getTempBedRoom1()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
      }
  }
   
      private class GButtonListener implements ActionListener {

         public void actionPerformed(ActionEvent event)
      { 
          try {
              room.decTempC();
              currC.setText(Integer.toString(room.getTempBedRoom2()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          } 
    }
      }
      
      private class HButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.incmaxTable();
              maxlabel.setText(Integer.toString(room.getTempMax()));
              
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class IButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.decmaxTable();
              maxlabel.setText(Integer.toString(room.getTempMax()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class JButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.incminTable();
              minlabel.setText(Integer.toString(room.getTempMin()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class KButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.decminTable();
              minlabel.setText(Integer.toString(room.getTempMin()));
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class LButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.setFanLivingRoom(5);
              fanA.setText(room.getLightLivingRoom());
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class MButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.setFanLivingRoom(3);
              fanA.setText("Medium");
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class NButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.setFanBedRoom1(5);
              fanB.setText("Medium");
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class OButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.setFanBedRoom1(3);
              fanB.setText(room.getLightBedRoom1());
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class PButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.setFanBedRoom2(5);
              fanC.setText("Medium"");
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class QButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.setFanBedRoom2(3);
              fanC.setText(room.getLightBedRoom2());;
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class RButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.incLightA();
              LightA.setText("OFF");
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class SButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.decLightA();
              LightC.setText(room.getLightLivingRoom());
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class TButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.incLightB();
              LightA.setText(room.getLightBedRoom1());
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class UButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.decLightB();
              LightA.setText(room.getLightBedRoom1());
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class VButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.incLightC();
              LightB.setText(room.getLightBedRoom2());
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
      private class WButtonListener implements ActionListener
   {  
      public void actionPerformed(ActionEvent event)
      { 
          try {
              room.decLightC();
              LightB.setText(room.getLightBedRoom2());
          } catch (IOException ex) {
              Logger.getLogger(Admin_System.class.getName()).log(Level.SEVERE, null, ex);
          }   
   }
      }
      
   private int state;
   
//hardcoded variables
   private String alarm = "on";
   private int min = 68;
   private int max = 75;
   private int currentRoomA = 70;
   private int currentRoomB = 70;
   private int currentRoomC = 70;
   private int sampleCode1;
   private int sampleCode2 = 2468;
   private int userID = 1111;
   private int userID2 = 2345;
   private int[] userIDPerms = {1,0,1};
   private int[] userID2Perms = {0,0,0};
   private int[] userIDMusic = {1,0};
   private int[] userID2Music = {0,1};
   private int count = 0;
   private int currID = userID2;
   private int[] currPerms = userID2Perms;
   private int[] currMusic = userID2Music;
   
   //GUI materials
   private KeyPad pad;
   private JTextArea display;
   //the different states
   private static final int START_STATE = 1;
  
  
}
