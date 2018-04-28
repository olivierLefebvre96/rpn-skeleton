package calculation;

import java.math.BigDecimal;

public interface Operation {
    BigDecimal compute(String expression);
}
