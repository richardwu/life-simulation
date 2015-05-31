import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Menuwest extends JPanel
{
    private BufferedImage img;

    //Constructor for the menu area on the left (converting an image to a JPanel)
    public Menuwest()
    {
       try {                
          img = ImageIO.read(new File("src\\img\\menuwest.png"));
       } catch (IOException ex) {}
       
       setPreferredSize(new Dimension(5, 600));
    }

    public void paintComponent(Graphics g) 
    {
        g.drawImage(img, 0, 0, null);        
    }
}