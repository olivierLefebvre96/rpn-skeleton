package calculator.token.event;

import calculator.listener.event.Event;
import calculator.token.Interpretor;
import calculator.token.ResultPrinter;

/**
 * Event class for the ResultPrinter class
 */
class ResultPrinterEvent extends Event {
    ResultPrinter resultPrinter;

    ResultPrinterEvent(ResultPrinter resultPrinter) {
        this.resultPrinter = resultPrinter;
    }
}
