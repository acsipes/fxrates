package demo.exams.twenty.amazon.a2018.cellhouse;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class CellHouseTest {

    @Test
    public void firstTest() {
        CellHouse underTest = new CellHouse();
        List<Integer> statesList = new LinkedList<>();
        statesList.add(1);
        statesList.add(0);
        statesList.add(0);
        statesList.add(0);
        statesList.add(0);
        statesList.add(1);
        statesList.add(0);
        statesList.add(0);
        int days = 1;
        
        List<Integer> expectedList = new LinkedList<>();
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(0);
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(0);

        List<Integer> actualList = underTest.cellsStates(statesList, days);

        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void secondTest() {

        CellHouse underTest = new CellHouse();
        List<Integer> statesList = new LinkedList<>();
        statesList.add(1);
        statesList.add(1);
        statesList.add(1);
        statesList.add(0);
        statesList.add(1);
        statesList.add(1);
        statesList.add(1);
        statesList.add(1);
        int days = 2;

        List<Integer> expectedList = new LinkedList<>();
        expectedList.add(0);
        expectedList.add(0);
        expectedList.add(0);
        expectedList.add(0);
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(0);

        List<Integer> actualList = underTest.cellsStates(statesList, days);

        Assert.assertEquals(expectedList, actualList);

    }

}
