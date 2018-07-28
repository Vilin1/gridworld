//package KingCrab;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class KingCrab extends CrabCritter{
    //all neighber actor move forward
	public void processActors(ArrayList<Actor> actors)
    {
		Grid<Actor> grid = getGrid();
        for (Actor a : actors)
        {
            Location target = a.getLocation().getAdjacentLocation(getDirection() + Location.AHEAD);
            if(grid.isValid(target)) {
            	a.moveTo(target);
            } else {
            	a.removeSelfFromGrid();
            }
        }
    }
}
