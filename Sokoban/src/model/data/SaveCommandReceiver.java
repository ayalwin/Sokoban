package model.data;

import java.io.IOException;
import java.util.HashMap;

import model.data.levels.Level;
import model.data.levels.ObjLevelSaver;
import model.data.levels.SaveLevel;
import model.data.levels.TextLevelSaver;
import model.data.levels.XmlLevelSaver;

public class SaveCommandReceiver {
	
	private HashMap <String, SaveLevel> LevelSaverFactory;
	
	public SaveCommandReceiver() {
		LevelSaverFactory=new HashMap<String,SaveLevel>();
		LevelSaverFactory.put("txt", new TextLevelSaver());
	LevelSaverFactory.put("obj", new ObjLevelSaver());
	LevelSaverFactory.put("xml", new XmlLevelSaver());
}

public void Action(String filepath, Level level) throws IOException{
	
	String temp;
	int c=filepath.indexOf('.',0);
		temp=filepath.substring(c+1, filepath.length());
		
		SaveLevel saver=LevelSaverFactory.get(temp);
		saver.Save(filepath, level);
		
		
		
	}
	


}
