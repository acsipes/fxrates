package demo.exams.twenty.amazon.a2018.cluster;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClusterTest {

    @Test
    public void firstTest() {
        Cluster underTest = new Cluster();
        int memory = 20;
        List<Integer[]> expected = new LinkedList<>();
        expected.add(new Integer[]{3, 1});

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
        tempFore2.add(7);
        foreground.add(tempFore2);

        tempFore3.add(3);
        tempFore3.add(14);
        foreground.add(tempFore3);

        List<List<Integer>> background = new LinkedList<>();
        tempBack1.add(1);
        tempBack1.add(5);
        background.add(tempBack1);

        tempBack2.add(2);
        tempBack2.add(10);
        background.add(tempBack2);

        tempBack3.add(3);
        tempBack3.add(14);
        background.add(tempBack3);

        List<Integer[]> actual = underTest.computingDevices(memory, foreground, background);

        assertEquals(actual.size(), expected.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i)[0], actual.get(i)[0]);
            assertEquals(expected.get(i)[1], actual.get(i)[1]);
        }
    }

    @Test
    public void secondTest() {
        Cluster underTest = new Cluster();
        int memory = 20;
        List<Integer[]> expected = new LinkedList<>();
        expected.add(new Integer[]{1, 3});
        expected.add(new Integer[]{3, 2});

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

        List<Integer[]> actual = underTest.computingDevices(memory, foreground, background);

        assertEquals(actual.size(), expected.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i)[0], actual.get(i)[0]);
            assertEquals(expected.get(i)[1], actual.get(i)[1]);
        }
    }

    @Test
    public void thirdTest() {
        Cluster underTest = new Cluster();
        int memory = 25;
        List<Integer[]> expected = new LinkedList<>();
        expected.add(new Integer[]{1, 2});
        expected.add(new Integer[]{4, 1});
        expected.add(new Integer[]{5, 3});

        List<Integer> tempFore1 = new LinkedList<>();
        List<Integer> tempFore2 = new LinkedList<>();
        List<Integer> tempFore3 = new LinkedList<>();
        List<Integer> tempFore4 = new LinkedList<>();
        List<Integer> tempFore5 = new LinkedList<>();

        List<Integer> tempBack1 = new LinkedList<>();
        List<Integer> tempBack2 = new LinkedList<>();
        List<Integer> tempBack3 = new LinkedList<>();
        List<Integer> tempBack4 = new LinkedList<>();
        List<Integer> tempBack5 = new LinkedList<>();

        List<List<Integer>> foreground = new LinkedList<>();
        tempFore1.add(1);
        tempFore1.add(10);
        foreground.add(tempFore1);

        tempFore2.add(2);
        tempFore2.add(1);
        foreground.add(tempFore2);

        tempFore3.add(3);
        tempFore3.add(6);
        foreground.add(tempFore3);

        tempFore4.add(4);
        tempFore4.add(12);
        foreground.add(tempFore4);

        tempFore5.add(5);
        tempFore5.add(7);
        foreground.add(tempFore5);

        List<List<Integer>> background = new LinkedList<>();
        tempBack1.add(1);
        tempBack1.add(13);
        background.add(tempBack1);

        tempBack2.add(2);
        tempBack2.add(15);
        background.add(tempBack2);

        tempBack3.add(3);
        tempBack3.add(18);
        background.add(tempBack3);

        tempBack4.add(4);
        tempBack4.add(17);
        background.add(tempBack4);

        tempBack5.add(5);
        tempBack5.add(20);
        background.add(tempBack5);

        List<Integer[]> actual = underTest.computingDevices(memory, foreground, background);

        assertEquals(actual.size(), expected.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i)[0], actual.get(i)[0]);
            assertEquals(expected.get(i)[1], actual.get(i)[1]);
        }
    }

    @Test
    public void fourthTest() {
        Cluster underTest = new Cluster();
        int memory = 20;
        List<Integer[]> expected = new LinkedList<>();
        expected.add(new Integer[]{2, 3});
        expected.add(new Integer[]{5, 1});

        List<Integer> tempFore1 = new LinkedList<>();
        List<Integer> tempFore2 = new LinkedList<>();
        List<Integer> tempFore3 = new LinkedList<>();
        List<Integer> tempFore4 = new LinkedList<>();
        List<Integer> tempFore5 = new LinkedList<>();

        List<Integer> tempBack1 = new LinkedList<>();
        List<Integer> tempBack2 = new LinkedList<>();
        List<Integer> tempBack3 = new LinkedList<>();
        List<Integer> tempBack4 = new LinkedList<>();
        List<Integer> tempBack5 = new LinkedList<>();

        List<List<Integer>> foreground = new LinkedList<>();
        tempFore1.add(1);
        tempFore1.add(10);
        foreground.add(tempFore1);

        tempFore2.add(2);
        tempFore2.add(1);
        foreground.add(tempFore2);

        tempFore3.add(3);
        tempFore3.add(6);
        foreground.add(tempFore3);

        tempFore4.add(4);
        tempFore4.add(12);
        foreground.add(tempFore4);

        tempFore5.add(5);
        tempFore5.add(7);
        foreground.add(tempFore5);

        List<List<Integer>> background = new LinkedList<>();
        tempBack1.add(1);
        tempBack1.add(12);
        background.add(tempBack1);

        tempBack2.add(2);
        tempBack2.add(15);
        background.add(tempBack2);

        tempBack3.add(3);
        tempBack3.add(18);
        background.add(tempBack3);

        tempBack4.add(4);
        tempBack4.add(17);
        background.add(tempBack4);

        tempBack5.add(5);
        tempBack5.add(20);
        background.add(tempBack5);

        //WHEN
        List<Integer[]> actual = underTest.computingDevices(memory, foreground, background);

        //THEN
        assertEquals(actual.size(), expected.size());

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i)[0], actual.get(i)[0]);
            assertEquals(expected.get(i)[1], actual.get(i)[1]);
        }
    }
}
