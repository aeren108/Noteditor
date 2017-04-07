/** @author Ahmet */
package note.jtools;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JTextArea;

public class TextArea extends JTextArea{
	Cursor cursor;
	Writer out;

	private static final long serialVersionUID = 1L;
	private String text;
	
	public TextArea(int x, int y, int width, int height){
		cursor = new Cursor(Cursor.TEXT_CURSOR);
		out = new PrintWriter(System.out);
		try {
			out.write("Anane");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(new Dimension(width, height));
		setLocation(new Point(x, y));
		setCursor(cursor);
		text = getText();
		
	}
	
	public String getLines(){
		return text;
	}
	
	public void writeLines(){
		setText("Bok");
		repaint();
	}
}
