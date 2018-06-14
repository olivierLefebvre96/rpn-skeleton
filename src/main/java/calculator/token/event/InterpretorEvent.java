package calculator.token.event;

import calculator.listener.event.Event;
import calculator.token.Interpretor;

/**
 * Event class for the Interpretor class
 */
class InterpretorEvent extends Event {
    Interpretor interpretor;

    InterpretorEvent(Interpretor interpretor) {
        this.interpretor = interpretor;
    }
}
