//package SpiralBug;

import info.gridworld.actor.Bug;

public class SpiralBug extends Bug{
	private int steps;
	private int sideLength;
	
	//construct
	//the origin length is sidelength
	public SpiralBug(int l) {
		sideLength = l;
		steps = 0;
	}
	
	public void act() {
		//move
		if(steps < sideLength&&canMove()) {
			move();
			steps++;
		} else {
			turn();
			turn();
			steps = 0;
			sideLength++;
		}
		//else turn twice and add the sidelength
	}
}
