package calculator.listener.event;

import calculator.listener.Message;

/**
 * Custom event class
 */
public class Event implements Message {
    /**
     * Gets the current class Type
     * @return the current class Type
     */
    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
