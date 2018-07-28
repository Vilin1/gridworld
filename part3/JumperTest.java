//package Jumper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class JumperTest {
	private ActorWorld world = new ActorWorld();
	private Jumper jumper1 = new Jumper();
	private Jumper jumper2 = new Jumper();
	
	/*
	 * run before every test
	 * to clear the grid
	 */
	@Before
	public void clearGrid() {
		int row = world.getGrid().getNumRows();
		int col = world.getGrid().getNumCols();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				world.remove(new Location(i, j));
			}
		}
	}

	/*
	 * test if a flower in front,cover it
	 * success
	 */
	@Test
	public void testAcrosssFlower() {
		world.add(new Location(4, 4), jumper1);
		world.add(new Location(2, 4), new Flower());
		jumper1.act();
		assertEquals(new Location(2, 4), jumper1.getLocation());
	}
	
	/*
	 * test if a rock in front, turn
	 * success
	*/
	@Test
	public void testAcrosssRock() {
		world.add(new Location(4, 4), jumper1);
		world.add(new Location(2, 4), new Rock());
		jumper1.act();
		jumper1.act();
		assertEquals(new Location(2, 6), jumper1.getLocation());
	}
	
	/*
	 * test if target out of grid, turn
	 * success
	 * 
	 */
	@Test
	public void testTargetOutofGrid() {
		world.add(new Location(1, 1), jumper1);
		jumper1.act();
		jumper1.act();
		jumper1.act();
		assertEquals(new Location(1, 3), jumper1.getLocation());
	}
	
	/*
	 * test if jumper fact edge, turn
	 * success
	 * 
	 */
	@Test
	public void testFactEdge() {
		world.add(new Location(0, 1), jumper1);
		jumper1.act();
		jumper1.act();
		jumper1.act();
		jumper1.act();
		assertEquals(new Location(0, 5), jumper1.getLocation());
	}
	
	/*
	 * test if jumper in front of it, turn
	 * success
	 * 
	 */
	@Test
	public void testAcrossAnotherJumper() {
		world.add(new Location(4, 4), jumper1);
		world.add(new Location(2, 4), jumper2);
		jumper1.act();
		jumper1.act();
		assertEquals(new Location(2, 6), jumper1.getLocation());
	}
	
	/*
	 * test if jumper forward,normal test
	 * success
	 * 
	 */
	@Test
	public void testJumperForward() {
		world.add(new Location(8, 8), jumper1);
		jumper1.act();
		jumper1.act();
		jumper1.act();
		assertEquals(new Location(2, 8), jumper1.getLocation());
	}
	
	/*
	 * test if can turn all the time
	 * success
	 * 
	 */
	@Test
	public void testJumperTurn() {
		world.add(new Location(6, 6), jumper1);
		world.add(new Location(4, 6), new Rock());
		world.add(new Location(8, 6), new Rock());
		world.add(new Location(6, 4), new Rock());
		world.add(new Location(6, 8), new Rock());
		world.add(new Location(4, 4), new Rock());
		world.add(new Location(4, 8), new Rock());
		world.add(new Location(8, 4), new Rock());
		world.add(new Location(8, 8), new Rock());
		jumper1.act();
		jumper1.act();
		jumper1.act();
		jumper1.act();
		assertEquals(new Location(6, 6), jumper1.getLocation());
	}
}
