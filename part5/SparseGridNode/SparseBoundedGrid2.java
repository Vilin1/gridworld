//package SparseGridNode;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SparseBoundedGrid2<E> extends AbstractGrid<E> {
    private Map<Location, E> gridMap;
    private int rows;
    private int columns;

    //construct, like BoundedGrid
    public SparseBoundedGrid2(int row, int column) {
		// TODO Auto-generated constructor stu
        if (row <= 0) {
            throw new IllegalArgumentException("row <= 0");
        }
        if (column <= 0) {
            throw new IllegalArgumentException("col <= 0");
        }
        rows = row;
        columns = column;
        //new map
        gridMap = new HashMap<Location, E>();
    }

    //method to get data
    public int getNumRows()
    {
        return rows;
    }

    public int getNumCols()
    {
        return columns;
    }

    //have the save code like BoundedGrid
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }


    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> arrayOfLocation = new ArrayList<Location>();
        for(Entry<Location, E> entry : gridMap.entrySet()) {
        	arrayOfLocation.add(entry.getKey());
        }
        return arrayOfLocation;
    }


    //hash can get directly
    public E get(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        return gridMap.get(loc); 
    }

    //valid loc and obj first
    public E put(Location loc, E obj)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }
        // Add the object to the grid.
        return gridMap.put(loc, obj);
    }

    //valid the loc first
    public E remove(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        // Remove the object from the grid.
        return gridMap.remove(loc);
    }
}
