import org.omg.Messaging.SyncScopeHelper;

/**

 * Main class for the Minesweeper game

 */

public class Minesweeper {
	
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
    	
    	int selection;//variable for marking or flipping tile
    	tile selectedTile;// variable for selected tile
    	int mineCount = 0;// variable to keep track of the amount of mines to set
    	boolean done = true;//marker for ending game
    	boolean playAgain;
    	
    	int difficulty = prompt.getDifficulty();//variable for creating user selected grid
    	Grid grid = new Grid(difficulty);//create new grid
    	printGrid(grid);
    	//mineCount = getMineCount(); //need to add method in grid class
    	
    	do{
    	selectedTile = grid.getTile(prompt.makeSelection());
    	//needs index checking code to be added and if the tile has already been selected and marked 
    	// alternatives for removing the mine?
    	System.out.println("Actions are:\n 1 = select tile, 2 = mark tile");
    	selection = prompt.selectAction();
    	if(selection == 1){
    		if(selectedTile.hasMine()){
    			System.out.println("Game Over!");
    			printGrid(grid);
    			done = true;
    			continue;
    		}
    		selectedTile.isSelected();
    		selectedTile.getNearbyMines();
    		printGrid(grid);
    		done = false;
    		
    	}else{
    		selectedTile.isMarked();
    		selectedTile.setMine(true);
    		selectedTile.setSelected(true);
    		//mineCount--;
    		done = false;
    	}
    	}while(!done);
    	
    	playAgain = prompt.playAgain();
    	if(playAgain == true)
    		startGame();
    	else
    		System.out.println("Thank You for playing!");
    	
    }



    private static void printGrid(Grid grid) {
      //TODO add code
    }
}

