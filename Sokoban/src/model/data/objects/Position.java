package model.data.objects;

import java.io.Serializable;

public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	public Position() {
		this.x=0;
		this.y=0;		
	}
	
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public boolean IsEqual(Position p)
	{
		if(this.x==p.getX()&&this.y==p.getY())
			return true;
		else 
			return false;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}