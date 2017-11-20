import java.util.Random;

public class Grid {
	
	private int rows;
	private int columns;
	private int difficulty;//??
	private int minecount;
	private tile [][] grid;
	Random random = new Random();

	/**Constructor for creating the grid**/
	public Grid(int difficulty){
		this.difficulty = prompt.getDifficulty();//?
		switch(difficulty)
		{
		case 1: rows = 9; columns = 9; break;
		case 2: rows = 16; columns = 16; break;
		case 3: rows = 16; columns = 30; break;
		}
		
	}//End Grid
	
	/**private method for placing the mines**/
	private void placeMines(){
		boolean shuffled = false;
		int rws, cols;
		for (int i = 0; i < difficulty; i++){
			do{
				rws = random.nextInt();
				cols = random.nextInt();
				
				if(rws == -1 && cols == -1){
					shuffled =true;
				}					
				else
					shuffled = false;
			}while(shuffled);
		}		
	}//End placeMines
	
	/**Method for verifying if the tile is a mine**/
	public boolean isMine(tile Tile){
		
		return false;
		
	}//End isMine
	
	/**Method for verifying if the tile is selected**/
	public boolean isSelected(tile Tile){
		return false;
		
	}//End isSelected
	
	/**Method for returning the tile**/
	public tile getTile(int [] location){
		return null;
		
	}//End getTile
	
	/**Method for marking tile**/
	public void markTile(tile Tile){
		
	}//End markTile
	
	/**Method for selecting the tile**/
	public void selectTile(tile Tile){
		
	}//End selectTile
	
	/**Method for uncovering the mines**/
	public int nearByMines(tile Tile){
		return 0;
		
	}//End nearByMines
	
}//End class
