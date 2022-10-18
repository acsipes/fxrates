package demo.exams.twentytwo.ekata;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Result {

    @Test
    public void run() {
        int instances = 2;
        List<Integer> averageUtil = Arrays.asList(25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80);

        int result = finalInstances(instances, averageUtil);

        System.out.println("Result: " + result);
        Assert.assertEquals(2, result);
    }
    @Test
    public void run2() {
        int instances = 5;
        List<Integer> averageUtil = Arrays.asList(30,5,4,8,19,89);

        int result = finalInstances(instances, averageUtil);

        System.out.println("Result: " + result);
        Assert.assertEquals(3, result);
    }


    public static int finalInstances(int instances, List<Integer> averageUtil) {
        int result = instances;
        double max = 2 * Math.pow(10, 8);

        for (int i = 0; i < averageUtil.size(); i++) {
            if (result > 1 && averageUtil.get(i) < 25) {
                if (result % 2 == 0) {
                    result /= 2;
                } else {
                    result = result / 2 + 1;
                }
                i += 10;
            } else if (result * 2 < max && averageUtil.get(i) > 60) {
                result *= 2;
                i += 10;
            }
        }
        return result;
    }
}
