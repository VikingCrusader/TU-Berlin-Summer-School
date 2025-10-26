package shipment_project;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Create item List
        ArrayList<Items> shipmentList = new ArrayList<>();
        shipmentList.add(new Items(0.6, 0.5, 0.5, 6.5, 3000));   // Laptop
        shipmentList.add(new Items(0.3, 0.3, 0.2, 0.2, 2000)); // Mouse
        shipmentList.add(new Items(1.0, 1.5, 0.5, 20, 1000));    // Desktop
        shipmentList.add(new Items(1.0, 0.2, 1.2, 16, 5000));    // Screen

        //Calculate the total Volume of Weight of all items
        double totalVolume = 0;
        double totalWeight = 0;
        for (Items item : shipmentList) {
            totalVolume += item.totalVolCal();
            totalWeight += item.totalWeight();
        }

        //Create container objects and calculate their volumes respectively
        Container small = new Container(2.59, 2.43, 6.06);
        Container big = new Container(2.59, 2.43, 12.01);
        double vSmall = small.calVol();
        double vBig = big.calVol();

        double minCost = Double.MAX_VALUE; //Store current minimum Cost
        int bestBig = 0, bestSmall = 0, bestHeavy = 0; //Store current best solution

        // Try all possible combinations of big container count from 0 up to max(possible), the rest are small
        // traverse all possibilities
        int maxBig = (int) Math.ceil(totalVolume / vBig);
        for (int bigCount = 0; bigCount <= maxBig; bigCount++) {
            // the volume that deducted the big containers, the rest have to contain by small boxes.
            double remainVolume = totalVolume - bigCount * vBig;
            // the weight ... (all volumes in big / totalvolume ) * totalWeight == volumes in big containers
            double remainWeight = totalWeight - (bigCount * vBig / totalVolume * totalWeight);
            // if remainVolume < 0, means all big boxes can contain all goods, no need small anymore
            if (remainVolume < 0) remainVolume = 0;
            // in this case, (big box is a specific value), the quantity of small boxes
            int smallCount = (int) Math.ceil(remainVolume / vSmall);
            // all items are assumed to be fluid, to calculate the density.
            double Density = totalWeight / totalVolume;
            // Weight of one small container, when it's full
            double fullWeight = vSmall * Density;
            // The weight of last container, which is not full
            double lastWeight = remainWeight - (smallCount - 1) * fullWeight;

            int heavy = 0; // the number of overweight containers
            if (fullWeight > 500) heavy += (smallCount - 1); //if full containers heavier than 500, then all of those considered heavy one.
            if (lastWeight > 500) heavy++; // if the last one is overweight or not

            double smallCost = heavy * 1200 + (smallCount - heavy) * 1000;
            double totalCost = bigCount * 1800 + smallCost;


            // if found a lower cost than before, replace them all
            if (totalCost < minCost) {
                minCost = totalCost;
                bestBig = bigCount;
                bestSmall = smallCount;
                bestHeavy = heavy;
            }
        }

        // Output result
        System.out.println("Optimal Plan:");
        System.out.println("Big containers used: "+bestBig);
        System.out.println("Small containers used: "+bestSmall +", among them "+bestHeavy +" containers are overweight");
        System.out.println("Total cost: "+minCost + " €");

    }
}