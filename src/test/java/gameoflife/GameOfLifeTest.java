package gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    private static final int EXPECTED_NULL_CELL_AMOUNT = 0;
    private GameOfLife underTest = new GameOfLife();
    
    @Test
    public void testLivingCellsNumberWithoutCell() {
        
        long result= underTest.getLivingCellsNumber();

        assertEquals(EXPECTED_NULL_CELL_AMOUNT,result);
    }

    @Test
    public void testHasCalculateMethod() {

        underTest.calculateNextState();

        assertEquals(EXPECTED_NULL_CELL_AMOUNT, underTest.getLivingCellsNumber());
    }
    
    @Test
    public void testGetCellsNumberAfterOneCell() {
        
        underTest.add(new Cell(1,2));

        underTest.calculateNextState();

        assertEquals(EXPECTED_NULL_CELL_AMOUNT, underTest.getLivingCellsNumber());
    }    

    @Test
    public void testGetCellsNumberWithOneLivingCell() {
        
        underTest.add(new Cell(1,2));

        assertEquals(1, underTest.getLivingCellsNumber());
    }
    
    @Test
    public void testGetCellsNumberWithThreeLivingCell() {
        
        underTest.add(new Cell(1,2));
        underTest.add(new Cell(1,1));
        underTest.add(new Cell(1,0));

        underTest.calculateNextState();

        assertEquals(1, underTest.getLivingCellsNumber());
    }   
    
}

