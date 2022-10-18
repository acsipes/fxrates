package demo.exams.twenty.cloudera.a2020.devicenamesystem;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DevciceNameSystemTest {
    
    @Test
    public void testMethod() {
        List<String> lists = new ArrayList<>();
        lists.add("switch");
        lists.add("tv");
        lists.add("switch");
        lists.add("tv");
        lists.add("switch");
        lists.add("tv");

        List<String> result = DevciceNameSystem.deviceNamesSystem(lists);

        System.out.println(result);
    }
}
