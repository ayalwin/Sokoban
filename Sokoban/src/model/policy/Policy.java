package model.policy;

/**
 * An interface which defines the legal moves an policy of a game
 * @author Ayal Weinberger 
 * 
 *
 */
public interface Policy{
	public void moveUp();
	public void moveDown();
	public void moveLeft();
	public void moveRight();
}
