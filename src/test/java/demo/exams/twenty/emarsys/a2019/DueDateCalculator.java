package demo.exams.twenty.emarsys.a2019;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.LocalDateTime;

public class DueDateCalculator {

    private static final int END_OF_WORK_TIME = 17;
    private static final int NON_WORKING_HOURS_A_DAY = 16;
    private static final int WEEKEND_IN_DAYS = 2;

    public LocalDateTime calculateDueDate(LocalDateTime submitDateTime, int turnaroundTime) throws WrongReportTimeException{

        if (isAfterWork(submitDateTime) || isWeekend(submitDateTime)) {
            throw new WrongReportTimeException("Issue time report must be within working hours");
        }

        LocalDateTime result = submitDateTime.plusNanos(0);

        for (int i = 0; i < turnaroundTime; i++) {
            result = result.plusHours(1);
            if (isAfterWork(result)) {
                result = result.plusHours(NON_WORKING_HOURS_A_DAY);
                if (isWeekend(result)) {
                    result = result.plusDays(WEEKEND_IN_DAYS);
                }
            }
        }
        return result;
    }

    private boolean isAfterWork(LocalDateTime submitDateTime) {
        return submitDateTime.getHour() >= END_OF_WORK_TIME;
    }

    private boolean isWeekend(LocalDateTime date) {
        return date.getDayOfWeek().equals(SATURDAY) || date.getDayOfWeek().equals(SUNDAY);
    }
}
