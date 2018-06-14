package calculator.token.event;

import calculator.listener.Handler;
import calculator.listener.event.Event;
import calculator.listener.event.EventDispatcher;
import calculator.token.Interpretor;
import calculator.token.ResultPrinter;
import calculator.token.Tokenizer;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * EventDispatcher related to token computing
 */
public class TokenDispatcher {
    public static String inputTokens = null;
    public static BigDecimal lastResult = null;

    private static String[] extractedTokens = null;

    /**
     * Registers an handle for each Event class
     * @param dispatcher EventDispatcher to which we register the channels
     */
    public static void registration(EventDispatcher dispatcher){
        dispatcher.registerChannel(TokenizerEvent.class, new Handler() {
            @Override
            public void dispatch(Event message) {
                TokenizerEvent tokenizerEvent = (TokenizerEvent) message;

                extractedTokens = tokenizerEvent.tokenizer.extractTokensIntoArray(inputTokens);
            }
        });

        dispatcher.registerChannel(InterpretorEvent.class, new Handler() {
            @Override
            public void dispatch(Event message) {
                InterpretorEvent interpretorEvent = (InterpretorEvent) message;

                lastResult = interpretorEvent.interpretor.interpret(extractedTokens);
            }
        });

        dispatcher.registerChannel(ResultPrinterEvent.class, new Handler() {
            @Override
            public void dispatch(Event message) {
                ResultPrinterEvent resultPrinterEvent = (ResultPrinterEvent) message;

                resultPrinterEvent.resultPrinter.printResult(Arrays.toString(extractedTokens), lastResult);
            }
        });
    }

    /**
     * Dispatch the registered events
     * @param dispatcher EventDispatcher to which we register the channels
     */
    public static void eventDispatching(EventDispatcher dispatcher) {
        dispatch(dispatcher);
    }

    /**
     * Dispatch the registered events and overwrites the current tokens String
     * @param dispatcher EventDispatcher to which we register the channels
     * @param tokens New String of tokens
     */
    public static void eventDispatching(EventDispatcher dispatcher, String tokens) {
        inputTokens = tokens;

        dispatch(dispatcher);
    }

    /**
     *
     * @param dispatcher EventDispatcher to which we register the channels
     */
    private static void dispatch(EventDispatcher dispatcher) {
        dispatcher.dispatch(new TokenizerEvent(new Tokenizer()));
        dispatcher.dispatch(new InterpretorEvent(new Interpretor()));
        dispatcher.dispatch(new ResultPrinterEvent(new ResultPrinter()));
    }
}
