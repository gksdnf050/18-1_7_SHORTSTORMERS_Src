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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/*
class Subject_Info {
	private String CheckBox;
	private String Subject_Name;
	private String Prof_Name;
	private String Day;
	private String Time;
	private String Year;
	
	public Subject_Info(String CheckBox, String Subject_Name, String Prof_Name, String Day, String Time, String Year) {
		super();
		this.CheckBox=CheckBox;
		this.Subject_Name=Subject_Name;
		this.Prof_Name=Prof_Name;
		this.Day=Day;
		this.Time=Time;
		this.Year=Year;
		
	}
	public Subject_Info() {
		
	}
	public void setCheckBox(String CheckBox) {
		this.CheckBox = CheckBox;
	}
	public void setSubject_Name(String Subject_Name) {
		this.Subject_Name = Subject_Name;
	}
	public void setProf_Name(String Prof_Name) {
		this.Prof_Name = Prof_Name;
	}
	public void setDay(String Day) {
		this.Day = Day;
	}
	public void setTime(String Time) {
		this.Time = Time;
	}
	public void setYear(String Year) {
		this.Year = Year;
	}

	
	public String getCheckBox() {
		return CheckBox;
	}
	public String getSubject_Name() {
		return Subject_Name;
	}
	public String getProf_Name() {
		return Prof_Name;
	}
	public String getDay() {
		return Day;
	}
	public String getTime() {
		return Time;
	}
	public String getYear() {
		return Year;
	}
}
*/

class Add_Panel extends JPanel{
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
	
	public ToDoList_test win;
	
	private Font TitleFont = new Font("HY견고딕",Font.BOLD, 30);
	private Font ButtonFont = new Font("맑은 고딕",Font.BOLD, 20);
	private Font SubFont = new Font("맑은 고딕",Font.BOLD, 15);
	
	private Color MainColor = new Color(0, 32, 96);
	
	
	public Add_Panel(ToDoList_test win) {
		this.win=win;
		setLayout(null);
		
		
		Title_Label = new JLabel("수강 과목 등록");
		Title_Label.setFont(TitleFont);
		Title_Label.setForeground(MainColor);
		Title_Label.setBounds(240,40,400,60);
		add(Title_Label);
		
		
		Sub_Label = new JLabel("과목 명 : ");
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
		
		Prof_Label = new JLabel("담당 교수 : ");
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
		
		Day_Label = new JLabel("요일 : ");
		Day_Label.setBounds(100,360,100,40);
		Day_Label.setFont(SubFont);
		add(Day_Label);
		
		String[] Days = {"월","화","수","목","금","토","일"}; 
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
		
		Time_Label = new JLabel("시간 : ");
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
		
		Year_Label = new JLabel("수강 년도 : ");
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
		
		
		Sem_Label = new JLabel("학기 : ");
		Sem_Label.setBounds(350,460,100,40);
		Sem_Label.setFont(SubFont);
		add(Sem_Label);
		
		String[] Sems = {"1학기","2학기"}; 
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

		//확인 버튼
				Reg_Button = new JButton("확인");
				Reg_Button.setSize(150,50);
				Reg_Button.setLocation(180,600);
				Reg_Button.setFont(ButtonFont);
				Reg_Button.addActionListener(new OkActionListener(Sub_Text, Prof_Text, Time_Text, Day_Combo, Year_Combo, Sem_Combo));
				add(Reg_Button);
				
				
				//취소 버튼
				Cancel_Button = new JButton("취소");
				Cancel_Button.setSize(150,50);
				Cancel_Button.setLocation(370,600);
				Cancel_Button.setFont(ButtonFont);
				Cancel_Button.addActionListener(new CancelActionListener());
				add(Cancel_Button);
		
		setBounds(0,0,650,750);
		
		
	}
	class OkActionListener extends JFrame implements ActionListener{
		private JTextField Sub_Text;
		private JTextField Prof_Text;
		private JTextField Time_Text;
		private JComboBox<String> Day_Combo;
		private JComboBox<String> Year_Combo;
		private JComboBox<String> Sem_Combo;
		boolean addFlag;
		private String[] Reg_Info={"", "", "", "", "", "" };
		
		
		
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
			
			
			//인자 확인
			addFlag = Boolean.FALSE;
			for(int i = 0; i<6; i++) {
				if(Reg_Info[i].equals("")) {
					JOptionPane.showMessageDialog(null , "빈칸을 모두 입력해주세요.");
					break;
				}
				addFlag = Boolean.TRUE;
			}
			if(addFlag == Boolean.TRUE) {
				// 엑셀에 추가
				String FilePath = "./Subject_Dir/";			
				
				//출력
				FileOutputStream outFile;
				try {
					FileInputStream inputStream = new FileInputStream(FilePath + "Subject_List.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
					Sheet sheet = workbook.getSheetAt(0);
					
					int rows = sheet.getPhysicalNumberOfRows();
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
				
				win.change("Main_Page");
			}
		}
	}
	class CancelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			win.change("Main_Page");
		}
	}
}




class Main_Page extends JPanel{
	private ToDoList_test win;
	
	private JLabel Id_Label;
	private JButton Add_Button = new JButton("등록");
	private JButton Change_Button = new JButton("수정");
	private JButton Delete_Button = new JButton("삭제");
	private JButton ShowAll_Button = new JButton("전체 To Do List 조회");
	private JButton TrashCan_Button = new JButton("Trashcan_image");
	private JLabel Title_Label = new JLabel();
	//private JTextArea Subject_TextArea = new JTextArea();
	private JScrollPane Subject_Scroll;
	private JCheckBox Subject_CheckBox;
	
	private Font TitleFont = new Font("HY견고딕",Font.BOLD, 30);
	private Font ButtonFont = new Font("맑은 고딕",Font.BOLD, 20);
	private Font SubFont = new Font("맑은 고딕",Font.BOLD, 15);
	
	private Color MainColor = new Color(0, 32, 96);
	
	
	
	//추가 JTable로 구현
	private JTable Subject_Table;
	private final String [] col = {"V", "과목", "교수", "요일", "시간", "수강년도", "학기"};
	private Object [][] datas;
	
	//엑셀 읽기 변수
	private Row row;
	private Cell cell;
	String FilePath = "./Subject_Dir/";
	Object ReadData[] = new Object[7];
	
	
	
	
	DefaultTableModel model;
	
	
	@SuppressWarnings("serial")
	public Main_Page(ToDoList_test win) {
		this.win=win;
		setLayout(null);
		
		model = new DefaultTableModel(datas, col);
		//테이블
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
		
		/*
		Subject_CheckBox = new JCheckBox();
		Subject_CheckBox.setHorizontalAlignment(JLabel.CENTER);
		*/
		
		
		
		//헤더 폰트
		JTableHeader header = Subject_Table.getTableHeader();
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)header.getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		header.setDefaultRenderer(renderer);
		
		header.setBackground(MainColor);
		header.setForeground(Color.WHITE);
		header.setFont(SubFont);
		//컬럼 크기, 이동변경 불가
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);
		
		//스트링 컬럼 속성
		DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();
		dtcr2.setHorizontalAlignment(SwingConstants.CENTER);
		dtcr2.setFont(SubFont);
		Subject_Table.getColumn("과목").setCellRenderer(dtcr2);
		Subject_Table.getColumn("교수").setCellRenderer(dtcr2);
		Subject_Table.getColumn("요일").setCellRenderer(dtcr2);
		Subject_Table.getColumn("시간").setCellRenderer(dtcr2);
		Subject_Table.getColumn("수강년도").setCellRenderer(dtcr2);
		Subject_Table.getColumn("학기").setCellRenderer(dtcr2);
				
		
		// 엑셀로부터 정보 읽기
		try {
			FileInputStream inputStream = new FileInputStream(FilePath + "Subject_List.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int cells = sheet.getRow(0).getPhysicalNumberOfCells();					//row for
				for(int i=1 ; i<rows; i++) {
				row=sheet.getRow(i);
				if(row != null) {
					// cell for
					ReadData[0]=Boolean.FALSE;  // 체크박스
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
							System.out.println(value);
							
						}
							
					}
				}
				model.addRow(ReadData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			


		//ID
		
		
		
		// 제목
		Title_Label = new JLabel("수강 과목 LIST");
		Title_Label.setFont(TitleFont);
		Title_Label.setForeground(MainColor);
		Title_Label.setBounds(240,40,400,60);
		add(Title_Label);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		
		
		// 버튼
		Add_Button.addActionListener(new RegActionListener());
			 
		Add_Button.setFont(ButtonFont);
		Change_Button.setFont(ButtonFont);
		Delete_Button.setFont(ButtonFont);
		ShowAll_Button.setFont(ButtonFont);
		
		
		p1.add(Add_Button);
		p1.add(Change_Button);
		p1.add(Delete_Button);
		p1.setBounds(350,100,270,50);
		add(p1);
		
		

		
		
		//스크롤 추가 
		Subject_Scroll = new JScrollPane(Subject_Table);
		Subject_Scroll.setBounds(25,150,600,400);
		add(Subject_Scroll);
		
		
		
		ShowAll_Button.setBounds(25, 600, 220, 50);
		TrashCan_Button.setBounds(480, 600, 150, 50);
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
		// 엑셀로부터 정보 읽기
		try {
			DefaultTableModel model = new DefaultTableModel(datas, col);
			this.Subject_Table.setModel(model);
			
			FileInputStream inputStream = new FileInputStream(FilePath + "Subject_List.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int cells = sheet.getRow(0).getPhysicalNumberOfCells();					//row for
				for(int i=1 ; i<rows; i++) {
				row=sheet.getRow(i);
				if(row != null) {
					// cell for
					ReadData[0]=Boolean.FALSE;  // 체크박스
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
							System.out.println(value);
							
						}
							
					}
				}
				model.addRow(ReadData);
				this.Subject_Table.repaint();
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}					
	}
	// 등록, 수정, 삭제 버튼 ActionListener
	class RegActionListener extends JFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 win.change("Add_Panel");
		}
	}
	
	class ChagneActionListener extends JFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 win.change("Add_Panel");
		}
	}
	class DeleteActionListener extends JFrame implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 
		}
	}

	
}



public class ToDoList_test extends JFrame{
	public Add_Panel AP = null;
	public Main_Page MP = null;
	public Add_Panel CP = null;	
	
	public void change(String panelName)	{
		if(panelName.equals("Add_Panel")) {			
			getContentPane().removeAll();
			getContentPane().add(AP);
			revalidate();
			repaint();
		}	
		else if(panelName.equals("Change_Panel")) {
			getContentPane().removeAll();
			getContentPane().add(CP);
			revalidate();
			repaint();
		}
		else if(panelName.equals("Main_Page")) {
			getContentPane().removeAll();
			getContentPane().add(MP);
			MP.RefreshSubjectTable();
			revalidate();
			repaint();
			
		}
		
	}
	
	
	
	public static void main(String [] args) {
		// 파일이 경로에 없으면 생성
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
		try {
			if(!destFile.exists()) {
				destFile.createNewFile();	
				sheet=workbook.createSheet();
				Row row = sheet.createRow(0);
				row.createCell(0).setCellValue("과목");
				row.createCell(1).setCellValue("교수");
				row.createCell(2).setCellValue("요일");
				row.createCell(3).setCellValue("시간");
				row.createCell(4).setCellValue("수강년도");
				row.createCell(5).setCellValue("학기");
				
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
		
		
		
		
		
		
		
		// GUI 시작
		ToDoList_test test = new ToDoList_test();
		
		test.setTitle("To Do List Program");
		test.AP = new Add_Panel(test);
		test.MP = new Main_Page(test);
		test.CP = new Add_Panel(test);
		
		test.add(test.MP);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    test.setSize(650, 750);
	    test.setVisible(true);
	}
}
