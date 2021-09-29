
public class View {
	

	public void mazeview(Maze maze) {
		char [][] Maze = maze.getMaze();
	    for (int i = 0; i < maze.getHeight() ; i++) {
	        System.out.println("");
			for (int j = 0; j < maze.getWidth(); j++) {
				System.out.print(maze.get(i, j));
				
				
	}
			
}
	    System.out.println("");
}
}
