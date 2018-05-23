package calculator.token;

import calculator.token.operand.Number;
import calculator.token.operator.OperatorRegistry;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Interpretor class which hosts the code to tokenize the input
 */
public class Interpretor {
    private static Stack<Token> stack = new Stack<>();
    public static BigDecimal lastResult = null;

    /**
     * Processes the input String
     * @param stringToEvaluate The input String to evaluate
     */
    public static void interpret(String stringToEvaluate){
        if(stringToEvaluate.isEmpty()) {
            System.out.println("Insufficient number of characters to interpret.");
            return;
        }

        if(containsIncorrectToken(stringToEvaluate)) {
            System.out.println("String to parse contains incorrect tokens such as letters which are currently not supported.");
            return;
        }

        String[] tokenArray = stringToEvaluate.split(" ");

        if(tokenArray.length <= 0) {
            System.out.println("Insufficient number of tokens to interpret.");
            return;
        }

        for (String stringToken : tokenArray) {
            if (OperatorRegistry.isOperator(stringToken)) {

                Token rightToken = stack.pop();
                Token leftToken = stack.pop();
                Token operator = OperatorRegistry.getOperator(stringToken, leftToken, rightToken);

                if(operator == null) {
                    System.out.println("Unexpected token found instead of an operator.");
                    return;
                }

                BigDecimal result = operator.evaluate();

                if(result == null) {
                    System.out.println("Result could not be evaluated due to an unknown error.");
                    return;
                }

                stack.push(new Number(result));

            } else {
                Double doubleToken = Double.parseDouble(stringToken);
                Token numberToken = new Number(BigDecimal.valueOf(doubleToken));
                stack.push(numberToken);
            }
        }

        lastResult = stack.pop().evaluate();

        printResult(stringToEvaluate, lastResult);
    }

    /**
     * Prints the result to the terminal
     * @param input Operation before processing
     * @param output Operation's result after processing
     */
    private static void printResult(String input, BigDecimal output){
        System.out.println("( " + input + " ) = " + output);
    }

    /**
     * Checks for incorrect and/or unknown tokens
     * @param stringToParse String to parse for incorrect tokens
     * @return Does it contains incorrect tokens or not?
     */
    private static boolean containsIncorrectToken(String stringToParse){
        return !stringToParse.matches("[\\d\\s-*/+]+");
    }
}
