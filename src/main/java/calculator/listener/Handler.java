package calculator.listener;

import calculator.listener.event.Event;

/**
 * Allows to handle event dispatching
 */
public class Handler implements Channel<Event> {
    /**
     * Dispatch an event.
     * Prints the current class by default.
     * @param message An class which extends the Event class
     */
    @Override
    public void dispatch(Event message) {
        System.out.println(message.getClass());
    }
}
