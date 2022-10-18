package demo.exams.twenty.emarsys.a2018;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmarsysTest2018 {

    @Test
    public void exampleTest() {
        String text = "u =>, v => w, w => z,x => u, y => v, z =>";
//        String text = "1 =>, 3 => 2, 2 => ,4 => 3, 5 => 4, 7 =>5,6=>5";
        String trimmedText = text.replaceAll("\\s+", "");
        System.out.println("trimm: " + trimmedText);

        String[] textCommaSplit = trimmedText.split(",");
        List<String> finalList = new LinkedList<>();
        List<String> noDependencyDestin = new LinkedList<>();
        List<String> dependenciedDestin = new LinkedList<>();
        for (String str : textCommaSplit) {
            if (str.length() == 3) {
                System.out.println("good param: " + str);
                finalList.add(str.replace("=>", ""));
                noDependencyDestin.add(str.replace("=>", ""));

            } else if (str.length() == 4) {
                System.out.println("good param: " + str);
                dependenciedDestin.add(str.replace("=>", ""));
            } else {
                throw new IllegalArgumentException("bad param: " + str);
            }
        }

        Map<String, String> textMap = new HashMap<>();
        for (String destin : dependenciedDestin) {
            textMap.put(destin.split("")[0], destin.split("")[1]);
        }

        Set<String> keyList = textMap.keySet();
        finalList.addAll(keyList);

        for (String elem : keyList) {
            for (Map.Entry<String, String> entry : textMap.entrySet()) {
                String entryValue = entry.getValue();
                if (elem.equals(entryValue) && finalList.indexOf(entryValue) > finalList.indexOf(entry.getKey())) {
                    finalList.remove(elem);
                    finalList.add(finalList.indexOf(entry.getKey()), entryValue);
                }
            }
        }

        for (String elem : finalList) {
            System.out.println("final ored destin: " + elem);
        }
    }
}
