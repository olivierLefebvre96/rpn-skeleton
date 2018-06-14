package calculator.token;

import calculator.token.operand.Number;
import calculator.token.operator.OperatorRegistry;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Stack;

/**
 * Interpretor class which tokenizes the input
 */
public class Interpretor {
    private OperatorRegistry operatorRegistry = new OperatorRegistry();
    private Stack<Token> stack = new Stack<>();

    /**
     * Processes the input String
     * @param tokensToEvaluate The input String to evaluate
     */
    public BigDecimal interpret(String[] tokensToEvaluate){
        if (tokensToEvaluate == null) return null;

        for (String stringToken : tokensToEvaluate) {
            if (operatorRegistry.isOperator(stringToken)) {

                BigDecimal result = extractResult(stringToken);

                if (result == null) return null;

                stack.push(new Number(result));

            } else {
                Double doubleToken = Double.parseDouble(stringToken);
                Token numberToken = new Number(BigDecimal.valueOf(doubleToken));

                stack.push(numberToken);
            }
        }

        return stack.pop().evaluate();
    }

    /**
     * Check the expression by evaluating it and returns it
     * @param stringToken The current token
     * @return The evaluated result or null if error
     */
    private BigDecimal extractResult(String stringToken) {
        Token rightToken = stack.pop();
        Token leftToken = stack.pop();
        Token operator = operatorRegistry.getOperator(stringToken, leftToken, rightToken);

        if(operator == null) {
            System.out.println("Unexpected token found instead of an operator.");
            return null;
        }

        BigDecimal result = operator.evaluate();

        if(result == null) {
            System.out.println("Result could not be evaluated due to an unknown error.");
            return null;
        }
        return result;
    }
}
