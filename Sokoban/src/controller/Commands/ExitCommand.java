package controller.Commands;

import java.util.LinkedList;

import model.model;
import view.view;

public class ExitCommand extends SokoModelCommand {

	public ExitCommand (model model, view view) {
		super(model, view);
		
	}
	
	@Override
	public void execute() {
		
		model.exit();
	
	}

	@Override
	public void setParams(LinkedList<String> params) {
		this.params=params;
		
	}

}
