package calculator.token;

import java.math.BigDecimal;

public class ResultPrinter {
    /**
     * Prints the result to the terminal
     * @param input Operation before processing
     * @param output Operation's result after processing
     */
    public void printResult(String input, BigDecimal output){
        if(output == null) {
            return;
        }

        System.out.println("( " + input + " ) = " + output);
    }
}
