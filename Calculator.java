package Project01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * A simple Calculator console application that allows the user
 * to enter numbers (doubles) and perform certain operations
 * on such numbers in order to calculate an answer. The answer
 * is then printed onto the terminal window.
 *
 * @author Mariafe Ponce
 * @author Daniel DeFrance (Provided starter code)
 */

public class Calculator {

    // FIELDS:
    private double answer; // the calculated answer (eg. 2.5, if the operation is 1.25 + 1.25 = )
    private Scanner scannedInput = new Scanner(System.in); // scanner that scans for written user input

    /**
     * Constant for value of Pi to 5 decimal places.
     */
    public final static double ROUGHLY_PI = 3.14159;

    /**
     * List of all valid operations and the operation descriptions.
     */
    public final static String usageInstructions = "Valid operations are: \n"
            + " + \t add \n - \t subtract \n * \t multiply \n / \t divide \n"
            + " c \t clear  \n neg \t negate \n % \t percent \n"
            + " ^ \t raise to power of next value entered \n inv \t invert the current value \n"
            + " rand \t radomize current value by a fractional amount \n"
            + " round \t round to number of places given next \n" + " = \t print answer \n ? \t Help \n q \t Quit \n";


    // CONSTRUCTORS:

    /**
     * Constructs a new calculator instance with a default answer of zero.
     */
    Calculator() {
        this.answer = 0;
    }

    ;

    // METHODS:

    /**
     * Scans and stores number from user input and checks the validity of the number
     *
     * @return user-inputted double after checking that it's a valid number.
     */
    public double getUserNum() {
        boolean validNumber = false;
        double userVal = 0;

        System.out.print("Enter number\n>>> ");

        while (!validNumber) {
            if (scannedInput.hasNext("pi")) {
                userVal = ROUGHLY_PI;
                scannedInput.next();
                validNumber = true;
            } else if (scannedInput.hasNextDouble()) {
                userVal = scannedInput.nextDouble();
                validNumber = true;
            } else {
                System.out.print("That's not a number. \nEnter a valid number\n>>> ");
                scannedInput.next();
            }
        }
        return userVal;
    }

    /**
     * Scans and stores operation from user input and calls a helper method
     * to check the operation's validity.
     *
     * @return user-inputted operation after checking that it's a valid operation.
     */
    public String getUserOp() {
        String op;

        System.out.print("Enter operation\n>>> ");
        op = scannedInput.next();
        while (!(this.checkUserOp(op))) {
            op = scannedInput.next();
        }
        return op;
    }

    /**
     * Checks the validity of the user-inputted operation.
     *
     * @param op user-inputted operation
     * @return true if operation is valid; false if operation is invalid,
     */
    private boolean checkUserOp(String op) {
        if (op.equals("+") || op.equals("-") || op.equals("=") || op.equals("?") || op.equals("Q") || op.equals("q")
                || op.equals("*") || op.equals("/") || op.equals("c") || op.equals("C") || op.equals("neg")
                || op.equals("%") || op.equals("^") || op.equals("inv") || op.equals("rand") || op.equals("round")) {
            return true;
        } else {
            System.out.print("Invalid Entry. Enter '?' for help." + "\nEnter a valid operation \n>>> ");
            return false;
        }
    }

    /**
     * Performs an operation on the calculator's current answer.
     * If the operation requires another number, the user-inputted
     * number is used to perform the operation on the current answer
     * (eg. Current Answer + User-Inputted Number).
     *
     * @param op  user-inputted operation (eg. "+", "*", "neg")
     * @param num user-inputted number (double)
     * @return calculated answer after performing the operation.
     */
    public double calculateAnswer(String op, double num) {
        switch (op) {
            case "+":
                add(num);
                break;
            case "-":
                subtract(num);
                break;
            case "*":
                multiply(num);
                break;
            case "/":
                divide(num);
                break;
            case "c":
            case "C":
                clear();
                break;
            case "neg":
                negate();
                break;
            case "%":
                percent();
                break;
            case "^":
                toPower(num);
                break;
            case "inv":
                invert();
                break;
            case "rand":
                randomize();
                break;
            case "round":
                roundTo((int) num);
                break;
            case "=":
                printAnswer();
                break;
            case "?":
                System.out.println(Calculator.usageInstructions);
                break;
            default:
                System.out.println("Invalid Operator");
        }
        return this.answer;
    }

    /**
     * Adds a double to the current answer.
     *
     * @param operand number you wish to add.
     * @return calculated answer after adding number.
     */
    public double add(double operand) {
        this.answer += operand;
        return this.answer;
    }

    /**
     * Subtracts a double from the current answer.
     *
     * @param operand number you wish to subtract.
     * @return calculated answer after subtracting number.
     */
    public double subtract(double operand) {
        this.answer -= operand;
        return this.answer;
    }

    /**
     * Multiplies a double by the current answer.
     *
     * @param operand number you wish to multiply.
     * @return calculated answer after multiplying number.
     */
    public double multiply(double operand) {
        this.answer *= operand;
        return this.answer;
    }

    /**
     * Divides a double by the current answer.
     *
     * @param operand number you wish to divide by.
     * @return calculated answer after it's been divided.
     */
    public double divide(double operand) {
        this.answer /= operand;
        return this.answer;
    }

    /**
     * Resets current answer to zero.
     *
     * @return current answer as zero.
     */
    public double clear() {
        this.answer = 0.0;
        return this.answer;
    }

    /**
     * Negates the current answer by turning it negative.
     *
     * @return answer after it's turned to negative.
     */
    public double negate() {
        this.answer *= -1;
        return this.answer;
    }

    /**
     * Converts the current answer to a percentage.
     *
     * @return answer after it's been converted to a percentage.
     */
    public double percent() {
        this.answer /= 100;
        return this.answer;
    }

    /**
     * Inverts the current answer.
     *
     * @return answer after it's been inverted.
     */
    public double invert() {
        this.answer = 1 / this.answer;
        return this.answer;
    }

    /**
     * Raises the current answer to the power of the operand.
     *
     * @param operand number that answer will be raised to the power of.
     * @return answer after it's been raised to the power of the operand.
     */
    public double toPower(double operand) {
        this.answer = Math.pow(this.answer, operand);
        return this.answer;
    }

    /**
     * Adds a random number between 0 and 1 to the current answer.
     *
     * @return answer after random number has been added.
     */
    public double randomize() {
        this.answer += Math.random();
        return this.answer;
    }

    /**
     * Rounds current answer to a specified number of decimals.
     *
     * @param operand number of decimals the answer needs to be rounded to.
     * @return answer after it has been rounded.
     */
    public double roundTo(int operand) {
        BigDecimal ans = new BigDecimal(this.answer); // creates a new BigDecimal instance with current answer's value.

        // rounds to specified # of decimals using setScale, converts to double, and updates answer.
        this.answer = ans.setScale(operand, RoundingMode.HALF_UP).doubleValue();
        return this.answer;
    }

    /**
     * Gets and returns current answer.
     *
     * @return current answer
     */
    public double getAnswer() {
        return this.answer;
    }

    /**
     * Prints current answer inside a right justified box.
     */
    public void printAnswer() {
        String answer = "" + this.answer;
        System.out.println("\n┌──────────────────────────┐");
        System.out.printf("│%25s │%n", answer); // formats string to right justified
        System.out.println("└──────────────────────────┘");
    }

}
