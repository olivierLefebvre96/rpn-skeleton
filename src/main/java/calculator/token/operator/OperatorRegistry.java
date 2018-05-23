package calculator.token.operator;

import calculator.token.*;

/**
 * Class that registers all operator-related computing
 */
public class OperatorRegistry {
    /**
     * Checks if the token in parameter is an operator
     * @param stringToken The token to check
     * @return Is an operator char or not
     */
    public static boolean isOperator(String stringToken) {
        return stringToken.equals("+") || stringToken.equals("-") || stringToken.equals("*") || stringToken.equals("/");
    }

    /**
     * Identify the operator and performs the corresponding computing
     * @param operator The operator String
     * @param left The left token to evaluate
     * @param right The right token to evaluate
     * @return The Expression corresponding to the operator found
     */
    public static Expression getOperator(String operator, Token left, Token right) {
        switch (operator) {
            case "+":
                return new Add(left, right);
            case "-":
                return new Subtract(left, right);
            case "*":
                return new Product(left, right);
            case "/":
                return new Divide(left, right);
        }

        System.out.println("Unknown operator found.");

        return null;
    }
}
