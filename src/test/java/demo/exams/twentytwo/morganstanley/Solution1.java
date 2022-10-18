package demo.exams.twentytwo.morganstanley;

import org.junit.Assert;
import org.junit.Test;

public class Solution1 {

    @Test
    public void run() {
        String text = "statistics";
        int result = getUniqueCharacter(text);
        System.out.println("Result: " + result);
        Assert.assertEquals(3, result);
    }

    @Test
    public void run2() {
        String text = "hackthegame";
        int result = getUniqueCharacter(text);
        System.out.println("Result: " + result);
        Assert.assertEquals(3, result);
    }

    @Test
    public void run3() {
        String text = "falafal";
        int result = getUniqueCharacter(text);
        System.out.println("Result: " + result);
        Assert.assertEquals(-1, result);
    }

    public static int getUniqueCharacter(String s) {
        String remainingTest = "";
        String[] splitText = s.split("");
        StringBuilder alreadyChecked = new StringBuilder();
        for (int i = 0; i < splitText.length; i++) {
            remainingTest = s.substring(i + 1);
            if (!alreadyChecked.toString().contains(splitText[i]) && !remainingTest.contains(splitText[i])) {
                return i + 1;
            } else {
                alreadyChecked.append(splitText[i]);
            }
        }
        return -1;
    }
}
