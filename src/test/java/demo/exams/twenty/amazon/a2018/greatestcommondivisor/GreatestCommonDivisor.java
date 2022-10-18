package demo.exams.twenty.amazon.a2018.greatestcommondivisor;

import java.util.Arrays;

class GreatestCommonDivisor {

    private int gCD = 1;

    int calcGCD(int elemNumbers, int[] elements) {
        Arrays.sort(elements);
        
        int result = 1;

            boolean allElemetDividor = false;
            while (gCD <= elements[0]) {
                gCD++;
                boolean stillDivisor = true;
                int index = 0;
                while(stillDivisor && index < elemNumbers) {
                        if (elements[index] % gCD != 0) {
                            allElemetDividor = false;
                            stillDivisor = false;
                        } else allElemetDividor = true;
                        index++;
                }
                    if (allElemetDividor) result = gCD;
            }
            return result;
    }
}
