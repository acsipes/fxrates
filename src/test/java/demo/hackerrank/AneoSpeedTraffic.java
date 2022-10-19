package demo.hackerrank;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AneoSpeedTraffic {

    int speed = 81;
    int lightCount = 3;
    int expected = 67;

    @Test
    public void aneoSpeedTraffic() {

        List<List<Integer>> originDatas = new ArrayList<>();
        List<Integer> originData = new ArrayList<>();

        originData.add(300);
        originData.add(30);
        originDatas.add(new ArrayList<>(originData));
        originData.clear();
        originData.add(1500);
        originData.add(20);
        originDatas.add(new ArrayList<>(originData));
        originData.clear();
        originData.add(3000);
        originData.add(10);
        originDatas.add(new ArrayList<>(originData));
        originData.clear();

        List<List<Integer>> datas = new ArrayList<>();

        for (int i = 0; i < lightCount; i++) {
            int distance = originDatas.get(i).get(0);
            int duration = originDatas.get(i).get(1);
            List<Integer> tempDatas = new ArrayList<>();
            tempDatas.add(distance);
            tempDatas.add(duration);
            datas.add(tempDatas);
        }

        int trafficLight = 0;
        boolean canMakeIt = true;
        boolean canPassAll = false;
        while (speed > 0 && !canPassAll) {
            trafficLight = 0;
            canMakeIt = true;
            double floatingSpeed = speed;
            double speedMeterPerSec = floatingSpeed * 5 / 18;

            while (trafficLight < lightCount && canMakeIt) {
                double toPoint = datas.get(trafficLight).get(0);
                double duration = datas.get(trafficLight).get(1);
                double traveledDistance = speedMeterPerSec * duration;
                if (trafficLight == 0) {
                    if (traveledDistance > toPoint) {

                    } else {
                        Double reachLamp = canMakeItUnderMultipleLightChange(toPoint, traveledDistance, speedMeterPerSec, true);
                        if (reachLamp != null) {
                        } else {
                            canMakeIt = false;
                        }
                    }
                } else {
                    double previousDistance = 0.0;
                    for (int i = trafficLight -1; i >= 0; i--) {
                        previousDistance += datas.get(i).get(0);                        
                    }
                    double timeInPrevLight = previousDistance / speedMeterPerSec;
                    int lampStatus = (int) timeInPrevLight / (int) duration;
                    double timeRemainingLampStatus = timeInPrevLight % duration == 0 ? 0 : duration - timeInPrevLight % duration;
                    boolean isGreenLight = timeRemainingLampStatus == 0 || lampStatus % 2 + 1 == 0;
                    double distanceInPartialLight = speedMeterPerSec * timeRemainingLampStatus;
                    double remainingLightDistance = toPoint - distanceInPartialLight;
                    Double reachLamp = canMakeItUnderMultipleLightChange(remainingLightDistance, traveledDistance, speedMeterPerSec, isGreenLight);
                    if (traveledDistance > remainingLightDistance || reachLamp != null) {

                    } else {
                        canMakeIt = false;
                    }
                }
                trafficLight++;
            }
            if (!canMakeIt) {
                speed--;
            }
            canPassAll = canMakeIt;
        }
        System.out.println(speed);
//        Assert.assertEquals(expected, speed);
    }

    private Double canMakeItUnderMultipleLightChange(double toPoint, double traveledDistance, double speed, boolean isGreenLight) {
        Double result = null;

        double fromPoint = 0.0;
        double maxIteration = toPoint / speed;
        int maxI = (int) maxIteration;
        int i = isGreenLight ? 2 : 1;
        while (i < maxI - 1 && result == null) {
            if ((fromPoint + traveledDistance * i) <= toPoint && (fromPoint + traveledDistance * (i + 1)) > toPoint) {
                result = fromPoint + traveledDistance * (i + 1);
            }
            i+= 2;
        }
        return result;
    }
}
