//package demo.exams.twentytwo.worldquant;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class Result1 {
//
//    @Test
//    public void run() {
//        List<Long> boxes = Arrays.asList(1L, 2L, 3L);
//        List<Long> unitsPerBox = Arrays.asList(3L, 2L, 1L);
//        long truckSize = 3L;
//
//        long result = getMaxUnits(boxes, unitsPerBox, truckSize);
//
//        System.out.println("Result: " + result);
//        assertEquals(7, result);
//    }
//
//    @Test
//    public void run2() {
//        List<Long> boxes = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
//        List<Long> unitsPerBox = Arrays.asList(2L, 1L, 1L, 2L, 9L, 6L);
//        long truckSize = 1L;
//
//
//        long result = getMaxUnits(boxes, unitsPerBox, truckSize);
//
//        System.out.println("Result: " + result);
//        assertEquals(9, result);
//    }
//
//    @Test
//    public void run3() {
//        List<Long> boxes = Arrays.asList(3L, 1L, 6L);
//        List<Long> unitsPerBox = Arrays.asList(2L, 7L, 4L);
//        long truckSize = 6L;
//
//        long result = getMaxUnits(boxes, unitsPerBox, truckSize);
//
//        System.out.println("Result: " + result);
//        assertEquals(27, result);
//    }
//
//    @Test
//    public void run4() {
//        List<Long> boxes = Arrays.asList(1L, 1L);
//        List<Long> unitsPerBox = Arrays.asList(9L, 6L);
//        long truckSize = 1L;
//
//        long result = getMaxUnits(boxes, unitsPerBox, truckSize);
//
//        System.out.println("Result: " + result);
//        assertEquals(9, result);
//    }
//
//    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
//        // TODO not working
//        List<Long[]> shipment = new ArrayList<>();
//
//        for (int i = 0; i < boxes.size(); i++) {
//            Long[] pairs = {boxes.get(i), unitsPerBox.get(i)};
//            shipment.add(pairs);
//        }
//        Long[] temp = new Long[shipment.size()];
////        shipment.toArray(temp);
//
////        Arrays.sort(shipment, (a, b) -> b - a[1]);
////        int result = 0;
////        for (Long[] b : shipment) {
////            long count = Math.min(b[0], truckSize);
////            result += count * b[1];
////            truckSize -= count;
////            if (truckSize == 0) return result;
////        }
////        return result;
//        return 1;
//    }
//
//    private static HashMap<Long, Long> sortByValueDesc(Map<Long, Long> hm) {
//        List<Map.Entry<Long, Long>> list =
//                new LinkedList<>(hm.entrySet());
//        list.sort(new Comparator<Map.Entry<Long, Long>>() {
//            public int compare(Map.Entry<Long, Long> o1,
//                               Map.Entry<Long, Long> o2) {
//                return (o2.getValue()).compareTo(o1.getValue());
//            }
//        });
//        HashMap<Long, Long> temp = new LinkedHashMap<>();
//        for (Map.Entry<Long, Long> aa : list) {
//            temp.put(aa.getKey(), aa.getValue());
//        }
//        return temp;
//    }
//}
