package demo.exams.twentytwo.interactivebrokers;

import org.junit.Test;

public class Solution3 {

    @Test
    public void run() {
        int[] array  = {0,1,0,1,1,1};
        int result = solution(array);
        System.out.println("Result: " + result);
    }

    public int solution(int[] A) {
        int startWithZeroChanges = 0;
        int startWithOneChanges = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i % 2) {
                startWithOneChanges ++;
            } else if (A[i] == 1 - (i % 2)) {
                startWithZeroChanges ++;
            }
        }
        return Math.min(startWithZeroChanges, startWithOneChanges);
    }
}
