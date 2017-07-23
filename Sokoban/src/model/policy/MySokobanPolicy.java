package model.policy;

import model.data.levels.Level;
import model.data.objects.Box;
import model.data.objects.Position;
import model.data.objects.Target;
import model.data.objects.Wall;
import model.data.objects.square;

/**
 * Implements the Sokoban game Policy
 * @author Ayal Weinberger
 *
 */
public class MySokobanPolicy implements Policy {
	Level level;
	square wall= new square(new Wall(), new Position());
	square box=new square(new Box(), new Position());
	square space=new square(new Position());
	Target target=new Target(new Position());
	
	square player;
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}



	Position Playerposition;
	int PlayerX;
	int PlayerY;
	
	
	
	
	public MySokobanPolicy(Level level) {
		this.level=level;
		this.player=level.getPlayer();
		this.Playerposition=player.getPosition();
		this.PlayerX=Playerposition.getX();
		this.PlayerY=Playerposition.getY();
		
		
	}
	//These function will check if the direction we want to move to is legal according to the policy described at the Instructions.
public boolean IsMoveAbleRight() {
	//can't move if there is a wall.
	if(level.getboard().get(PlayerY).get(PlayerX+1).getObject()==null)
		return true;
	if(level.getboard().get(PlayerY).get(PlayerX+1).getObject().getClass()==wall.getObject().getClass())
		return false;
	if(level.getboard().get(PlayerY).get(PlayerX+1).getObject()==null||level.getboard().get(PlayerY).get(PlayerX+2).getObject()==null)
		return true;
	//can't move if there is 2 boxes in a row.
	if(level.getboard().get(PlayerY).get(PlayerX+1).getObject()instanceof Box &&level.getboard().get(PlayerY).get(PlayerX+2).getObject().getClass()==box.getObject().getClass())
		return false;
	//can't move if there is a box an a wall in a row.
	if(level.getboard().get(PlayerY).get(PlayerX+1).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY).get(PlayerX+2).getObject().getClass()==wall.getObject().getClass())
		return false;
	else return true;
}
public boolean IsMoveAbleLeft() {
	//can't move if there is a wall.
	if(level.getboard().get(PlayerY).get(PlayerX-1).getObject()==null)
		return true;
	if(level.getboard().get(PlayerY).get(PlayerX-1).getObject().getClass()==wall.getObject().getClass())
		return false;
	if(level.getboard().get(PlayerY).get(PlayerX-1).getObject()==null||level.getboard().get(PlayerY).get(PlayerX-2).getObject()==null)
		return true;
	//can't move if there is 2 boxes in a row.
	if(level.getboard().get(PlayerY).get(PlayerX-1).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY).get(PlayerX-2).getObject().getClass()==box.getObject().getClass())
		return false;
	//can't move if there is a box an a wall in a row.
	if(level.getboard().get(PlayerY).get(PlayerX-1).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY).get(PlayerX-2).getObject().getClass()==wall.getObject().getClass())
		return false;
	else return true;
}
public boolean IsMoveAbleUp() {
	//can't move if there is a wall.
	if(level.getboard().get(PlayerY-1).get(PlayerX).getObject()==null)
		return true;
	if(level.getboard().get(PlayerY-1).get(PlayerX).getObject().getClass()==wall.getObject().getClass())
		return false;
	if(level.getboard().get(PlayerY-1).get(PlayerX).getObject()==null||level.getboard().get(PlayerY-2).get(PlayerX).getObject()==null)
		return true;
	//can't move if there is 2 boxes in a row.
	if(level.getboard().get(PlayerY-1).get(PlayerX).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY-2).get(PlayerX).getObject().getClass()==box.getObject().getClass())
		return false;
	//can't move if there is a box an a wall in a row.
	if(level.getboard().get(PlayerY-1).get(PlayerX).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY-2).get(PlayerX).getObject().getClass()==wall.getObject().getClass())
		return false;
	else return true;
	
}
public boolean IsMoveAbleDown() {
	//can't move if there is a wall.
	if(level.getboard().get(PlayerY+1).get(PlayerX).getObject()==null)
		return true;
	if(level.getboard().get(PlayerY+1).get(PlayerX).getObject().getClass()==wall.getObject().getClass())
		return false;
	if(level.getboard().get(PlayerY+1).get(PlayerX).getObject()==null||level.getboard().get(PlayerY+2).get(PlayerX).getObject()==null)
		return true;
	//can't move if there is 2 boxes in a row.
	if(level.getboard().get(PlayerY+1).get(PlayerX).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY+2).get(PlayerX).getObject().getClass()==box.getObject().getClass())
		return false;
	if(level.getboard().get(PlayerY+1).get(PlayerX).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY+2).get(PlayerX).getObject().getClass()==wall.getObject().getClass())
		return false;
	else return true;
	
}



public void moveUp()
{
	if (IsMoveAbleUp())
	{
		if(level.getboard().get(PlayerY-1).get(PlayerX).getObject()==null)
		{
			level.swap(level.getPlayer(), level.getboard().get(PlayerY-1).get(PlayerX));
			level.setMovesCount(level.getMovesCount()+1);
			level.findPlayer();
			player=level.getPlayer();
			Playerposition=player.getPosition();
			PlayerX=Playerposition.getX();
			PlayerY=Playerposition.getY();
			
		}
		
		else if(level.getboard().get(PlayerY-1).get(PlayerX).getObject()==null||level.getboard().get(PlayerY-1).get(PlayerX).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY-2).get(PlayerX).getClass()!=target.getClass())
		{
			if (level.getboard().get(PlayerY-1).get(PlayerX).getClass()==new Target().getClass())
			{
				level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);	
			}	
				level.swap(level.getboard().get(PlayerY-2).get(PlayerX), level.getboard().get(PlayerY-1).get(PlayerX));
				level.swap(level.getPlayer(), level.getboard().get(PlayerY-1).get(PlayerX));
				level.setMovesCount(level.getMovesCount()+1);
				level.findPlayer();
				player=level.getPlayer();
				Playerposition=player.getPosition();
				PlayerX=Playerposition.getX();
				PlayerY=Playerposition.getY();
					
		}
		else if(level.getboard().get(PlayerY-1).get(PlayerX).getObject().getClass()==box.getObject().getClass())
		{
			if (level.getboard().get(PlayerY-2).get(PlayerX).getClass()==new Target().getClass())
			{
				level.getboard().get(PlayerY-2).get(PlayerX).setObject(level.getboard().get(PlayerY-1).get(PlayerX).getObject());
				level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()+1);
				level.getboard().get(PlayerY-1).get(PlayerX).setObject(null);
				if (level.getboard().get(PlayerY-1).get(PlayerX).getClass()==new Target().getClass())
				{
					level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);	
				}
				level.swap(level.getPlayer(), level.getboard().get(PlayerY-1).get(PlayerX));	
				level.setMovesCount(level.getMovesCount()+1);
				level.findPlayer();
				player=level.getPlayer();
				Playerposition=player.getPosition();
				PlayerX=Playerposition.getX();
				PlayerY=Playerposition.getY();

						
			}
		}
		if(level.checkIfComplete())
		{
			System.out.println("Level Completed");
		}	
	}
	else{	
	}
}

public void moveDown()
{
	
	
	if (IsMoveAbleDown())
	{
		if(level.getboard().get(PlayerY+1).get(PlayerX).getObject()==null)
		{
			level.swap(level.getPlayer(), level.getboard().get(PlayerY+1).get(PlayerX));
			level.setMovesCount(level.getMovesCount()+1);
			level.findPlayer();
			player=level.getPlayer();
			Playerposition=player.getPosition();
			PlayerX=Playerposition.getX();
			PlayerY=Playerposition.getY();
			
		}
		
		else if(level.getboard().get(PlayerY+1).get(PlayerX).getObject()==null||level.getboard().get(PlayerY+1).get(PlayerX).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY+2).get(PlayerX).getClass()!=target.getClass())
		{
			if (level.getboard().get(PlayerY+1).get(PlayerX).getClass()==new Target().getClass())
			{
				level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);
			}	
				level.swap(level.getboard().get(PlayerY+2).get(PlayerX), level.getboard().get(PlayerY+1).get(PlayerX));
				level.swap(level.getPlayer(), level.getboard().get(PlayerY+1).get(PlayerX));
				level.setMovesCount(level.getMovesCount()+1);
				level.findPlayer();
				player=level.getPlayer();
				Playerposition=player.getPosition();
				PlayerX=Playerposition.getX();
				PlayerY=Playerposition.getY();
				
		}
		else if(level.getboard().get(PlayerY+1).get(PlayerX).getObject().getClass()==box.getObject().getClass())
		{
			if (level.getboard().get(PlayerY+2).get(PlayerX).getClass()==new Target().getClass())
			{
				level.getboard().get(PlayerY+2).get(PlayerX).setObject(level.getboard().get(PlayerY+1).get(PlayerX).getObject());
				level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()+1);
				level.getboard().get(PlayerY+1).get(PlayerX).setObject(null);
				if (level.getboard().get(PlayerY+1).get(PlayerX).getClass()==new Target().getClass())
				{
					level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);
				}
				level.swap(level.getPlayer(), level.getboard().get(PlayerY+1).get(PlayerX));
				level.setMovesCount(level.getMovesCount()+1);
				level.findPlayer();
				player=level.getPlayer();
				Playerposition=player.getPosition();
				PlayerX=Playerposition.getX();
				PlayerY=Playerposition.getY();
				
			}	
		}		
if(level.checkIfComplete())
{
	System.out.println("Level Completed");
	}
}
else{
}
}
		
			public void moveRight()
			{
				if (IsMoveAbleRight())
				{
					if(level.getboard().get(PlayerY).get(PlayerX+1).getObject()==null)
					{
						level.swap(level.getPlayer(), level.getboard().get(PlayerY).get(PlayerX+1));
						level.setMovesCount(level.getMovesCount()+1);
						level.findPlayer();
						player=level.getPlayer();
						Playerposition=player.getPosition();
						PlayerX=Playerposition.getX();
						PlayerY=Playerposition.getY();
						
					}
					
					else if(level.getboard().get(PlayerY).get(PlayerX+1).getObject()==null||level.getboard().get(PlayerY).get(PlayerX+1).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY).get(PlayerX+2).getClass()!=target.getClass())
					{
						if (level.getboard().get(PlayerY).get(PlayerX+1).getClass()==new Target().getClass())
						{
							level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);
						}
							level.swap(level.getboard().get(PlayerY).get(PlayerX+2), level.getboard().get(PlayerY).get(PlayerX+1));
							level.swap(level.getPlayer(), level.getboard().get(PlayerY).get(PlayerX+1));
							level.setMovesCount(level.getMovesCount()+1);
							level.findPlayer();
							player=level.getPlayer();
							Playerposition=player.getPosition();
							PlayerX=Playerposition.getX();
							PlayerY=Playerposition.getY();
					}
					else if(level.getboard().get(PlayerY).get(PlayerX+1).getObject().getClass()==box.getObject().getClass())
					{
						if (level.getboard().get(PlayerY).get(PlayerX+2).getClass()==new Target().getClass())
						{
							level.getboard().get(PlayerY).get(PlayerX+2).setObject(level.getboard().get(PlayerY).get(PlayerX+1).getObject());
							level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()+1);
							level.getboard().get(PlayerY).get(PlayerX+1).setObject(null);
							if (level.getboard().get(PlayerY).get(PlayerX+1).getClass()==new Target().getClass())
							{
								
								level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);
							}
							level.swap(level.getPlayer(), level.getboard().get(PlayerY).get(PlayerX+1));
							level.setMovesCount(level.getMovesCount()+1);
							level.findPlayer();
							player=level.getPlayer();
							Playerposition=player.getPosition();
							PlayerX=Playerposition.getX();
							PlayerY=Playerposition.getY();
							
						}
							
					}
			if(level.checkIfComplete())
			{
				System.out.println("Level Completed");
		}	
	}
	else{	
	}
}
				public void moveLeft()
				{
					if (IsMoveAbleLeft())
					{
						if(level.getboard().get(PlayerY).get(PlayerX-1).getObject()==null)
						{
							level.swap(level.getPlayer(), level.getboard().get(PlayerY).get(PlayerX-1));
							level.setMovesCount(level.getMovesCount()+1);
							level.findPlayer();
							player=level.getPlayer();
							Playerposition=player.getPosition();
							PlayerX=Playerposition.getX();
							PlayerY=Playerposition.getY();
							
						}
						
						else if(level.getboard().get(PlayerY).get(PlayerX-1).getObject()==null||level.getboard().get(PlayerY).get(PlayerX-1).getObject().getClass()==box.getObject().getClass()&&level.getboard().get(PlayerY).get(PlayerX-2).getClass()!=target.getClass())
						{
							if (level.getboard().get(PlayerY).get(PlayerX-1).getClass()==new Target().getClass())
							{
								level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);
					}	
								level.swap(level.getboard().get(PlayerY).get(PlayerX-2), level.getboard().get(PlayerY).get(PlayerX-1));
								level.swap(level.getPlayer(), level.getboard().get(PlayerY).get(PlayerX-1));
								level.setMovesCount(level.getMovesCount()+1);
								level.findPlayer();
								player=level.getPlayer();
								Playerposition=player.getPosition();
								PlayerX=Playerposition.getX();
								PlayerY=Playerposition.getY();
						}
						else if(level.getboard().get(PlayerY).get(PlayerX-1).getObject().getClass()==box.getObject().getClass())
						{
							if (level.getboard().get(PlayerY).get(PlayerX-2).getClass()==new Target().getClass())
							{
								level.getboard().get(PlayerY).get(PlayerX-2).setObject(level.getboard().get(PlayerY).get(PlayerX-1).getObject());
								level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()+1);
								level.getboard().get(PlayerY).get(PlayerX-1).setObject(null);
								if (level.getboard().get(PlayerY).get(PlayerX-1).getClass()==new Target().getClass())
								{
									
									level.setBoxesOnTargetCount(level.getBoxesOnTargetCount()-1);
							}
								level.swap(level.getPlayer(), level.getboard().get(PlayerY).get(PlayerX-1));
								level.setMovesCount(level.getMovesCount()+1);
								level.findPlayer();
								player=level.getPlayer();
								Playerposition=player.getPosition();
								PlayerX=Playerposition.getX();
								PlayerY=Playerposition.getY();
						}
							}
						
						
					if(level.checkIfComplete())
					{
						System.out.println("Level Completed");
					}
					
				}
				
				else{
					
				}
					}
				}