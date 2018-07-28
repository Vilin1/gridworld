//package ChameleonKid;


import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class ChameleonKid extends ModifiedChameleonCritter{
	//get actor in ahead or behind
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> frontAndBehindActor = new ArrayList<Actor>();
        int []targetDirection = {Location.AHEAD, Location.HALF_CIRCLE};
        for(int i : targetDirection) {
            //get actor from this two direction
        	Location loc = getLocation().getAdjacentLocation(getDirection() + i);
        	if(getGrid().isValid(loc)) {
        		Actor actor = getGrid().get(loc);
        		if(actor != null) {
        			frontAndBehindActor.add(actor);

        		}
        	}
        }
        //return
        return frontAndBehindActor;
    }
}



