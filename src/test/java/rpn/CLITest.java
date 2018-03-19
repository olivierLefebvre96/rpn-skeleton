package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.evaluate;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_simple_soustraction() {
        assertThat(evaluate("15 12 -")).isEqualTo(3);
    }

    @Test
    public void should_evaluate_more_complex_soustraction() {
        assertThat(evaluate("2 7 - 19 -")).isEqualTo(-24);
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        assertThat(evaluate("17 17 *")).isEqualTo(289);
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        assertThat(evaluate("-7 5 3 * *")).isEqualTo(-105);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(evaluate("22 11 /")).isEqualTo(2);
    }

    @Test
    public void should_evaluate_more_complex_division() {
        assertThat(evaluate("10 2 / 2 /")).isEqualTo(2.5);
    }
}