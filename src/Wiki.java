import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Wiki extends JComponent implements MouseListener
{
	private final int PANEL_MENU = 0;
	private final int PANEL_SPECIES = 1;
	private final int PANEL_TILES = 2;
	private final int PANEL_WEATHER = 3;
	private final int PANEL_BACKTOSPECIES = 4;
	private final int PANEL_BACKTOTILES = 5;
	private final int PANEL_BACKTOWEATHER = 6;
	
	BufferedImage buttonImg, mainImg;
	private int panelID;
	
	//Constructor for the wiki component
	public Wiki ()
	{
		try 
		{
			buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonmenu.png"));
		} catch (IOException e) {}
		
		panelID = PANEL_MENU;
		
		try
		{
			mainImg = ImageIO.read(new File ("src\\img\\wikimain.png"));
		} catch (IOException e) {}
		
		setPreferredSize(new Dimension (900, 600));
		addMouseListener(this);
	}
	
	//Paints both the button panel and the main panel
	public void paintComponent (Graphics g)
	{
		g.drawImage(buttonImg, 0, 0, null);
		g.drawImage(mainImg, 300, 0, null);
	}

	//Mouselistener for mouse clicks (buttons)
	@Override
	public void mouseClicked(MouseEvent e)
	{
		//Uses corresponding button coordinates depending on which button panel image is shown
		if (panelID == PANEL_MENU)
		{
			//Species button clicked
			if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 68 && e.getY() <= 112)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonspecies.png"));
				} catch (IOException e1) {}
				panelID = PANEL_SPECIES;
				repaint();
			}
			//Tiles button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 127 && e.getY() <= 169)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttontiles.png"));
				} catch (IOException e1) {}
				panelID = PANEL_TILES;
				repaint();
			}
			//Weather button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 184 && e.getY() <= 227)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonweather.png"));
				} catch (IOException e1) {}
				panelID = PANEL_WEATHER;
				repaint();
			}
		}
		else if (panelID == PANEL_SPECIES)
		{
			//Lezag button clicked
			if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 68 && e.getY() <= 112)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikilezag.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOSPECIES;
				repaint();
			}
			//Raeb button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 127 && e.getY() <= 169)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikiraeb.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOSPECIES;
				repaint();
			}
			//Yeso button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 184 && e.getY() <= 227)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikiyeso.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOSPECIES;
				repaint();
			}
			//Krah button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 240 && e.getY() <=279)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikikrah.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOSPECIES;
				repaint();
			}
			//Otuq button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 300 && e.getY() <= 341)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikiotuq.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOSPECIES;
				repaint();
			}
			//Iekom button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 359 && e.getY() <= 400)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikiiekom.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOSPECIES;
				repaint();
			}
			//Nogard button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 415 && e.getY() <= 459)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikinogard.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOSPECIES;
				repaint();
			}
			//Back button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 476 && e.getY() <= 517)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonmenu.png"));
				} catch (IOException e1) {}
				panelID = PANEL_MENU;
				repaint();
			}
		}
		else if (panelID == PANEL_TILES)
		{
			//Grass button clicked
			if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 68 && e.getY() <= 112)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikigrass.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOTILES;
				repaint();
			}
			//Water button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 127 && e.getY() <= 169)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikiwater.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOTILES;
				repaint();
			}
			//Rock button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 184 && e.getY() <= 227)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikirock.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOTILES;
				repaint();
			}
			//Desert button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 240 && e.getY() <=279)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikidesert.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOTILES;
				repaint();
			}
			//Mountain button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 300 && e.getY() <= 341)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikimountain.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOTILES;
				repaint();
			}
			//Tree button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 359 && e.getY() <= 400)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikitree.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOTILES;
				repaint();
			}
			//Back button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 415 && e.getY() <= 459)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonmenu.png"));
				} catch (IOException e1) {}
				panelID = PANEL_MENU;
				repaint();
			}
		}
		else if (panelID == PANEL_WEATHER)
		{
			//Hail button clicked
			if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 68 && e.getY() <= 112)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikihail.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOWEATHER;
				repaint();
			}
			//Rain button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 127 && e.getY() <= 169)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikirain.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOWEATHER;
				repaint();
			}
			//Snow button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 184 && e.getY() <= 227)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikisnow.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOWEATHER;
				repaint();
			}
			//Sunny button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 240 && e.getY() <=279)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonback.png"));
				} catch (IOException e1) {}
				try
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikisunny.png"));
				} catch (IOException e1) {}
				panelID = PANEL_BACKTOWEATHER;
				repaint();
			}
			//Back button clicked
			else if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 300 && e.getY() <= 341)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonmenu.png"));
				} catch (IOException e1) {}
				panelID = PANEL_MENU;
				repaint();
			}
		}
		else if (panelID == PANEL_BACKTOSPECIES)
		{
			//Back button clicked
			if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 68 && e.getY() <= 112)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonspecies.png"));
				} catch (IOException e1) {}
				try 
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikimain.png"));
				} catch (IOException e1) {}
				panelID = PANEL_SPECIES;
				repaint();
			}
		}
		else if (panelID == PANEL_BACKTOTILES)
		{
			//Back button clicked
			if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 68 && e.getY() <= 112)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttontiles.png"));
				} catch (IOException e1) {}
				try 
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikimain.png"));
				} catch (IOException e1) {}
				panelID = PANEL_TILES;
				repaint();
			}
		}
		else if (panelID == PANEL_BACKTOWEATHER)
		{
			//Back button clicked
			if (e.getX() >= 59 && e.getX() <= 237 && e.getY() >= 68 && e.getY() <= 112)
			{
				try
				{
					buttonImg = ImageIO.read(new File ("src\\img\\wikibuttonweather.png"));
				} catch (IOException e1) {}
				try 
				{
					mainImg = ImageIO.read(new File ("src\\img\\wikimain.png"));
				} catch (IOException e1) {}
				panelID = PANEL_WEATHER;
				repaint();
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
