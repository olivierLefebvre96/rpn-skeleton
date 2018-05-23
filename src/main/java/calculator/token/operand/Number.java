package calculator.token.operand;

import calculator.token.Token;

import java.math.BigDecimal;

/**
 * Operand which represents BigDecimal mathematical numbers
 */
public class Number implements Token {

    private final BigDecimal number;

    public Number(BigDecimal number){
        this.number = number;
    }

    @Override
    public BigDecimal evaluate() {
        return number;
    }
}