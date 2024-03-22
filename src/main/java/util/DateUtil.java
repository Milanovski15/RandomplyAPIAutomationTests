package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DateUtil {

    DateTimeFormatter dtf;
    LocalDateTime time;

    public String currentTimeFormatted(){
        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        time = LocalDateTime.now().minusHours(1);

        return time.format(dtf);
    }

    public static String generateRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1940, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return randomDate.format(formatter);
    }
}
