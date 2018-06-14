package calculator.listener;

/**
 * Allows to register events to classes
 * @param <E> A class implementing the Message interface
 */
public interface DynamicRouter<E extends Message> {
    void registerChannel(Class<? extends E> contentType, Channel<? extends E> channel);
    void unregisterChannel(Class<? extends E> contentType, Channel<? extends E> channel);
    void dispatch(E content);
}
