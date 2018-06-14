package calculator.token;

import java.math.BigDecimal;

/**
 * Represents an mathematical expression which is composed of tokens
 */
public class Expression implements Token {
    protected final Token leftToken;
    protected final Token rightToken;

    /**
     * Constructor with two tokens to evaluate together
     * @param leftToken The left token to evaluate
     * @param rightToken the right token to evaluate
     */
    protected Expression(Token leftToken, Token rightToken){
        this.leftToken = leftToken;
        this.rightToken = rightToken;
    }

    @Override
    public BigDecimal evaluate() {
        return null;
    }
}
