package src.graph;

import java.util.ArrayList;

public class CreateAdjListFromMatrix {

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList= new ArrayList<>(isConnected.length+1);
        createAdjacencyList(isConnected, adjList);
        System.out.println(adjList);
        return 0;
    }

    public void createAdjacencyList(int [][] isConnected, ArrayList<ArrayList<Integer>> adjList){
        for(int i=0;i<isConnected.length+1;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){

                if(isConnected[i][j]!=0 && i!=j)
                    adjList.get(i+1).add(j+1);
            }

        }
    }
}


