import java.util.ArrayList;
import java.util.function.IntToDoubleFunction;

public class Maze {
	private int width;
	private int height;
	private char [][] maze;
	private ArrayList<Cords> Cordinates = new ArrayList<Cords>();
	private ArrayList<Position> recentMoves = new ArrayList<Position>();
//Controller algorithm
	//Create Model
	//Create view
	// Open File
	//Read maze
	//While (for next line{
	//read text base
	//results
	//display result
	public Maze (int width, int height) {
		this.width = width;
		this.height = height;
	    maze = new char [height][width];
	     
	}
	public char [][] getMaze(){
		return maze;
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	//finds position of a given char on the board
	public Position findPosition(char space)
	    {
	     for (int row = 0; row < maze.length; row++)
	        for (int column = 0; column < maze[0].length; column++)
	           if (maze[row][column] == space)
	            return new Position(row, column);;
	        
	        return null;
	    }
	
	public void makeCords(Cords Coordinates) {
		Cordinates.add(Coordinates);
		for(int i = 0; i < Cordinates.size(); i++) {   
		}  
	}
	
	public Cords getCordsOut() {
	 if (Cordinates.size() == 0) {
		 return null;
	 }
	 
	 Cords cordsList = Cordinates.remove(0);
	 return cordsList;
}
	
	//will record the last 3 boardpositions and remove the least recent.
	public void recordPositions() {
		recentMoves.add(findPosition('1'));
		if (recentMoves.size() >= 2) {
			recentMoves.remove(0);
		}
	}
	
	public void set(char character, int row, int column)
	{ 
	   maze[row][column] = character;
		  
	}
	
	public char get(int row, int column) {
		
		return maze[row][column]; 
	}
	
	private boolean illegalMove(int row, int column) {
		//returns false if it is a legal move 
		//returns true if it is an illegal move
		if(get(row, column)  == ('#') || get(row,column) == '.' || get(row,column) == '1') {
			
		return true;
		}
		//if(get(row,column) != )
		return false; 
	}
	
	//Counts the number of clearspots on the board
	public int countClearSpots(int row, int column) {
		int clearSpots = 0; 
		if (illegalMove(row+1, column) == false) {
			clearSpots = clearSpots + 1;
	}
		if (illegalMove(row-1, column) == false) {
			clearSpots = clearSpots + 1;
	}
		if (illegalMove(row, column+1) == false) {
			clearSpots = clearSpots + 1;
	}
		if (illegalMove(row, column-1) == false) {
			clearSpots = clearSpots + 1;
	}
		return clearSpots;
	}
	
	//Uses the set method to set the movement 
	private String calculateMovement(int row, int col) { 
			if (illegalMove(row+1, col) == false) {
				set('.', row+1, col);
				 return "S"; 
			}
			if (illegalMove(row-1, col) == false) {
				set('.', row-1, col);
				 return "N";
			}
			if (illegalMove(row, col+1) == false) {
				set('.', row, col+1);
				 return "E";
			}
			if (illegalMove(row, col-1) == false) {
				set('.', row, col-1);
				return "W";
			}
		
		return null;
		
	
	}
	private Position movement(String Direction, int row, int col) {
		switch(Direction) {
			case ("S"):  
				set('.', row, col);
			 return new Position(row+1, col);
			 
			case("N"):
				set('.', row, col);
			return new Position(row-1, col);
			
			case("E"):
				set('.', row, col);
			return new Position(row, col+1);
			
			case("W"):
				set('.', row, col);
		    return new Position(row, col-1);
		}
		return null;
	}
	//returns true if it did change directions.
	private boolean didChangeDirection(String Direction, String previousDirection) {
		if (Direction != previousDirection && previousDirection != null) {
			return true;
		}
		
return false; 
	}
	
	
	
	public String solve (int startrow, int startcol, int Endrow, int Endcol, 
			String previousDirection) {
		String result = "";
		//Must use recursion
		//Must return string of the form: r,c-r1,c1,r2-c2
		//drop breadcrumb
		//Must detect startrow and startcolumn
		// base cases
		//if we are at the end
		if (startrow == Endrow && startcol == Endcol) {
		    String stringEndRow = "" + Endrow;
		    String stringEndCol = "" + Endcol; 
		  //return end coordinates
		    return stringEndRow + stringEndCol;
		}
		//if no more moves can be made and maze is impossible.
		//fix this code to ensure that you can go back to an intersection if clearspots == 0 
		if (countClearSpots(startrow,startcol) == 0) {
			return null;
		}
		//    return null
		// counts number of clear spots
		if (countClearSpots(startrow, startcol) == 1) {
			
		
		// if only one way to go
		// 	calculate the next spot's coordinates
		   String Direction = calculateMovement(startrow, startcol);
		   Position newCords = movement(Direction, startrow, startcol);
		   if (didChangeDirection(Direction, previousDirection) == true) {
				   return startrow + "," + startcol +
				   "-" + solve(newCords.getRow(), newCords.getColumn(), Endrow, Endcol, Direction);
			   }
			   else {
				   return solve(newCords.getRow(), newCords.getColumn(), Endrow, Endcol, Direction);
		   //if no change in direction.
			
		   	}
			   
		   }
		
		if (countClearSpots(startrow, startcol) >= 2) {
			String Direction = calculateMovement(startrow, startcol);
			Position newCords = movement(Direction,startrow,startcol);
			Direction = calculateMovement(startrow, startcol); 
			String results = solve(newCords.getRow(), newCords.getColumn()
					, Endrow, Endcol, Direction);
			
			if (results != null) {
					return newCords.getRow() + "," + newCords.getColumn()
							+ "-" + result;
			}
		}
		//There are multiple ways to go
		//
		//if we can move east
		//     calculate the east coordinates
		//     results = solve(eastRow, eastCol, endRow, endCol)
		//
		//     if results != null
		
		//        return eastRow+ "," +eastCol+"-" result
		
		//if we can move south
				//     calculate the south coordinates
				//     results = solve(southRow, southCol, endRow, endCol)
				//
				//     if results != null
				//         return southRow+ "," +southCol+"-" result
		
		//if we can move west
				//     calculate the west coordinates
				//     results = solve(westRow, westCol, endRow, endCol)
				//
				//     if results != null
				//        return westRow+ "," +westCol+"-" result
		
		//if we can move north
				//     calculate the north coordinates
				//     results = solve(northRow, northCol, endRow, endCol)
				//
				//     if results != null
				//         return northRow+ "," +northCol+"-" result
		return null;
	}
}
