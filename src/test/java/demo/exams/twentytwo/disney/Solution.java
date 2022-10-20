package demo.exams.twentytwo.disney;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    @Test
    public void testAnagrams() {
        var text = "abcd";
        var anotherText = "cdab";

        var firstMap = groupInMap(text);
        var secondMap = groupInMap(anotherText);

        Assertions.assertEquals(firstMap, secondMap);

    }

    @Test
    public void testAnagramsWithStream() {
        var text = "abcdea";
        var anotherText = "cadabe";

        var firstMap = Arrays.stream(text.split(""))
                .collect(Collectors.groupingBy(it -> it));
        var secondMap = Arrays.stream(anotherText.split(""))
                .collect(Collectors.groupingBy(it -> it));
        Assertions.assertEquals(firstMap, secondMap);
    }

    private Map<String, Integer> groupInMap(String text) {
        var result = new HashMap<String, Integer>();
        var splitText = text.split("");
        for (String letter : splitText) {
            if (result.get(letter) == null) {
                result.put(letter, 1);
            } else {
                var counter = result.get(letter);
                counter += 1;
                result.put(letter, counter);
            }
        }
        return result;
    }

}
