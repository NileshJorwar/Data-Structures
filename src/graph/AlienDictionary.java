package src.graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {
//                "wrt", "wrf", "er", "ett", "rftt"
                "z","x","a","zb","zx"
        };

        System.out.println("result"+alienOrder(words));
    }

    private static String alienOrder(String[] words) {
        //Use hashset to store distinct characters from each word
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {

                adjList.put(c - 'a', new ArrayList<>());
                indegree.put(c - 'a', 0);
            }
        }

        int count = 0;

        //Here, map is used to store the edges in adjList
        //adding degree at the same time when adding to adj list a---> b , add b s indegree as 1
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
            int minLen = Math.min(s1.length(), s2.length());
            for (int j = 0; j < minLen; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
//                    count++;
                    adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    //adding indegree
                    indegree.put(s2.charAt(j) - 'a', indegree.getOrDefault(s2.charAt(j) - 'a', 0) + 1);
                    break;
                }
            }
        }

        //Once in-degree are computed,
        Queue<Integer> queue = new LinkedList<>();

        for (int ind : indegree.keySet()) {
            if (indegree.get(ind) == 0) {
                queue.add(ind);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            char c = (char) (currentNode +  'a');
            stringBuilder.append(c);
            for (int neighbour: adjList.get(currentNode)) {
                indegree.put(neighbour, indegree.get(neighbour)-1);
                if(indegree.get(neighbour)==0){
                    queue.add(neighbour);
                }
            }

        }
        //result always has same count of chars as that of indegree array size
        if(stringBuilder.length() < indegree.size())
            return "";
        System.out.println(stringBuilder);
        return stringBuilder.toString();

    }
}
