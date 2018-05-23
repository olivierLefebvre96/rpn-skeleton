package calculator.token;

import java.math.BigDecimal;

/**
 * Interface representing chars/Strings which are evaluated
 */
public interface Token {
    /**
     * Evaluate a token by evaluating him and returning its BigDecimal value
     * @return A BigDecimal instance representing the evaluated token(s)
     */
    BigDecimal evaluate();
}
