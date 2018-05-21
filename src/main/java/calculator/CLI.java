package calculator;

import calculator.token.Interpretor;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static void main(String[] args) {
        String tokens = Stream.of(args).collect(Collectors.joining(" ")).trim();

        System.out.println("About to evaluate: '" + tokens + "'");

        Interpretor.interpret(tokens);
    }
}
