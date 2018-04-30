package calculation;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnTest {
    private Operation operation;

    @Test
    public void should_evaluate_single_digit_constant() {
        operation = new Rpn();

        assertThat(operation.compute("5")).isEqualTo(BigDecimal.valueOf(5.0));
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        operation = new Rpn();

        assertThat(operation.compute("17")).isEqualTo(BigDecimal.valueOf(17.0));
    }

    @Test
    public void should_evaluate_simple_addition() {
        operation = new Rpn();

        assertThat(operation.compute("17 5 +")).isEqualTo(BigDecimal.valueOf(22.0));
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        operation = new Rpn();

        assertThat(operation.compute("2 3 5 + +")).isEqualTo(BigDecimal.valueOf(10.0));
    }

    @Test
    public void should_evaluate_simple_subtraction() {
        operation = new Rpn();

        assertThat(operation.compute("15 12 -")).isEqualTo(BigDecimal.valueOf(3.0));
    }

    @Test
    public void should_evaluate_more_complex_subtraction() {
        operation = new Rpn();

        assertThat(operation.compute("2 7 - 19 -")).isEqualTo(BigDecimal.valueOf(-24.0));
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        operation = new Rpn();

        assertThat(operation.compute("17 17 *")).isEqualTo(BigDecimal.valueOf(289.0));
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        operation = new Rpn();

        assertThat(operation.compute("-7 5 3 * *")).isEqualTo(BigDecimal.valueOf(-105.0));
    }

    @Test
    public void should_evaluate_simple_division() {
        operation = new Rpn();

        assertThat(operation.compute("22 11 /")).isEqualTo(BigDecimal.valueOf(2.0));
    }

    @Test
    public void should_evaluate_more_complex_division() {
        operation = new Rpn();

        assertThat(operation.compute("10 2 / 2 /")).isEqualTo(BigDecimal.valueOf(2.5));
    }

    @Test
    public void should_be_null(){
        operation = new Rpn();
        boolean isNull = operation.compute("5 d+") == null;

        assertThat(isNull).isTrue();
    }
}