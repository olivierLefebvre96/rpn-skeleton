package calculation;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

class Rpn implements Operation {
    private Stack<Double> stack = new Stack<>();

    public BigDecimal compute(String expression){
        if (!expression.equals("")) {
            Double result = evaluate(expression);

            return result != null ? BigDecimal.valueOf(result) : null;
        }

        return null;
    }

    private Double evaluate(String expression) {
        Scanner scanner = new Scanner(expression);
        String occurrence;

        while(scanner.hasNext()){
            occurrence = scanner.next();

            if(!isOperator(occurrence)) {
                try {
                    stack.push(Double.parseDouble(occurrence));
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
        switch (element) {
            case "+":
                stack.push(stack.pop() + stack.pop());
                break;
            case "-":
                stack.push(-stack.pop() + stack.pop());
                break;
            case "*":
                stack.push(stack.pop() * stack.pop());
                break;
            case "/":
                Double first = stack.pop();
                Double second = stack.pop();

                if(first == 0){
                    System.out.println("Division error. Trying to divide by zero?");
                    return;
                }

                stack.push(second / first);

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
