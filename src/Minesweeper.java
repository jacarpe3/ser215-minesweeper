import java.io.IOException;

/**
  * Main class for the Minesweeper game
  */
        
public class Minesweeper {
 
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean playAgain;
        do {
            playAgain = startGame();
        } while (playAgain);

        System.exit(0);
    }
 

    /**
     * Main method for game play
     * @returns boolean value corresponding to if the player wants to play again
     */
    private static boolean startGame() throws IOException, InterruptedException {
        clearConsole();
        System.out.print("\n");
        System.out.println("\t  __  __ _                                                   ");
        System.out.println("\t |  \\/  (_)                                                  ");
        System.out.println("\t | \\  / |_ _ __   ___  _____      _____  ___ _ __   ___ _ __ ");
        System.out.println("\t | |\\/| | | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
        System.out.println("\t | |  | | | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |   ");
        System.out.println("\t |_|  |_|_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|   ");
        System.out.println("\t                                            | |              ");
        System.out.println("\t   Version 1.0                              |_|              " + "\n");
        System.out.println("\t*****************************************************************");
        System.out.println("\tBy Josh Carpenter, Brent Yoshimura, Amy Kiely, and Kyle Jeffreys");
        System.out.println("\t*****************************************************************\n");

        System.out.println("\t1 - Easy");
        System.out.println("\t2 - Normal");
        System.out.println("\t3 - Expert\n");

        boolean winner = false, loser = false;
        int difficulty = Prompt.getDifficulty();
        Grid grid = new Grid(difficulty);
        int markedMines = 0;

        do {
            printGrid(grid);
            int action = Prompt.selectAction();

            // Mark or Unmark a Tile
            if (action == 1) {
                Tile selectedTile;
                boolean invalid;
                do {
                    invalid = false;
                    selectedTile = grid.getTile(Prompt.makeSelection(grid.getRows(), grid.getColumns()));
                    if (selectedTile.isSelected()) {
                        System.out.println("That tile has already been selected! Please try again...");
                        invalid = true;
                    } else if (selectedTile.isMarked()) {
                        selectedTile.setMarked(false);
                        if (selectedTile.hasMine()) {
                            markedMines--;
                        }
                    } else {
                        selectedTile.setMarked(true);
                        if (selectedTile.hasMine()) {
                            markedMines++;
                        }
                    }
                } while (invalid);
                if (markedMines == grid.getMineCount()) {
                    winner = true;
                }

            // Select a tile
            } else if (action == 2) {
                Tile selectedTile;
                boolean invalid;
                do {
                    invalid = false;
                    selectedTile = grid.getTile(Prompt.makeSelection(grid.getRows(), grid.getColumns()));
                    if (selectedTile.isMarked()) {
                        System.out.println("That tile is marked! Please try again...");
                        invalid = true;
                    } else if (selectedTile.isSelected()) {
                        System.out.println("That tile has already been selected! Please try again...");
                        invalid = true;
                    } else {
                        selectedTile.setSelected(true);
                        if (selectedTile.hasMine()) {
                            loser = true;
                        } else {
                            selectedTile.setNearbyMines(grid.nearbyMines(selectedTile));
                        }
                    }
                } while (invalid);

            // Quit the game
            } else if (action == 3) {
                System.out.println("\tQuitting game...\n");
                break;
            }
        } while (!winner && !loser);

        if (winner) {
            System.out.println("\t*** You found all the mines!  You Win! ***\n");
        }

        if (loser) {
            System.out.println("\t*** You triggered a mine!  You Lose! ***\n");
        }

        return Prompt.playAgain();
    }

    /**
     * Method to print the grid's current state in the console application
     * @param grid the Grid object to print
     */
    private static void printGrid(Grid grid) throws IOException, InterruptedException {
        clearConsole();
        int rows = grid.getRows();
        int columns = grid.getColumns();

        System.out.println("\n");
        System.out.println("\t         C   O   L   U   M   N\n");
        System.out.print("             ");
        for (int c = 1; c <= columns; c++) {
            if (c < 10) {
                System.out.print(c + "   ");
            } else {
                System.out.print(c + "  ");
            }
        }
        System.out.print("\n\n\n");
        for (int i = 0; i < rows; i++) {
            if (i == 0) {
                System.out.print("       " + (i + 1) + "     ");
            } else if (i == 1) {
                System.out.print("   R   " + (i + 1) + "     ");
            } else if (i == 2) {
                System.out.print("   O   " + (i + 1) + "     ");
            } else if (i == 3) {
                System.out.print("   W   " + (i + 1) + "     ");
            } else if (i < 9) {
                System.out.print("       " + (i + 1) + "     ");
            } else {
                System.out.print("      " + (i + 1) + "     ");
            }

            for (int j = 0; j < columns; j++) {
                int[] location = {i, j};
                Tile thisTile = grid.getTile(location);
                if (thisTile.isSelected()) {
                    if (thisTile.getNearbyMines() == 0) {
                        System.out.print("    ");
                    } else {
                        System.out.print(thisTile.getNearbyMines() + "   ");
                    }
                } else if (thisTile.isMarked()) {
                    System.out.print("#   ");
                } else {
                    System.out.print("?   ");
                }
            }
            System.out.print("\n\n");
        }
        System.out.print("\n\n");
    }

    /**
     * Clears the console window to prevent scrolling or printing duplicate grids
     */
    private static void clearConsole() throws IOException, InterruptedException {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }
}