package demo.exams.twenty.amazon.a2018.steakhouses;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SteakHouseTest {

    @Test
    public void amazonRealFirstUnitTest1() {

        SteakHouse undertest = new SteakHouse();
        List<List<Integer>> expected1 = new ArrayList<>();
        List<List<Integer>> actualOne = new ArrayList<>();

        List<List<Integer>> sampleList1 = new ArrayList<>();
        List<Integer> first1 = new ArrayList<>();
        List<Integer> first2 = new ArrayList<>();
        List<Integer> first3 = new ArrayList<>();
        List<Integer> first4 = new ArrayList<>();
        List<Integer> first5 = new ArrayList<>();

        first1.add(1);
        first1.add(-3);
        sampleList1.add(first1);

        first2.add(1);
        first2.add(2);
        sampleList1.add(first2);
        expected1.add(first2);

        first3.add(3);
        first3.add(4);
        sampleList1.add(first3);

        actualOne = undertest.nearestXsteakHouses(3, sampleList1, 1);

        Assert.assertEquals(expected1, actualOne);
    }
    @Test
    public void amazonRealFirstUnitTest2() {

        SteakHouse undertest = new SteakHouse();

        List<List<Integer>> expected2 = new ArrayList<>();
        List<List<Integer>> actual2 = null;


        List<List<Integer>> sampleList2 = new ArrayList<>();
        List<Integer> second1 = new ArrayList<>();
        List<Integer> second2= new ArrayList<>();
        List<Integer> second3 = new ArrayList<>();
        List<Integer> second4 = new ArrayList<>();
        List<Integer> second5 = new ArrayList<>();
        List<Integer> second6 = new ArrayList<>();

        second1.add(3);
        second1.add(6);
        sampleList2.add(second1);

        second6.add(7);
        second6.add(9);
        sampleList2.add(second6);

        second2.add(2);
        second2.add(4);
        sampleList2.add(second2);

        second3.add(5);
        second3.add(3);
        sampleList2.add(second3);

        expected2.add(second2);
        expected2.add(second3);
        expected2.add(second1);
        //  [[2, 4], [3, 6], [5, 3]]

        second4.add(2);
        second4.add(7);
        sampleList2.add(second4);

        second5.add(1);
        second5.add(8);
        sampleList2.add(second5);

        actual2 = undertest.nearestXsteakHouses(6, sampleList2, 3);

        Assert.assertEquals(expected2, actual2);

    }
    @Test
    public void amazonRealFirst() {
        SteakHouse solution = new SteakHouse();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first1 = new ArrayList<>();
        List<Integer> first2= new ArrayList<>();
        List<Integer> first3 = new ArrayList<>();
        List<Integer> first4 = new ArrayList<>();
        List<Integer> first5 = new ArrayList<>();

        first1.add(1);
        first1.add(2);
        list.add(first1);

        first2.add(0);
        first2.add(2);
        list.add(first2);

        first3.add(2);
        first3.add(2);
        list.add(first3);

        first4.add(3);
        first4.add(2);
        list.add(first4);

        first5.add(1);
        first5.add(0);
        list.add(first5);
        System.out.println(list);

        List<List<Integer>> result = solution.nearestXsteakHouses(5, list, 3);

        result.stream().forEach(houseList -> printResult(houseList));
    }

    private void printResult(List<Integer> houseCoordinates) {
        System.out.println("result is: " + houseCoordinates.get(0) + ", " + houseCoordinates.get(1));
    }
}
