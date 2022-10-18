package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ITMegmerettetesTest {
    
    @Test
    public void firstTest() {

        long first = 1L;
        long second = 2L - 1L;
        assertEquals(first, second);
    }
    
    
}
