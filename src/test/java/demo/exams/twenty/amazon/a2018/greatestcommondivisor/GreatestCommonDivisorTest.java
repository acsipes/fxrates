package demo.exams.twenty.amazon.a2018.greatestcommondivisor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    public void sampleTest() {
        GreatestCommonDivisor underTest = new GreatestCommonDivisor();
        int num = 5;
        int[] arr = {4, 8, 16, 12, 20};
        int expectedResult = 4;

        int actual = underTest.calcGCD(num, arr);

        assertEquals(expectedResult, actual);

    }

    @Test
    public void firstTest() {
        GreatestCommonDivisor underTest = new GreatestCommonDivisor();
        int num = 5;
        int[] arr = {2, 3, 4, 5, 6};
        int expectedResult = 1;

        int actual = underTest.calcGCD(num, arr);

        assertEquals(expectedResult, actual);
    }

    @Test
    public void secondTest() {
        GreatestCommonDivisor underTest = new GreatestCommonDivisor();
        int num = 5;
        int[] arr = {2, 4, 6, 8, 10};
        int expectedResult = 2;

        int actual = underTest.calcGCD(num, arr);

        assertEquals(expectedResult, actual);
    }

    @Test
    public void thirdTest() {
        GreatestCommonDivisor underTest = new GreatestCommonDivisor();
        int num = 5;
        int[] arr = {8, 4, 2, 10, 6};
        int expectedResult = 2;

        int actual = underTest.calcGCD(num, arr);

        assertEquals(expectedResult, actual);
    }

    @Test
    public void fourthTest() {
        GreatestCommonDivisor underTest = new GreatestCommonDivisor();
        int num = 5;
        int[] arr = {840768, 37297, 151, 2567, 302};
        int expectedResult = 151;

        int actual = underTest.calcGCD(num, arr);

        assertEquals(expectedResult, actual);
     }

    @Test
    public void fifthTest() {
        GreatestCommonDivisor underTest = new GreatestCommonDivisor();
        int num = 8;
        int[] arr = {22, 187, 33, 11, 1122, 396, 1980, 9900};
        int expectedResult = 11;

        int actual = underTest.calcGCD(num, arr);

        assertEquals(expectedResult, actual);
    }
}
