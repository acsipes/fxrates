package demo.exams.twenty.cloudera.a2020.smartsale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmartSale {

    public static int deleteProducts(List<Integer> ids, int m) {

        Set<Integer> indiNumbers = new HashSet<>();

        indiNumbers.addAll(ids);
        int result = indiNumbers.size();

        List<Integer> frequencies = new ArrayList<>();

        for (Integer id : indiNumbers) {
            int frequency = Collections.frequency(ids, id);
            frequencies.add(frequency);
        }

        Collections.sort(frequencies);
        Collections.reverse(frequencies);
        
        // TODO
        
        int sum = 0;
        for (int i = 0; i < frequencies.size(); i++) {
            sum = sum + frequencies.get(i);
            if (sum > m) {
                break;
            }
            result -= i + 1;
        }
        
        // TODO
            
        return result;
    }
}
