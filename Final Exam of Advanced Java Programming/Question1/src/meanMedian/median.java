package meanMedian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class median {
    // calculate the median
    public static Double getMedian(List<Double> list) {
        if (list == null || list.isEmpty()) return null;

        List<Double> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        int size = sortedList.size();
        if (size % 2 != 0) { // if odd
            return sortedList.get(size / 2);
        } else { // if even
            return (sortedList.get(size / 2 - 1) + sortedList.get(size / 2)) / 2;
        }
    }
}
