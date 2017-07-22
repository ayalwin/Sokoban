package model.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import model.data.levels.Level;

public class Client {
	private String solution= null;
	
	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public void start(String ip, int port, Level level) {
		try {			
			Socket socket = new Socket(ip, port);
			System.out.println("connected to server");

			BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
			
			outToServer.writeObject(level);
			this.solution = serverInput.readLine();
			
			System.out.println("Solution received from server: " + solution);

			serverInput.close();
			outToServer.close();
			socket.close();
		} 
		catch (UnknownHostException e) {/*...*/}
		catch (IOException e) {
		
		}
	}
}