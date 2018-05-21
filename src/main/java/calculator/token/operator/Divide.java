package calculator.token.operator;

import calculator.token.Expression;
import calculator.token.Token;

import java.math.BigDecimal;
import java.util.Objects;

public class Divide extends Expression {
    Divide(Token leftToken, Token rightToken) {
        super(leftToken, rightToken);
    }

    @Override
    public BigDecimal evaluate() {
        if(Objects.equals( leftToken.evaluate(), BigDecimal.ZERO)) {
            System.out.println("No right operand permitted as zero for division operations.");
            return null;
        }

        return BigDecimal.ZERO.add(leftToken.evaluate()).divide(rightToken.evaluate(), BigDecimal.ROUND_UNNECESSARY);
    }
}
