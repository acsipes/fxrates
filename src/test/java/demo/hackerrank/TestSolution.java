package demo.hackerrank;

import org.junit.Test;

public class TestSolution {

    int[] keyboards = {3, 1};
    int[] drives = {5, 2, 8};
    int b = 10;
    
    @Test
    public void getMoneySpent() {
        
        int max = 0;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int examinedPrices = keyboards[i] + drives[j];
                if (examinedPrices > max && examinedPrices <= b) {
                    max = examinedPrices;                    
                }
            }
        }
        System.out.println(max == 0 ? -1: max);
        int speed = 16;
        double speedD = speed;
        double meterPerSec = speedD*5/18;
        int tillInt = 300;
        double until = tillInt;
        double till = until/ meterPerSec;
        double lampStatus = till / 10;
        double nextLamp = till % 10;
        System.out.println(till);
    }
}
