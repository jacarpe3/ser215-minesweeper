import java.util.Scanner;

/**
 * Prompt class used to prompt user for various types of values.
 * Overloaded methods to accept min and max parameters.
 * @author Josh Carpenter
 */
public class Prompt {

    private Prompt(){}

    private static String invalidMsg = "\tInvalid entry!  Please try again...";

    /**
     * Prompts the user for the desired level of difficulty and will ONLY accept an int value between 1 and 3
     * @return int value representing the desired level of difficulty
     */
    public static int getDifficulty() {
        return getUserInt("\tEnter the desired level of difficulty: ", invalidMsg, 1, 3);
    }

    /**
     * Prompts the user for their next move
     * @return int value representing the desired level of difficulty
     */
    public static int selectAction() {
        System.out.println("\t1 - Mark/unmark a tile...");
        System.out.println("\t2 - Select a tile...");
        System.out.println("\t3 - Quit Game\n");
        return getUserInt("\tSelect an action: ", invalidMsg, 1, 3);
    }

    /**
     * Prompts user if they would like to play again
     * @return boolean value referring to player's choice to play again
     */
    public static boolean playAgain() {
        boolean invalid, playAgain = false;
        String entry;
        do {
            invalid = false;
            entry = getUserString("\tWould you like to play again? (Y or N): ");
            if (entry.equalsIgnoreCase("Y")) {
                playAgain = true;
            } else if (entry.equalsIgnoreCase("N")) {
                playAgain = false;
            } else {
                invalid = true;
                System.out.println(invalidMsg);
            }
        } while (invalid);
        return playAgain;
    }

    /**
     * Prompts the user to enter the tile they wish to select (or mark)
     * @return a int[] where the value at index 0 is the row and the value at index 1 is the column
     */
    public static int[] makeSelection() {
        boolean invalid;
        String entry, delim = ",", prompt = "\tEnter the location of the tile (row, column): ";
        int[] location = new int[2];
        do {
            invalid = false;
            entry = getUserString(prompt);
            if (!entry.contains(delim)) {
                System.out.println(invalidMsg);
                invalid = true;
            } else {
                String[] parts = entry.split(delim);
                try {
                    location[0] = Integer.parseInt(parts[0].replaceAll("\\s", "")) - 1;
                    location[1] = Integer.parseInt(parts[1].replaceAll("\\s", "")) - 1;
                } catch (NumberFormatException e) {
                    System.out.println(invalidMsg);
                    invalid = true;
                }
            }
        } while (invalid);
        return location;
    }

    /**
     * Prompts user for an integer and does not accept strings or special
     * characters.  The integer must be >= the minimum value specified
     * and <= the max value specified.
     * @param prompt the prompt you wish to be displayed to the user
     * @param invalid the message displayed when an invalidMsg entry is given
     * @param min the minimum integer value to be accepted
     * @param max the maximum integer value to be accepted
     * @return integer value from user
     */
    private static int getUserInt(String prompt, String invalid, int min, int max) {
        Scanner scan = new Scanner(System.in);
        boolean isInvalid;
        int input;
        do {
            isInvalid = false;
            System.out.print(prompt);
            while (!scan.hasNextInt()) {
                System.out.println(invalid);
                System.out.print(prompt);
                scan.next();
            }
            input = scan.nextInt();
            if (input < min) {
                isInvalid = true;
                System.out.println(invalid);
            } else if (input > max) {
                isInvalid = true;
                System.out.println(invalid);
            }
        } while (isInvalid);
        return input;
    }

    /**
     * Prompts user for input and returns a string
     * @param prompt the prompt you wish to be displayed to the user
     * @return String value of the input from the user
     */
    private static String getUserString(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        return scan.nextLine();
    }

}
