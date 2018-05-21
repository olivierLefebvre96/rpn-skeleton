package calculator.token;

import calculator.token.operand.Number;
import calculator.token.operator.OperatorRegistry;

import java.math.BigDecimal;
import java.util.Stack;

public class Interpretor {
    public static Stack<Token> stack = new Stack<>();
    public static BigDecimal lastResult = null;

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

                if(operator == null) return;

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

    private static void printResult(String stringToPrint, BigDecimal evaluatedRpn){
        System.out.println("( " + stringToPrint + " ) = " + evaluatedRpn);
    }

    private static boolean containsIncorrectToken(String stringToParse){
        return !stringToParse.matches("[\\d\\s-*/+]+");
    }
}
