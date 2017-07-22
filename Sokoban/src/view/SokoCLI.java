package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Observable;

import model.data.levels.Level;

public class SokoCLI extends Observable implements view {
	private BufferedReader reader;
	private PrintWriter writer;
	private String existString;
	
	public SokoCLI(BufferedReader reader,PrintWriter writer,String exitSting) {
		this.reader=reader;
		this.writer=writer;
		this.existString=exitSting;
	}

	@Override
	public void display(Level level) {
		writer.println(level);
		writer.flush();
	}

	@Override
	public void displayMessage(String msg) {
		writer.println(msg);
		writer.flush();
	}

	@Override
	public void start() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String commandLine=" ";
				do{
					writer.print("Enter command: \n");
					writer.flush();
					
					try {
						commandLine=reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String[] arr=commandLine.split(" ");
					LinkedList<String> params = new LinkedList<String>();
					for (String param : arr) {
						params.add(param);
					}
					setChanged();
					notifyObservers(params);
					
					
				}while (!commandLine.equals(existString));
					
				
				
			}
		}).start();
			

	}
}

