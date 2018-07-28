import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class UnboundedGrid2<E> extends AbstractGrid<E> {
	private Object[][] occupantArray;
	private int dimension;

	//origin with a demision of 16
	public UnboundedGrid2() {
        dimension = 16;
		occupantArray = new Object[dimension][dimension];
	}

	public int getNumRows()
    {
        return -1;
    }

    public int getNumCols()
    {
        return -1;
    }

    //row and col not-negative
    public boolean isValid(Location loc) {
    	if(loc.getRow() >= 0&&loc.getCol() >= 0) {
    		return true;
    	}
    	return false;
    }

    //get all location have actor
    public ArrayList<Location> getOccupiedLocations() {
    	ArrayList<Location> result = new ArrayList<Location>();
    	for(int i = 0; i < dimension; i++) {
    		for(int j = 0; j < dimension; j++) {
    			Location tempLoc = new Location(i, j);
    			if(get(tempLoc) != null) {
    				result.add(tempLoc);
    			}
    		}
    	}
    	return result;
    }

    //loc valid or not
    public E get(Location loc) {
    	if (!isValid(loc)) {
            throw new NullPointerException("loc < 0");
    	}
        if(loc.getRow() >= dimension||loc.getCol() >= dimension) {
    		return null;
    	} else {
    	   return (E)occupantArray[loc.getRow()][loc.getCol()];
        }
    }

    //put actor in grid
    public E put(Location loc, E obj) {
    	if (!isValid(loc)) {
            throw new NullPointerException("loc == null");
    	}
        if (obj == null){
            throw new NullPointerException("obj == null");
        }
        if(loc.getRow() >= dimension||loc.getCol() >= dimension) {
        	append(loc);
        }
        //put in array if it is ok
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return get(loc);

    }
    //grid is not good enough
    //append until big enought
    private void append(Location loc) {
    	int beforeChange = dimension;
    	while(dimension <= loc.getRow()||dimension <= loc.getCol()) {
    		dimension = 2*dimension;
    	}

    	Object[][] tempArray = new Object[dimension][dimension];

    	//copy
        for(int i = 0; i < beforeChange; i++) {
            for(int j = 0; j < beforeChange; j++) {
                tempArray[i][j] = occupantArray[i][j];
            }
        }
        occupantArray = tempArray;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc)) {
            throw new NullPointerException("loc ilvalid");
        }
        if(loc.getRow() >= dimension||loc.getCol() >= dimension) {
        	return null;
        }
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return get(loc);
    }
}
