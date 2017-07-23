package model.data.levels;

import java.io.InputStream;
import Util.SerializationUtil;

/**
 * Loading a new level from an Object file.
 * @author Ayal Weinberger
 *
 */
public class MyObjectLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) throws Exception {
		
		Level level;
		level=(Level) SerializationUtil.deserialize(in);
		return level;
		
	
	}

}
