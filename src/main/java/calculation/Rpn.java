package calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Stack;

class Rpn implements Operation {
    private Stack<BigDecimal> stack = new Stack<>();

    public BigDecimal compute(String expression){
        if (expression == null || expression.equals("")) return null;

        return evaluate(expression);
    }

    private BigDecimal evaluate(String expression) {
        Scanner scanner = new Scanner(expression);
        String occurrence;

        while(scanner.hasNext()){
            occurrence = scanner.next();

            if(!isOperator(occurrence)) {
                try {
                    stack.push(BigDecimal.valueOf(Double.parseDouble(occurrence)));
                } catch (NumberFormatException ex1) {
                    System.out.println("Bad formatted RPN.\n");
                    return null;
                }
            }
            else {
                if(stack.size() <= 1){
                    System.out.println("Invalid RPN. Check the last characters of your RPN expression.");
                    return null;
                }
                else {
                    processOperation(occurrence);
                    if(stack.size() == 0) return null;
                }
            }
        }

        if(stack.size() > 1) {
            System.out.println("Lack of mathematical operators to evaluate the expression.");
            return null;
        }

        return stack.pop();
    }

    /** Determine the type of operation to do in the stack
     * @param element String to evaluate
     */
    private void processOperation(String element){
        BigDecimal first;
        BigDecimal second;

        switch (element) {
            case "+":
                stack.push(stack.pop().add(stack.pop()));
                break;
            case "-":
                first = stack.pop();
                second = stack.pop();

                stack.push(second.subtract(first)); //-stack.pop() + stack.pop()
                break;
            case "*":
                stack.push(stack.pop().multiply(stack.pop()));
                break;
            case "/":
                first = stack.pop();
                second = stack.pop();

                if(first.equals(BigDecimal.ZERO)){
                    System.out.println("Division error. Trying to divide by zero?");
                    return;
                }

                stack.push(second.divide(first, RoundingMode.UNNECESSARY));

                break;
        }
    }

    /**
     * Determine if the string parameter is a mathematical operator
     * @param element A string
     * @return True if the string parameter is a mathematical operator
     */
    private static boolean isOperator(String element){
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/");
    }
}
