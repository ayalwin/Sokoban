package model.data.levels;


import java.io.Serializable;
import java.util.ArrayList;

import model.data.objects.GameObject;
import model.data.objects.Player;
import model.data.objects.Target;
import model.data.objects.square;

/**
 * This class implements a Sokoban level logic
 * @author Ayal Weinberger
 *
 */


public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
private String name;
private int MovesCount=0;
private int BoxesOnTargetCount=0;
private int BestSteps;
private square player;
private int numoftargets=0;
private ArrayList<ArrayList<square>> board;


/**
 * Construct a new level given a specific board
 * @param board board
 */
public Level(ArrayList<ArrayList<square>> board)

{
	this.board=board;
	
	//Finds the square where the player is located
	
	for (int i=0;i<board.size();i++)
	{
		for (int j=0;j<board.get(i).size();j++)
		{
			if (board.get(i).get(j).getObject()!=null&&board.get(i).get(j).getObject().getClass()==new Player().getClass())
			{
				player=board.get(i).get(j);
				
			}
			if (board.get(i).get(j).getClass()==new Target().getClass())
			{
				numoftargets+=1;
			}
		}
	}
}


/**
 * checks if level has been completed
 * @return - boolean
 */
public boolean checkIfComplete()
{
	if(numoftargets==BoxesOnTargetCount)
	{
		return true;
	}
	else
	{
		return false;
	}
}


/**
 * returns the number of targets in this level
 * @return - int
 */
public int getNumoftargets() {
	return numoftargets;
}

public void setNumoftargets(int numoftargets) {
	this.numoftargets = numoftargets;
}

//Finds the square where the player is located


public void findPlayer()
{
	for (int i=0;i<board.size();i++)
	{
		for (int j=0;j<board.get(i).size();j++)
		{
			if (board.get(i).get(j).getObject()!=null&&board.get(i).get(j).getObject().getClass()==new Player().getClass())
			{
				player=board.get(i).get(j);
			}
		}	
	}
}


//will swap the objects between 2 given squares.

	/**
	 * swaps objects between two given squares on the board
	 * @param sq1 - first square
	 * @param sq2 -second square
	 */
	public void swap(square sq1,square sq2)
	{
		
		GameObject sq1object=new GameObject();
		sq1object=sq1.getObject();
		GameObject sq2object=new GameObject();
		sq2object=sq2.getObject();
		sq2.setObject(sq1object);
		sq1.setObject(sq2object);
	}
	
/**
 * @return - the square where the player is positioned
 */
public square getPlayer() {
	return player;
}


/**
 * 
 * @param player - the desired square to position the player
 */
public void setPlayer(square player) {
	this.player = player;
}

/**
 * Default constructor 
 */
public Level() {

}

/**
 * 
 * @return - this level's board
 */
public ArrayList<ArrayList<square>> getboard() {
	return board;
}


/**
 * 
 * @param board - new board
 */
public void setGameobjects(ArrayList<ArrayList<square>> board) {
	this.board =board;
}

public String toString(){
    String result = "";
for(int i = 0; i < board.size(); i++){
    for(int j = 0; j < board.get(i).size(); j++){
        result += board.get(i).get(j);
    }
    
    result += "\n";
    }
    return result;
}

/**
 * @return Srting level name
 */
public String getName() {
	return name;
}

/**
 * @param name - Stnig name
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return int 
 */
public int getMovesCount() {
	return MovesCount;
}
/**
 * @param movesCount int
 */
public void setMovesCount(int movesCount) {
	MovesCount = movesCount;
}

/**
 * returns the number of target where boxes are positioned at
 * @return int
 */
public int getBoxesOnTargetCount() {
	return BoxesOnTargetCount;
}


public void setBoxesOnTargetCount(int boxesOnTargetCount) {
	BoxesOnTargetCount = boxesOnTargetCount;
}
public int getBestSteps() {
	return BestSteps;
}
public void setBestSteps(int bestSteps) {
	BestSteps = bestSteps;
 }
}
