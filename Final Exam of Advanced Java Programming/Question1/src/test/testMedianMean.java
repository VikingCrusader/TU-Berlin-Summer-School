package test;

import meanMedian.mean;
import meanMedian.median;

import java.util.ArrayList;
import java.util.List;

public class testMedianMean {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<Double>();
        // add numbers
        list.add(3.0);
        list.add(0.6);
        list.add(8.0);
        list.add(9.0);
        list.add(99.9);
        list.add(8.0);
        list.add(90.0);
        list.add(88.0);
        list.add(0.5);
        list.add(0.0);
        list.add(7.0);
        list.add(20.0);
        list.add(-2.0);
        list.add(-11.0);
        list.add(22.0);
        list.add(77.0);
        list.add(88.9);
        list.add(6.7);
        list.add(88.0);
        list.add(9.22);
        list.add(-22.0);
        list.add(9.9);
        list.add(66.7);
        list.add(-2.0);
        list.add(0.08);
        list.add(7.9);
        // calculate the mean
        System.out.println("The mean of this List is: " + mean.getMean(list));
        // calculate the median
        System.out.println("The median of this List is: " + median.getMedian(list));
    }
}
