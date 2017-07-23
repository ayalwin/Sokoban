package Boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import controller.SokobanController;
import model.MyModel;
import view.SokoCLI;


public class Run {
	

	public static void main(String[] args) throws Exception {
		
		MyModel model=new MyModel();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		SokoCLI view =new SokoCLI(reader, writer, "Exit");
		SokobanController controller=new SokobanController(model, view);
		model.addObserver(controller);
		view.addObserver(controller);
		view.start();
				
	
		
		
		
		
		
	}
}

