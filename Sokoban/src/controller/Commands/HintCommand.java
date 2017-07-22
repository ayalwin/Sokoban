package controller.Commands;

import java.util.LinkedList;

public class HintCommand extends SokoModelCommand{

	public HintCommand(model.model model, view.view view) {
		super(model, view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setParams(LinkedList<String> params) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void execute() throws Exception {
		model.getHint();
	}

}
