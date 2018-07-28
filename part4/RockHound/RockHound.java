//package RockHound;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;

public class RockHound extends Critter{
	//get all actor is not critter
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
        	//judge if is a Rock
            if (a instanceof Rock) {
            	//else remove from grid
                a.removeSelfFromGrid();
            }
        }
    }
}
