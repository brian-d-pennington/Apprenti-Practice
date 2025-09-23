import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Calculate payment expected from a given date until the end of the year
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        LocalDate endOfYear = LocalDate.of(date.getYear(), Month.DECEMBER, 31);
        LocalDate firstFriday = findFirstFridayOfYear(date.getYear());

        BigDecimal total = BigDecimal.ZERO;
        BigDecimal payment = BigDecimal.TEN;

        for (LocalDate current = firstFriday; !current.isAfter(endOfYear); current = current.plusWeeks(2)) {
            if (!current.isBefore(date)) {
                total = total.add(payment);
            }
        }

        return total;
    }

    // 2. Calculate payments expected from a given date until the end of the year
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        LocalDate endOfYear = LocalDate.of(date.getYear(), Month.DECEMBER, 31);
        LocalDate firstFriday = findFirstFridayOfYear(date.getYear());

        BigDecimal total = BigDecimal.ZERO;

        for (LocalDate current = firstFriday; !current.isAfter(endOfYear); current = current.plusWeeks(2)) {
            if (!current.isBefore(date)) {
                BigDecimal payment = BigDecimal.valueOf(current.getDayOfMonth());
                total = total.add(payment);
            }
        }

        return total;
    }

    // method to find the first Friday of the given year
    private LocalDate findFirstFridayOfYear(int year) {
        LocalDate date = LocalDate.of(year, Month.JANUARY, 1);
        while (date.getDayOfWeek() != DayOfWeek.FRIDAY) {
            date = date.plusDays(1);
        }
        return date;
    }

}
