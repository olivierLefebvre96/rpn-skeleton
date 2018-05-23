package calculator.token.operator;

import calculator.token.Expression;
import calculator.token.Token;

import java.math.BigDecimal;

/**
 * Add expression for evaluating mathematical additions
 */
public class Add extends Expression {
    Add(Token leftToken, Token rightToken) {
        super(leftToken, rightToken);
    }

    @Override
    public BigDecimal evaluate() {
        return BigDecimal.ZERO.add(leftToken.evaluate()).add(rightToken.evaluate());
    }
}
