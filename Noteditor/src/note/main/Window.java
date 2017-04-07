/** @author Ahmet */
package note.main;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import note.files.Editor;
import note.gfx.Board;
import note.jtools.Button;
import note.jtools.Entry;
import note.jtools.List;
import note.jtools.TextArea;

public class Window extends JFrame{
	Board panel;

	Button add;
	Button del;
	Button read;
	Button paste;

	Entry name;
	TextArea text;
	List list;
	JScrollPane pane;

	Font font;
	Editor editor;
	File file;

	private static final long serialVersionUID = 1L;

	private String title;
	private int width, height;

	public Window(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;

		init();
		buttonEvents();
	}

	public void init(){
		setTitle(title);
		setSize(new Dimension(width, height));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new Board();

		font = new Font("Consolas", Font.PLAIN, 18);
		editor = new Editor();

		add = new Button("Add", font, 300, 300, 90, 50);
		del = new Button("Del", font, 300, 200, 100, 50);
		read = new Button("Read", font, 300, 100, 100, 50);
		paste = new Button("Paste", font, 300, 400, 100, 50); //Not working for now

		name = new Entry("File name", font, 450, 30);
		text = new TextArea(450, 60, 300, 480);
		list = new List();
		pane = new JScrollPane(list);

		file = new File("saves/");
		File[] filest = file.listFiles();
		String[] words = new String[filest.length];

									//
		for (int j = 0; j <filest.length; j++){
			words[j] = filest[j].getName().substring(0, filest[j].getName().length()-4);
			System.out.println(filest[j].getName());
			list.addElement(words[j]);
			System.out.println(filest[j].getName().substring(0, filest[j].getName().length()-4));
		}

		//Add

		panel.add(add);
		panel.add(del);
		panel.add(read);
		panel.add(paste);

		panel.add(name);
		panel.add(text);
		
		add(list);
		add(panel);

		setVisible(true);

	}

	public void buttonEvents(){
		//Add buttons' events
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				editor.createFile("saves/"+name.getText()+".txt");
				editor.writeFile("saves/"+name.getText()+".txt", text.getText());

				list.addElement(name.getText());
				list.revalidate();

				System.out.println(text.getText());
				name.setText("");
				text.setText("");

			}
		});

		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.deleteFile("saves/"+list.getIndex()+".txt");
				list.deleteElement();
				text.setText("");
				name.setText("");
			}
		});

		read.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(editor.readFile("saves/"+list.getIndex()+".txt"));
				text.setText(editor.readFile("saves/"+list.getIndex()+".txt"));
				text.setLineWrap(false);
				name.setText(list.getIndex());

			}
		});

		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText("İsim belirlenmedi");
			}
		});
	}

	public static void main(String[] args){
		new Window("Noteditor", 800, 600);
	}
}
