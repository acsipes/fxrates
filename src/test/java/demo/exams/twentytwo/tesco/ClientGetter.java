package demo.exams.twentytwo.tesco;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                .map(it -> it.getKey().toString())
                .collect(Collectors.toList());
    }

    public HashMap<Long, Long> sortByValueDesc(Map<Long, Long> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Long, Long> > list =
                new LinkedList<>(hm.entrySet());

        // Sort the list by value desc
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // put data from sorted list to hashmap
        HashMap<Long, Long> temp = new LinkedHashMap<Long, Long>();
        for (Map.Entry<Long, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
