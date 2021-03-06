package model.data.levels;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Saves a level as a XML file.
 * @author Ayal Weinberger
 * 
 *
 */
public class XmlLevelSaver implements SaveLevel {
	

	@Override
	public void Save(String filepath, Level level) throws IOException {
		XMLEncoder x=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
		x.writeObject(level);
		x.close();
		

	}

}
