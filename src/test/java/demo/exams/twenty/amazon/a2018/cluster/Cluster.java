package demo.exams.twenty.amazon.a2018.cluster;

import java.util.LinkedList;
import java.util.List;

class Cluster {

    List<Integer[]> computingDevices(int memory, List<List<Integer>> foreground, List<List<Integer>> background) {

        List<Integer[]> result = new LinkedList<>();
        int maxSumMemory = 0;

        for (int i = 0; i < foreground.size(); i++) {
            for (int j = 0; j < foreground.size(); j++) {
                int sumMemories = foreground.get(i).get(1) + background.get(j).get(1);
                if (sumMemories <= memory) {
                    if (sumMemories > maxSumMemory) {
                        maxSumMemory = sumMemories;
                        result.clear();
                        result.add(new Integer[]{foreground.get(i).get(0), background.get(j).get(0)});
                    } else if (sumMemories == maxSumMemory) result.add(new Integer[]{foreground.get(i).get(0), background.get(j).get(0)});
                }
            }
        }
        return result;
    }
}
