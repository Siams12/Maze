import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Controller {
	
	public static void main(String[] args) {
		Controller Controller = new Controller();
		Controller.go();

	}
	public Scanner createScannerFile() { 
	File file = getMazeFileFromUser();
	  Scanner input = null;
	  try {
		  input = new Scanner(file);
	  }
	  catch(FileNotFoundException e) {
		  System.out.println("Could not read the file");
	  }
	  return input;
	}
	
	public Maze readMazeFromFile(Scanner input) {
		//read width and height of maze
	     //Controller mazeController = new Controller();
		   int width = input.nextInt();
		   int height = input.nextInt();
		  
		  System.out.println(width);
		  System.out.println(height);
		  Maze maze = new Maze (width, height); 
		  input.nextLine();
		  for (int row = 0; row < height; row++) {
			  String converttoCharacter = input.nextLine();
			  for(int column = 0; column < width ; column++) {
				  char character = converttoCharacter.charAt(column);
				  maze.set(character, row, column);
			  }
			  
			  }
		  while (input.hasNextInt()) {
		
			  int startrow = input.nextInt();
			  int startcol = input.nextInt();
			  int endrow = input.nextInt();
			  int endcol = input.nextInt();
			  Cords Cords = new Cords(startrow, startcol, endrow, endcol);
			  maze.makeCords(Cords);
		  }
		  
		  
		  return maze;
		  
			  
		}
    public File getMazeFileFromUser() {
    	JFileChooser chooser = new JFileChooser();
		 
	    int returnVal = chooser.showOpenDialog(null);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    
	      File file = chooser.getSelectedFile();
	    
	  
	    
	
	    return file;
	    }
	    return null;
    }
	

	public void go() {
		//Read maze from file
		//for each start and end pair 
		// {
		// solve the maze
		// output the answer
		//}
		Scanner s = createScannerFile();
		Maze mazeController = readMazeFromFile(s); 
		View View = new View();
	    View.mazeview(mazeController);
	    Cords cords = mazeController.getCordsOut();
	    mazeController.set('1', cords.getStartRow(), cords.getStartCol());
	    mazeController.recordPositions();
	    System.out.println(mazeController.solve(cords.getStartRow(), cords.getStartCol(), cords.getEndRow(), cords.getEndCol()));
	    View.mazeview(mazeController);
	    }
}
