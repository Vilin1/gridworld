//package QuickCrab;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class QuickCrabRunner {
	private QuickCrabRunner() {
		
	}
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int SEVEN = 7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(FIVE, FIVE), new QuickCrab());
		world.add(new Location(FIVE, THREE), new Rock());
		world.add(new Location(FIVE, SEVEN), new Flower());
		world.add(new Location(SIX, SIX), new Rock());
		world.add(new Location(TWO, TWO), new Rock());
		world.show();
	}

}
