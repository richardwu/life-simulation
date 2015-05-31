import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class WaterTile extends Tile 
{
	
	private int waterlevel;
	private boolean isEmpty;
        public WaterTile(int x, int y) throws IOException
        {
                super(OBSTACLE_TRUE, TYPE_WATER, ImageIO.read(new File ("src\\img\\water100.png")), x, y);
                waterlevel = 100;
                isEmpty = false; 
        }
        
        public void elapse (Weather weather, boolean isAdjacentOccupied)
        {
        		//Lowers the water level if animal is nearby
                if (waterlevel > 0 && isAdjacentOccupied)
                {
                        // Reduces condition by 5; if condition is already less than 5, reduces it to 0
                        if (waterlevel >= 50)
                                waterlevel -=50;
                        else
                                waterlevel -= waterlevel;
                        
                        if (waterlevel == 0)
                                isEmpty = true;
                }
                
                //Lowers/raises water level depending on weather
                if (weather.getType() == weather.TYPE_SUNNY)
                {
                	if (waterlevel <= 5)
                		waterlevel = 0;
                	else
                		waterlevel -= 5;
                }
                else
                {
                	if (waterlevel == 0)
                		waterlevel = 30;
                	else
                	{
                		if (waterlevel >= 10)
                			waterlevel = 100;
                		else
                			waterlevel += 10;
                	}
                }
                
                //Changes image to appropriately display the different stages of the water level
                try
                {
                	if (waterlevel == 0)
                		img = ImageIO.read(new File ("src\\img\\water0.png"));
                	else if (waterlevel <= 25)
                		img = ImageIO.read(new File ("src\\img\\water25.png"));
                	else if (waterlevel <= 50)
                		img = ImageIO.read(new File ("src\\img\\water50.png"));
                	else if (waterlevel <= 75)
                		img = ImageIO.read(new File ("src\\img\\water75.png"));
                	else
                		img = ImageIO.read(new File ("src\\img\\water100.png"));
                }
                catch (IOException e) {}
        }
        
        public int getwaterlevel ()
        {
        	return waterlevel;
        }
        
        public void setWaterlevel (int waterlevel)
        {
        	this.waterlevel = waterlevel; 
        }
}
