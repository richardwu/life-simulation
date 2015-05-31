import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class RockTile extends Tile 
{

        public RockTile(int x, int y) throws IOException 
        {
                super(OBSTACLE_FALSE, TYPE_ROCK, ImageIO.read(new File ("src\\img\\rock.png")), x, y);

        }


}
