package demo.exams.twentytwo.accenture;

import java.util.*;

public class GroupSelector {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(90);
        numbers.add(36);
        numbers.add(45);

        numbers.add(13);
        numbers.add(22);

        numbers.add(42);
        numbers.add(15);
        numbers.add(33);
        numbers.add(51);

        numbers.add(44);
        numbers.add(71);
        numbers.add(80);

        Map<Integer, List<Integer>> groups = grouping(numbers);

        System.out.println("Groups: " + groups);

        List<Integer> result = getBiggestPair(groups);

        System.out.println("result: " + result);
    }

    private static int digitSum(int elem) {
        int sum = 0;
        int num = elem;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    private static Map<Integer, List<Integer>> grouping(List<Integer> list) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int elem: list) {
            int sumOfDigit = digitSum(elem);
            if (result.get(sumOfDigit) != null) {
                result.get(sumOfDigit).add(elem);
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(elem);
                result.put(sumOfDigit, tempList);
            }
        }
        return result;
    }

    private static List<Integer> getTwoBiggest(List<Integer> list) {
        list.sort(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();
        result.add(list.get(0));
        result.add(list.get(1));
        System.out.println("Biggest two: " + result);
        return result;
    }

    private static List<Integer> getBiggestPair(Map<Integer, List<Integer>> groups) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : groups.values()) {
            List<Integer> groupsSum = getTwoBiggest(list);
            if (result.isEmpty()) {
                result.add(groupsSum.get(0));
                result.add(groupsSum.get(1));
            } else if (result.get(0) + result.get(1) < groupsSum.get(0) + groupsSum.get(1)) {
                result.clear();
                result.add(groupsSum.get(0));
                result.add(groupsSum.get(1));
            }
        }
        return result;
    }
}
