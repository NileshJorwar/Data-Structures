package src.graph.shortestpaths.dijkstras.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithK {
    public static void main(String[] args) {
        int cities = 4;
        int flights[][] = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}};
        int src = 0;
        int dest = 3;
        int k = 1;
        int chapPrice = findCheapestFlightPractice(cities, flights, src, dest, k);
        System.out.println("Cheap Price: " + chapPrice);
    }

    private static int findCheapestFlightPractice(int cities, int[][] flights, int src, int dest, int k) {
        List<List<FlightInfo>> adjList = new ArrayList<>();
        createAdjListCheap(flights, cities, adjList);
        int priceArr[] = new int[cities];
        for (int i = 0; i < cities; i++) {
            priceArr[i] = (int) 1e9;
        }

        Queue<int[]> queue = new LinkedList<>();
        //stops, srcCity, price are set to 0 initially as same on same airport city
        queue.add(new int[]{0, src, 0});
        priceArr[0]=0;
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int noOfStops = current[0];
            int current_city = current[1];
            int current_price = current[2];
            if (current_city == dest && noOfStops <= k + 1) {
                res = Math.min(res, current_price);
            }
            if (noOfStops < k + 1) {
                for (FlightInfo flightInfo : adjList.get(current_city)) {
                    int newPrice = current_price + flightInfo.price;
                    if (newPrice < priceArr[flightInfo.city]) {
                        priceArr[flightInfo.city] = newPrice;
                        queue.add(new int[]{noOfStops + 1, flightInfo.city, newPrice});
                    }
                }
            }

        }
        return res;
    }

    private static void createAdjListCheap(int[][] flights, int cities, List<List<FlightInfo>> adjList) {
        for (int i = 0; i < cities; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adjList.get(flights[i][0]).add(new FlightInfo(flights[i][1], flights[i][2]));
        }
    }
}

class FlightInfo {

    int city, price;

    FlightInfo(int city, int price) {
        this.city = city;
        this.price = price;
    }
}
