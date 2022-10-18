package demo.exams.twentytwo.interactivebrokers;


import org.junit.Test;

import java.util.*;

public class Solution {

    @Test
    public void run() {
        int[] array  = {1, 3, 6, 4, 1, 2, 7,10,5,9,12,11, -8, -6, -5};
        int result = solution(array);
        System.out.println("Result: " + result);
    }

    public int solution(int[] A) {

        Set<Integer> ints = new HashSet<>();
        Arrays.stream(A)
                .filter(it -> it > 0)
                .sorted()
                .forEach(ints::add);

        System.out.println("List: " + ints);

        return getSmallest(ints);


    }

    private int getSmallest(Set<Integer> ints) {
        int result = 1;
        for (int i = 1; i < 100001; i++) {
            if (!ints.contains(i)) {
                return i;
            }
        }
        return result;

    }
}
