package calculator.listener.event;

import calculator.listener.Channel;
import calculator.listener.DynamicRouter;
import calculator.listener.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Dispatches the events
 */
public class EventDispatcher implements DynamicRouter<Event> {
    private Map<Class<? extends Event>, Handler> handlers;

    /**
     * Constructor
     */
    public EventDispatcher() {
        handlers = new HashMap<>();
    }

    /**
     * Registers a new handler to a class
     * @param contentType Class which extends the Event class
     * @param channel Event handler
     */
    @Override
    public void registerChannel(Class<? extends Event> contentType, Channel<? extends Event> channel) {
        handlers.put(contentType, (Handler)channel);
    }

    /**
     * Unregisters a new handler to a class
     * @param contentType Class which extends the Event class
     * @param channel Event handler
     */
    @Override
    public void unregisterChannel(Class<? extends Event> contentType, Channel<? extends Event> channel) {
        handlers.remove(contentType, channel);
    }

    /**
     * Dispatches the created handlers
     * @param content A class which extends the Event class
     */
    @Override
    public void dispatch(Event content) {
        handlers.get(content.getClass()).dispatch(content);
    }
}
