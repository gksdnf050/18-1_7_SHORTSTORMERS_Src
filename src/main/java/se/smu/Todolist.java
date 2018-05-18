package se.smu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



public class Todolist extends JFrame{
	private JCheckBox chk;
	private JButton Hide_Button;
	private Register_Todolist RT;
	private JButton Add_Button;
	private JButton Delete_Button;
	private JButton Change_Button;
	
	
	private Row row;  
    private Cell cell;  
 
   	private JTable table; 
   	DefaultTableModel model;
   
   	public String[] column = {"V", "ÇÒ ÀÏ", "¸¶°¨ ±âÇÑ", "½ÇÁ¦ ¸¶°¨ÀÏ", "¿Ï·á ¿©ºÎ", "Áß¿äµµ"};
    public Object rowData[][];
    
    // Ãß°¡ 
    private String Subject_Name = new String();
    
    
    
    public void setSubject_Name(String Subject_Name) {
    		this.Subject_Name = Subject_Name;
    		System.out.println(this.Subject_Name);
    }
    
    public void RefreshTable_1() {
		
		try {
			DefaultTableModel model = new DefaultTableModel(rowData, column) {				
				public boolean isCellEditable(int row, int column) {
					if(column == 0) {
						return true;
					}
					return false;
				}
			};
			table.setModel(model);
	
			chk = new JCheckBox();
		    table.getColumn("V").setCellRenderer(dtcr1);	    
		    table.getColumn("V").setCellEditor(new DefaultCellEditor(chk));
		    chk.setHorizontalAlignment(JLabel.CENTER);
		    
		    Hide_render myRenderer = new Hide_render();
	   		myRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	   		
	   		TableColumn column = table.getColumnModel().getColumn(1); 
	   		column.setCellRenderer(myRenderer);
	   		
	   		TableColumn column2 = table.getColumnModel().getColumn(2); 
	   		column2.setCellRenderer(myRenderer);
	   		
	   		TableColumn column3 = table.getColumnModel().getColumn(3); 
	   		column3.setCellRenderer(myRenderer);
	   		
	   		TableColumn column4 = table.getColumnModel().getColumn(4); 
	   		column4.setCellRenderer(myRenderer);
	   		
	   		TableColumn column5 = table.getColumnModel().getColumn(5); 
	   		column5.setCellRenderer(myRenderer);
	   		
		    
		    
		    table.getTableHeader().setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		    
		    Color navy = new Color(0,32,96);
		    table.getTableHeader().setBackground(navy);
		    table.getTableHeader().setForeground(Color.white);
		    table.getColumnModel().getColumn(0).setPreferredWidth(10);
		    table.getColumnModel().getColumn(1).setPreferredWidth(200);
		    table.getColumnModel().getColumn(2).setPreferredWidth(50);
		    table.getColumnModel().getColumn(3).setPreferredWidth(50);
		    table.getColumnModel().getColumn(4).setPreferredWidth(50);
		    table.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		    table.setBackground(Color.WHITE);
		    table.setAutoCreateRowSorter(true);
		    TableRowSorter tablesorter = new TableRowSorter(table.getModel());
		    table.setRowSorter(tablesorter);
		

		    table.revalidate();
		    table.repaint();
		
		    FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
	         XSSFWorkbook workbook = new XSSFWorkbook(fis);
	         Sheet sheet = workbook.getSheetAt(0);
	         int rows = sheet.getPhysicalNumberOfRows();         
	         for(int i=0;i<rows;i++) {
	            Row row = sheet.getRow(i);
	         
	            if(row==null)
	               rows++;
	            else {
	               Object[] ob = {false,row.getCell(0),row.getCell(1),row.getCell(2),row.getCell(3),row.getCell(4)} ;
	               model.addRow(ob);      	   
	            }
	   		}	
	         fis.close();
		} 
		catch (Exception e) {			
			e.printStackTrace();		
		}		      
	}
    
    public void RefreshTable_2() {
	
	try {
		DefaultTableModel model = new DefaultTableModel(rowData, column) {				
			public boolean isCellEditable(int row, int column) {
				if(column == 0) {
					return true;
				}
				return false;
			}
		};
		table.setModel(model);

		chk = new JCheckBox();
	    table.getColumn("V").setCellRenderer(dtcr1);	    
	    table.getColumn("V").setCellEditor(new DefaultCellEditor(chk));
	    chk.setHorizontalAlignment(JLabel.CENTER);
	    
	    Show_render myRenderer2 = new Show_render();
   		myRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
   		
   		TableColumn column = table.getColumnModel().getColumn(1); 
   		column.setCellRenderer(myRenderer2);
   		
   		TableColumn column2 = table.getColumnModel().getColumn(2); 
   		column2.setCellRenderer(myRenderer2);
   		
   		TableColumn column3 = table.getColumnModel().getColumn(3); 
   		column3.setCellRenderer(myRenderer2);
   		
   		TableColumn column4 = table.getColumnModel().getColumn(4); 
   		column4.setCellRenderer(myRenderer2);
   		
   		TableColumn column5 = table.getColumnModel().getColumn(5); 
   		column5.setCellRenderer(myRenderer2);
   		
	    
	    
	    table.getTableHeader().setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
	    
	    Color navy = new Color(0,32,96);
	    table.getTableHeader().setBackground(navy);
	    table.getTableHeader().setForeground(Color.white);
	    table.getColumnModel().getColumn(0).setPreferredWidth(10);
	    table.getColumnModel().getColumn(1).setPreferredWidth(200);
	    table.getColumnModel().getColumn(2).setPreferredWidth(50);
	    table.getColumnModel().getColumn(3).setPreferredWidth(50);
	    table.getColumnModel().getColumn(4).setPreferredWidth(50);
	    table.getColumnModel().getColumn(5).setPreferredWidth(50);
	
	    table.setBackground(Color.WHITE);
	    table.setAutoCreateRowSorter(true);
	    TableRowSorter tablesorter = new TableRowSorter(table.getModel());
	    table.setRowSorter(tablesorter);
	

	    table.revalidate();
	    table.repaint();
	
	    FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(fis);
         Sheet sheet = workbook.getSheetAt(0);
         int rows = sheet.getPhysicalNumberOfRows();         
         for(int i=0;i<rows;i++) {
            Row row = sheet.getRow(i);
         
            if(row==null)
               rows++;
            else {
               Object[] ob = {false,row.getCell(0),row.getCell(1),row.getCell(2),row.getCell(3),row.getCell(4)} ;
               model.addRow(ob);      	   
            }
   		}	
         fis.close();
	} 
	catch (Exception e) {			
		e.printStackTrace();		
	}		      
}

    public void RefreshTable() {
		
		try {
			DefaultTableModel model = new DefaultTableModel(rowData, column) {				
				public boolean isCellEditable(int row, int column) {
					if(column == 0) {
						return true;
					}
					return false;
				}
			};
			table.setModel(model);
	
			chk = new JCheckBox();
		    table.getColumn("V").setCellRenderer(dtcr1);	    
		    table.getColumn("V").setCellEditor(new DefaultCellEditor(chk));
		    chk.setHorizontalAlignment(JLabel.CENTER);
		    
		    DefaultTableCellRenderer Todo = new DefaultTableCellRenderer();
		    Todo.setHorizontalAlignment(SwingConstants.CENTER);
		    table.getColumn("ÇÒ ÀÏ").setCellRenderer(Todo);
		    
	    
		    DefaultTableCellRenderer Dead = new DefaultTableCellRenderer();
		    Dead.setHorizontalAlignment(SwingConstants.CENTER);
		    table.getColumn("¸¶°¨ ±âÇÑ").setCellRenderer(Dead);
		    
		    
		    DefaultTableCellRenderer Actual = new DefaultTableCellRenderer();
		    Actual.setHorizontalAlignment(SwingConstants.CENTER);
		    table.getColumn("½ÇÁ¦ ¸¶°¨ÀÏ").setCellRenderer(Actual);
		    
		    DefaultTableCellRenderer Done = new DefaultTableCellRenderer();
		    Done.setHorizontalAlignment(SwingConstants.CENTER);
		    table.getColumn("¿Ï·á ¿©ºÎ").setCellRenderer(Done);
		    
		    
		    DefaultTableCellRenderer Import = new DefaultTableCellRenderer();
		    Import.setHorizontalAlignment(SwingConstants.CENTER);
		    table.getColumn("Áß¿äµµ").setCellRenderer(Import);
		    
		    
		    table.getTableHeader().setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
		    
		    Color navy = new Color(0,32,96);
		    table.getTableHeader().setBackground(navy);
		    table.getTableHeader().setForeground(Color.white);
		    table.getColumnModel().getColumn(0).setPreferredWidth(10);
		    table.getColumnModel().getColumn(1).setPreferredWidth(200);
		    table.getColumnModel().getColumn(2).setPreferredWidth(50);
		    table.getColumnModel().getColumn(3).setPreferredWidth(50);
		    table.getColumnModel().getColumn(4).setPreferredWidth(50);
		    table.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		    table.setBackground(Color.WHITE);
		    table.setAutoCreateRowSorter(true);
		    TableRowSorter tablesorter = new TableRowSorter(table.getModel());
		    table.setRowSorter(tablesorter);
		

		    table.revalidate();
		    table.repaint();
		
		    FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
	         XSSFWorkbook workbook = new XSSFWorkbook(fis);
	         Sheet sheet = workbook.getSheetAt(0);
	         int rows = sheet.getPhysicalNumberOfRows();         
	         for(int i=0;i<rows;i++) {
	            Row row = sheet.getRow(i);
	         
	            if(row==null)
	               rows++;
	            else {
	               Object[] ob = {false,row.getCell(0),row.getCell(1),row.getCell(2),row.getCell(3),row.getCell(4)} ;
	               model.addRow(ob);      	   
	            }
	   		}	
	         fis.close();
		} 
		catch (Exception e) {			
			e.printStackTrace();		
		}		      
	}
      
    public void TableSetting()throws IOException{
  	   try {
  	         FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
  	         XSSFWorkbook workbook = new XSSFWorkbook(fis);
  	         Sheet sheet = workbook.getSheetAt(0);
  	         int rows = sheet.getPhysicalNumberOfRows();
  	         
  	         for(int i=0;i<rows;i++) {
  	            Row row = sheet.getRow(i); 	         
  	            if(row==null)
  	               rows++;
  	            else {
  	               Object[] ob = {false,row.getCell(0),row.getCell(1),row.getCell(2),row.getCell(3),row.getCell(4)} ;
  	               model.addRow(ob);   
  	             
  	            }

  	   		} 
  	       
  	      fis.close();
  	   	}
  	   	catch (FileNotFoundException e){
  	   			e.printStackTrace();
  	   	}   
     }
     
    DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer(){		
	      public Component getTableCellRendererComponent
	      (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	      {
	         chk = new JCheckBox();
	         chk.setSelected(((Boolean)value).booleanValue());
	         chk.setHorizontalAlignment(JLabel.CENTER);
	         return chk;	         
	      }
    };
	public Todolist(final String Subject_Name) {    
    		this.Subject_Name = Subject_Name;
    	
    		Color navy = new Color(0,32,96);
	    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
	    JLabel Title_Label = new JLabel(Subject_Name + " To do LIST");
	    Title_Label.setFont(new Font("HY°ß°íµñ",Font.BOLD,30));
	    Title_Label.setForeground(navy);
	    this.add(Title_Label);
	    
	    Add_Button = new JButton("µî·Ï");
	    Add_Button.setBackground(Color.white);
	    Add_Button.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
	    
	    Delete_Button = new JButton("»èÁ¦");
	    Delete_Button.setBackground(Color.white);
	    Delete_Button.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
	    
	    Change_Button = new JButton("¼öÁ¤");
	    Change_Button.setBackground(Color.white);
	    Change_Button.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
	    
	    Hide_Button = new JButton("¼û±â±â");
	    Hide_Button.setBackground(Color.white);
	    Hide_Button.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,20));
	    
	    add(Add_Button);
	    add(Delete_Button);
	    add(Change_Button);
	    add(Hide_Button);
	    	    
	    model = new DefaultTableModel(rowData,column)
	    	{    	
	    		public boolean isCellEditable(int rowData, int column)
	    		{ 
	    			if(column>0) {
	    				return false; 
	    						}
	    		else {
	    			return true;
	    			}
	    			
	    		}
	    	};
	    	
	    table= new JTable(model);
	    JScrollPane scrollpane =new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
	    this.add(scrollpane);
	    table.setRowSorter(new TableRowSorter(model)); 
	    
	    
	    chk = new JCheckBox();
	    table.getColumn("V").setCellRenderer(dtcr1);	    
	    table.getColumn("V").setCellEditor(new DefaultCellEditor(chk));
	    chk.setHorizontalAlignment(JLabel.CENTER);
	    
	    DefaultTableCellRenderer Todo = new DefaultTableCellRenderer();
	    Todo.setHorizontalAlignment(SwingConstants.CENTER);
	    table.getColumn("ÇÒ ÀÏ").setCellRenderer(Todo);
	    
    
	    DefaultTableCellRenderer Dead = new DefaultTableCellRenderer();
	    Dead.setHorizontalAlignment(SwingConstants.CENTER);
	    table.getColumn("¸¶°¨ ±âÇÑ").setCellRenderer(Dead);
	    
	    
	    DefaultTableCellRenderer Actual = new DefaultTableCellRenderer();
	    Actual.setHorizontalAlignment(SwingConstants.CENTER);
	    table.getColumn("½ÇÁ¦ ¸¶°¨ÀÏ").setCellRenderer(Actual);
	    
	    DefaultTableCellRenderer Done = new DefaultTableCellRenderer();
	    Done.setHorizontalAlignment(SwingConstants.CENTER);
	    table.getColumn("¿Ï·á ¿©ºÎ").setCellRenderer(Done);
	    
	    
	    DefaultTableCellRenderer Import = new DefaultTableCellRenderer();
	    Import.setHorizontalAlignment(SwingConstants.CENTER);
	    table.getColumn("Áß¿äµµ").setCellRenderer(Import);
	    
	    
	    table.getTableHeader().setFont(new Font("¸¼Àº°íµñ",Font.BOLD,15));
	    
	    
	    table.getTableHeader().setBackground(navy);
	    table.getTableHeader().setForeground(Color.white);
	    table.getColumnModel().getColumn(0).setPreferredWidth(10);
	    table.getColumnModel().getColumn(1).setPreferredWidth(200);
	    table.getColumnModel().getColumn(2).setPreferredWidth(50);
	    table.getColumnModel().getColumn(3).setPreferredWidth(50);
	    table.getColumnModel().getColumn(4).setPreferredWidth(50);
	    table.getColumnModel().getColumn(5).setPreferredWidth(50);
	    
	    try {
	         TableSetting();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	    
	    this.setLayout(null);
	    Add_Button.setBounds(368,160,80,30);
	    Delete_Button.setBounds(458,160,80,30);
	    Change_Button.setBounds(548,160,80,30);
	    Hide_Button.setBounds(238,160,120,30);
	    scrollpane.setBounds(10, 200, 620, 200);
	    Title_Label.setBounds(100, 50, 450, 40);

	    
	    setSize(650,750);
	    setVisible(false);
	    
	    Hide_Button.addActionListener(new ActionListener(){
		   	public void actionPerformed(ActionEvent e) {
		   		JButton b = (JButton)e.getSource();
		   		
		   		if(b.getText().equals("¼û±â±â")) {
		   		Hide_render myRenderer = new Hide_render();
		   		myRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		   		
		   		TableColumn column = table.getColumnModel().getColumn(1); 
		   		column.setCellRenderer(myRenderer);
		   		
		   		TableColumn column2 = table.getColumnModel().getColumn(2); 
		   		column2.setCellRenderer(myRenderer);
		   		
		   		TableColumn column3 = table.getColumnModel().getColumn(3); 
		   		column3.setCellRenderer(myRenderer);
		   		
		   		TableColumn column4 = table.getColumnModel().getColumn(4); 
		   		column4.setCellRenderer(myRenderer);
		   		
		   		TableColumn column5 = table.getColumnModel().getColumn(5); 
		   		column5.setCellRenderer(myRenderer);
		   		
		   		Hide_Button.setText("º¸¿©ÁÖ±â"); 
		   		RefreshTable_1();
		   		}
		   		else {
		   			Show_render myRenderer = new Show_render();
			   		myRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			   		
			   		TableColumn column = table.getColumnModel().getColumn(1); 
			   		column.setCellRenderer(myRenderer);
			   		
			   		TableColumn column2 = table.getColumnModel().getColumn(2); 
			   		column2.setCellRenderer(myRenderer);
			   		
			   		TableColumn column3 = table.getColumnModel().getColumn(3); 
			   		column3.setCellRenderer(myRenderer);
			   		
			   		TableColumn column4 = table.getColumnModel().getColumn(4); 
			   		column4.setCellRenderer(myRenderer);
			   		
			   		TableColumn column5 = table.getColumnModel().getColumn(5); 
			   		column5.setCellRenderer(myRenderer);
		   			
		   			b.setText("¼û±â±â");
		   			RefreshTable_2();
		   		}
		   		
		 /* 	int row = table.getRowCount();
		   		int column = table.getColumnCount();
		   		String value[] =  new String[row];
		   		
		   		for(int r=0;r<row;r++) {
		   		 value[r] =  table.getValueAt(r,4).toString();
		   		
		   		}
		   		
		   		for(int j=0; j<column;j++) {
		   			for(int i=0; i<row;i++)
			   			if (value[i].equals("ï¿½Ï·ï¿½"))
			   			{
			   				table.getValueAt(j, i).
			   			}
		   		}*/
		   		
		   		/*try {
		   		FileInputStream fis = new FileInputStream("C:\\Users\\Public\\Book1.xlsx");
		   		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		   		Sheet sheet = workbook.getSheetAt(0);
		   		int rows = sheet.getPhysicalNumberOfRows(); 
		   		String[] ob = new String[rows];
		   		
		   		for(int i=0;i<rows;i++) {
	            
		                ob[i] = sheet.getRow(i).getCell(3).toString();

		   		}for(int i=0;i<rows;i++) {
		   			if(ob[i].equals("ï¿½Ï·ï¿½"))
			   		{
			   			row=sheet.getRow(i);
			   			row.getCell(0).
			   			row.getCell(1)
			   			row.getCell(2)
			   			row.getCell(3)
			   			row.getCell(4)
			   			
			   		}
		   		}
		   		fis.close();
		   		
		   		FileInputStream fis2 = new FileInputStream("C:\\Users\\Public\\Book1.xlsx");
		   		XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
		   		Sheet sheet2 = workbook2.getSheetAt(0);
		   		
		   		
		   		}
		   		
		   		catch (IOException e){
	  	   			e.printStackTrace();
	  	   	}  */
		   }
	    });
	    
   
	   
	    Add_Button.addActionListener(new ActionListener(){
		   	public void actionPerformed(ActionEvent arg0) {
		   		
		   	setVisible(false);
		   	RT = new Register_Todolist(Subject_Name);
		   	RT.setVisible(true);
		   	
		   }
	    });
   
   
	    Change_Button.addActionListener(new ActionListener(){
		   	public void actionPerformed(ActionEvent arg0) {
		   		
		   		UIManager UI =new UIManager();
	   			Color navy = new Color(0,32,96);
	   			Font message = new Font("¸¼Àº°íµñ",Font.BOLD,20);
	   			UI.put("OptionPane.messageForeground", navy);
	   			UI.put("OptionPane.messageFont", message);
		   		
		   		int SelectedNum = 0;
				int SelectedRowNum = 0;
				boolean Select = Boolean.FALSE;
				for(int i=0; i < table.getRowCount() ; i++) {
					if(table.getValueAt(i, 0) == Boolean.TRUE) {
						SelectedNum++;
						SelectedRowNum = i;
					}
				}
				
				if(SelectedNum == 0 || SelectedNum > 1) {
					if(SelectedNum == 0) {
					JOptionPane.showMessageDialog(null , "Ç×¸ñÀ» ¼±ÅÃÇØÁÖ¼¼¿ä.", "¾Ë¸²", JOptionPane.INFORMATION_MESSAGE);	}
					if(SelectedNum > 1) {
					JOptionPane.showMessageDialog(null , "ÇÏ³ªÀÇ Ç×¸ñ¸¸ ¼±ÅÃÇØÁÖ¼¼¿ä.", "¾Ë¸²", JOptionPane.INFORMATION_MESSAGE);}
				}				
				
				
				else {
					Select = Boolean.TRUE;
				}
				
				if(Select == Boolean.TRUE) {
		   		String[] data = new String[5];
				for(int i = 0; i < 5; i++) {
					data[i] = table.getValueAt(SelectedRowNum, i+1).toString();
				}
		   	 setVisible(false);
		   	 new Change_Todolist(SelectedRowNum, data).setVisible(true);
		   		}
		   	}
		   
		 });
   
   
	   Delete_Button.addActionListener(new ActionListener(){
		   	public void actionPerformed(ActionEvent arg0) {
		   		
		   		UIManager UI =new UIManager();
	   			Color navy = new Color(0,32,96);
	   			Font message = new Font("¸¼Àº°íµñ",Font.BOLD,20);
	   			UI.put("OptionPane.messageForeground", navy);
	   			UI.put("OptionPane.messageFont", message);
	   			
		   		if(chk.isSelected()) {
				int SelectedNum = 0;
				Vector<Integer> SelectedRowNum = new Vector<Integer>();
				 
				for(int i=0; i < table.getRowCount() ; i++) {
					if(table.getValueAt(i, 0) == Boolean.TRUE) {
						SelectedNum++;
						SelectedRowNum.add(Integer.valueOf(i));
						
					}
				}
				
				int SelectedNum2 = 0;
				int SelectedRowNum2 = 0;
				boolean Select = Boolean.FALSE;
				for(int i=0; i < table.getRowCount() ; i++) {
					if(table.getValueAt(i, 0) == Boolean.TRUE) {
						SelectedNum2++;
						SelectedRowNum2 = i;
					}
								
			}
				String[] data = new String[5];
				for(int i = 0; i < 5; i++) {
					data[i] = table.getValueAt(SelectedRowNum2, i+1).toString();
				}
				try {
					
						FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/Trashcan.xlsx");
						XSSFWorkbook workbook = new XSSFWorkbook(fis);
						Sheet sheet = workbook.getSheetAt(0);
						//Row NextRow = sheet.getRow(0);
						//Cell NextCell = NextRow.getCell(0);

						int rows = sheet.getPhysicalNumberOfRows();
						Row row = sheet.createRow(rows);
						
						row.createCell(0).setCellValue(data[0]);   	   		
						row.createCell(1).setCellValue(data[1]);   	   			
						row.createCell(2).setCellValue(data[2]);	   			
						row.createCell(3).setCellValue(data[3]);
						row.createCell(4).setCellValue(data[4]);
						
						/*int	NextRowNum=0;
						
						for(int searchRow = 0; searchRow < sheet.getPhysicalNumberOfRows();searchRow++) {
							row = sheet.getRow(searchRow);
							cell = row.getCell(0);
							
							if (cell.getStringCellValue() == ""){
								for(NextRowNum = searchRow; NextRowNum < sheet.getPhysicalNumberOfRows(); NextRowNum++) {
									
									NextRow = sheet.getRow(NextRowNum);
									NextCell = NextRow.getCell(0);
									if(NextCell.getStringCellValue() != "") {
										
										for(int r = 0; r <row.getPhysicalNumberOfCells(); r++) {
											NextCell = NextRow.getCell(r);
											row.getCell(r).setCellValue(NextCell.getStringCellValue());
											NextCell.setCellValue("");
										}
										break;
									}
								}
							}
						}*/
				
						
						
					FileOutputStream fos = new FileOutputStream("./Subject_Dir/ToDolist_Dir/Trashcan.xlsx");
	   				workbook.write(fos);    
	   				fos.close();
	   				fis.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				} 
								
					try {
						FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
						XSSFWorkbook workbook = new XSSFWorkbook(fis);
						Sheet sheet = workbook.getSheetAt(0);
						int rows=0;
						Iterator <Integer> it = SelectedRowNum.iterator();
						Row row; 
						Row NextRow = sheet.getRow(0);
						Cell NextCell = NextRow.getCell(0);
							
						while(it.hasNext()) {
							rows = it.next().intValue();							
							row = sheet.getRow(rows);
						
							row.getCell(0).setCellValue("");
							row.getCell(1).setCellValue("");
							row.getCell(2).setCellValue("");
							row.getCell(3).setCellValue("");
							row.getCell(4).setCellValue("");
							
							
						}
		
						int	NextRowNum=0;
												
						for(int searchRow = 0; searchRow < sheet.getPhysicalNumberOfRows();searchRow++) {
							row = sheet.getRow(searchRow);
							cell = row.getCell(0);
							
							if (cell.getStringCellValue() == ""){
								for(NextRowNum = searchRow; NextRowNum < sheet.getPhysicalNumberOfRows(); NextRowNum++) {
									
									NextRow = sheet.getRow(NextRowNum);
									NextCell = NextRow.getCell(0);
									if(NextCell.getStringCellValue() != "") {
										
										for(int r = 0; r <row.getPhysicalNumberOfCells(); r++) {
											NextCell = NextRow.getCell(r);
											row.getCell(r).setCellValue(NextCell.getStringCellValue());
											NextCell.setCellValue("");
										}
										break;
									}
								}
							}
						}
						
						for(int i=0; i < SelectedRowNum.size() ; i++) {
							
							row = sheet.getRow(sheet.getLastRowNum());
							sheet.removeRow(row);
						}
				
						FileOutputStream fos = new FileOutputStream("./Subject_Dir/ToDolist_Dir/"+ Subject_Name +".xlsx");
						workbook.write(fos);
						fos.close();
						fis.close();
						
						   	   					   	   			
					} catch (Exception ex) {
						ex.printStackTrace();
					} 
					RefreshTable();	
					
		   		}
		   		else {
		   			JOptionPane.showMessageDialog(null , "Ç×¸ñÀ» ¼±ÅÃÇØÁÖ¼¼¿ä.","¾Ë¸²", JOptionPane.INFORMATION_MESSAGE);
		   		}
		   	}
		   
	   });

	}
    
}