package calculator.listener;


public interface Message {
    Class<? extends Message> getType();
}
