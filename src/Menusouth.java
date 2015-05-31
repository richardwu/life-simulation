import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import javax.swing.JComponent;


public class Menusouth extends JComponent implements MouseListener 
{
	private final int ID_MAINSTART = 0;
	private final int ID_MAINPAUSE = 1;
	private final int ID_SPAWN = 2;
	private final int ID_SAVE = 3;
	private final int ID_LOAD = 4;
	private final int ID_MENU = 5;
	private final int ID_COMINGSOON = 6;

	private BufferedImage img, weatherImg;
	private int panelID, lifeformSpecies, weather;
	private boolean loop, makeLifeform;
	
	//Constructor for menubar at the bottom
	public Menusouth ()
	{
		try
		{
			img = ImageIO.read(new File ("src\\img\\menusouthstart.png"));
		} catch (IOException e) {}
		panelID = ID_MAINSTART;
		loop = false;
		makeLifeform = false;
		weather = -1;
		
		setPreferredSize(new Dimension(1274, 73));
		addMouseListener(this);
	}
	
	//Paints background image as well as corresponding weather images
	public void paintComponent (Graphics g)
	{
		g.drawImage (img, 0, 0, null);
		
		//Prints weather images for the two particular panels
		if (panelID == ID_MAINSTART || panelID == ID_MAINPAUSE)
		{
			//Weather images
			try
			{
				if (weather == 0)
					weatherImg = ImageIO.read(new File ("src\\img\\rain.png"));
				else if (weather == 1)
					weatherImg = ImageIO.read(new File ("src\\img\\hail.png"));
				else if (weather == 2)
					weatherImg = ImageIO.read(new File ("src\\img\\snow.png"));
				else if (weather == 3)
					weatherImg = ImageIO.read(new File ("src\\img\\sunny.png"));
			} catch (IOException e) {}

			if (weather != -1)
				g.drawImage (weatherImg, 1155, 20, null);
		}
	}
	
	public boolean loop ()
	{
		return loop;
	}
	
	public boolean makeLifeform ()
	{
		return makeLifeform;
	}
	
	public void setMakeLifeform (boolean makeLifeform)
	{
		this.makeLifeform = makeLifeform;
	}
	
	public int getLifeformSpecies ()
	{
		return lifeformSpecies;
	}
	
	public void setWeather(int weather) 
	{
		this.weather = weather;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//Panels w/ start button (main panel)
		if (panelID == ID_MAINSTART)
		{
			//Start button clicked
			if (e.getX() >= 48 && e.getX() <= 189 && e.getY() >= 16 && e.getY() <= 63)
			{
				//Changes image to main panel w/ pause button
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthpause.png"));
				} catch (IOException e1) {}
				panelID = ID_MAINPAUSE;
				loop = true;
				repaint();		
			}
			//Spawn button clicked
			else if (e.getX() >= 240 && e.getX() <= 381 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthspecies.png"));
				} catch (IOException e1) {}
				panelID = ID_SPAWN;
				repaint();		
			}
			//Save button clicked
			else if (e.getX() >= 431 && e.getX() <= 574 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthcomingsoon.png"));
				} catch (IOException e1) {}
				panelID = ID_COMINGSOON;
				repaint();		
			}
			//Load button clicked
			else if (e.getX() >= 624 && e.getX() <= 766 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthcomingsoon.png"));
				} catch (IOException e1) {}
				panelID = ID_COMINGSOON;
				repaint();		
			}
			//Menu button clicked
			else if (e.getX() >= 816 && e.getX() <= 959 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthcomingsoon.png"));
				} catch (IOException e1) {}
				panelID = ID_COMINGSOON;
				repaint();		
			}
		}
		//Panel w/ pause button (main panel)
		else if (panelID == ID_MAINPAUSE)
		{
			//Stop button clicked
			if (e.getX() >= 48 && e.getX() <= 189 && e.getY() >= 16 && e.getY() <= 63)
			{
				//Changes image to main panel w/ start button
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthstart.png"));
				} catch (IOException e1) {}
				panelID = ID_MAINSTART;
				loop = false;
				repaint();		
			}
			//Spawn button clicked
			else if (e.getX() >= 240 && e.getX() <= 381 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthspecies.png"));
				} catch (IOException e1) {}
				panelID = ID_SPAWN;
				repaint();		
			}
			//Save button clicked
			else if (e.getX() >= 431 && e.getX() <= 574 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthcomingsoon.png"));
				} catch (IOException e1) {}
				panelID = ID_COMINGSOON;
				repaint();		
			}
			//Load button clicked
			else if (e.getX() >= 624 && e.getX() <= 766 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthcomingsoon.png"));
				} catch (IOException e1) {}
				panelID = ID_COMINGSOON;
				repaint();			
			}
			//Menu button clicked
			else if (e.getX() >= 816 && e.getX() <= 959 && e.getY() >= 16 && e.getY() <= 63)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menusouthcomingsoon.png"));
				} catch (IOException e1) {}
				panelID = ID_COMINGSOON;
				repaint();		
			}
		}
		//Panel w/ species button
		else if (panelID == ID_SPAWN)
		{
			//Species 1
			if (e.getX() >= 41 && e.getX() <= 139 && e.getY() >= 23 && e.getY() <= 59)
			{
				lifeformSpecies = 0;
				makeLifeform = true;
			}
			//Species 2
			else if (e.getX() >= 181 && e.getX() <= 279 && e.getY() >= 23 && e.getY() <= 59)
			{
				lifeformSpecies = 1;
				makeLifeform = true;
			}
			//Species 3
			else if (e.getX() >= 322 && e.getX() <= 419 && e.getY() >= 23 && e.getY() <= 59)
			{
				lifeformSpecies = 2;
				makeLifeform = true;
			}
			//Species 4
			else if (e.getX() >= 462 && e.getX() <= 559 && e.getY() >= 23 && e.getY() <= 59)
			{
				lifeformSpecies = 3;
				makeLifeform = true;
			}
			//Species 5
			else if (e.getX() >= 601 && e.getX() <= 700 && e.getY() >= 23 && e.getY() <= 59)
			{
				lifeformSpecies = 4;
				makeLifeform = true;
			}
			//Species 6
			else if (e.getX() >= 741 && e.getX() <= 840 && e.getY() >= 23 && e.getY() <= 59)
			{
				lifeformSpecies = 5;
				makeLifeform = true;
			}
			//Species 7
			else if (e.getX() >= 881 && e.getX() <= 980 && e.getY() >= 23 && e.getY() <= 59)
			{
				lifeformSpecies = 6;
				makeLifeform = true;
			}
			//Back button
			else if (e.getX() >= 1023 && e.getX() <= 1219 && e.getY() >= 23 && e.getY() <= 59)
			{
				if (loop)
				{
					//Changes image to main panel w/ stop button
					try 
					{
						img = ImageIO.read(new File ("src\\img\\menusouthpause.png"));
					} catch (IOException e1) {}
					panelID = ID_MAINPAUSE;
					repaint();	
				}
				else
				{
					//Changes image to main panel w/ start screen
					try 
					{
						img = ImageIO.read(new File ("src\\img\\menusouthstart.png"));
					} catch (IOException e1) {}
					panelID = ID_MAINSTART;
					repaint();
				}
			}
		}
		else if (panelID == ID_COMINGSOON)
		{
			if (e.getX() >= 1012 && e.getX() <= 1207 && e.getY() >= 23 && e.getY() <= 59)
			{
				if (loop)
				{
					//Changes image to main panel w/ stop button
					try 
					{
						img = ImageIO.read(new File ("src\\img\\menusouthpause.png"));
					} catch (IOException e1) {}
					panelID = ID_MAINPAUSE;
					repaint();	
				}
				else
				{
					//Changes image to main panel w/ start screen
					try 
					{
						img = ImageIO.read(new File ("src\\img\\menusouthstart.png"));
					} catch (IOException e1) {}
					panelID = ID_MAINSTART;
					repaint();
				}
			}
		}
		
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
