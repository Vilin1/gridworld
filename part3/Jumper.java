//package Jumper;


import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug{
	 public Jumper() {
		 setColor(Color.RED);
	 }
	 
	 public Jumper(Color bugColor) {
	        setColor(bugColor);
	 }
	 
	 public void turn() {
		 setDirection(getDirection() + Location.HALF_RIGHT);
	 }
	 
	 public void move() {
		 Grid<Actor> gr = getGrid();
		 
		 //get current location
		 Location currentLocation = getLocation();
		 Location middleLocation = currentLocation.getAdjacentLocation(getDirection());
		 //next location valid or not
		 if(!gr.isValid(middleLocation)) {
			 removeSelfFromGrid();
			 return;
		 }
		 //get target location
		 Location targetLocation = middleLocation.getAdjacentLocation(getDirection());
		 moveTo(targetLocation);
		 
		 if (gr.isValid(targetLocation)) {
			 moveTo(targetLocation);
		 }
	     else {
	         removeSelfFromGrid();
	     }
	 }
	 
	 public boolean canMove() {
		 Grid<Actor> gr = getGrid();
	     if (gr == null) {
	        return false;
	     }
		 //get current location
		 Location currentLocation = getLocation();
		 Location middleLocation = currentLocation.getAdjacentLocation(getDirection());
		 //next location valid or not
		 if(!gr.isValid(middleLocation)) {
			 return false;
		 }
		 //get target location
		 Location targetLocation = middleLocation.getAdjacentLocation(getDirection());
		 
		 if (!gr.isValid(targetLocation)){
			 return false;
		 }
	     Actor neighbor = gr.get(targetLocation);
	     return (neighbor == null) || (neighbor instanceof Flower);
		 
	 }
	 
	 public void act() {
        if (canMove())
        {
            move();
        }
        else
        {
            turn();
        }
    }
}
