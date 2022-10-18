package demo.exams.twenty.emarsys.a2019;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class DueDateCalculatorTest {

    public static final int FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME = 160;
    public static final int ONE_WORKING_DAY_TURNAROUND_TIME = 8;
    private DueDateCalculator underTest;

    @Before
    public void setup() {
        underTest = new DueDateCalculator();
    }

    @Test
    public void testCalculateDueDateWithinDay() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        int turnaroundTime = ONE_WORKING_DAY_TURNAROUND_TIME / 2;
        LocalDateTime expected = LocalDateTime.of(2019, 12, 16, 14, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, turnaroundTime);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateForNextDay() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 16, 15);
        int fourHoursTurnaroundTime = ONE_WORKING_DAY_TURNAROUND_TIME / 2;
        LocalDateTime expected = LocalDateTime.of(2019, 12, 17, 12, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, fourHoursTurnaroundTime);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateWithEightHours() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        LocalDateTime expected = LocalDateTime.of(2019, 12, 17, 10, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, ONE_WORKING_DAY_TURNAROUND_TIME);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateWithFullWeekWorkingHours() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        int fullWeekWorkingHoursTurnaroundTime = ONE_WORKING_DAY_TURNAROUND_TIME * 5;
        LocalDateTime expected = LocalDateTime.of(2019, 12, 23, 10, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, fullWeekWorkingHoursTurnaroundTime);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateDueDateWithOneMonth() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 10, 15);
        LocalDateTime expected = LocalDateTime.of(2020, 1, 13, 10, 15);

        LocalDateTime actual = underTest.calculateDueDate(submitDate, FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = WrongReportTimeException.class)
    public void testCalculateDueDateWithAfterWorkReportTime() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 16, 18, 15);

        underTest.calculateDueDate(submitDate, FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME);
    }

    @Test(expected = WrongReportTimeException.class)
    public void testCalculateDueDateWithWeekendReportTime() throws WrongReportTimeException {
        LocalDateTime submitDate = LocalDateTime.of(2019, 12, 14, 10, 15);

        underTest.calculateDueDate(submitDate, FOUR_WEEKS_WORKING_HOURS_TURNAROUND_TIME);
    }
}
