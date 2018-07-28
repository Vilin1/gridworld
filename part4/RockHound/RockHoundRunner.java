//package RockHound;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class RockHoundRunner {
	private RockHoundRunner() {
		
	}
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FIVE = 5;
	private static final int SIX = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(FIVE, FIVE), new RockHound());
		world.add(new Location(THREE, THREE), new Rock());
		world.add(new Location(SIX, SIX), new Rock());
		world.add(new Location(SIX, TWO), new Rock());
		world.add(new Location(1, SIX), new Rock());
		world.show();
	}

}
