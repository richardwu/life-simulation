
import java.io.IOException;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * COPYRIGHT 2014
 * 
 *------------------------------------------------
 *
 * ICS4U1 LIFE SIMULATION SUMMATIVE
 * TEACHER: MR JAY
 * SCHOOL: MARC GARNEAU COLLEGIATE INSTITUTE
 * DATE: THURSDAY JANUARY 23 2014	
 * TIME: 16:27:40PM
 * 
 * 
 * LEAD PROGRAMMER: 
 * RICHARD WU
 * 
 * PROGRAMMER(S): 
 * PETER FENG
 * 
 * GRAPHICS & IMAGES: 
 * NICHOLAS BLAKE
 * PETER FENG
 * GABRIEL IP
 * 
 * DOCUMENTATION:
 * GABRIEL IP
 *
 */

public class Module
{
	private final int WINDOW_WIDTH = 1282;
	private final int WINDOW_HEIGHT = 759;
	private final int DURATION_HAIL = 2;
	private final int DURATION_SNOW = 4;
	private final int DURATION_RAIN = 7;
	private final int DURATION_SUNNY = 2;
	
	private JComponent currentComponent; 
	private Map map;
	private Wiki wiki;
	private Weather weather;
	private Menunorth menunorth;
	private Menusouth menusouth;
	private Menuwest menuwest;
	private Menueast menueast;
	private ImageIcon img;
	
	private int weatherDuration = 0;
	private boolean isNewWeather = true;
	
	public static void main (String [] args)
	{
		Module module = new Module ();	
	}
	
	public Module ()
	{
		//Constructs the necessary components for the GUI
		try {
			map = new Map ();
		} catch (IOException e1) {}
		
		wiki = new Wiki ();
	
		currentComponent = map; 
		
		menunorth = new Menunorth ();
		menusouth = new Menusouth ();
		
		menuwest = new Menuwest ();
		menueast = new Menueast ();
		
		img = new ImageIcon("src\\img\\species7sidebar.png");
	
		JFrame window = new JFrame ();
		
		//Layouts, ecetera
		JPanel content = new JPanel ();
		content.setLayout(new BoxLayout (content, BoxLayout.PAGE_AXIS));
		
		JPanel middlePane = new JPanel ();
		middlePane.setLayout(new BoxLayout (middlePane, BoxLayout.X_AXIS));
		
		middlePane.add(menuwest);
		middlePane.add(currentComponent);
		middlePane.add(menueast);
		
		content.add(menunorth);
		content.add(middlePane);
		content.add(menusouth);

		window.add(content);
	
		//JFrame additions
		window.setIconImage (img.getImage());
		window.setTitle("Life Simulation: Nogard Edition!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		Random rand = new Random ();

		//Thread loop
		while (true)
		{
			//If user decides to clear selection
			if (menueast.isClearLifeform())
			{
				menueast.setIsClearLifeform(false);
				map.clearLifeform(menueast.getLifeform());
				currentComponent.repaint();
			}
			
			//If user decides to delete selected lifeform
			if (menueast.isDeleteLifeform())
			{
				menueast.setIsDeleteLifeform(false);
				map.removeLifeform(menueast.getLifeform());
				currentComponent.repaint();
			}
			
			//If user selects a lifeform
			if (map.getLifeformSelected() != null && menueast.getLifeform() != map.getLifeformSelected())
			{
				menueast.setLifeform(map.getLifeformSelected());
				menueast.repaint();
			}
			//If lifeform dies or disappears somewhere
			else if (map.getLifeformSelected() == null && menueast.getLifeform() != null)
			{
				menueast.setLifeform(null);
				menueast.repaint();
			}
			
			//Changes component to wiki if user clicks wiki tab
			if (currentComponent == map && menunorth.isMap() == false)
			{
				middlePane.remove(menuwest);
				middlePane.remove(currentComponent);
				middlePane.remove(menueast);
				currentComponent = wiki;
				middlePane.add(menuwest);
				middlePane.add(currentComponent);
				middlePane.add(menueast);
				middlePane.revalidate();
				middlePane.repaint();
			}
			//Changes component to map if user clicks map tab
			else if (currentComponent == wiki && menunorth.isMap() == true)
			{
				middlePane.remove(menuwest);
				middlePane.remove(currentComponent);
				middlePane.remove(menueast);
				currentComponent = map;
				middlePane.add(menuwest);
				middlePane.add(currentComponent);
				middlePane.add(menueast);
				middlePane.revalidate();
				middlePane.repaint();
			}
			
			//If user decides to spawn a lifeform
			if (menusouth.makeLifeform())
			{
				menusouth.setMakeLifeform(false);
				map.newLifeform(menusouth.getLifeformSpecies(), rand.nextInt(2));
				currentComponent.repaint();
			}
		
			//If user begins looping process, does necessary operations
			if (menusouth.loop())
			{
				elapse ();
				menunorth.repaint();
				menusouth.repaint();
				currentComponent.repaint();
				menuwest.repaint();
				menueast.repaint();

				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {}
			}
		}
	}
	
	//Generates a weather randomly
	public void weatherGenerator ()
	{
		int rng;
		
		//If duration of weather is 0, sets boolean to true to generate new weather
		if (weatherDuration == 0)
			isNewWeather = true;
		
		//Generates new weather
		if (isNewWeather)
		{
			Random rand = new Random();
			rng = rand.nextInt(100) + 1;
			
			//If statements = percentage check; generates type of weather according to rng
			if (rng <= 10)
			{
				int duration = rand.nextInt(DURATION_HAIL) + 1;
				int severity = rand.nextInt(100) + 1;
				weather = new Hail (duration, severity);
				weatherDuration = duration;
				isNewWeather = false;
			}
			else if (rng <= 25)
			{
				int duration = rand.nextInt(DURATION_SNOW) + 1;
				int severity = rand.nextInt(100) + 1;
				weather = new Snow (duration, severity);
				weatherDuration = duration;
				isNewWeather = false;
			}
			else if (rng <= 50)
			{
				int duration = rand.nextInt(DURATION_RAIN) + 1;
				int severity = rand.nextInt(100) + 1;
				weather = new Rain (duration, severity);
				weatherDuration = duration;
				isNewWeather = false;
			}
			else
			{
				int duration = rand.nextInt(DURATION_SUNNY) + 1;
				int severity = rand.nextInt(100) + 1;
				weather = new Sunny (duration, severity);
				weatherDuration = duration;
				isNewWeather = false;
			}
			
			menusouth.setWeather(weather.getType());
		}
		else
			weatherDuration--;
	}
	
	//Elapse method to elapse weatherGenerator as well as the map
	public void elapse ()
	{
		weatherGenerator ();
		map.elapse(weather);
	}
}