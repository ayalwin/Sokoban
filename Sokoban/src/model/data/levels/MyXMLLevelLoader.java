package model.data.levels;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.io.InputStream;

/**
 * Loading a new level from a XML file.
 * @author Ayal Weinberger
 *
 */
public class MyXMLLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) throws IOException {
		Level level;
		
		XMLDecoder decoder= new XMLDecoder(in);
		level=(Level) decoder.readObject();
		decoder.close();
		return level;
	}

}