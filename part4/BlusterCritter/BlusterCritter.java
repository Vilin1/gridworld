//package BlusterCritter;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter{
	//count the number of critter
	private int count;
	//the number color would change
	private static final int COLORCHANGE = 10;
	private static final int UPPER = 255;
	private static final int LOWER = 0;
	

	public BlusterCritter(int c) {
		count = c;
	}
	
	//get all 24 location
	//porcondition valid
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> targetActor = new ArrayList<Actor>();
		Grid<Actor> grid = getGrid();
        Location current = getLocation();
        int row = current.getRow();
        int col = current.getCol();
        for(int i = row-2; i <= row+2; i++) {
        	for(int j = col-2; j <= col+2; j++) {
        		Location tempLocation = new Location(i, j);
        		//check 24 grids and add actor
        		if(grid.isValid(tempLocation)&&grid.get(tempLocation) != null&&grid.get(tempLocation)!=this) {
        			targetActor.add(grid.get(tempLocation));
        		}	
        	}
        }
        return targetActor;
    }


	//count the number of the Critter
	public void processActors(ArrayList<Actor> actors) {
		int numOfCritter = 0;
        for (Actor a : actors) {
            if (a instanceof Critter) {
            	numOfCritter++;
            }
        }
        //call to change color
        changeColor(numOfCritter);
    }
	
	//the function to change the change
	//if the color out of rank, dont's change
	public void changeColor(int num) {
		Color color = getColor();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		if(num < count) {
			//check if in the range
			if(red + COLORCHANGE < UPPER ) {
				red += COLORCHANGE;
			}
			if(green + COLORCHANGE < UPPER ) {
				green += COLORCHANGE;
			}
			if(blue + COLORCHANGE < UPPER ) {
				blue += COLORCHANGE;
			}
		} else {
			if(red - COLORCHANGE > LOWER) {
				red -= COLORCHANGE;
			}
			if(green - COLORCHANGE > LOWER) {
				green -= COLORCHANGE;
			}
			if(blue - COLORCHANGE > LOWER) {
				blue -= COLORCHANGE;
			}
		}
		//legal and set
		setColor(new Color(red, green, blue));
	}
}
