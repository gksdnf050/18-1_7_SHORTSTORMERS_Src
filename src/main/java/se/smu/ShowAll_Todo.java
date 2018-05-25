package se.smu;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.io.File;
import java.io.FileInputStream;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ShowAll_Todo extends JFrame {
	String Todo,Done,Sub,VALUE;
	String Dead_day,Actual_day;
	XSSFRow row;
	XSSFCell cell;
    Boolean Is_import;
    File file;

    ToDoList_Main win;
    
    //////////�ɹ� �ʵ�
    
    private JLabel Title_Label;
    private JTable tableArea;
    private JScrollPane scrollArea;
    
    //////////UI�ɹ� �ʵ�
    
    public ShowAll_Todo(ToDoList_Main win) {//������
    	this.win = win;
    	setSize(750,650);
    	    
    setLayout(null);
    	
    	JPanel Label = new JPanel();
    	JPanel Table = new JPanel();
    	
    	////////////////////////////////////////////////////////////Title Label
    	Title_Label=new JLabel("��ü TO do LIST");
    	Title_Label.setFont(new Font("HY�߰��",Font.BOLD,30));
    	Title_Label.setForeground(new Color(0,32,96));
    	Label.add(Title_Label);
    	add(Label);
    	Label.setBounds(220,70,300,50);
    	
    	////////////////////////////////////////////////////////////TableArea
    	String ColumnNames[] = {"����","TO do","���� ����","���� ������","�Ϸ� ����"};
    	
    	
    	DefaultTableModel model = new DefaultTableModel(ColumnNames,0) { // table ���� ���� �Ұ�
    		 public boolean isCellEditable(int rowIndex, int mColIndex) {
    	        	return false;
    	        }
    	};
    	tableArea = new JTable(model);
    	scrollArea = new JScrollPane(tableArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //��ũ�� �߰�
    	
    	
    	scrollArea.setPreferredSize(new Dimension(650,400)); // table ũ������ 
    	Table.setBounds(0,150,735,500); 
    	
        tableArea.getTableHeader().setReorderingAllowed(false); // table �Ӽ��� �̵� ����
        
        tableArea.setAutoCreateRowSorter(true); // �÷� �����ϱ� ���  
        
        JTableHeader header = tableArea.getTableHeader(); // ��� ���� ����
        header.setBackground(new Color(0,32,96));
        header.setForeground(Color.white); 
        
        header.setFont(new Font("�������",Font.BOLD,15));
        tableArea.setFont(new Font("�������",Font.PLAIN,15)); //����� �� �� ��Ʈ�� ũ�⼳��
        
        header.setPreferredSize(new Dimension(100,30)); // �����������
        tableArea.setRowHeight(30); // ����������
        
        tableArea.getColumnModel().getColumn(0).setPreferredWidth(100); // ���ʺ�����
        tableArea.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableArea.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableArea.getColumnModel().getColumn(3).setPreferredWidth(50);
        tableArea.getColumnModel().getColumn(4).setPreferredWidth(50); 
        
       
        
        DefaultTableCellRenderer CR = new DefaultTableCellRenderer(); // �� ��� ����
        CR.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel CM = tableArea.getColumnModel();
        for(int i =0; i<CM.getColumnCount(); i++) {
        	CM.getColumn(i).setCellRenderer(CR);
        }
        
        Table.add(scrollArea);
        add(Table);
    	
        /////////////////////////////////////////////////////////////////�������������
		String folder="./Subject_Dir/ToDolist_Dir/"; //���� ������ ����
		String file_name; // ���� �����̸�
		File file=new File(folder);
		
		if(!file.isDirectory()) {
			System.out.println("�ش���丮�� �����ϴ�");
			System.exit(1);
		}
		
		File []list=file.listFiles();
		
		for(File f:list) {
			
			if(f.isFile() && !f.getName().equals("Trashcan.xlsx")) { // �������� ����
				
				file_name=f.getName();
			
				System.out.println(folder + file_name);
		        try {

					FileInputStream inputStream = new FileInputStream(folder + file_name);

					XSSFWorkbook wb = new XSSFWorkbook(inputStream);
					

					//sheet�� ���

					int sheetCn = wb.getNumberOfSheets();

					

					

					for(int cn = 0; cn < sheetCn; cn++){


						//0��° sheet ���� ���

						XSSFSheet sheet = wb.getSheetAt(cn);

						

						//���� sheet���� rows�� ���

						int rows = sheet.getPhysicalNumberOfRows();

						

						//���� row���� ����� cell�� ���

						int cells = sheet.getRow(cn).getPhysicalNumberOfCells(); 
					
						

						for (int r = 1; r < rows; r++) { // ������ �ι�°�ٺ��� �ҷ���

							row = sheet.getRow(r); // row ��������

							if (row != null) {

								for (int c = 0; c < cells; c++) {

									cell = row.getCell(c);

									if (cell != null) {

										String value = null;

										switch (cell.getCellType()) {

										case XSSFCell.CELL_TYPE_FORMULA:

											value = cell.getCellFormula();

											break;

										case XSSFCell.CELL_TYPE_NUMERIC:
											if(!HSSFDateUtil.isCellDateFormatted(cell)) {
												SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
												value = "" + formatter.format(cell.getDateCellValue());
												
											}else {
												DecimalFormat df = new DecimalFormat();
												value = "" + df.format(cell.getNumericCellValue());
												
											}
											break;

										case XSSFCell.CELL_TYPE_STRING:

											value = "" + cell.getStringCellValue();

											break;

										case XSSFCell.CELL_TYPE_BLANK:

											value = "[null �ƴ� ����]";

											break;

										case XSSFCell.CELL_TYPE_ERROR:

											value = "" + cell.getErrorCellValue();

											break;

										default:

										}

										System.out.print(value + "\t");
										VALUE = value;

									} else {

										System.out.print("[null]\t");
										VALUE = null;
									}
									
									switch(c) {
									
									case 0 : Sub=VALUE;
									break;
									case 1 : Todo=VALUE;
									break;
									case 2 : Dead_day=VALUE;
									break;
									case 3 : Actual_day=VALUE;
									break;
									case 4 : Done = VALUE;
									model.addRow(new Object[] {Sub,Todo,Dead_day,Actual_day,Done});
									
									break;
									}

								} // for(c) ��

								
								System.out.print("\n");

							}

						} // for(r) ��

					}

				} catch (Exception e) {

					e.printStackTrace();

				}
			} // if(�����ϰ��)
		} // for(f)

		setVisible(false);	
    

        this.addWindowListener(new WindowAdapter(){ //����â�� xǥ�ô����� ���������� �̵�
            public void windowClosing(WindowEvent e) { 
            	Back test = new Back();
            	test.back();
            	
            }
        });
    }
}

