import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GrassTile extends Tile
{
       private int condition;
        private boolean isDead; 
        
        
        public GrassTile(int x, int y) throws IOException
        {
                super(OBSTACLE_FALSE, TYPE_GRASS, ImageIO.read(new File ("src\\img\\grass100.png")), x, y);
                condition = 100;
                isDead = false;
        }
        
        public void elapse (Weather weather, boolean isAdjacentOccupied, Lifeform occupied)
        {
        		//If nearby herbivore/omnivore lifeform, grass condition decreases
                if (condition > 0 && isAdjacentOccupied && (occupied.getType() == occupied.TYPE_OMNIVORE || occupied.getType() == occupied.TYPE_HERBIVORE))
                {
                        // Reduces condition by 5; if condition is already less than 5, reduces it to 0
                        if (condition >= 50)
                                condition -=50;
                        else
                                condition = 0;
                        
                        if (condition == 0)
                                isDead = true;
                }
                
                //If raining, grass grows
                if (weather.getType() == weather.TYPE_RAIN)
                {
                	if (isDead)
                	{
                		isDead = false;
                		condition = 50;
                	}
                	else
                	{
                		if (condition >= 80)
                			condition = 100;
                		else
                			condition += 20;
                	}
                }
                //If snow/hail, grass grows (not as much rain)
                else if (weather.getType() == weather.TYPE_HAIL || weather.getType() == weather.TYPE_SNOW)
                {
                	if (isDead)
                	{
                		isDead = false;
                		condition = 30;
                	}
                	else
                	{
                		if (condition >= 85)
                			condition = 100;
                		else
                			condition += 15;
                	}
                }
                //If sunny, grass condition decreases slightly
                else
                {
                	if (condition > 0)
                	{
                		if (condition <= 10)
                		{
                			condition = 0;
                			isDead = true;
                		}
                		else
                			condition -= 10;
                	}
                }
                
                //Changes grass image to correspond with the different stages of the grass condition
                try
                {
                	if (condition == 0)
                		img = ImageIO.read(new File ("src\\img\\grass0.png"));
                	else if (condition <= 25)
                		img = ImageIO.read(new File ("src\\img\\grass25.png"));
                	else if (condition <= 50)
                		img = ImageIO.read(new File ("src\\img\\grass50.png"));
                	else if (condition <= 75)
                		img = ImageIO.read(new File ("src\\img\\grass75.png"));
                	else
                		img = ImageIO.read(new File ("src\\img\\grass100.png"));
                }
                catch (IOException e) {}
        }

        public int getCondition ()
        {
        	return condition;
        }
        
        public void setCondition (int condition)
        {
        	this.condition = condition;
        }
}
