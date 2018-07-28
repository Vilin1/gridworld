//package CrabCritter;

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains crab critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public final class CrabCritterRunner
{
    private CrabCritterRunner() {
        
    }
    private static final int TWO = 2;
    private static final int FIVE = 5;
    private static final int SEVEN = 7;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(SEVEN, FIVE), new Rock());
        world.add(new Location(FIVE, FOUR), new Rock());
        world.add(new Location(TWO, FIVE), new Rock());
        world.add(new Location(TWO, THREE), new Rock());
        world.add(new Location(SEVEN, SEVEN), new Flower());
        world.add(new Location(TWO, TWO), new Flower());
    }
}