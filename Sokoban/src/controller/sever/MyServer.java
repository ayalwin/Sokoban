package controller.sever;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer {
	private int port;
	private ClientHandler ch;
	private volatile boolean stop;

	public MyServer(int port,ClientHandler ch) {
		this.port=port;
		this.ch=ch;
		stop=false;
	}

	private void runServer() throws Exception{

		ServerSocket server=new ServerSocket(port);
		server.setSoTimeout(1000);
		try{
			Socket aClient=server.accept();
			ch.handleClient(aClient.getInputStream(), aClient.getOutputStream());
			aClient.getInputStream().close();
			aClient.getOutputStream().close();
			aClient.close();
			server.close();
		}catch (SocketTimeoutException e){e.printStackTrace();}


	}
	
	public void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try{runServer();}catch(Exception e){e.printStackTrace();}
				
			}
		}).start();
			
	}
	
	public void stop(){stop=true;}
}




