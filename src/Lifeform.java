import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Lifeform
{
	
	protected final String [] speciesList ={"Lezag", "Raeb", "Yeso", "Krah", "Otuq", "Iekom", "Nogard"};
	protected static final int SPECIES_ONE = 0;
	protected static final int SPECIES_TWO = 1;
	protected static final int SPECIES_THREE = 2;
	protected static final int SPECIES_FOUR = 3;
	protected static final int SPECIES_FIVE = 4;
	protected static final int SPECIES_SIX = 5;
	protected static final int SPECIES_SEVEN = 6;
	
	protected final String [] typeList = {"Carnivore", "Herbivore", "Omnivore"};
	protected static final int TYPE_CARNIVORE = 0;
	protected static final int TYPE_HERBIVORE = 1;
	protected static final int TYPE_OMNIVORE = 2;
	
	protected static final boolean FLYING_TRUE = true;
	protected static final boolean FLYING_FALSE = false;
	protected static final boolean WATER_TRUE = true;
	protected static final boolean WATER_FALSE = false;
	
	protected final int MAP_WIDTH = 30;
	protected final int MAP_HEIGHT = 20;
	protected final int TILE_SIZE = 30;
	protected final int GENDER_MALE = 0;
	protected final int GENDER_FEMALE = 1;
	
	protected int hunger, gender, x, y, species, type, id; 
	protected BufferedImage img;
	protected boolean isFlying, isWater, isSelected;


	//Constructor for the lifeforms of the game
	public Lifeform (int x, int y, int gender, int species, int type, boolean isFlying, boolean isWater, int id)
	{
		hunger = 75;
		this.gender = gender;
		this.x = x;
		this.y = y;
		this.species = species;
		this.type = type;
		this.isFlying = isFlying;
		this.isWater = isWater;
		isSelected = false;
		this.id = id;
		
		try
		{
			img = ImageIO.read (new File ("src\\img\\species" + (species + 1) + ".png"));
		} catch (IOException e) {}
	}
	
	public void draw (Graphics g)
	{
		//Offset for select glow
		if (isSelected)
			g.drawImage(img, x * TILE_SIZE - 1, y * TILE_SIZE - 1, null);
		else
			g.drawImage(img, x * TILE_SIZE, y * TILE_SIZE, null);
	}	
	
	//Reproduce method
	public boolean reproduce (Lifeform lifeformB)
	{
		Random rand = new Random();

		//Checks if opposite gender and if both hunger levels is above 60
		if (gender != lifeformB.getGender() && hunger >= 60 && lifeformB.getHunger() >= 60)	    
			return rand.nextInt(100) + 1 < 20;
		else 
			return false;
	}
	
	//Movement method (generates random movement)
	public void move ()
	{
		//Generates a random # of iterations
		Random rand = new Random ();
		int iterations = rand.nextInt(8) + 1;
	
		for (int i = 1; i <= iterations; i++)
		{
			//Generates random direction and magnitude
			int direction = rand.nextInt(4) + 1;
			int magnitude = rand.nextInt(3) + 1;

			if (direction == 1 && y - magnitude >= 0)
				y -= magnitude;
			else if (direction == 2 && y + magnitude < MAP_HEIGHT)
				y += magnitude;
			else if (direction == 3 && x - magnitude >= 0)
				x -= magnitude;
			else if (direction == 4 && x + magnitude < MAP_WIDTH)
				x += magnitude;
		}
	}
	
	//Eat method (adjusts hunger level based on food)
	public void eat (boolean food, boolean animalEaten)
	{
		//If there is food, increases hunger level accordingly; else decreases
		if (food)
		{
			if (species == TYPE_HERBIVORE || species == TYPE_OMNIVORE)
			{
				if (hunger <= 90)
					hunger += 10;
				else
					hunger = 100;
			}
			
			if (animalEaten)
			{
				if (hunger <= 50)
					hunger += 50;
				else
					hunger = 100;
			}
		}
		else
		{
			if (species == TYPE_CARNIVORE)
			{
				if (hunger >= 5)
					hunger -= 5;
				else
					hunger = 0;
			}
			else
			{
				if (hunger >= 10)
					hunger -= 10;
				else
					hunger = 0;
			}
		}
	}
	
	public int getType ()
	{
		return type;
	}
	
	public int getSpecies()
	{
		return species;
	}
	
	public int getHunger ()
	{
		return hunger;
	}
	
	public int getGender ()
	{
		return gender;
	}
	
	public int getX ()
	{
		return x;
	}
	
	public int getY ()
	{
		return y;
	}
	
	public String[] getSpeciesList ()
	{
		return speciesList;
	}
	
	public boolean isFlying ()
	{
		return isFlying;
	}
	
	public boolean isWater ()
	{
		return isWater;
	}
	
	public boolean isSelected ()
	{
		return isSelected;
	}
	
	//Changes images to show the lifeform is selected
	public void setIsSelected (boolean isSelected)
	{
		try
		{
		if (isSelected)
			img = ImageIO.read(new File ("src\\img\\species" + (species + 1) + "selected.png"));
		else
			img = ImageIO.read(new File ("src\\img\\species" + (species + 1) + ".png"));
		}catch(IOException e) {}
		
		this.isSelected = isSelected; 
	}
	
	public String[] getTypeList ()
	{
		return typeList;
	}
	
	public void setImg (BufferedImage img)
	{
		this.img = img;
	}

	public int getId ()
	{
		return id;
	}
	
	public void setId (int id)
	{
		this.id = id;
	}
}
