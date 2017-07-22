package Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil {
	
	public static void serialize(Object o,String filename) throws IOException
	{
		FileOutputStream fos=new FileOutputStream(filename);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(o);
		fos.close();			
	}
public static Object deserialize(InputStream in) throws IOException, ClassNotFoundException{
	ObjectInputStream ois=new ObjectInputStream(in);
	Object o=ois.readObject();
	return o;
 } 
}		