//package ModifiedChameleonCritter;

import java.awt.Color;
import java.util.ArrayList;


import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class ModifiedChameleonCritter extends Critter{
	//the color will darken to 
	private static final double DARKENTO = 0.9;

	public ModifiedChameleonCritter(Color c) {
		setColor(c);
	}
	
	//if 0 actor near, darken, else one of neighber change color
	public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
        	darken();
        	return;
        }
        int r = (int) (Math.random() * n);

        Actor other = actors.get(r);
        setColor(other.getColor());
    }
	
	//move acording to super class
	public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
	
	//get darken
	public void darken() {
		Color color = getColor();
		int green = (int)(color.getGreen()*DARKENTO);
		int red = (int)(color.getRed()*DARKENTO);
		int blue = (int)(color.getBlue()*DARKENTO);
		setColor(new Color(red, green, blue));
	}
}
