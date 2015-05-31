import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class TreeTile extends Tile
{
    public TreeTile(int x, int y) throws IOException 
    {
            super(OBSTACLE_TRUE, TYPE_TREE, ImageIO.read(new File ("src\\img\\tree.png")), x, y);

    }

}
