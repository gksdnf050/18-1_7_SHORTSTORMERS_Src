package se.smu;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Add_Change_Panel extends JPanel{
	private JLabel Title_Label;
	
	private JButton Reg_Button;
	private JButton Cancel_Button;
	private JLabel Sub_Label;
	private JLabel Prof_Label;
	
	private JLabel Day_Label;
	private JLabel Time_Label;
	private JLabel Year_Label;
	private JLabel Sem_Label;
	
	private JTextField Sub_Text;
	private JTextField Prof_Text;
	private JTextField Time_Text;
	private JComboBox<String> Day_Combo;
	private JComboBox<String> Year_Combo;
	private JComboBox<String> Sem_Combo;
	
	public ToDoList_Main win;
	
	private Font TitleFont = new Font("HY�߰���",Font.BOLD, 30);
	private Font ButtonFont = new Font("���� ����",Font.BOLD, 20);
	private Font SubFont = new Font("���� ����",Font.BOLD, 15);
	
	private Color MainColor = new Color(0, 32, 96);
	
	private int RowNum;
	public String[] Reg_Info={"", "", "", "", "", ""};
	
	private String PreName = null;
	public String PanelName;
	public void showPanel(ToDoList_Main win) {
		this.win=win;
		setLayout(null);
		
		Sub_Label = new JLabel("���� �� : ");
		Sub_Label.setBounds(100,200,100,40);
		Sub_Label.setFont(SubFont);
		add(Sub_Label);
		
		Sub_Text = new JTextField(20);
		Sub_Text.setBounds(180,200,350,50);
		Sub_Text.setFont(SubFont);
		Sub_Text.setText("");
		/*Sub_Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField sub = (JTextField)e.getSource();
				Reg_Info[0]=sub.getText();
			}
		});*/
		add(Sub_Text);
		
		Prof_Label = new JLabel("��� ���� : ");
		Prof_Label.setBounds(100,260,100,40);
		Prof_Label.setFont(SubFont);
		add(Prof_Label);
		
		Prof_Text = new JTextField(20);
		Prof_Text.setBounds(180,260,350,50);
		Prof_Text.setFont(SubFont);
		Prof_Text.setText("");
		/*Prof_Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField sub = (JTextField)e.getSource();
				Reg_Info[1]=sub.getText();
			}
		});*/
		add(Prof_Text);
		
		Day_Label = new JLabel("���� : ");
		Day_Label.setBounds(100,360,100,40);
		Day_Label.setFont(SubFont);
		add(Day_Label);
		
		String[] Days = {"��","ȭ","��","��","��","��","��"}; 
		Day_Combo = new JComboBox<String>(Days);
		/*Day_Combo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JComboBox<String> cb = (JComboBox) e.getSource();
		        Reg_Info[2] = cb.getSelectedItem().toString();
		    }
		});*/
		Day_Combo.setBounds(180,360,140,50);
		Day_Combo.setFont(SubFont);
		add(Day_Combo);
		
		Time_Label = new JLabel("�ð� : ");
		Time_Label.setBounds(350,360,100,50);
		Time_Label.setFont(SubFont);
		add(Time_Label);
		
		Time_Text = new JTextField(20);
		Time_Text.setBounds(400,360,140,50);
		Time_Text.setFont(SubFont);
		Time_Text.setText("");
		/*Time_Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField sub = (JTextField)e.getSource();
				Reg_Info[3]=sub.getText();
			}
		});*/
		add(Time_Text);
		
		Year_Label = new JLabel("���� �⵵ : ");
		Year_Label.setBounds(100,460,100,40);
		Year_Label.setFont(SubFont);
		add(Year_Label);
		
		String[] Years = new String[10];
		Integer temp = 2017;
		for(int i=0; i<10;i++) {
			Years[i]=String.valueOf(temp);
			temp++;
		}
		Year_Combo = new JComboBox<String>(Years);
		/*Year_Combo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JComboBox<String> cb = (JComboBox) e.getSource();
		        Reg_Info[4] = cb.getSelectedItem().toString();
		    }
		});*/
		Year_Combo.setBounds(180,460,140,50);
		Year_Combo.setFont(SubFont);
		add(Year_Combo);
		
		
		Sem_Label = new JLabel("�б� : ");
		Sem_Label.setBounds(350,460,100,40);
		Sem_Label.setFont(SubFont);
		add(Sem_Label);
		
		String[] Sems = {"1�б�","2�б�"}; 
		Sem_Combo = new JComboBox<String>(Sems);
		/*Sem_Combo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JComboBox<String> cb = (JComboBox) e.getSource();
		        Reg_Info[5] = cb.getSelectedItem().toString();
		    }
		});*/
		Sem_Combo.setBounds(400,460,140,50);
		Sem_Combo.setFont(SubFont);
		add(Sem_Combo);		

		//Ȯ�� ��ư
		Reg_Button = new JButton("Ȯ��");
		Reg_Button.setSize(150,50);
		Reg_Button.setLocation(180,600);
		Reg_Button.setFont(ButtonFont);
		Reg_Button.addActionListener(new OkActionListener(Sub_Text, Prof_Text, Time_Text, Day_Combo, Year_Combo, Sem_Combo));
		add(Reg_Button);
				
				
		//��� ��ư
		Cancel_Button = new JButton("���");
		Cancel_Button.setSize(150,50);
		Cancel_Button.setLocation(370,600);
		Cancel_Button.setFont(ButtonFont);
		Cancel_Button.addActionListener(new CancelActionListener());
		add(Cancel_Button);
		
		setBounds(0,0,650,750);
		
	}
	
	public Add_Change_Panel(ToDoList_Main win, String PanelName) {
		Title_Label = new JLabel("���� ���� ���");
		Title_Label.setFont(TitleFont);
		Title_Label.setForeground(MainColor);
		Title_Label.setBounds(240,40,400,60);
		add(Title_Label);
		
		showPanel(win);
		
		
	}
	
	public void setRowNum(int RowNum) {
		this.RowNum = RowNum;
	}
	
	public void setRegInfo (String[] S_Reg_Info) {
		this.Reg_Info = S_Reg_Info;
	}
	
	public void setPanelName (String PanelName) {
		this.PanelName = PanelName;
	}
	
	public void setPreName(String PreName) {
		this.PreName = PreName; 
	}
	
	public void ChangeTitle(String Title) {
		Title_Label.setText(Title);
	}
	
	public void ChangeMod(String[] Reg_info) {
		Sub_Text.setText(Reg_Info[0]);
		Prof_Text.setText(Reg_Info[1]);
		Day_Combo.setSelectedItem(Reg_Info[2]);
		Time_Text.setText(Reg_Info[3]);
		Year_Combo.setSelectedItem(Reg_Info[4]);
		Sem_Combo.setSelectedItem(Reg_Info[5]);
		
		Sub_Text.repaint();
		Prof_Text.repaint();
		Day_Combo.repaint();
		Time_Text.repaint();
		Year_Combo.repaint();
		Sem_Combo.repaint();
	}
	
	//��Ϲ�ư ActionListener
	class OkActionListener extends JFrame implements ActionListener{
		private JTextField Sub_Text;
		private JTextField Prof_Text;
		private JTextField Time_Text;
		private JComboBox<String> Day_Combo;
		private JComboBox<String> Year_Combo;
		private JComboBox<String> Sem_Combo;
		boolean addFlag;
		
		
		
		public OkActionListener(JTextField Sub_Text, JTextField Prof_Text, JTextField Time_Text, JComboBox<String> Day_Combo, JComboBox<String> Year_Combo, JComboBox<String> Sem_Combo){
			this.Sub_Text = Sub_Text;
			this.Prof_Text = Prof_Text;
			this.Time_Text = Time_Text;
			this.Day_Combo = Day_Combo;
			this.Year_Combo = Year_Combo;
			this.Sem_Combo = Sem_Combo;
		}
		
		public void actionPerformed(ActionEvent e) {
			Reg_Info[0] = Sub_Text.getText();
			Reg_Info[1] = Prof_Text.getText();
			Reg_Info[2] = Day_Combo.getSelectedItem().toString();
			Reg_Info[3] = Time_Text.getText();
			Reg_Info[4] = Year_Combo.getSelectedItem().toString();
			Reg_Info[5] = Sem_Combo.getSelectedItem().toString();
			
			
			//���� Ȯ��
			addFlag = Boolean.FALSE;
			for(int i = 0; i < 6; i++) {
				if(Reg_Info[i].equals("")) {
					JOptionPane.showMessageDialog(null , "��ĭ�� ��� �Է����ּ���.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
					
					break;
				}
				addFlag = Boolean.TRUE;
			}
			if(addFlag == Boolean.TRUE) {
				// ������ �߰�
				String FilePath = "./Subject_Dir/";			
				String FilePath2 = "./Subject_Dir/Todolist_Dir/";			
				
				// ToDoList ���� ����
				File destFile = new File(FilePath2 + Reg_Info[0] +".xlsx");
				File OriFile = new File(FilePath2 + PreName + ".xlsx");
				//���
				FileOutputStream outFile;
				try {
					if(PanelName == "Add_Panel") {
						destFile.createNewFile();	
					}
					else if(PanelName == "Change_Panel"){
						OriFile.renameTo(destFile);
					}
					
					
					FileInputStream inputStream = new FileInputStream(FilePath + "Subject_List.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
					Sheet sheet = workbook.getSheetAt(0);
					int rows=0;
					
					
					if(PanelName == "Add_Panel") {
						rows = sheet.getPhysicalNumberOfRows();
					}
					else if(PanelName == "Change_Panel")
						rows = RowNum+1;
					Row row = sheet.createRow(rows);
					row.createCell(0).setCellValue(Reg_Info[0]);
					row.createCell(1).setCellValue(Reg_Info[1]);
					row.createCell(2).setCellValue(Reg_Info[2]);
					row.createCell(3).setCellValue(Reg_Info[3]);
					row.createCell(4).setCellValue(Reg_Info[4]);
					row.createCell(5).setCellValue(Reg_Info[5]);
					
					outFile = new FileOutputStream(FilePath + "Subject_List.xlsx");
					workbook.write(outFile);	
					outFile.close();
					workbook.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				} 
				
				Sub_Text.setText("");
				Prof_Text.setText("");
				Time_Text.setText("");
				Day_Combo.setSelectedIndex(0);
				Year_Combo.setSelectedIndex(0);
				Sem_Combo.setSelectedIndex(0);
				
				
				win.change("Mainpage");
			}
		}
	}
	class CancelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			win.change("Mainpage");
		}
	}
	
	
}



class Mainpage extends JPanel{
	private ToDoList_Main win;
	
	private JLabel Id_Label;
	
	private JButton Add_Button = new JButton("���");
	private JButton Change_Button = new JButton("����");
	private JButton Delete_Button = new JButton("����");
	private JButton ShowAll_Button = new JButton("��ü To Do List ��ȸ");
	private JButton TrashCan_Button = new JButton();
	private JLabel Title_Label = new JLabel();
	private JScrollPane Subject_Scroll;
	
	private Font TitleFont = new Font("HY�߰���",Font.BOLD, 30);
	private Font ButtonFont = new Font("���� ����",Font.BOLD, 20);
	private Font SubFont = new Font("���� ����",Font.BOLD, 15);
	
	private Color MainColor = new Color(0, 32, 96);
	
	private ImageIcon TrashCan_Icon = new ImageIcon("./TrashCan.png");
	
	//�߰� JTable�� ����
	private JTable Subject_Table;
	private final String [] col = {"V", "����", "����", "����", "�ð�", "�����⵵", "�б�"};
	private Object [][] datas;
	
	//���� �б� ����
	private Row row;
	private Cell cell;
	String FilePath = "./Subject_Dir/";
	Object ReadData[] = new Object[7];
	
	
	
	
	DefaultTableModel model;
	
	
	@SuppressWarnings("serial")
	public Mainpage(ToDoList_Main win) {
		this.win=win;
		setLayout(null);
		
		model = new DefaultTableModel(datas, col);
		//���̺�
		Subject_Table = new JTable(model) {
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
					case 0:
						return Boolean.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					case 5:
						return String.class;
					case 6:
						return String.class;
					default:
						return Boolean.class;
				}
			}
		};
		
		//��� ��Ʈ
		JTableHeader header = Subject_Table.getTableHeader();
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)header.getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		header.setDefaultRenderer(renderer);
		
		header.setBackground(MainColor);
		header.setForeground(Color.WHITE);
		header.setFont(SubFont);
		
		//�÷� ũ��, �̵����� �Ұ�
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);
		
		Subject_Table.addMouseListener(new SelectSubjectMouseListener());
		
		
		//ID
		Id_Label = new JLabel();
		Id_Label.setFont(SubFont);
		Id_Label.setBounds(25,100,150,40);
		add(Id_Label);
		
		// ����
		Title_Label = new JLabel("���� ���� LIST");
		Title_Label.setFont(TitleFont);
		Title_Label.setForeground(MainColor);
		Title_Label.setBounds(240,40,400,60);
		add(Title_Label);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		
		
		// ��ư
		Add_Button.addActionListener(new RegActionListener());
		Change_Button.addActionListener(new ChangeActionListener());	 
		Delete_Button.addActionListener(new DeleteActionListener());
		
		Add_Button.setFont(ButtonFont);
		Change_Button.setFont(ButtonFont);
		Delete_Button.setFont(ButtonFont);
		ShowAll_Button.setFont(ButtonFont);
		
		
		p1.add(Add_Button);
		p1.add(Change_Button);
		p1.add(Delete_Button);
		p1.setBounds(350,100,270,50);
		add(p1);
		
		

		
		
		//��ũ�� �߰� 
		Subject_Scroll = new JScrollPane(Subject_Table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Subject_Scroll.setBounds(25,150,600,400);
		Subject_Scroll.getVerticalScrollBar().setVisible(true);
		Subject_Scroll.getVerticalScrollBar().setBackground(MainColor);
		Subject_Scroll.getHorizontalScrollBar().setVisible(true);
		Subject_Scroll.getHorizontalScrollBar().setBackground(MainColor);
		
		add(Subject_Scroll);
		
		
		
		ShowAll_Button.setBounds(25, 600, 220, 50);
		ShowAll_Button.addActionListener(new ShowAllActionListener());
		
		TrashCan_Button.setBounds(500, 570, 100, 100);
		Image originalImage = TrashCan_Icon.getImage();
		Image changedImage = originalImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon finIcon = new ImageIcon(changedImage);
		TrashCan_Button.setIcon(finIcon);		
		TrashCan_Button.addActionListener(new TrashcanActionListener());
		
		
		add(ShowAll_Button);
		add(TrashCan_Button);
		
		
		
	}
	/*
  	int Get_HowMany_Check() {
  		
  	}
  	
  	void Add_Check() {
  		
  	}
  	
  	void Minus_Check() {
  		
  	}
  	
  	public void SubjectList() {
  	
  	}
  	*/
	
	
	public void RefreshSubjectTable() {
		// �����κ��� ���� �б�
		try {
			DefaultTableModel model = new DefaultTableModel(datas, col) {;
				@Override
				public boolean isCellEditable(int row, int column) {
					if(column == 0) {
						return true;
					}
					return false;
				}
			};
			Subject_Table.setModel(model);
			
			FileInputStream inputStream = new FileInputStream(FilePath + "Subject_List.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int cells = sheet.getRow(0).getPhysicalNumberOfCells();					//row for
			for(int i=1 ; i<rows; i++) {
				row=sheet.getRow(i);
				if(row != null) {
					// cell for
					ReadData[0]=Boolean.FALSE;  // üũ�ڽ�
					for(int j=0;j<cells;j++) {
						cell = row.getCell(j);
						if(cell !=null) {
							String value = null;
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_FORMULA:
								value = cell.getCellFormula();
								break;
							case Cell.CELL_TYPE_NUMERIC:
								value = "" + cell.getNumericCellValue();
								break;
							case Cell.CELL_TYPE_STRING:
								value = "" + cell.getStringCellValue();
								break;
							case Cell.CELL_TYPE_BLANK:
								value = "";
								break;
							case Cell.CELL_TYPE_ERROR:
								value = "" + cell.getErrorCellValue();
								break;
							default:
							}
					ReadData[j+1]= value;		
					}
				}
			}
			model.addRow(ReadData);
				
		}
		//��Ʈ�� �÷� �Ӽ�
		DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
		dtcr2.setHorizontalAlignment(SwingConstants.CENTER);
		dtcr2.setFont(SubFont);
		Subject_Table.getColumn("V").setPreferredWidth(40);
		Subject_Table.getColumn("����").setCellRenderer(dtcr2);
		Subject_Table.getColumn("����").setPreferredWidth(150);
		Subject_Table.getColumn("����").setCellRenderer(dtcr2);
		Subject_Table.getColumn("����").setCellRenderer(dtcr2);
		Subject_Table.getColumn("�ð�").setCellRenderer(dtcr2);
		Subject_Table.getColumn("�����⵵").setCellRenderer(dtcr2);
		Subject_Table.getColumn("�б�").setCellRenderer(dtcr2);
		Subject_Table.setRowHeight(50);
		Subject_Table.setFont(SubFont);
		
		
		// ���̺� ����
		Subject_Table.setBackground(Color.WHITE);
		Subject_Table.setAutoCreateRowSorter(true);
		TableRowSorter tablesorter = new TableRowSorter(Subject_Table.getModel());
		Subject_Table.setRowSorter(tablesorter);
		// ���̺� ���ΰ�ħ
		Subject_Table.revalidate();
		Subject_Table.repaint();
		
		} catch (Exception e) {			
			e.printStackTrace();		
		}					
	}
	// ���� �� �۾��� ����
	// �����ߴٸ� Subject_Table�� ���� ���·� Subject_List.xlsx ����
	void RefreshSubjectExel() {
		if(Subject_Table.getRowCount() > 1) {
			String FilePath = "./Subject_Dir/";			
			File destFile = new File(FilePath +"Subject_List.xlsx");
			//���
			FileOutputStream outFile;
			try {
				FileInputStream inputStream = new FileInputStream(destFile);
				XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
				Sheet sheet = workbook.getSheetAt(0);
				int rows = 1;
				Row row;
				for(int i = 0; i < Subject_Table.getRowCount(); i++) {
					row  = sheet.getRow(rows);
					row.getCell(0).setCellValue(Subject_Table.getValueAt(i, 1).toString());
					row.getCell(1).setCellValue(Subject_Table.getValueAt(i, 2).toString());
					row.getCell(2).setCellValue(Subject_Table.getValueAt(i, 3).toString());
					row.getCell(3).setCellValue(Subject_Table.getValueAt(i, 4).toString());
					row.getCell(4).setCellValue(Subject_Table.getValueAt(i, 5).toString());
					row.getCell(5).setCellValue(Subject_Table.getValueAt(i, 6).toString());
					rows++;
				}
				
				outFile = new FileOutputStream(FilePath + "Subject_List.xlsx");
				workbook.write(outFile);	
				outFile.close();
				workbook.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			} 
		}
	}
		
	void setID(String Id) {
		Id_Label.setText("ID : " + Id);
		Id_Label.repaint();
	}
	
	void RemoveFile(String FilePath, String FileName) {
		File destFile = new File(FilePath + FileName + ".xlsx");
		destFile.delete();
	}
	
	// ���, ����, ���� , ������ ��ư ActionListener
	class RegActionListener extends JFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			RefreshSubjectExel();
			
			int SelectedRowNum = Subject_Table.getRowCount();
			String [] S_Reg_Info = {"","","��", "", "2018", "1�б�"};
			win.change("Add_Panel", SelectedRowNum, S_Reg_Info);
		}
	}
	
	class ChangeActionListener extends JFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int SelectedNum = 0;
			int SelectedRowNum = 0;
			boolean Select_Flag = Boolean.FALSE;
			for(int i=0; i < Subject_Table.getRowCount() ; i++) {
				if(Subject_Table.getValueAt(i, 0) == Boolean.TRUE) {
					SelectedNum++;
					SelectedRowNum = i;
				}
			}
			if(SelectedNum == 0 || SelectedNum > 1) {
				JOptionPane.showMessageDialog(null , "�ϳ��� ������ �������ּ���." , "�˸�", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				Select_Flag = Boolean.TRUE;
			}
			
			if(Select_Flag == Boolean.TRUE) {
				RefreshSubjectExel();
				
				
				String[] S_Reg_Info = new String[6];
				for(int i = 0; i < 6; i++) {
					S_Reg_Info[i] = Subject_Table.getValueAt(SelectedRowNum, i+1).toString();
				}
				System.out.println("���� ������ ��ȯ");
				win.change("Change_Panel", SelectedRowNum, S_Reg_Info);
			}
		}
	}
	class DeleteActionListener extends JFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			RefreshSubjectExel();

			int SelectedNum = 0;
			Vector<Integer> SelectedRowNum = new Vector<Integer>();
			boolean Select_Flag = Boolean.FALSE;
			for(int i=0; i < Subject_Table.getRowCount() ; i++) {
				if(Subject_Table.getValueAt(i, 0) == Boolean.TRUE) {
					SelectedNum++;
					SelectedRowNum.add(Integer.valueOf(i));
					System.out.println((i+1) + "��° row ���� ");
				}
			}
			
			if(SelectedNum == 0) {
				JOptionPane.showMessageDialog(null , "�ϳ� �̻��� ������ �������ּ���.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				Select_Flag = Boolean.TRUE;
			}
			
			if(Select_Flag == Boolean.TRUE) {
				
				// ��������
				String FilePath = "./Subject_Dir/";			
				String FilePath2 = "./Subject_Dir/Todolist_Dir/";			
				
				//���
				FileOutputStream outFile;
				try {
					FileInputStream inputStream = new FileInputStream(FilePath + "Subject_List.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
					Sheet sheet = workbook.getSheetAt(0);
					int rows=0;
					Iterator <Integer> it = SelectedRowNum.iterator();
					Row row; 
					Row NextRow = sheet.getRow(0);
					Cell NextCell = NextRow.getCell(0);
					NextCell = NextRow.getCell(0);
					
					while(it.hasNext()) {
						rows = it.next().intValue()+1;
						row = sheet.getRow(rows);
						
						//To Do List ���� ���� 
						RemoveFile(FilePath2, sheet.getRow(rows).getCell(0).getStringCellValue());
						
						//������ ������ Row �ʱ�ȭ (Subject_List.xlsx)
						row.getCell(0).setCellValue("");
						row.getCell(1).setCellValue("");
						row.getCell(2).setCellValue("");
						row.getCell(3).setCellValue("");
						row.getCell(4).setCellValue("");
						row.getCell(5).setCellValue("");
						System.out.println("temp");
					}
					
					
					
					int	NextRowNum=0;
					// Subject_List.xlsx ����
					// ���� ���� ��ȸ
					System.out.println("���� ���� ����");
					
					for(int searchRow = 1; searchRow < sheet.getPhysicalNumberOfRows();searchRow++) {
						row = sheet.getRow(searchRow);
						cell = row.getCell(0);
						// Row�� ù��° Cell�� �����̸� ���� ������ �ƴ� Row ã��
						if (cell.getStringCellValue() == ""){
							for(NextRowNum = searchRow; NextRowNum < sheet.getPhysicalNumberOfRows(); NextRowNum++) {
								// ������ ��� ���� ������ �ƴ� �� ã��
								NextRow = sheet.getRow(NextRowNum);
								NextCell = NextRow.getCell(0);
								if(NextCell.getStringCellValue() != "") {
									// ���� ������ �ƴ� ���� �����̿��� ���� �̵�
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
					// ���� ���� ���̱�
					for(int i=0; i < SelectedRowNum.size() ; i++) {
						System.out.println("Subject_List.xlsx || " + sheet.getLastRowNum() + "��° row ����");
						row = sheet.getRow(sheet.getLastRowNum());
						sheet.removeRow(row);
					}
					
						
					outFile = new FileOutputStream(FilePath + "Subject_List.xlsx");
					workbook.write(outFile);	
					outFile.close();
					workbook.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				} 
				
				System.out.println("���� ����");
				RefreshSubjectTable();
			}
		}
	}
	
	class TrashcanActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Trashcan TC = new Trashcan();
		}
	}
	
	class ShowAllActionListener extends JFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			win.change("ShowAll_Todo");
		}
	}
	
	// ���� ����Ŭ���� ToDoList ������ ��ȯ ���콺������
	private class SelectSubjectMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			JTable t = (JTable)e.getSource();
			if(e.getClickCount() == 2) {
				TableModel m = t.getModel();
				Point pt = e.getPoint();
				int r = t.rowAtPoint(pt);
				int c = t.columnAtPoint(pt);
				
				if(r >= 0 && c >0) {
					int row = t.convertColumnIndexToModel(r);
					System.out.println(row);
				}
			}
		}
	}
	
}



public class ToDoList_Main extends JFrame{
	public Add_Change_Panel AP = null;
	public Add_Change_Panel CP = null;
	public Mainpage MP = null;
	public Login Log = null;
	public Trashcan TC = null;
	public ShowAll_Todo SA = null;
	
	public void change(String panelName)	{
		// ���� ������ ��ȯ
		if(panelName.equals("Mainpage")) {
			getContentPane().removeAll();
			getContentPane().add(MP);
			MP.setID(Log.getID());
			MP.RefreshSubjectTable();
			revalidate();
			repaint();
		}
		else if(panelName.equals("ShowAll_Todo")) {
			this.setVisible(false);
			this.SA = new ShowAll_Todo(this);
			SA.setVisible(true);
		}
		
	}
	// ���� ������ ��ȯ
	public void change(String panelName, int SelectedRowNum, String[] Reg_Info) {
		//���õ� ������ �ټ� ����
		//�߰� ȭ�� ��ȯ
		if(panelName.equals("Add_Panel")) {	
			AP.setPanelName("Add_Panel");
			AP.setRegInfo(Reg_Info);
			AP.ChangeMod(Reg_Info);
			AP.repaint();
			getContentPane().removeAll();
			getContentPane().add(AP);
			revalidate();
			repaint();
		}
		// ���� ������ ��ȯ
		else if(panelName.equals("Change_Panel")) {			
			AP.setRowNum(SelectedRowNum);
		
			AP.setRegInfo(Reg_Info);
			AP.setPanelName("Change_Panel");
			AP.setPreName(Reg_Info[0]);
			AP.ChangeMod(Reg_Info);
			AP.ChangeTitle("���� ���� ����");
			AP.repaint();
			getContentPane().removeAll();
			getContentPane().add(AP);
			revalidate();
			repaint();
		}
	}
	
	
	public static void main(String [] args) {
		// ������ ��ο� ������ ����
		String FilePath = "./Subject_Dir/";
		String FilePath2 = "./Subject_Dir/ToDolist_Dir/";
		File destdir = new File(FilePath);
		File destdir2 = new File(FilePath2);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet;
		if(!destdir.exists() || !destdir2.exists()) {
			destdir.mkdirs();
			destdir2.mkdirs();
		}
		File destFile = new File(FilePath + "Subject_List.xlsx");
		File destFile2 = new File(FilePath2 + "Trashcan.xlsx");
		try {
			if(!destFile.exists() || !destFile2.exists()) {
				destFile.createNewFile();
				destFile2.createNewFile();
				sheet=workbook.createSheet();
				Row row = sheet.createRow(0);
				row.createCell(0).setCellValue("����");
				row.createCell(1).setCellValue("����");
				row.createCell(2).setCellValue("����");
				row.createCell(3).setCellValue("�ð�");
				row.createCell(4).setCellValue("�����⵵");
				row.createCell(5).setCellValue("�б�");
				
				FileOutputStream outFile;
				try {
					outFile = new FileOutputStream(FilePath + "Subject_List.xlsx");
					workbook.write(outFile);
					outFile.close();
					workbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch(IOException ex){
			ex.getMessage();
		}
		
		// GUI ����
		ToDoList_Main test = new ToDoList_Main();
		
		test.setTitle("To Do List Program");
		test.Log = new Login(test);
		test.AP = new Add_Change_Panel(test, "Add_Panel");
		test.MP = new Mainpage(test);
		
		test.add(test.Log);
		//test.MP.RefreshSubjectTable();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    test.setSize(650, 750);
	    test.setVisible(true);
	    test.setResizable(false);
	}
}
