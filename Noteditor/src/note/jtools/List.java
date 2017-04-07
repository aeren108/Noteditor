/** @author Ahmet */
package note.jtools;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class List extends JList{
	
	static DefaultListModel model = new DefaultListModel<>();
	TextArea ta;
	String line;
	
	private static final long serialVersionUID = 1L;

	public List(){
		super(model);
		
		setLocation(new Point(30, 30));
		setSize(new Dimension(235, 510));
		
		setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		setVisibleRowCount(5);
		setSelectedIndex(0);
		
		repaint();
		
	}
	
	public void addElement(String element){
		if (element == "")
			return;
		else if (element == "File name")
			return;
		else
			model.addElement(element);
	}
	
	public void deleteElement(){
		try {
			model.remove(getSelectedIndex());
		}catch(Exception e){
			System.err.println("Element not found");
		}
	}
	
	public String getIndex(){
		return getSelectedValue().toString();
	}
	
	public void refreshList(TextArea area, String text){
		ta = area;
		line = text;
		if (!isSelectionEmpty()){
			ta.setText(line);
		}
		else
			refreshList(ta, line);
	}
}
