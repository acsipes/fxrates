package demo.exams.twentytwo.tesco;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientGetter {

    public List<String> getTopKClients(List<ClientTransaction> clientTrans, int k) {
        var groupedClientTxs = clientTrans
                .stream()
                .collect(Collectors.groupingBy(ClientTransaction::getClientId));

        var result = new HashMap<Long, Long>();
        groupedClientTxs.values().stream()
                .map(this::sumClientTx)
                .collect(Collectors.toList())
                .forEach(result::putAll);
        HashMap<Long, Long> descGroups = sortByValueDesc(result);
        return getFirstKClients(descGroups, k);

    }

    private Map<Long, Long> sumClientTx(List<ClientTransaction> clientTrans) {
        var totalAmount = clientTrans.stream()
                .mapToLong(ClientTransaction::getAmount)
                .sum();
        var result = new HashMap<Long, Long>();
        result.put(clientTrans.get(0).getClientId(), totalAmount);
        return result;
    }

    private List<String> getFirstKClients(Map<Long, Long> descGroups, int k) {
        return descGroups.entrySet()
                .stream()
                .limit(k)
                .map(this::getClientId)
                .collect(Collectors.toList());
    }

    private String getClientId(Map.Entry<Long, Long> it) {

        return it.getKey().toString();
    }

    public HashMap<Long, Long> sortByValueDesc(Map<Long, Long> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Long, Long> > list =
                new LinkedList<Map.Entry<Long, Long> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Long, Long> >() {
            public int compare(Map.Entry<Long, Long> o1,
                               Map.Entry<Long, Long> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Long, Long> temp = new LinkedHashMap<Long, Long>();
        for (Map.Entry<Long, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
