package calculator.token.operator;

import calculator.token.Expression;
import calculator.token.Token;

import java.math.BigDecimal;

/**
 * Product expression for evaluating mathematical multiplications
 */
public class Product extends Expression {
    Product(Token leftToken, Token rightToken) {
        super(leftToken, rightToken);
    }

    @Override
    public BigDecimal evaluate() {
        return BigDecimal.ZERO.add(leftToken.evaluate()).multiply(rightToken.evaluate());
    }
}
