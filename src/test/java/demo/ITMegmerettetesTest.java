package demo;

import org.junit.Assert;
import org.junit.Test;

public class ITMegmerettetesTest {
    
    @Test
    public void firstTest() {

        long first = 1L;
        long second = 2L - 1L;
        Assert.assertEquals(first, second);
    }
    
    
}
