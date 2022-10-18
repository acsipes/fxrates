package demo.exams.twenty.emarsys.a2019;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DueDateCalculatorTest {

    public static final int FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME = 160;
    public static final int ONE_WORKING_DAY_TURNAROUND_TIME = 8;
    private DueDateCalculator underTest;

    @BeforeEach
    public void setup() {
        underTest = new DueDateCalculator();
    }

    @Test
    public void testCalculateDueDateWithinDay() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        int turnaroundTime = ONE_WORKING_DAY_TURNAROUND_TIME / 2;
        LocalDateTime expected = LocalDateTime.of(2019, 12, 16, 14, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, turnaroundTime);

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateForNextDay() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 16, 15);
        int fourHoursTurnaroundTime = ONE_WORKING_DAY_TURNAROUND_TIME / 2;
        LocalDateTime expected = LocalDateTime.of(2019, 12, 17, 12, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, fourHoursTurnaroundTime);

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateWithEightHours() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        LocalDateTime expected = LocalDateTime.of(2019, 12, 17, 10, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, ONE_WORKING_DAY_TURNAROUND_TIME);

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateWithFullWeekWorkingHours() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        int fullWeekWorkingHoursTurnaroundTime = ONE_WORKING_DAY_TURNAROUND_TIME * 5;
        LocalDateTime expected = LocalDateTime.of(2019, 12, 23, 10, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, fullWeekWorkingHoursTurnaroundTime);

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateWithOneMonth() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        LocalDateTime expected = LocalDateTime.of(2020, 1, 13, 10, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME);

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateWithAfterWorkReportTime() {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 18, 15);

        assertThrows(WrongReportTimeException.class, () -> underTest.calculateDueDate(submitDate, FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME));
    }

    @Test
    public void testCalculateDueDateWithWeekendReportTime() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 14, 10, 15);

        assertThrows(WrongReportTimeException.class, () -> underTest.calculateDueDate(submitDate, FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME));
    }
}
