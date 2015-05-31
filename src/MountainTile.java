import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MountainTile extends Tile
{
        public MountainTile(int x, int y) throws IOException 
        {
                super(OBSTACLE_TRUE, TYPE_MOUNTAIN, ImageIO.read(new File ("src\\img\\mountain.png")), x, y);
        }
}
