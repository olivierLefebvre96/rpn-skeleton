package calculator.token.operator;

import calculator.token.Expression;
import calculator.token.Token;

import java.math.BigDecimal;

public class Subtract extends Expression {
    Subtract(Token leftToken, Token rightToken) {
        super(leftToken, rightToken);
    }

    @Override
    public BigDecimal evaluate() {
        return BigDecimal.ZERO.add(leftToken.evaluate()).subtract(rightToken.evaluate());
    }
}
