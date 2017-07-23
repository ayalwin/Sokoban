package model.data.levels;

import java.io.InputStream;


/**
 * This interface loads a new game level from file.
 * @author Ayal Weinberget
 * 
 */
public interface LevelLoader {


/**
 * Loading Sokoban level
 * @param in file location
 * @return Level
 * @throws Exception Exception
 */
public Level loadLevel(InputStream in) throws Exception;
}

