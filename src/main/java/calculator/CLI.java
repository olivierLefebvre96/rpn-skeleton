package calculator;

import calculator.listener.event.EventDispatcher;
import calculator.token.event.TokenDispatcher;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new EventDispatcher();

        String tokens = Stream.of(args).collect(Collectors.joining(" ")).trim();

        System.out.println("About to evaluate: '" + tokens + "'");

        TokenDispatcher.inputTokens = tokens;
        TokenDispatcher.registration(eventDispatcher);

        TokenDispatcher.eventDispatching(eventDispatcher);
    }
}
