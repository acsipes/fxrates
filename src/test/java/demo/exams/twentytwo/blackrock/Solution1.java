package demo.exams.twentytwo.blackrock;

import org.junit.jupiter.api.Test;

/**
 * future stock prices. the int ararys contains the daily prices in days order
 * need to find the best option, with lowest price in that day and sell the highest price's day
 */
public class Solution1 {

    String computeBestTransaction(int[] data) {
        var min = Integer.MAX_VALUE;
        var minDay = 1;
        var maxDiff = 0;
        var maxDay = 365;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[i] && ((data[j] - data[i]) > maxDiff)) {
                    maxDiff = (data[j] - data[i]);
                    minDay = i + 1;
                    maxDay = j + 1;
                }
            }
        }

        return String.format("BUY@%s on day %s and SELL@%s on day %s. For a profit of $%s per share!", data[minDay - 1], minDay, data[maxDay - 1], maxDay, data[maxDay - 1] - data[minDay - 1]);
    }

    @Test
    public void testStocksPirce() {

        int[] nums1 = {100, 101, 99, 94, 80, 99, 100, 111, 103, 102, 81, 85, 84, 95, 100, 105, 70, 75, 90, 110, 20};
        int[] nums2 = {100, 101, 99, 94, 80, 99, 100, 111, 103, 102, 81, 85, 84, 95, 100, 105, 70, 75, 90, 95, 20};
        int[] nums3 = {100, 101, 99, 94, 60, 99, 100, 110, 103, 102, 81, 85, 84, 95, 100, 105, 70, 75, 90, 112, 20, 30};
        int[] nums4 = {100, 101, 99, 94, 75, 99, 100, 101, 103, 102, 81, 85, 84, 95, 100, 105, 75, 100, 104, 70, 75, 90};
        int[] nums5 = {100, 90, 95, 100, 110, 100, 90, 100, 85};
        int[] nums6 = {100, 90, 95, 100, 110, 100, 90, 100,};

        System.out.println("result = " + computeBestTransaction(nums5));
    }
}
