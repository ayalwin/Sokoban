package model.data.levels;

import java.io.IOException;

/**
 * @author Ayal Weinberger
 * This interface saves a level into a new file.
 */
public interface SaveLevel {
	
	public void Save(String filepath, Level level) throws IOException;
	

}
