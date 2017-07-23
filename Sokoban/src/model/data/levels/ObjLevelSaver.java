package model.data.levels;

import java.io.IOException;

import Util.SerializationUtil;

/**
 * Saves a level as an object file.
 * @author Ayal Weinberger
 * 
 *
 */
public class ObjLevelSaver implements SaveLevel {

	@Override
	public void Save(String filepath, Level level) throws IOException{
		
		SerializationUtil.serialize(level, filepath);

	}

}
