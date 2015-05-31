import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;


public class Tile
{
    	private final int TILE_SIZE = 30;
    
        protected final static String [] types = {"Grass", "Water", "Rock", "Desert", "Mountain", "Tree"};
        protected final static int TYPE_GRASS = 0;
        protected final static int TYPE_WATER = 1;
        protected final static int TYPE_ROCK = 2;
        protected final static int TYPE_DESERT = 3;
        protected final static int TYPE_MOUNTAIN = 4;
        protected final static int TYPE_TREE = 5;
        
        protected final static boolean OBSTACLE_TRUE = true;
        protected final static boolean OBSTACLE_FALSE = false;
        
        protected boolean isObstacle, isOccupied;
        protected int type, x, y;
        protected BufferedImage img;
        protected Lifeform occupiedLifeform;
        
        //Constructor for the tiles of the map
        public Tile (boolean isObstacle, int type, BufferedImage img, int x, int y)
        {
                this.isObstacle = isObstacle;
                this.type = type;
                this.img = img;
                this.x = x;
                this.y = y;
                isOccupied = false;
                occupiedLifeform = null;
        }
        
        public void draw (Graphics g)
        {
            g.drawImage (img, x*TILE_SIZE, y*TILE_SIZE, null);
        }
        
        public int getType ()
        {
        	return type;
        }
        
        
        public int getX ()
        {
        	return x;
        }
        
        public int getY ()
        {
        	return y;
        }
        
        public boolean isObstacle ()
        {
        	return isObstacle;
        }
        
        public boolean isOccupied ()
        {
        	return isOccupied;
        }
        
        public void setIsOccupied (boolean isOccupied)
        {
        	this.isOccupied = isOccupied;
        }
        
        public void setOccupiedLifeform (Lifeform occupiedLifeform)
        {
        	this.occupiedLifeform = occupiedLifeform;
        }
        
        public void setX (int x)
        {
        	this.x = x;
        }
        
        public void setY (int y)
        {
        	this.y = y;
        }
        
}
