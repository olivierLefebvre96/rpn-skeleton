package calculator;

import calculator.token.Interpretor;
import org.assertj.core.data.Percentage;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpretorTest {
    @Test
    public void should_evaluate_single_digit_constant() {
        Interpretor.interpret("5");
        assertThat(Interpretor.lastResult).isEqualTo(BigDecimal.valueOf(5.0));
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        Interpretor.interpret("17");
        assertThat(Interpretor.lastResult).isEqualTo(BigDecimal.valueOf(17.0));
    }

    @Test
    public void should_evaluate_simple_addition() {
        Interpretor.interpret("17 5 +");
        assertThat(Interpretor.lastResult).isEqualTo(BigDecimal.valueOf(22.0));
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        Interpretor.interpret("2 3 5 + +");
        assertThat(Interpretor.lastResult).isEqualTo(BigDecimal.valueOf(10.0));
    }

    @Test
    public void should_evaluate_simple_subtraction() {
        Interpretor.interpret("15 12 -");
        assertThat(Interpretor.lastResult).isEqualTo(BigDecimal.valueOf(3.0));
    }

    @Test
    public void should_evaluate_more_complex_subtraction() {
        Interpretor.interpret("2 7 - 19 -");
        assertThat(Interpretor.lastResult).isEqualTo(BigDecimal.valueOf(-24.0));
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        Interpretor.interpret("17 17 *");
        assertThat(Interpretor.lastResult).isCloseTo(BigDecimal.valueOf(289.0), Percentage.withPercentage(0.001));
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        Interpretor.interpret("-7 5 3 * *");
        assertThat(Interpretor.lastResult).isCloseTo(BigDecimal.valueOf(-105.0), Percentage.withPercentage(0.001));
    }

    @Test
    public void should_evaluate_simple_division() {
        Interpretor.interpret("22 11 /");
        assertThat(Interpretor.lastResult).isEqualTo(BigDecimal.valueOf(2.0));
    }

    @Test
    public void should_evaluate_more_complex_division() {
        Interpretor.interpret("10 2 / 2 /");
        assertThat(Interpretor.lastResult).isCloseTo(BigDecimal.valueOf(2.5), Percentage.withPercentage(0.001));
    }

    @Test
    public void should_be_null(){
        Interpretor.lastResult = null;
        Interpretor.interpret("5 d+");

        assertThat(Interpretor.lastResult == null).isTrue();
    }
}