package demo.exams.twentytwo.blackrock;

import org.junit.jupiter.api.Test;

/**
 * first character is a digit that repsresents the numbor of uppercase symbols in the correct passwrod
 * next  3 char are last 3 chars in password reverse order
 * last char reps the sum of all digit in the password
 */
public class Solution2 {

    String getCorrectPassword(String[] passwords, String checkString){

        var result = "";
        for (String pw : passwords) {
                var upperCaseSum = 0;
                var upperCaseReq = Character.getNumericValue(checkString.charAt(0));
                for (char letter : pw.toCharArray()) {
                    if (Character.isUpperCase(letter)) {
                        upperCaseSum += 1;
                    }
                }
                if (upperCaseSum == upperCaseReq) {
                    var lastThree = pw.substring(pw.length() - 3);
                    var reversedLastThree = new StringBuilder(lastThree).reverse().toString();
                    var lastThreeReq = checkString.substring(1, 4);
                    if (lastThreeReq.equals(reversedLastThree)) {
                        int numbersSumReq = Character.getNumericValue(checkString.charAt(checkString.length() - 1));
                        var onlyDigits = pw.replaceAll("\\D", "");
                        if (onlyDigits.length() <= 0 ) {
                            if (numbersSumReq == 0) {
                                return pw;
                            } else {
                                return "";
                            }
                        } else {
                            var sumOfDigits = 0;
                            for (String digit : onlyDigits.split("")) {
                                sumOfDigits += Integer.parseInt(digit);
                            }
                            if (sumOfDigits == numbersSumReq) {
                                result = pw;
                            }
                        }

                    }
                }
        }
        return result;
    }

    @Test
    public void quessPassword() {
        String[] passwords = {
                "P@sswORD1",
                "20passWORD20",
                "PASS6word",
                "crazyPassword1#$%",
                "theBestpassword"};
        var checkString1 = "41DR1";
        var checkString2 = "402D4";
        var checkString3 = "4dro6";
        var checkString4 = "1%$#1";
        var checkString5 = "1dro0";
        System.out.println("rsult = " + getCorrectPassword(passwords, checkString4));

    }
}
