package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import controller.Commands.DisplayCommand;
import controller.Commands.ExitCommand;
import controller.Commands.HintCommand;
import controller.Commands.LoadCommand;
import controller.Commands.MoveCommand;
import controller.Commands.SaveCommand;
import controller.Commands.SokoModelCommand;
import controller.Commands.SolveCommand;
import model.model;
import view.view;

public class SokobanController implements Observer {

	private model model;
	private view view;
	private controller controller;
	private Map<String, SokoModelCommand> commands;
	
	public SokobanController(model model,view view) {
		this.model=model;
		this.view=view;
		initCommands();
		controller=new controller();
		controller.start();
	}
	
	public void initCommands()
	{
		commands=new HashMap<String,SokoModelCommand>();
		commands.put("Move", new MoveCommand(model,view));
		commands.put("Save", new SaveCommand(model,view));
		commands.put("Load",new LoadCommand(model,view));
		commands.put("Display", new DisplayCommand(model,view));
		commands.put("Exit", new ExitCommand(model,view));
		commands.put("Solve", new SolveCommand(model, view));
		commands.put("Hint", new HintCommand(model, view));
		
		
		
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		LinkedList<String> params =(LinkedList<String>) arg;
		String commandkey=params.removeFirst();
		if(commandkey=="Exit")
		{
			System.out.println("stopping controller");
			controller.stop();
		}
		SokoModelCommand c=commands.get(commandkey);
		if(c==null)
		{
			view.displayMessage("Command not found");
			return;
		} 
		
		c.setParams(params);
		controller.insertCommand(c);

	}

}
