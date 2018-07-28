//package BlusterCritter;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class BlusterCritterRunner {
	private BlusterCritterRunner() {
		
	}

	private static final int FOUR = 4;
	private static final int THREE = 3;
	private static final int FIVE = 5;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int EIGHT = 8;
	private static final int NINE = 9;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(THREE, FOUR), new BlusterCritter(3));
		world.add(new Location(ONE, FIVE), new Rock(Color.black));
		world.add(new Location(TWO, FOUR), new BlusterCritter(3));
		world.add(new Location(EIGHT, FOUR), new BlusterCritter(3));
		world.add(new Location(FIVE, NINE), new BlusterCritter(3));
		world.add(new Location(FOUR, NINE), new BlusterCritter(3));
		world.add(new Location(ONE, THREE), new BlusterCritter(3));
		world.show();
	}

}
