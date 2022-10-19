package demo.exams.twentytwo.interactivebrokers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

    @Test
    public void run() {
        int[] array  = {-1, -2, -3, -4, -3};
        int result = solution(array);
        System.out.println("Result: " + result);
    }

    public int solution(int[] A) {
        List<Integer> list = new LinkedList<>();
        Arrays.stream(A).sorted().forEach(list::add);
        int result = 0;
        int i = 0;
        boolean hasResult = false;
        while (i < list.size() && list.get(i) < 0 && !hasResult) {
            int abs = (Math.abs(list.get(i)));
            if (list.contains(abs)) {
                result = abs;
                hasResult = true;
            }
            i++;
        }
        return result;
    }

}
