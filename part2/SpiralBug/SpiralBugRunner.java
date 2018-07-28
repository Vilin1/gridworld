//package SpiralBug;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public final class SpiralBugRunner
{
	private SpiralBugRunner() {

	}
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        SpiralBug bob = new SpiralBug(4);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}