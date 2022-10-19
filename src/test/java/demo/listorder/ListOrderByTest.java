package demo.listorder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOrderByTest {

    @Test
    public void testOrderBy() {
        Kerdes kerdes1 = new Kerdes(1, "first");
        Kerdes kerdes2 = new Kerdes(2, "seconf");
        Kerdes kerdes3 = new Kerdes(3, "seconf");
        Kerdes kerdes4 = new Kerdes(4, "seconf");

        List<Kerdes> lista = new ArrayList<>();

        lista.add(kerdes4);
        lista.add(kerdes1);
        
        lista.add(kerdes3);
        lista.add(kerdes1);
        lista.add(kerdes2);
        lista.add(kerdes1);
        lista.add(kerdes4);
        lista.add(kerdes2);
        lista.add(kerdes3);

//        only for java 1.8

        lista.sort(Comparator.comparing(Kerdes::getId).reversed());


        Collections.sort(lista, new Comparator<Kerdes>() {
            @Override
            public int compare(Kerdes o1, Kerdes o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        Collections.reverse(lista);
        lista.forEach(list -> System.out.println("List is:" + list.getId()));
    }

    @Test
    public void carrigeBack() {
        String str = "Begins";
        str =  str + "\n";
        str =  str + "end";
        System.out.println("str: " + str);

        System.out.println("--------------------------");

        String str2 = "Begins";
        str2 =  str2 + "\r";
        str2 =  str2 + "end";
        System.out.println("str: " + str2);

        System.out.println("--------------------------");

        String str3 = "Begins";
        str3 =  str3 + "\r\n";
        str3 =  str3 + "end";
        System.out.println("str: " + str3);
    }
}
