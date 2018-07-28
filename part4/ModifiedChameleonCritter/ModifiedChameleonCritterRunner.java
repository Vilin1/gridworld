//package ModifiedChameleonCritter;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;

public final class ModifiedChameleonCritterRunner {
	private ModifiedChameleonCritterRunner() {
		
	}

	private static final int FIVE = 5;
	private static final int FOUR = 4;
	private static final int SIX = 6;
	private static final int TWO = 2;
	private static final int EIGHT = 8;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(FIVE,FIVE), new ModifiedChameleonCritter(Color.red));
		world.add(new Location(FIVE,FOUR), new Flower());
		world.add(new Location(TWO,TWO), new Rock());
		world.add(new Location(SIX,EIGHT), new Rock());
		world.show();
	}

}