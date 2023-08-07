package src.graph.disjointsets;

import java.util.*;

public class SentenceSimilarityII {
    public static void main(String[] args) {
        String[] sentence1 = {
                "great", "acting", "skills"
        };
        String[] sentence2 = {
                "fine", "drama", "talent"
        };
        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(Arrays.asList("great", "good"));
        similarPairs.add(Arrays.asList("fine", "good"));
        similarPairs.add(Arrays.asList("drama", "acting"));
        similarPairs.add(Arrays.asList("skills", "talent"));
        boolean res = new SentenceSimilarityII().areSentencesSimilarTwo(sentence1, sentence2, similarPairs);
        System.out.println("Result: " + res);
    }

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1 = sentence1.length;
        int len2 = sentence2.length;
        if (len1 != len2) {
            return false;
        }
        DisjointSetsOfWords ds = new DisjointSetsOfWords();
        for (List<String> pairs : similarPairs) {
            // add similar words to DSU and union them
            ds.addWord(pairs.get(0));
            ds.addWord(pairs.get(1));
            ds.unionByRank(pairs.get(0), pairs.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (ds.isWordPresent(sentence1[i]) && ds.isWordPresent(sentence2[i]) &&
                    ds.findUltimateParent(sentence1[i]) == ds.findUltimateParent(sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;

    }
}

class DisjointSetsOfWords {
    Map<String, Integer> ranks = new HashMap<>();
    Map<String, String> parent = new HashMap<>();

    public void addWord(String str) {
        if (!parent.containsKey(str)) {
            parent.put(str, str);
            ranks.put(str, 0);
        }
    }

    public void unionByRank(String u, String v) {
        //find ultimate parent
        String u_ulp = findUltimateParent(u);
        String v_ulp = findUltimateParent(v);

        if (u_ulp == v_ulp)
            return;
        if (ranks.get(u_ulp) > ranks.get(v_ulp)) {
            parent.put(v_ulp, u_ulp);
        } else if (ranks.get(u_ulp) < ranks.get(v_ulp)) {
            parent.put(u_ulp, v_ulp);
        } else {
            parent.put(v_ulp, u_ulp);
            ranks.put(u_ulp, ranks.get(u_ulp) + 1);
        }
    }

    public boolean isWordPresent(String str) {
        if (parent.containsKey(str))
            return true;
        return false;
    }

    public String findUltimateParent(String node) {
        if (node == parent.get(node)) {
            return node;
        }
        String ultimateParent = findUltimateParent(parent.get(node));
        return ultimateParent;
    }
}