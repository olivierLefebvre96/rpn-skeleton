package calculator.listener;

/**
 * Channel interface
 * @param <E> A class implementing the Message interface
 */
public interface Channel<E extends Message> {
    void dispatch(E message);
}
