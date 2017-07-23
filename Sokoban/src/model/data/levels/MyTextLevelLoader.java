package model.data.levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.data.objects.Box;
import model.data.objects.Player;
import model.data.objects.Position;
import model.data.objects.Target;
import model.data.objects.Wall;
import model.data.objects.square;

/**
 * Loading a new level from a text file.
 * @author Ayal Weinberger
 *
 */
public class MyTextLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) throws IOException {
		ArrayList<ArrayList<square>> bo = new ArrayList<>();
		new BufferedReader(new InputStreamReader(in));
		bo.add(new ArrayList<square>());
		int y=0,x=0,c;
		while ((c=in.read()) !=-1)
		{
			char ch = (char)c;
			switch (ch)
			{
			case '#':
			bo.get(y).add(x, new square(new Wall(), new Position(x, y)));
			x++;
			break;
		case '@':
			bo.get(y).add(x, new square(new Box(), new Position(x, y)));
			x++;
			break;
		case '\n':
			x=0;
			y++;
			bo.add(new ArrayList<square>());
			break;
		case 'A':
			bo.get(y).add(x, new square(new Player(), new Position(x, y)));
			x++;
			break;
		case 'o':
			bo.get(y).add(x, new Target(new Position(x, y)));
			x++;
			break;
		case ' ':
				bo.get(y).add(x, new square(new Position(x, y)));
				x++;
			break;
				
		
			}
			
		}
		
		
		
		
		
		
		
		return new Level(bo);
	}

}
