package demo.exams.twentytwo.tesco;

import java.util.*;
import java.util.stream.Collectors;

public class ClientGetter {

    public List<String> getTopKClients(List<ClientTransaction> clientTrans, int k) {
        Map<Long, Long> groups = new HashMap<>();

        clientTrans.forEach(it -> grouping(it, groups));

        return getFirstKClients(sortByValueDesc(groups), k);

    }

    private void grouping(ClientTransaction clientTx, Map<Long, Long> groups) {
        Long clientId = clientTx.getClientId();
        if (groups.get(clientId) != null) {
            long tempAmount = groups.get(clientTx.getClientId()) + clientTx.getAmount();
            groups.put(clientId, tempAmount);
        } else {
            groups.put(clientId, clientTx.getAmount());
        }
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
