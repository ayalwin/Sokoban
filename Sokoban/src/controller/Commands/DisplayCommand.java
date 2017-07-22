package controller.Commands;

import java.util.LinkedList;

import model.model;
import view.view;

public class DisplayCommand extends SokoModelCommand {
	
	public  DisplayCommand(model model,view view) {
		super(model, view);
		
	}

	@Override
	public void execute() {
		
		view.display(model.getCurrentLevel());

	}

	@Override
	public void setParams(LinkedList<String> params) {
		this.params=params;
		
	}

}
