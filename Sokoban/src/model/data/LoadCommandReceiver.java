package model.data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import model.data.levels.Level;
import model.data.levels.LevelLoader;
import model.data.levels.MyObjectLevelLoader;
import model.data.levels.MyTextLevelLoader;
import model.data.levels.MyXMLLevelLoader;

public class LoadCommandReceiver {

	private HashMap<String,LevelLoader> levelCreatorFactory;


	public LoadCommandReceiver() {

		levelCreatorFactory=new HashMap<String,LevelLoader>();
		levelCreatorFactory.put("txt", new MyTextLevelLoader());
		levelCreatorFactory.put("obj", new MyObjectLevelLoader() );
		levelCreatorFactory.put("xml", new MyXMLLevelLoader());  

	}


	public Level Action(String filepath) throws Exception

	{


		String temp;
		int c=filepath.indexOf('.',0);
		temp=filepath.substring(c+1, filepath.length());

		Level level=null;
		LevelLoader loader;
		loader=levelCreatorFactory.get(temp);
		BufferedInputStream bi=new BufferedInputStream(new FileInputStream(filepath));
		level=loader.loadLevel(bi);
		File f = new File(filepath);
		int c2=f.getName().indexOf('.',0);
		level.setName(f.getName().substring(0, c2));
		return level;

	}

}
