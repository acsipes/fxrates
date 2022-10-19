package demo.exams.twentytwo.morganstanley;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution2 {

    @Test
    public void run() {
        List<String> list1 = Arrays.asList("Alex", "Blake", "2");
        List<String> list2 = Arrays.asList("Blake", "Alex", "2");
        List<String> list3 = Arrays.asList("Casey", "Alex", "5");
        List<String> list4 = Arrays.asList("Blake", "Casey", "7");
        List<String> list5 = Arrays.asList("Alex", "Blake", "4");
        List<String> list6 = Arrays.asList("Alex", "Casey", "4");
        List<List<String>> debts = Arrays.asList(list1, list2, list3, list4, list5, list6);
        List<String> result = smallestNegativeBalance(debts);
        System.out.println("Result: " + result);
        List<String> expected = Arrays.asList("Alex", "Blake");
        assertEquals(expected, result);
    }

    @Test
    public void run2() {
        List<String> list1 = Arrays.asList("Alex", "Blake", "5");
        List<String> list2 = Arrays.asList("Blake", "Alex", "3");
        List<String> list3 = Arrays.asList("Casey", "Alex", "7");
        List<String> list4 = Arrays.asList("Casey", "Alex", "4");
        List<String> list5 = Arrays.asList("Casey", "Alex", "2");
        List<List<String>> debts = Arrays.asList(list1, list2, list3, list4, list5);
        List<String> result = smallestNegativeBalance(debts);
        System.out.println("Result: " + result);
        List<String> expected = Arrays.asList("Casey");
        assertEquals(expected, result);
    }

    @Test
    public void run3() {
        List<String> list1 = Arrays.asList("Blake", "Alex", "7");
        List<String> list2 = Arrays.asList("Blake", "Alex", "3");
        List<String> list3 = Arrays.asList("Alex", "Blake", "4");
        List<String> list4 = Arrays.asList("Blake", "Alex", "1");
        List<String> list5 = Arrays.asList("Alex", "Blake", "7");

        List<List<String>> debts = Arrays.asList(list1, list2, list3, list4, list5);
        List<String> result = smallestNegativeBalance(debts);
        System.out.println("Result: " + result);
        List<String> expected = Arrays.asList("Nobody has a negative balance");
        assertEquals(expected, result);
    }

    @Test
    public void run4() {
        List<String> list1 = Arrays.asList("Casey", "Alex", "7");
        List<String> list2 = Arrays.asList("Casey", "Alex", "3");
        List<String> list3 = Arrays.asList("Alex", "Casey", "4");
        List<String> list4 = Arrays.asList("Casey", "Alex", "1");
        List<String> list5 = Arrays.asList("Alex", "Casey", "7");
        List<String> list6 = Arrays.asList("Alex", "Blake", "5");
        List<String> list7 = Arrays.asList("Casey", "Blake", "5");

        // alex -14, blake 7, casey 7
        List<List<String>> debts = Arrays.asList(list1, list2, list3, list4, list5, list6,list7);
        List<String> result = smallestNegativeBalance(debts);
        System.out.println("Result: " + result);
        List<String> expected = Arrays.asList("Alex", "Casey");
        assertEquals(expected, result);
    }

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        Map<String, BigInteger> records = new HashMap<>();
        for (List<String> loan : debts) {
            String borrower = loan.get(0);
            String amount = loan.get(2);
            summingDebt(records, borrower, new BigInteger(amount).negate(), new BigInteger(amount).negate());
            String lender = loan.get(1);
            summingDebt(records, lender, new BigInteger(amount), new BigInteger(amount));
        }
        Map<String, BigInteger> sortedDebts = sortByValueDesc(records);
        List<String> result = new LinkedList<>();
        BigInteger smallest = sortedDebts.entrySet().iterator().next().getValue();
        System.out.println("record: " + records);
        if (smallest.compareTo(BigInteger.ZERO) >= 0) {
            return Arrays.asList("Nobody has a negative balance");
        }
        sortedDebts.entrySet().stream()
                .filter(it -> it.getValue().equals(smallest))
                .forEach(it -> result.add(it.getKey()));
            return result;
    }

    private static void summingDebt(Map<String, BigInteger> records, String borrower, BigInteger amount, BigInteger amount1) {
        if (records.get(borrower) == null) {
            records.put(borrower, amount);
        } else {
            BigInteger debt = records.get(borrower);
            records.put(borrower, debt.add(amount1));
        }
    }

    private static LinkedHashMap<String, BigInteger> sortByValueDesc(Map<String, BigInteger> hm)
    {
        List<Map.Entry<String, BigInteger> > list =
                new LinkedList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());
        LinkedHashMap<String, BigInteger> temp = new LinkedHashMap<>();
        for (Map.Entry<String, BigInteger> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
