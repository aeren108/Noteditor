/** @author Ahmet */
package note.jtools;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{

	private static final long serialVersionUID = 1L;

	public Button(String text, Font font, int x, int y, int width, int height){
        setText(text);
        setFont(font);
        setSize(new Dimension(width, height));
        setLocation(new Point(x, y));
      
    }
	
	public Button(ImageIcon image, int x, int y, int width, int height){
        setIcon(image);
        setSize(new Dimension(width, height));
        setLocation(new Point(x, y));
    }
}
