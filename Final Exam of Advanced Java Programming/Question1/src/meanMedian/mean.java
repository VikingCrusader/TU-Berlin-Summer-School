package meanMedian;

import java.util.Collections;
import java.util.List;

public class mean {
    // calculate the mean
    public static Double getMean(List<Double> list) {
        if (list == null || list.isEmpty()) return null;
        double sum = 0.0;
        for (Double num : list) {
            sum += num;
        }
        return sum / list.size();
    }
}
