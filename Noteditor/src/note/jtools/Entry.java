/** @author Ahmet */
package note.jtools;

import java.awt.Font;

import javax.swing.JTextField;

public class Entry extends JTextField{
    
	private static final long serialVersionUID = 1L;
	private String text;

    public Entry(String text, Font font, int x, int y){
    	setText(text);
        setFont(font);
        setLocation(x, y);
        setSize(300, 28);

        text = getText();

    }

    public String getLine(){
        return text;
    }
}
