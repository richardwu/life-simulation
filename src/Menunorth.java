import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Menunorth extends JComponent implements MouseListener 
{
	private final int ID_MAP = 0;
	private final int ID_WIKI = 1;
	
	private BufferedImage img;
	private int panelID;
	private boolean isMap;
	
	//Constructor for the menubar at the top
	public Menunorth ()
	{
		try
		{
			img = ImageIO.read(new File ("src\\img\\menunorthmap.png"));
		} catch (IOException e) {}
		panelID = ID_MAP;
		isMap = true;
		
		setPreferredSize(new Dimension(1274, 56));
		addMouseListener(this);
	}
	
	public void paintComponent (Graphics g)
	{
		g.drawImage (img, 0, 0, null);
	}
	
	public boolean isMap ()
	{
		return isMap;
	}

	//Mouselistener for mouse clicks
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//Map tab
		if (panelID == ID_MAP)
		{
			//Wiki tab clicked
			if (e.getX() >= 140 && e.getX() <= 275 && e.getY() >= 0 && e.getY() <= 45)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menunorthwiki.png"));
				} catch (IOException e1) {}
				panelID = ID_WIKI;
				isMap = false;
				repaint();
			}
		}
		//Wiki tab
		else if (panelID == ID_WIKI)
		{
			//Map tab clicked
			if (e.getX() >= 0 && e.getX() <= 139 && e.getY() >= 0 && e.getY() <= 45)
			{
				try 
				{
					img = ImageIO.read(new File ("src\\img\\menunorthmap.png"));
				} catch (IOException e1) {}
				panelID = ID_MAP;
				isMap = true;
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
