package se.smu;


import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



public class Change_Todolist extends JFrame {
   String[] Todo = {"","","",""};   
   String[] data = {"","","","","",""};
   String Subject_Name;
   

   Change_Todolist(final int SelectedRowNum,final String[] data,final String Subject_Name){
      this.Subject_Name = Subject_Name;
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       String[] Dead_day = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
                "24","25","26","27","28","29","30","31"};
       JComboBox Day_combo = new JComboBox(Dead_day);
       this.add(Day_combo);
          
      String[] Actual_day = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
                   "24","25","26","27","28","29","30","31"};
      JComboBox Day_Combo2 = new JComboBox(Actual_day);
      this.add(Day_Combo2);  
      
       JLabel Todo_Label = new JLabel("To do ¸í :");
       Todo_Label.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(Todo_Label);
       final JTextField Todo_text = new JTextField("ÀÔ·ÂÇØÁÖ¼¼¿ä");
       this.add(Todo_text);
       
       JLabel Actual_Label = new JLabel("½ÇÁ¦ ¸¶°¨ÀÏ :");
       Actual_Label.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(Actual_Label);
       
       JLabel Title_Label = new JLabel("To Do ¼öÁ¤");
       Title_Label.setFont(new Font("HY°ß°íµñ",Font.BOLD,30));
       this.add(Title_Label);
       
       String[] Done = {"","ÁØºñ","ÁøÇà","¿Ï·á"};
       final JComboBox Done_Combo = new JComboBox(Done);
       this.add(Done_Combo);
       
       String[] Dead_mon = {"","1","2","3","4","5","6","7","8","9","10","11","12"};
       JComboBox Month_combo = new JComboBox(Dead_mon);
       this.add(Month_combo);
             

       JLabel Deadline_Label = new JLabel("¸¶°¨ ±âÇÑ:");
       Deadline_Label.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(Deadline_Label);
       
      
       
       JLabel Month_Label = new JLabel("¿ù");
       Month_Label.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(Month_Label);
       
       Month_combo.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             JComboBox <String> cb = (JComboBox)e.getSource();
             Todo[0] =cb.getSelectedItem().toString();
          };
       });
       

       
       
       Day_combo.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                JComboBox <String> cb = (JComboBox)e.getSource();
                Todo[1] =cb.getSelectedItem().toString();
             };
          });
       
       
       String[] Actual_mon = {"","1","2","3","4","5","6","7","8","9","10","11","12"};
       JComboBox Month_Combo2 = new JComboBox(Actual_mon);

       JLabel day_Label = new JLabel("ÀÏ");
       day_Label.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(day_Label);
       
       JLabel Import_Label = new JLabel("Áß¿äµµ ");
       Import_Label.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(Import_Label);
       
       Month_Combo2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             JComboBox <String> cb = (JComboBox)e.getSource();
             Todo[2]=cb.getSelectedItem().toString();
          };
       });
       
       
       String[] Import = {"","1", "2", "3" };
       final JComboBox Import_Combo = new JComboBox(Import);
       this.add(Import_Combo);
       
       this.add(Month_Combo2);
       JLabel Month_Label2 = new JLabel("¿ù");
       Month_Label2.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(Month_Label2);
       
      
       JLabel IsDone_Label = new JLabel("¿Ï·á ¿©ºÎ ");
       IsDone_Label.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(IsDone_Label);
       
       Import_Combo.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                JComboBox <String> cb = (JComboBox)e.getSource();
                data [4]=cb.getSelectedItem().toString();
             };
          });
       
        Day_Combo2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               JComboBox <String> cb = (JComboBox)e.getSource();
               Todo[3]=cb.getSelectedItem().toString();
            };
        });
       JButton Cancel_Button = new JButton("Ãë¼Ò");
       JLabel day_Label2 = new JLabel("ÀÏ");
       day_Label2.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
       this.add(day_Label2);
       
       Cancel_Button.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
       this.add(Cancel_Button);
       
       
       Done_Combo.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             JComboBox <String> cb = (JComboBox)e.getSource();
             data[3]=cb.getSelectedItem().toString();
          };
       });
       
   
       JButton Done_Button = new JButton("¼öÁ¤ ¿Ï·á");
       Done_Button.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
      
    
       Cancel_Button.setBackground(Color.white);
       Done_Button.setBackground(Color.white);
       this.add(Done_Button);
       
       this.setLayout(null);
       Month_Label2.setBounds(280, 300, 450, 40);
       Todo_text.setBounds(180,100,350,40);
       Day_combo.setBounds(350,200,80,40);
       Import_Label.setBounds(350, 400, 450, 40);
       Done_Combo.setBounds(180,400,80,40);
       Deadline_Label.setBounds(80, 200, 450, 40);
       Month_Label.setBounds(280, 200, 450, 40);
       day_Label.setBounds(450, 200, 450, 40);
       Done_Button.setBounds(180,600,130,30);
       day_Label2.setBounds(450, 300, 450, 40);
       IsDone_Label.setBounds(80, 400, 450, 40);       
       Cancel_Button.setBounds(360,600,130,30);
       Actual_Label.setBounds(80, 300, 450, 40);
       Month_combo.setBounds(180,200,80,40);       
       Month_Combo2.setBounds(180,300,80,40);      
       Day_Combo2.setBounds(350,300,80,40);       
       Import_Combo.setBounds(430,400,80,40);
      Title_Label.setBounds(250, 30, 450, 40);

       setSize(650,750);
          
       Done_Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                
               UIManager UI =new UIManager();
         Color navy = new Color(0,32,96);
         Font message = new Font("¸¼Àº°íµñ",Font.BOLD,20);
         UI.put("OptionPane.messageForeground", navy);
         UI.put("OptionPane.messageFont", message);
               
         data[0] = new String(Todo[0]+"¿ù" + Todo[1]+"ÀÏ");
         data[1] = new String(Todo[2]+"¿ù" + Todo[3]+"ÀÏ");
         data[2] = Todo_text.getText();
         data[3] = Done_Combo.getSelectedItem().toString();
         data[4] = Import_Combo.getSelectedItem().toString();
            boolean change = Boolean.FALSE;
            
            
      
         if(data[0].equals("¿ùÀÏ") || data[1].equals("¿ùÀÏ") || data[2].equals("ÀÔ·ÂÇØÁÖ¼¼¿ä") || data[3].equals("") ||data[4].equals("")) {
            JOptionPane.showMessageDialog(null , "ÇÊ¼ö ÀÔ·Â »çÇ×ÀÔ´Ï´Ù.", "¾Ë¸²", JOptionPane.INFORMATION_MESSAGE);                   
            
         }
         else change = Boolean.TRUE;
      
      if(change == Boolean.TRUE) {                  
                  try {
               
                     FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
                     XSSFWorkbook workbook = new XSSFWorkbook(fis);
                     Sheet sheet = workbook.getSheetAt(0);
                  

                     int rows = SelectedRowNum+1;
                     Row row = sheet.createRow(rows);
                     
         
                     row.createCell(0).setCellValue(Subject_Name);
                     row.createCell(1).setCellValue(data[2]);               
                     row.createCell(2).setCellValue(data[0]);                  
                     row.createCell(3).setCellValue(data[1]);               
                     row.createCell(4).setCellValue(data[3]);
                     row.createCell(5).setCellValue(data[4]);

                  
                     FileOutputStream fos = new FileOutputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
                     workbook.write(fos);    
                     fos.close();
                     fis.close();
                  
            
                  }
               
                     catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            
               setVisible(false);
                new Todolist(Subject_Name).setVisible(true);
                              }
            }         
            
        });         
       
  

      Cancel_Button.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0) {
             setVisible(false);
             new Todolist(Subject_Name).setVisible(true);
               }
         });
 
 }
}