import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class DesertTile extends Tile
{
        public DesertTile(int x, int y) throws IOException 
        {
                super(OBSTACLE_FALSE, TYPE_DESERT, ImageIO.read(new File ("src\\img\\desert.png")), x, y);
        }

}
