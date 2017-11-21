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
		case 1: rows = 9; columns = 9; minecount = 10; break;
		case 2: rows = 16; columns = 16; minecount = 20; break;
		case 3: rows = 16; columns = 30; minecount = 30; break;
		}		
		grid = new tile[rows][columns];
		
		//Loops to fill grid with default tiles
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = new tile();
			}
		}
		
	}//End Grid
	
	/**private method for placing the mines**/
	private void placeMines(){
		boolean shuffled = false;
		int rws, cols;
		for (int i = 0; i < minecount; i++){
			do{
				rws = random.nextInt(rows);//random row index for the mine
				cols = random.nextInt(columns);//random column index for mine
				grid[rws][cols].setMine(true);;//set mine
				
				if(rws == -1){// need to fix
					shuffled =true;
				}					
				else
					shuffled = false;
			}while(shuffled);
		}		
	}//End placeMines
	
	/**Method for verifying if the tile is a mine**/
	public boolean isMine(tile Tile){
		if(Tile.hasMine() == false){
			return false;	
		}else
			return true;
		
	}//End isMine
	
	/**Method for verifying if the tile is selected**/
	public boolean isSelected(tile Tile){
		if(Tile.isSelected() == false){
			return false;
		}else
			return true;
		
	}//End isSelected
	
	/**Method for returning the tile**/
	public tile getTile(int [] location){// delete comment when method is finished
		return null;
		
	}//End getTile
	
	/**Method for marking tile**/
	public void markTile(tile Tile){
		Tile.setMarked(true);
		
	}//End markTile
	
	/**Method for selecting the tile**/
	public void selectTile(tile Tile){
		if(Tile.isSelected() == true){//verify tile selection
			if(Tile.hasMine() == true){//game over selection
				System.out.println("Gameover, Minesweeper.printGrid()");//temporary modify when done
			}
		}else
			if(Tile.isSelected() == true){//verify tile selection
				nearByMines(Tile);//uncover the number of mines around location
			}
	}//End selectTile
	
	/**Method for uncovering the mines**/
	public int nearByMines(tile Tile){
		int count = 0;
		int location;
		for(int i =0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				
			}
		}		
		return count;		
	}//End nearByMines
	
}//End class
