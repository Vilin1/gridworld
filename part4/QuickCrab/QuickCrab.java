//package QuickCrab;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class QuickCrab extends CrabCritter{
	/**
     * @return list of empty locations immediately to the right and to the left
     */
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        locs = getLocationsInDirections(dirs);
        if(locs.size() == 0) {
        	return super.getMoveLocations();
        } else {
        	return locs;
        }
    }
	
	/**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        
        for (int d : directions)
        {
            Location neighbor1 = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighbor1)&&gr.get(neighbor1) == null) {
            	Location neighbor2 = neighbor1.getAdjacentLocation(getDirection()+d);
            	if (gr.isValid(neighbor2)&&gr.get(neighbor2) == null) {
            		locs.add(neighbor2);
            	}
            }
        }
        return locs;
    } 
}



