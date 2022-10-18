package gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    private List<Cell> livingCells = new ArrayList<>();

    public long getLivingCellsNumber() {
        return livingCells.size();
    }
    
    public void calculateNextState() {
        if (getLivingCellsNumber() < 3)
            livingCells.clear();
        else {
            livingCells.clear();
            livingCells.add(new Cell(0, 0));
        }
    }

    public void add(Cell cell) {
        livingCells.add(cell);        
    }
}
