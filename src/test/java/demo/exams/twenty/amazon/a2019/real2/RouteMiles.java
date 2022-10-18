package demo.exams.twenty.amazon.a2019.real2;

import java.util.LinkedList;
import java.util.List;

/*
    Amazon ID test 23280666762291
 */
public class RouteMiles 
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        List<List<Integer>> result = new LinkedList<>();

        int maxSumMiles = 0;

        for (int i = 0; i < forwardRouteList.size(); i++) {
            for (int j = 0; j < returnRouteList.size(); j++) {
                int sumMiles = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
                if (sumMiles <= maxTravelDist) {
                    if (sumMiles > maxSumMiles) {
                        maxSumMiles = sumMiles;
                        result.clear();
                        collectIdPairs(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0), result);
                    } else if (sumMiles == maxSumMiles) collectIdPairs(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0), result);
                }
            }
        }

        return result;

    }

    private void collectIdPairs(Integer forwardId, Integer ReturnId, List<List<Integer>> idList) {
        List<Integer> idPairs = new LinkedList<>();
        idPairs.add(forwardId);
        idPairs.add(ReturnId);
        idList.add(idPairs);
    }
}