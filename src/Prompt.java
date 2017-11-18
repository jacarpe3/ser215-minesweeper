import java.util.Scanner;

/**
 * Prompt class used to prompt user for various types of values.
 * Overloaded methods to accept min and max parameters.
 * @author Josh Carpenter
 */
public class Prompt {

    private Prompt(){}

    private static String invalid = "Invalid Entry!  Please try again...";

    /**
     * Prompts the user for the desired level of difficulty and will ONLY accept an int value between 1 and 3
     * @return int value representing the desired level of difficulty
     */
    public static int getDifficulty() {
        return getUserInt("Enter the desired level of difficulty: ", invalid, 1, 3);
    }

    /**
     * Prompts the user for their next move
     * @return int value representing the desired level of difficulty
     */
    public static int selectAction() {
        return getUserInt("Select an action: ", invalid, 1, 2);
    }

    /**
     * Prompts user for an integer and does not accept strings or special
     * characters.  The integer must be >= the minimum value specified
     * and <= the max value specified.
     * @param prompt the prompt you wish to be displayed to the user
     * @param invalid the message displayed when an invalid entry is given
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
}
