package model.data.objects;

import java.io.Serializable;

public class square implements Serializable {
	private static final long serialVersionUID = 1L;
	private GameObject object=null;
	private Position position;
	
	public square(Position p)
	{
		this.position=p;
	}
	
	public square(GameObject g, Position p) {
		this.object=g;
		this.position=p;
	}
	
	public square()
	{
	}

	public GameObject getObject() {
		return object;
	}

	public void setObject(GameObject object) {
		this.object = object;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String toString()
	{
		if(this.object==null)
			return " ";
		else return object.toString();	
	}
}