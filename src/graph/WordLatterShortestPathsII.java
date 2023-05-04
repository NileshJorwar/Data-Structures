package src.graph;

import java.util.*;

//TimeLimit Exceeded
public class WordLatterShortestPathsII {
    //find sequences
    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> res = usingBfsToFindShortestPaths(beginWord, endWord, wordList);
        System.out.println(res);
    }

    private static List<List<String>> usingBfsToFindShortestPaths(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            wordSet.add(wordList.get(i));
        }
        Queue<ArrayList<String>> listQueue = new LinkedList<>();
        ArrayList<String> as = new ArrayList<>();
        as.add(beginWord);
        listQueue.add(as);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while (!listQueue.isEmpty()) {

            ArrayList<String> list = listQueue.poll();

            //remove all the words used in previous level
            if (list.size() > level) {
                level++;
                for (String st : usedOnLevel) {
                    wordSet.remove(st);
                }
            }
            //get the last word of list and traverse through it for cha a-z
            String word = list.get(list.size() - 1);
            if (word.equals(endWord)) {
                if (ans.size() == 0) {
                    ans.add(list);
                } else if (ans.get(0).size() == list.size()) {
                    ans.add(list);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    char replacedCharArr[] = word.toCharArray();
                    replacedCharArr[i] = ch;
                    String replacedWord = new String(replacedCharArr);
                    if (wordSet.contains(replacedWord)) {
                        list.add(replacedWord);
                        //?
                        ArrayList<String> temp = new ArrayList<>(list);
                        listQueue.add(temp);
                        //mark as visited on used level
                        usedOnLevel.add(replacedWord);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return ans;

    }
}

