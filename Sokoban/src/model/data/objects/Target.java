package model.data.objects;

public class Target extends square {
	private static final long serialVersionUID = 1L;
	private GameObject object=null;
	private Position position;
	
	public Target(GameObject g, Position p)
	{
		super(g, p);
		this.object=g;
		this.position=p;
	}
	
	public Target(Position p)
	{
		this.position=p;
		this.object=null;	
	}
	public Target()
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
			return "o";
		else return object.toString();	
	}
}