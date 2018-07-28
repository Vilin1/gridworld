//package ZBug;

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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    //memory turn to which direction
    private int tag;
    //the first turn
    private boolean flagOfStart;
    //finish of not
    private boolean gameStatus;
    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        tag = 0;
        sideLength = length;
        flagOfStart = true;
        gameStatus = false;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if(flagOfStart) {
            turns(2);
            flagOfStart = false;
        }
        if(!gameStatus) {
            if (steps < sideLength&&canMove())
            {
                move();
                steps++;
            } else if(!canMove()) {
                gameStatus = false;
            } else {
                tag++;
                steps = 0;
                if(tag == 1) {
                    turns(3);
                }
                if(tag == 2) {
                    turns(5);
                }
                if(tag == 3) {
                    gameStatus = true; 
                }
            }
        }

    }

    //turn serveral times
    public void turns(int times) {
        for(int i = 0; i < times; i++) {
            turn();
        }
    }
}
