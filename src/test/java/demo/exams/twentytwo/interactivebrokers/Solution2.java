package demo.exams.twentytwo.interactivebrokers;

import org.junit.jupiter.api.Test;

public class Solution2 {

    @Test
    public void run() {
        int[] array  = {1, 1, 2, 2, 3};
        int result = solution(array);
        System.out.println("Result: " + result);
    }

    int solution(int[] A) {
//        int ans = 0;
        int ans = A[1];
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }
}
