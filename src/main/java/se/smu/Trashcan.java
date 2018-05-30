package se.smu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Trashcan extends JFrame {
	DefaultTableCellRenderer dcr,check;
	DefaultTableModel model;
	JTable Table;
	JScrollPane jscollPane;
	JButton restore,remove;
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	Font default_font = new Font("맑은 고딕",Font.BOLD,20);
	Color default_color = new Color(0,32,96);
	
	public Trashcan() {
		TableSetting();
		TableColumnSetting();
		ButtonSetting();
		
		try {
			DataSetting();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		JLabel Title_label = new JLabel("휴지통");
		Title_label.setFont(new Font("HY견고딕",Font.BOLD,30));
		Title_label.setForeground(default_color);
		
		Title_label.setBounds(260, 25, 200, 50);
		jscollPane.setBounds(50,100,550,270);
		restore.setBounds(170,400,130,40);
		remove.setBounds(350,400,130,40);
		
		add(Title_label);
		add(jscollPane);
		add(restore);
		add(remove);
		
		setSize(650,550);
		setVisible(true);
	}
	  
	

	
	
	public void TableSetting() {
		String columnNames[] = {"V","과목","To do","마감 기한","실제 마감일","완료 여부"};
		
		dcr = new DefaultTableCellRenderer() {	
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){	
				JCheckBox box= new JCheckBox();
				box.setSelected(((Boolean)value).booleanValue());  
				return box;
			}
		};

		model = new DefaultTableModel(null,columnNames) {
			public boolean isCellEditable(int row,int column) {
				if(column>0)
					return false;
				else
					return true;
			}
		};
		
		Table = new JTable(model);
		Table.setRowHeight(30);
		TableHeaderSetting();
		jscollPane = new JScrollPane(Table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
	}
	
	
	
	public void TableColumnSetting() {	
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		Table.getColumn("V").setCellRenderer(center);
		Table.getColumn("과목").setCellRenderer(center);
		Table.getColumn("To do").setCellRenderer(center);
		Table.getColumn("마감 기한").setCellRenderer(center);
		Table.getColumn("실제 마감일").setCellRenderer(center);
		Table.getColumn("완료 여부").setCellRenderer(center);
		Table.getTableHeader().setReorderingAllowed(false);
		
		Table.getColumn("V").setCellRenderer(dcr);
		JCheckBox checkbox = new JCheckBox();
		Table.getColumn("V").setCellEditor(new DefaultCellEditor(checkbox));
	}
	
	
	
	public void TableHeaderSetting() {
		JTableHeader header = Table.getTableHeader();
		header.setBackground(default_color);
		header.setForeground(new Color(255,255,255));
		
		Table.getColumnModel().getColumn(0).setPreferredWidth(20);
		Table.getColumnModel().getColumn(1).setPreferredWidth(120);
		Table.getColumnModel().getColumn(2).setPreferredWidth(200);
		Table.getColumnModel().getColumn(3).setPreferredWidth(60);
		Table.getColumnModel().getColumn(4).setPreferredWidth(70);
		Table.getColumnModel().getColumn(5).setPreferredWidth(60);
	}
	
	
	
	public void ButtonSetting() {
		restore= new JButton("복 구");
		restore.setFont(default_font);
		restore.setForeground(new Color(0,0,0));
		restore.setBackground(new Color(255,255,255));
		restore.addActionListener(new MyActionListener());
		
		remove = new JButton("영구 삭제");
		remove.setFont(default_font);
		remove.setForeground(new Color(0,0,0));
		remove.setBackground(new Color(255,255,255));
		remove.addActionListener(new MyActionListener());
	}
	
	
	 
	public void DataSetting() throws IOException {	
		try {
			FileInputStream fis = new FileInputStream("./Subject_Dir/ToDolist_Dir/Trashcan.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			for(int i=1;i<rows;i++) {
				XSSFRow row = sheet.getRow(i);
				if(row==null)
					rows++;
				else {
					Object[] obj = {false,row.getCell(0),row.getCell(1),row.getCell(2),row.getCell(3),row.getCell(4)} ;
					model.addRow(obj);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void TableReset() throws IOException {
		model = (DefaultTableModel)Table.getModel();
		model.setNumRows(0);
		int rows = sheet.getPhysicalNumberOfRows();
		for(int i=1;i<rows;i++) {
			XSSFRow row = sheet.getRow(i);
			if(row==null)
				rows++;
			else {
				Object[] obj = {false,row.getCell(0),row.getCell(1),row.getCell(2),row.getCell(3),row.getCell(4)} ;
				model.addRow(obj);
			}
		}
	}
		
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("영구 삭제")){
				boolean check = false;
				for(int i=0;i<model.getRowCount();i++) {
					if(Table.getModel().getValueAt(i, 0).equals(true)) {
						int j=0;
						check=true;
						while(sheet.getRow(j)==null || !sheet.getRow(j).getCell(0).equals(Table.getModel().getValueAt(i, 1))) 
							j++;
						sheet.removeRow(sheet.getRow(j));	
					}
				}
				if(check==false)
					JOptionPane.showMessageDialog(null , "아무것도 선택되지 않았습니다.");
				else {
					try {
						TableReset();
						FileOutputStream fos = new FileOutputStream("./Subject_Dir/ToDolist_Dir/Trashcan.xlsx");
						workbook.write(fos);
						fos.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
				}
			}
			
			else {
				boolean check = false;
				for(int i=0;i<model.getRowCount();i++) {
					if(Table.getModel().getValueAt(i, 0).equals(true)) {
						int index=0;
						check=true;
						String Subject = Table.getModel().getValueAt(i, 1).toString();
						FileInputStream fis2;
						FileOutputStream fos2;
						
						while(sheet.getRow(index)==null || !sheet.getRow(index).getCell(0).equals(Table.getModel().getValueAt(i, 1))) 
							index++;
						String[] data= {Table.getModel().getValueAt(i, 1).toString(),
								Table.getModel().getValueAt(i, 2).toString(),
								Table.getModel().getValueAt(i, 3).toString(),
								Table.getModel().getValueAt(i, 4).toString(),
								Table.getModel().getValueAt(i, 5).toString(),
								sheet.getRow(index).getCell(5).toString()};
						sheet.removeRow(sheet.getRow(index));

						try {
							fis2 = new FileInputStream("./Subject_Dir/ToDolist_Dir/"+Subject+".xlsx");
							XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
							XSSFSheet sheet2 = workbook2.getSheetAt(0);
							index=0;
							while(true) {
								XSSFRow row = sheet2.getRow(index);
								if(row!=null)
									index++;
								else {
									row = sheet2.createRow(index);
									for(int z=0;z<6;z++) 
										row.createCell(z).setCellValue(data[z]);
									break;
								}
							}
							fos2 = new FileOutputStream("./Subject_Dir/ToDolist_Dir/"+Subject+".xlsx");
							workbook2.write(fos2);
							fos2.close();
							
						} catch (Exception e1) {
							e1.printStackTrace();
						} 
					}
				}
				if(check==false)
					JOptionPane.showMessageDialog(null , "아무것도 선택되지 않았습니다.");
				else {
					try {
						TableReset();
						FileOutputStream fos = new FileOutputStream("./Subject_Dir/ToDolist_Dir/Trashcan.xlsx");
						workbook.write(fos);
						fos.close();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}	
	}
}

