package Project01;


public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator myCalc = new Calculator(); // create a calculator for the demo
        double number = 0; // initialize the number
        String operation = "+"; // initialize the operation

        System.out.println("*** Welcome to Calculator ***");

        /*
        This do-while loop runs at least one time and repeats as long
        the operation is not "Q" or "q", which exits the Calculator application
        */
        do {

            /*
            If the performed operation requires an additional number (when performing addition,
            multiplication, division, etc.) it gets the user's next number.
             */
            if (!operation.equals("=") && !operation.equals("?") && !operation.equals("%") &&
                    !operation.equals("neg") && !operation.equals("inv") && !operation.equals("c") &&
                    !operation.equals("C") && !operation.equals("rand")) // don't get a number in these cases...
                number = myCalc.getUserNum(); // ... otherwise, go ahead and get user's next number

            myCalc.calculateAnswer(operation, number); // run the calculation
            operation = myCalc.getUserOp(); // get the user's next operation

        } while (!operation.equals("q") && !operation.equals("Q")); // 'Q' to quit

        System.out.println("<end>");
    }


}
