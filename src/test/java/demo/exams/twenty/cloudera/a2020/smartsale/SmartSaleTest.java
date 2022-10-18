package demo.exams.twenty.cloudera.a2020.smartsale;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartSaleTest {

    @Test
    public void testMethod() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(1);
        ids.add(1);
        ids.add(1);
        ids.add(1);
        ids.add(1);
        ids.add(2);
        ids.add(2);
        ids.add(2);
        ids.add(4);
        ids.add(4);
        ids.add(4);
        ids.add(4);
        ids.add(3);
        ids.add(3);
        ids.add(3);
        ids.add(3);
        ids.add(3);

        int result = SmartSale.deleteProducts(ids, 11);
        System.out.println(result);
    }
}
