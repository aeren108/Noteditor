/** @author Ahmet */
package note.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Editor {
	File file;
	File files;

	private String URL;
	private String lines;

	public Editor(){

	}

	public void createFile(String path){

		this.URL = path;
		files = new File(URL);

		if (!files.exists()){
			try {
				files.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteFile(String path){
		file = new File(path);
		file.delete();
	}

	public void writeFile(String path, String texts){
		try {
			file = new File(path);
			FileWriter write = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(write);

			writer.write(texts);
			writer.newLine();

			writer.close();
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String readFile(String path){
		File file;
		FileReader read;
		BufferedReader reader;
		StringBuilder builder;

		String texts;

		try {
			file = new File(path);
			read = new FileReader(file);
			reader = new BufferedReader(read);
			builder = new StringBuilder();

			texts = reader.readLine();

			while(texts != null){
				builder.append(texts + "\n");
				texts = reader.readLine();
			}

			read.close();
			reader.close();

			lines = builder.toString();

			return(lines);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return(lines);

	}

	public String getURL(){
		return URL;
	}

	public File getFile(){
		return files;
	}

	public boolean isFile(){
		if (files.exists())
			return false;
		else
			return true;
	}
}

