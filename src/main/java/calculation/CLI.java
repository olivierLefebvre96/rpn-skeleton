package calculation;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CLI {
    public static void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" ")).trim();

        Operation operation = new Rpn();

        System.out.println("About to evaluate '" + expression + "'");

        BigDecimal result = operation.compute(expression);

        System.out.println("> " + result);
    }
}
