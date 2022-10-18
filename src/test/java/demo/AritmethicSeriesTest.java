package demo;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class AritmethicSeriesTest {

    @Test
    public void singleSeries() {

        int elementNumber = 20;

        List<Integer> elements = new LinkedList<>();

        for(int i = 0; i < elementNumber;) {
            System.out.println("series elem = " + ++i);
            elements.add(i);
        }
        int result = 0;

        for(int elem: elements) {
            result += elem;
        }

        System.out.println("Sum = "+ result);
    }
}
