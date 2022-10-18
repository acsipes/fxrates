package demo.exams.twenty.amazon.a2019.real2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteMilesTest {
    
    @Test
    public void testCase1() {
        RouteMiles underTest = new RouteMiles();
        int memory = 20;

        List<List<Integer>> result = new LinkedList<>();

        List<List<Integer>> expected = new LinkedList<>();
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(3);
        List<Integer> b = new LinkedList<>();
        b.add(3);
        b.add(2);
        
        expected.add(a);
        expected.add(b);

        List<Integer> tempFore1 = new LinkedList<>();
        List<Integer> tempFore2 = new LinkedList<>();
        List<Integer> tempFore3 = new LinkedList<>();

        List<Integer> tempBack1 = new LinkedList<>();
        List<Integer> tempBack2 = new LinkedList<>();
        List<Integer> tempBack3 = new LinkedList<>();

        List<List<Integer>> foreground = new LinkedList<>();
        tempFore1.add(1);
        tempFore1.add(8);
        foreground.add(tempFore1);

        tempFore2.add(2);
        tempFore2.add(15);
        foreground.add(tempFore2);

        tempFore3.add(3);
        tempFore3.add(9);
        foreground.add(tempFore3);

        List<List<Integer>> background = new LinkedList<>();
        tempBack1.add(1);
        tempBack1.add(8);
        background.add(tempBack1);

        tempBack2.add(2);
        tempBack2.add(11);
        background.add(tempBack2);

        tempBack3.add(3);
        tempBack3.add(12);
        background.add(tempBack3);

        List<List<Integer>> actual = underTest.optimalUtilization(memory, foreground, background);

        assertEquals(actual.size(), expected.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).get(0), actual.get(i).get(0));
            assertEquals(expected.get(i).get(1), actual.get(i).get(1));
        }
    }
}
