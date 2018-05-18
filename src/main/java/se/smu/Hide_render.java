package se.smu;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Hide_render extends DefaultTableCellRenderer { 

public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
{ 

	Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
  
	if (table.getValueAt(row, 4).toString().indexOf("¿Ï·á") !=-1)
	{ 
		cell.setForeground(Color.WHITE); 
		} 
	else { 
			cell.setForeground(Color.BLACK); 
		} 
	
return cell; 

} 
	}