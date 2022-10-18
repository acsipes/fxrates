package demo.exams.twenty.amazon.a2019.real1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
    Amazon ID test 23280666762291
 */

public class RealOne {

    int minimumTime(int numOfSubFiles, List<Integer> files)
    {
        files.sort(Comparator.comparingInt(Integer::intValue));
        
        List<Integer> tempList = new LinkedList<>();
        
        tempList.add(files.get(0));
        tempList.add(files.get(1));
        tempList.add(getLastTwoelementsSum(tempList));
        
        for (int i = 2; i < files.size() - 1; i++) {
            tempList.add(files.get(i));
            tempList.add(getLastTwoelementsSum(tempList));
            
        }
        tempList.add(files.get(files.size()-1));
        
        return tempList.stream().mapToInt(Integer::intValue).sum();
    }

    private Integer getLastTwoelementsSum(List<Integer> files) {
        int a = files.get(files.size()-2);
        int b = files.get(files.size()-1);
        return a + b;
    }

    int minimumTime2(int numOfSubFiles, List<Integer> files)
    {
        int totalSum = 0;
        int tempSum = 0;

        files.sort(Comparator.comparingInt(Integer::intValue));
        
                
        tempSum = totalSum = files.get(0) + files.get(1);
        totalSum = totalSum + tempSum;
        for (int i = 2; i  < files.size() - 1; i++) {

            tempSum = tempSum + files.get(i);
            totalSum = totalSum + tempSum + files.get(i);            
        }       
        totalSum = totalSum + files.get(files.size() - 1);
        
        return totalSum;
    }

    // METHOD SIGNATURE ENDS
}
