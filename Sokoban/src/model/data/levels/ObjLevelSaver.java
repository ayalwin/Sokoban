package model.data.levels;

import java.io.IOException;

import Util.SerializationUtil;

public class ObjLevelSaver implements SaveLevel {

	@Override
	public void Save(String filepath, Level level) throws IOException{
		
		SerializationUtil.serialize(level, filepath);

	}

}
