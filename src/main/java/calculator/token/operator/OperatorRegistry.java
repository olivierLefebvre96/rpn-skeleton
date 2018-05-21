package calculator.token.operator;

import calculator.token.*;

public class OperatorRegistry {
    public static boolean isOperator(String stringToken) {
        return stringToken.equals("+") || stringToken.equals("-") || stringToken.equals("*") || stringToken.equals("/");
    }

    public static Expression getOperator(String stringToken, Token left, Token right) {
        switch (stringToken) {
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
