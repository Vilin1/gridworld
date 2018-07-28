//package SparseGridNode;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class SparseBoundedGrid<E> extends AbstractGrid<E> {
  private SparseGridNode[] occupantArray;
  private int rows;
  private int columns;

  /**
   * Constructs an empty bounded grid with the given dimensions. (Precondition:
 */
  public SparseBoundedGrid(int row, int column) {
    if (row <= 0) {
      throw new IllegalArgumentException("row <= 0");
    }
    if (column <= 0) {
      throw new IllegalArgumentException("column <= 0");
    }

    rows = row;
    columns = column;
    occupantArray = new SparseGridNode[row];
  }

  //method to get data
  public int getNumRows() {
    return rows;
  }

  public int getNumCols() {
    return columns;
  }


  public boolean isValid(Location loc) {
    return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
  }

  //put obj into loc
  public E put(Location loc, E obj) {
    if (!isValid(loc)) {
      throw new IllegalArgumentException("Location " + loc + " is not valid");
    }
    if (obj == null) {
      throw new NullPointerException("obj == null");
    }

    // Add the object to the grid. 
    //if obj haved existed, removed first, then add to front
    E oldOccupant = remove(loc);
    SparseGridNode oldRowHead = occupantArray[loc.getRow()];
    SparseGridNode newRowHead = new SparseGridNode(obj, loc.getCol(), null, oldRowHead);
    if (oldRowHead != null) {
      oldRowHead.setPre(newRowHead);
    }
    occupantArray[loc.getRow()] = newRowHead;
    return oldOccupant;
  }

  //get E in location loc, failed to return null
  public E get(Location loc) {
    //get the first one of the row
    SparseGridNode target = occupantArray[loc.getRow()];
    //find target in that row
    while(target != null) {
      if(target.getCol() == loc.getCol()) {
        break;
      }
      target = target.getNext();
    }
    //process target
    if (target != null) {
      return (E) target.getOccupant();
    } else {
      return null;
    }
  }

  public ArrayList<Location> getOccupiedLocations() {
    ArrayList<Location> arrayOfLocation = new ArrayList<Location>();
    // traverses all occupied locations.
    for (int i = 0; i < rows; i++) {
      SparseGridNode firstNode = occupantArray[i];
      //get the target in every row
      while (firstNode != null) {
        Location loc = new Location(i, firstNode.getCol());
        arrayOfLocation.add(loc);
        firstNode = firstNode.getNext();
      }
    }
    return arrayOfLocation;
  }

  public E remove(Location loc) {
    if (!isValid(loc)) {
      throw new IllegalArgumentException("Location " + loc + " is not valid");
    }

    //get the first one of the row
    SparseGridNode target = occupantArray[loc.getRow()];
    while(target != null) {
      if(target.getCol() == loc.getCol()) {
        break;
      }
      target = target.getNext();
    }

    //a temp to return at the end
    SparseGridNode temp = target;
    boolean tag = false;
    if(target != null) {
      tag = true;
    }

    //target exist, process it
    if(tag) {
      SparseGridNode beforeNode = target.getPre();
      SparseGridNode afterNode = target.getNext();
      //pre is not the front
      if(beforeNode != null) {
        beforeNode.setNext(afterNode);
      }else {
        occupantArray[loc.getRow()] = afterNode;
      }

      if(afterNode != null) {
        afterNode.setPre(beforeNode);
      }
    }
    //the location exit or not
    if(tag) {
      return temp.getOccupant();
    } else {
      return null;
    }
  }
  
}
