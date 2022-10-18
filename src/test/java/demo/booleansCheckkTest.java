package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class booleansCheckkTest {
    
    private boolean isKmr;
    
    private boolean isAndroid;
    
    private boolean isWeb;
    
    private boolean isCreateSurvey = true;
    
    @Test
    public void noneOfthis() {
        isCreateSurvey = false;
        
        boolean actaul = (!isKmr && !isAndroid && !isWeb || isCreateSurvey);
        
        assertTrue(actaul);
    }

    @Test
    public void kmrTrue() {
        isKmr = true;
        
        boolean actaul = (!isKmr && !isAndroid && !isWeb || isCreateSurvey);
        
        assertTrue(actaul);
    }

    @Test
    public void androidTrue() {
        isAndroid = true;
        
        boolean actaul = (!isKmr && !isAndroid && !isWeb || isCreateSurvey);
        
        assertTrue(actaul);
    }

    @Test
    public void webTrue() {
        isWeb = true;
        
        boolean actaul = (!isKmr && !isAndroid && !isWeb || isCreateSurvey);
        
        assertTrue(actaul);
    }

    @Test
    public void oneOfThisAndIsCreateFalse() {
        isKmr = true;
        isCreateSurvey = false;
        
        boolean actaul = (!isKmr && !isAndroid && !isWeb || isCreateSurvey);
        
        assertFalse(actaul);
    }
}
