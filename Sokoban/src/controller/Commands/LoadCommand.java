package controller.Commands;

import java.util.LinkedList;

import model.model;
import view.view;

public class LoadCommand extends SokoModelCommand {
	
	
	private String filepath;
	

	public LoadCommand(model model,view view) {
		super(model,view);
	}
	@Override
	public void execute() throws Exception {
		model.loadLevel(filepath);
	}


	@Override
	public void setParams(LinkedList<String> params) {
		this.params=params;
		this.filepath=params.get(0);
	}
}
