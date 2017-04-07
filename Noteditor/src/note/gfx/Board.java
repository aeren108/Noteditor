/** @author Ahmet */
package note.gfx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel{

	private static final long serialVersionUID = 1L;

	public Board(){
        setSize(new Dimension(800, 600));
        setLayout(null);

    }

    @Override
    public void paint(Graphics g) {
    	super.paint(g);
    	
    	//Draw
    	
    	g.setColor(Color.LIGHT_GRAY);
    	g.fillRect(0, 0, 800, 600);
    	
    	g.setColor(Color.ORANGE);
    	g.fillRect(20, 20, 255, 530);
    	
    	g.setColor(Color.PINK);
    	g.fillRect(440, 20, 320, 530);
    	
    	g.clearRect(450, 60, 300, 480);
    	g.clearRect(30, 30, 235, 510);
    	g.clearRect(450, 30, 300, 28);
    	g.clearRect(300, 300, 90, 50);
    	
    	
    	//End
    	
    	g.dispose();
    	

    	
    }
}
