package calculator.token.event;

import calculator.listener.event.Event;
import calculator.token.Tokenizer;

/**
 * Event class for the Tokenizer class
 */
class TokenizerEvent extends Event {
    Tokenizer tokenizer;

    TokenizerEvent(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }
}
