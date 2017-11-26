
/**
 * Tile object for Minesweeper grid locations
 */

public class Tile {

    private boolean hasMine, isMarked, isSelected;
    private int[] location;
    private int nearbyMines;

    public Tile(int[] location) {
        this.hasMine = false;
        this.isMarked = false;
        this.isSelected = false;
        this.location = location;
        this.nearbyMines = 0;
    }

    /**
     * @return boolean value representing if the tile is marked as containing a mine
     */
    public boolean isMarked() {
        return isMarked;
    }

    /**
     * @return boolean value representing if the tile has been selected (turned over) yet
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * @return boolean value representing if the tile is hiding a mine underneath
     */
    public boolean hasMine() {
        return hasMine;
    }

    /**
     * @return The location array of the tile that specifies the row/column
     */
    public int[] getLocation() {
        return location;
    }

    /**
     * @return The number of mines touching this tile
     */
    public int getNearbyMines() {
        return nearbyMines;
    }

    /**
     * sets the isMarked variable
     */
    public void setMarked(boolean marked) {
        this.isMarked = marked;
    }

    /**
     * sets the isSelected variable
     */
    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    /**
     * sets the hasMine variable
     */
    public void setMine(boolean mine) {
        this.hasMine = mine;
    }

    /**
     * sets the number of nearby mines
     */
    public void setNearbyMines(int nearbyMines) {
        this.nearbyMines = nearbyMines;
    }
}
