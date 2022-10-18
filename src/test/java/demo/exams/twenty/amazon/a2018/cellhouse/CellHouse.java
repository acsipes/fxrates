package demo.exams.twenty.amazon.a2018.cellhouse;

import java.util.LinkedList;
import java.util.List;

class CellHouse {

    private List<Integer> nextDayStates = new LinkedList<>();

    List<Integer> cellsStates(List<Integer> states, int days) {

        for(int i = 0; i < days; i++) {
            nextDayStates.add(calcFirstCell(states.get(1)));

            for(int n = 1; n < states.size()-1; n++){
                nextDayStates.add(calcMiddleCell(states.get(n-1), states.get(n+1)));
            }
            nextDayStates.add(calcLastCell(states.get(states.size()-2)));

            states.clear();
            states.addAll(nextDayStates);
            if (i < days - 1) nextDayStates.clear();
        }
        return nextDayStates;
    }

    private int calcFirstCell(int secondCell){
        return secondCell == 0 ? 0 : 1;
    }

    private int calcLastCell(int penultimateCell){
        return penultimateCell == 0 ? 0 : 1;
    }

    private int calcMiddleCell(int infrontCell, int nextCell) {
        return infrontCell == nextCell ? 0 : 1;
    }


}
