package demo.exams.twentytwo.ekata;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Result2 {
    @Test
    public void run() {
        String startDate = "2010-06-27";
        String endDate = "2010-06-27";
        List<String> knownTimestamps = Arrays.asList("2010-06-27 00:00",
                "2010-06-27 01:00",
                "2010-06-27 02:00",
                "2010-06-27 03:00",
                "2010-06-27 04:00",
                "2010-06-27 05:00",
                "2010-06-27 06:00",
                "2010-06-27 08:00",
                "2010-06-27 10:00",
                "2010-06-27 11:00",
                "2010-06-27 12:00",
                "2010-06-27 13:00",
                "2010-06-27 16:00",
                "2010-06-27 17:00",
                "2010-06-27 18:00",
                "2010-06-27 19:00",
                "2010-06-27 20:00",
                "2010-06-27 21:00",
                "2010-06-27 23:00");
        List<Integer> pricesAtKnownTimeStamps = Arrays.asList(19,62,64,62,63,63,64,63,64,48,
                46,
                45,
                44,
                46,
                47,
                48,
                49,
                51,
                52,
                52,
                5);
        List<Integer> result = predictMissingPrices(startDate, endDate, knownTimestamps, pricesAtKnownTimeStamps, null);

        System.out.println("Result: " + result);
//        Assert.assertEquals(3, result);
    }

    @Test
    public void run2() {
        String startDate = "2010-06-27";
        String endDate = "2010-06-27";
        List<String> knownTimestamps = Arrays.asList("2020-09-01 00:00", "2020-09-01 01:00", "2020-09-01 02:00", "2020-09-01 04:00", "2020-09-01 05:00", "2020-09-01 06:00", "2020-09-01 07:00", "2020-09-01 08:00", "2020-09-01 09:00", "2020-09-01 10:00", "2020-09-01 11:00", "2020-09-01 12:00", "2020-09-01 13:00", "2020-09-01 15:00", "2020-09-01 16:00", "2020-09-01 17:00", "2020-09-01 18:00", "2020-09-01 19:00", "2020-09-01 20:00", "2020-09-01 21:00", "2020-09-01 22:00", "2020-09-02 01:00", "2020-09-02 02:00", "2020-09-02 03:00", "2020-09-02 04:00", "2020-09-02 05:00", "2020-09-02 06:00", "2020-09-02 07:00", "2020-09-02 08:00", "2020-09-02 09:00", "2020-09-02 10:00", "2020-09-02 11:00", "2020-09-02 12:00", "2020-09-02 13:00", "2020-09-02 14:00", "2020-09-02 15:00", "2020-09-02 16:00", "2020-09-02 17:00", "2020-09-02 18:00", "2020-09-02 19:00", "2020-09-02 20:00", "2020-09-02 21:00", "2020-09-02 22:00", "2020-09-02 23:00");
        List<Integer> pricesAtKnownTimeStamps = Arrays.asList(100, 100, 100, 103, 103, 106, 106, 106, 109, 109, 109, 112, 112, 115, 115, 115, 118, 118, 118, 121, 121, 124, 124, 127, 127, 127, 130, 130, 130, 133, 133, 133, 136, 136, 136, 139, 139, 139, 142, 142, 142, 145, 145, 145);
        List<Integer> result = predictMissingPrices(startDate, endDate, knownTimestamps, pricesAtKnownTimeStamps, null);

        System.out.println("Result: " + result);
//        Assert.assertEquals(3, result);
    }

    private static final Duration HOUR = Duration.ofHours(1L);

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static List<Integer> predictMissingPrices(String startDate, String endDate, List<String> knownTimestamps, List<Integer> pricesAtKnownTimeStamps, List<String> unknownTimestamps) {

        // TODO not working
        List<Integer> results = new LinkedList<>();
        List<String> tempKnownTimestamps = new ArrayList<>(knownTimestamps);
        List<Integer> tempPricesAtKnownTimeStamps = new ArrayList<>(pricesAtKnownTimeStamps);

        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);

        for (int i = 0; i < tempKnownTimestamps.size() - 1; i++) {
            LocalDateTime currentTime = LocalDateTime.parse(tempKnownTimestamps.get(i), FORMATTER);
            LocalDateTime followingTime = LocalDateTime.parse(tempKnownTimestamps.get(i + 1), FORMATTER);

            Duration duration = Duration.between(currentTime, followingTime);
            if (!duration.equals(HOUR)) {
                int currentPrice = tempPricesAtKnownTimeStamps.get(i);
                int nextPrice = tempPricesAtKnownTimeStamps.get(i + 1);
                if (currentPrice > nextPrice) {
//                    int predictedValue = (int) Math.round(currentPrice * 0.9);
                    int diff = (currentPrice - nextPrice) / 2;
                    int predictedValue = currentPrice - diff;
                    results.add(predictedValue);
                    String missingTime = currentTime.plusHours(1L).toString();
                    var formattedMissingTime = missingTime.replace("T", " ");
                    tempKnownTimestamps.add((i + 1), formattedMissingTime);
                    tempPricesAtKnownTimeStamps.add((i + 1), predictedValue);
                } else {
//                    int predictedValue = (int) Math.round(currentPrice * 1.1);
                    int diff = (nextPrice - currentPrice) / 2;
                    int predictedValue = currentPrice + diff;
                    results.add(predictedValue);
                    String missingTime = currentTime.plusHours(1L).toString();
                    var formattedMissingTime = missingTime.replace("T", " ");
                    tempKnownTimestamps.add(i + 1, formattedMissingTime);
                    tempPricesAtKnownTimeStamps.add(i + 1, predictedValue);
                }
            }
        }
        return results;
    }

}
