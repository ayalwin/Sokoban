package controller.Commands;

import java.util.LinkedList;

public class SolveCommand extends SokoModelCommand {

	public SolveCommand(model.model model, view.view view) {
		super(model, view);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws Exception {
		model.solve();
	}

	@Override
	public void setParams(LinkedList<String> params) {
		// TODO Auto-generated method stub

	}

}
