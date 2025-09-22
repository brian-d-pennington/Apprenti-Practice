import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercise04 {

    // BigDecimal
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Add a, b, and c together and return the result
    BigDecimal add(BigDecimal a, BigDecimal b, BigDecimal c) {
        return a.add(b).add(c);
    }

    // 2. Divide a by b and return the result with only two decimal points
    BigDecimal divideWithTwoDecimalPlaces(BigDecimal a, BigDecimal b) {
        return a.divide(b, 2, RoundingMode.HALF_UP);
    }

    // 3. Calculate the sum of elements in values and return it with a scale of 4
    BigDecimal sum(BigDecimal[] values) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal value : values) {
            sum = sum.add(value);
        }
        return sum.setScale(4, RoundingMode.HALF_UP);
    }

    // 4. Calculate the average of elements in values
    BigDecimal average(BigDecimal[] values) {
        if (values == null || values.length == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal sum = sum(values);
        return sum.divide(BigDecimal.valueOf(values.length), 4, RoundingMode.HALF_UP);
    }

    // 5. Calculate total interest earned on an investment
    BigDecimal calculateInterest(BigDecimal investment, BigDecimal interestRate, int periods) {
        BigDecimal total = investment.multiply(BigDecimal.ONE.add(interestRate).pow(periods));
        return total.subtract(investment);
    }
}
