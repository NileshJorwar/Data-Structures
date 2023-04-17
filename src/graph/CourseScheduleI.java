package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kahn's Algo -- BFS of TOpo sort using
// in-degree and queue where in-degree of numCourses calculated and with 0 in-degree node are started first

/**
 * Directed Acyclic Graph – can’t be formed for cyclic graph , can’t be formed for undirected graph
 * Formed for directed graph with no cycles
 * Linear ordering of vertices such that there is and edge between u & v where u appears before v in that ordering.
 * Start with vertices with in-degree 0 and add them to queue and add all vertices in-degree in array in keep subtracting as u visit
 * the vertices
 */
public class CourseScheduleI {
    public static void main(String[] args) {
        int prerequisites[][] = {
                {1, 0}, {0, 1}
        };
        // course == nodes
        int numCourses = 6;

        boolean res = courseSchedule(numCourses, prerequisites);
        System.out.println(res);

    }

    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        createAdjList(adjList, numCourses, prerequisites);
        // In-degree creation
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : adjList.get(i)) {
                indegree[neighbour]++;
            }
        }

        System.out.println(indegree);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        //BFS
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            ans.add(currentNode);
            for (int neighbour : adjList.get(currentNode)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        if(ans.size() == numCourses){
            return true;
        }
        return false;
    }

    public static void createAdjList(List<List<Integer>> adjList, int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

    }
}
