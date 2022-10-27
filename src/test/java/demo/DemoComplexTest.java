package demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class DemoComplexTest {

    @Test

    public void testStringContains() {

        var text = "aaaaabbbcdefggggghijjklllll";
        var message = "wxedfghizuapl";

        var groupedText = Arrays.stream(text.split("")).collect(Collectors.groupingBy(it -> it));
        var max = 0;
        var result = new LinkedList<>();
        for (String letter : message.split("")) {
            var value = groupedText.get(letter);
            if (value != null) {
                if (value.size() == max) {
                    result.add(letter);
                } else if (value.size() > max) {
                    max = value.size();
                    result = new LinkedList<>();
                    result.add(letter);
                }
            }
        }

        System.out.println("result = " + result);
    }
}
