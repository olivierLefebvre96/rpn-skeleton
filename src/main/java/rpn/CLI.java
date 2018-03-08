package rpn;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" ")).trim();

        System.out.println("About to evaluate '" + expression + "'");

        BigDecimal result = !expression.equals("") ? BigDecimal.valueOf(evaluate(expression)) : BigDecimal.valueOf(0.0);

        System.out.println("> " + result);
    }

    static Double evaluate(String expression) {
        Scanner scanner = new Scanner(expression);
        Stack<Double> stack = new Stack<>();
        String occurrence;

        while(scanner.hasNext()){
            occurrence = scanner.next();

            if(!isOperator(occurrence)) {
                try {
                    stack.push(Double.parseDouble(occurrence));
                } catch (NumberFormatException arrEx) {
                    throw new NumberFormatException("Bad formatted RPN.\n");
                }
            }
            else {
                if(stack.size() <= 1){
                    System.out.println("Invalid RPN. Check the last characters of your RPN expression.");
                    return 0.0;
                }
                else {
                    compute(stack, occurrence);
                    if(stack.size() == 0) return 0.0;
                }
            }
        }

        if(stack.size() > 1) {
            System.out.println("Lack of mathematical operators to evaluate the expression.");
            return 0.0;
        }

        return stack.pop();
    }

    private static void compute(Stack<Double> stack, String occurrence){
        switch (occurrence) {
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

    private static boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
