package demo.OITM.sixth;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class LychrelSearch {

    @Test
    public void testLychrel() {

        var limit = 10000;

        for (int i = 0; i < limit; i++) {
            if (!isPalindrom(new BigInteger(String.valueOf(i)))) {
                System.out.println(i + " is a Lynchrel");
            }
        }
    }

    private boolean isPalindrom(BigInteger number) {
        var i = 0;
        var isPalindrom = false;
        while (i < 50 && !isPalindrom) {
            BigInteger temp = number.add(reverseString(number));
            if (temp.equals(reverseString(temp))) {
                isPalindrom = true;
            }
            number = temp;
            i++;
        }
        return isPalindrom;
    }

    private BigInteger reverseString(BigInteger number) {
        var text = number.toString();
        StringBuilder input1 = new StringBuilder();
        input1.append(text);
        input1.reverse();
        return new BigInteger(input1.toString());
    }
}