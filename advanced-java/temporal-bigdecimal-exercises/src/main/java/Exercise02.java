import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Exercise02 {

    // LocalTime
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return the current time as a LocalTime
    LocalTime getNow() {
        return LocalTime.now();
    }

    // 2. return 4PM (tea time!) as a LocalTime.
    LocalTime getTeaTime() {
        return LocalTime.of(16, 0);
    }

    // 3. add 12 hours to the time parameter and return the value
    LocalTime add12Hours(LocalTime time) {
        return time.plusHours(12);
    }

    // 4. given a time parameter, return a list of the next 4
    // quarter-hour appointments available after the time.
    // appointment times should not include seconds even if the time parameter does.
    List<LocalTime> getQuarterHourAppointments(LocalTime time) {
        LocalTime current = time.withSecond(0).withNano(0);

        int minute = current.getMinute();
        int mod = minute % 15;
        if (mod != 0) {
            current = current.plusMinutes(15 - mod);
        }

        List<LocalTime> appointments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            appointments.add(current);
            current = current.plusMinutes(15);
        }

        return appointments;
    }
}
