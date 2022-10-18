package demo.exams.twenty.amazon.a2019.real1;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RealOneTest {
    
    @Test
    public void testCase1() {
        int sum = 4;
        List<Integer> files = new LinkedList<>();
        files.add(20);
        files.add(4);
        files.add(8);
        files.add(2);
        int expected = 54;

        RealOne undertest = new RealOne();

        int actual = undertest.minimumTime(sum, files);

        Assert.assertEquals(expected, actual);

        int actual2 = undertest.minimumTime2(sum, files);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void testCase2() {
        int sum = 6;
        List<Integer> files = new LinkedList<>();
        files.add(1);
        files.add(2);
        files.add(5);
        files.add(10);
        files.add(35);
        files.add(89);
        
        int expected = 224;

        RealOne undertest = new RealOne();

        int actual = undertest.minimumTime(sum, files);

        Assert.assertEquals(expected, actual);
        
        int actual2 = undertest.minimumTime2(sum, files);
        Assert.assertEquals(expected, actual2);
    }

}