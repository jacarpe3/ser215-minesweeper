import java.util.Scanner;

/**
 * Input class used to prompt user for various types of values.
 * Overloaded methods to accept min and max parameters.
 * @author Josh Carpenter
 * Hi Josh testing to see if this works Brent Y
 */
public class Input {

    private Input(){}

    /**
     * Prompts user for an integer and does not accept strings or special
     * characters.  The integer must be >= the minimum value specified
     * and <= the max value specified.
     * @param prompt the prompt you wish to be displayed to the user
     * @param invalid the message displayed when an invalid entry is given
     * @return integer value from user
     */
    public static int getUserInt(String prompt, String invalid) {
        Scanner scan = new Scanner(System.in);
        int input;
        System.out.print(prompt);
        while (!scan.hasNextInt()) {
            System.out.println(invalid);
            System.out.print(prompt);
            scan.next();
        }
        input = scan.nextInt();
        return input;
    }


    /**
     * Prompts user for an integer and does not accept strings or special
     * characters.  The integer must be >= the minimum value specified
     * and <= the max value specified.
     * @param prompt the prompt you wish to be displayed to the user
     * @param invalid the message displayed when an invalid entry is given
     * @param min the minimum integer value to be accepted
     * @return integer value from user
     */
    public static int getUserInt(String prompt, String invalid, int min) {
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
            }
        } while (isInvalid);
        return input;
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
    public static int getUserInt(String prompt, String invalid, int min, int max) {
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
