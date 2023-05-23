package src.graph.dijkstras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsKStops {
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
        int cheapPrice = findCheapestPrice(cities, flights, src, dest, k);
        System.out.println("Cheapest Flight: " + cheapPrice);
    }

    private static int findCheapestPrice(int cities, int[][] flights, int src, int dest, int k) {
        int res = Integer.MAX_VALUE;
        int price[] = new int[cities];
        for (int i = 0; i < cities; i++) {
            price[i] = (int) 1e9;
        }

        //Create a graph for adjacency list
        ArrayList<ArrayList<Flight>> adjList = new ArrayList<>();
        createAdjListForFlight(cities, adjList, flights);

        // setting price or distance array for start as 0
        price[src] = 0;

        //Setting Src to be start in Queue
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, src, 0});

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int current_stops = current[0];
            int current_city = current[1];
            int current_price = current[2];
            if (current_city == dest && current_stops <= k + 1) {
                res = Math.min(res, current_price);
            }
            if (current_stops < k + 1) {
                for (Flight flight : adjList.get(current_city)) {
                    int newPrice = current_price + flight.price;

                    if (newPrice < price[flight.city] ) {
                        price[flight.city] = newPrice;
                        queue.add(new int[]{current_stops + 1, flight.city, newPrice});
                    }

                }
            }

        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void createAdjListForFlight(int cities, ArrayList<ArrayList<Flight>> adjList, int[][] flights) {
        for (int i = 0; i < cities; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adjList.get(flights[i][0]).add(new Flight(flights[i][1], flights[i][2]));
        }

    }
}

class Flight {

    int city, price;

    Flight(int city, int price) {
        this.city = city;
        this.price = price;
    }
}
