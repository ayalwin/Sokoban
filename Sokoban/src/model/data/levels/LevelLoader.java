package model.data.levels;

import java.io.InputStream;

public interface LevelLoader {
	/**<h3><font color="red">LevelLoader description:</h3> </font></br>
A. The separation is carried out by the class which is responsible for producing data not aware of her creative process and it does not choose when to be formed, the class that produces it is the one that receives the information about the create of the class. </br> </br>
B.Because if elected to change the way we load files, then the only class which manufactures have to change, if we elected to add or modify any information relating to incorporate a mere class represents change and it will not affect the way the loading level.</br> </br>
C. Thanks to this principle, we can ensure that every class we have no matter with what files it knows how to work, we can use it and it’s use will be transparent to us, according to the file extension you choose the correct department and principle will ensure that the whole class that implements the interface LevelLoader work and produce us forward successfully.</br> </br>
D.the designation of inputstream is to stream information into our application from a file on your computer, it gives us easy access and lay deal with regular files and thus we do not need to check if the string received is indeed a standard string and if the file exists. In addition, this way we can ensure that every file we want to take care of the future of our department can access it using inputstream easy and convenient manner. </br> </br>
	*/
	public Level loadLevel(InputStream in) throws Exception;
}

