package controller.Commands;

import java.util.LinkedList;

import model.model;
import view.view;


public abstract class SokoModelCommand implements command {
	
	
	
	public SokoModelCommand(model model, view view) {
		this.model=model;
		this.view=view;
		
	}

	
	public abstract void setParams(LinkedList<String> params);
	protected model model;
	protected view view;
	protected LinkedList<String> params=new LinkedList<String>();
	
	
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		
	}
	


}
