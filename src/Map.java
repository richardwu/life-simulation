import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Map extends JComponent implements MouseListener
{
	private final int TILE_SIZE = 30;
	private final int MAP_WIDTH = 30;
	private final int MAP_HEIGHT = 20;

	private Tile [][] tiles;
	private ArrayList <Lifeform> lifeforms = new ArrayList <Lifeform> ();
	private Lifeform lifeformSelected;
	private int idCount;
	
	public Map () throws IOException
	{
		/*
		 * DO NOT PUT ANY CODE BEFORE THIS SECTION (SINCE TILES ARE BEING READ IN THE CODE BELOW!)
		 */
		
		//READS TILE TYPE FROM A TEXT DOCUMENT AND ADDS IT TO THE ARRAY OF TILES
		FileReader file = null;
		try
		{
			file = new FileReader("src\\defaultmap.txt");
		} catch (FileNotFoundException e) {}
		BufferedReader reader = new BufferedReader(file);

		tiles = new Tile [MAP_HEIGHT][MAP_WIDTH];

		//Loops through .txt file to read tile type IDs
		for (int i = 0; i < MAP_WIDTH; i++)
		{
			String str = null;
			try 
			{
				str = reader.readLine();
			} catch (IOException e) {}

			for (int j = 0; j < MAP_HEIGHT; j++)
			{
				int temp = 0;

				temp = str.charAt(j) - '0';

				//Uses the character read to construct corresponding tile
				if (temp == tiles[0][0].TYPE_GRASS)
					tiles[j][i] = new GrassTile(i,j);
				else if (temp == tiles[0][0].TYPE_WATER)
					tiles[j][i] = new WaterTile(i,j);
				else if (temp == tiles[0][0].TYPE_ROCK)
					tiles[j][i] = new RockTile(i,j);
				else if (temp == tiles[0][0].TYPE_DESERT)
					tiles[j][i] = new DesertTile(i,j);
				else if (temp == tiles[0][0].TYPE_MOUNTAIN)
					tiles[j][i] = new MountainTile(i,j);
				else
					tiles[j][i] = new TreeTile(i,j);
			}
		}
		
		/*
		 * PUT CODE BEYOND THIS POINT
		 */
		
		idCount = 0;
		
		//Testing purposes
		
/*		for (int i = 1; i <=480; i++)
			newLifeform (2, 0);*/
		
/*		for (int i = 1; i <= 10; i++)
		{
			for (int j = 1; j <= 2; j++)
			{
				newLifeform(0,0);
				newLifeform(3,0);
				newLifeform(5,0);
			}
			newLifeform(1,0);
			newLifeform(2,0);
			newLifeform(4,0);
			newLifeform(6,0);
		}*/
		
		newLifeform(6,0);
		
		lifeformSelected = null;
		
		setPreferredSize(new Dimension (900, 600));
		addMouseListener(this);
	}
	
	//Draws the map (tiles and lifeforms)
	public void paintComponent (Graphics g)
	{       
		// Draws the tiles of the map
		for (int i = 0; i < MAP_HEIGHT; i++)
		{
			for (int j = 0; j < MAP_WIDTH; j++)
				tiles[i][j].draw(g);
		}

		// Draws the lifeforms in their current positions
		for (int i = 0; i < lifeforms.size(); i++)
			lifeforms.get(i).draw(g);
	}

	//Finds lifeform 
	public Lifeform lifeformCheck (int x, int y, int radius)
	{
		//Finds and saves positions of lifeforms in boolean array
		Lifeform [][] positions = new Lifeform [MAP_HEIGHT][MAP_WIDTH];
		
		for (int i = 0; i < lifeforms.size(); i++)
			positions[lifeforms.get(i).getY()][lifeforms.get(i).getX()] = lifeforms.get(i);
		
		//Checks surrounding block for lifeform
		
		//Establishes x and y coordinates for check array
		int startX, endX, startY, endY;
		
		if (x - radius < 0)
			startX = 0;
		else
			startX = x - radius;
		if (x + radius > MAP_WIDTH - 1)
			endX = MAP_WIDTH - 1;
		else
			endX = x + radius;
		
		if (y - radius < 0)
			startY = 0;
		else
			startY = y - radius;
		if (y + radius > MAP_HEIGHT - 1)
			endY = MAP_HEIGHT - 1;
		else 
			endY = y + radius;
		
		//Sets position of invoked lifeform to false (doesn't check itself)
		positions[y][x] = null;
		
		for (int i = startX; i <= endX; i++)
		{
			for (int j = startY; j <= endY; j++)
			{
				if (positions[j][i] != null)
					return positions[j][i];
			}
		}
		return null;
	}
	
	//Checks for TILE within radius
	public Tile tileCheck (int x, int y, int radius, int tileType)
	{
		//Finds and saves positions of lifeforms in boolean array
		Tile [][] positions = new Tile [MAP_HEIGHT][MAP_WIDTH];
		
		for (int i = 0; i < tiles.length; i++)
		{
			for (int j = 0; j < tiles[i].length; j++)
			{
				if (tiles[i][j].getType() == tileType)
					positions[tiles[i][j].getY()][tiles[i][j].getX()] = tiles[i][j];
			}
		}
		
		//Checks surrounding block for lifeform
		
		//Establishes x and y coordinates for check array
		int startX, endX, startY, endY;
		
		if (x - radius < 0)
			startX = 0;
		else
			startX = x - radius;
		if (x + radius > MAP_WIDTH - 1)
			endX = MAP_WIDTH - 1;
		else
			endX = x + radius;
		
		if (y - radius < 0)
			startY = 0;
		else
			startY = y - radius;
		if (y + radius > MAP_HEIGHT - 1)
			endY = MAP_HEIGHT - 1;
		else 
			endY = y + radius;
		
		//Sets position of invoked lifeform to false (doesn't check itself)
		positions[y][x] = null;
		
		for (int i = startX; i <= endX; i++)
		{
			for (int j = startY; j <= endY; j++)
			{
				if (positions[j][i] != null)
					return positions[j][i];
			}
		}
		return null;
	}
	
	//Runs necessary functions to progress tiles and lifeforms by 1 turn
	public void elapse (Weather weather)
	{
		//Elapses tiles
		for (int i = 0; i < MAP_HEIGHT; i++)
		{
			for (int j = 0; j < MAP_WIDTH; j++)
			{
				boolean isAdjacentOccupied = false;
				
				//Elapses water tiles based on weather and neighbouring lifeforms
				if (tiles[i][j].getType() == tiles[i][j].TYPE_WATER)
				{
					if (lifeformCheck (j, i, 2) != null)
						isAdjacentOccupied = true;
					else
						isAdjacentOccupied = false;
					((WaterTile) tiles[i][j]).elapse(weather, isAdjacentOccupied);
				}
				//Elapses grass tiles based on weather and neighbouring lifeforms
				else if (tiles[i][j].getType() == tiles[i][j].TYPE_GRASS)
				{
					Lifeform occupied = lifeformCheck(j,i,1);
					if (occupied != null)
						isAdjacentOccupied = true;
					else
						isAdjacentOccupied = false;
					((GrassTile) tiles[i][j]).elapse(weather, isAdjacentOccupied, occupied);
				}
			}
		}
		
		//Lifeform movement,reproduction, and eating
		for (int i = 0; i < lifeforms.size(); i++)
		{

			//Lifeform dies if it's at 0 hunger level
			if (lifeforms.get(i).getHunger() == 0)
			{
				if (lifeformSelected != null && lifeforms.get(i).getId() == lifeformSelected.getId())
					lifeformSelected = null;
				lifeforms.remove(i);
			}
			else
			{
				
				
				//Movement
				
				
				
				//Sets beginning tile occupied status as false (since it's about to move)
				tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].isOccupied = false;
				tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].setOccupiedLifeform(null);

				//Flying creatures only account for occupied tiles
				if (lifeforms.get(i).isFlying())
				{
					do
						lifeforms.get(i).move();
					while (tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].isOccupied());

				}
				//Swimming creatures only account for occupied tiles and obstacle tiles other than water tiles
				else if (lifeforms.get(i).isWater())
				{
					do
						lifeforms.get(i).move();
					while (tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].isOccupied() || tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].getType() == tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].TYPE_TREE || tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].getType() == tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].TYPE_MOUNTAIN);
				}
				//Land creatures account for occupied and obstacle tiles
				else
				{
					do
						lifeforms.get(i).move();
					while(tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].isObstacle() || tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].isOccupied());
				}
				//Sets new position tile occupied status as true
				tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].setIsOccupied(true);
				tiles[lifeforms.get(i).getY()][lifeforms.get(i).getX()].setOccupiedLifeform(lifeforms.get(i));

				//Reproduce
				Random rand = new Random();
				Lifeform mateLifeform = lifeformCheck(lifeforms.get(i).getX(), lifeforms.get(i).getY(), 2); 
				if (mateLifeform != null && lifeforms.get(i).reproduce(mateLifeform))
					offspring (lifeforms.get(i), lifeforms.get(i).getSpecies(), rand.nextInt(2));

				
				
				//Food/eating
				
				
				
				boolean food = false;
				//Grass eating for herbivores and omnivores
				if (lifeforms.get(i).getType() == lifeforms.get(i).TYPE_HERBIVORE || lifeforms.get(i).getType() == lifeforms.get(i).TYPE_OMNIVORE)
				{
					//Checks if nearby grass tile in respect to lifeform
					GrassTile grassTile = (GrassTile) tileCheck(lifeforms.get(i).getX(), lifeforms.get(i).getY(), 1, tiles[0][0].TYPE_GRASS);
					
					//Verifies if grasstile exists and the condition is AT LEAST 30 = food; else no food
					if (grassTile != null && grassTile.getCondition() >= 30)
					{
							food = true;
							lifeforms.get(i).eat(food, false);
					}
					else
					{
						if (lifeforms.get(i).getType() == lifeforms.get(i).TYPE_HERBIVORE)
						{
							food = false;
							lifeforms.get(i).eat(food, false);
						}
					}
				}

				//Animal eating for carnivores and omnivores
				boolean animalKilled = false;
				if (lifeforms.get(i).getType() == lifeforms.get(i).TYPE_CARNIVORE || lifeforms.get(i).getType() == lifeforms.get(i).TYPE_OMNIVORE)
				{
					//Checks if nearby lifeform to be eaten
					Lifeform neighbour = lifeformCheck(lifeforms.get(i).getX(), lifeforms.get(i).getY(), 1);
					if (neighbour != null && neighbour.getSpecies() != lifeforms.get(i).getSpecies())
					{
						boolean chance = false;
						
						//Generates random number and assigns chance boolean if percentage matches
						if (lifeforms.get(i).getSpecies() == lifeforms.get(i).SPECIES_TWO)
							chance = rand.nextInt(100) + 1 < 90;
						else if (lifeforms.get(i).getSpecies() == lifeforms.get(i).SPECIES_THREE)
							chance = rand.nextInt(100) + 1 < 20;
						else if (lifeforms.get(i).getSpecies() == lifeforms.get(i).SPECIES_FIVE)
							chance = rand.nextInt(100) + 1 < 80;
						else if (lifeforms.get(i).getSpecies() == lifeforms.get(i).SPECIES_SEVEN)
							chance = rand.nextInt(100) + 1 < 95;
						
						//If animal wins rng
						if (chance)
						{
							food = true;
							animalKilled = true;
							lifeforms.get(i).eat(food, animalKilled);
							//Deletes animal from system
							for (int j = 0; j < lifeforms.size(); j++)
							{
								if (lifeformSelected != null && neighbour.getId() == lifeformSelected.getId())
									lifeformSelected = null;
								if (lifeforms.get(j).getId() == neighbour.getId())
									lifeforms.remove(lifeforms.get(j));
							}
						}
						else
						{
							//If herbivores before previously did not get any food either
							if (food != true)
								lifeforms.get(i).eat(food, false);
						}
					}
					else
					{
						//If herbivores before previously did not get any food either
						if (food != true)
							lifeforms.get(i).eat(food, false);
					}
				}
				/*
				 * NO CODE BEYOND THIS POINT B/C OBJECT REMOVED FROM ARRAY!
				 */
			}
		}
		
		//IMPORTANT!: RANDOMLY GENERATES LIFEFORMS ON RANDOM TURNS - DISABLE IF YOU WANT NO EXTERIOR INFLUENCES---------------------
		
		Random rand = new Random ();
		if (rand.nextInt (100) + 1 < 40)
		{
			for (int i = 1; i <= rand.nextInt(3)+1; i++)
			{
				newLifeform (rand.nextInt(7), rand.nextInt(2));
			}
		}
	}
	
	//Method to generate a new lifeform
	public void newLifeform (int species, int gender)
	{
		//Only generates if there's enough room on the map
		if (lifeforms.size() < 481)
		{
			Random rand = new Random();
			int x, y;
			
			//Assigns a random, unoccupied/non-obstacular tile
			do
			{
				x = rand.nextInt(MAP_WIDTH);
				y = rand.nextInt(MAP_HEIGHT);
			}
			while (tiles[y][x].isOccupied() || tiles[y][x].isObstacle());

			idCount++;

			//Invokes corresponding constructor based on species
			if (species == 0)
				lifeforms.add(new Lifeform1(x, y, gender, idCount));
			else if (species == 1)
				lifeforms.add(new Lifeform2(x, y, gender, idCount));
			else if (species == 2)
				lifeforms.add(new Lifeform3(x, y, gender, idCount));
			else if (species == 3)
				lifeforms.add(new Lifeform4(x, y, gender, idCount));
			else if (species == 4)
				lifeforms.add(new Lifeform5(x, y, gender, idCount));
			else if (species == 5)
				lifeforms.add(new Lifeform6(x, y, gender, idCount));
			else
				lifeforms.add(new Lifeform7(x, y, gender, idCount));

			tiles[y][x].setIsOccupied(true);
			tiles[y][x].setOccupiedLifeform(lifeforms.get(lifeforms.size()-1));
		}
	}
	
	//Generate offspring close to the invoked lifeform
	public void offspring (Lifeform lifeform, int species, int gender)
	{
		if (lifeforms.size() < 481)
		{
			Random rand = new Random();
			int startX, endX, startY, endY, x, y, newX, newY;
			int radius = 5;

			x = lifeform.getX();
			y = lifeform.getY();

			//Finds start/end X/Y within radius
			if (x - radius < 0)
				startX = 0;
			else
				startX = x - radius;
			if (x + radius > MAP_WIDTH - 1)
				endX = MAP_WIDTH - 1;
			else
				endX = x + radius;

			if (y - radius < 0)
				startY = 0;
			else
				startY = y - radius;
			if (y + radius > MAP_HEIGHT - 1)
				endY = MAP_HEIGHT - 1;
			else 
				endY = y + radius;

			//Randomly generates the new position, with type matching
			//(see previous comments about generating lifeforms)
			if (lifeform.isFlying())
			{
				do
				{
					newX = rand.nextInt(endX - startX + 1) + startX;
					newY = rand.nextInt(endY - startY + 1) + startY;
				}
				while (tiles[newY][newX].isOccupied());
			}
			else if (lifeform.isWater())
			{
				do
				{
					newX = rand.nextInt(endX - startX + 1) + startX;
					newY = rand.nextInt(endY - startY + 1) + startY;
				}
				while (tiles[newY][newX].isOccupied() || tiles[newY][newX].getType() == tiles[newY][newX].TYPE_MOUNTAIN || tiles[newY][newX].getType() == tiles[newY][newX].TYPE_TREE);
			}
			else
			{
				do
				{
					newX = rand.nextInt(endX - startX + 1) + startX;
					newY = rand.nextInt(endY - startY + 1) + startY;
				}
				while (tiles[newY][newX].isOccupied() || tiles[newY][newX].isObstacle());
			}

			idCount++;

			//Once coordinates found, invokes appropriate constructor
			if (species == 0)
				lifeforms.add(new Lifeform1(x, y, gender, idCount));
			else if (species == 1)
				lifeforms.add(new Lifeform2(x, y, gender, idCount));
			else if (species == 2)
				lifeforms.add(new Lifeform3(x, y, gender, idCount));
			else if (species == 3)
				lifeforms.add(new Lifeform4(x, y, gender, idCount));
			else if (species == 4)
				lifeforms.add(new Lifeform5(x, y, gender, idCount));
			else if (species == 5)
				lifeforms.add(new Lifeform6(x, y, gender, idCount));
			else
				lifeforms.add(new Lifeform7(x, y, gender, idCount));

			tiles[y][x].setIsOccupied(true);
			tiles[y][x].setOccupiedLifeform(lifeforms.get(lifeforms.size()-1));
		}
	}
	
	//Removes the requested lifeform from map (based on ID)
	public void removeLifeform (Lifeform lifeform)
	{
		for (int i = 0; i < lifeforms.size(); i++)
		{
			if (lifeform.getId() == lifeforms.get(i).getId())
				lifeforms.remove(i);
		}
		lifeformSelected = null;
	}
	
	public Lifeform getLifeformSelected ()
	{
		return lifeformSelected;
	}
	
	//Clears the selection of the lifeform
	public void clearLifeform (Lifeform lifeform)
	{
		for (int i = 0; i < lifeforms.size(); i++)
		{
			if (lifeform.getId() == lifeforms.get(i).getId())
				lifeforms.get(i).setIsSelected(false);
		}
		lifeformSelected = null;
	}
	
	public int getIdCount ()
	{
		return idCount;
	}
	
	public void setIdCount (int idCount)
	{
		this.idCount = idCount;
	}

	//Mouselistener for mouseclicks
	@Override
	public void mouseClicked(MouseEvent e) 
	{	
		//Finds lifeform potentially clicked on
		Lifeform lifeform = null;
		for (int i = 0; i < lifeforms.size(); i++)
		{
			if (e.getX() >= lifeforms.get(i).getX() * TILE_SIZE && e.getX() <= (lifeforms.get(i).getX() + 1) * TILE_SIZE && e.getY() >= lifeforms.get(i).getY() * TILE_SIZE && e.getY() <= (lifeforms.get(i).getY() + 1) * TILE_SIZE)
			{
				lifeform = lifeforms.get(i);
				break;
			}
		}
		
		//Sees if there are none selected already
		boolean noneSelected = true;
		for (int i = 0; i < lifeforms.size(); i++)
		{
			if (lifeforms.get(i).isSelected() && lifeforms.get(i) != lifeform)
			{
				noneSelected = false;
				break;
			}
		}
		
		//If no other lifeform is selected 
		if (lifeform != null && noneSelected)
		{
			if (lifeform.isSelected() == false)
			{
				lifeformSelected = lifeform;
				lifeform.setIsSelected(true);
				repaint();
			}
			else
			{
				lifeformSelected = null;
				lifeform.setIsSelected(false);
				repaint();
			}
		}
	}


	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{

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
