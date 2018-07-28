//package KingCrab;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class KingCrabRunner {
	private KingCrabRunner() {
		
	}
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int SEVEN = 7;
	private static final int ONE = 1;
	private static final int FOUR = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
	    world.add(new Location(SIX, FIVE), new Rock());
	    world.add(new Location(FIVE, FOUR), new Rock());
	    world.add(new Location(TWO, ONE), new Rock());
	    world.add(new Location(SEVEN, FOUR), new Rock());
	    world.add(new Location(SEVEN, ONE), new Flower());
	    world.add(new Location(TWO, TWO), new Flower());
	    world.add(new Location(THREE, FIVE), new Flower());
	    world.add(new Location(SIX, SIX), new Bug());
	    world.add(new Location(FOUR, FOUR), new KingCrab());
	    world.add(new Location(FIVE, ONE), new KingCrab());
	    world.show();
	}

}
