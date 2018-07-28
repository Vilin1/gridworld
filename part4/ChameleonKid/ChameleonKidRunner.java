//package ChameleonKid;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class ChameleonKidRunner {
	private ChameleonKidRunner() {

	}
	private static final int FOUR = 4;
	private static final int THREE = 3;
	private static final int FIVE = 5;
	private static final int ONE = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(FOUR, FOUR), new ChameleonKid());
		world.add(new Location(THREE, FOUR), new Rock(Color.black));
		world.add(new Location(FIVE, FOUR), new Rock(Color.red));
		world.add(new Location(ONE, FOUR), new Rock(Color.red));
		world.show();
	}

}
