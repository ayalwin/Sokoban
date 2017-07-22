package controller.Commands;

import java.util.LinkedList;

import model.model;
import view.view;

public class MoveCommand extends SokoModelCommand {
	
	
	
	public MoveCommand(model model,view view) {
		super(model,view);
	}
	
	private String direction;

	@Override
	public void execute() {
		model.move(direction);
	}
@Override
public void setParams(LinkedList<String> params) {
	this.params=params;
	this.direction=params.get(0);
}
}
