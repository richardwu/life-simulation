import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Menueast extends JComponent implements MouseListener
{
	private final int HUNGER_X = 30;
	private final int HUNGER_Y = 245;
	private final int GENDER_X = 155;
	private final int GENDER_Y = 315;
	private final int SPECIES_X = 210;
	private final int SPECIES_Y = 70;
	private final int DIET_X = 90;
	private final int DIET_Y = 470;
	
    private BufferedImage img, sprite;
	private Lifeform lifeform;
	private boolean isDeleteLifeform, isClearLifeform;

	//Constructor for the menubar on the right
    public Menueast()
    {
       try {                
          img = ImageIO.read(new File("src\\img\\menueast.png"));
       } catch (IOException ex) {}
       lifeform = null;
       isDeleteLifeform = false;
       isClearLifeform = false;
       
       setPreferredSize(new Dimension(369, 600));
       addMouseListener(this);
    }

    //Displays all the info./images pertaining to selected lifeform as well as background image
    public void paintComponent(Graphics g) 
    {	
		g.drawImage (img, 0, 0, null);

		if (lifeform != null)
		{
			//Prints the sprite of the lifeform
			try 
			{
				sprite = ImageIO.read(new File ("src\\img\\species" + (lifeform.getSpecies() + 1) + "sidebar.png"));
			} catch (IOException e1) {}	
			
			g.drawImage (sprite, 50, 0, null);
			
			//Prints the hunger level
			g.setFont(new Font ("", Font.BOLD, 40));
			
			String hungerStatus;
			if (lifeform.getHunger() <= 33)
			{
				g.setColor(Color.RED);
				hungerStatus = "Famished";
			}
			else if (lifeform.getHunger() <= 66)
			{
				g.setColor(Color.YELLOW);
				hungerStatus = "Content";
			}
			else
			{
				g.setColor(Color.GREEN);
				hungerStatus = "Bloated";
			}
			g.drawString(lifeform.getHunger() + "%     " + hungerStatus, HUNGER_X, HUNGER_Y);
			
			g.setColor(Color.BLUE);
			
			//Prints the species
			g.drawString(lifeform.getSpeciesList()[lifeform.getSpecies()], SPECIES_X, SPECIES_Y);
			

			//Prints the gender
			BufferedImage genderImg = null;
			if (lifeform.getGender() == lifeform.GENDER_MALE)
			{
				try 
				{
					genderImg = ImageIO.read(new File ("src\\img\\male.png"));
				} catch (IOException e) {}
			}
			else
			{
				try 
				{
					genderImg = ImageIO.read(new File ("src\\img\\female.png"));
				} catch (IOException e) {}
			}
			g.drawImage(genderImg, GENDER_X, GENDER_Y, null);

			//Prints the diet/vore type
			g.drawString(lifeform.getTypeList()[lifeform.getType()], DIET_X, DIET_Y);
		}     
    }
    
    public Lifeform getLifeform ()
    {
    	return lifeform;
    }
    
	public void setLifeform (Lifeform lifeform)
	{
		this.lifeform = lifeform;
	}
	
    public boolean isDeleteLifeform ()
    {
    	return isDeleteLifeform;
    }
    
    public void setIsDeleteLifeform (boolean isDeleteLifeform)
    {
    	this.isDeleteLifeform = isDeleteLifeform;
    }
    
	
	public boolean isClearLifeform ()
	{
		return isClearLifeform;
	}
	
	public void setIsClearLifeform (boolean isClearLifeform)
	{
		this.isClearLifeform = isClearLifeform;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//Clear selection button clicked
		if (lifeform != null && e.getX() >= 24 && e.getX() <= 161 && e.getY() >= 520 && e.getY() <= 585)
			isClearLifeform = true;
		//Delete button clicked
		else if (lifeform != null && e.getX() >= 210 && e.getX() <= 345 && e.getY() >= 520 && e.getY() <= 585)
			isDeleteLifeform = true;
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
