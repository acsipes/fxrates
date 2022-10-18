package demo.exams.twenty.amazon.a2018.steakhouses;

import static java.lang.Double.compare;
import static java.lang.Math.sqrt;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class SteakHouse {

    private List<List<Integer>> nearbyLocations = new LinkedList<>();
    private List<List<Integer>> tempNearbyLocations = new LinkedList<>();

    List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
                                            List<List<Integer>> allLocations,
                                            int numSteakhouses) {
        if (numSteakhouses > totalSteakhouses) {

            // should be slf4j log here, but couldn't import it
            System.out.println(
                    "The number of required nearby Steak Houses is bigger than the total steak house's number");
        } else {

            nearbyLocations = allLocations
                    .stream()
                    .sorted((listFist, listSecond) -> compare(calculateHypotenuse(listFist), calculateHypotenuse(listSecond)))
                    .limit(numSteakhouses)
                    .collect(Collectors.toList());
        }
        return nearbyLocations;
    }

    private Double calculateHypotenuse(List<Integer> list) {
        double a = list.get(0);
        double b = list.get(1);
        return sqrt(a * a + b * b);
    }

}
