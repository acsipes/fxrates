package demo.exams.twenty.cloudera.a2020.devicenamesystem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class DevciceNameSystem {

    public static List<String> deviceNamesSystem(List<String> devicenames) {
        for (int i = devicenames.size() -1; i >= 0; i--) {
            String deviceName = devicenames.get(i);
            List<String> subList = devicenames.subList(0, i);
            int frequency = Collections.frequency(subList, deviceName);
            if (frequency != 0) {
                deviceName = deviceName + frequency;
                devicenames.set(i, deviceName);                
            }
        }

        return devicenames;
    } 
}
