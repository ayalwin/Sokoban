package controller.Commands;

import java.io.IOException;
import java.util.LinkedList;

import model.model;
import view.view;

public class  SaveCommand extends SokoModelCommand {
	
	
	
	public SaveCommand(model model,view view) {
		super(model,view);
	}
	

	private String filepath;
	
	
	
	
	

	@Override
	public void execute() throws IOException {
		model.saveLevel(filepath);

	}


	@Override
	public void setParams(LinkedList<String>params) {
		this.params=params;
		this.filepath=params.get(0);
	
		
	}

}
