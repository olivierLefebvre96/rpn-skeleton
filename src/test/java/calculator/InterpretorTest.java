package calculator;

import calculator.listener.event.EventDispatcher;
import calculator.token.event.TokenDispatcher;
import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpretorTest {
    private EventDispatcher eventDispatcher = new EventDispatcher();

    @Before
    public void registration(){
        TokenDispatcher.registration(eventDispatcher);
    }

    @Test
    public void should_evaluate_single_digit_constant() {
        TokenDispatcher.eventDispatching(eventDispatcher, "5");
        assertThat(TokenDispatcher.lastResult).isEqualTo(BigDecimal.valueOf(5.0));
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        TokenDispatcher.eventDispatching(eventDispatcher, "17");
        assertThat(TokenDispatcher.lastResult).isEqualTo(BigDecimal.valueOf(17.0));
    }

    @Test
    public void should_evaluate_simple_addition() {
        TokenDispatcher.eventDispatching(eventDispatcher, "17 5 +");
        assertThat(TokenDispatcher.lastResult).isEqualTo(BigDecimal.valueOf(22.0));
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        TokenDispatcher.eventDispatching(eventDispatcher, "2 3 5 + +");
        assertThat(TokenDispatcher.lastResult).isEqualTo(BigDecimal.valueOf(10.0));
    }

    @Test
    public void should_evaluate_simple_subtraction() {
        TokenDispatcher.eventDispatching(eventDispatcher, "15 12 -");
        assertThat(TokenDispatcher.lastResult).isEqualTo(BigDecimal.valueOf(3.0));
    }

    @Test
    public void should_evaluate_more_complex_subtraction() {
        TokenDispatcher.eventDispatching(eventDispatcher, "2 7 - 19 -");
        assertThat(TokenDispatcher.lastResult).isEqualTo(BigDecimal.valueOf(-24.0));
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        TokenDispatcher.eventDispatching(eventDispatcher, "17 17 *");
        assertThat(TokenDispatcher.lastResult).isCloseTo(BigDecimal.valueOf(289.0), Percentage.withPercentage(0.001));
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        TokenDispatcher.eventDispatching(eventDispatcher, "-7 5 3 * *");
        assertThat(TokenDispatcher.lastResult).isCloseTo(BigDecimal.valueOf(-105.0), Percentage.withPercentage(0.001));
    }

    @Test
    public void should_evaluate_simple_division() {
        TokenDispatcher.eventDispatching(eventDispatcher, "22 11 /");
        assertThat(TokenDispatcher.lastResult).isEqualTo(BigDecimal.valueOf(2));
    }

    @Test
    public void should_evaluate_more_complex_division() {
        TokenDispatcher.eventDispatching(eventDispatcher, "10 2 / 2 /");
        assertThat(TokenDispatcher.lastResult).isCloseTo(BigDecimal.valueOf(2.5), Percentage.withPercentage(0.001));
    }

    @Test
    public void should_be_null(){
        TokenDispatcher.eventDispatching(eventDispatcher, "5 d+");
        assertThat(TokenDispatcher.lastResult == null).isTrue();
    }

    @Test
    public void should_evaluate_complex_operation(){
        TokenDispatcher.eventDispatching(eventDispatcher, "5 9 * 5 / 6 / 8 /");
        assertThat(TokenDispatcher.lastResult).isCloseTo(BigDecimal.valueOf(0.1875), Percentage.withPercentage(0.0001));
    }
}