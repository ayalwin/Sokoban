package model;

import java.io.IOException;

import model.data.levels.Level;

public interface model {
	
	public void move(String direction);
	public void saveLevel(String filepath) throws IOException;
	public void loadLevel(String filepath) throws Exception;
	public void exit();
	public void solve();
	public void getHint();
	public Level getCurrentLevel();

}
