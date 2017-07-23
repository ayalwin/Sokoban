package model.data.levels;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.data.objects.square;
/**
 * Saves a level as a text file
 * @author Ayal Weinberger
 * .
 *
 */
public class TextLevelSaver implements SaveLevel {

	@Override
	public void Save(String filepath, Level level) throws FileNotFoundException{
		
		PrintWriter pw=new PrintWriter(new FileOutputStream(filepath));
		
		for(ArrayList<square>g:level.getboard())
		{
			for(square go:g){
				
				pw.write(go.toString());
			}
			pw.println();
				
		}
		pw.close();
	}
}
		
		
		