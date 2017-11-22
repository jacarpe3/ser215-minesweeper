import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Grid class for the game board and supporting methods for interacting with it
 * @author Brent Yoshimura, Josh Carpenter
 */
public class Grid {

    private int rows;
    private int columns;
    private int mineCount;
    private Tile[][] grid;
    Random random = new Random();

    /**Constructor for creating the grid**/
    public Grid(int difficulty){

        switch(difficulty) {
            case 1: this.rows = 9; this.columns = 9; this.mineCount = 10; break;
            case 2: this.rows = 16; this.columns = 16; this.mineCount = 20; break;
            case 3: this.rows = 16; this.columns = 30; this.mineCount = 30; break;
        }
        grid = new Tile[rows][columns];

        //Loops to fill grid with default tiles
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                int[] location = {i, j};
                grid[i][j] = new Tile(location);
            }
        }

        this.placeMines();

    }

    /**private method for placing the mines**/
    private void placeMines() {
        int count = 0;
        do {
            int randomRow = random.nextInt(rows);  //random row index for the mine
            int randomColumn = random.nextInt(columns);  //random column index for mine
            Tile randomTile = grid[randomRow][randomColumn];
            if (!randomTile.hasMine()) {
                randomTile.setMine(true);
                count++;
            }
        } while (count < mineCount);
    }

    /**Method for verifying if the tile is a mine**/
    public boolean isMine(Tile tile) {
        return tile.hasMine();
    }

    /**Method for verifying if the tile is selected**/
    public boolean isSelected(Tile tile){
        return tile.isSelected();
    }

    /**Method for returning the tile**/
    public Tile getTile(int[] location){
        return this.grid[location[0]][location[1]];
    }

    /**Method for marking tile**/
    public void markTile(Tile tile){
        tile.setMarked(true);
    }

    /**Method for selecting the tile**/
    public void selectTile(Tile tile) {
        tile.setSelected(true);
    }

    /**Method for displaying the number of mines touching the current tile**/
    public int nearbyMines(Tile tile) {
        int count = 0;
        int[] current = tile.getLocation();
        List<int[]> nearbyTiles = new ArrayList<>();
        int[] top = new int[2], topRight = new int[2], right = new int[2], bottomRight = new int[2],
                bottom = new int[2], bottomLeft = new int[2], left = new int[2], topLeft = new int[2];

        // Calculate location arrays for surrounding tiles and add to List
        top[0] = current[0] - 1; top[1] = current[1]; nearbyTiles.add(top);
        topLeft[0] = current[0] - 1; topLeft[1] = current[1] - 1; nearbyTiles.add(topLeft);
        topRight[0] = current[0] - 1; topRight[1] = current[1] + 1; nearbyTiles.add(topRight);
        left[0] = current[0]; left[1] = current[1] - 1; nearbyTiles.add(left);
        right[0] = current[0]; right[1] = current[1] + 1; nearbyTiles.add(right);
        bottomLeft[0] = current[0] + 1; bottomLeft[1] = current[1] - 1; nearbyTiles.add(bottomLeft);
        bottom[0] = current[0] + 1; bottom[1] = current[1]; nearbyTiles.add(bottom);
        bottomRight[0] = current[0] + 1; bottomRight[1] = current[1] + 1; nearbyTiles.add(bottomRight);

        // Iterate through the nearby tiles, verify it is on the grid, check if it contains a mine, and increment count if so
        for (int[] tileLocation : nearbyTiles) {
            if (tileLocation[0] >= 0 && tileLocation[0] < rows && tileLocation[1] >= 0 && tileLocation[1] < columns) {
                Tile thisTile = getTile(tileLocation);
                if (thisTile.hasMine()) {
                    count++;
                }
            }
        }
        return count;
    }
}