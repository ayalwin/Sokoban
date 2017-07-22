package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.data.levels.Level;

public class LevelDisplayer extends Canvas {
	Level level;

	public void setLevel(Level level) {
		this.level = level;
		redraw();
	}

	public void redraw()
	{
		if(level!=null)
		{
			GraphicsContext gc = getGraphicsContext2D();	
			Image wall=null;
			Image box=null;
			Image target=null;
			Image player=null;
			Image levelcompleted=null;

			try {
				levelcompleted=new Image(new FileInputStream("./resources/levelcompleted.png"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			try {
				wall=new Image(new FileInputStream("./resources/wall.jpeg"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				box=new Image(new FileInputStream("./resources/box.jpeg"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				target=new Image(new FileInputStream("./resources/target.jpeg"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				player=new Image(new FileInputStream("./resources/player.jpeg"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(level);

			String[] dataTxt = level.toString().split("\n");
			for(int i = 0; i < dataTxt.length; i++)
				System.out.println(dataTxt[i]);

			gc.setFill(Color.WHITE);

			double W= getWidth();
			double H= getHeight();
			double w=W/dataTxt[0].length();
			double h=H/dataTxt.length;
			gc.clearRect(0, 0, W, H);

			if(level.checkIfComplete())
			{
				
				gc.drawImage(levelcompleted,0, 0, W, H);
				
			}

			else{

				for(int i = 0; i < dataTxt.length ;i++)
					for(int j = 0; j < dataTxt[0].length() ;j++)
					{
						if(dataTxt[i].charAt(j) == ' ')	
						{
							gc.fillRect(j*w, i*h, w, h);
						}
						else if(dataTxt[i].charAt(j) == '#')
						{
							gc.drawImage(wall, j*w, i*h, w, h);	
						}else if(dataTxt[i].charAt(j) == '@')
						{		
							gc.drawImage(box, j*w, i*h, w, h);
						}else if(dataTxt[i].charAt(j) == 'o')
						{		
							gc.drawImage(target, j*w, i*h, w, h);
						}else if(dataTxt[i].charAt(j) == 'A')
						{	
							gc.drawImage(player, j*w, i*h, w, h);
						}
					}
			}
		}
	}
}
